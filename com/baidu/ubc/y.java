package com.baidu.ubc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.util.io.Closeables;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.config.AppConfig;
import com.sina.weibo.sdk.statistic.LogBuilder;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class y extends SQLiteOpenHelper {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static y oHA = null;
    private static ReentrantLock oHB = new ReentrantLock();
    private Context mContext;
    private long mTotalLength;
    private b oGs;
    private ReentrantReadWriteLock oHz;

    public static y gX(Context context) {
        if (oHA == null) {
            oHB.lock();
            if (oHA == null) {
                oHA = new y(context);
            }
            oHB.unlock();
        }
        return oHA;
    }

    private y(Context context) {
        super(context, "bdbehavior.db", (SQLiteDatabase.CursorFactory) null, 7);
        this.oHz = new ReentrantReadWriteLock(true);
        this.oGs = new b(context);
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
            ai.ejh().putString("ubc_cloudconfig_version", "0");
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
                        J(sQLiteDatabase);
                        break;
                    case 2:
                        M(sQLiteDatabase);
                        break;
                    case 3:
                        K(sQLiteDatabase);
                        break;
                    case 4:
                        L(sQLiteDatabase);
                        break;
                    case 6:
                        am(sQLiteDatabase);
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

    private void J(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE file (filename TEXT PRIMARY KEY,state TEXT,reserve1 TEXT,reserve2 TEXT);");
        } catch (SQLException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void K(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE event ADD COLUMN extend TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE flow ADD COLUMN extend TEXT");
        } catch (SQLException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void L(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE config ADD COLUMN extend TEXT");
        } catch (SQLException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void am(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE config ADD COLUMN reallog DEFAULT '0'");
            sQLiteDatabase.execSQL("ALTER TABLE event ADD COLUMN reallog DEFAULT '0'");
        } catch (SQLException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void M(SQLiteDatabase sQLiteDatabase) {
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
    public void b(n nVar) {
        if (nVar == null || TextUtils.isEmpty(nVar.getId())) {
            if (DEBUG) {
                Log.d("UBCDatabaseHelper", "saveEvent#event id must not be null");
                return;
            }
            return;
        }
        this.oHz.writeLock().lock();
        try {
            ContentValues i = i(nVar);
            String bgb = nVar.bgb();
            String id = nVar.getId();
            int bgc = nVar.bgc();
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                if (a(bgb, id, bgc, writableDatabase)) {
                    long insert = writableDatabase.insert("event", null, i);
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
            this.oGs.B(e);
        } finally {
            this.oHz.writeLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ba(List<n> list) {
        if (list == null || list.size() == 0) {
            if (DEBUG) {
                Log.d("UBCDatabaseHelper", "saveEvents#data must not be null");
                return;
            }
            return;
        }
        for (n nVar : list) {
            b(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean eiZ() {
        int i;
        this.oHz.writeLock().lock();
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                try {
                    i = writableDatabase.delete("event", "reallog =?", new String[]{"1"});
                    try {
                        writableDatabase.setTransactionSuccessful();
                    } catch (SQLException e) {
                        e = e;
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                        this.oGs.B(e);
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
            this.oGs.B(e3);
            return false;
        } finally {
            this.oHz.writeLock().unlock();
        }
    }

    private ContentValues i(n nVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("flowhandle", Integer.valueOf(nVar.bgc()));
        contentValues.put("eventid", nVar.getId());
        contentValues.put("begintime", Long.valueOf(nVar.getTime()));
        if (!TextUtils.isEmpty(nVar.getContent())) {
            contentValues.put("content", nVar.getContent());
        } else if (nVar.bge() != null && !TextUtils.isEmpty(nVar.bge().toString())) {
            contentValues.put("content", nVar.bge().toString());
        }
        if (!TextUtils.isEmpty(nVar.bgd())) {
            contentValues.put("reserve1", nVar.bgd());
        }
        if (!TextUtils.isEmpty(nVar.getCategory())) {
            contentValues.put("reserve2", nVar.getCategory());
        }
        if (nVar.bfZ()) {
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
        if (!TextUtils.isEmpty(nVar.eiR())) {
            contentValues.put("reallog", nVar.eiR());
        } else {
            contentValues.put("reallog", "0");
        }
        return contentValues;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [693=6] */
    /* JADX WARN: Can't wrap try/catch for region: R(15:1|2|3|4|(2:5|6)|(3:27|28|(11:30|(17:31|(4:33|(1:35)|36|(1:38))|39|(1:41)|42|(1:44)|45|(1:47)|48|(3:50|(1:52)|53)|54|(1:56)(1:70)|57|(1:61)|62|63|(1:69)(1:65))|67|68|9|10|11|12|13|14|15))|8|9|10|11|12|13|14|15|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0218, code lost:
        if (com.baidu.ubc.y.DEBUG != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x021a, code lost:
        r3.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x021d, code lost:
        r25.oGs.B(r3);
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
    private int a(String str, aj ajVar) {
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
        this.oHz.readLock().lock();
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
                this.oHz.readLock().unlock();
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
                ajVar.r(j, j2);
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
                ajVar.r(j, j2);
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
                        ajVar.zG("1");
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
                    g eiL = g.eiL();
                    jSONObject.put("idtype", eiL.zv(string2));
                    jSONObject.put("isreal", eiL.XG(string2) ? "1" : "0");
                    String XH = eiL.XH(string2);
                    if (!TextUtils.isEmpty(XH) && !TextUtils.equals(XH, "0")) {
                        jSONObject.put("gflow", XH);
                    }
                    ajVar.df(jSONObject);
                    ajVar.zF(rawQuery.getString(columnIndex));
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
                ajVar.r(j, j2);
                return i;
            }
        }
        i2 = 0;
        j3 = Long.MAX_VALUE;
        j2 = 0;
        Closeables.closeSafely(rawQuery);
        j = j3;
        i = i2;
        ajVar.r(j, j2);
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
        this.oHz.writeLock().lock();
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("flowid", pVar.getId());
                contentValues.put("flowhandle", Integer.valueOf(pVar.bgc()));
                contentValues.put("state", pVar.bgk());
                contentValues.put("begintime", Long.valueOf(pVar.bgj()));
                if (pVar.bge() != null) {
                    contentValues.put("content", pVar.bge().toString());
                } else {
                    contentValues.put("content", pVar.getContent());
                }
                contentValues.put("option", Integer.valueOf(pVar.getOption()));
                contentValues.put("reserve1", pVar.bgd());
                if (!TextUtils.isEmpty(pVar.getCategory())) {
                    contentValues.put("reserve2", pVar.getCategory());
                }
                if (pVar.bfZ()) {
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
            this.oGs.B(e2);
        } finally {
            this.oHz.writeLock().unlock();
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
        this.oHz.writeLock().lock();
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
            this.oGs.B(e);
        } finally {
            this.oHz.writeLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(String str, int i) {
        if (i < 0 || TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.d("UBCDatabaseHelper", "cancelFlow#flowHandle invalid");
                return;
            }
            return;
        }
        this.oHz.writeLock().lock();
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
                int delete2 = writableDatabase.delete("event", "flowhandle = " + i, null);
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
            this.oGs.B(e);
        } finally {
            this.oHz.writeLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(String str, int i, String str2) {
        if (i < 0 || TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.d("UBCDatabaseHelper", "updateFlowValue#flowHandle invalid");
                return;
            }
            return;
        }
        this.oHz.writeLock().lock();
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
            this.oGs.B(e);
        } finally {
            this.oHz.writeLock().unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1005=4] */
    private boolean a(String str, String str2, int i, SQLiteDatabase sQLiteDatabase) {
        SQLException e;
        Cursor cursor = null;
        boolean z = false;
        this.oHz.writeLock().lock();
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
                            this.oGs.B(e3);
                        } finally {
                            Closeables.closeSafely(cursor);
                        }
                    } catch (SQLException e4) {
                        e = e4;
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                        this.oGs.B(e);
                        return z;
                    }
                }
            } catch (SQLException e5) {
                z = true;
                e = e5;
            }
            return z;
        } finally {
            this.oHz.writeLock().unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1100=4] */
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x013b A[Catch: all -> 0x01d2, TryCatch #1 {all -> 0x01d2, blocks: (B:9:0x0076, B:11:0x007a, B:12:0x0094, B:20:0x0132, B:22:0x013b, B:24:0x013f, B:25:0x015d, B:13:0x0106, B:15:0x0111, B:17:0x0117, B:18:0x011a), top: B:76:0x0076 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01e1 A[Catch: all -> 0x0233, TryCatch #2 {all -> 0x0233, blocks: (B:28:0x019b, B:44:0x01dd, B:46:0x01e1, B:47:0x01e4), top: B:78:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x024c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void bfv() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6 = 0;
        int i7 = 0;
        this.oHz.writeLock().lock();
        try {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    long currentTimeMillis = System.currentTimeMillis() - g.eiL().bfO();
                    i4 = writableDatabase.delete("flow", "endtime < " + currentTimeMillis, null);
                    try {
                        if (DEBUG) {
                            Log.d("UBCDatabaseHelper", "clearInvalidData: delete flow count:" + i4);
                        }
                        i3 = writableDatabase.delete("event", "begintime < " + currentTimeMillis, null);
                        try {
                            if (DEBUG) {
                                Log.d("UBCDatabaseHelper", "clearInvalidData: delete event count:" + i3);
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
                                if (arrayList.size() <= 0) {
                                }
                                writableDatabase.setTransactionSuccessful();
                                writableDatabase.endTransaction();
                                zi("flow");
                                zi("event");
                                this.oHz.writeLock().unlock();
                                if (i4 <= 0) {
                                }
                                ac.ejd().h(String.valueOf(g.eiL().bfO()), i4, i3, i7);
                            }
                            Closeables.closeSafely(rawQuery);
                            if (arrayList.size() <= 0) {
                                if (DEBUG) {
                                    Log.d("UBCDatabaseHelper", "clearInvalidData: delete flow count2:" + arrayList.size());
                                }
                                i7 = arrayList.size();
                                try {
                                    String w = w(arrayList);
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("flowhandle").append(" in (").append(w).append(")");
                                    writableDatabase.delete("flow", sb2.toString(), null);
                                    writableDatabase.delete("event", sb2.toString(), null);
                                } catch (Throwable th) {
                                    th = th;
                                    i6 = i3;
                                    i5 = i4;
                                    try {
                                        writableDatabase.endTransaction();
                                        throw th;
                                    } catch (SQLException e) {
                                        e = e;
                                        i4 = i5;
                                        i3 = i6;
                                        if (DEBUG) {
                                        }
                                        this.oGs.B(e);
                                        this.oHz.writeLock().unlock();
                                        if (i4 <= 0) {
                                        }
                                        ac.ejd().h(String.valueOf(g.eiL().bfO()), i4, i3, i7);
                                    } catch (Throwable th2) {
                                        th = th2;
                                        i2 = i5;
                                        i = i6;
                                        this.oHz.writeLock().unlock();
                                        if (i2 > 0 || i > 0 || i7 > 0) {
                                            ac.ejd().h(String.valueOf(g.eiL().bfO()), i2, i, i7);
                                        }
                                        throw th;
                                    }
                                }
                            } else {
                                i7 = 0;
                            }
                            writableDatabase.setTransactionSuccessful();
                            try {
                                writableDatabase.endTransaction();
                                zi("flow");
                                zi("event");
                                this.oHz.writeLock().unlock();
                                if (i4 <= 0 || i3 > 0 || i7 > 0) {
                                    ac.ejd().h(String.valueOf(g.eiL().bfO()), i4, i3, i7);
                                }
                            } catch (SQLException e2) {
                                e = e2;
                                if (DEBUG) {
                                    e.printStackTrace();
                                }
                                this.oGs.B(e);
                                this.oHz.writeLock().unlock();
                                if (i4 <= 0 || i3 > 0 || i7 > 0) {
                                    ac.ejd().h(String.valueOf(g.eiL().bfO()), i4, i3, i7);
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            i7 = 0;
                            i6 = i3;
                            i5 = i4;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        i7 = 0;
                        i5 = i4;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    i7 = 0;
                    i5 = 0;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (SQLException e3) {
            e = e3;
            i7 = 0;
            i3 = 0;
            i4 = 0;
        } catch (Throwable th7) {
            th = th7;
            i7 = 0;
            i = 0;
            i2 = 0;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1165=4, 1168=6] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008d A[Catch: all -> 0x0136, TryCatch #4 {all -> 0x0136, blocks: (B:14:0x0089, B:16:0x008d, B:17:0x00a7), top: B:57:0x0089 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e9 A[Catch: all -> 0x0131, TryCatch #2 {all -> 0x0131, blocks: (B:18:0x00aa, B:36:0x00e5, B:38:0x00e9, B:39:0x00ec, B:33:0x00e0, B:34:0x00e3), top: B:56:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void zi(String str) {
        int i;
        int delete;
        int i2 = 0;
        Cursor cursor = null;
        int i3 = 0;
        this.oHz.writeLock().lock();
        try {
            try {
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
                        try {
                            if (cursor != null && cursor.getCount() > 0) {
                                cursor.moveToFirst();
                                if (cursor.getInt(0) > g.eiL().bfP()) {
                                    i = (cursor.getInt(1) + cursor.getInt(2)) / 2;
                                    Closeables.closeSafely(cursor);
                                    delete = writableDatabase.delete(str, "_id < " + i, null);
                                    if (DEBUG) {
                                        Log.d("UBCDatabaseHelper", "ensureDataBaseLimit#performTransaction: delete count:" + delete);
                                    }
                                    writableDatabase.setTransactionSuccessful();
                                    writableDatabase.endTransaction();
                                    this.oHz.writeLock().unlock();
                                    if (delete <= 0) {
                                        ac.ejd().w(String.valueOf(g.eiL().bfP()), delete, str);
                                        return;
                                    }
                                    return;
                                }
                            }
                            if (DEBUG) {
                            }
                            writableDatabase.setTransactionSuccessful();
                            writableDatabase.endTransaction();
                            this.oHz.writeLock().unlock();
                            if (delete <= 0) {
                            }
                        } catch (Throwable th) {
                            th = th;
                            writableDatabase.endTransaction();
                            throw th;
                        }
                        i = 0;
                        Closeables.closeSafely(cursor);
                        delete = writableDatabase.delete(str, "_id < " + i, null);
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    this.oHz.writeLock().unlock();
                    if (i3 > 0) {
                        ac.ejd().w(String.valueOf(g.eiL().bfP()), i3, str);
                    }
                    throw th;
                }
            } catch (SQLException e2) {
                e = e2;
                if (DEBUG) {
                    e.printStackTrace();
                }
                this.oGs.B(e);
                this.oHz.writeLock().unlock();
                if (i2 <= 0) {
                    ac.ejd().w(String.valueOf(g.eiL().bfP()), i2, str);
                }
            }
        } catch (SQLException e3) {
            e = e3;
            i2 = 0;
            if (DEBUG) {
            }
            this.oGs.B(e);
            this.oHz.writeLock().unlock();
            if (i2 <= 0) {
            }
        } catch (Throwable th4) {
            th = th4;
            i3 = 0;
            this.oHz.writeLock().unlock();
            if (i3 > 0) {
            }
            throw th;
        }
    }

    public void a(f fVar) {
        Cursor cursor = null;
        this.oHz.readLock().lock();
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
                        fVar.oGS.add(string);
                    } else if (TextUtils.equals(string2, "1")) {
                        fVar.oGV.add(string);
                    }
                    if (i2 == 0) {
                        fVar.oGT.add(string);
                    }
                    if (TextUtils.equals(string3, "1")) {
                        fVar.oGU.add(string);
                    }
                    if (i > 0) {
                        fVar.oGX.put(string, String.valueOf(i));
                    }
                    if (!TextUtils.isEmpty(string4)) {
                        fVar.oGY.put(string, string4);
                    }
                    if (i3 != 0 && i4 != 0) {
                        fVar.oGZ.put(string, new m(string, i4, i3));
                    }
                    if (!TextUtils.isEmpty(string5)) {
                        try {
                            JSONObject jSONObject = new JSONObject(string5);
                            if (jSONObject.has("idtype")) {
                                fVar.oHa.add(string);
                            }
                            if (jSONObject.has("ch") && TextUtils.equals(jSONObject.getString("ch"), "1")) {
                                fVar.oGW.add(string);
                            }
                            if (jSONObject.has("gflow")) {
                                String string7 = jSONObject.getString("gflow");
                                if (!TextUtils.equals(string7, "0")) {
                                    fVar.oHc.put(string, string7);
                                }
                            }
                            if (jSONObject.has("uploadType")) {
                                String string8 = jSONObject.getString("uploadType");
                                if (!TextUtils.isEmpty(string8)) {
                                    fVar.oHd.put(string, string8);
                                }
                            }
                            int optInt = jSONObject.optInt("lcache", 2);
                            if (optInt == 1 || optInt == 0) {
                                fVar.oHe.put(string, Integer.valueOf(optInt));
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (TextUtils.equals(string6, "1")) {
                        fVar.oHb.add(string);
                    }
                } while (cursor.moveToNext());
            }
        } catch (SQLException e3) {
            if (DEBUG) {
                e3.printStackTrace();
            }
            this.oGs.B(e3);
        } finally {
            this.oHz.readLock().unlock();
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
        this.oHz.readLock().lock();
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
            this.oGs.B(e2);
        } finally {
            this.oHz.readLock().unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1446=5, 1454=4] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public k XP(String str) {
        Cursor cursor;
        Cursor cursor2;
        this.oHz.readLock().lock();
        try {
            try {
                cursor = getReadableDatabase().rawQuery(String.format("SELECT * FROM %s where eventid = \"%s\"", "config", str), null);
                if (cursor != null) {
                    try {
                        if (cursor.getCount() > 0) {
                            cursor.moveToFirst();
                            String string = cursor.getString(cursor.getColumnIndex("eventid"));
                            String string2 = cursor.getString(cursor.getColumnIndex("switch"));
                            int i = cursor.getInt(cursor.getColumnIndex("cycle"));
                            k kVar = new k(string, string2, i == 0 ? "1" : "0", i, cursor.getString(cursor.getColumnIndex("type")), cursor.getString(cursor.getColumnIndex("reserve1")));
                            String string3 = cursor.getString(cursor.getColumnIndex("extend"));
                            if (!TextUtils.isEmpty(string3)) {
                                try {
                                    JSONObject jSONObject = new JSONObject(string3);
                                    String optString = jSONObject.optString("dfc");
                                    if (!TextUtils.isEmpty(optString)) {
                                        kVar.XL(optString);
                                    }
                                    String optString2 = jSONObject.optString("version");
                                    if (!TextUtils.isEmpty(optString2)) {
                                        kVar.setVersion(optString2);
                                    }
                                    String optString3 = jSONObject.optString("uploadType");
                                    if (!TextUtils.isEmpty(optString3)) {
                                        kVar.XO(optString3);
                                    }
                                    int optInt = jSONObject.optInt("lcache", 2);
                                    if (optInt == 1 || optInt == 0) {
                                        kVar.OE(optInt);
                                    }
                                } catch (JSONException e) {
                                    if (DEBUG) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                            String string4 = cursor.getString(cursor.getColumnIndex("reallog"));
                            if (!TextUtils.isEmpty(string4)) {
                                kVar.XM(string4);
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
            this.oGs.B(e4);
        } finally {
            this.oHz.readLock().unlock();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1524=4] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean XQ(String str) {
        Cursor cursor = null;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ").append("config").append(" WHERE ").append("eventid").append("=\"").append(str).append("\"");
        this.oHz.writeLock().lock();
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                cursor = writableDatabase.rawQuery(sb.toString(), null);
                if (cursor == null || cursor.getCount() == 0) {
                    return true;
                }
                int delete = writableDatabase.delete("config", "eventid =? ", new String[]{str});
                writableDatabase.setTransactionSuccessful();
                boolean z = delete > 0;
                this.oHz.writeLock().unlock();
                return z;
            } finally {
                Closeables.closeSafely(cursor);
                writableDatabase.endTransaction();
            }
        } catch (SQLException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            this.oGs.B(e);
            return false;
        } finally {
            this.oHz.writeLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(ArrayList<j> arrayList, aj ajVar) {
        int i;
        this.mTotalLength = 0L;
        String d = d(arrayList, true);
        if (TextUtils.isEmpty(d)) {
            i = 0;
        } else {
            StringBuilder sb = new StringBuilder(256);
            sb.append("SELECT * ").append(" FROM ").append("flow").append(" WHERE ").append("flowid").append(" in (").append(d).append(")");
            i = b(sb.toString(), ajVar);
        }
        String d2 = d(arrayList, false);
        if (!TextUtils.isEmpty(d2)) {
            StringBuilder sb2 = new StringBuilder(256);
            sb2.append("SELECT *  FROM ").append("event").append(" WHERE ").append("eventid").append(" in (").append(d2).append(")").append(" AND ").append("flowhandle").append(" = ").append(-1).append(" AND ").append("reallog").append(" = \"0\"");
            return i | a(sb2.toString(), ajVar);
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(aj ajVar, aj ajVar2) {
        int c = c(ajVar, ajVar2);
        if (ajVar.ejj() && ajVar2.ejj()) {
            return 1;
        }
        return c | b(ajVar, ajVar2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1764=5] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:119:0x02bf */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:78:0x0223 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r30v0, types: [com.baidu.ubc.aj] */
    /* JADX WARN: Type inference failed for: r31v0, types: [com.baidu.ubc.aj] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v17, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v22, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v9 */
    private int b(aj ajVar, aj ajVar2) {
        SQLException e;
        int i;
        boolean ejj;
        boolean ejj2;
        Throwable th;
        Cursor cursor;
        Cursor cursor2;
        int i2;
        ?? r7 = "SELECT * FROM event WHERE flowhandle = -1 AND reallog = \"0\"";
        this.oHz.readLock().lock();
        int i3 = 0;
        try {
            try {
                ejj = ajVar.ejj();
                ejj2 = ajVar2.ejj();
                i = 0;
                try {
                    try {
                        try {
                            try {
                                r7 = getReadableDatabase().rawQuery("SELECT * FROM event WHERE flowhandle = -1 AND reallog = \"0\"", null);
                            } catch (Throwable th2) {
                                i3 = 0;
                                th = th2;
                            }
                        } catch (Throwable th3) {
                            r7 = 0;
                            i3 = 0;
                            th = th3;
                        }
                    } catch (UnsupportedEncodingException e2) {
                        e = e2;
                        i = 0;
                        cursor2 = null;
                    } catch (RuntimeException e3) {
                        e = e3;
                        i = 0;
                        cursor = null;
                    } catch (JSONException e4) {
                        r7 = 0;
                        i = 0;
                    } catch (Throwable th4) {
                        r7 = 0;
                        th = th4;
                    }
                } catch (SQLException e5) {
                    e = e5;
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                    this.oGs.B(e);
                    return i;
                }
            } catch (SQLException e6) {
                e = e6;
                i = i3;
            }
            if (r7 != 0) {
                try {
                } catch (UnsupportedEncodingException e7) {
                    i = 0;
                    cursor2 = r7;
                    e = e7;
                } catch (RuntimeException e8) {
                    i = 0;
                    cursor = r7;
                    e = e8;
                } catch (JSONException e9) {
                    i = 0;
                } catch (Throwable th5) {
                    th = th5;
                    Closeables.closeSafely((Cursor) r7);
                    throw th;
                }
                if (r7.getCount() > 0) {
                    r7.moveToFirst();
                    int columnIndex = r7.getColumnIndex("eventid");
                    int columnIndex2 = r7.getColumnIndex("begintime");
                    int columnIndex3 = r7.getColumnIndex("content");
                    int columnIndex4 = r7.getColumnIndex("reserve1");
                    int columnIndex5 = r7.getColumnIndex("reserve2");
                    int columnIndex6 = r7.getColumnIndex("extend");
                    i = 0;
                    boolean z = ejj2;
                    boolean z2 = ejj;
                    do {
                        try {
                            String string = r7.getString(columnIndex);
                            boolean zp = g.eiL().zp(string);
                            if (!z2 || !z) {
                                if ((!z2 || !zp) && (!z || zp)) {
                                    int i4 = 0;
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("id", string);
                                    long j = r7.getLong(columnIndex2);
                                    jSONObject.put("timestamp", Long.toString(j));
                                    if (j > 0) {
                                        if (zp) {
                                            if (ajVar.bgE() == 0 || j < ajVar.bgE()) {
                                                ajVar.r(j, 0L);
                                            }
                                            if (j > ajVar.getMaxTime()) {
                                                ajVar.r(0L, j);
                                            }
                                        } else {
                                            if (ajVar2.bgE() == 0 || j < ajVar2.bgE()) {
                                                ajVar2.r(j, 0L);
                                            }
                                            if (j > ajVar2.getMaxTime()) {
                                                ajVar2.r(0L, j);
                                            }
                                        }
                                    }
                                    jSONObject.put("type", "0");
                                    String string2 = r7.getString(columnIndex3);
                                    if (!TextUtils.isEmpty(string2)) {
                                        jSONObject.put("content", string2);
                                        i4 = 0 + string2.getBytes("UTF-8").length;
                                    }
                                    String string3 = r7.getString(columnIndex4);
                                    if (TextUtils.isEmpty(string3)) {
                                        i2 = i4;
                                    } else {
                                        jSONObject.put("abtest", string3);
                                        if (zp) {
                                            ajVar.zG("1");
                                        } else {
                                            ajVar2.zG("1");
                                        }
                                        i2 = i4 + string3.getBytes("UTF-8").length;
                                    }
                                    String string4 = r7.getString(columnIndex5);
                                    if (!TextUtils.isEmpty(string4)) {
                                        jSONObject.put("c", string4);
                                    }
                                    String string5 = r7.getString(columnIndex6);
                                    if (!TextUtils.isEmpty(string5) && new JSONObject(string5).has("ctr")) {
                                        jSONObject.put(MapBundleKey.MapObjKey.OBJ_OFFSET, "1");
                                    }
                                    g eiL = g.eiL();
                                    jSONObject.put("idtype", eiL.zv(string));
                                    jSONObject.put("isreal", eiL.XG(string) ? "1" : "0");
                                    String XH = eiL.XH(string);
                                    if (!TextUtils.isEmpty(XH) && !TextUtils.equals(XH, "0")) {
                                        jSONObject.put("gflow", XH);
                                    }
                                    if (zp) {
                                        ajVar.df(jSONObject);
                                        ajVar.zF(string);
                                        ajVar.OJ(i2);
                                        if (ajVar.ejj()) {
                                            z2 = true;
                                        }
                                    } else {
                                        ajVar2.df(jSONObject);
                                        ajVar2.zF(string);
                                        ajVar2.OJ(i2);
                                        if (ajVar2.ejj()) {
                                            z = true;
                                        }
                                    }
                                    if (i == 0) {
                                        i = 1;
                                    }
                                    if (z2 && z) {
                                        break;
                                    }
                                }
                            } else {
                                break;
                            }
                        } catch (UnsupportedEncodingException e10) {
                            cursor2 = r7;
                            e = e10;
                            if (DEBUG) {
                                e.printStackTrace();
                            }
                            Closeables.closeSafely(cursor2);
                            return i;
                        } catch (RuntimeException e11) {
                            cursor = r7;
                            e = e11;
                            if (DEBUG) {
                                e.printStackTrace();
                            }
                            Closeables.closeSafely(cursor);
                            return i;
                        } catch (JSONException e12) {
                            if (DEBUG) {
                                Log.d("UBCDatabaseHelper", "json exception:");
                            }
                            Closeables.closeSafely((Cursor) r7);
                            return i;
                        }
                    } while (r7.moveToNext());
                    Closeables.closeSafely((Cursor) r7);
                    return i;
                }
            }
            i = 0;
            Closeables.closeSafely((Cursor) r7);
            return i;
        } finally {
            this.oHz.readLock().unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1954=5] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:136:0x001d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:97:0x0298 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x022a A[ADDED_TO_REGION] */
    /* JADX WARN: Type inference failed for: r6v5, types: [int] */
    /* JADX WARN: Type inference failed for: r6v71 */
    /* JADX WARN: Type inference failed for: r6v72 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int c(aj ajVar, aj ajVar2) {
        SQLException e;
        ?? r6;
        boolean ejj;
        boolean ejj2;
        Cursor cursor;
        SQLiteDatabase readableDatabase;
        Throwable th;
        String str;
        Cursor cursor2;
        RuntimeException runtimeException;
        String str2;
        Cursor cursor3;
        UnsupportedEncodingException unsupportedEncodingException;
        Cursor rawQuery;
        int i;
        boolean z;
        boolean z2;
        String str3;
        String str4 = " SELECT * FROM flow";
        this.oHz.readLock().lock();
        ?? r8 = false;
        try {
            try {
                ejj = ajVar.ejj();
                ejj2 = ajVar2.ejj();
                cursor = null;
                readableDatabase = getReadableDatabase();
            } catch (SQLException e2) {
                e = e2;
                str4 = r8;
            }
            try {
                try {
                    try {
                        try {
                            rawQuery = readableDatabase.rawQuery(" SELECT * FROM flow", null);
                        } catch (SQLException e3) {
                            e = e3;
                            if (DEBUG) {
                                e.printStackTrace();
                            }
                            this.oGs.B(e);
                            return r6;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        Closeables.closeSafely(cursor);
                        throw th;
                    }
                } catch (UnsupportedEncodingException e4) {
                    str2 = null;
                    cursor3 = null;
                    unsupportedEncodingException = e4;
                } catch (RuntimeException e5) {
                    str = null;
                    cursor2 = null;
                    runtimeException = e5;
                }
                if (rawQuery != null) {
                    try {
                    } catch (UnsupportedEncodingException e6) {
                        str2 = r8;
                        cursor3 = rawQuery;
                        unsupportedEncodingException = e6;
                        if (DEBUG) {
                            unsupportedEncodingException.printStackTrace();
                        }
                        Closeables.closeSafely(cursor3);
                        str4 = str2;
                        return r6;
                    } catch (RuntimeException e7) {
                        str = r8;
                        cursor2 = rawQuery;
                        runtimeException = e7;
                        if (DEBUG) {
                            runtimeException.printStackTrace();
                        }
                        Closeables.closeSafely(cursor2);
                        str4 = str;
                        return r6;
                    }
                    if (rawQuery.getCount() > 0) {
                        rawQuery.moveToFirst();
                        int columnIndex = rawQuery.getColumnIndex("flowid");
                        int columnIndex2 = rawQuery.getColumnIndex("flowhandle");
                        int columnIndex3 = rawQuery.getColumnIndex("state");
                        int columnIndex4 = rawQuery.getColumnIndex("begintime");
                        int columnIndex5 = rawQuery.getColumnIndex(LogBuilder.KEY_END_TIME);
                        int columnIndex6 = rawQuery.getColumnIndex("content");
                        int columnIndex7 = rawQuery.getColumnIndex("option");
                        int columnIndex8 = rawQuery.getColumnIndex("reserve1");
                        int columnIndex9 = rawQuery.getColumnIndex("reserve2");
                        int columnIndex10 = rawQuery.getColumnIndex("slot");
                        int columnIndex11 = rawQuery.getColumnIndex("extend");
                        while (true) {
                            if ("2".equals(rawQuery.getString(columnIndex3)) || (Math.abs(rawQuery.getLong(columnIndex4) - System.currentTimeMillis()) > 86400000 && (rawQuery.getInt(columnIndex7) & 4) != 0)) {
                                String string = rawQuery.getString(columnIndex);
                                int i2 = rawQuery.getInt(columnIndex2);
                                if (i2 >= 0) {
                                    boolean zp = g.eiL().zp(string);
                                    if (ejj && ejj2) {
                                        str3 = r8;
                                        break;
                                    } else if (ejj && zp) {
                                        z = ejj2;
                                        z2 = ejj;
                                    } else if (!ejj2 || zp) {
                                        int i3 = 0;
                                        p pVar = new p();
                                        pVar.setId(rawQuery.getString(columnIndex));
                                        pVar.nH(i2);
                                        pVar.dw(rawQuery.getLong(columnIndex4));
                                        pVar.setEndTime(rawQuery.getLong(columnIndex5));
                                        if (zp) {
                                            if (pVar.getEndTime() > 0 && pVar.getEndTime() > ajVar.getMaxTime()) {
                                                ajVar.r(0L, pVar.getEndTime());
                                            }
                                            if (pVar.bgj() > 0 && (ajVar.bgE() == 0 || pVar.bgj() < ajVar.bgE())) {
                                                ajVar.r(pVar.bgj(), 0L);
                                            }
                                        } else {
                                            if (pVar.getEndTime() > 0 && pVar.getEndTime() > ajVar2.getMaxTime()) {
                                                ajVar2.r(0L, pVar.getEndTime());
                                            }
                                            if (pVar.bgj() > 0 && (ajVar2.bgE() == 0 || pVar.bgj() < ajVar2.bgE())) {
                                                ajVar2.r(pVar.bgj(), 0L);
                                            }
                                        }
                                        String string2 = rawQuery.getString(columnIndex6);
                                        if (!TextUtils.isEmpty(string2)) {
                                            pVar.setContent(string2);
                                            i3 = 0 + string2.getBytes("UTF-8").length;
                                        }
                                        String string3 = rawQuery.getString(columnIndex8);
                                        if (!TextUtils.isEmpty(string3)) {
                                            pVar.zB(string3);
                                            i3 += string3.getBytes("UTF-8").length;
                                        }
                                        if (!TextUtils.isEmpty(rawQuery.getString(columnIndex9))) {
                                            pVar.setCategory(rawQuery.getString(columnIndex9));
                                        }
                                        String string4 = rawQuery.getString(columnIndex10);
                                        if (columnIndex10 < 0 || TextUtils.isEmpty(string4)) {
                                            i = i3;
                                        } else {
                                            pVar.zC(string4);
                                            i = i3 + string4.getBytes("UTF-8").length;
                                        }
                                        if (!TextUtils.isEmpty(rawQuery.getString(columnIndex11))) {
                                            try {
                                                if (new JSONObject(rawQuery.getString(columnIndex11)).has("ctr")) {
                                                    pVar.iq(true);
                                                }
                                            } catch (JSONException e8) {
                                                e8.printStackTrace();
                                            }
                                        }
                                        if (zp) {
                                            a(readableDatabase, pVar, ajVar);
                                            ajVar.aH(pVar.bgc(), Integer.parseInt(pVar.getId()));
                                            ajVar.OJ(i);
                                            if (ajVar.ejj()) {
                                                z = ejj2;
                                                z2 = true;
                                                if (r8 == false) {
                                                    r8 = true;
                                                }
                                                if (z2 && z) {
                                                    str3 = r8;
                                                    break;
                                                }
                                            }
                                            z = ejj2;
                                            z2 = ejj;
                                            if (r8 == false) {
                                            }
                                            if (z2) {
                                                str3 = r8;
                                                break;
                                            }
                                        } else {
                                            a(readableDatabase, pVar, ajVar2);
                                            ajVar2.aH(pVar.bgc(), Integer.parseInt(pVar.getId()));
                                            ajVar2.OJ(i);
                                            if (ajVar2.ejj()) {
                                                z = true;
                                                z2 = ejj;
                                                if (r8 == false) {
                                                }
                                                if (z2) {
                                                }
                                            }
                                            z = ejj2;
                                            z2 = ejj;
                                            if (r8 == false) {
                                            }
                                            if (z2) {
                                            }
                                        }
                                    } else {
                                        z = ejj2;
                                        z2 = ejj;
                                    }
                                } else {
                                    z = ejj2;
                                    z2 = ejj;
                                }
                            } else {
                                z = ejj2;
                                z2 = ejj;
                            }
                            if (!rawQuery.moveToNext()) {
                                break;
                            }
                            ejj = z2;
                            ejj2 = z;
                        }
                        Closeables.closeSafely(rawQuery);
                        str4 = str3;
                        return r6;
                    }
                }
                str3 = r8;
                Closeables.closeSafely(rawQuery);
                str4 = str3;
                return r6;
            } catch (Throwable th3) {
                cursor = null;
                r8 = " SELECT * FROM flow";
                th = th3;
            }
        } finally {
            this.oHz.readLock().unlock();
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase, p pVar, aj ajVar) {
        Cursor cursor = null;
        try {
            if (pVar.bgc() >= 0) {
                try {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", pVar.getId());
                        jSONObject.put(LogBuilder.KEY_START_TIME, Long.toString(pVar.bgj()));
                        jSONObject.put(LogBuilder.KEY_END_TIME, Long.toString(pVar.getEndTime()));
                        jSONObject.put("type", "1");
                        g eiL = g.eiL();
                        jSONObject.put("isreal", eiL.XG(pVar.getId()) ? "1" : "0");
                        String XH = eiL.XH(pVar.getId());
                        if (!TextUtils.isEmpty(XH) && !TextUtils.equals(XH, "0")) {
                            jSONObject.put("gflow", XH);
                        }
                        if (!TextUtils.isEmpty(pVar.getContent())) {
                            jSONObject.put("content", pVar.getContent());
                        }
                        if (!TextUtils.isEmpty(pVar.bgd())) {
                            jSONObject.put("abtest", pVar.bgd());
                            ajVar.zG("1");
                        }
                        if (!TextUtils.isEmpty(pVar.getCategory())) {
                            jSONObject.put("c", pVar.getCategory());
                        }
                        if (pVar.bgl() != null) {
                            jSONObject.put("part", pVar.bgl());
                        }
                        if (pVar.bfZ()) {
                            jSONObject.put(MapBundleKey.MapObjKey.OBJ_OFFSET, "1");
                        }
                        jSONObject.put("idtype", eiL.zv(pVar.getId()));
                        JSONArray jSONArray = new JSONArray();
                        StringBuilder sb = new StringBuilder(256);
                        sb.append("SELECT ").append("eventid").append(" , ").append("begintime").append(" , ").append("content").append(" FROM ").append("event").append(" WHERE ").append("flowhandle").append(" = ").append(pVar.bgc());
                        try {
                            cursor = sQLiteDatabase.rawQuery(sb.toString(), null);
                            if (cursor != null && cursor.getCount() > 0) {
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
                            Closeables.closeSafely(cursor);
                            ajVar.df(jSONObject);
                        } catch (Throwable th) {
                            Closeables.closeSafely(cursor);
                            throw th;
                        }
                    } catch (JSONException e) {
                        if (DEBUG) {
                            Log.d("UBCDatabaseHelper", "json exception:");
                        }
                    }
                } catch (RuntimeException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
            }
        } catch (SQLException e3) {
            if (DEBUG) {
                e3.printStackTrace();
            }
            this.oGs.B(e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(aj ajVar) {
        StringBuilder sb = new StringBuilder(256);
        sb.append("SELECT * FROM ").append("event").append(" WHERE ").append("flowhandle").append(" = ").append(-1).append(" AND ").append("reallog").append(" = \"1\"");
        return a(sb.toString(), ajVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [2201=5] */
    /* JADX WARN: Can't wrap try/catch for region: R(14:1|(4:2|3|4|(2:5|6))|(3:30|31|(12:33|(5:34|(18:67|(1:114)(2:71|72)|73|74|(1:108)(2:78|79)|80|(1:82)|83|(1:85)|86|(1:88)|89|(1:93)|94|(4:96|97|98|(1:100))|104|105|(1:107))(1:40)|41|42|(1:44)(1:45))|46|9|10|11|12|13|(1:15)|16|17|18))|8|9|10|11|12|13|(0)|16|17|18|(1:(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(17:1|2|3|4|(2:5|6)|(3:30|31|(12:33|(5:34|(18:67|(1:114)(2:71|72)|73|74|(1:108)(2:78|79)|80|(1:82)|83|(1:85)|86|(1:88)|89|(1:93)|94|(4:96|97|98|(1:100))|104|105|(1:107))(1:40)|41|42|(1:44)(1:45))|46|9|10|11|12|13|(1:15)|16|17|18))|8|9|10|11|12|13|(0)|16|17|18|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x024a, code lost:
        if (com.baidu.ubc.y.DEBUG != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x024c, code lost:
        r3.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x024f, code lost:
        r27.oGs.B(r3);
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
    private int b(String str, aj ajVar) {
        int i;
        ArrayList<p> arrayList;
        Cursor cursor;
        long j;
        long j2;
        Cursor cursor2;
        Cursor cursor3;
        long endTime;
        long bgj;
        String string;
        int i2;
        this.oHz.readLock().lock();
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
                this.oHz.readLock().unlock();
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
                        pVar.nH(cursor3.getInt(columnIndex2));
                        pVar.dw(cursor3.getLong(columnIndex4));
                        pVar.setEndTime(cursor3.getLong(columnIndex5));
                        endTime = (pVar.getEndTime() <= 0 || pVar.getEndTime() <= j2) ? j2 : pVar.getEndTime();
                        try {
                            bgj = (pVar.bgj() <= 0 || pVar.bgj() >= j) ? j : pVar.bgj();
                            String string2 = cursor3.getString(columnIndex6);
                            if (!TextUtils.isEmpty(string2)) {
                                pVar.setContent(string2);
                                this.mTotalLength = string2.getBytes("UTF-8").length + this.mTotalLength;
                            }
                            String string3 = cursor3.getString(columnIndex8);
                            if (!TextUtils.isEmpty(string3)) {
                                pVar.zB(string3);
                                this.mTotalLength = string3.getBytes("UTF-8").length + this.mTotalLength;
                            }
                            if (!TextUtils.isEmpty(cursor3.getString(columnIndex9))) {
                                pVar.setCategory(cursor3.getString(columnIndex9));
                            }
                            String string4 = cursor3.getString(columnIndex10);
                            if (columnIndex10 >= 0 && !TextUtils.isEmpty(string4)) {
                                pVar.zC(string4);
                                this.mTotalLength = string4.getBytes("UTF-8").length + this.mTotalLength;
                            }
                            if (!TextUtils.isEmpty(cursor3.getString(columnIndex11))) {
                                this.mTotalLength = string.getBytes("UTF-8").length + this.mTotalLength;
                                try {
                                    if (new JSONObject(cursor3.getString(columnIndex11)).has("ctr")) {
                                        pVar.iq(true);
                                    }
                                } catch (JSONException e7) {
                                    e7.printStackTrace();
                                }
                            }
                            arrayList.add(pVar);
                            ajVar.aH(pVar.bgc(), Integer.parseInt(pVar.getId()));
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
                            ajVar.r(j, j2);
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
                                ajVar.r(j, j2);
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
                        bgj = j;
                    }
                    try {
                        if (!cursor3.moveToNext()) {
                            break;
                        }
                        j = bgj;
                        j2 = endTime;
                    } catch (UnsupportedEncodingException e10) {
                        j = bgj;
                        j2 = endTime;
                        e = e10;
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                        Closeables.closeSafely(cursor3);
                        i = 0;
                        if (arrayList.size() > 0) {
                        }
                        ajVar.r(j, j2);
                        return i;
                    } catch (RuntimeException e11) {
                        j = bgj;
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
                        ajVar.r(j, j2);
                        return i;
                    }
                }
                j = bgj;
                j2 = endTime;
                i2 = 1;
                Closeables.closeSafely(cursor3);
                i = i2;
                if (arrayList.size() > 0) {
                    b(arrayList, ajVar);
                }
                ajVar.r(j, j2);
                return i;
            }
        }
        i2 = 0;
        Closeables.closeSafely(cursor3);
        i = i2;
        if (arrayList.size() > 0) {
        }
        ajVar.r(j, j2);
        return i;
    }

    private void b(ArrayList<p> arrayList, aj ajVar) {
        Cursor cursor;
        Cursor cursor2 = null;
        this.oHz.readLock().lock();
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            try {
                Iterator<p> it = arrayList.iterator();
                while (it.hasNext()) {
                    p next = it.next();
                    if (next.bgc() >= 0) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", next.getId());
                        jSONObject.put(LogBuilder.KEY_START_TIME, Long.toString(next.bgj()));
                        jSONObject.put(LogBuilder.KEY_END_TIME, Long.toString(next.getEndTime()));
                        jSONObject.put("type", "1");
                        g eiL = g.eiL();
                        jSONObject.put("isreal", eiL.XG(next.getId()) ? "1" : "0");
                        String XH = eiL.XH(next.getId());
                        if (!TextUtils.isEmpty(XH) && !TextUtils.equals(XH, "0")) {
                            jSONObject.put("gflow", XH);
                        }
                        if (!TextUtils.isEmpty(next.getContent())) {
                            jSONObject.put("content", next.getContent());
                        }
                        if (!TextUtils.isEmpty(next.bgd())) {
                            jSONObject.put("abtest", next.bgd());
                            ajVar.zG("1");
                        }
                        if (!TextUtils.isEmpty(next.getCategory())) {
                            jSONObject.put("c", next.getCategory());
                        }
                        if (next.bgl() != null) {
                            jSONObject.put("part", next.bgl());
                        }
                        if (next.bfZ()) {
                            jSONObject.put(MapBundleKey.MapObjKey.OBJ_OFFSET, "1");
                        }
                        jSONObject.put("idtype", eiL.zv(next.getId()));
                        JSONArray jSONArray = new JSONArray();
                        StringBuilder sb = new StringBuilder(256);
                        sb.append("SELECT ").append("eventid").append(" , ").append("begintime").append(" , ").append("content").append(" FROM ").append("event").append(" WHERE ").append("flowhandle").append(" = ").append(next.bgc());
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
                            ajVar.df(jSONObject);
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
            this.oGs.B(e3);
        } finally {
            this.oHz.readLock().unlock();
        }
    }

    private String d(ArrayList<j> arrayList, boolean z) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            j jVar = arrayList.get(i2);
            if (z && !"0".equals(jVar.getType())) {
                if (i > 0) {
                    sb.append(",");
                } else {
                    i++;
                }
                sb.append(jVar.getId());
            } else if (!z && "0".equals(jVar.getType())) {
                if (i > 0) {
                    sb.append(",");
                } else {
                    i++;
                }
                sb.append(jVar.getId());
            }
        }
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [2563=4, 2571=5] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean gB(List<k> list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        this.oHz.writeLock().lock();
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            StringBuilder sb = new StringBuilder();
            sb.append("replace into ").append("config").append("(").append("eventid").append(",").append("type").append(",").append("recordrule").append(",").append("uploadrule").append(",").append("cycle").append(",").append("switch").append(",").append("sample").append(",").append("reserve1").append(",").append("reserve2").append(",").append("extend").append(",").append("reallog").append(")").append(" values(?,?,?,?,?,?,?,?,?,?,?)");
            SQLiteStatement compileStatement = writableDatabase.compileStatement(sb.toString());
            writableDatabase.beginTransactionNonExclusive();
            try {
                for (k kVar : list) {
                    compileStatement.clearBindings();
                    compileStatement.bindString(1, kVar.getId());
                    compileStatement.bindString(2, kVar.getType());
                    if (kVar.bfW() != 0 && kVar.bfX() != 0) {
                        compileStatement.bindLong(3, kVar.bfW());
                        compileStatement.bindLong(4, kVar.bfX());
                    }
                    if ("1".equals(kVar.bfT())) {
                        compileStatement.bindLong(5, 0L);
                    } else {
                        compileStatement.bindLong(5, kVar.getTimeout());
                    }
                    compileStatement.bindString(6, kVar.bfS());
                    compileStatement.bindLong(7, kVar.bfV());
                    compileStatement.bindString(8, kVar.bfU());
                    if (!TextUtils.isEmpty(kVar.getCategory())) {
                        compileStatement.bindString(9, kVar.getCategory());
                    }
                    JSONObject jSONObject = new JSONObject();
                    if (TextUtils.equals(kVar.bfY(), "1")) {
                        jSONObject.put("idtype", "1");
                    }
                    if (TextUtils.equals(kVar.eiP(), "1")) {
                        jSONObject.put("ch", "1");
                    }
                    if (TextUtils.equals(kVar.eiQ(), "1")) {
                        jSONObject.put("dfc", "1");
                    }
                    if (kVar.getVersion() != null) {
                        jSONObject.put("version", kVar.getVersion());
                    }
                    String eiS = kVar.eiS();
                    if (!TextUtils.isEmpty(eiS) && !TextUtils.equals(eiS, "0")) {
                        jSONObject.put("gflow", eiS);
                    }
                    String eiT = kVar.eiT();
                    if (!TextUtils.isEmpty(eiT)) {
                        jSONObject.put("uploadType", eiT);
                    }
                    int eiU = kVar.eiU();
                    if (eiU != 2) {
                        jSONObject.put("lcache", eiU);
                    }
                    String jSONObject2 = jSONObject.toString();
                    if (!TextUtils.isEmpty(jSONObject2)) {
                        compileStatement.bindString(10, jSONObject2);
                    }
                    if (TextUtils.equals(kVar.eiR(), "1")) {
                        compileStatement.bindString(11, kVar.eiR());
                    } else {
                        compileStatement.bindString(11, "0");
                    }
                    if (compileStatement.executeUpdateDelete() <= 0) {
                        return false;
                    }
                }
                writableDatabase.setTransactionSuccessful();
                if (DEBUG) {
                    Log.d("UBCDatabaseHelper", "updateConfig success count: " + list.size());
                }
                return true;
            } catch (JSONException e) {
                if (DEBUG) {
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
            this.oGs.B(e2);
        } finally {
            this.oHz.writeLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int eja() {
        Cursor cursor = null;
        int i = 0;
        this.oHz.readLock().lock();
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("SELECT COUNT(").append("eventid").append(") FROM ").append("config");
                cursor = readableDatabase.rawQuery(sb.toString(), null);
                if (cursor != null) {
                    cursor.moveToFirst();
                    i = cursor.getInt(0);
                }
            } catch (SQLException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            } finally {
                Closeables.closeSafely(cursor);
            }
        } catch (SQLException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        } finally {
            this.oHz.readLock().unlock();
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HashMap<String, String> bp(ArrayList<String> arrayList) {
        Cursor cursor = null;
        this.oHz.readLock().lock();
        HashMap<String, String> hashMap = new HashMap<>();
        String w = w(arrayList);
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ").append("eventid").append(",").append("extend").append(" FROM ").append("config").append(" WHERE ").append("eventid").append(" in (").append(w).append(")");
        try {
            try {
                cursor = getReadableDatabase().rawQuery(sb.toString(), null);
            } catch (SQLiteException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            } finally {
                Closeables.closeSafely(cursor);
            }
        } catch (SQLException e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        } finally {
            this.oHz.readLock().unlock();
        }
        if (cursor != null && cursor.moveToFirst()) {
            do {
                String string = cursor.getString(cursor.getColumnIndex("eventid"));
                String string2 = cursor.getString(cursor.getColumnIndex("extend"));
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                    hashMap.put(string, string2);
                }
            } while (cursor.moveToNext());
            return hashMap;
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(SparseArray<Integer> sparseArray, ArrayList<String> arrayList, boolean z, String str) {
        boolean z2;
        SQLException e;
        this.oHz.writeLock().lock();
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
                            int delete2 = writableDatabase.delete("event", sb.toString(), null);
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
                    int delete3 = writableDatabase.delete("event", sb2.toString(), null);
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
                this.oHz.writeLock().unlock();
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
            this.oGs.B(e);
            return z2;
        }
        return z2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [2793=4] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public o XR(String str) {
        Cursor cursor;
        o oVar = null;
        this.oHz.readLock().lock();
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
            this.oGs.B(e3);
        } finally {
            this.oHz.readLock().unlock();
        }
        return oVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zk(String str) {
        this.oHz.writeLock().lock();
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
            this.oGs.B(e);
        } finally {
            this.oHz.writeLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bfw() {
        this.oHz.writeLock().lock();
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
            this.oGs.B(e);
        } finally {
            this.oHz.writeLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zl(String str) {
        this.oHz.writeLock().lock();
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
            this.oGs.B(e);
        } finally {
            this.oHz.writeLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dB(String str, String str2) {
        this.oHz.writeLock().lock();
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
            this.oGs.B(e);
        } finally {
            this.oHz.writeLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bfx() {
        this.oHz.writeLock().lock();
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
            this.oGs.B(e);
        } finally {
            this.oHz.writeLock().unlock();
        }
    }

    private String w(ArrayList arrayList) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append(arrayList.get(i));
        }
        return sb.toString();
    }
}
