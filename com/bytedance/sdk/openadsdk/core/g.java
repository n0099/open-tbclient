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
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class g {
    private static final Object c = new Object();

    /* renamed from: a  reason: collision with root package name */
    private c f6850a;

    /* renamed from: b  reason: collision with root package name */
    private Context f6851b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Context context) {
        try {
            this.f6851b = context == null ? p.a() : context.getApplicationContext();
            if (this.f6850a == null) {
                this.f6850a = new c();
            }
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context c() {
        return this.f6851b == null ? p.a() : this.f6851b;
    }

    /* loaded from: classes4.dex */
    public class c {

        /* renamed from: b  reason: collision with root package name */
        private SQLiteDatabase f6867b = null;

        public c() {
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, MOVE_EXCEPTION, THROW, IF, INVOKE, INVOKE, THROW, MOVE_EXCEPTION] complete} */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        private synchronized void d() {
            try {
                synchronized (g.c) {
                    if (this.f6867b == null || !this.f6867b.isOpen()) {
                        this.f6867b = new a(g.this.c()).getWritableDatabase();
                        this.f6867b.setLockingEnabled(false);
                    }
                }
            } finally {
            }
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        public synchronized void a(String str) throws SQLException {
            try {
                d();
                this.f6867b.execSQL(str);
            } catch (Throwable th) {
                if (e()) {
                    throw th;
                }
            }
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        public synchronized Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            Cursor bVar;
            try {
                d();
                bVar = this.f6867b.query(str, strArr, str2, strArr2, str3, str4, str5);
            } catch (Throwable th) {
                th.printStackTrace();
                bVar = new b();
                if (e()) {
                    throw th;
                }
            }
            return bVar;
        }

        public synchronized int a(String str, ContentValues contentValues, String str2, String[] strArr) {
            int i;
            try {
                d();
                i = this.f6867b.update(str, contentValues, str2, strArr);
            } catch (Exception e) {
                e.printStackTrace();
                i = 0;
                if (e()) {
                    throw e;
                }
            }
            return i;
        }

        public synchronized long a(String str, String str2, ContentValues contentValues) {
            long j;
            try {
                d();
                j = this.f6867b.insert(str, str2, contentValues);
            } catch (Exception e) {
                e.printStackTrace();
                j = -1;
                if (e()) {
                    throw e;
                }
            }
            return j;
        }

        public synchronized int a(String str, String str2, String[] strArr) {
            int i;
            try {
                d();
                i = this.f6867b.delete(str, str2, strArr);
            } catch (Exception e) {
                e.printStackTrace();
                i = 0;
                if (e()) {
                    throw e;
                }
            }
            return i;
        }

        public synchronized void a() {
            d();
            if (this.f6867b != null) {
                this.f6867b.beginTransaction();
            }
        }

        public synchronized void b() {
            d();
            if (this.f6867b != null) {
                this.f6867b.setTransactionSuccessful();
            }
        }

        public synchronized void c() {
            d();
            if (this.f6867b != null) {
                this.f6867b.endTransaction();
            }
        }

        private synchronized boolean e() {
            boolean z;
            SQLiteDatabase sQLiteDatabase = this.f6867b;
            if (sQLiteDatabase != null) {
                z = sQLiteDatabase.inTransaction();
            }
            return z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends SQLiteOpenHelper {

        /* renamed from: a  reason: collision with root package name */
        final Context f6854a;

        public a(Context context) {
            super(context, "ttopensdk.db", (SQLiteDatabase.CursorFactory) null, 7);
            this.f6854a = context;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                a(sQLiteDatabase, this.f6854a);
            } catch (Throwable th) {
            }
        }

        private void a(SQLiteDatabase sQLiteDatabase, Context context) {
            com.bytedance.sdk.openadsdk.utils.u.b("DBHelper", "initDB........");
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.c.f.e());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.c.n.g());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.c.l.e());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.l.g.b());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.core.widget.webview.a.a.c());
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            try {
                com.bytedance.sdk.openadsdk.utils.u.b("DBHelper", "onUpgrade....数据库版本升级.....old:" + i + ",new:" + i2);
                if (i <= i2) {
                    a(sQLiteDatabase, g.this.f6851b);
                } else {
                    a(sQLiteDatabase);
                    a(sQLiteDatabase, g.this.f6851b);
                    com.bytedance.sdk.openadsdk.utils.u.b("DBHelper", "onUpgrade...逆向安装.数据库重置-创建表.....");
                }
                switch (i) {
                    case 1:
                        com.bytedance.sdk.openadsdk.utils.u.b("DBHelper", "onUpgrade.....执行表创建.....");
                        return;
                    case 2:
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'ad_video_info';");
                        return;
                    case 3:
                        sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.c.n.g());
                        return;
                    case 4:
                        sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.core.widget.webview.a.a.c());
                        return;
                    case 5:
                        sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.c.l.e());
                        return;
                    default:
                        return;
                }
            } catch (Throwable th) {
            }
        }

        private void a(SQLiteDatabase sQLiteDatabase) {
            ArrayList<String> b2 = b(sQLiteDatabase);
            if (b2 != null && b2.size() > 0) {
                Iterator<String> it = b2.iterator();
                while (it.hasNext()) {
                    sQLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s ;", it.next()));
                }
            }
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
            } catch (Exception e) {
            }
            return arrayList;
        }
    }

    public c a() {
        return this.f6850a;
    }

    /* loaded from: classes4.dex */
    private class b extends AbstractCursor {
        private b() {
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getCount() {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String[] getColumnNames() {
            return new String[0];
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String getString(int i) {
            return null;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public short getShort(int i) {
            return (short) 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getInt(int i) {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public long getLong(int i) {
            return 0L;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public float getFloat(int i) {
            return 0.0f;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public double getDouble(int i) {
            return 0.0d;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public boolean isNull(int i) {
            return true;
        }
    }
}
