package com.baidu.tieba.util;

import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class u {
    private int a;
    private boolean b = false;
    private v e = null;
    private String c = "tieba_database.db";
    private String d = y.a + "/tieba/" + this.c;

    public u() {
        this.a = 1;
        this.a = 11;
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
        if (y.c()) {
            this.b = y.b(this.c);
            sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(this.d, (SQLiteDatabase.CursorFactory) null);
            if (sQLiteDatabase != null) {
                if (!this.b) {
                    a(sQLiteDatabase);
                    sQLiteDatabase.setVersion(this.a);
                } else {
                    int version = sQLiteDatabase.getVersion();
                    if (version != this.a) {
                        a(sQLiteDatabase, version, this.a);
                        sQLiteDatabase.setVersion(this.a);
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
                be.b(getClass().getName(), "onCreateDatabase", e.getMessage());
            }
        }
    }

    public void a(v vVar) {
        this.e = vVar;
    }
}
