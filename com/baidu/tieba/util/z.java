package com.baidu.tieba.util;

import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public final class z {
    private int a;
    private boolean b = false;
    private aa e = null;
    private String c = "tieba_database.db";
    private String d = af.a + "/" + com.baidu.tieba.data.i.k() + "/" + this.c;

    public z() {
        this.a = 1;
        this.a = 11;
    }

    private void a(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL(str);
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "ExecSQL", str);
        }
    }

    public final SQLiteDatabase a() {
        SQLiteDatabase sQLiteDatabase = null;
        if (af.c()) {
            this.b = af.b(this.c);
            sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(this.d, (SQLiteDatabase.CursorFactory) null);
            if (sQLiteDatabase != null) {
                if (!this.b) {
                    if (sQLiteDatabase != null) {
                        a(sQLiteDatabase, "CREATE TABLE if not exists pb_photo(key varchar(50) Primary Key,image blob,date Integer,stamp Integer)");
                        a(sQLiteDatabase, "CREATE INDEX if not exists pb_photo_index ON pb_photo(date)");
                        a(sQLiteDatabase, "CREATE TABLE if not exists friend_photo(key varchar(50) Primary Key,image blob,date Integer,stamp Integer)");
                        a(sQLiteDatabase, "CREATE INDEX if not exists friend_photo_index ON friend_photo(date)");
                        a(sQLiteDatabase);
                    }
                    b();
                    sQLiteDatabase.setVersion(this.a);
                } else {
                    int version = sQLiteDatabase.getVersion();
                    if (version != this.a) {
                        int i = this.a;
                        if (version <= 9) {
                            a(sQLiteDatabase);
                        }
                        if (version < 11) {
                            a(sQLiteDatabase, "ALTER TABLE pb_photo ADD stamp Integer");
                            a(sQLiteDatabase, "ALTER TABLE friend_photo ADD stamp Integer");
                            if (version > 9) {
                                a(sQLiteDatabase, "ALTER TABLE user_icon ADD stamp Integer");
                            }
                        }
                        b();
                        sQLiteDatabase.setVersion(this.a);
                    }
                }
            }
        }
        return sQLiteDatabase;
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase, "CREATE TABLE if not exists user_icon(key varchar(50) Primary Key,image blob,date Integer,stamp Integer)");
        a(sQLiteDatabase, "CREATE INDEX if not exists user_icon_index ON user_icon(date)");
    }

    private void b() {
        if (this.e != null) {
            try {
                this.e.a();
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b(getClass().getName(), "onCreateDatabase", e.getMessage());
            }
        }
    }

    public final void a(aa aaVar) {
        this.e = aaVar;
    }
}
