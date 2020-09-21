package com.baidu.ubc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.util.io.Closeables;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.config.AppConfig;
import com.sina.weibo.sdk.statistic.LogBuilder;
import com.xiaomi.mipush.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class x extends SQLiteOpenHelper {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static x npQ = null;
    private static ReentrantLock npR = new ReentrantLock();
    private Context mContext;
    private long mTotalLength;
    private b noS;
    private ReentrantReadWriteLock npP;

    public static x gf(Context context) {
        if (npQ == null) {
            npR.lock();
            if (npQ == null) {
                npQ = new x(context);
            }
            npR.unlock();
        }
        return npQ;
    }

    private x(Context context) {
        super(context, "bdbehavior.db", (SQLiteDatabase.CursorFactory) null, 7);
        this.npP = new ReentrantReadWriteLock(true);
        this.noS = new b(context);
        this.mContext = context;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public void close() {
        Log.w("UBCDatabaseHelper", "Database is being closed");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        if (DEBUG) {
            Log.i("UBCDatabaseHelper", "Creating database bdbehavior.db version 7");
        }
        try {
            sQLiteDatabase.execSQL("CREATE TABLE event (_id INTEGER PRIMARY KEY AUTOINCREMENT,flowhandle INTEGER,eventid TEXT,begintime LONG,content TEXT,reserve1 TEXT,reserve2 TEXT,extend TEXT,reallog TEXT);");
            sQLiteDatabase.execSQL("CREATE TABLE flow (_id INTEGER PRIMARY KEY AUTOINCREMENT,flowid TEXT,flowhandle INTEGER,state TEXT,begintime LONG,endtime LONG,content TEXT,option INTEGER,reserve1 TEXT,reserve2 TEXT,slot TEXT,extend TEXT );");
            sQLiteDatabase.execSQL("CREATE TABLE config (eventid TEXT PRIMARY KEY,type TEXT,recordrule TEXT,uploadrule TEXT,cycle INTEGER,switch TEXT,sample INTEGER,reserve1 TEXT,reserve2 TEXT,extend TEXT,reallog TEXT);");
            sQLiteDatabase.execSQL("CREATE TABLE file (filename TEXT PRIMARY KEY,state TEXT,reserve1 TEXT,reserve2 TEXT);");
            ag.dQk().putString("ubc_cloudconfig_version", "0");
        } catch (Exception e) {
            Log.w("UBCDatabaseHelper", "Error while creating db: " + e.toString());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.enableWriteAheadLogging();
        super.onConfigure(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            sQLiteDatabase.beginTransaction();
            while (i < i2) {
                switch (i) {
                    case 1:
                        I(sQLiteDatabase);
                        break;
                    case 2:
                        L(sQLiteDatabase);
                        break;
                    case 3:
                        J(sQLiteDatabase);
                        break;
                    case 4:
                        K(sQLiteDatabase);
                        break;
                    case 6:
                        al(sQLiteDatabase);
                        break;
                }
                i++;
            }
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Throwable th) {
            try {
                if (DEBUG) {
                    Log.e("UBCDatabaseHelper", th.toString() + "\n" + Log.getStackTraceString(th));
                }
            } finally {
                sQLiteDatabase.endTransaction();
            }
        }
    }

    private void I(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE file (filename TEXT PRIMARY KEY,state TEXT,reserve1 TEXT,reserve2 TEXT);");
        } catch (SQLException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void J(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE event ADD COLUMN extend TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE flow ADD COLUMN extend TEXT");
        } catch (SQLException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void K(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE config ADD COLUMN extend TEXT");
        } catch (SQLException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void al(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE config ADD COLUMN reallog DEFAULT '0'");
            sQLiteDatabase.execSQL("ALTER TABLE event ADD COLUMN reallog DEFAULT '0'");
        } catch (SQLException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void L(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE config ADD COLUMN sample TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE flow ADD COLUMN slot TEXT");
        } catch (SQLException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(n nVar) {
        if (nVar == null || TextUtils.isEmpty(nVar.getId())) {
            if (DEBUG) {
                Log.d("UBCDatabaseHelper", "saveEvent#event id must not be null");
                return;
            }
            return;
        }
        this.npP.writeLock().lock();
        try {
            ContentValues f = f(nVar);
            String aWC = nVar.aWC();
            String id = nVar.getId();
            int aWD = nVar.aWD();
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                if (a(aWC, id, aWD, writableDatabase)) {
                    long insert = writableDatabase.insert(NotificationCompat.CATEGORY_EVENT, null, f);
                    if (DEBUG) {
                        Log.d("UBCDatabaseHelper", "saveEvent#performTransaction: rowId=" + insert);
                    }
                }
                writableDatabase.setTransactionSuccessful();
            } finally {
                writableDatabase.endTransaction();
            }
        } catch (SQLException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            this.noS.B(e);
        } finally {
            this.npP.writeLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aD(List<n> list) {
        if (list == null || list.size() == 0) {
            if (DEBUG) {
                Log.d("UBCDatabaseHelper", "saveEvents#data must not be null");
                return;
            }
            return;
        }
        for (n nVar : list) {
            a(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dQe() {
        int i;
        this.npP.writeLock().lock();
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                try {
                    i = writableDatabase.delete(NotificationCompat.CATEGORY_EVENT, "reallog =?", new String[]{"1"});
                    try {
                        writableDatabase.setTransactionSuccessful();
                    } catch (SQLException e) {
                        e = e;
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                        this.noS.B(e);
                        writableDatabase.endTransaction();
                        return i > 0;
                    }
                } finally {
                    writableDatabase.endTransaction();
                }
            } catch (SQLException e2) {
                e = e2;
                i = 0;
            }
            return i > 0;
        } catch (SQLException e3) {
            if (DEBUG) {
                e3.printStackTrace();
            }
            this.noS.B(e3);
            return false;
        } finally {
            this.npP.writeLock().unlock();
        }
    }

    private ContentValues f(n nVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("flowhandle", Integer.valueOf(nVar.aWD()));
        contentValues.put("eventid", nVar.getId());
        contentValues.put("begintime", Long.valueOf(nVar.getTime()));
        if (!TextUtils.isEmpty(nVar.getContent())) {
            contentValues.put("content", nVar.getContent());
        } else if (nVar.aWF() != null && !TextUtils.isEmpty(nVar.aWF().toString())) {
            contentValues.put("content", nVar.aWF().toString());
        }
        if (!TextUtils.isEmpty(nVar.aWE())) {
            contentValues.put("reserve1", nVar.aWE());
        }
        if (!TextUtils.isEmpty(nVar.getCategory())) {
            contentValues.put("reserve2", nVar.getCategory());
        }
        if (nVar.aWA()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ctr", "1");
                contentValues.put("extend", jSONObject.toString());
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        if (!TextUtils.isEmpty(nVar.dPY())) {
            contentValues.put("reallog", nVar.dPY());
        } else {
            contentValues.put("reallog", "0");
        }
        return contentValues;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [686=6] */
    /* JADX WARN: Can't wrap try/catch for region: R(15:1|2|3|4|(2:5|6)|(3:27|28|(11:30|(17:31|(4:33|(1:35)|36|(1:38))|39|(1:41)|42|(1:44)|45|(1:47)|48|(3:50|(1:52)|53)|54|(1:56)(1:70)|57|(1:61)|62|63|(1:69)(1:65))|67|68|9|10|11|12|13|14|15))|8|9|10|11|12|13|14|15|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0218, code lost:
        if (com.baidu.ubc.x.DEBUG != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x021a, code lost:
        r3.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x021d, code lost:
        r25.noS.B(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x023d, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x023e, code lost:
        r2 = r3;
        r3 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0244, code lost:
        r3 = e;
     */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0247: MOVE  (r6 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:91:0x0247 */
    /* JADX WARN: Removed duplicated region for block: B:80:0x021a A[Catch: all -> 0x0230, TryCatch #0 {all -> 0x0230, blocks: (B:3:0x0014, B:45:0x01aa, B:47:0x01af, B:78:0x0216, B:80:0x021a, B:81:0x021d, B:72:0x0209, B:65:0x01f2, B:74:0x020f, B:75:0x0212, B:58:0x01d9), top: B:97:0x0014 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int a(String str, ah ahVar) {
        int i;
        RuntimeException runtimeException;
        Cursor cursor;
        long j;
        long j2;
        UnsupportedEncodingException unsupportedEncodingException;
        Cursor cursor2;
        Cursor cursor3;
        Cursor rawQuery;
        String string;
        int i2;
        long j3;
        this.npP.readLock().lock();
        Cursor cursor4 = null;
        long j4 = Long.MAX_VALUE;
        long j5 = 0;
        try {
            try {
                try {
                    try {
                        try {
                            try {
                                rawQuery = getReadableDatabase().rawQuery(str, null);
                            } catch (Throwable th) {
                                th = th;
                                cursor4 = cursor3;
                                Closeables.closeSafely(cursor4);
                                throw th;
                            }
                        } catch (JSONException e) {
                            if (DEBUG) {
                                Log.d("UBCDatabaseHelper", "json exception:");
                            }
                            Closeables.closeSafely((Cursor) null);
                            j = j4;
                            j2 = j5;
                            i = 0;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        Closeables.closeSafely(cursor4);
                        throw th;
                    }
                } catch (UnsupportedEncodingException e2) {
                    unsupportedEncodingException = e2;
                    cursor2 = null;
                    j = Long.MAX_VALUE;
                    j2 = 0;
                } catch (RuntimeException e3) {
                    runtimeException = e3;
                    cursor = null;
                    j = Long.MAX_VALUE;
                    j2 = 0;
                }
            } finally {
                this.npP.readLock().unlock();
            }
        } catch (SQLException e4) {
            SQLException e5 = e4;
            i = 0;
        }
        if (rawQuery != null) {
            try {
            } catch (UnsupportedEncodingException e6) {
                long j6 = j5;
                unsupportedEncodingException = e6;
                cursor2 = rawQuery;
                j = j4;
                j2 = j6;
                if (DEBUG) {
                    unsupportedEncodingException.printStackTrace();
                }
                Closeables.closeSafely(cursor2);
                i = 0;
                ahVar.q(j, j2);
                return i;
            } catch (RuntimeException e7) {
                long j7 = j5;
                runtimeException = e7;
                cursor = rawQuery;
                j = j4;
                j2 = j7;
                if (DEBUG) {
                    runtimeException.printStackTrace();
                }
                Closeables.closeSafely(cursor);
                i = 0;
                ahVar.q(j, j2);
                return i;
            }
            if (rawQuery.getCount() > 0) {
                rawQuery.moveToFirst();
                int columnIndex = rawQuery.getColumnIndex("eventid");
                int columnIndex2 = rawQuery.getColumnIndex("begintime");
                int columnIndex3 = rawQuery.getColumnIndex("content");
                int columnIndex4 = rawQuery.getColumnIndex("reserve1");
                int columnIndex5 = rawQuery.getColumnIndex("reserve2");
                int columnIndex6 = rawQuery.getColumnIndex("extend");
                do {
                    JSONObject jSONObject = new JSONObject();
                    String string2 = rawQuery.getString(columnIndex);
                    jSONObject.put("id", string2);
                    long j8 = rawQuery.getLong(columnIndex2);
                    jSONObject.put("timestamp", Long.toString(j8));
                    if (j8 > 0) {
                        if (j8 < j4) {
                            j4 = j8;
                        }
                        if (j8 > j5) {
                            j5 = j8;
                        }
                    }
                    jSONObject.put("type", "0");
                    String string3 = rawQuery.getString(columnIndex3);
                    if (!TextUtils.isEmpty(string3)) {
                        jSONObject.put("content", string3);
                        this.mTotalLength += string3.getBytes("UTF-8").length;
                    }
                    String string4 = rawQuery.getString(columnIndex4);
                    if (!TextUtils.isEmpty(string4)) {
                        jSONObject.put("abtest", string4);
                        ahVar.xL("1");
                        this.mTotalLength += string4.getBytes("UTF-8").length;
                    }
                    if (!TextUtils.isEmpty(rawQuery.getString(columnIndex5))) {
                        jSONObject.put("c", rawQuery.getString(columnIndex5));
                    }
                    if (!TextUtils.isEmpty(rawQuery.getString(columnIndex6))) {
                        if (new JSONObject(rawQuery.getString(columnIndex6)).has("ctr")) {
                            jSONObject.put(MapBundleKey.MapObjKey.OBJ_OFFSET, "1");
                        }
                        this.mTotalLength += string.getBytes("UTF-8").length;
                    }
                    g dPU = g.dPU();
                    jSONObject.put("idtype", dPU.xA(string2));
                    jSONObject.put("isreal", dPU.Ub(string2) ? "1" : "0");
                    String Uc = dPU.Uc(string2);
                    if (!TextUtils.isEmpty(Uc) && !TextUtils.equals(Uc, "0")) {
                        jSONObject.put("gflow", Uc);
                    }
                    ahVar.cT(jSONObject);
                    ahVar.xK(rawQuery.getString(columnIndex));
                    if (this.mTotalLength >= 10485760) {
                        break;
                    }
                } while (rawQuery.moveToNext());
                i2 = 1;
                j3 = j4;
                j2 = j5;
                Closeables.closeSafely(rawQuery);
                j = j3;
                i = i2;
                ahVar.q(j, j2);
                return i;
            }
        }
        i2 = 0;
        j3 = Long.MAX_VALUE;
        j2 = 0;
        Closeables.closeSafely(rawQuery);
        j = j3;
        i = i2;
        ahVar.q(j, j2);
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(p pVar) {
        if (pVar == null || TextUtils.isEmpty(pVar.getId())) {
            if (DEBUG) {
                Log.d("UBCDatabaseHelper", "saveFlow#event id must not be null");
                return;
            }
            return;
        }
        this.npP.writeLock().lock();
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("flowid", pVar.getId());
                contentValues.put("flowhandle", Integer.valueOf(pVar.aWD()));
                contentValues.put("state", pVar.aWL());
                contentValues.put("begintime", Long.valueOf(pVar.aWK()));
                if (pVar.aWF() != null) {
                    contentValues.put("content", pVar.aWF().toString());
                } else {
                    contentValues.put("content", pVar.getContent());
                }
                contentValues.put("option", Integer.valueOf(pVar.getOption()));
                contentValues.put("reserve1", pVar.aWE());
                if (!TextUtils.isEmpty(pVar.getCategory())) {
                    contentValues.put("reserve2", pVar.getCategory());
                }
                if (pVar.aWA()) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("ctr", "1");
                        contentValues.put("extend", jSONObject.toString());
                    } catch (JSONException e) {
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
                long insert = writableDatabase.insert("flow", null, contentValues);
                if (DEBUG) {
                    Log.d("UBCDatabaseHelper", "saveFlow#performTransaction: rowId=" + insert);
                }
                writableDatabase.setTransactionSuccessful();
            } finally {
                writableDatabase.endTransaction();
            }
        } catch (SQLException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
            this.noS.B(e2);
        } finally {
            this.npP.writeLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        if (i < 0 || TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.d("UBCDatabaseHelper", "endFlow#flowHandle invalid");
                return;
            }
            return;
        }
        this.npP.writeLock().lock();
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("state", "2");
                contentValues.put(LogBuilder.KEY_END_TIME, Long.valueOf(j));
                if (jSONArray != null && jSONArray.length() > 0) {
                    contentValues.put("slot", jSONArray.toString());
                }
                StringBuilder sb = new StringBuilder();
                sb.append("flowid").append("=\"").append(str).append("\"").append(" AND ").append("flowhandle").append(" = ").append(i);
                int update = writableDatabase.update("flow", contentValues, sb.toString(), null);
                if (DEBUG && update != 1) {
                    Log.d("UBCDatabaseHelper", "endFlow#performTransaction: endFlow count:" + update);
                }
                writableDatabase.setTransactionSuccessful();
            } finally {
                writableDatabase.endTransaction();
            }
        } catch (SQLException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            this.noS.B(e);
        } finally {
            this.npP.writeLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(String str, int i) {
        if (i < 0 || TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.d("UBCDatabaseHelper", "cancelFlow#flowHandle invalid");
                return;
            }
            return;
        }
        this.npP.writeLock().lock();
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("flowid").append("=\"").append(str).append("\"").append(" AND ").append("flowhandle").append(" = ").append(i);
                int delete = writableDatabase.delete("flow", sb.toString(), null);
                if (DEBUG) {
                    Log.d("UBCDatabaseHelper", "cancelFlow#performTransaction: cancelFlow flow count:" + delete);
                }
                int delete2 = writableDatabase.delete(NotificationCompat.CATEGORY_EVENT, "flowhandle = " + i, null);
                if (DEBUG) {
                    Log.d("UBCDatabaseHelper", "cancelFlow#performTransaction: cancelFlow event count:" + delete2);
                }
                writableDatabase.setTransactionSuccessful();
            } finally {
                writableDatabase.endTransaction();
            }
        } catch (SQLException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            this.noS.B(e);
        } finally {
            this.npP.writeLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(String str, int i, String str2) {
        if (i < 0 || TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.d("UBCDatabaseHelper", "updateFlowValue#flowHandle invalid");
                return;
            }
            return;
        }
        this.npP.writeLock().lock();
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("content", str2);
                StringBuilder sb = new StringBuilder();
                sb.append("flowid").append("=\"").append(str).append("\"").append(" AND ").append("flowhandle").append(" = ").append(i);
                int update = writableDatabase.update("flow", contentValues, sb.toString(), null);
                if (DEBUG && update != 1) {
                    Log.d("UBCDatabaseHelper", "updateFlowValue#performTransaction: updateFlowValue count:" + update);
                }
                writableDatabase.setTransactionSuccessful();
            } finally {
                writableDatabase.endTransaction();
            }
        } catch (SQLException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            this.noS.B(e);
        } finally {
            this.npP.writeLock().unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [998=4] */
    private boolean a(String str, String str2, int i, SQLiteDatabase sQLiteDatabase) {
        SQLException e;
        Cursor cursor = null;
        boolean z = false;
        this.npP.writeLock().lock();
        try {
            try {
                if (str.equals(str2)) {
                    z = true;
                } else {
                    try {
                        StringBuilder sb = new StringBuilder();
                        sb.append("SELECT ").append("state").append(" FROM ").append("flow").append(" WHERE ").append("flowhandle").append(" = ").append(i);
                        try {
                            cursor = sQLiteDatabase.rawQuery(sb.toString(), null);
                            if (cursor != null && cursor.getCount() > 0) {
                                cursor.moveToFirst();
                                String string = cursor.getString(0);
                                if (!TextUtils.isEmpty(string)) {
                                    if ("1".equals(string)) {
                                        z = true;
                                    }
                                }
                            }
                        } catch (RuntimeException e2) {
                            if (DEBUG) {
                                e2.printStackTrace();
                            }
                        } catch (SQLException e3) {
                            if (DEBUG) {
                                e3.printStackTrace();
                            }
                            this.noS.B(e3);
                        } finally {
                            Closeables.closeSafely(cursor);
                        }
                    } catch (SQLException e4) {
                        e = e4;
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                        this.noS.B(e);
                        return z;
                    }
                }
            } catch (SQLException e5) {
                z = true;
                e = e5;
            }
            return z;
        } finally {
            this.npP.writeLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x013a A[Catch: all -> 0x01b4, TryCatch #1 {all -> 0x01b4, blocks: (B:4:0x0011, B:6:0x003f, B:7:0x0059, B:9:0x0079, B:10:0x0093, B:18:0x0131, B:20:0x013a, B:22:0x013e, B:23:0x015c, B:24:0x0193, B:11:0x0105, B:13:0x0110, B:15:0x0116, B:16:0x0119), top: B:43:0x0011 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void aVW() {
        this.npP.writeLock().lock();
        try {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    long currentTimeMillis = System.currentTimeMillis() - g.dPU().aWp();
                    int delete = writableDatabase.delete("flow", "endtime < " + currentTimeMillis, null);
                    if (DEBUG) {
                        Log.d("UBCDatabaseHelper", "clearInvalidData: delete flow count:" + delete);
                    }
                    int delete2 = writableDatabase.delete(NotificationCompat.CATEGORY_EVENT, "begintime < " + currentTimeMillis, null);
                    if (DEBUG) {
                        Log.d("UBCDatabaseHelper", "clearInvalidData: delete event count:" + delete2);
                    }
                    StringBuilder sb = new StringBuilder(256);
                    sb.append("SELECT ").append("flowhandle").append(" FROM ").append("flow").append(" WHERE ").append("begintime").append(" < ").append(System.currentTimeMillis() - 86400000).append(" AND ").append(LogBuilder.KEY_END_TIME).append(" is NULL ").append(" AND ").append("option").append(" = 0");
                    ArrayList arrayList = new ArrayList();
                    Cursor rawQuery = writableDatabase.rawQuery(sb.toString(), null);
                    if (rawQuery != null && rawQuery.getCount() > 0) {
                        rawQuery.moveToFirst();
                        do {
                            arrayList.add(Integer.valueOf(rawQuery.getInt(rawQuery.getColumnIndex("flowhandle"))));
                        } while (rawQuery.moveToNext());
                        Closeables.closeSafely(rawQuery);
                        if (arrayList.size() > 0) {
                        }
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                        xn("flow");
                        xn(NotificationCompat.CATEGORY_EVENT);
                    }
                    Closeables.closeSafely(rawQuery);
                    if (arrayList.size() > 0) {
                        if (DEBUG) {
                            Log.d("UBCDatabaseHelper", "clearInvalidData: delete flow count2:" + arrayList.size());
                        }
                        String w = w(arrayList);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("flowhandle").append(" in (").append(w).append(")");
                        writableDatabase.delete("flow", sb2.toString(), null);
                        writableDatabase.delete(NotificationCompat.CATEGORY_EVENT, sb2.toString(), null);
                    }
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                    xn("flow");
                    xn(NotificationCompat.CATEGORY_EVENT);
                } catch (Throwable th) {
                    writableDatabase.endTransaction();
                    throw th;
                }
            } catch (SQLException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                this.noS.B(e);
            }
        } finally {
            this.npP.writeLock().unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x008e A[Catch: all -> 0x00ca, TryCatch #3 {all -> 0x00ca, blocks: (B:4:0x0012, B:13:0x006e, B:14:0x0071, B:16:0x008e, B:17:0x00a8, B:25:0x00c0, B:5:0x003d, B:7:0x0048, B:9:0x004e, B:11:0x0060, B:22:0x00b9, B:24:0x00bd), top: B:45:0x0012 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void xn(String str) {
        int i;
        Cursor cursor = null;
        this.npP.writeLock().lock();
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("SELECT COUNT(*), MIN(").append(IMConstants.MSG_ROW_ID).append("), MAX(").append(IMConstants.MSG_ROW_ID).append(") FROM ").append(str);
                try {
                    cursor = writableDatabase.rawQuery(sb.toString(), null);
                } catch (RuntimeException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                    Closeables.closeSafely(cursor);
                    i = 0;
                }
                if (cursor != null && cursor.getCount() > 0) {
                    cursor.moveToFirst();
                    if (cursor.getInt(0) > g.dPU().aWq()) {
                        i = (cursor.getInt(1) + cursor.getInt(2)) / 2;
                        Closeables.closeSafely(cursor);
                        int delete = writableDatabase.delete(str, "_id < " + i, null);
                        if (DEBUG) {
                            Log.d("UBCDatabaseHelper", "ensureDataBaseLimit#performTransaction: delete count:" + delete);
                        }
                        writableDatabase.setTransactionSuccessful();
                    }
                }
                i = 0;
                Closeables.closeSafely(cursor);
                int delete2 = writableDatabase.delete(str, "_id < " + i, null);
                if (DEBUG) {
                }
                writableDatabase.setTransactionSuccessful();
            } finally {
                writableDatabase.endTransaction();
            }
        } catch (SQLException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
            this.noS.B(e2);
        } finally {
            this.npP.writeLock().unlock();
        }
    }

    public void a(f fVar) {
        Cursor cursor = null;
        this.npP.readLock().lock();
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM ").append("config");
            try {
                cursor = readableDatabase.rawQuery(sb.toString(), null);
                if (fVar == null) {
                    fVar = new f();
                }
            } catch (RuntimeException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            } finally {
                Closeables.closeSafely(cursor);
            }
            if (cursor != null && cursor.getCount() > 0) {
                cursor.moveToFirst();
                do {
                    String string = cursor.getString(cursor.getColumnIndex("eventid"));
                    String string2 = cursor.getString(cursor.getColumnIndex("switch"));
                    int i = cursor.getInt(cursor.getColumnIndex("sample"));
                    String string3 = cursor.getString(cursor.getColumnIndex("reserve1"));
                    String string4 = cursor.getString(cursor.getColumnIndex("reserve2"));
                    int i2 = cursor.getInt(cursor.getColumnIndex("cycle"));
                    int i3 = cursor.getInt(cursor.getColumnIndex("uploadrule"));
                    int i4 = cursor.getInt(cursor.getColumnIndex("recordrule"));
                    String string5 = cursor.getString(cursor.getColumnIndex("extend"));
                    String string6 = cursor.getString(cursor.getColumnIndex("reallog"));
                    if (TextUtils.equals(string2, "0")) {
                        fVar.npn.add(string);
                    } else if (TextUtils.equals(string2, "1")) {
                        fVar.npq.add(string);
                    }
                    if (i2 == 0) {
                        fVar.npo.add(string);
                    }
                    if (TextUtils.equals(string3, "1")) {
                        fVar.npp.add(string);
                    }
                    if (i > 0) {
                        fVar.nps.put(string, String.valueOf(i));
                    }
                    if (!TextUtils.isEmpty(string4)) {
                        fVar.npt.put(string, string4);
                    }
                    if (i3 != 0 && i4 != 0) {
                        fVar.npu.put(string, new m(string, i4, i3));
                    }
                    if (!TextUtils.isEmpty(string5)) {
                        try {
                            JSONObject jSONObject = new JSONObject(string5);
                            if (jSONObject.has("idtype")) {
                                fVar.npv.add(string);
                            }
                            if (jSONObject.has("ch") && TextUtils.equals(jSONObject.getString("ch"), "1")) {
                                fVar.npr.add(string);
                            }
                            if (jSONObject.has("gflow")) {
                                String string7 = jSONObject.getString("gflow");
                                if (!TextUtils.equals(string7, "0")) {
                                    fVar.npx.put(string, string7);
                                }
                            }
                            if (jSONObject.has("uploadType")) {
                                String string8 = jSONObject.getString("uploadType");
                                if (!TextUtils.isEmpty(string8)) {
                                    fVar.npy.put(string, string8);
                                }
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (TextUtils.equals(string6, "1")) {
                        fVar.npw.add(string);
                    }
                } while (cursor.moveToNext());
            }
        } catch (SQLException e3) {
            if (DEBUG) {
                e3.printStackTrace();
            }
            this.noS.B(e3);
        } finally {
            this.npP.readLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00cf A[Catch: RuntimeException -> 0x00fe, all -> 0x0121, Merged into TryCatch #0 {all -> 0x0121, RuntimeException -> 0x00fe, blocks: (B:4:0x0093, B:6:0x009e, B:8:0x00a4, B:9:0x00bc, B:14:0x00cf, B:16:0x00d7, B:17:0x00df, B:18:0x00e7, B:26:0x00ff, B:28:0x0103), top: B:44:0x0093 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(SparseArray<ArrayList> sparseArray) {
        int i;
        Cursor cursor = null;
        this.npP.readLock().lock();
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT ").append("eventid").append(" , ").append("type").append(" , ").append("cycle").append(" FROM ").append("config").append(" WHERE ").append("switch").append("=\"").append("1").append("\"").append(" AND (").append("reallog").append(" = \"0\" OR ").append("reallog").append(" = \"\")");
            try {
                cursor = readableDatabase.rawQuery(sb.toString(), null);
            } catch (RuntimeException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            } finally {
                Closeables.closeSafely(cursor);
            }
            if (cursor != null && cursor.getCount() > 0) {
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex("eventid");
                int columnIndex2 = cursor.getColumnIndex("type");
                int columnIndex3 = cursor.getColumnIndex("cycle");
                do {
                    String string = cursor.getString(columnIndex);
                    String string2 = cursor.getString(columnIndex2);
                    int i2 = cursor.getInt(columnIndex3);
                    if (i2 != 0) {
                        if (i2 < 6) {
                            i = 6;
                        } else if (i2 > 720) {
                            i = 720;
                        }
                        if (string != null) {
                            ArrayList arrayList = sparseArray.get(i);
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                                sparseArray.put(i, arrayList);
                            }
                            arrayList.add(new j(string, string2));
                        }
                    }
                    i = i2;
                    if (string != null) {
                    }
                } while (cursor.moveToNext());
            }
        } catch (SQLException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
            this.noS.B(e2);
        } finally {
            this.npP.readLock().unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1412=4, 1404=5] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public k Uj(String str) {
        Cursor cursor;
        Cursor cursor2;
        this.npP.readLock().lock();
        try {
            try {
                cursor = getReadableDatabase().rawQuery(String.format("SELECT * FROM %s where eventid = \"%s\"", "config", str), null);
                if (cursor != null) {
                    try {
                        if (cursor.getCount() > 0) {
                            cursor.moveToFirst();
                            String string = cursor.getString(cursor.getColumnIndex("eventid"));
                            String string2 = cursor.getString(cursor.getColumnIndex("switch"));
                            String string3 = cursor.getString(cursor.getColumnIndex("cycle"));
                            k kVar = new k(string, string2, TextUtils.equals(string3, "0") ? "0" : "1", Integer.parseInt(string3), cursor.getString(cursor.getColumnIndex("type")), cursor.getString(cursor.getColumnIndex("reserve1")));
                            String string4 = cursor.getString(cursor.getColumnIndex("extend"));
                            if (!TextUtils.isEmpty(string4)) {
                                try {
                                    JSONObject jSONObject = new JSONObject(string4);
                                    String optString = jSONObject.optString("dfc");
                                    if (!TextUtils.isEmpty(optString)) {
                                        kVar.Uf(optString);
                                    }
                                    String optString2 = jSONObject.optString("version");
                                    if (!TextUtils.isEmpty(optString2)) {
                                        kVar.setVersion(optString2);
                                    }
                                    String optString3 = jSONObject.optString("uploadType");
                                    if (!TextUtils.isEmpty(optString3)) {
                                        kVar.Ui(optString3);
                                    }
                                } catch (JSONException e) {
                                    if (DEBUG) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                            String string5 = cursor.getString(cursor.getColumnIndex("reallog"));
                            if (!TextUtils.isEmpty(string5)) {
                                kVar.Ug(string5);
                            }
                            Closeables.closeSafely(cursor);
                            return kVar;
                        }
                    } catch (RuntimeException e2) {
                        e = e2;
                        cursor2 = cursor;
                        try {
                            if (DEBUG) {
                                e.printStackTrace();
                            }
                            Closeables.closeSafely(cursor2);
                            return null;
                        } catch (Throwable th) {
                            th = th;
                            cursor = cursor2;
                            Closeables.closeSafely(cursor);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        Closeables.closeSafely(cursor);
                        throw th;
                    }
                }
                Closeables.closeSafely(cursor);
            } catch (RuntimeException e3) {
                e = e3;
                cursor2 = null;
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
            }
        } catch (SQLException e4) {
            if (DEBUG) {
                e4.printStackTrace();
            }
            this.noS.B(e4);
        } finally {
            this.npP.readLock().unlock();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Uk(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        this.npP.writeLock().lock();
        try {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    int delete = writableDatabase.delete("config", "eventid =? ", new String[]{str});
                    writableDatabase.setTransactionSuccessful();
                    boolean z = delete > 0;
                    this.npP.writeLock().unlock();
                    return z;
                } finally {
                    writableDatabase.endTransaction();
                }
            } catch (Throwable th) {
                this.npP.writeLock().unlock();
                throw th;
            }
        } catch (SQLException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            this.noS.B(e);
            this.npP.writeLock().unlock();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(ArrayList<j> arrayList, ah ahVar) {
        int i;
        this.mTotalLength = 0L;
        String d = d(arrayList, true);
        if (TextUtils.isEmpty(d)) {
            i = 0;
        } else {
            StringBuilder sb = new StringBuilder(256);
            sb.append("SELECT * ").append(" FROM ").append("flow").append(" WHERE ").append("flowid").append(" in (").append(d).append(")");
            i = b(sb.toString(), ahVar);
        }
        String d2 = d(arrayList, false);
        if (!TextUtils.isEmpty(d2)) {
            StringBuilder sb2 = new StringBuilder(256);
            sb2.append("SELECT *  FROM ").append(NotificationCompat.CATEGORY_EVENT).append(" WHERE ").append("eventid").append(" in (").append(d2).append(")").append(" AND ").append("flowhandle").append(" = ").append(-1).append(" AND ").append("reallog").append(" = \"0\"");
            return i | a(sb2.toString(), ahVar);
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(ah ahVar) {
        this.mTotalLength = 0L;
        StringBuilder sb = new StringBuilder(256);
        sb.append(" SELECT * FROM ").append("flow");
        int b = b(sb.toString(), ahVar);
        if (this.mTotalLength >= 10485760) {
            return 1;
        }
        StringBuilder sb2 = new StringBuilder(256);
        sb2.append("SELECT * FROM ").append(NotificationCompat.CATEGORY_EVENT).append(" WHERE ").append("flowhandle").append(" = ").append(-1).append(" AND ").append("reallog").append(" = \"0\"");
        return b | a(sb2.toString(), ahVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d(ah ahVar) {
        StringBuilder sb = new StringBuilder(256);
        sb.append("SELECT * FROM ").append(NotificationCompat.CATEGORY_EVENT).append(" WHERE ").append("flowhandle").append(" = ").append(-1).append(" AND ").append("reallog").append(" = \"1\"");
        return a(sb.toString(), ahVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1676=5] */
    /* JADX WARN: Can't wrap try/catch for region: R(14:1|(4:2|3|4|(2:5|6))|(3:30|31|(12:33|(5:34|(18:67|(1:114)(2:71|72)|73|74|(1:108)(2:78|79)|80|(1:82)|83|(1:85)|86|(1:88)|89|(1:93)|94|(4:96|97|98|(1:100))|104|105|(1:107))(1:40)|41|42|(1:44)(1:45))|46|9|10|11|12|13|(1:15)|16|17|18))|8|9|10|11|12|13|(0)|16|17|18|(1:(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(17:1|2|3|4|(2:5|6)|(3:30|31|(12:33|(5:34|(18:67|(1:114)(2:71|72)|73|74|(1:108)(2:78|79)|80|(1:82)|83|(1:85)|86|(1:88)|89|(1:93)|94|(4:96|97|98|(1:100))|104|105|(1:107))(1:40)|41|42|(1:44)(1:45))|46|9|10|11|12|13|(1:15)|16|17|18))|8|9|10|11|12|13|(0)|16|17|18|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x024a, code lost:
        if (com.baidu.ubc.x.DEBUG != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x024c, code lost:
        r3.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x024f, code lost:
        r27.noS.B(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x026f, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0270, code lost:
        r2 = r3;
        r3 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0276, code lost:
        r3 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01f4 A[Catch: all -> 0x0262, SQLException -> 0x0276, TryCatch #0 {all -> 0x0262, blocks: (B:3:0x000c, B:52:0x01ea, B:54:0x01ee, B:56:0x01f4, B:57:0x01fb, B:86:0x0248, B:88:0x024c, B:89:0x024f, B:68:0x0220, B:82:0x0241, B:83:0x0244, B:79:0x023a), top: B:117:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x021d A[Catch: all -> 0x027a, TRY_LEAVE, TryCatch #10 {all -> 0x027a, blocks: (B:65:0x0219, B:67:0x021d), top: B:121:0x0219 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0237 A[Catch: all -> 0x0278, TRY_LEAVE, TryCatch #9 {all -> 0x0278, blocks: (B:7:0x0026, B:9:0x002c, B:10:0x007c, B:12:0x0089, B:14:0x009e, B:71:0x0227, B:16:0x00a8, B:18:0x00db, B:20:0x00e3, B:22:0x00e8, B:24:0x00f2, B:26:0x00fa, B:28:0x00ff, B:30:0x010b, B:31:0x0125, B:33:0x0131, B:34:0x014b, B:36:0x0157, B:37:0x0162, B:39:0x016a, B:41:0x0170, B:42:0x018a, B:44:0x0196, B:45:0x01ab, B:47:0x01bf, B:61:0x020d, B:48:0x01c5, B:76:0x0233, B:78:0x0237), top: B:120:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x024c A[Catch: all -> 0x0262, TryCatch #0 {all -> 0x0262, blocks: (B:3:0x000c, B:52:0x01ea, B:54:0x01ee, B:56:0x01f4, B:57:0x01fb, B:86:0x0248, B:88:0x024c, B:89:0x024f, B:68:0x0220, B:82:0x0241, B:83:0x0244, B:79:0x023a), top: B:117:0x000c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int b(String str, ah ahVar) {
        int i;
        ArrayList<p> arrayList;
        Cursor cursor;
        long j;
        long j2;
        Cursor cursor2;
        Cursor cursor3;
        long endTime;
        long aWK;
        String string;
        int i2;
        this.npP.readLock().lock();
        try {
            try {
                arrayList = new ArrayList<>();
                cursor = null;
                j = Long.MAX_VALUE;
                j2 = 0;
                cursor2 = null;
                try {
                    try {
                        cursor3 = getReadableDatabase().rawQuery(str, null);
                    } catch (Throwable th) {
                        th = th;
                        Closeables.closeSafely(cursor2);
                        throw th;
                    }
                } catch (UnsupportedEncodingException e) {
                    e = e;
                    cursor3 = null;
                } catch (RuntimeException e2) {
                    e = e2;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = null;
                    Closeables.closeSafely(cursor2);
                    throw th;
                }
            } finally {
                this.npP.readLock().unlock();
            }
        } catch (SQLException e3) {
            SQLException e4 = e3;
            i = 0;
        }
        if (cursor3 != null) {
            try {
            } catch (UnsupportedEncodingException e5) {
                e = e5;
            } catch (RuntimeException e6) {
                e = e6;
                cursor = cursor3;
            }
            if (cursor3.getCount() > 0) {
                cursor3.moveToFirst();
                int columnIndex = cursor3.getColumnIndex("flowid");
                int columnIndex2 = cursor3.getColumnIndex("flowhandle");
                int columnIndex3 = cursor3.getColumnIndex("state");
                int columnIndex4 = cursor3.getColumnIndex("begintime");
                int columnIndex5 = cursor3.getColumnIndex(LogBuilder.KEY_END_TIME);
                int columnIndex6 = cursor3.getColumnIndex("content");
                int columnIndex7 = cursor3.getColumnIndex("option");
                int columnIndex8 = cursor3.getColumnIndex("reserve1");
                int columnIndex9 = cursor3.getColumnIndex("reserve2");
                int columnIndex10 = cursor3.getColumnIndex("slot");
                int columnIndex11 = cursor3.getColumnIndex("extend");
                while (true) {
                    if ("2".equals(cursor3.getString(columnIndex3)) || (Math.abs(cursor3.getLong(columnIndex4) - System.currentTimeMillis()) > 86400000 && (cursor3.getInt(columnIndex7) & 4) != 0)) {
                        p pVar = new p();
                        pVar.setId(cursor3.getString(columnIndex));
                        pVar.mv(cursor3.getInt(columnIndex2));
                        pVar.cr(cursor3.getLong(columnIndex4));
                        pVar.setEndTime(cursor3.getLong(columnIndex5));
                        endTime = (pVar.getEndTime() <= 0 || pVar.getEndTime() <= j2) ? j2 : pVar.getEndTime();
                        try {
                            aWK = (pVar.aWK() <= 0 || pVar.aWK() >= j) ? j : pVar.aWK();
                            String string2 = cursor3.getString(columnIndex6);
                            if (!TextUtils.isEmpty(string2)) {
                                pVar.setContent(string2);
                                this.mTotalLength = string2.getBytes("UTF-8").length + this.mTotalLength;
                            }
                            String string3 = cursor3.getString(columnIndex8);
                            if (!TextUtils.isEmpty(string3)) {
                                pVar.xG(string3);
                                this.mTotalLength = string3.getBytes("UTF-8").length + this.mTotalLength;
                            }
                            if (!TextUtils.isEmpty(cursor3.getString(columnIndex9))) {
                                pVar.setCategory(cursor3.getString(columnIndex9));
                            }
                            String string4 = cursor3.getString(columnIndex10);
                            if (columnIndex10 >= 0 && !TextUtils.isEmpty(string4)) {
                                pVar.xH(string4);
                                this.mTotalLength = string4.getBytes("UTF-8").length + this.mTotalLength;
                            }
                            if (!TextUtils.isEmpty(cursor3.getString(columnIndex11))) {
                                this.mTotalLength = string.getBytes("UTF-8").length + this.mTotalLength;
                                try {
                                    if (new JSONObject(cursor3.getString(columnIndex11)).has("ctr")) {
                                        pVar.hg(true);
                                    }
                                } catch (JSONException e7) {
                                    e7.printStackTrace();
                                }
                            }
                            arrayList.add(pVar);
                            ahVar.aF(pVar.aWD(), Integer.parseInt(pVar.getId()));
                            if (this.mTotalLength >= 10485760) {
                                break;
                            }
                        } catch (UnsupportedEncodingException e8) {
                            j2 = endTime;
                            e = e8;
                            if (DEBUG) {
                            }
                            Closeables.closeSafely(cursor3);
                            i = 0;
                            if (arrayList.size() > 0) {
                            }
                            ahVar.q(j, j2);
                            return i;
                        } catch (RuntimeException e9) {
                            j2 = endTime;
                            e = e9;
                            cursor = cursor3;
                            try {
                                if (DEBUG) {
                                }
                                Closeables.closeSafely(cursor);
                                i = 0;
                                if (arrayList.size() > 0) {
                                }
                                ahVar.q(j, j2);
                                return i;
                            } catch (Throwable th3) {
                                th = th3;
                                cursor2 = cursor;
                                Closeables.closeSafely(cursor2);
                                throw th;
                            }
                        }
                    } else {
                        endTime = j2;
                        aWK = j;
                    }
                    try {
                        if (!cursor3.moveToNext()) {
                            break;
                        }
                        j = aWK;
                        j2 = endTime;
                    } catch (UnsupportedEncodingException e10) {
                        j = aWK;
                        j2 = endTime;
                        e = e10;
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                        Closeables.closeSafely(cursor3);
                        i = 0;
                        if (arrayList.size() > 0) {
                        }
                        ahVar.q(j, j2);
                        return i;
                    } catch (RuntimeException e11) {
                        j = aWK;
                        j2 = endTime;
                        e = e11;
                        cursor = cursor3;
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                        Closeables.closeSafely(cursor);
                        i = 0;
                        if (arrayList.size() > 0) {
                        }
                        ahVar.q(j, j2);
                        return i;
                    }
                }
                j = aWK;
                j2 = endTime;
                i2 = 1;
                Closeables.closeSafely(cursor3);
                i = i2;
                if (arrayList.size() > 0) {
                    b(arrayList, ahVar);
                }
                ahVar.q(j, j2);
                return i;
            }
        }
        i2 = 0;
        Closeables.closeSafely(cursor3);
        i = i2;
        if (arrayList.size() > 0) {
        }
        ahVar.q(j, j2);
        return i;
    }

    private void b(ArrayList<p> arrayList, ah ahVar) {
        Cursor cursor;
        Cursor cursor2 = null;
        this.npP.readLock().lock();
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            try {
                Iterator<p> it = arrayList.iterator();
                while (it.hasNext()) {
                    p next = it.next();
                    if (next.aWD() >= 0) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", next.getId());
                        jSONObject.put(LogBuilder.KEY_START_TIME, Long.toString(next.aWK()));
                        jSONObject.put(LogBuilder.KEY_END_TIME, Long.toString(next.getEndTime()));
                        jSONObject.put("type", "1");
                        g dPU = g.dPU();
                        jSONObject.put("isreal", dPU.Ub(next.getId()) ? "1" : "0");
                        String Uc = dPU.Uc(next.getId());
                        if (!TextUtils.isEmpty(Uc) && !TextUtils.equals(Uc, "0")) {
                            jSONObject.put("gflow", Uc);
                        }
                        if (!TextUtils.isEmpty(next.getContent())) {
                            jSONObject.put("content", next.getContent());
                        }
                        if (!TextUtils.isEmpty(next.aWE())) {
                            jSONObject.put("abtest", next.aWE());
                            ahVar.xL("1");
                        }
                        if (!TextUtils.isEmpty(next.getCategory())) {
                            jSONObject.put("c", next.getCategory());
                        }
                        if (next.aWM() != null) {
                            jSONObject.put("part", next.aWM());
                        }
                        if (next.aWA()) {
                            jSONObject.put(MapBundleKey.MapObjKey.OBJ_OFFSET, "1");
                        }
                        jSONObject.put("idtype", dPU.xA(next.getId()));
                        JSONArray jSONArray = new JSONArray();
                        StringBuilder sb = new StringBuilder(256);
                        sb.append("SELECT ").append("eventid").append(" , ").append("begintime").append(" , ").append("content").append(" FROM ").append(NotificationCompat.CATEGORY_EVENT).append(" WHERE ").append("flowhandle").append(" = ").append(next.aWD());
                        try {
                            cursor = readableDatabase.rawQuery(sb.toString(), null);
                            if (cursor != null) {
                                try {
                                    if (cursor.getCount() > 0) {
                                        cursor.moveToFirst();
                                        int columnIndex = cursor.getColumnIndex("eventid");
                                        int columnIndex2 = cursor.getColumnIndex("begintime");
                                        int columnIndex3 = cursor.getColumnIndex("content");
                                        do {
                                            JSONObject jSONObject2 = new JSONObject();
                                            jSONObject2.put("id", cursor.getString(columnIndex));
                                            jSONObject2.put("timestamp", Long.toString(cursor.getLong(columnIndex2)));
                                            jSONObject2.put("content", cursor.getString(columnIndex3));
                                            jSONArray.put(jSONObject2);
                                        } while (cursor.moveToNext());
                                        jSONObject.put("eventlist", jSONArray);
                                    }
                                } catch (Throwable th) {
                                    cursor2 = cursor;
                                    th = th;
                                    Closeables.closeSafely(cursor2);
                                    throw th;
                                }
                            }
                            Closeables.closeSafely(cursor);
                            ahVar.cT(jSONObject);
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } else {
                        cursor = cursor2;
                    }
                    cursor2 = cursor;
                }
            } catch (RuntimeException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            } catch (JSONException e2) {
                if (DEBUG) {
                    Log.d("UBCDatabaseHelper", "json exception:");
                }
            }
        } catch (SQLException e3) {
            if (DEBUG) {
                e3.printStackTrace();
            }
            this.noS.B(e3);
        } finally {
            this.npP.readLock().unlock();
        }
    }

    private String d(ArrayList<j> arrayList, boolean z) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            j jVar = arrayList.get(i2);
            if (z && !"0".equals(jVar.getType())) {
                if (i > 0) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                } else {
                    i++;
                }
                sb.append(jVar.getId());
            } else if (!z && "0".equals(jVar.getType())) {
                if (i > 0) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                } else {
                    i++;
                }
                sb.append(jVar.getId());
            }
        }
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1922=4] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(k kVar) {
        if (kVar == null) {
            return false;
        }
        this.npP.writeLock().lock();
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("eventid", kVar.getId());
                contentValues.put("type", kVar.getType());
                if ("1".equals(kVar.aWu())) {
                    contentValues.put("cycle", (Integer) 0);
                } else {
                    contentValues.put("cycle", Integer.valueOf(kVar.getTimeout()));
                }
                contentValues.put("switch", kVar.aWt());
                contentValues.put("reserve1", kVar.aWv());
                if (!TextUtils.isEmpty(kVar.getCategory())) {
                    contentValues.put("reserve2", kVar.getCategory());
                }
                contentValues.put("sample", Integer.valueOf(kVar.aWw()));
                if (kVar.aWx() != 0 && kVar.aWy() != 0) {
                    contentValues.put("recordrule", Integer.valueOf(kVar.aWx()));
                    contentValues.put("uploadrule", Integer.valueOf(kVar.aWy()));
                }
                JSONObject jSONObject = new JSONObject();
                if (TextUtils.equals(kVar.aWz(), "1")) {
                    jSONObject.put("idtype", "1");
                }
                if (TextUtils.equals(kVar.dPW(), "1")) {
                    jSONObject.put("ch", "1");
                }
                if (TextUtils.equals(kVar.dPX(), "1")) {
                    jSONObject.put("dfc", "1");
                }
                if (kVar.getVersion() != null) {
                    jSONObject.put("version", kVar.getVersion());
                }
                String dPZ = kVar.dPZ();
                if (!TextUtils.isEmpty(dPZ) && !TextUtils.equals(dPZ, "0")) {
                    jSONObject.put("gflow", dPZ);
                }
                String dQa = kVar.dQa();
                if (!TextUtils.isEmpty(dQa)) {
                    jSONObject.put("uploadType", dQa);
                }
                if (!TextUtils.isEmpty(jSONObject.toString())) {
                    contentValues.put("extend", jSONObject.toString());
                }
                if (TextUtils.equals(kVar.dPY(), "1")) {
                    contentValues.put("reallog", kVar.dPY());
                } else {
                    contentValues.put("reallog", "0");
                }
                long replace = writableDatabase.replace("config", null, contentValues);
                if (DEBUG) {
                    Log.d("UBCDatabaseHelper", "updateConfig#performTransaction: id=" + kVar.getId());
                }
                writableDatabase.setTransactionSuccessful();
                boolean z = replace > 0;
                this.npP.writeLock().unlock();
                return z;
            } catch (JSONException e) {
                if (AppConfig.isDebug()) {
                    e.printStackTrace();
                }
                return false;
            } finally {
                writableDatabase.endTransaction();
            }
        } catch (SQLException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
            this.noS.B(e2);
            return false;
        } finally {
            this.npP.writeLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(SparseArray<Integer> sparseArray, ArrayList<String> arrayList, boolean z, String str) {
        boolean z2;
        SQLException e;
        this.npP.writeLock().lock();
        try {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                if (sparseArray != null) {
                    try {
                        if (sparseArray.size() > 0) {
                            int size = sparseArray.size();
                            ArrayList arrayList2 = new ArrayList(size);
                            for (int i = 0; i < size; i++) {
                                arrayList2.add(Integer.valueOf(sparseArray.keyAt(i)));
                            }
                            String w = w(arrayList2);
                            if (DEBUG) {
                                Log.d("UBCDatabaseHelper", "save file name " + str + " delete flow handle ids = " + w);
                            }
                            StringBuilder sb = new StringBuilder();
                            sb.append("flowhandle").append(" in (").append(w).append(")");
                            int delete = writableDatabase.delete("flow", sb.toString(), null);
                            if (DEBUG) {
                                Log.d("UBCDatabaseHelper", "clearUploadedData#performTransaction: flow table delete count:" + delete);
                            }
                            int delete2 = writableDatabase.delete(NotificationCompat.CATEGORY_EVENT, sb.toString(), null);
                            if (DEBUG) {
                                Log.d("UBCDatabaseHelper", "clearUploadedData#performTransaction:  delete flow -> event table count:" + delete2);
                            }
                        }
                    } finally {
                    }
                }
                if (arrayList != null && arrayList.size() > 0) {
                    String w2 = w(arrayList);
                    if (DEBUG) {
                        Log.d("UBCDatabaseHelper", "delete event ids = " + w2);
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("eventid").append(" in (").append(w2).append(")").append(" AND ").append("flowhandle").append(" = ").append(-1);
                    int delete3 = writableDatabase.delete(NotificationCompat.CATEGORY_EVENT, sb2.toString(), null);
                    if (DEBUG) {
                        Log.d("UBCDatabaseHelper", "clearUploadedData#performTransaction: event table count2:" + delete3);
                    }
                }
                if ((sparseArray != null && sparseArray.size() > 0) || (arrayList != null && arrayList.size() > 0)) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("filename", str);
                    contentValues.put("state", "0");
                    contentValues.put("reserve1", z ? "1" : "0");
                    long insert = writableDatabase.insert("file", null, contentValues);
                    if (DEBUG) {
                        Log.d("UBCDatabaseHelper", "clearUploadedData#save file: rowId=" + insert);
                    }
                }
                writableDatabase.setTransactionSuccessful();
                z2 = true;
            } finally {
                this.npP.writeLock().unlock();
            }
        } catch (SQLException e2) {
            z2 = false;
            e = e2;
        }
        try {
        } catch (SQLException e3) {
            e = e3;
            if (DEBUG) {
                e.printStackTrace();
            }
            this.noS.B(e);
            return z2;
        }
        return z2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [2056=4] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public o Ul(String str) {
        Cursor cursor;
        o oVar = null;
        this.npP.readLock().lock();
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT ").append("state").append(" , ").append("reserve1").append(" FROM ").append("file").append(" WHERE ").append("filename").append("=\"").append(str).append("\"");
            try {
                cursor = readableDatabase.rawQuery(sb.toString(), null);
                if (cursor != null) {
                    try {
                        try {
                            if (cursor.getCount() > 0) {
                                cursor.moveToFirst();
                                oVar = new o(str, cursor.getString(cursor.getColumnIndex("state")), !cursor.isNull(cursor.getColumnIndex("reserve1")) ? cursor.getString(cursor.getColumnIndex("reserve1")) : "");
                            }
                        } catch (Exception e) {
                            e = e;
                            if (DEBUG) {
                                e.printStackTrace();
                            }
                            Closeables.closeSafely(cursor);
                            return oVar;
                        }
                    } catch (Throwable th) {
                        th = th;
                        Closeables.closeSafely(cursor);
                        throw th;
                    }
                }
                Closeables.closeSafely(cursor);
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                Closeables.closeSafely(cursor);
                throw th;
            }
        } catch (SQLException e3) {
            if (DEBUG) {
                e3.printStackTrace();
            }
            this.noS.B(e3);
        } finally {
            this.npP.readLock().unlock();
        }
        return oVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void xp(String str) {
        this.npP.writeLock().lock();
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("filename").append("=\"").append(str).append("\"");
                int delete = writableDatabase.delete("file", sb.toString(), null);
                if (DEBUG) {
                    Log.d("UBCDatabaseHelper", "deleteSendedFile#performTransaction: delete file table:" + delete);
                }
                writableDatabase.setTransactionSuccessful();
            } finally {
                writableDatabase.endTransaction();
            }
        } catch (SQLException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            this.noS.B(e);
        } finally {
            this.npP.writeLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aVX() {
        this.npP.writeLock().lock();
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                int delete = writableDatabase.delete("file", null, null);
                if (DEBUG) {
                    Log.d("UBCDatabaseHelper", "deleteAllSentFile#performTransaction: delete file table:" + delete);
                }
                writableDatabase.setTransactionSuccessful();
            } finally {
                writableDatabase.endTransaction();
            }
        } catch (SQLException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            this.noS.B(e);
        } finally {
            this.npP.writeLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void xq(String str) {
        this.npP.writeLock().lock();
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("filename").append("=\"").append(str).append("\"");
                ContentValues contentValues = new ContentValues();
                contentValues.put("state", "1");
                int update = writableDatabase.update("file", contentValues, sb.toString(), null);
                if (DEBUG) {
                    Log.d("UBCDatabaseHelper", "updateSendedFileFail#performTransaction: update file table:" + update);
                }
                writableDatabase.setTransactionSuccessful();
            } finally {
                writableDatabase.endTransaction();
            }
        } catch (SQLException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            this.noS.B(e);
        } finally {
            this.npP.writeLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dj(String str, String str2) {
        this.npP.writeLock().lock();
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("filename").append("=\"").append(str).append("\"");
                ContentValues contentValues = new ContentValues();
                contentValues.put("state", str2);
                writableDatabase.update("file", contentValues, sb.toString(), null);
                writableDatabase.setTransactionSuccessful();
            } finally {
                writableDatabase.endTransaction();
            }
        } catch (SQLException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            this.noS.B(e);
        } finally {
            this.npP.writeLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aVY() {
        this.npP.writeLock().lock();
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("state", "1");
                int update = writableDatabase.update("file", contentValues, null, null);
                if (DEBUG) {
                    Log.d("UBCDatabaseHelper", "updateAllSentFileFail#performTransaction: update file table:" + update);
                }
                writableDatabase.setTransactionSuccessful();
            } finally {
                writableDatabase.endTransaction();
            }
        } catch (SQLException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            this.noS.B(e);
        } finally {
            this.npP.writeLock().unlock();
        }
    }

    private String w(ArrayList arrayList) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            if (i > 0) {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            sb.append(arrayList.get(i));
        }
        return sb.toString();
    }
}
