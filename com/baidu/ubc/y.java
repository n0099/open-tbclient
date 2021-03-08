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
/* loaded from: classes5.dex */
public class y extends SQLiteOpenHelper {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static y oVU = null;
    private static ReentrantLock oVV = new ReentrantLock();
    private Context mContext;
    private long mTotalLength;
    private b oUM;
    private ReentrantReadWriteLock oVT;

    public static y hm(Context context) {
        if (oVU == null) {
            oVV.lock();
            if (oVU == null) {
                oVU = new y(context);
            }
            oVV.unlock();
        }
        return oVU;
    }

    private y(Context context) {
        super(context, "bdbehavior.db", (SQLiteDatabase.CursorFactory) null, 7);
        this.oVT = new ReentrantReadWriteLock(true);
        this.oUM = new b(context);
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
            ai.eij().putString("ubc_cloudconfig_version", "0");
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
                        an(sQLiteDatabase);
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

    private void an(SQLiteDatabase sQLiteDatabase) {
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
        this.oVT.writeLock().lock();
        try {
            ContentValues i = i(nVar);
            String beU = nVar.beU();
            String id = nVar.getId();
            int beV = nVar.beV();
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                if (a(beU, id, beV, writableDatabase)) {
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
            this.oUM.B(e);
        } finally {
            this.oVT.writeLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bc(List<n> list) {
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
    public boolean eib() {
        int i;
        this.oVT.writeLock().lock();
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
                        this.oUM.B(e);
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
            this.oUM.B(e3);
            return false;
        } finally {
            this.oVT.writeLock().unlock();
        }
    }

    private ContentValues i(n nVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("flowhandle", Integer.valueOf(nVar.beV()));
        contentValues.put("eventid", nVar.getId());
        contentValues.put("begintime", Long.valueOf(nVar.getTime()));
        if (!TextUtils.isEmpty(nVar.getContent())) {
            contentValues.put("content", nVar.getContent());
        } else if (nVar.beX() != null && !TextUtils.isEmpty(nVar.beX().toString())) {
            contentValues.put("content", nVar.beX().toString());
        }
        if (!TextUtils.isEmpty(nVar.beW())) {
            contentValues.put("reserve1", nVar.beW());
        }
        if (!TextUtils.isEmpty(nVar.getCategory())) {
            contentValues.put("reserve2", nVar.getCategory());
        }
        if (nVar.beS()) {
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
        if (!TextUtils.isEmpty(nVar.ehT())) {
            contentValues.put("reallog", nVar.ehT());
        } else {
            contentValues.put("reallog", "0");
        }
        return contentValues;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [693=5] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x020c A[Catch: all -> 0x0222, TryCatch #3 {all -> 0x0222, blocks: (B:3:0x0014, B:45:0x01b0, B:47:0x01b4, B:79:0x0208, B:81:0x020c, B:82:0x020f, B:59:0x01df, B:66:0x01ee, B:73:0x01fc, B:75:0x0202, B:76:0x0205), top: B:94:0x0014 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int a(String str, aj ajVar) {
        int i;
        long j;
        int i2;
        String string;
        this.oVT.readLock().lock();
        Cursor cursor = null;
        long j2 = Long.MAX_VALUE;
        long j3 = 0;
        try {
            try {
                try {
                    try {
                        try {
                            try {
                                cursor = getReadableDatabase().rawQuery(str, null);
                                if (cursor == null || cursor.getCount() <= 0) {
                                    j = 0;
                                    i2 = 0;
                                } else {
                                    cursor.moveToFirst();
                                    int columnIndex = cursor.getColumnIndex("eventid");
                                    int columnIndex2 = cursor.getColumnIndex("begintime");
                                    int columnIndex3 = cursor.getColumnIndex("content");
                                    int columnIndex4 = cursor.getColumnIndex("reserve1");
                                    int columnIndex5 = cursor.getColumnIndex("reserve2");
                                    int columnIndex6 = cursor.getColumnIndex("extend");
                                    do {
                                        JSONObject jSONObject = new JSONObject();
                                        String string2 = cursor.getString(columnIndex);
                                        jSONObject.put("id", string2);
                                        long j4 = cursor.getLong(columnIndex2);
                                        jSONObject.put("timestamp", Long.toString(j4));
                                        if (j4 > 0) {
                                            if (j4 < j2) {
                                                j2 = j4;
                                            }
                                            if (j4 > j3) {
                                                j3 = j4;
                                            }
                                        }
                                        jSONObject.put("type", "0");
                                        String string3 = cursor.getString(columnIndex3);
                                        if (!TextUtils.isEmpty(string3)) {
                                            jSONObject.put("content", string3);
                                            this.mTotalLength = string3.getBytes("UTF-8").length + this.mTotalLength;
                                        }
                                        String string4 = cursor.getString(columnIndex4);
                                        if (!TextUtils.isEmpty(string4)) {
                                            jSONObject.put("abtest", string4);
                                            ajVar.yU("1");
                                            this.mTotalLength = string4.getBytes("UTF-8").length + this.mTotalLength;
                                        }
                                        if (!TextUtils.isEmpty(cursor.getString(columnIndex5))) {
                                            jSONObject.put("c", cursor.getString(columnIndex5));
                                        }
                                        if (!TextUtils.isEmpty(cursor.getString(columnIndex6))) {
                                            if (new JSONObject(cursor.getString(columnIndex6)).has("ctr")) {
                                                jSONObject.put("of", "1");
                                            }
                                            this.mTotalLength = string.getBytes("UTF-8").length + this.mTotalLength;
                                        }
                                        g ehN = g.ehN();
                                        jSONObject.put("idtype", ehN.yJ(string2));
                                        jSONObject.put("isreal", ehN.Xz(string2) ? "1" : "0");
                                        String XA = ehN.XA(string2);
                                        if (!TextUtils.isEmpty(XA) && !TextUtils.equals(XA, "0")) {
                                            jSONObject.put("gflow", XA);
                                        }
                                        ajVar.dm(jSONObject);
                                        ajVar.yT(cursor.getString(columnIndex));
                                        if (this.mTotalLength >= 10485760) {
                                            break;
                                        }
                                    } while (cursor.moveToNext());
                                    j = j3;
                                    i2 = 1;
                                }
                            } catch (UnsupportedEncodingException e) {
                                j = j3;
                                if (DEBUG) {
                                    e.printStackTrace();
                                }
                                Closeables.closeSafely(cursor);
                                i = 0;
                            }
                        } catch (RuntimeException e2) {
                            j = j3;
                            if (DEBUG) {
                                e2.printStackTrace();
                            }
                            Closeables.closeSafely(cursor);
                            i = 0;
                        }
                        try {
                            Closeables.closeSafely(cursor);
                            i = i2;
                        } catch (SQLException e3) {
                            e = e3;
                            i = i2;
                            if (DEBUG) {
                                e.printStackTrace();
                            }
                            this.oUM.B(e);
                            return i;
                        }
                    } catch (Throwable th) {
                        Closeables.closeSafely(cursor);
                        throw th;
                    }
                } catch (JSONException e4) {
                    long j5 = j3;
                    if (DEBUG) {
                        Log.d("UBCDatabaseHelper", "json exception:");
                    }
                    Closeables.closeSafely(cursor);
                    j = j5;
                    i = 0;
                }
            } finally {
                this.oVT.readLock().unlock();
            }
        } catch (SQLException e5) {
            e = e5;
            i = 0;
        }
        try {
            ajVar.y(j2, j);
        } catch (SQLException e6) {
            e = e6;
            if (DEBUG) {
            }
            this.oUM.B(e);
            return i;
        }
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
        this.oVT.writeLock().lock();
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("flowid", pVar.getId());
                contentValues.put("flowhandle", Integer.valueOf(pVar.beV()));
                contentValues.put("state", pVar.bfd());
                contentValues.put("begintime", Long.valueOf(pVar.bfc()));
                if (pVar.beX() != null) {
                    contentValues.put("content", pVar.beX().toString());
                } else {
                    contentValues.put("content", pVar.getContent());
                }
                contentValues.put("option", Integer.valueOf(pVar.getOption()));
                contentValues.put("reserve1", pVar.beW());
                if (!TextUtils.isEmpty(pVar.getCategory())) {
                    contentValues.put("reserve2", pVar.getCategory());
                }
                if (pVar.beS()) {
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
            this.oUM.B(e2);
        } finally {
            this.oVT.writeLock().unlock();
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
        this.oVT.writeLock().lock();
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
            this.oUM.B(e);
        } finally {
            this.oVT.writeLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P(String str, int i) {
        if (i < 0 || TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.d("UBCDatabaseHelper", "cancelFlow#flowHandle invalid");
                return;
            }
            return;
        }
        this.oVT.writeLock().lock();
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
            this.oUM.B(e);
        } finally {
            this.oVT.writeLock().unlock();
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
        this.oVT.writeLock().lock();
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
            this.oUM.B(e);
        } finally {
            this.oVT.writeLock().unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1005=4] */
    private boolean a(String str, String str2, int i, SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        boolean z = false;
        this.oVT.writeLock().lock();
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
                        } catch (RuntimeException e) {
                            if (DEBUG) {
                                e.printStackTrace();
                            }
                        } catch (SQLException e2) {
                            if (DEBUG) {
                                e2.printStackTrace();
                            }
                            this.oUM.B(e2);
                        } finally {
                            Closeables.closeSafely(cursor);
                        }
                    } catch (SQLException e3) {
                        e = e3;
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                        this.oUM.B(e);
                        return z;
                    }
                }
            } catch (SQLException e4) {
                e = e4;
                z = true;
            }
            return z;
        } finally {
            this.oVT.writeLock().unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1100=4] */
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x013b A[Catch: all -> 0x01d2, TryCatch #8 {all -> 0x01d2, blocks: (B:9:0x0076, B:11:0x007a, B:12:0x0094, B:20:0x0132, B:22:0x013b, B:24:0x013f, B:25:0x015d, B:13:0x0106, B:15:0x0111, B:17:0x0117, B:18:0x011a), top: B:80:0x0076 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01dd A[Catch: all -> 0x022f, TryCatch #7 {all -> 0x022f, blocks: (B:28:0x019b, B:43:0x01d9, B:45:0x01dd, B:46:0x01e0, B:40:0x01d4, B:41:0x01d7), top: B:76:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0241  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void beo() {
        int i;
        int i2 = 0;
        this.oVT.writeLock().lock();
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    long currentTimeMillis = System.currentTimeMillis() - g.ehN().beH();
                    int delete = writableDatabase.delete("flow", "endtime < " + currentTimeMillis, null);
                    try {
                        if (DEBUG) {
                            Log.d("UBCDatabaseHelper", "clearInvalidData: delete flow count:" + delete);
                        }
                        int delete2 = writableDatabase.delete("event", "begintime < " + currentTimeMillis, null);
                        try {
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
                                if (arrayList.size() <= 0) {
                                }
                                writableDatabase.setTransactionSuccessful();
                                writableDatabase.endTransaction();
                                yw("flow");
                                yw("event");
                                this.oVT.writeLock().unlock();
                                if (delete <= 0) {
                                }
                                ac.eif().h(String.valueOf(g.ehN().beH()), delete, delete2, i);
                            }
                            Closeables.closeSafely(rawQuery);
                            if (arrayList.size() <= 0) {
                                if (DEBUG) {
                                    Log.d("UBCDatabaseHelper", "clearInvalidData: delete flow count2:" + arrayList.size());
                                }
                                i = arrayList.size();
                                try {
                                    String r = r(arrayList);
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("flowhandle").append(" in (").append(r).append(")");
                                    writableDatabase.delete("flow", sb2.toString(), null);
                                    writableDatabase.delete("event", sb2.toString(), null);
                                } catch (Throwable th2) {
                                    th = th2;
                                    writableDatabase.endTransaction();
                                    throw th;
                                }
                            } else {
                                i = 0;
                            }
                            writableDatabase.setTransactionSuccessful();
                            writableDatabase.endTransaction();
                            yw("flow");
                            yw("event");
                            this.oVT.writeLock().unlock();
                            if (delete <= 0 || delete2 > 0 || i > 0) {
                                ac.eif().h(String.valueOf(g.ehN().beH()), delete, delete2, i);
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (SQLException e) {
                e = e;
                if (DEBUG) {
                    e.printStackTrace();
                }
                this.oUM.B(e);
                this.oVT.writeLock().unlock();
                if (0 <= 0 || 0 > 0 || i2 > 0) {
                    ac.eif().h(String.valueOf(g.ehN().beH()), 0, 0, i2);
                }
            }
        } catch (SQLException e2) {
            e = e2;
            i2 = 0;
            if (DEBUG) {
            }
            this.oUM.B(e);
            this.oVT.writeLock().unlock();
            if (0 <= 0) {
            }
            ac.eif().h(String.valueOf(g.ehN().beH()), 0, 0, i2);
        } catch (Throwable th6) {
            th = th6;
            i2 = 0;
            this.oVT.writeLock().unlock();
            if (0 > 0 || 0 > 0 || i2 > 0) {
                ac.eif().h(String.valueOf(g.ehN().beH()), 0, 0, i2);
            }
            throw th;
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
    private void yw(String str) {
        int i;
        int delete;
        int i2 = 0;
        Cursor cursor = null;
        int i3 = 0;
        this.oVT.writeLock().lock();
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
                                if (cursor.getInt(0) > g.ehN().beI()) {
                                    i = (cursor.getInt(1) + cursor.getInt(2)) / 2;
                                    Closeables.closeSafely(cursor);
                                    delete = writableDatabase.delete(str, "_id < " + i, null);
                                    if (DEBUG) {
                                        Log.d("UBCDatabaseHelper", "ensureDataBaseLimit#performTransaction: delete count:" + delete);
                                    }
                                    writableDatabase.setTransactionSuccessful();
                                    writableDatabase.endTransaction();
                                    this.oVT.writeLock().unlock();
                                    if (delete <= 0) {
                                        ac.eif().x(String.valueOf(g.ehN().beI()), delete, str);
                                        return;
                                    }
                                    return;
                                }
                            }
                            if (DEBUG) {
                            }
                            writableDatabase.setTransactionSuccessful();
                            writableDatabase.endTransaction();
                            this.oVT.writeLock().unlock();
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
                    this.oVT.writeLock().unlock();
                    if (i3 > 0) {
                        ac.eif().x(String.valueOf(g.ehN().beI()), i3, str);
                    }
                    throw th;
                }
            } catch (SQLException e2) {
                e = e2;
                if (DEBUG) {
                    e.printStackTrace();
                }
                this.oUM.B(e);
                this.oVT.writeLock().unlock();
                if (i2 <= 0) {
                    ac.eif().x(String.valueOf(g.ehN().beI()), i2, str);
                }
            }
        } catch (SQLException e3) {
            e = e3;
            i2 = 0;
            if (DEBUG) {
            }
            this.oUM.B(e);
            this.oVT.writeLock().unlock();
            if (i2 <= 0) {
            }
        } catch (Throwable th4) {
            th = th4;
            i3 = 0;
            this.oVT.writeLock().unlock();
            if (i3 > 0) {
            }
            throw th;
        }
    }

    public void a(f fVar) {
        Cursor cursor = null;
        this.oVT.readLock().lock();
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
                        fVar.oVm.add(string);
                    } else if (TextUtils.equals(string2, "1")) {
                        fVar.oVp.add(string);
                    }
                    if (i2 == 0) {
                        fVar.oVn.add(string);
                    }
                    if (TextUtils.equals(string3, "1")) {
                        fVar.oVo.add(string);
                    }
                    if (i > 0) {
                        fVar.oVr.put(string, String.valueOf(i));
                    }
                    if (!TextUtils.isEmpty(string4)) {
                        fVar.oVs.put(string, string4);
                    }
                    if (i3 != 0 && i4 != 0) {
                        fVar.oVt.put(string, new m(string, i4, i3));
                    }
                    if (!TextUtils.isEmpty(string5)) {
                        try {
                            JSONObject jSONObject = new JSONObject(string5);
                            if (jSONObject.has("idtype")) {
                                fVar.oVu.add(string);
                            }
                            if (jSONObject.has("ch") && TextUtils.equals(jSONObject.getString("ch"), "1")) {
                                fVar.oVq.add(string);
                            }
                            if (jSONObject.has("gflow")) {
                                String string7 = jSONObject.getString("gflow");
                                if (!TextUtils.equals(string7, "0")) {
                                    fVar.oVw.put(string, string7);
                                }
                            }
                            if (jSONObject.has("uploadType")) {
                                String string8 = jSONObject.getString("uploadType");
                                if (!TextUtils.isEmpty(string8)) {
                                    fVar.oVx.put(string, string8);
                                }
                            }
                            int optInt = jSONObject.optInt("lcache", 2);
                            if (optInt == 1 || optInt == 0) {
                                fVar.oVy.put(string, Integer.valueOf(optInt));
                            }
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (TextUtils.equals(string6, "1")) {
                        fVar.oVv.add(string);
                    }
                } while (cursor.moveToNext());
            }
        } catch (SQLException e3) {
            if (DEBUG) {
                e3.printStackTrace();
            }
            this.oUM.B(e3);
        } finally {
            this.oVT.readLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00cf A[Catch: RuntimeException -> 0x00fe, all -> 0x0121, Merged into TryCatch #0 {all -> 0x0121, RuntimeException -> 0x00fe, blocks: (B:4:0x0093, B:6:0x009e, B:8:0x00a4, B:9:0x00bc, B:14:0x00cf, B:16:0x00d7, B:17:0x00df, B:18:0x00e7, B:26:0x00ff, B:28:0x0103), top: B:44:0x0093 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(SparseArray<ArrayList> sparseArray) {
        int i;
        Cursor cursor = null;
        this.oVT.readLock().lock();
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
            this.oUM.B(e2);
        } finally {
            this.oVT.readLock().unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1446=5, 1454=4] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public k XI(String str) {
        Cursor cursor;
        Cursor cursor2;
        this.oVT.readLock().lock();
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
                                        kVar.XE(optString);
                                    }
                                    String optString2 = jSONObject.optString("version");
                                    if (!TextUtils.isEmpty(optString2)) {
                                        kVar.setVersion(optString2);
                                    }
                                    String optString3 = jSONObject.optString("uploadType");
                                    if (!TextUtils.isEmpty(optString3)) {
                                        kVar.XH(optString3);
                                    }
                                    int optInt = jSONObject.optInt("lcache", 2);
                                    if (optInt == 1 || optInt == 0) {
                                        kVar.Nn(optInt);
                                    }
                                } catch (JSONException e) {
                                    if (DEBUG) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                            String string4 = cursor.getString(cursor.getColumnIndex("reallog"));
                            if (!TextUtils.isEmpty(string4)) {
                                kVar.XF(string4);
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
            this.oUM.B(e4);
        } finally {
            this.oVT.readLock().unlock();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1524=4] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean XJ(String str) {
        Cursor cursor = null;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ").append("config").append(" WHERE ").append("eventid").append("=\"").append(str).append("\"");
        this.oVT.writeLock().lock();
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
                this.oVT.writeLock().unlock();
                return z;
            } finally {
                Closeables.closeSafely(cursor);
                writableDatabase.endTransaction();
            }
        } catch (SQLException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            this.oUM.B(e);
            return false;
        } finally {
            this.oVT.writeLock().unlock();
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
        if (ajVar.eil() && ajVar2.eil()) {
            return 1;
        }
        return c | b(ajVar, ajVar2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1764=4] */
    private int b(aj ajVar, aj ajVar2) {
        int i;
        this.oVT.readLock().lock();
        int i2 = 0;
        try {
            boolean eil = ajVar.eil();
            boolean eil2 = ajVar2.eil();
            Cursor cursor = null;
            try {
                try {
                    try {
                        try {
                            cursor = getReadableDatabase().rawQuery("SELECT * FROM event WHERE flowhandle = -1 AND reallog = \"0\"", null);
                            if (cursor != null && cursor.getCount() > 0) {
                                cursor.moveToFirst();
                                int columnIndex = cursor.getColumnIndex("eventid");
                                int columnIndex2 = cursor.getColumnIndex("begintime");
                                int columnIndex3 = cursor.getColumnIndex("content");
                                int columnIndex4 = cursor.getColumnIndex("reserve1");
                                int columnIndex5 = cursor.getColumnIndex("reserve2");
                                int columnIndex6 = cursor.getColumnIndex("extend");
                                do {
                                    String string = cursor.getString(columnIndex);
                                    boolean yD = g.ehN().yD(string);
                                    if (!eil || !eil2) {
                                        if ((!eil || !yD) && (!eil2 || yD)) {
                                            int i3 = 0;
                                            JSONObject jSONObject = new JSONObject();
                                            jSONObject.put("id", string);
                                            long j = cursor.getLong(columnIndex2);
                                            jSONObject.put("timestamp", Long.toString(j));
                                            if (j > 0) {
                                                if (yD) {
                                                    if (ajVar.bfx() == 0 || j < ajVar.bfx()) {
                                                        ajVar.y(j, 0L);
                                                    }
                                                    if (j > ajVar.getMaxTime()) {
                                                        ajVar.y(0L, j);
                                                    }
                                                } else {
                                                    if (ajVar2.bfx() == 0 || j < ajVar2.bfx()) {
                                                        ajVar2.y(j, 0L);
                                                    }
                                                    if (j > ajVar2.getMaxTime()) {
                                                        ajVar2.y(0L, j);
                                                    }
                                                }
                                            }
                                            jSONObject.put("type", "0");
                                            String string2 = cursor.getString(columnIndex3);
                                            if (!TextUtils.isEmpty(string2)) {
                                                jSONObject.put("content", string2);
                                                i3 = 0 + string2.getBytes("UTF-8").length;
                                            }
                                            String string3 = cursor.getString(columnIndex4);
                                            if (TextUtils.isEmpty(string3)) {
                                                i = i3;
                                            } else {
                                                jSONObject.put("abtest", string3);
                                                if (yD) {
                                                    ajVar.yU("1");
                                                } else {
                                                    ajVar2.yU("1");
                                                }
                                                i = i3 + string3.getBytes("UTF-8").length;
                                            }
                                            String string4 = cursor.getString(columnIndex5);
                                            if (!TextUtils.isEmpty(string4)) {
                                                jSONObject.put("c", string4);
                                            }
                                            String string5 = cursor.getString(columnIndex6);
                                            if (!TextUtils.isEmpty(string5) && new JSONObject(string5).has("ctr")) {
                                                jSONObject.put("of", "1");
                                            }
                                            g ehN = g.ehN();
                                            jSONObject.put("idtype", ehN.yJ(string));
                                            jSONObject.put("isreal", ehN.Xz(string) ? "1" : "0");
                                            String XA = ehN.XA(string);
                                            if (!TextUtils.isEmpty(XA) && !TextUtils.equals(XA, "0")) {
                                                jSONObject.put("gflow", XA);
                                            }
                                            if (yD) {
                                                ajVar.dm(jSONObject);
                                                ajVar.yT(string);
                                                ajVar.Ns(i);
                                                if (ajVar.eil()) {
                                                    eil = true;
                                                }
                                            } else {
                                                ajVar2.dm(jSONObject);
                                                ajVar2.yT(string);
                                                ajVar2.Ns(i);
                                                if (ajVar2.eil()) {
                                                    eil2 = true;
                                                }
                                            }
                                            if (i2 == 0) {
                                                i2 = 1;
                                            }
                                            if (eil && eil2) {
                                                break;
                                            }
                                        }
                                    } else {
                                        break;
                                    }
                                } while (cursor.moveToNext());
                            }
                            Closeables.closeSafely(cursor);
                        } catch (UnsupportedEncodingException e) {
                            if (DEBUG) {
                                e.printStackTrace();
                            }
                            Closeables.closeSafely(cursor);
                        }
                    } catch (RuntimeException e2) {
                        if (DEBUG) {
                            e2.printStackTrace();
                        }
                        Closeables.closeSafely(cursor);
                    }
                } catch (JSONException e3) {
                    if (DEBUG) {
                        Log.d("UBCDatabaseHelper", "json exception:");
                    }
                    Closeables.closeSafely(cursor);
                }
            } catch (Throwable th) {
                Closeables.closeSafely(cursor);
                throw th;
            }
        } catch (SQLException e4) {
            if (DEBUG) {
                e4.printStackTrace();
            }
            this.oUM.B(e4);
        } finally {
            this.oVT.readLock().unlock();
        }
        return i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1954=5] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:142:0x007a */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v16, types: [java.lang.String] */
    private int c(aj ajVar, aj ajVar2) {
        int i;
        int i2;
        this.oVT.readLock().lock();
        int i3 = 0;
        try {
            try {
                boolean eil = ajVar.eil();
                boolean eil2 = ajVar2.eil();
                Cursor cursor = null;
                SQLiteDatabase readableDatabase = getReadableDatabase();
                try {
                    try {
                        cursor = readableDatabase.rawQuery(" SELECT * FROM flow", null);
                        if (cursor != null && cursor.getCount() > 0) {
                            cursor.moveToFirst();
                            int columnIndex = cursor.getColumnIndex("flowid");
                            int columnIndex2 = cursor.getColumnIndex("flowhandle");
                            int columnIndex3 = cursor.getColumnIndex("state");
                            int columnIndex4 = cursor.getColumnIndex("begintime");
                            int columnIndex5 = cursor.getColumnIndex(LogBuilder.KEY_END_TIME);
                            int columnIndex6 = cursor.getColumnIndex("content");
                            int columnIndex7 = cursor.getColumnIndex("option");
                            int columnIndex8 = cursor.getColumnIndex("reserve1");
                            int columnIndex9 = cursor.getColumnIndex("reserve2");
                            int columnIndex10 = cursor.getColumnIndex("slot");
                            int columnIndex11 = cursor.getColumnIndex("extend");
                            int i4 = "extend";
                            while (true) {
                                try {
                                    i4 = i3;
                                    if ("2".equals(cursor.getString(columnIndex3)) || (Math.abs(cursor.getLong(columnIndex4) - System.currentTimeMillis()) > 86400000 && (cursor.getInt(columnIndex7) & 4) != 0)) {
                                        String string = cursor.getString(columnIndex);
                                        int i5 = cursor.getInt(columnIndex2);
                                        if (i5 >= 0) {
                                            boolean yD = g.ehN().yD(string);
                                            if (eil && eil2) {
                                                i3 = i4;
                                                break;
                                            } else if (eil && yD) {
                                                i3 = i4;
                                            } else if (!eil2 || yD) {
                                                int i6 = 0;
                                                p pVar = new p();
                                                pVar.setId(cursor.getString(columnIndex));
                                                pVar.mo(i5);
                                                pVar.dC(cursor.getLong(columnIndex4));
                                                pVar.setEndTime(cursor.getLong(columnIndex5));
                                                if (yD) {
                                                    if (pVar.getEndTime() > 0 && pVar.getEndTime() > ajVar.getMaxTime()) {
                                                        ajVar.y(0L, pVar.getEndTime());
                                                    }
                                                    if (pVar.bfc() > 0 && (ajVar.bfx() == 0 || pVar.bfc() < ajVar.bfx())) {
                                                        ajVar.y(pVar.bfc(), 0L);
                                                    }
                                                } else {
                                                    if (pVar.getEndTime() > 0 && pVar.getEndTime() > ajVar2.getMaxTime()) {
                                                        ajVar2.y(0L, pVar.getEndTime());
                                                    }
                                                    if (pVar.bfc() > 0 && (ajVar2.bfx() == 0 || pVar.bfc() < ajVar2.bfx())) {
                                                        ajVar2.y(pVar.bfc(), 0L);
                                                    }
                                                }
                                                String string2 = cursor.getString(columnIndex6);
                                                if (!TextUtils.isEmpty(string2)) {
                                                    pVar.setContent(string2);
                                                    i6 = 0 + string2.getBytes("UTF-8").length;
                                                }
                                                String string3 = cursor.getString(columnIndex8);
                                                if (!TextUtils.isEmpty(string3)) {
                                                    pVar.yP(string3);
                                                    i6 += string3.getBytes("UTF-8").length;
                                                }
                                                if (!TextUtils.isEmpty(cursor.getString(columnIndex9))) {
                                                    pVar.setCategory(cursor.getString(columnIndex9));
                                                }
                                                String string4 = cursor.getString(columnIndex10);
                                                if (columnIndex10 < 0 || TextUtils.isEmpty(string4)) {
                                                    i2 = i6;
                                                } else {
                                                    pVar.yQ(string4);
                                                    i2 = i6 + string4.getBytes("UTF-8").length;
                                                }
                                                if (!TextUtils.isEmpty(cursor.getString(columnIndex11))) {
                                                    try {
                                                        if (new JSONObject(cursor.getString(columnIndex11)).has("ctr")) {
                                                            pVar.iJ(true);
                                                        }
                                                    } catch (JSONException e) {
                                                        e.printStackTrace();
                                                    }
                                                }
                                                if (yD) {
                                                    a(readableDatabase, pVar, ajVar);
                                                    ajVar.aB(pVar.beV(), Integer.parseInt(pVar.getId()));
                                                    ajVar.Ns(i2);
                                                    if (ajVar.eil()) {
                                                        eil = true;
                                                    }
                                                } else {
                                                    a(readableDatabase, pVar, ajVar2);
                                                    ajVar2.aB(pVar.beV(), Integer.parseInt(pVar.getId()));
                                                    ajVar2.Ns(i2);
                                                    if (ajVar2.eil()) {
                                                        eil2 = true;
                                                    }
                                                }
                                                i3 = i4 == 0 ? 1 : i4;
                                                if (eil && eil2) {
                                                    break;
                                                }
                                            } else {
                                                i3 = i4;
                                            }
                                        } else {
                                            i3 = i4;
                                        }
                                    } else {
                                        i3 = i4;
                                    }
                                    boolean moveToNext = cursor.moveToNext();
                                    if (!moveToNext) {
                                        break;
                                    }
                                    i4 = moveToNext;
                                } catch (UnsupportedEncodingException e2) {
                                    e = e2;
                                    i3 = i4;
                                    if (DEBUG) {
                                        e.printStackTrace();
                                    }
                                    Closeables.closeSafely(cursor);
                                    return i3;
                                } catch (RuntimeException e3) {
                                    e = e3;
                                    i3 = i4;
                                    if (DEBUG) {
                                        e.printStackTrace();
                                    }
                                    Closeables.closeSafely(cursor);
                                    return i3;
                                } catch (Throwable th) {
                                    th = th;
                                    i = i4;
                                    try {
                                        Closeables.closeSafely(cursor);
                                        throw th;
                                    } catch (SQLException e4) {
                                        e = e4;
                                        i3 = i;
                                        if (DEBUG) {
                                            e.printStackTrace();
                                        }
                                        this.oUM.B(e);
                                        return i3;
                                    }
                                }
                            }
                        }
                        Closeables.closeSafely(cursor);
                    } catch (Throwable th2) {
                        th = th2;
                        i = 0;
                    }
                } catch (UnsupportedEncodingException e5) {
                    e = e5;
                } catch (RuntimeException e6) {
                    e = e6;
                }
            } catch (SQLException e7) {
                e = e7;
            }
            return i3;
        } finally {
            this.oVT.readLock().unlock();
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase, p pVar, aj ajVar) {
        Cursor cursor = null;
        try {
            if (pVar.beV() >= 0) {
                try {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", pVar.getId());
                        jSONObject.put(LogBuilder.KEY_START_TIME, Long.toString(pVar.bfc()));
                        jSONObject.put(LogBuilder.KEY_END_TIME, Long.toString(pVar.getEndTime()));
                        jSONObject.put("type", "1");
                        g ehN = g.ehN();
                        jSONObject.put("isreal", ehN.Xz(pVar.getId()) ? "1" : "0");
                        String XA = ehN.XA(pVar.getId());
                        if (!TextUtils.isEmpty(XA) && !TextUtils.equals(XA, "0")) {
                            jSONObject.put("gflow", XA);
                        }
                        if (!TextUtils.isEmpty(pVar.getContent())) {
                            jSONObject.put("content", pVar.getContent());
                        }
                        if (!TextUtils.isEmpty(pVar.beW())) {
                            jSONObject.put("abtest", pVar.beW());
                            ajVar.yU("1");
                        }
                        if (!TextUtils.isEmpty(pVar.getCategory())) {
                            jSONObject.put("c", pVar.getCategory());
                        }
                        if (pVar.bfe() != null) {
                            jSONObject.put("part", pVar.bfe());
                        }
                        if (pVar.beS()) {
                            jSONObject.put("of", "1");
                        }
                        jSONObject.put("idtype", ehN.yJ(pVar.getId()));
                        JSONArray jSONArray = new JSONArray();
                        StringBuilder sb = new StringBuilder(256);
                        sb.append("SELECT ").append("eventid").append(" , ").append("begintime").append(" , ").append("content").append(" FROM ").append("event").append(" WHERE ").append("flowhandle").append(" = ").append(pVar.beV());
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
                            ajVar.dm(jSONObject);
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
            this.oUM.B(e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(aj ajVar) {
        StringBuilder sb = new StringBuilder(256);
        sb.append("SELECT * FROM ").append("event").append(" WHERE ").append("flowhandle").append(" = ").append(-1).append(" AND ").append("reallog").append(" = \"1\"");
        return a(sb.toString(), ajVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [2201=5] */
    /* JADX WARN: Can't wrap try/catch for region: R(15:2|3|4|(2:5|6)|(3:30|31|(13:33|34|(6:35|36|(18:63|(1:110)(2:67|68)|69|70|(1:104)(2:74|75)|76|(1:78)|79|(1:81)|82|(1:84)|85|(1:89)|90|(4:92|93|94|(1:96))|100|101|(1:103))(1:42)|43|44|(1:46)(1:47))|48|9|10|11|12|13|(1:15)|16|17|18))|8|9|10|11|12|13|(0)|16|17|18) */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0242, code lost:
        if (com.baidu.ubc.y.DEBUG != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0244, code lost:
        r3.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0247, code lost:
        r26.oUM.B(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0267, code lost:
        r3 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0268, code lost:
        r2 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x026a, code lost:
        r3 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01f0 A[Catch: all -> 0x025a, SQLException -> 0x026a, TryCatch #12 {SQLException -> 0x026a, blocks: (B:55:0x01ea, B:57:0x01f0, B:58:0x01f7), top: B:126:0x01ea }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0214 A[Catch: all -> 0x026c, TRY_LEAVE, TryCatch #4 {all -> 0x026c, blocks: (B:7:0x0026, B:9:0x002c, B:11:0x007d, B:13:0x008c, B:15:0x00a2, B:72:0x021e, B:17:0x00ac, B:19:0x00e3, B:21:0x00eb, B:23:0x00f0, B:25:0x00fa, B:27:0x0102, B:29:0x0107, B:31:0x0113, B:32:0x012a, B:34:0x0136, B:35:0x014d, B:37:0x0159, B:38:0x0164, B:40:0x016c, B:42:0x0172, B:43:0x0189, B:45:0x0195, B:46:0x01a7, B:48:0x01bb, B:62:0x0209, B:49:0x01c1, B:66:0x0210, B:68:0x0214, B:77:0x022c, B:79:0x0230), top: B:123:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0230 A[Catch: all -> 0x026c, TRY_LEAVE, TryCatch #4 {all -> 0x026c, blocks: (B:7:0x0026, B:9:0x002c, B:11:0x007d, B:13:0x008c, B:15:0x00a2, B:72:0x021e, B:17:0x00ac, B:19:0x00e3, B:21:0x00eb, B:23:0x00f0, B:25:0x00fa, B:27:0x0102, B:29:0x0107, B:31:0x0113, B:32:0x012a, B:34:0x0136, B:35:0x014d, B:37:0x0159, B:38:0x0164, B:40:0x016c, B:42:0x0172, B:43:0x0189, B:45:0x0195, B:46:0x01a7, B:48:0x01bb, B:62:0x0209, B:49:0x01c1, B:66:0x0210, B:68:0x0214, B:77:0x022c, B:79:0x0230), top: B:123:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0244 A[Catch: all -> 0x025a, TryCatch #15 {all -> 0x025a, blocks: (B:3:0x000c, B:53:0x01e6, B:55:0x01ea, B:57:0x01f0, B:58:0x01f7, B:87:0x0240, B:89:0x0244, B:90:0x0247, B:69:0x0217, B:80:0x0233, B:83:0x023a, B:84:0x023d), top: B:122:0x000c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int b(String str, aj ajVar) {
        int i;
        ArrayList<p> arrayList;
        long j;
        RuntimeException e;
        long j2;
        Cursor cursor;
        UnsupportedEncodingException e2;
        long endTime;
        long bfc;
        String string;
        int i2;
        this.oVT.readLock().lock();
        try {
            try {
                arrayList = new ArrayList<>();
                j = Long.MAX_VALUE;
                try {
                    try {
                        cursor = getReadableDatabase().rawQuery(str, null);
                    } catch (Throwable th) {
                        th = th;
                        Closeables.closeSafely((Cursor) null);
                        throw th;
                    }
                } catch (UnsupportedEncodingException e3) {
                    e2 = e3;
                    j2 = 0;
                    cursor = null;
                } catch (RuntimeException e4) {
                    e = e4;
                    j2 = 0;
                    cursor = null;
                } catch (Throwable th2) {
                    th = th2;
                    Closeables.closeSafely((Cursor) null);
                    throw th;
                }
            } catch (SQLException e5) {
                e = e5;
                i = 0;
            }
            if (cursor != null) {
                try {
                } catch (UnsupportedEncodingException e6) {
                    e2 = e6;
                    j2 = 0;
                } catch (RuntimeException e7) {
                    e = e7;
                    j2 = 0;
                }
                if (cursor.getCount() > 0) {
                    cursor.moveToFirst();
                    int columnIndex = cursor.getColumnIndex("flowid");
                    int columnIndex2 = cursor.getColumnIndex("flowhandle");
                    int columnIndex3 = cursor.getColumnIndex("state");
                    int columnIndex4 = cursor.getColumnIndex("begintime");
                    int columnIndex5 = cursor.getColumnIndex(LogBuilder.KEY_END_TIME);
                    int columnIndex6 = cursor.getColumnIndex("content");
                    int columnIndex7 = cursor.getColumnIndex("option");
                    int columnIndex8 = cursor.getColumnIndex("reserve1");
                    int columnIndex9 = cursor.getColumnIndex("reserve2");
                    int columnIndex10 = cursor.getColumnIndex("slot");
                    int columnIndex11 = cursor.getColumnIndex("extend");
                    j2 = 0;
                    while (true) {
                        try {
                            if ("2".equals(cursor.getString(columnIndex3)) || (Math.abs(cursor.getLong(columnIndex4) - System.currentTimeMillis()) > 86400000 && (cursor.getInt(columnIndex7) & 4) != 0)) {
                                p pVar = new p();
                                pVar.setId(cursor.getString(columnIndex));
                                pVar.mo(cursor.getInt(columnIndex2));
                                pVar.dC(cursor.getLong(columnIndex4));
                                pVar.setEndTime(cursor.getLong(columnIndex5));
                                endTime = (pVar.getEndTime() <= 0 || pVar.getEndTime() <= j2) ? j2 : pVar.getEndTime();
                                try {
                                    bfc = (pVar.bfc() <= 0 || pVar.bfc() >= j) ? j : pVar.bfc();
                                    String string2 = cursor.getString(columnIndex6);
                                    if (!TextUtils.isEmpty(string2)) {
                                        pVar.setContent(string2);
                                        this.mTotalLength += string2.getBytes("UTF-8").length;
                                    }
                                    String string3 = cursor.getString(columnIndex8);
                                    if (!TextUtils.isEmpty(string3)) {
                                        pVar.yP(string3);
                                        this.mTotalLength += string3.getBytes("UTF-8").length;
                                    }
                                    if (!TextUtils.isEmpty(cursor.getString(columnIndex9))) {
                                        pVar.setCategory(cursor.getString(columnIndex9));
                                    }
                                    String string4 = cursor.getString(columnIndex10);
                                    if (columnIndex10 >= 0 && !TextUtils.isEmpty(string4)) {
                                        pVar.yQ(string4);
                                        this.mTotalLength += string4.getBytes("UTF-8").length;
                                    }
                                    if (!TextUtils.isEmpty(cursor.getString(columnIndex11))) {
                                        this.mTotalLength += string.getBytes("UTF-8").length;
                                        try {
                                            if (new JSONObject(cursor.getString(columnIndex11)).has("ctr")) {
                                                pVar.iJ(true);
                                            }
                                        } catch (JSONException e8) {
                                            e8.printStackTrace();
                                        }
                                    }
                                    arrayList.add(pVar);
                                    ajVar.aB(pVar.beV(), Integer.parseInt(pVar.getId()));
                                    if (this.mTotalLength >= 10485760) {
                                        break;
                                    }
                                } catch (UnsupportedEncodingException e9) {
                                    e2 = e9;
                                    j2 = endTime;
                                    if (DEBUG) {
                                    }
                                    Closeables.closeSafely(cursor);
                                    i = 0;
                                    if (arrayList.size() > 0) {
                                    }
                                    ajVar.y(j, j2);
                                    return i;
                                } catch (RuntimeException e10) {
                                    e = e10;
                                    j2 = endTime;
                                    if (DEBUG) {
                                    }
                                    Closeables.closeSafely(cursor);
                                    i = 0;
                                    if (arrayList.size() > 0) {
                                    }
                                    ajVar.y(j, j2);
                                    return i;
                                }
                            } else {
                                endTime = j2;
                                bfc = j;
                            }
                            try {
                                if (!cursor.moveToNext()) {
                                    break;
                                }
                                j2 = endTime;
                                j = bfc;
                            } catch (UnsupportedEncodingException e11) {
                                e2 = e11;
                                j2 = endTime;
                                j = bfc;
                                if (DEBUG) {
                                    e2.printStackTrace();
                                }
                                Closeables.closeSafely(cursor);
                                i = 0;
                                if (arrayList.size() > 0) {
                                }
                                ajVar.y(j, j2);
                                return i;
                            } catch (RuntimeException e12) {
                                e = e12;
                                j2 = endTime;
                                j = bfc;
                                if (DEBUG) {
                                    e.printStackTrace();
                                }
                                Closeables.closeSafely(cursor);
                                i = 0;
                                if (arrayList.size() > 0) {
                                }
                                ajVar.y(j, j2);
                                return i;
                            }
                        } catch (UnsupportedEncodingException e13) {
                            e2 = e13;
                        } catch (RuntimeException e14) {
                            e = e14;
                        }
                    }
                    j2 = endTime;
                    j = bfc;
                    i2 = 1;
                    Closeables.closeSafely(cursor);
                    i = i2;
                    if (arrayList.size() > 0) {
                        b(arrayList, ajVar);
                    }
                    ajVar.y(j, j2);
                    return i;
                }
            }
            j2 = 0;
            i2 = 0;
            Closeables.closeSafely(cursor);
            i = i2;
            if (arrayList.size() > 0) {
            }
            ajVar.y(j, j2);
            return i;
        } finally {
            this.oVT.readLock().unlock();
        }
    }

    private void b(ArrayList<p> arrayList, aj ajVar) {
        Cursor cursor;
        Throwable th;
        Cursor cursor2;
        Cursor cursor3 = null;
        this.oVT.readLock().lock();
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            try {
                Iterator<p> it = arrayList.iterator();
                while (it.hasNext()) {
                    p next = it.next();
                    if (next.beV() >= 0) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", next.getId());
                        jSONObject.put(LogBuilder.KEY_START_TIME, Long.toString(next.bfc()));
                        jSONObject.put(LogBuilder.KEY_END_TIME, Long.toString(next.getEndTime()));
                        jSONObject.put("type", "1");
                        g ehN = g.ehN();
                        jSONObject.put("isreal", ehN.Xz(next.getId()) ? "1" : "0");
                        String XA = ehN.XA(next.getId());
                        if (!TextUtils.isEmpty(XA) && !TextUtils.equals(XA, "0")) {
                            jSONObject.put("gflow", XA);
                        }
                        if (!TextUtils.isEmpty(next.getContent())) {
                            jSONObject.put("content", next.getContent());
                        }
                        if (!TextUtils.isEmpty(next.beW())) {
                            jSONObject.put("abtest", next.beW());
                            ajVar.yU("1");
                        }
                        if (!TextUtils.isEmpty(next.getCategory())) {
                            jSONObject.put("c", next.getCategory());
                        }
                        if (next.bfe() != null) {
                            jSONObject.put("part", next.bfe());
                        }
                        if (next.beS()) {
                            jSONObject.put("of", "1");
                        }
                        jSONObject.put("idtype", ehN.yJ(next.getId()));
                        JSONArray jSONArray = new JSONArray();
                        StringBuilder sb = new StringBuilder(256);
                        sb.append("SELECT ").append("eventid").append(" , ").append("begintime").append(" , ").append("content").append(" FROM ").append("event").append(" WHERE ").append("flowhandle").append(" = ").append(next.beV());
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
                                } catch (Throwable th2) {
                                    th = th2;
                                    cursor2 = cursor;
                                    Closeables.closeSafely(cursor2);
                                    throw th;
                                }
                            }
                            Closeables.closeSafely(cursor);
                            ajVar.dm(jSONObject);
                        } catch (Throwable th3) {
                            th = th3;
                            cursor2 = cursor3;
                        }
                    } else {
                        cursor = cursor3;
                    }
                    cursor3 = cursor;
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
            this.oUM.B(e3);
        } finally {
            this.oVT.readLock().unlock();
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
    public boolean gr(List<k> list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        this.oVT.writeLock().lock();
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
                    if (kVar.beP() != 0 && kVar.beQ() != 0) {
                        compileStatement.bindLong(3, kVar.beP());
                        compileStatement.bindLong(4, kVar.beQ());
                    }
                    if ("1".equals(kVar.beM())) {
                        compileStatement.bindLong(5, 0L);
                    } else {
                        compileStatement.bindLong(5, kVar.getTimeout());
                    }
                    compileStatement.bindString(6, kVar.beL());
                    compileStatement.bindLong(7, kVar.beO());
                    compileStatement.bindString(8, kVar.beN());
                    if (!TextUtils.isEmpty(kVar.getCategory())) {
                        compileStatement.bindString(9, kVar.getCategory());
                    }
                    JSONObject jSONObject = new JSONObject();
                    if (TextUtils.equals(kVar.beR(), "1")) {
                        jSONObject.put("idtype", "1");
                    }
                    if (TextUtils.equals(kVar.ehR(), "1")) {
                        jSONObject.put("ch", "1");
                    }
                    if (TextUtils.equals(kVar.ehS(), "1")) {
                        jSONObject.put("dfc", "1");
                    }
                    if (kVar.getVersion() != null) {
                        jSONObject.put("version", kVar.getVersion());
                    }
                    String ehU = kVar.ehU();
                    if (!TextUtils.isEmpty(ehU) && !TextUtils.equals(ehU, "0")) {
                        jSONObject.put("gflow", ehU);
                    }
                    String ehV = kVar.ehV();
                    if (!TextUtils.isEmpty(ehV)) {
                        jSONObject.put("uploadType", ehV);
                    }
                    int ehW = kVar.ehW();
                    if (ehW != 2) {
                        jSONObject.put("lcache", ehW);
                    }
                    String jSONObject2 = jSONObject.toString();
                    if (!TextUtils.isEmpty(jSONObject2)) {
                        compileStatement.bindString(10, jSONObject2);
                    }
                    if (TextUtils.equals(kVar.ehT(), "1")) {
                        compileStatement.bindString(11, kVar.ehT());
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
            this.oUM.B(e2);
        } finally {
            this.oVT.writeLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int eic() {
        Cursor cursor = null;
        int i = 0;
        this.oVT.readLock().lock();
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
            this.oVT.readLock().unlock();
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HashMap<String, String> bi(ArrayList<String> arrayList) {
        Cursor cursor = null;
        this.oVT.readLock().lock();
        HashMap<String, String> hashMap = new HashMap<>();
        String r = r(arrayList);
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ").append("eventid").append(",").append("extend").append(" FROM ").append("config").append(" WHERE ").append("eventid").append(" in (").append(r).append(")");
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
            this.oVT.readLock().unlock();
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
        this.oVT.writeLock().lock();
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
                            String r = r(arrayList2);
                            if (DEBUG) {
                                Log.d("UBCDatabaseHelper", "save file name " + str + " delete flow handle ids = " + r);
                            }
                            StringBuilder sb = new StringBuilder();
                            sb.append("flowhandle").append(" in (").append(r).append(")");
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
                    String r2 = r(arrayList);
                    if (DEBUG) {
                        Log.d("UBCDatabaseHelper", "delete event ids = " + r2);
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("eventid").append(" in (").append(r2).append(")").append(" AND ").append("flowhandle").append(" = ").append(-1);
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
                this.oVT.writeLock().unlock();
            }
        } catch (SQLException e) {
            e = e;
            z2 = false;
        }
        try {
        } catch (SQLException e2) {
            e = e2;
            if (DEBUG) {
                e.printStackTrace();
            }
            this.oUM.B(e);
            return z2;
        }
        return z2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [2793=4] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public o XK(String str) {
        Cursor cursor;
        o oVar = null;
        this.oVT.readLock().lock();
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
            this.oUM.B(e3);
        } finally {
            this.oVT.readLock().unlock();
        }
        return oVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void yy(String str) {
        this.oVT.writeLock().lock();
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
            this.oUM.B(e);
        } finally {
            this.oVT.writeLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bep() {
        this.oVT.writeLock().lock();
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
            this.oUM.B(e);
        } finally {
            this.oVT.writeLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void yz(String str) {
        this.oVT.writeLock().lock();
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
            this.oUM.B(e);
        } finally {
            this.oVT.writeLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dt(String str, String str2) {
        this.oVT.writeLock().lock();
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
            this.oUM.B(e);
        } finally {
            this.oVT.writeLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void beq() {
        this.oVT.writeLock().lock();
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
            this.oUM.B(e);
        } finally {
            this.oVT.writeLock().unlock();
        }
    }

    private String r(ArrayList arrayList) {
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
