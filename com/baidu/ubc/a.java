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
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.sina.weibo.sdk.statistic.LogBuilder;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private final C0549a jWC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context) {
        this.jWC = new C0549a(context, "bdbehavior.db");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(j jVar) {
        if (jVar != null && !TextUtils.isEmpty(jVar.getId())) {
            final ContentValues contentValues = new ContentValues();
            contentValues.put("flowhandle", Integer.valueOf(jVar.acH()));
            contentValues.put("eventid", jVar.getId());
            contentValues.put("begintime", Long.valueOf(jVar.getTime()));
            if (jVar.acJ() != null) {
                contentValues.put("content", jVar.acJ().toString());
            } else {
                contentValues.put("content", jVar.getContent());
            }
            contentValues.put("reserve1", jVar.acI());
            if (!TextUtils.isEmpty(jVar.getCategory())) {
                contentValues.put("reserve2", jVar.getCategory());
            }
            if (jVar.acE()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("ctr", "1");
                    contentValues.put("extend", jSONObject.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            final String acG = jVar.acG();
            final String id = jVar.getId();
            final int acH = jVar.acH();
            new b() { // from class: com.baidu.ubc.a.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // com.baidu.ubc.a.b
                protected boolean b(SQLiteDatabase sQLiteDatabase) {
                    return a.this.a(acG, id, acH, sQLiteDatabase) && sQLiteDatabase.insert(NotificationCompat.CATEGORY_EVENT, null, contentValues) != -1;
                }
            }.c(this.jWC.getWritableDatabase());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ag(final List<j> list) {
        if (list != null && list.size() != 0) {
            new b() { // from class: com.baidu.ubc.a.6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // com.baidu.ubc.a.b
                protected boolean b(SQLiteDatabase sQLiteDatabase) {
                    boolean z = true;
                    for (j jVar : list) {
                        if (!TextUtils.isEmpty(jVar.getId()) && a.this.a(jVar.acG(), jVar.getId(), jVar.acH(), sQLiteDatabase)) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("flowhandle", Integer.valueOf(jVar.acH()));
                            contentValues.put("eventid", jVar.getId());
                            contentValues.put("begintime", Long.valueOf(jVar.getTime()));
                            if (!TextUtils.isEmpty(jVar.getContent())) {
                                contentValues.put("content", jVar.getContent());
                            } else if (jVar.acJ() != null && !TextUtils.isEmpty(jVar.acJ().toString())) {
                                contentValues.put("content", jVar.acJ().toString());
                            }
                            contentValues.put("reserve1", jVar.acI());
                            if (!TextUtils.isEmpty(jVar.getCategory())) {
                                contentValues.put("reserve2", jVar.getCategory());
                            }
                            if (jVar.acE()) {
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("ctr", "1");
                                    contentValues.put("extend", jSONObject.toString());
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            z = sQLiteDatabase.insert(NotificationCompat.CATEGORY_EVENT, null, contentValues) < 0 ? false : z;
                        }
                    }
                    return z;
                }
            }.c(this.jWC.getWritableDatabase());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [417=4] */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0068, code lost:
        if ("1".equals(r3) != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(String str, String str2, int i, SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        boolean z = true;
        if (str.equals(str2)) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ").append("state").append(" FROM ").append("flow").append(" WHERE ").append("flowhandle").append(" = ").append(i);
        try {
            try {
                try {
                    Cursor rawQuery = sQLiteDatabase.rawQuery(sb.toString(), null);
                    if (rawQuery != null) {
                        try {
                            if (rawQuery.getCount() > 0) {
                                rawQuery.moveToFirst();
                                String string = rawQuery.getString(0);
                                if (!TextUtils.isEmpty(string)) {
                                }
                            }
                        } catch (SQLiteFullException e) {
                            cursor = rawQuery;
                            com.baidu.f.a.r(cursor);
                            return false;
                        }
                    }
                    z = false;
                    com.baidu.f.a.r(rawQuery);
                    return z;
                } catch (RuntimeException e2) {
                    e2.printStackTrace();
                    com.baidu.f.a.r(null);
                    return false;
                }
            } catch (SQLiteFullException e3) {
                cursor = null;
            }
        } catch (Throwable th) {
            com.baidu.f.a.r(null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(k kVar) {
        if (kVar != null && !TextUtils.isEmpty(kVar.getId())) {
            SQLiteDatabase writableDatabase = this.jWC.getWritableDatabase();
            final ContentValues contentValues = new ContentValues();
            contentValues.put("flowid", kVar.getId());
            contentValues.put("flowhandle", Integer.valueOf(kVar.acH()));
            contentValues.put("state", kVar.acO());
            contentValues.put("begintime", Long.valueOf(kVar.acN()));
            if (kVar.acJ() != null) {
                contentValues.put("content", kVar.acJ().toString());
            } else {
                contentValues.put("content", kVar.getContent());
            }
            contentValues.put("option", Integer.valueOf(kVar.getOption()));
            contentValues.put("reserve1", kVar.acI());
            if (!TextUtils.isEmpty(kVar.getCategory())) {
                contentValues.put("reserve2", kVar.getCategory());
            }
            if (kVar.acE()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("ctr", "1");
                    contentValues.put("extend", jSONObject.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            new b() { // from class: com.baidu.ubc.a.7
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // com.baidu.ubc.a.b
                protected boolean b(SQLiteDatabase sQLiteDatabase) {
                    return sQLiteDatabase.insert("flow", null, contentValues) != -1;
                }
            }.c(writableDatabase);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(String str, int i, String str2) {
        if (i >= 0 && !TextUtils.isEmpty(str)) {
            final ContentValues contentValues = new ContentValues();
            contentValues.put("content", str2);
            StringBuilder sb = new StringBuilder();
            sb.append("flowid").append("=\"").append(str).append("\"").append(" AND ").append("flowhandle").append(" = ").append(i);
            final String sb2 = sb.toString();
            new b() { // from class: com.baidu.ubc.a.8
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // com.baidu.ubc.a.b
                protected boolean b(SQLiteDatabase sQLiteDatabase) {
                    return sQLiteDatabase.update("flow", contentValues, sb2, null) == 1;
                }
            }.c(this.jWC.getWritableDatabase());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i, long j, JSONArray jSONArray) {
        if (i >= 0 && !TextUtils.isEmpty(str)) {
            final ContentValues contentValues = new ContentValues();
            contentValues.put("state", "2");
            contentValues.put(LogBuilder.KEY_END_TIME, Long.valueOf(j));
            if (jSONArray != null && jSONArray.length() > 0) {
                contentValues.put("slot", jSONArray.toString());
            }
            StringBuilder sb = new StringBuilder();
            sb.append("flowid").append("=\"").append(str).append("\"").append(" AND ").append("flowhandle").append(" = ").append(i);
            final String sb2 = sb.toString();
            new b() { // from class: com.baidu.ubc.a.9
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // com.baidu.ubc.a.b
                protected boolean b(SQLiteDatabase sQLiteDatabase) {
                    return sQLiteDatabase.update("flow", contentValues, sb2, null) == 1;
                }
            }.c(this.jWC.getWritableDatabase());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(String str, final int i) {
        if (i >= 0 && !TextUtils.isEmpty(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("flowid").append("=\"").append(str).append("\"").append(" AND ").append("flowhandle").append(" = ").append(i);
            final String sb2 = sb.toString();
            new b() { // from class: com.baidu.ubc.a.10
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // com.baidu.ubc.a.b
                protected boolean b(SQLiteDatabase sQLiteDatabase) {
                    sQLiteDatabase.delete("flow", sb2, null);
                    sQLiteDatabase.delete(NotificationCompat.CATEGORY_EVENT, "flowhandle = " + i, null);
                    return true;
                }
            }.c(this.jWC.getWritableDatabase());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void acd() {
        new b() { // from class: com.baidu.ubc.a.11
            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [713=4] */
            /* JADX WARN: Removed duplicated region for block: B:38:0x016c  */
            @Override // com.baidu.ubc.a.b
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            protected boolean b(SQLiteDatabase sQLiteDatabase) {
                Cursor cursor;
                Cursor cursor2;
                Cursor cursor3 = null;
                long currentTimeMillis = System.currentTimeMillis() - e.cAT().acv();
                int delete = sQLiteDatabase.delete("flow", "endtime < " + currentTimeMillis, null);
                if (delete > 0) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", "expire");
                        jSONObject.put("ubc_type", "flow");
                        jSONObject.put("expire_time", currentTimeMillis);
                        jSONObject.put("count", delete);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    UBC.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, jSONObject.toString());
                }
                int delete2 = sQLiteDatabase.delete(NotificationCompat.CATEGORY_EVENT, "begintime < " + currentTimeMillis, null);
                if (delete2 > 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("type", "expire");
                        jSONObject2.put("ubc_type", NotificationCompat.CATEGORY_EVENT);
                        jSONObject2.put("expire_time", currentTimeMillis);
                        jSONObject2.put("count", delete2);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    UBC.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, jSONObject2.toString());
                }
                StringBuilder sb = new StringBuilder(256);
                sb.append("SELECT ").append("flowhandle").append(" FROM ").append("flow").append(" WHERE ").append("begintime").append(" < ").append(System.currentTimeMillis() - 86400000).append(" AND ").append(LogBuilder.KEY_END_TIME).append(" is NULL ").append(" AND ").append("option").append(" = 0");
                ArrayList arrayList = new ArrayList();
                try {
                    cursor2 = sQLiteDatabase.rawQuery(sb.toString(), null);
                    if (cursor2 != null) {
                        try {
                            if (cursor2.getCount() > 0) {
                                cursor2.moveToFirst();
                                do {
                                    arrayList.add(Integer.valueOf(cursor2.getInt(cursor2.getColumnIndex("flowhandle"))));
                                } while (cursor2.moveToNext());
                            }
                        } catch (SQLiteFullException e3) {
                            com.baidu.f.a.r(cursor2);
                            if (arrayList.size() != 0) {
                            }
                            return true;
                        } catch (RuntimeException e4) {
                            cursor = cursor2;
                            e = e4;
                            try {
                                e.printStackTrace();
                                com.baidu.f.a.r(cursor);
                                if (arrayList.size() != 0) {
                                }
                                return true;
                            } catch (Throwable th) {
                                th = th;
                                cursor3 = cursor;
                                com.baidu.f.a.r(cursor3);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            cursor3 = cursor2;
                            th = th2;
                            com.baidu.f.a.r(cursor3);
                            throw th;
                        }
                    }
                    com.baidu.f.a.r(cursor2);
                } catch (SQLiteFullException e5) {
                    cursor2 = null;
                } catch (RuntimeException e6) {
                    e = e6;
                    cursor = null;
                } catch (Throwable th3) {
                    th = th3;
                }
                if (arrayList.size() != 0) {
                    String n = a.this.n(arrayList);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("flowhandle").append(" in (").append(n).append(")");
                    sQLiteDatabase.delete("flow", sb2.toString(), null);
                    sQLiteDatabase.delete(NotificationCompat.CATEGORY_EVENT, sb2.toString(), null);
                }
                return true;
            }
        }.c(this.jWC.getWritableDatabase());
        lk("flow");
        lk(NotificationCompat.CATEGORY_EVENT);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void lk(final String str) {
        Cursor cursor;
        RuntimeException runtimeException;
        Cursor cursor2 = null;
        final int i = 0;
        SQLiteDatabase writableDatabase = this.jWC.getWritableDatabase();
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT COUNT(*), MIN(").append(IMConstants.MSG_ROW_ID).append("), MAX(").append(IMConstants.MSG_ROW_ID).append(") FROM ").append(str);
        try {
            try {
                Cursor rawQuery = writableDatabase.rawQuery(sb.toString(), null);
                if (rawQuery != null) {
                    try {
                        if (rawQuery.getCount() > 0) {
                            rawQuery.moveToFirst();
                            if (rawQuery.getInt(0) > e.cAT().acw()) {
                                i = (rawQuery.getInt(1) + rawQuery.getInt(2)) / 2;
                            }
                        }
                    } catch (RuntimeException e) {
                        cursor = rawQuery;
                        runtimeException = e;
                        try {
                            runtimeException.printStackTrace();
                            com.baidu.f.a.r(cursor);
                            if (i <= 0) {
                            }
                        } catch (Throwable th) {
                            th = th;
                            cursor2 = cursor;
                            com.baidu.f.a.r(cursor2);
                            throw th;
                        }
                    }
                }
                com.baidu.f.a.r(rawQuery);
            } catch (RuntimeException e2) {
                cursor = null;
                runtimeException = e2;
            }
        } catch (SQLiteFullException e3) {
            com.baidu.f.a.r(null);
        } catch (Throwable th2) {
            th = th2;
            com.baidu.f.a.r(cursor2);
            throw th;
        }
        if (i <= 0) {
            new b() { // from class: com.baidu.ubc.a.12
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // com.baidu.ubc.a.b
                protected boolean b(SQLiteDatabase sQLiteDatabase) {
                    int delete = sQLiteDatabase.delete(str, "_id < " + i, null);
                    UBC.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "delLimit");
                    return delete > 0;
                }
            }.c(writableDatabase);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:50:0x0120 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v6, types: [android.database.Cursor] */
    public void a(HashSet<String> hashSet, HashSet<String> hashSet2, HashSet<String> hashSet3, HashSet<String> hashSet4, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, HashMap<String, i> hashMap3, HashSet<String> hashSet5) {
        Throwable th;
        Cursor cursor;
        RuntimeException e;
        ?? readableDatabase = this.jWC.getReadableDatabase();
        Cursor cursor2 = null;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ").append("config");
        try {
            try {
                cursor = readableDatabase.rawQuery(sb.toString(), null);
                if (cursor != null) {
                    try {
                        if (cursor.getCount() > 0) {
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
                                if (TextUtils.equals(string2, "0")) {
                                    hashSet.add(string);
                                } else if (TextUtils.equals(string2, "1")) {
                                    hashSet2.add(string);
                                }
                                if (i2 == 0) {
                                    hashSet3.add(string);
                                }
                                if (TextUtils.equals(string3, "1")) {
                                    hashSet4.add(string);
                                }
                                if (i > 0) {
                                    hashMap.put(string, String.valueOf(i));
                                }
                                if (!TextUtils.isEmpty(string4)) {
                                    hashMap2.put(string, string4);
                                }
                                if (i3 != 0 && i4 != 0) {
                                    hashMap3.put(string, new i(string, i4, i3));
                                }
                                if (!TextUtils.isEmpty(string5)) {
                                    try {
                                        if (new JSONObject(string5).has("idtype")) {
                                            hashSet5.add(string);
                                        }
                                    } catch (JSONException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                            } while (cursor.moveToNext());
                        }
                    } catch (SQLiteFullException e3) {
                        cursor2 = cursor;
                        com.baidu.f.a.r(cursor2);
                        return;
                    } catch (RuntimeException e4) {
                        e = e4;
                        e.printStackTrace();
                        com.baidu.f.a.r(cursor);
                        return;
                    }
                }
                com.baidu.f.a.r(cursor);
            } catch (Throwable th2) {
                th = th2;
                com.baidu.f.a.r(readableDatabase);
                throw th;
            }
        } catch (SQLiteFullException e5) {
        } catch (RuntimeException e6) {
            cursor = null;
            e = e6;
        } catch (Throwable th3) {
            readableDatabase = 0;
            th = th3;
            com.baidu.f.a.r(readableDatabase);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00a5 A[Catch: SQLiteFullException -> 0x00cb, RuntimeException -> 0x00d3, all -> 0x00db, Merged into TryCatch #2 {all -> 0x00db, SQLiteFullException -> 0x00cb, RuntimeException -> 0x00d3, blocks: (B:3:0x0069, B:5:0x0074, B:7:0x007a, B:8:0x0092, B:13:0x00a5, B:15:0x00ad, B:16:0x00b5, B:17:0x00bd, B:24:0x00cc, B:27:0x00d4), top: B:33:0x0069 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(SparseArray<ArrayList> sparseArray) {
        int i;
        Cursor cursor = null;
        SQLiteDatabase readableDatabase = this.jWC.getReadableDatabase();
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ").append("eventid").append(" , ").append("type").append(" , ").append("cycle").append(" FROM ").append("config").append(" WHERE ").append("switch").append("=\"").append("1").append("\"");
        try {
            cursor = readableDatabase.rawQuery(sb.toString(), null);
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
                            arrayList.add(new g(string, string2));
                        }
                    }
                    i = i2;
                    if (string != null) {
                    }
                } while (cursor.moveToNext());
            }
        } catch (SQLiteFullException e) {
            e.printStackTrace();
        } catch (RuntimeException e2) {
            e2.printStackTrace();
        } finally {
            com.baidu.f.a.r(cursor);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(ArrayList<g> arrayList, s sVar) {
        int i;
        String d = d(arrayList, true);
        if (TextUtils.isEmpty(d)) {
            i = 0;
        } else {
            StringBuilder sb = new StringBuilder(256);
            sb.append("SELECT * ").append(" FROM ").append("flow").append(" WHERE ").append("flowid").append(" in (").append(d).append(")");
            i = a(sb.toString(), sVar);
        }
        String d2 = d(arrayList, false);
        if (!TextUtils.isEmpty(d2)) {
            StringBuilder sb2 = new StringBuilder(256);
            sb2.append("SELECT *  FROM ").append(NotificationCompat.CATEGORY_EVENT).append(" WHERE ").append("eventid").append(" in (").append(d2).append(")").append(" AND ").append("flowhandle").append(" = ").append(-1);
            return i | b(sb2.toString(), sVar);
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(s sVar) {
        StringBuilder sb = new StringBuilder(256);
        sb.append(" SELECT * FROM ").append("flow");
        int a = a(sb.toString(), sVar);
        StringBuilder sb2 = new StringBuilder(256);
        sb2.append("SELECT * FROM ").append(NotificationCompat.CATEGORY_EVENT).append(" WHERE ").append("flowhandle").append(" = ").append(-1);
        return a | b(sb2.toString(), sVar);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:88:0x0076 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x018c  */
    /* JADX WARN: Type inference failed for: r8v18, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int a(String str, s sVar) {
        Cursor cursor;
        RuntimeException runtimeException;
        int i = 0;
        ArrayList<k> arrayList = new ArrayList<>();
        Cursor cursor2 = null;
        long j = Long.MAX_VALUE;
        long j2 = 0;
        try {
            try {
                try {
                    cursor2 = this.jWC.getReadableDatabase().rawQuery(str, null);
                    if (cursor2 != null) {
                        try {
                            if (cursor2.getCount() > 0) {
                                cursor2.moveToFirst();
                                int columnIndex = cursor2.getColumnIndex("flowid");
                                int columnIndex2 = cursor2.getColumnIndex("flowhandle");
                                int columnIndex3 = cursor2.getColumnIndex("state");
                                int columnIndex4 = cursor2.getColumnIndex("begintime");
                                int columnIndex5 = cursor2.getColumnIndex(LogBuilder.KEY_END_TIME);
                                int columnIndex6 = cursor2.getColumnIndex("content");
                                int columnIndex7 = cursor2.getColumnIndex("option");
                                int columnIndex8 = cursor2.getColumnIndex("reserve1");
                                int columnIndex9 = cursor2.getColumnIndex("reserve2");
                                int columnIndex10 = cursor2.getColumnIndex("slot");
                                int columnIndex11 = cursor2.getColumnIndex("extend");
                                long j3 = "extend";
                                while (true) {
                                    try {
                                        j3 = j;
                                        if ("2".equals(cursor2.getString(columnIndex3)) || (Math.abs(cursor2.getLong(columnIndex4) - System.currentTimeMillis()) > 86400000 && (cursor2.getInt(columnIndex7) & 4) != 0)) {
                                            k kVar = new k();
                                            kVar.setId(cursor2.getString(columnIndex));
                                            kVar.gX(cursor2.getInt(columnIndex2));
                                            kVar.aA(cursor2.getLong(columnIndex4));
                                            kVar.setEndTime(cursor2.getLong(columnIndex5));
                                            long endTime = (kVar.getEndTime() <= 0 || kVar.getEndTime() <= j2) ? j2 : kVar.getEndTime();
                                            try {
                                                if (kVar.acN() > 0 && kVar.acN() < j3) {
                                                    j3 = kVar.acN();
                                                }
                                                kVar.setContent(cursor2.getString(columnIndex6));
                                                kVar.lA(cursor2.getString(columnIndex8));
                                                if (!TextUtils.isEmpty(cursor2.getString(columnIndex9))) {
                                                    kVar.setCategory(cursor2.getString(columnIndex9));
                                                }
                                                if (columnIndex10 >= 0 && !TextUtils.isEmpty(cursor2.getString(columnIndex10))) {
                                                    kVar.lB(cursor2.getString(columnIndex10));
                                                }
                                                if (!TextUtils.isEmpty(cursor2.getString(columnIndex11))) {
                                                    try {
                                                        if (new JSONObject(cursor2.getString(columnIndex11)).has("ctr")) {
                                                            kVar.dI(true);
                                                        }
                                                    } catch (JSONException e) {
                                                        e.printStackTrace();
                                                    }
                                                }
                                                arrayList.add(kVar);
                                                sVar.U(kVar.acH(), Integer.parseInt(kVar.getId()));
                                                j2 = endTime;
                                                j = j3;
                                            } catch (SQLiteFullException e2) {
                                                j2 = endTime;
                                                j = j3;
                                                com.baidu.f.a.r(cursor2);
                                                if (arrayList.size() > 0) {
                                                }
                                                sVar.m(j, j2);
                                                return i;
                                            } catch (RuntimeException e3) {
                                                j2 = endTime;
                                                j = j3;
                                                cursor = cursor2;
                                                runtimeException = e3;
                                                try {
                                                    runtimeException.printStackTrace();
                                                    com.baidu.f.a.r(cursor);
                                                    if (arrayList.size() > 0) {
                                                    }
                                                    sVar.m(j, j2);
                                                    return i;
                                                } catch (Throwable th) {
                                                    th = th;
                                                    cursor2 = cursor;
                                                    com.baidu.f.a.r(cursor2);
                                                    throw th;
                                                }
                                            }
                                        } else {
                                            j = j3;
                                        }
                                        boolean moveToNext = cursor2.moveToNext();
                                        if (!moveToNext) {
                                            break;
                                        }
                                        j3 = moveToNext;
                                    } catch (SQLiteFullException e4) {
                                        j = j3;
                                    } catch (RuntimeException e5) {
                                        j = j3;
                                        cursor = cursor2;
                                        runtimeException = e5;
                                    }
                                }
                                i = 1;
                            }
                        } catch (RuntimeException e6) {
                            cursor = cursor2;
                            runtimeException = e6;
                        }
                    }
                    com.baidu.f.a.r(cursor2);
                } catch (SQLiteFullException e7) {
                }
            } catch (RuntimeException e8) {
                cursor = null;
                runtimeException = e8;
            }
            if (arrayList.size() > 0) {
                b(arrayList, sVar);
            }
            sVar.m(j, j2);
            return i;
        } catch (Throwable th2) {
            th = th2;
            com.baidu.f.a.r(cursor2);
            throw th;
        }
    }

    private void b(ArrayList<k> arrayList, s sVar) {
        Cursor cursor;
        Cursor cursor2 = null;
        SQLiteDatabase readableDatabase = this.jWC.getReadableDatabase();
        try {
            Iterator<k> it = arrayList.iterator();
            while (it.hasNext()) {
                k next = it.next();
                if (next.acH() >= 0) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("id", next.getId());
                    jSONObject.put(LogBuilder.KEY_START_TIME, Long.toString(next.acN()));
                    jSONObject.put(LogBuilder.KEY_END_TIME, Long.toString(next.getEndTime()));
                    jSONObject.put("type", "1");
                    if (!TextUtils.isEmpty(next.getContent())) {
                        jSONObject.put("content", next.getContent());
                    }
                    if (!TextUtils.isEmpty(next.acI())) {
                        jSONObject.put("abtest", next.acI());
                        sVar.lG("1");
                    }
                    if (!TextUtils.isEmpty(next.getCategory())) {
                        jSONObject.put("c", next.getCategory());
                    }
                    if (next.acP() != null) {
                        jSONObject.put("part", next.acP());
                    }
                    if (next.acE()) {
                        jSONObject.put("of", "1");
                    }
                    jSONObject.put("idtype", e.cAT().lx(next.getId()));
                    JSONArray jSONArray = new JSONArray();
                    StringBuilder sb = new StringBuilder(256);
                    sb.append("SELECT ").append("eventid").append(" , ").append("begintime").append(" , ").append("content").append(" FROM ").append(NotificationCompat.CATEGORY_EVENT).append(" WHERE ").append("flowhandle").append(" = ").append(next.acH());
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
                        com.baidu.f.a.r(cursor2);
                        cursor = cursor2;
                    } catch (SQLiteFullException e) {
                        com.baidu.f.a.r(cursor2);
                        cursor = cursor2;
                    } catch (Throwable th) {
                        com.baidu.f.a.r(cursor2);
                        throw th;
                    }
                    sVar.bt(jSONObject);
                } else {
                    cursor = cursor2;
                }
                cursor2 = cursor;
            }
        } catch (RuntimeException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1262=4] */
    private int b(String str, s sVar) {
        Cursor cursor;
        RuntimeException runtimeException;
        int i = 0;
        Cursor cursor2 = null;
        long j = Long.MAX_VALUE;
        long j2 = 0;
        try {
            try {
                Cursor rawQuery = this.jWC.getReadableDatabase().rawQuery(str, null);
                if (rawQuery != null) {
                    try {
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
                                String string = rawQuery.getString(columnIndex);
                                jSONObject.put("id", string);
                                long j3 = rawQuery.getLong(columnIndex2);
                                jSONObject.put("timestamp", Long.toString(j3));
                                if (j3 > 0) {
                                    if (j3 < j) {
                                        j = j3;
                                    }
                                    if (j3 > j2) {
                                        j2 = j3;
                                    }
                                }
                                jSONObject.put("type", "0");
                                if (!TextUtils.isEmpty(rawQuery.getString(columnIndex3))) {
                                    jSONObject.put("content", rawQuery.getString(columnIndex3));
                                }
                                if (!TextUtils.isEmpty(rawQuery.getString(columnIndex4))) {
                                    jSONObject.put("abtest", rawQuery.getString(columnIndex4));
                                    sVar.lG("1");
                                }
                                if (!TextUtils.isEmpty(rawQuery.getString(columnIndex5))) {
                                    jSONObject.put("c", rawQuery.getString(columnIndex5));
                                }
                                if (!TextUtils.isEmpty(rawQuery.getString(columnIndex6)) && new JSONObject(rawQuery.getString(columnIndex6)).has("ctr")) {
                                    jSONObject.put("of", "1");
                                }
                                jSONObject.put("idtype", e.cAT().lx(string));
                                sVar.bt(jSONObject);
                                sVar.lF(rawQuery.getString(columnIndex));
                            } while (rawQuery.moveToNext());
                            i = 1;
                        }
                    } catch (RuntimeException e) {
                        cursor = rawQuery;
                        runtimeException = e;
                        try {
                            runtimeException.printStackTrace();
                            com.baidu.f.a.r(cursor);
                            sVar.m(j, j2);
                            return i;
                        } catch (Throwable th) {
                            th = th;
                            cursor2 = cursor;
                            com.baidu.f.a.r(cursor2);
                            throw th;
                        }
                    }
                }
                com.baidu.f.a.r(rawQuery);
            } catch (RuntimeException e2) {
                cursor = null;
                runtimeException = e2;
            }
        } catch (SQLiteFullException e3) {
            com.baidu.f.a.r(null);
        } catch (JSONException e4) {
            com.baidu.f.a.r(null);
        } catch (Throwable th2) {
            th = th2;
            com.baidu.f.a.r(cursor2);
            throw th;
        }
        sVar.m(j, j2);
        return i;
    }

    private String d(ArrayList<g> arrayList, boolean z) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            g gVar = arrayList.get(i2);
            if (z && !"0".equals(gVar.getType())) {
                if (i > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                } else {
                    i++;
                }
                sb.append(gVar.getId());
            } else if (!z && "0".equals(gVar.getType())) {
                if (i > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                } else {
                    i++;
                }
                sb.append(gVar.getId());
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ah(final List<h> list) {
        if (list != null && list.size() != 0) {
            new b() { // from class: com.baidu.ubc.a.13
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // com.baidu.ubc.a.b
                protected boolean b(SQLiteDatabase sQLiteDatabase) {
                    for (h hVar : list) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("eventid", hVar.getId());
                        contentValues.put("type", hVar.getType());
                        if ("1".equals(hVar.acy())) {
                            contentValues.put("cycle", (Integer) 0);
                        } else {
                            contentValues.put("cycle", Integer.valueOf(hVar.getTimeout()));
                        }
                        contentValues.put("switch", hVar.acx());
                        contentValues.put("reserve1", hVar.acz());
                        if (!TextUtils.isEmpty(hVar.getCategory())) {
                            contentValues.put("reserve2", hVar.getCategory());
                        }
                        contentValues.put("sample", Integer.valueOf(hVar.acA()));
                        if (hVar.acB() != 0 && hVar.acC() != 0) {
                            contentValues.put("recordrule", Integer.valueOf(hVar.acB()));
                            contentValues.put("uploadrule", Integer.valueOf(hVar.acC()));
                        }
                        if (TextUtils.equals(hVar.acD(), "1")) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("idtype", "1");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            contentValues.put("extend", jSONObject.toString());
                        }
                        sQLiteDatabase.replace("config", null, contentValues);
                    }
                    return true;
                }
            }.c(this.jWC.getWritableDatabase());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(final SparseArray<Integer> sparseArray, final ArrayList<String> arrayList, final boolean z, final String str) {
        b bVar = new b() { // from class: com.baidu.ubc.a.2
            long beginTime;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
                this.beginTime = System.currentTimeMillis();
            }

            @Override // com.baidu.ubc.a.b
            protected boolean b(SQLiteDatabase sQLiteDatabase) {
                if (sparseArray != null && sparseArray.size() > 0) {
                    int size = sparseArray.size();
                    ArrayList arrayList2 = new ArrayList(size);
                    for (int i = 0; i < size; i++) {
                        arrayList2.add(Integer.valueOf(sparseArray.keyAt(i)));
                    }
                    String n = a.this.n(arrayList2);
                    StringBuilder sb = new StringBuilder();
                    sb.append("flowhandle").append(" in (").append(n).append(")");
                    o.lE("delete flow table flow count:" + sQLiteDatabase.delete("flow", sb.toString(), null));
                    o.lE("delete flow table event count:" + sQLiteDatabase.delete(NotificationCompat.CATEGORY_EVENT, sb.toString(), null));
                }
                if (arrayList != null && arrayList.size() > 0) {
                    String n2 = a.this.n(arrayList);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("eventid").append(" in (").append(n2).append(")").append(" AND ").append("flowhandle").append(" = ").append(-1);
                    o.lE("delete event table event count:" + sQLiteDatabase.delete(NotificationCompat.CATEGORY_EVENT, sb2.toString(), null));
                }
                if ((sparseArray != null && sparseArray.size() > 0) || (arrayList != null && arrayList.size() > 0)) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("filename", str);
                    contentValues.put("state", "0");
                    contentValues.put("reserve1", z ? "1" : "0");
                    sQLiteDatabase.insert(BdStatsConstant.OpSubType.FILE, null, contentValues);
                }
                o.lE("delete total time:" + (System.currentTimeMillis() - this.beginTime));
                return true;
            }
        };
        bVar.c(this.jWC.getWritableDatabase());
        return bVar.Hr();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void lm(final String str) {
        new b() { // from class: com.baidu.ubc.a.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.baidu.ubc.a.b
            protected boolean b(SQLiteDatabase sQLiteDatabase) {
                StringBuilder sb = new StringBuilder();
                sb.append("filename").append("=\"").append(str).append("\"");
                sQLiteDatabase.delete(BdStatsConstant.OpSubType.FILE, sb.toString(), null);
                return true;
            }
        }.c(this.jWC.getWritableDatabase());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ln(final String str) {
        new b() { // from class: com.baidu.ubc.a.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.baidu.ubc.a.b
            protected boolean b(SQLiteDatabase sQLiteDatabase) {
                StringBuilder sb = new StringBuilder();
                sb.append("filename").append("=\"").append(str).append("\"");
                ContentValues contentValues = new ContentValues();
                contentValues.put("state", "1");
                sQLiteDatabase.update(BdStatsConstant.OpSubType.FILE, contentValues, sb.toString(), null);
                return true;
            }
        }.c(this.jWC.getWritableDatabase());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void acf() {
        new b() { // from class: com.baidu.ubc.a.5
            @Override // com.baidu.ubc.a.b
            protected boolean b(SQLiteDatabase sQLiteDatabase) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("state", "1");
                sQLiteDatabase.update(BdStatsConstant.OpSubType.FILE, contentValues, null, null);
                return true;
            }
        }.c(this.jWC.getWritableDatabase());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String n(ArrayList arrayList) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            if (i > 0) {
                sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            sb.append(arrayList.get(i));
        }
        return sb.toString();
    }

    final long acg() {
        return this.jWC.acg();
    }

    final long ach() {
        return this.jWC.ach();
    }

    /* renamed from: com.baidu.ubc.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0549a extends SQLiteOpenHelper {
        private String bNZ;
        private Context mContext;

        C0549a(Context context, String str) {
            super(context.getApplicationContext(), str, (SQLiteDatabase.CursorFactory) null, 5);
            this.bNZ = str;
            this.mContext = context.getApplicationContext();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("CREATE TABLE event (_id INTEGER PRIMARY KEY AUTOINCREMENT,flowhandle INTEGER,eventid TEXT,begintime LONG,content TEXT,reserve1 TEXT,reserve2 TEXT,extend TEXT );");
            sQLiteDatabase.execSQL("CREATE TABLE flow (_id INTEGER PRIMARY KEY AUTOINCREMENT,flowid TEXT,flowhandle INTEGER,state TEXT,begintime LONG,endtime LONG,content TEXT,option INTEGER,reserve1 TEXT,reserve2 TEXT,slot TEXT,extend TEXT );");
            sQLiteDatabase.execSQL("CREATE TABLE config (eventid TEXT PRIMARY KEY,type TEXT,recordrule TEXT,uploadrule TEXT,cycle INTEGER,switch TEXT,sample INTEGER,reserve1 TEXT,reserve2 TEXT,extend TEXT);");
            sQLiteDatabase.execSQL("CREATE TABLE file (filename TEXT PRIMARY KEY,state TEXT,reserve1 TEXT,reserve2 TEXT);");
            r.cAU().putString("ubc_version_md5", "0");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            while (i < i2) {
                switch (i) {
                    case 1:
                        z(sQLiteDatabase);
                        break;
                    case 2:
                        C(sQLiteDatabase);
                        break;
                    case 3:
                        A(sQLiteDatabase);
                        break;
                    case 4:
                        B(sQLiteDatabase);
                        break;
                }
                i++;
            }
        }

        private void z(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE file (filename TEXT PRIMARY KEY,state TEXT,reserve1 TEXT,reserve2 TEXT);");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private void A(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE event ADD COLUMN extend TEXT");
                sQLiteDatabase.execSQL("ALTER TABLE flow ADD COLUMN extend TEXT");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private void B(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE config ADD COLUMN extend TEXT");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        private void C(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE config ADD COLUMN sample TEXT");
                sQLiteDatabase.execSQL("ALTER TABLE flow ADD COLUMN slot TEXT");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public synchronized SQLiteDatabase getReadableDatabase() {
            SQLiteDatabase sQLiteDatabase;
            sQLiteDatabase = null;
            try {
                sQLiteDatabase = super.getReadableDatabase();
            } catch (Exception e) {
                e.printStackTrace();
                if (new File(this.mContext.getDatabasePath(this.bNZ).getPath()).delete()) {
                    sQLiteDatabase = super.getReadableDatabase();
                    r.cAU().putString("ubc_version_md5", "0");
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", "delDB");
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    UBC.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, jSONObject.toString());
                }
            }
            return sQLiteDatabase;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public synchronized SQLiteDatabase getWritableDatabase() {
            SQLiteDatabase sQLiteDatabase;
            sQLiteDatabase = null;
            try {
                sQLiteDatabase = super.getWritableDatabase();
            } catch (Exception e) {
                e.printStackTrace();
                if (new File(this.mContext.getDatabasePath(this.bNZ).getPath()).delete()) {
                    sQLiteDatabase = super.getWritableDatabase();
                    r.cAU().putString("ubc_version_md5", "0");
                    UBC.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "delDB");
                }
            }
            return sQLiteDatabase;
        }

        long acg() {
            return new File(this.mContext.getDatabasePath(this.bNZ).getPath()).length();
        }

        long ach() {
            return new File(this.mContext.getDatabasePath(this.bNZ).getPath() + "-journal").length();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public abstract class b {
        private boolean bOa;

        protected abstract boolean b(SQLiteDatabase sQLiteDatabase);

        private b() {
            this.bOa = false;
        }

        public void c(SQLiteDatabase sQLiteDatabase) {
            if (sQLiteDatabase != null) {
                this.bOa = false;
                sQLiteDatabase.beginTransaction();
                try {
                    try {
                        if (b(sQLiteDatabase)) {
                            sQLiteDatabase.setTransactionSuccessful();
                            this.bOa = true;
                        }
                        try {
                            sQLiteDatabase.endTransaction();
                        } catch (RuntimeException e) {
                        }
                    } catch (RuntimeException e2) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", "DBError");
                            jSONObject.put("db_size", a.this.acg());
                            jSONObject.put("db_log_size", a.this.ach());
                            jSONObject.put("exception", Log.getStackTraceString(e2));
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                        UBC.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, jSONObject.toString());
                        try {
                            sQLiteDatabase.endTransaction();
                        } catch (RuntimeException e4) {
                        }
                    }
                } catch (Throwable th) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (RuntimeException e5) {
                    }
                    throw th;
                }
            }
        }

        protected boolean Hr() {
            return this.bOa;
        }
    }
}
