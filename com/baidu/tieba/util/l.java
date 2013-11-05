package com.baidu.tieba.util;

import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private int f2453a;
    private boolean b = false;
    private m e = null;
    private String c = "tieba_database.db";
    private String d = w.f2463a + "/tieba/" + this.c;

    public l() {
        this.f2453a = 1;
        this.f2453a = 9;
    }

    private void a(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL(str);
        } catch (Exception e) {
            be.a(3, getClass().getName(), "ExecSQL", str);
        }
    }

    public SQLiteDatabase a() {
        SQLiteDatabase sQLiteDatabase = null;
        if (w.c()) {
            this.b = w.b(this.c);
            sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(this.d, (SQLiteDatabase.CursorFactory) null);
            if (sQLiteDatabase != null) {
                if (!this.b) {
                    a(sQLiteDatabase);
                    sQLiteDatabase.setVersion(this.f2453a);
                } else {
                    int version = sQLiteDatabase.getVersion();
                    if (version != this.f2453a) {
                        a(sQLiteDatabase, version, this.f2453a);
                        sQLiteDatabase.setVersion(this.f2453a);
                    }
                }
            }
        }
        return sQLiteDatabase;
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            a(sQLiteDatabase, "CREATE TABLE if not exists pb_photo(key varchar(50) Primary Key,image blob,date Integer)");
            a(sQLiteDatabase, "CREATE INDEX if not exists pb_photo_index ON pb_photo(date)");
            a(sQLiteDatabase, "CREATE TABLE if not exists friend_photo(key varchar(50) Primary Key,image blob,date Integer)");
            a(sQLiteDatabase, "CREATE INDEX if not exists friend_photo_index ON friend_photo(date)");
        }
        b();
    }

    private void a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        b();
    }

    private void b() {
        if (this.e != null) {
            try {
                this.e.a();
            } catch (Exception e) {
                be.b(getClass().getName(), "onCreateDatabase", e.getMessage());
            }
        }
    }

    public void a(m mVar) {
        this.e = mVar;
    }
}
