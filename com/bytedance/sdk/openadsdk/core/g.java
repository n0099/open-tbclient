package com.bytedance.sdk.openadsdk.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: c  reason: collision with root package name */
    public static final Object f28153c = new Object();

    /* renamed from: a  reason: collision with root package name */
    public c f28154a;

    /* renamed from: b  reason: collision with root package name */
    public Context f28155b;

    /* loaded from: classes6.dex */
    public class b extends AbstractCursor {
        public b() {
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String[] getColumnNames() {
            return new String[0];
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getCount() {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public double getDouble(int i2) {
            return 0.0d;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public float getFloat(int i2) {
            return 0.0f;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getInt(int i2) {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public long getLong(int i2) {
            return 0L;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public short getShort(int i2) {
            return (short) 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String getString(int i2) {
            return null;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public boolean isNull(int i2) {
            return true;
        }
    }

    public g(Context context) {
        try {
            this.f28155b = context == null ? p.a() : context.getApplicationContext();
            if (this.f28154a == null) {
                this.f28154a = new c();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context c() {
        Context context = this.f28155b;
        return context == null ? p.a() : context;
    }

    public c a() {
        return this.f28154a;
    }

    /* loaded from: classes6.dex */
    public class c {

        /* renamed from: b  reason: collision with root package name */
        public SQLiteDatabase f28184b = null;

        public c() {
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, MOVE_EXCEPTION, THROW, IF, INVOKE, INVOKE, THROW, MOVE_EXCEPTION] complete} */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private synchronized void d() {
            try {
                synchronized (g.f28153c) {
                    if (this.f28184b == null || !this.f28184b.isOpen()) {
                        SQLiteDatabase writableDatabase = new a(g.this.c()).getWritableDatabase();
                        this.f28184b = writableDatabase;
                        writableDatabase.setLockingEnabled(false);
                    }
                }
            } finally {
            }
        }

        private synchronized boolean e() {
            boolean z;
            SQLiteDatabase sQLiteDatabase = this.f28184b;
            if (sQLiteDatabase != null) {
                z = sQLiteDatabase.inTransaction();
            }
            return z;
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        public synchronized void a(String str) throws SQLException {
            try {
                d();
                this.f28184b.execSQL(str);
            } catch (Throwable th) {
                if (e()) {
                    throw th;
                }
            }
        }

        public synchronized void b() {
            d();
            if (this.f28184b == null) {
                return;
            }
            this.f28184b.setTransactionSuccessful();
        }

        public synchronized void c() {
            d();
            if (this.f28184b == null) {
                return;
            }
            this.f28184b.endTransaction();
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        public synchronized Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            Cursor cursor;
            try {
                d();
                cursor = this.f28184b.query(str, strArr, str2, strArr2, str3, str4, str5);
            } catch (Throwable th) {
                th.printStackTrace();
                b bVar = new b();
                if (e()) {
                    throw th;
                }
                cursor = bVar;
            }
            return cursor;
        }

        public synchronized int a(String str, ContentValues contentValues, String str2, String[] strArr) {
            int i2;
            try {
                d();
                i2 = this.f28184b.update(str, contentValues, str2, strArr);
            } catch (Exception e2) {
                e2.printStackTrace();
                if (e()) {
                    throw e2;
                }
                i2 = 0;
            }
            return i2;
        }

        public synchronized long a(String str, String str2, ContentValues contentValues) {
            long j;
            try {
                d();
                j = this.f28184b.insert(str, str2, contentValues);
            } catch (Exception e2) {
                e2.printStackTrace();
                if (e()) {
                    throw e2;
                }
                j = -1;
            }
            return j;
        }

        public synchronized int a(String str, String str2, String[] strArr) {
            int i2;
            try {
                d();
                i2 = this.f28184b.delete(str, str2, strArr);
            } catch (Exception e2) {
                e2.printStackTrace();
                if (e()) {
                    throw e2;
                }
                i2 = 0;
            }
            return i2;
        }

        public synchronized void a() {
            d();
            if (this.f28184b == null) {
                return;
            }
            this.f28184b.beginTransaction();
        }
    }

    /* loaded from: classes6.dex */
    public class a extends SQLiteOpenHelper {

        /* renamed from: a  reason: collision with root package name */
        public final Context f28163a;

        public a(Context context) {
            super(context, "ttopensdk.db", (SQLiteDatabase.CursorFactory) null, 7);
            this.f28163a = context;
        }

        private void a(SQLiteDatabase sQLiteDatabase, Context context) {
            com.bytedance.sdk.openadsdk.utils.u.b("DBHelper", "initDB........");
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.c.f.d());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.c.n.f());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.c.l.d());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.m.g.b());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.core.widget.webview.a.a.c());
        }

        private ArrayList<String> b(SQLiteDatabase sQLiteDatabase) {
            ArrayList<String> arrayList = new ArrayList<>();
            try {
                Cursor rawQuery = sQLiteDatabase.rawQuery("select name from sqlite_master where type='table' order by name", null);
                if (rawQuery != null) {
                    while (rawQuery.moveToNext()) {
                        String string = rawQuery.getString(0);
                        if (!string.equals("android_metadata") && !string.equals("sqlite_sequence")) {
                            arrayList.add(string);
                        }
                    }
                    rawQuery.close();
                }
            } catch (Exception unused) {
            }
            return arrayList;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                a(sQLiteDatabase, this.f28163a);
            } catch (Throwable unused) {
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            try {
                com.bytedance.sdk.openadsdk.utils.u.b("DBHelper", "onUpgrade....数据库版本升级.....old:" + i2 + ",new:" + i3);
                if (i2 <= i3) {
                    a(sQLiteDatabase, g.this.f28155b);
                } else {
                    a(sQLiteDatabase);
                    a(sQLiteDatabase, g.this.f28155b);
                    com.bytedance.sdk.openadsdk.utils.u.b("DBHelper", "onUpgrade...逆向安装.数据库重置-创建表.....");
                }
                if (i2 == 1) {
                    com.bytedance.sdk.openadsdk.utils.u.b("DBHelper", "onUpgrade.....执行表创建.....");
                } else if (i2 == 2) {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'ad_video_info';");
                } else if (i2 == 3) {
                    sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.c.n.f());
                } else if (i2 == 4) {
                    sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.core.widget.webview.a.a.c());
                } else if (i2 != 5) {
                } else {
                    sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.c.l.d());
                }
            } catch (Throwable unused) {
            }
        }

        private void a(SQLiteDatabase sQLiteDatabase) {
            ArrayList<String> b2 = b(sQLiteDatabase);
            if (b2 == null || b2.size() <= 0) {
                return;
            }
            Iterator<String> it = b2.iterator();
            while (it.hasNext()) {
                sQLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s ;", it.next()));
            }
        }
    }
}
