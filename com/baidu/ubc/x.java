package com.baidu.ubc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.util.io.Closeables;
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
/* loaded from: classes13.dex */
public class x extends SQLiteOpenHelper {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static x lNX = null;
    private static ReentrantLock lNY = new ReentrantLock();
    private ReentrantReadWriteLock lNW;
    private long mTotalLength;

    public static x fs(Context context) {
        if (lNX == null) {
            lNY.lock();
            if (lNX == null) {
                lNX = new x(context);
            }
            lNY.unlock();
        }
        return lNX;
    }

    private x(Context context) {
        super(context, "bdbehavior.db", (SQLiteDatabase.CursorFactory) null, 7);
        this.lNW = new ReentrantReadWriteLock(true);
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
            ag.dkP().putString("ubc_cloudconfig_version", "0");
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
        Log.i("UBCDatabaseHelper", "bdbehavior.db upgrading from version " + i + " to " + i2);
        sQLiteDatabase.beginTransaction();
        while (i < i2) {
            switch (i) {
                case 1:
                    try {
                        D(sQLiteDatabase);
                        break;
                    } catch (Throwable th) {
                        try {
                            if (DEBUG) {
                                Log.e("UBCDatabaseHelper", th.toString() + "\n" + Log.getStackTraceString(th));
                            }
                            return;
                        } finally {
                            sQLiteDatabase.endTransaction();
                        }
                    }
                case 2:
                    G(sQLiteDatabase);
                    break;
                case 3:
                    E(sQLiteDatabase);
                    break;
                case 4:
                    F(sQLiteDatabase);
                    break;
                case 6:
                    ad(sQLiteDatabase);
                    break;
            }
            i++;
        }
        sQLiteDatabase.setTransactionSuccessful();
    }

    private void D(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE file (filename TEXT PRIMARY KEY,state TEXT,reserve1 TEXT,reserve2 TEXT);");
        } catch (SQLException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void E(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE event ADD COLUMN extend TEXT");
            sQLiteDatabase.execSQL("ALTER TABLE flow ADD COLUMN extend TEXT");
        } catch (SQLException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void F(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE config ADD COLUMN extend TEXT");
        } catch (SQLException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void ad(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE config ADD COLUMN reallog DEFAULT '0'");
            sQLiteDatabase.execSQL("ALTER TABLE event ADD COLUMN reallog DEFAULT '0'");
        } catch (SQLException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void G(SQLiteDatabase sQLiteDatabase) {
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
        this.lNW.writeLock().lock();
        try {
            ContentValues f = f(nVar);
            String ahF = nVar.ahF();
            String id = nVar.getId();
            int aDJ = nVar.aDJ();
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            if (a(ahF, id, aDJ, writableDatabase)) {
                long insert = writableDatabase.insert(NotificationCompat.CATEGORY_EVENT, null, f);
                if (DEBUG) {
                    Log.d("UBCDatabaseHelper", "saveEvent#performTransaction: rowId=" + insert);
                }
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } finally {
            this.lNW.writeLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void au(List<n> list) {
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
    public boolean dkJ() {
        this.lNW.writeLock().lock();
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            int delete = writableDatabase.delete(NotificationCompat.CATEGORY_EVENT, "reallog =?", new String[]{"1"});
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            return delete > 0;
        } finally {
            this.lNW.writeLock().unlock();
        }
    }

    private ContentValues f(n nVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("flowhandle", Integer.valueOf(nVar.aDJ()));
        contentValues.put("eventid", nVar.getId());
        contentValues.put("begintime", Long.valueOf(nVar.getTime()));
        if (!TextUtils.isEmpty(nVar.getContent())) {
            contentValues.put("content", nVar.getContent());
        } else if (nVar.aDL() != null && !TextUtils.isEmpty(nVar.aDL().toString())) {
            contentValues.put("content", nVar.aDL().toString());
        }
        if (!TextUtils.isEmpty(nVar.aDK())) {
            contentValues.put("reserve1", nVar.aDK());
        }
        if (!TextUtils.isEmpty(nVar.getCategory())) {
            contentValues.put("reserve2", nVar.getCategory());
        }
        if (nVar.aDH()) {
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
        if (!TextUtils.isEmpty(nVar.dkD())) {
            contentValues.put("reallog", nVar.dkD());
        } else {
            contentValues.put("reallog", "0");
        }
        return contentValues;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [660=7, 661=4] */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x023b: MOVE  (r6 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:86:0x023b */
    private int a(String str, ah ahVar) {
        Cursor cursor;
        RuntimeException runtimeException;
        Cursor cursor2;
        long j;
        long j2;
        UnsupportedEncodingException unsupportedEncodingException;
        Cursor cursor3;
        SQLiteFullException sQLiteFullException;
        Cursor cursor4;
        int i;
        Cursor rawQuery;
        String string;
        int i2;
        long j3;
        this.lNW.readLock().lock();
        Cursor cursor5 = null;
        long j4 = Long.MAX_VALUE;
        long j5 = 0;
        try {
            try {
                try {
                    try {
                        try {
                            rawQuery = getReadableDatabase().rawQuery(str, null);
                        } catch (Throwable th) {
                            th = th;
                            Closeables.closeSafely(cursor5);
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
                } catch (SQLiteFullException e2) {
                    sQLiteFullException = e2;
                    cursor4 = null;
                    j = Long.MAX_VALUE;
                    j2 = 0;
                } catch (UnsupportedEncodingException e3) {
                    unsupportedEncodingException = e3;
                    cursor3 = null;
                    j = Long.MAX_VALUE;
                    j2 = 0;
                } catch (RuntimeException e4) {
                    runtimeException = e4;
                    cursor2 = null;
                    j = Long.MAX_VALUE;
                    j2 = 0;
                }
                if (rawQuery != null) {
                    try {
                    } catch (SQLiteFullException e5) {
                        long j6 = j5;
                        sQLiteFullException = e5;
                        cursor4 = rawQuery;
                        j = j4;
                        j2 = j6;
                        if (DEBUG) {
                            sQLiteFullException.printStackTrace();
                        }
                        Closeables.closeSafely(cursor4);
                        i = 0;
                        ahVar.r(j, j2);
                        return i;
                    } catch (UnsupportedEncodingException e6) {
                        long j7 = j5;
                        unsupportedEncodingException = e6;
                        cursor3 = rawQuery;
                        j = j4;
                        j2 = j7;
                        if (DEBUG) {
                            unsupportedEncodingException.printStackTrace();
                        }
                        Closeables.closeSafely(cursor3);
                        i = 0;
                        ahVar.r(j, j2);
                        return i;
                    } catch (RuntimeException e7) {
                        long j8 = j5;
                        runtimeException = e7;
                        cursor2 = rawQuery;
                        j = j4;
                        j2 = j8;
                        if (DEBUG) {
                            runtimeException.printStackTrace();
                        }
                        Closeables.closeSafely(cursor2);
                        i = 0;
                        ahVar.r(j, j2);
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
                            long j9 = rawQuery.getLong(columnIndex2);
                            jSONObject.put("timestamp", Long.toString(j9));
                            if (j9 > 0) {
                                if (j9 < j4) {
                                    j4 = j9;
                                }
                                if (j9 > j5) {
                                    j5 = j9;
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
                                ahVar.sq("1");
                                this.mTotalLength += string4.getBytes("UTF-8").length;
                            }
                            if (!TextUtils.isEmpty(rawQuery.getString(columnIndex5))) {
                                jSONObject.put("c", rawQuery.getString(columnIndex5));
                            }
                            if (!TextUtils.isEmpty(rawQuery.getString(columnIndex6))) {
                                if (new JSONObject(rawQuery.getString(columnIndex6)).has("ctr")) {
                                    jSONObject.put("of", "1");
                                }
                                this.mTotalLength += string.getBytes("UTF-8").length;
                            }
                            g dkz = g.dkz();
                            jSONObject.put("idtype", dkz.sh(string2));
                            jSONObject.put("isreal", dkz.Nq(string2) ? "1" : "0");
                            String Nr = dkz.Nr(string2);
                            if (!TextUtils.isEmpty(Nr) && !TextUtils.equals(Nr, "0")) {
                                jSONObject.put("gflow", Nr);
                            }
                            ahVar.cr(jSONObject);
                            ahVar.sp(rawQuery.getString(columnIndex));
                            if (this.mTotalLength >= 10485760) {
                                break;
                            }
                        } while (rawQuery.moveToNext());
                        i2 = 1;
                        long j10 = j4;
                        j2 = j5;
                        j3 = j10;
                        Closeables.closeSafely(rawQuery);
                        long j11 = j3;
                        i = i2;
                        j = j11;
                        ahVar.r(j, j2);
                        return i;
                    }
                }
                i2 = 0;
                j2 = 0;
                j3 = Long.MAX_VALUE;
                Closeables.closeSafely(rawQuery);
                long j112 = j3;
                i = i2;
                j = j112;
                ahVar.r(j, j2);
                return i;
            } catch (Throwable th2) {
                th = th2;
                cursor5 = cursor;
            }
        } finally {
            this.lNW.readLock().unlock();
        }
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
        this.lNW.writeLock().lock();
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            ContentValues contentValues = new ContentValues();
            contentValues.put("flowid", pVar.getId());
            contentValues.put("flowhandle", Integer.valueOf(pVar.aDJ()));
            contentValues.put("state", pVar.aDR());
            contentValues.put("begintime", Long.valueOf(pVar.aDQ()));
            if (pVar.aDL() != null) {
                contentValues.put("content", pVar.aDL().toString());
            } else {
                contentValues.put("content", pVar.getContent());
            }
            contentValues.put("option", Integer.valueOf(pVar.getOption()));
            contentValues.put("reserve1", pVar.aDK());
            if (!TextUtils.isEmpty(pVar.getCategory())) {
                contentValues.put("reserve2", pVar.getCategory());
            }
            if (pVar.aDH()) {
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
            writableDatabase.endTransaction();
        } finally {
            this.lNW.writeLock().unlock();
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
        this.lNW.writeLock().lock();
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
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
            writableDatabase.endTransaction();
        } finally {
            this.lNW.writeLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(String str, int i) {
        if (i < 0 || TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.d("UBCDatabaseHelper", "cancelFlow#flowHandle invalid");
                return;
            }
            return;
        }
        this.lNW.writeLock().lock();
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
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
            writableDatabase.endTransaction();
        } finally {
            this.lNW.writeLock().unlock();
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
        this.lNW.writeLock().lock();
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            ContentValues contentValues = new ContentValues();
            contentValues.put("content", str2);
            StringBuilder sb = new StringBuilder();
            sb.append("flowid").append("=\"").append(str).append("\"").append(" AND ").append("flowhandle").append(" = ").append(i);
            int update = writableDatabase.update("flow", contentValues, sb.toString(), null);
            if (DEBUG && update != 1) {
                Log.d("UBCDatabaseHelper", "updateFlowValue#performTransaction: updateFlowValue count:" + update);
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } finally {
            this.lNW.writeLock().unlock();
        }
    }

    private boolean a(String str, String str2, int i, SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        boolean z = false;
        this.lNW.writeLock().lock();
        try {
            if (str.equals(str2)) {
                z = true;
            } else {
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
                    Closeables.closeSafely(cursor);
                } catch (SQLiteFullException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                    Closeables.closeSafely(cursor);
                } catch (RuntimeException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                    Closeables.closeSafely(cursor);
                }
            }
            return z;
        } finally {
            this.lNW.writeLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x013a A[Catch: all -> 0x01bc, TryCatch #4 {all -> 0x01c1, blocks: (B:3:0x000a, B:26:0x0196, B:4:0x0011, B:6:0x003f, B:7:0x0059, B:9:0x0079, B:10:0x0093, B:18:0x0131, B:19:0x0134, B:21:0x013a, B:23:0x013e, B:24:0x015c, B:25:0x0193, B:33:0x01b7, B:45:0x01d4, B:47:0x01da, B:48:0x01dd), top: B:51:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void aDf() {
        Cursor cursor = null;
        this.lNW.writeLock().lock();
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            long currentTimeMillis = System.currentTimeMillis() - g.dkz().aDy();
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
            try {
                try {
                    cursor = writableDatabase.rawQuery(sb.toString(), null);
                } catch (SQLiteFullException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                    Closeables.closeSafely(cursor);
                } catch (RuntimeException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                    Closeables.closeSafely(cursor);
                }
                if (cursor != null && cursor.getCount() > 0) {
                    cursor.moveToFirst();
                    do {
                        arrayList.add(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("flowhandle"))));
                    } while (cursor.moveToNext());
                    Closeables.closeSafely(cursor);
                    if (arrayList.size() > 0) {
                    }
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                    rU("flow");
                    rU(NotificationCompat.CATEGORY_EVENT);
                }
                Closeables.closeSafely(cursor);
                if (arrayList.size() > 0) {
                    if (DEBUG) {
                        Log.d("UBCDatabaseHelper", "clearInvalidData: delete flow count2:" + arrayList.size());
                    }
                    String r = r(arrayList);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("flowhandle").append(" in (").append(r).append(")");
                    writableDatabase.delete("flow", sb2.toString(), null);
                    writableDatabase.delete(NotificationCompat.CATEGORY_EVENT, sb2.toString(), null);
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                rU("flow");
                rU(NotificationCompat.CATEGORY_EVENT);
            } catch (Throwable th) {
                Closeables.closeSafely(cursor);
                throw th;
            }
        } finally {
            this.lNW.writeLock().unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1071=4] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008e A[Catch: all -> 0x00d7, TryCatch #4 {all -> 0x00dc, blocks: (B:3:0x000b, B:18:0x00ab, B:4:0x0012, B:13:0x006e, B:14:0x0071, B:16:0x008e, B:17:0x00a8, B:25:0x00c0, B:31:0x00cd, B:5:0x003d, B:7:0x0048, B:9:0x004e, B:11:0x0060, B:22:0x00b9, B:24:0x00bd, B:28:0x00c6, B:30:0x00ca), top: B:42:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void rU(String str) {
        int i;
        Cursor cursor = null;
        this.lNW.writeLock().lock();
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT COUNT(*), MIN(").append(IMConstants.MSG_ROW_ID).append("), MAX(").append(IMConstants.MSG_ROW_ID).append(") FROM ").append(str);
            try {
                cursor = writableDatabase.rawQuery(sb.toString(), null);
            } catch (SQLiteFullException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                Closeables.closeSafely(cursor);
                i = 0;
            } catch (RuntimeException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
                Closeables.closeSafely(cursor);
                i = 0;
            }
            if (cursor != null && cursor.getCount() > 0) {
                cursor.moveToFirst();
                if (cursor.getInt(0) > g.dkz().aDz()) {
                    i = (cursor.getInt(1) + cursor.getInt(2)) / 2;
                    Closeables.closeSafely(cursor);
                    int delete = writableDatabase.delete(str, "_id < " + i, null);
                    if (DEBUG) {
                        Log.d("UBCDatabaseHelper", "ensureDataBaseLimit#performTransaction: delete count:" + delete);
                    }
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                }
            }
            i = 0;
            Closeables.closeSafely(cursor);
            int delete2 = writableDatabase.delete(str, "_id < " + i, null);
            if (DEBUG) {
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } finally {
            this.lNW.writeLock().unlock();
        }
    }

    public void a(f fVar) {
        Cursor cursor = null;
        this.lNW.readLock().lock();
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM ").append("config");
            try {
                try {
                    cursor = readableDatabase.rawQuery(sb.toString(), null);
                    if (fVar == null) {
                        fVar = new f();
                    }
                } catch (RuntimeException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                    Closeables.closeSafely(cursor);
                }
            } catch (SQLiteFullException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
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
                        fVar.lNw.add(string);
                    } else if (TextUtils.equals(string2, "1")) {
                        fVar.lNz.add(string);
                    }
                    if (i2 == 0) {
                        fVar.lNx.add(string);
                    }
                    if (TextUtils.equals(string3, "1")) {
                        fVar.lNy.add(string);
                    }
                    if (i > 0) {
                        fVar.lNB.put(string, String.valueOf(i));
                    }
                    if (!TextUtils.isEmpty(string4)) {
                        fVar.lNC.put(string, string4);
                    }
                    if (i3 != 0 && i4 != 0) {
                        fVar.lND.put(string, new m(string, i4, i3));
                    }
                    if (!TextUtils.isEmpty(string5)) {
                        try {
                            JSONObject jSONObject = new JSONObject(string5);
                            if (jSONObject.has("idtype")) {
                                fVar.lNE.add(string);
                            }
                            if (jSONObject.has("ch") && TextUtils.equals(jSONObject.getString("ch"), "1")) {
                                fVar.lNA.add(string);
                            }
                            if (jSONObject.has("gflow")) {
                                String string7 = jSONObject.getString("gflow");
                                if (!TextUtils.equals(string7, "0")) {
                                    fVar.lNG.put(string, string7);
                                }
                            }
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                    }
                    if (TextUtils.equals(string6, "1")) {
                        fVar.lNF.add(string);
                    }
                } while (cursor.moveToNext());
                Closeables.closeSafely(cursor);
            }
            Closeables.closeSafely(cursor);
        } finally {
            this.lNW.readLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00cf A[Catch: SQLiteFullException -> 0x00fe, RuntimeException -> 0x0115, all -> 0x0121, TryCatch #1 {RuntimeException -> 0x0115, blocks: (B:4:0x0093, B:6:0x009e, B:8:0x00a4, B:9:0x00bc, B:14:0x00cf, B:16:0x00d7, B:17:0x00df, B:18:0x00e7), top: B:43:0x0093, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(SparseArray<ArrayList> sparseArray) {
        int i;
        Cursor cursor = null;
        this.lNW.readLock().lock();
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT ").append("eventid").append(" , ").append("type").append(" , ").append("cycle").append(" FROM ").append("config").append(" WHERE ").append("switch").append("=\"").append("1").append("\"").append(" AND (").append("reallog").append(" = \"0\" OR ").append("reallog").append(" = \"\")");
            try {
                try {
                    cursor = readableDatabase.rawQuery(sb.toString(), null);
                } catch (RuntimeException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                    Closeables.closeSafely(cursor);
                }
            } catch (SQLiteFullException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
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
                Closeables.closeSafely(cursor);
            }
            Closeables.closeSafely(cursor);
        } finally {
            this.lNW.readLock().unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1332=4] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public k Nw(String str) {
        Cursor cursor;
        Cursor cursor2;
        Cursor cursor3;
        this.lNW.readLock().lock();
        try {
            try {
                try {
                    cursor2 = getReadableDatabase().rawQuery(String.format("SELECT * FROM %s where eventid = \"%s\"", "config", str), null);
                    if (cursor2 != null) {
                        try {
                            if (cursor2.getCount() > 0) {
                                cursor2.moveToFirst();
                                String string = cursor2.getString(cursor2.getColumnIndex("eventid"));
                                String string2 = cursor2.getString(cursor2.getColumnIndex("switch"));
                                String string3 = cursor2.getString(cursor2.getColumnIndex("cycle"));
                                k kVar = new k(string, string2, TextUtils.equals(string3, "0") ? "0" : "1", Integer.parseInt(string3), cursor2.getString(cursor2.getColumnIndex("type")), cursor2.getString(cursor2.getColumnIndex("reserve1")));
                                String string4 = cursor2.getString(cursor2.getColumnIndex("extend"));
                                if (!TextUtils.isEmpty(string4)) {
                                    try {
                                        JSONObject jSONObject = new JSONObject(string4);
                                        String optString = jSONObject.optString("dfc");
                                        if (!TextUtils.isEmpty(optString)) {
                                            kVar.Nt(optString);
                                        }
                                        String optString2 = jSONObject.optString("version");
                                        if (!TextUtils.isEmpty(optString2)) {
                                            kVar.setVersion(optString2);
                                        }
                                    } catch (JSONException e) {
                                        if (DEBUG) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                                String string5 = cursor2.getString(cursor2.getColumnIndex("reallog"));
                                if (!TextUtils.isEmpty(string5)) {
                                    kVar.Nu(string5);
                                }
                                Closeables.closeSafely(cursor2);
                                return kVar;
                            }
                        } catch (SQLiteFullException e2) {
                            e = e2;
                            cursor3 = cursor2;
                            try {
                                if (DEBUG) {
                                    e.printStackTrace();
                                }
                                Closeables.closeSafely(cursor3);
                                return null;
                            } catch (Throwable th) {
                                th = th;
                                cursor = cursor3;
                                Closeables.closeSafely(cursor);
                                throw th;
                            }
                        } catch (RuntimeException e3) {
                            e = e3;
                            if (DEBUG) {
                                e.printStackTrace();
                            }
                            Closeables.closeSafely(cursor2);
                            return null;
                        }
                    }
                    Closeables.closeSafely(cursor2);
                } catch (Throwable th2) {
                    th = th2;
                    Closeables.closeSafely(cursor);
                    throw th;
                }
            } catch (SQLiteFullException e4) {
                e = e4;
                cursor3 = null;
            } catch (RuntimeException e5) {
                e = e5;
                cursor2 = null;
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
                Closeables.closeSafely(cursor);
                throw th;
            }
            return null;
        } finally {
            this.lNW.readLock().unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1383=4] */
    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Nx(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        this.lNW.writeLock().lock();
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            int delete = writableDatabase.delete("config", "eventid =? ", new String[]{str});
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            boolean z = delete > 0;
            this.lNW.writeLock().unlock();
            return z;
        } catch (Throwable th) {
            this.lNW.writeLock().unlock();
            throw th;
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1592=6] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01f3 A[Catch: all -> 0x0252, TryCatch #12 {all -> 0x0252, blocks: (B:3:0x000c, B:52:0x01ea, B:53:0x01ed, B:55:0x01f3, B:56:0x01fa, B:67:0x021f, B:88:0x024e, B:89:0x0251, B:85:0x0247, B:78:0x0239), top: B:120:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x021c A[Catch: all -> 0x0261, TRY_LEAVE, TryCatch #1 {all -> 0x0261, blocks: (B:64:0x0218, B:66:0x021c), top: B:118:0x0218 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0236 A[Catch: all -> 0x025f, TRY_LEAVE, TryCatch #16 {all -> 0x025f, blocks: (B:7:0x0026, B:9:0x002c, B:10:0x007c, B:12:0x0089, B:14:0x009e, B:70:0x0226, B:16:0x00a8, B:18:0x00db, B:20:0x00e3, B:22:0x00e8, B:24:0x00f2, B:26:0x00fa, B:28:0x00ff, B:30:0x010b, B:31:0x0125, B:33:0x0131, B:34:0x014b, B:36:0x0157, B:37:0x0162, B:39:0x016a, B:41:0x0170, B:42:0x018a, B:44:0x0196, B:45:0x01ab, B:47:0x01bf, B:60:0x020c, B:48:0x01c5, B:82:0x0240, B:84:0x0244, B:75:0x0232, B:77:0x0236), top: B:123:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0244 A[Catch: all -> 0x025f, TRY_LEAVE, TryCatch #16 {all -> 0x025f, blocks: (B:7:0x0026, B:9:0x002c, B:10:0x007c, B:12:0x0089, B:14:0x009e, B:70:0x0226, B:16:0x00a8, B:18:0x00db, B:20:0x00e3, B:22:0x00e8, B:24:0x00f2, B:26:0x00fa, B:28:0x00ff, B:30:0x010b, B:31:0x0125, B:33:0x0131, B:34:0x014b, B:36:0x0157, B:37:0x0162, B:39:0x016a, B:41:0x0170, B:42:0x018a, B:44:0x0196, B:45:0x01ab, B:47:0x01bf, B:60:0x020c, B:48:0x01c5, B:82:0x0240, B:84:0x0244, B:75:0x0232, B:77:0x0236), top: B:123:0x001e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int b(String str, ah ahVar) {
        Cursor cursor;
        int i;
        long endTime;
        long aDQ;
        String string;
        this.lNW.readLock().lock();
        try {
            ArrayList<p> arrayList = new ArrayList<>();
            Cursor cursor2 = null;
            long j = Long.MAX_VALUE;
            long j2 = 0;
            Cursor cursor3 = null;
            try {
                try {
                    cursor = getReadableDatabase().rawQuery(str, null);
                } catch (Throwable th) {
                    th = th;
                    Closeables.closeSafely(cursor3);
                    throw th;
                }
            } catch (SQLiteFullException e) {
                e = e;
            } catch (UnsupportedEncodingException e2) {
                e = e2;
                cursor = null;
            } catch (RuntimeException e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                cursor3 = null;
                Closeables.closeSafely(cursor3);
                throw th;
            }
            if (cursor != null) {
                try {
                } catch (SQLiteFullException e4) {
                    e = e4;
                    cursor2 = cursor;
                } catch (UnsupportedEncodingException e5) {
                    e = e5;
                } catch (RuntimeException e6) {
                    e = e6;
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
                    while (true) {
                        if ("2".equals(cursor.getString(columnIndex3)) || (Math.abs(cursor.getLong(columnIndex4) - System.currentTimeMillis()) > 86400000 && (cursor.getInt(columnIndex7) & 4) != 0)) {
                            p pVar = new p();
                            pVar.setId(cursor.getString(columnIndex));
                            pVar.jf(cursor.getInt(columnIndex2));
                            pVar.bR(cursor.getLong(columnIndex4));
                            pVar.setEndTime(cursor.getLong(columnIndex5));
                            endTime = (pVar.getEndTime() <= 0 || pVar.getEndTime() <= j2) ? j2 : pVar.getEndTime();
                            try {
                                aDQ = (pVar.aDQ() <= 0 || pVar.aDQ() >= j) ? j : pVar.aDQ();
                                String string2 = cursor.getString(columnIndex6);
                                if (!TextUtils.isEmpty(string2)) {
                                    pVar.setContent(string2);
                                    this.mTotalLength = string2.getBytes("UTF-8").length + this.mTotalLength;
                                }
                                String string3 = cursor.getString(columnIndex8);
                                if (!TextUtils.isEmpty(string3)) {
                                    pVar.sk(string3);
                                    this.mTotalLength = string3.getBytes("UTF-8").length + this.mTotalLength;
                                }
                                if (!TextUtils.isEmpty(cursor.getString(columnIndex9))) {
                                    pVar.setCategory(cursor.getString(columnIndex9));
                                }
                                String string4 = cursor.getString(columnIndex10);
                                if (columnIndex10 >= 0 && !TextUtils.isEmpty(string4)) {
                                    pVar.sl(string4);
                                    this.mTotalLength = string4.getBytes("UTF-8").length + this.mTotalLength;
                                }
                                if (!TextUtils.isEmpty(cursor.getString(columnIndex11))) {
                                    this.mTotalLength = string.getBytes("UTF-8").length + this.mTotalLength;
                                    try {
                                        if (new JSONObject(cursor.getString(columnIndex11)).has("ctr")) {
                                            pVar.gc(true);
                                        }
                                    } catch (JSONException e7) {
                                        e7.printStackTrace();
                                    }
                                }
                                arrayList.add(pVar);
                                ahVar.aw(pVar.aDJ(), Integer.parseInt(pVar.getId()));
                                if (this.mTotalLength >= 10485760) {
                                    break;
                                }
                            } catch (SQLiteFullException e8) {
                                j2 = endTime;
                                e = e8;
                                cursor2 = cursor;
                                try {
                                    if (DEBUG) {
                                        e.printStackTrace();
                                    }
                                    Closeables.closeSafely(cursor2);
                                    i = 0;
                                    if (arrayList.size() > 0) {
                                    }
                                    ahVar.r(j, j2);
                                    return i;
                                } catch (Throwable th3) {
                                    th = th3;
                                    cursor3 = cursor2;
                                    Closeables.closeSafely(cursor3);
                                    throw th;
                                }
                            } catch (UnsupportedEncodingException e9) {
                                j2 = endTime;
                                e = e9;
                                if (DEBUG) {
                                    e.printStackTrace();
                                }
                                Closeables.closeSafely(cursor);
                                i = 0;
                                if (arrayList.size() > 0) {
                                }
                                ahVar.r(j, j2);
                                return i;
                            } catch (RuntimeException e10) {
                                j2 = endTime;
                                e = e10;
                                if (DEBUG) {
                                    e.printStackTrace();
                                }
                                Closeables.closeSafely(cursor);
                                i = 0;
                                if (arrayList.size() > 0) {
                                }
                                ahVar.r(j, j2);
                                return i;
                            }
                        } else {
                            endTime = j2;
                            aDQ = j;
                        }
                        try {
                            if (!cursor.moveToNext()) {
                                break;
                            }
                            j = aDQ;
                            j2 = endTime;
                        } catch (SQLiteFullException e11) {
                            j = aDQ;
                            j2 = endTime;
                            e = e11;
                            cursor2 = cursor;
                            if (DEBUG) {
                            }
                            Closeables.closeSafely(cursor2);
                            i = 0;
                            if (arrayList.size() > 0) {
                            }
                            ahVar.r(j, j2);
                            return i;
                        } catch (UnsupportedEncodingException e12) {
                            j = aDQ;
                            j2 = endTime;
                            e = e12;
                            if (DEBUG) {
                            }
                            Closeables.closeSafely(cursor);
                            i = 0;
                            if (arrayList.size() > 0) {
                            }
                            ahVar.r(j, j2);
                            return i;
                        } catch (RuntimeException e13) {
                            j = aDQ;
                            j2 = endTime;
                            e = e13;
                            if (DEBUG) {
                            }
                            Closeables.closeSafely(cursor);
                            i = 0;
                            if (arrayList.size() > 0) {
                            }
                            ahVar.r(j, j2);
                            return i;
                        }
                    }
                    j = aDQ;
                    j2 = endTime;
                    i = 1;
                    Closeables.closeSafely(cursor);
                    if (arrayList.size() > 0) {
                        b(arrayList, ahVar);
                    }
                    ahVar.r(j, j2);
                    return i;
                }
            }
            i = 0;
            Closeables.closeSafely(cursor);
            if (arrayList.size() > 0) {
            }
            ahVar.r(j, j2);
            return i;
        } finally {
            this.lNW.readLock().unlock();
        }
    }

    private void b(ArrayList<p> arrayList, ah ahVar) {
        Cursor cursor;
        Cursor cursor2 = null;
        this.lNW.readLock().lock();
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            try {
                Iterator<p> it = arrayList.iterator();
                while (it.hasNext()) {
                    p next = it.next();
                    if (next.aDJ() >= 0) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", next.getId());
                        jSONObject.put(LogBuilder.KEY_START_TIME, Long.toString(next.aDQ()));
                        jSONObject.put(LogBuilder.KEY_END_TIME, Long.toString(next.getEndTime()));
                        jSONObject.put("type", "1");
                        g dkz = g.dkz();
                        jSONObject.put("isreal", dkz.Nq(next.getId()) ? "1" : "0");
                        String Nr = dkz.Nr(next.getId());
                        if (!TextUtils.isEmpty(Nr) && !TextUtils.equals(Nr, "0")) {
                            jSONObject.put("gflow", Nr);
                        }
                        if (!TextUtils.isEmpty(next.getContent())) {
                            jSONObject.put("content", next.getContent());
                        }
                        if (!TextUtils.isEmpty(next.aDK())) {
                            jSONObject.put("abtest", next.aDK());
                            ahVar.sq("1");
                        }
                        if (!TextUtils.isEmpty(next.getCategory())) {
                            jSONObject.put("c", next.getCategory());
                        }
                        if (next.aDS() != null) {
                            jSONObject.put("part", next.aDS());
                        }
                        if (next.aDH()) {
                            jSONObject.put("of", "1");
                        }
                        jSONObject.put("idtype", dkz.sh(next.getId()));
                        JSONArray jSONArray = new JSONArray();
                        StringBuilder sb = new StringBuilder(256);
                        sb.append("SELECT ").append("eventid").append(" , ").append("begintime").append(" , ").append("content").append(" FROM ").append(NotificationCompat.CATEGORY_EVENT).append(" WHERE ").append("flowhandle").append(" = ").append(next.aDJ());
                        try {
                            try {
                                cursor2 = readableDatabase.rawQuery(sb.toString(), null);
                                if (cursor2 != null && cursor2.getCount() > 0) {
                                    cursor2.moveToFirst();
                                    int columnIndex = cursor2.getColumnIndex("eventid");
                                    int columnIndex2 = cursor2.getColumnIndex("begintime");
                                    int columnIndex3 = cursor2.getColumnIndex("content");
                                    do {
                                        JSONObject jSONObject2 = new JSONObject();
                                        jSONObject2.put("id", cursor2.getString(columnIndex));
                                        jSONObject2.put("timestamp", Long.toString(cursor2.getLong(columnIndex2)));
                                        jSONObject2.put("content", cursor2.getString(columnIndex3));
                                        jSONArray.put(jSONObject2);
                                    } while (cursor2.moveToNext());
                                    jSONObject.put("eventlist", jSONArray);
                                }
                                Closeables.closeSafely(cursor2);
                                cursor = cursor2;
                            } catch (SQLiteFullException e) {
                                if (DEBUG) {
                                    e.printStackTrace();
                                }
                                Closeables.closeSafely(cursor2);
                                cursor = cursor2;
                            }
                            ahVar.cr(jSONObject);
                        } finally {
                        }
                    } else {
                        cursor = cursor2;
                    }
                    cursor2 = cursor;
                }
            } catch (RuntimeException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            } catch (JSONException e3) {
                if (DEBUG) {
                    Log.d("UBCDatabaseHelper", "json exception:");
                }
            }
        } finally {
            this.lNW.readLock().unlock();
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(k kVar) {
        if (kVar != null) {
            this.lNW.writeLock().lock();
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("eventid", kVar.getId());
                    contentValues.put("type", kVar.getType());
                    if ("1".equals(kVar.aDB())) {
                        contentValues.put("cycle", (Integer) 0);
                    } else {
                        contentValues.put("cycle", Integer.valueOf(kVar.getTimeout()));
                    }
                    contentValues.put("switch", kVar.aDA());
                    contentValues.put("reserve1", kVar.aDC());
                    if (!TextUtils.isEmpty(kVar.getCategory())) {
                        contentValues.put("reserve2", kVar.getCategory());
                    }
                    contentValues.put("sample", Integer.valueOf(kVar.aDD()));
                    if (kVar.aDE() != 0 && kVar.aDF() != 0) {
                        contentValues.put("recordrule", Integer.valueOf(kVar.aDE()));
                        contentValues.put("uploadrule", Integer.valueOf(kVar.aDF()));
                    }
                    JSONObject jSONObject = new JSONObject();
                    if (TextUtils.equals(kVar.aDG(), "1")) {
                        jSONObject.put("idtype", "1");
                    }
                    if (TextUtils.equals(kVar.dkB(), "1")) {
                        jSONObject.put("ch", "1");
                    }
                    if (TextUtils.equals(kVar.dkC(), "1")) {
                        jSONObject.put("dfc", "1");
                    }
                    if (kVar.getVersion() != null) {
                        jSONObject.put("version", kVar.getVersion());
                    }
                    String dkE = kVar.dkE();
                    if (!TextUtils.isEmpty(dkE) && !TextUtils.equals(dkE, "0")) {
                        jSONObject.put("gflow", dkE);
                    }
                    if (!TextUtils.isEmpty(jSONObject.toString())) {
                        contentValues.put("extend", jSONObject.toString());
                    }
                    if (TextUtils.equals(kVar.dkD(), "1")) {
                        contentValues.put("reallog", kVar.dkD());
                    } else {
                        contentValues.put("reallog", "0");
                    }
                    long replace = writableDatabase.replace("config", null, contentValues);
                    if (DEBUG) {
                        Log.d("UBCDatabaseHelper", "updateConfig#performTransaction: id=" + kVar.getId());
                    }
                    writableDatabase.setTransactionSuccessful();
                    r0 = replace > 0;
                    writableDatabase.endTransaction();
                } catch (JSONException e) {
                    if (AppConfig.isDebug()) {
                        e.printStackTrace();
                    }
                    writableDatabase.endTransaction();
                }
            } finally {
                this.lNW.writeLock().unlock();
            }
        }
        return r0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(SparseArray<Integer> sparseArray, ArrayList<String> arrayList, boolean z, String str) {
        this.lNW.writeLock().lock();
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            if (sparseArray != null && sparseArray.size() > 0) {
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
                int delete2 = writableDatabase.delete(NotificationCompat.CATEGORY_EVENT, sb.toString(), null);
                if (DEBUG) {
                    Log.d("UBCDatabaseHelper", "clearUploadedData#performTransaction:  delete flow -> event table count:" + delete2);
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                String r2 = r(arrayList);
                if (DEBUG) {
                    Log.d("UBCDatabaseHelper", "delete event ids = " + r2);
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("eventid").append(" in (").append(r2).append(")").append(" AND ").append("flowhandle").append(" = ").append(-1);
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
            writableDatabase.endTransaction();
            return true;
        } finally {
            this.lNW.writeLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o Ny(String str) {
        Cursor cursor;
        Throwable th;
        String str2;
        o oVar = null;
        this.lNW.readLock().lock();
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
                                String string = cursor.getString(cursor.getColumnIndex("state"));
                                if (cursor.isNull(cursor.getColumnIndex("reserve1"))) {
                                    str2 = "";
                                } else {
                                    str2 = cursor.getString(cursor.getColumnIndex("reserve1"));
                                }
                                oVar = new o(str, string, str2);
                            }
                        } catch (Exception e) {
                            e = e;
                            if (DEBUG) {
                                e.printStackTrace();
                            }
                            Closeables.closeSafely(cursor);
                            return oVar;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        Closeables.closeSafely(cursor);
                        throw th;
                    }
                }
                Closeables.closeSafely(cursor);
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th3) {
                cursor = null;
                th = th3;
                Closeables.closeSafely(cursor);
                throw th;
            }
            return oVar;
        } finally {
            this.lNW.readLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void rW(String str) {
        this.lNW.writeLock().lock();
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            StringBuilder sb = new StringBuilder();
            sb.append("filename").append("=\"").append(str).append("\"");
            int delete = writableDatabase.delete("file", sb.toString(), null);
            if (DEBUG) {
                Log.d("UBCDatabaseHelper", "deleteSendedFile#performTransaction: delete file table:" + delete);
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } finally {
            this.lNW.writeLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aDg() {
        this.lNW.writeLock().lock();
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            int delete = writableDatabase.delete("file", null, null);
            if (DEBUG) {
                Log.d("UBCDatabaseHelper", "deleteAllSentFile#performTransaction: delete file table:" + delete);
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } finally {
            this.lNW.writeLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void rX(String str) {
        this.lNW.writeLock().lock();
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            StringBuilder sb = new StringBuilder();
            sb.append("filename").append("=\"").append(str).append("\"");
            ContentValues contentValues = new ContentValues();
            contentValues.put("state", "1");
            int update = writableDatabase.update("file", contentValues, sb.toString(), null);
            if (DEBUG) {
                Log.d("UBCDatabaseHelper", "updateSendedFileFail#performTransaction: update file table:" + update);
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } finally {
            this.lNW.writeLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cr(String str, String str2) {
        this.lNW.writeLock().lock();
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            StringBuilder sb = new StringBuilder();
            sb.append("filename").append("=\"").append(str).append("\"");
            ContentValues contentValues = new ContentValues();
            contentValues.put("state", str2);
            writableDatabase.update("file", contentValues, sb.toString(), null);
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } finally {
            this.lNW.writeLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aDh() {
        this.lNW.writeLock().lock();
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            ContentValues contentValues = new ContentValues();
            contentValues.put("state", "1");
            int update = writableDatabase.update("file", contentValues, null, null);
            if (DEBUG) {
                Log.d("UBCDatabaseHelper", "updateAllSentFileFail#performTransaction: update file table:" + update);
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } finally {
            this.lNW.writeLock().unlock();
        }
    }

    private String r(ArrayList arrayList) {
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
