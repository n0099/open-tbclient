package com.baidu.tieba.util;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.tieba.data.Config;
/* loaded from: classes.dex */
public class DatabaseSdHelper {
    private int mVersion;
    private boolean mHaveCreate = false;
    private onCreateCallback mOnCreateCallback = null;
    private String mName = Config.TMP_DATABASE_NAME;
    private String mPath = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + Config.TMPDIRNAME + "/" + this.mName;

    /* loaded from: classes.dex */
    public interface onCreateCallback {
        void onCreate();
    }

    public DatabaseSdHelper() {
        this.mVersion = 1;
        this.mVersion = 3;
    }

    private void ExecSQL(SQLiteDatabase db, String sql) {
        try {
            db.execSQL(sql);
        } catch (Exception e) {
            TiebaLog.log_e(3, getClass().getName(), "ExecSQL", sql);
        }
    }

    public SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase database = null;
        if (FileHelper.CheckTempDir()) {
            this.mHaveCreate = FileHelper.CheckFile(this.mName);
            database = SQLiteDatabase.openOrCreateDatabase(this.mPath, (SQLiteDatabase.CursorFactory) null);
            if (database != null) {
                if (!this.mHaveCreate) {
                    onCreateDatabase(database);
                    database.setVersion(this.mVersion);
                } else {
                    int version = database.getVersion();
                    if (version != this.mVersion) {
                        onUpdateDatabase(database, version, this.mVersion);
                        database.setVersion(this.mVersion);
                    }
                }
            }
        }
        return database;
    }

    private void onCreateDatabase(SQLiteDatabase database) {
        if (database != null) {
            ExecSQL(database, "CREATE TABLE if not exists pb_photo(key varchar(50) Primary Key,image blob,date Integer)");
            ExecSQL(database, "CREATE INDEX if not exists pb_photo_index ON pb_photo(date)");
            ExecSQL(database, "CREATE TABLE if not exists friend_photo(key varchar(50) Primary Key,image blob,date Integer)");
            ExecSQL(database, "CREATE INDEX if not exists friend_photo_index ON friend_photo(date)");
        }
        ExeCallback();
    }

    private void onUpdateDatabase(SQLiteDatabase database, int old_version, int new_version) {
        ExeCallback();
    }

    private void ExeCallback() {
        if (this.mOnCreateCallback != null) {
            try {
                this.mOnCreateCallback.onCreate();
            } catch (Exception ex) {
                TiebaLog.e(getClass().getName(), "onCreateDatabase", ex.getMessage());
            }
        }
    }

    public void setOnCreateCallback(onCreateCallback callback) {
        this.mOnCreateCallback = callback;
    }
}
