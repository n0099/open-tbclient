package com.baidu.tieba.util;

import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    private int f2613a;
    private boolean b = false;
    private u e = null;
    private String c = "tieba_database.db";
    private String d = x.f2616a + "/tieba/" + this.c;

    public t() {
        this.f2613a = 1;
        this.f2613a = 11;
    }

    private void a(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL(str);
        } catch (Exception e) {
            bd.a(3, getClass().getName(), "ExecSQL", str);
        }
    }

    public SQLiteDatabase a() {
        SQLiteDatabase sQLiteDatabase = null;
        if (x.c()) {
            this.b = x.b(this.c);
            sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(this.d, (SQLiteDatabase.CursorFactory) null);
            if (sQLiteDatabase != null) {
                if (!this.b) {
                    a(sQLiteDatabase);
                    sQLiteDatabase.setVersion(this.f2613a);
                } else {
                    int version = sQLiteDatabase.getVersion();
                    if (version != this.f2613a) {
                        a(sQLiteDatabase, version, this.f2613a);
                        sQLiteDatabase.setVersion(this.f2613a);
                    }
                }
            }
        }
        return sQLiteDatabase;
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            a(sQLiteDatabase, "CREATE TABLE if not exists pb_photo(key varchar(50) Primary Key,image blob,date Integer,stamp Integer)");
            a(sQLiteDatabase, "CREATE INDEX if not exists pb_photo_index ON pb_photo(date)");
            a(sQLiteDatabase, "CREATE TABLE if not exists friend_photo(key varchar(50) Primary Key,image blob,date Integer,stamp Integer)");
            a(sQLiteDatabase, "CREATE INDEX if not exists friend_photo_index ON friend_photo(date)");
            b(sQLiteDatabase);
        }
        b();
    }

    private void a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i <= 9) {
            b(sQLiteDatabase);
        }
        if (i < 11) {
            a(sQLiteDatabase, "ALTER TABLE pb_photo ADD stamp Integer");
            a(sQLiteDatabase, "ALTER TABLE friend_photo ADD stamp Integer");
            if (i > 9) {
                a(sQLiteDatabase, "ALTER TABLE user_icon ADD stamp Integer");
            }
        }
        b();
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase, "CREATE TABLE if not exists user_icon(key varchar(50) Primary Key,image blob,date Integer,stamp Integer)");
        a(sQLiteDatabase, "CREATE INDEX if not exists user_icon_index ON user_icon(date)");
    }

    private void b() {
        if (this.e != null) {
            try {
                this.e.a();
            } catch (Exception e) {
                bd.b(getClass().getName(), "onCreateDatabase", e.getMessage());
            }
        }
    }

    public void a(u uVar) {
        this.e = uVar;
    }
}
