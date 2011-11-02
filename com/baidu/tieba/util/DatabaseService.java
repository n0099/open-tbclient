package com.baidu.tieba.util;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.data.MarkData;
import com.baidu.tieba.model.WriteModel;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class DatabaseService {
    private DatabaseLocation mLoc;
    private static Boolean mMarkChanged = true;
    private static Boolean mMarkNumChanged = true;
    private static volatile SQLiteDatabase database = null;
    private static volatile SQLiteDatabase SDdatabase = null;

    /* loaded from: classes.dex */
    public enum DatabaseLocation {
        INNER,
        SDCARD
    }

    public DatabaseService() {
        this.mLoc = DatabaseLocation.INNER;
        if (database == null || !database.isOpen()) {
            synchronized (DatabaseService.class) {
                try {
                    DatabaseHelper mHelper = new DatabaseHelper(TiebaApplication.app);
                    database = mHelper.getWritableDatabase();
                } catch (Exception ex) {
                    TiebaLog.e("DatabaseService", "DatabaseService", "error = " + ex.getMessage());
                }
            }
        }
    }

    public DatabaseService(DatabaseLocation loc) {
        this.mLoc = loc;
        if (this.mLoc != DatabaseLocation.SDCARD || SDdatabase == null || !SDdatabase.isOpen()) {
            if (this.mLoc != DatabaseLocation.INNER || database == null || !database.isOpen()) {
                synchronized (DatabaseService.class) {
                    try {
                        if (this.mLoc == DatabaseLocation.SDCARD) {
                            if (FileHelper.CheckTempDir()) {
                                boolean have_create = FileHelper.CheckFile(Config.TMP_DATABASE_NAME);
                                SDdatabase = SQLiteDatabase.openOrCreateDatabase(FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + Config.TMPDIRNAME + "/" + Config.TMP_DATABASE_NAME, (SQLiteDatabase.CursorFactory) null);
                                if (!have_create) {
                                    onCreateSdDatabase();
                                }
                            }
                        } else {
                            DatabaseHelper mHelper = new DatabaseHelper(TiebaApplication.app);
                            database = mHelper.getWritableDatabase();
                        }
                    } catch (Exception ex) {
                        TiebaLog.e("DatabaseService", "DatabaseService", "error = " + ex.getMessage());
                    }
                }
            }
        }
    }

    public void ExecSQL(String sql) {
        try {
            if (this.mLoc == DatabaseLocation.SDCARD && SDdatabase != null) {
                SDdatabase.execSQL(sql);
            } else if (this.mLoc == DatabaseLocation.INNER && database != null) {
                database.execSQL(sql);
            }
        } catch (Exception ex) {
            TiebaLog.e("DatabaseService", "ExecSQL", "error = " + ex.getMessage());
            TiebaLog.e("DatabaseService", "ExecSQL", sql);
        }
    }

    public Boolean ExecSQL(String sql, Object[] bindArgs) {
        try {
            if (this.mLoc == DatabaseLocation.SDCARD && SDdatabase != null) {
                SDdatabase.execSQL(sql, bindArgs);
            } else if (this.mLoc == DatabaseLocation.INNER && database != null) {
                database.execSQL(sql, bindArgs);
            }
            return true;
        } catch (Exception ex) {
            TiebaLog.e("DatabaseService", "ExecSQL", "error = " + ex.getMessage());
            TiebaLog.e("DatabaseService", "ExecSQL", sql);
            return false;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0042 -> B:7:0x0010). Please submit an issue!!! */
    public Cursor rawQuery(String sql, String[] selectionArgs) {
        try {
        } catch (Exception ex) {
            TiebaLog.e("DatabaseService", "rawQuery", "error = " + ex.getMessage());
        }
        if (this.mLoc == DatabaseLocation.SDCARD && SDdatabase != null) {
            return SDdatabase.rawQuery(sql, selectionArgs);
        }
        if (this.mLoc == DatabaseLocation.INNER && database != null) {
            return database.rawQuery(sql, selectionArgs);
        }
        return null;
    }

    public static void closeDatabase() {
        try {
            if (database != null) {
                database.close();
                database = null;
            }
            if (SDdatabase != null) {
                SDdatabase.close();
                SDdatabase = null;
            }
        } catch (Exception e) {
        }
    }

    private void onCreateSdDatabase() {
        try {
            TiebaApplication.app.resetTDatabaseCreateTime();
        } catch (Exception e) {
        }
        if (SDdatabase != null) {
            SDdatabase.execSQL("CREATE TABLE pb_photo(key varchar(50) Primary Key,image blob,date Integer)");
            SDdatabase.execSQL("CREATE INDEX pb_photo_index ON pb_photo(date)");
            SDdatabase.execSQL("CREATE TABLE friend_photo(key varchar(50) Primary Key,image blob,date Integer)");
            SDdatabase.execSQL("CREATE INDEX friend_photo_index ON friend_photo(date)");
        }
    }

    public static Bitmap getPbPhoto(String key) {
        return getPhoto("pb_photo", key);
    }

    public static Bitmap getFriendPhoto(String key) {
        return getPhoto("friend_photo", key);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    private static Bitmap getPhoto(String tableName, String key) {
        DatabaseService service = new DatabaseService(DatabaseLocation.SDCARD);
        Cursor cursor = null;
        Bitmap bm = null;
        try {
            if (service != null) {
                try {
                    cursor = service.rawQuery("select * from " + tableName + " where key = ?", new String[]{key});
                    if (cursor != null) {
                        if (cursor.moveToFirst()) {
                            bm = BitmapHelper.Bytes2Bitmap(cursor.getBlob(1));
                        }
                        cursor.close();
                    }
                } catch (Exception ex) {
                    TiebaLog.e("DatabaseService", "getPhoto", "error = " + ex.getMessage());
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e) {
                        }
                    }
                }
            }
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e2) {
                }
            }
            return bm;
        } catch (Throwable th) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e3) {
                }
            }
            throw th;
        }
    }

    public static void cashPbPhoto(String key, Bitmap bm) {
        cashPhoto("pb_photo", Config.MAX_CASH_PB_PHOTO_NUM, key, bm);
    }

    public static void cashFriendPhoto(String key, Bitmap bm) {
        cashPhoto("friend_photo", 500, key, bm);
    }

    private static void cashPhoto(String tableName, int maxNum, String key, Bitmap bm) {
        DatabaseService service = new DatabaseService(DatabaseLocation.SDCARD);
        Cursor cursor = null;
        if (service != null) {
            try {
                try {
                    Cursor cursor2 = service.rawQuery("select count(*) from " + tableName, null);
                    int num = 0;
                    if (cursor2 != null) {
                        if (cursor2.moveToFirst()) {
                            num = cursor2.getInt(0);
                        }
                        cursor2.close();
                    }
                    if (num >= maxNum) {
                        Cursor cursor3 = service.rawQuery("select * from " + tableName + " order by date asc limit 1", null);
                        if (cursor3 != null) {
                            cursor3.moveToFirst();
                            String tmp_key = cursor3.getString(0);
                            service.ExecSQL("delete from " + tableName + " where key=?", new String[]{tmp_key});
                            cursor3.close();
                        }
                    }
                    Cursor cursor4 = service.rawQuery("select * from " + tableName + " where key = ?", new String[]{key});
                    if (cursor4 != null) {
                        if (cursor4.moveToFirst()) {
                            service.ExecSQL("delete from " + tableName + " where key=?", new String[]{key});
                        }
                        cursor4.close();
                    }
                    cursor = null;
                    Date date = new Date();
                    service.ExecSQL("Insert into " + tableName + "(key,image,date) values(?,?,?)", new Object[]{key, BitmapHelper.Bitmap2Bytes(bm, 100), Long.valueOf(date.getTime())});
                } catch (Exception ex) {
                    TiebaLog.e("DatabaseService", "cashPhoto", "error = " + ex.getMessage());
                    if (cursor != null) {
                        try {
                            cursor.close();
                            return;
                        } catch (Exception e) {
                            return;
                        }
                    }
                    return;
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e2) {
                    }
                }
                throw th;
            }
        }
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Exception e3) {
            }
        }
    }

    public static void cashLikeData(String data) {
        cachData(0, data);
    }

    public static void delLikeData() {
        delCachData(0);
    }

    public static String getLikeData() {
        return getCachData(0);
    }

    public static void cashRemindData(String data) {
        cachData(1, data);
    }

    public static String getRemindData() {
        return getCachData(1);
    }

    public static void cashPersonData(String data) {
        cachData(2, data);
    }

    public static String getPersonData() {
        return getCachData(2);
    }

    public static void delPersonData() {
        delCachData(2);
    }

    public static void cashReplymeData(String data) {
        cachData(3, data);
    }

    public static void delReplymeData() {
        delCachData(3);
    }

    public static String getReplymeData() {
        return getCachData(3);
    }

    public static void cashAtmeData(String data) {
        cachData(4, data);
    }

    public static void delAtmeData() {
        delCachData(4);
    }

    public static String getAtmeData() {
        return getCachData(4);
    }

    private static void cachData(int type, String data) {
        DatabaseService service = new DatabaseService();
        if (service != null) {
            try {
                service.ExecSQL("delete from cash_data where type=? and account=?", new String[]{String.valueOf(type), TiebaApplication.getCurrentAccount()});
                service.ExecSQL("Insert into cash_data(account,type,data) values(?,?,?)", new Object[]{TiebaApplication.getCurrentAccount(), Integer.valueOf(type), data});
            } catch (Exception ex) {
                TiebaLog.e("DatabaseService", "cachData", "error = " + ex.getMessage());
            }
        }
    }

    private static void delCachData(int type) {
        DatabaseService service = new DatabaseService();
        if (service != null) {
            try {
                service.ExecSQL("delete from cash_data where type=? and account=?", new String[]{String.valueOf(type), TiebaApplication.getCurrentAccount()});
            } catch (Exception ex) {
                TiebaLog.e("DatabaseService", "cachData", "error = " + ex.getMessage());
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    private static String getCachData(int type) {
        String ret = null;
        DatabaseService service = new DatabaseService();
        Cursor cursor = null;
        try {
            if (service != null) {
                try {
                    cursor = service.rawQuery("select * from cash_data where type = ? and account=?", new String[]{String.valueOf(type), TiebaApplication.getCurrentAccount()});
                    if (cursor != null) {
                        if (cursor.moveToFirst()) {
                            ret = cursor.getString(2);
                        }
                        cursor.close();
                    }
                    cursor = null;
                } catch (Exception ex) {
                    TiebaLog.e("DatabaseService", "getCachData", "error = " + ex.getMessage());
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e) {
                        }
                    }
                }
            }
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e2) {
                }
            }
            return ret;
        } catch (Throwable th) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e3) {
                }
            }
            throw th;
        }
    }

    public static void saveAccountData(AccountData data) {
        if (data != null) {
            if (data.getIsActive() == 1) {
                clearActiveAccount();
            }
            DatabaseService service = new DatabaseService();
            try {
                Date date = new Date();
                if (service != null) {
                    service.ExecSQL("delete from account_data where id=?", new String[]{data.getID()});
                    service.ExecSQL("Insert into account_data(id,account,password,bduss,isactive,tbs,time) values(?,?,?,?,?,?,?)", new Object[]{data.getID(), data.getAccount(), data.getPassword(), data.getBDUSS(), Integer.valueOf(data.getIsActive()), data.getTbs(), Long.valueOf(date.getTime())});
                }
            } catch (Exception ex) {
                TiebaLog.e("DatabaseService", "saveAccountData", "error = " + ex.getMessage());
            }
        }
    }

    public static void clearActiveAccount() {
        DatabaseService service = new DatabaseService();
        if (service != null) {
            try {
                service.ExecSQL("update account_data set isactive=0 where isactive=1");
            } catch (Exception ex) {
                TiebaLog.e("DatabaseService", "updataAccountData", "error = " + ex.getMessage());
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    public static ArrayList<AccountData> getAllAccountData() {
        DatabaseService service = new DatabaseService();
        ArrayList<AccountData> ret = new ArrayList<>();
        Cursor cursor = null;
        if (service != null) {
            try {
                try {
                    cursor = service.rawQuery("select * from account_data order by time desc", null);
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            AccountData data = new AccountData();
                            data.setID(cursor.getString(0));
                            data.setAccount(cursor.getString(1));
                            data.setPassword(cursor.getString(2));
                            data.setBDUSS(cursor.getString(3));
                            data.setIsActive(cursor.getInt(4));
                            data.setTbs(cursor.getString(5));
                            data.setTime(cursor.getLong(6));
                            ret.add(data);
                        }
                        cursor.close();
                    }
                    cursor = null;
                } catch (Exception ex) {
                    TiebaLog.e("DatabaseService", "getAllAccountData", "error = " + ex.getMessage());
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e) {
                        }
                    }
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e2) {
                    }
                }
                throw th;
            }
        }
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Exception e3) {
            }
        }
        return ret;
    }

    public static AccountData getActiveAccountData() {
        Exception ex;
        DatabaseService service = new DatabaseService();
        AccountData ret = null;
        Cursor cursor = null;
        try {
            if (service != null) {
                try {
                    cursor = service.rawQuery("select * from account_data where isactive=?", new String[]{String.valueOf(1)});
                    if (cursor != null) {
                        if (cursor.moveToFirst()) {
                            AccountData ret2 = new AccountData();
                            try {
                                ret2.setID(cursor.getString(0));
                                ret2.setAccount(cursor.getString(1));
                                ret2.setPassword(cursor.getString(2));
                                ret2.setBDUSS(cursor.getString(3));
                                ret2.setIsActive(cursor.getInt(4));
                                ret2.setTbs(cursor.getString(5));
                                ret2.setTime(cursor.getLong(6));
                                ret = ret2;
                            } catch (Exception e) {
                                ex = e;
                                ret = ret2;
                                TiebaLog.e("DatabaseService", "getActiveAccountData", "error = " + ex.getMessage());
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e2) {
                                    }
                                }
                                return ret;
                            } catch (Throwable th) {
                                th = th;
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e3) {
                                    }
                                }
                                throw th;
                            }
                        }
                        cursor.close();
                    }
                    cursor = null;
                } catch (Exception e4) {
                    ex = e4;
                }
            }
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e5) {
                }
            }
            return ret;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static AccountData getAccountData(String account) {
        Exception ex;
        DatabaseService service = new DatabaseService();
        AccountData ret = null;
        Cursor cursor = null;
        if (service != null) {
            try {
                try {
                    cursor = service.rawQuery("select * from account_data where account=?", new String[]{account});
                    if (cursor != null) {
                        if (cursor.moveToFirst()) {
                            AccountData ret2 = new AccountData();
                            try {
                                ret2.setID(cursor.getString(0));
                                ret2.setAccount(cursor.getString(1));
                                ret2.setPassword(cursor.getString(2));
                                ret2.setBDUSS(cursor.getString(3));
                                ret2.setIsActive(cursor.getInt(4));
                                ret2.setTbs(cursor.getString(5));
                                ret2.setTime(cursor.getLong(6));
                                ret = ret2;
                            } catch (Exception e) {
                                ex = e;
                                ret = ret2;
                                TiebaLog.e("DatabaseService", "getAccountData", "error = " + ex.getMessage());
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e2) {
                                    }
                                }
                                return ret;
                            } catch (Throwable th) {
                                th = th;
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e3) {
                                    }
                                }
                                throw th;
                            }
                        }
                        cursor.close();
                    }
                    cursor = null;
                } catch (Exception e4) {
                    ex = e4;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Exception e5) {
            }
        }
        return ret;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    public static ArrayList<String> getAllSearchData() {
        DatabaseService service = new DatabaseService();
        ArrayList<String> ret = new ArrayList<>();
        Cursor cursor = null;
        try {
            if (service != null) {
                try {
                    cursor = service.rawQuery("select * from search_data where account=? order by time desc limit 10", new String[]{TiebaApplication.getCurrentAccount()});
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            String tmp = cursor.getString(0);
                            if (tmp != null && tmp.length() > 0) {
                                ret.add(tmp);
                            }
                        }
                        cursor.close();
                    }
                    cursor = null;
                } catch (Exception ex) {
                    TiebaLog.e("DatabaseService", "getAllSearchData", "error = " + ex.getMessage());
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e) {
                        }
                    }
                }
            }
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e2) {
                }
            }
            return ret;
        } catch (Throwable th) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e3) {
                }
            }
            throw th;
        }
    }

    public static void saveSearchData(ArrayList<String> data) {
        DatabaseService service = new DatabaseService();
        if (service != null && data != null) {
            try {
                service.ExecSQL("delete from search_data where account=?", new String[]{TiebaApplication.getCurrentAccount()});
                for (int i = 0; i < data.size() && i < 10; i++) {
                    service.ExecSQL("Insert into search_data(key,account) values(?,?)", new Object[]{data.get(i), TiebaApplication.getCurrentAccount()});
                }
            } catch (Exception ex) {
                TiebaLog.e("DatabaseService", "saveSearchData", "error = " + ex.getMessage());
            }
        }
    }

    public static void saveOneSearchData(String data) {
        DatabaseService service = new DatabaseService();
        if (service != null && data != null) {
            try {
                Date date = new Date();
                service.ExecSQL("delete from search_data where key=? and account=?", new String[]{data, TiebaApplication.getCurrentAccount()});
                service.ExecSQL("Insert into search_data(key,account,time) values(?,?,?)", new Object[]{data, TiebaApplication.getCurrentAccount(), Long.valueOf(date.getTime())});
            } catch (Exception ex) {
                TiebaLog.e("DatabaseService", "saveSearchData", "error = " + ex.getMessage());
            }
        }
    }

    public static void delOneSearchData(String data) {
        DatabaseService service = new DatabaseService();
        if (service != null && data != null) {
            try {
                service.ExecSQL("delete from search_data where key=? and account=?", new String[]{data, TiebaApplication.getCurrentAccount()});
            } catch (Exception ex) {
                TiebaLog.e("DatabaseService", "saveSearchData", "error = " + ex.getMessage());
            }
        }
    }

    public static void delAllSearchData() {
        DatabaseService service = new DatabaseService();
        if (service != null) {
            try {
                service.ExecSQL("delete from search_data where account=?", new String[]{TiebaApplication.getCurrentAccount()});
            } catch (Exception ex) {
                TiebaLog.e("DatabaseService", "delAllSearchData", "error = " + ex.getMessage());
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    public static ArrayList<MarkData> getAllMarkData() {
        DatabaseService service = new DatabaseService();
        ArrayList<MarkData> ret = new ArrayList<>();
        Cursor cursor = null;
        if (service != null) {
            try {
                try {
                    Cursor cursor2 = service.rawQuery("select * from mark_data where account=? order by time desc", new String[]{TiebaApplication.getCurrentAccount()});
                    if (cursor2 != null) {
                        while (cursor2.moveToNext()) {
                            MarkData tmp = new MarkData();
                            tmp.setId(cursor2.getString(0));
                            tmp.setFloor(cursor2.getInt(1));
                            tmp.setTime(cursor2.getInt(2));
                            tmp.setTitle(cursor2.getString(3));
                            tmp.setSequence(Boolean.valueOf(cursor2.getInt(4) == 1));
                            tmp.setHostMode(cursor2.getInt(5) == 1);
                            tmp.setPostId(cursor2.getString(6));
                            tmp.setAccount(cursor2.getString(7));
                            tmp.setAuthorName(cursor2.getString(8));
                            tmp.setReplyNum(cursor2.getInt(9));
                            ret.add(tmp);
                        }
                        cursor2.close();
                    }
                    cursor = null;
                    setMarkState(false);
                } catch (Exception ex) {
                    TiebaLog.e("DatabaseService", "getAllMarkData", "error = " + ex.getMessage());
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e) {
                        }
                    }
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e2) {
                    }
                }
                throw th;
            }
        }
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Exception e3) {
            }
        }
        TiebaLog.i("DatabaseService", "getAllMarkData", "success = " + String.valueOf(ret.size()));
        return ret;
    }

    public static void setMarkState(Boolean changed) {
        synchronized (mMarkChanged) {
            mMarkChanged = changed;
        }
    }

    public static Boolean getMarkState() {
        return mMarkChanged;
    }

    public static void setMarkNumState(Boolean changed) {
        synchronized (mMarkNumChanged) {
            mMarkNumChanged = changed;
        }
    }

    public static Boolean getMarkNumState() {
        return mMarkNumChanged;
    }

    public static MarkData getMarkDataById(String id) {
        Exception ex;
        DatabaseService service = new DatabaseService();
        Cursor cursor = null;
        MarkData data = null;
        if (service != null) {
            try {
                try {
                    cursor = service.rawQuery("select * from mark_data where id=? and account=?", new String[]{id, TiebaApplication.getCurrentAccount()});
                    if (cursor != null) {
                        if (cursor.moveToFirst()) {
                            MarkData data2 = new MarkData();
                            try {
                                data2.setId(cursor.getString(0));
                                data2.setFloor(cursor.getInt(1));
                                data2.setTime(cursor.getInt(2));
                                data2.setTitle(cursor.getString(3));
                                data2.setSequence(Boolean.valueOf(cursor.getInt(4) == 1));
                                data2.setHostMode(cursor.getInt(5) == 1);
                                data2.setPostId(cursor.getString(6));
                                data2.setAuthorName(cursor.getString(8));
                                data2.setReplyNum(cursor.getInt(9));
                                data = data2;
                            } catch (Exception e) {
                                ex = e;
                                data = data2;
                                TiebaLog.e("DatabaseService", "getMarkDataById", "error = " + ex.getMessage());
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e2) {
                                    }
                                }
                                return data;
                            } catch (Throwable th) {
                                th = th;
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e3) {
                                    }
                                }
                                throw th;
                            }
                        }
                        cursor.close();
                    }
                    cursor = null;
                } catch (Exception e4) {
                    ex = e4;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Exception e5) {
            }
        }
        return data;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, CONST, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    public static int getMarkDataNum() {
        DatabaseService service = new DatabaseService();
        Cursor cursor = null;
        int num = 0;
        try {
            if (service != null) {
                try {
                    cursor = service.rawQuery("select count(*) from mark_data where account=?", new String[]{TiebaApplication.getCurrentAccount()});
                    if (cursor != null && cursor.moveToFirst()) {
                        num = cursor.getInt(0);
                        setMarkNumState(false);
                    }
                } catch (Exception ex) {
                    TiebaLog.e("DatabaseService", "getMarkDatanum", ex.getMessage());
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e) {
                        }
                    }
                }
            }
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e2) {
                }
            }
            return num;
        } catch (Throwable th) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e3) {
                }
            }
            throw th;
        }
    }

    public static boolean saveMarkData(MarkData data) {
        Boolean ret = false;
        DatabaseService service = new DatabaseService();
        if (service != null) {
            if (data != null) {
                try {
                    service.ExecSQL("delete from mark_data where id=? and account=?", new String[]{data.getId(), TiebaApplication.getCurrentAccount()});
                    Object[] objArr = new Object[10];
                    objArr[0] = data.getId();
                    objArr[1] = Integer.valueOf(data.getFloor());
                    objArr[2] = Long.valueOf(data.getTime());
                    objArr[3] = data.getTitle();
                    objArr[4] = Integer.valueOf(data.getSequence().booleanValue() ? 1 : 0);
                    objArr[5] = Integer.valueOf(data.getHostMode() ? 1 : 0);
                    objArr[6] = data.getPostId();
                    objArr[7] = TiebaApplication.getCurrentAccount();
                    objArr[8] = data.getAuthorName();
                    objArr[9] = Integer.valueOf(data.getReplyNum());
                    ret = service.ExecSQL("Insert into mark_data(id,floor,time,title,sequence,hostmode,postid,account,authorname,replynum) values(?,?,?,?,?,?,?,?,?,?)", objArr);
                    if (ret.booleanValue()) {
                        setMarkNumState(true);
                        setMarkState(true);
                    }
                } catch (Exception ex) {
                    TiebaLog.e("DatabaseService", "saveMarkData", "error = " + ex.getMessage());
                    ret = false;
                }
            }
        }
        return ret.booleanValue();
    }

    public static boolean deleteMarkData(String id) {
        boolean ret = false;
        DatabaseService service = new DatabaseService();
        if (service != null) {
            try {
                ret = service.ExecSQL("delete from mark_data where id=? and account=?", new String[]{id, TiebaApplication.getCurrentAccount()}).booleanValue();
                if (ret) {
                    setMarkState(true);
                    setMarkNumState(true);
                }
            } catch (Exception ex) {
                TiebaLog.e("DatabaseService", "deleteMarkData", "error = " + ex.getMessage());
            }
        }
        return ret;
    }

    public static void deleteDraftBox(WriteModel model) {
        DatabaseService service = new DatabaseService();
        try {
            if (model.getType() == WriteModel.NEW) {
                service.ExecSQL("delete from draft_box where account=? and type=? and forum_id=?", new Object[]{TiebaApplication.getCurrentAccount(), 0, model.getForumId()});
            } else if (model.getType() == WriteModel.REPLY) {
                service.ExecSQL("delete from draft_box where account=? and type=? and thread_id=?", new Object[]{TiebaApplication.getCurrentAccount(), 1, model.getThreadId()});
            } else {
                service.ExecSQL("delete from draft_box where account=? and type=? and thread_id=? and floor_id=?", new Object[]{TiebaApplication.getCurrentAccount(), 2, model.getThreadId(), model.getFloor()});
            }
        } catch (Exception ex) {
            TiebaLog.e("DatabaseService", "deleteDraftBox", "error = " + ex.getMessage());
        }
    }

    public static void delOverdueDraft() {
        Date date = new Date();
        long time = date.getTime() - Config.APP_OVERDUR_DRAFT_BOX;
        DatabaseService service = new DatabaseService();
        try {
            service.ExecSQL("delete from draft_box where time<?", new Object[]{Long.valueOf(time)});
        } catch (Exception ex) {
            TiebaLog.e("DatabaseService", "delMouthAgoDraft", "error = " + ex.getMessage());
        }
    }

    public static void saveDraftBox(WriteModel model) {
        deleteDraftBox(model);
        DatabaseService service = new DatabaseService();
        try {
            Date date = new Date();
            service.ExecSQL("Insert into draft_box(account,type,forum_id,forum_name,thread_id,floor_id,title,content,time) values(?,?,?,?,?,?,?,?,?)", new Object[]{TiebaApplication.getCurrentAccount(), Integer.valueOf(model.getType()), model.getForumId(), model.getForumName(), model.getThreadId(), model.getFloor(), model.getTitle(), model.getContent(), Long.valueOf(date.getTime())});
        } catch (Exception ex) {
            TiebaLog.e("DatabaseService", "saveDraftBox", "error = " + ex.getMessage());
        }
    }

    public static WriteModel getDraftBox(int type, String forum_id, String thread_id, String floor_id) {
        Exception ex;
        DatabaseService service = new DatabaseService();
        Cursor cursor = null;
        WriteModel model = null;
        try {
            try {
                if (type == WriteModel.NEW) {
                    cursor = service.rawQuery("select * from draft_box where account=? and type=? and forum_id=?", new String[]{TiebaApplication.getCurrentAccount(), String.valueOf(type), forum_id});
                } else if (type == WriteModel.REPLY) {
                    cursor = service.rawQuery("select * from draft_box where account=? and type=? and thread_id=?", new String[]{TiebaApplication.getCurrentAccount(), String.valueOf(type), thread_id});
                } else {
                    cursor = service.rawQuery("select * from draft_box where account=? and type=? and thread_id=? and floor_id=?", new String[]{TiebaApplication.getCurrentAccount(), String.valueOf(type), thread_id, floor_id});
                }
                if (cursor != null && cursor.moveToFirst()) {
                    WriteModel model2 = new WriteModel();
                    try {
                        model2.setType(type);
                        model2.setForumId(forum_id);
                        model2.setForumName(cursor.getString(3));
                        model2.setThreadId(thread_id);
                        model2.setFloor(floor_id);
                        model2.setTitle(cursor.getString(6));
                        model2.setContent(cursor.getString(7));
                        model = model2;
                    } catch (Exception e) {
                        ex = e;
                        model = model2;
                        TiebaLog.e("DatabaseService", "getDraftBox", "error = " + ex.getMessage());
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception e2) {
                            }
                        }
                        return model;
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception e3) {
                            }
                        }
                        throw th;
                    }
                }
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e4) {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e5) {
            ex = e5;
        }
        return model;
    }

    public static void saveSettingData() {
        DatabaseService service = new DatabaseService();
        try {
            service.ExecSQL("delete from setting where account=?", new Object[]{TiebaApplication.getCurrentAccount()});
            Object[] objArr = new Object[5];
            objArr[0] = TiebaApplication.getCurrentAccount();
            objArr[1] = Integer.valueOf(TiebaApplication.app.getMsgFrequency());
            objArr[2] = Integer.valueOf(TiebaApplication.app.isMsgFansOn() ? 1 : 0);
            objArr[3] = Integer.valueOf(TiebaApplication.app.isMsgReplymeOn() ? 1 : 0);
            objArr[4] = Integer.valueOf(TiebaApplication.app.isMsgAtmeOn() ? 1 : 0);
            service.ExecSQL("Insert into setting(account,frequency,fans_switch,reply_me_switch,at_me_switch) values(?,?,?,?,?)", objArr);
        } catch (Exception ex) {
            TiebaLog.e("DatabaseService", "saveDraftBox", "error = " + ex.getMessage());
        }
    }

    public static void getSettingData() {
        DatabaseService service = new DatabaseService();
        Cursor cursor = null;
        try {
            try {
                Cursor cursor2 = service.rawQuery("select * from setting where account=?", new String[]{TiebaApplication.getCurrentAccount()});
                if (cursor2 != null && cursor2.moveToFirst()) {
                    TiebaApplication.app.setMsgFrequency(cursor2.getInt(1));
                    if (cursor2.getInt(2) == 0) {
                        TiebaApplication.app.setMsgFansOn(false);
                    } else {
                        TiebaApplication.app.setMsgFansOn(true);
                    }
                    if (cursor2.getInt(3) == 0) {
                        TiebaApplication.app.setMsgReplymeOn(false);
                    } else {
                        TiebaApplication.app.setMsgReplymeOn(true);
                    }
                    if (cursor2.getInt(4) == 0) {
                        TiebaApplication.app.setMsgAtmeOn(false);
                    } else {
                        TiebaApplication.app.setMsgAtmeOn(true);
                    }
                } else {
                    TiebaApplication.app.setMsgFrequency(Config.MSG_DEFAULT_FREQUENCY);
                    TiebaApplication.app.setMsgFansOn(true);
                    TiebaApplication.app.setMsgReplymeOn(true);
                    TiebaApplication.app.setMsgAtmeOn(true);
                }
                if (cursor2 != null) {
                    try {
                        cursor2.close();
                    } catch (Exception e) {
                    }
                }
            } catch (Exception ex) {
                TiebaLog.e("DatabaseService", "getDraftBox", "error = " + ex.getMessage());
                if (0 != 0) {
                    try {
                        cursor.close();
                    } catch (Exception e2) {
                    }
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    cursor.close();
                } catch (Exception e3) {
                }
            }
            throw th;
        }
    }

    public static void deletSdDatebase() {
        synchronized (DatabaseService.class) {
            try {
                SDdatabase.close();
            } catch (Exception e) {
            }
            try {
                FileHelper.DelFile(Config.TMP_DATABASE_NAME);
            } catch (Exception e2) {
            }
            SDdatabase = null;
        }
    }

    public static void deletLocDatebase(Context context) {
        synchronized (DatabaseService.class) {
            try {
                database.close();
            } catch (Exception e) {
            }
            try {
                context.deleteDatabase(Config.PHONE_DATEBASE_NAME);
            } catch (Exception ex) {
                TiebaLog.e("DatabaseService", "deletDatebase", "error = " + ex.getMessage());
            }
            database = null;
        }
    }

    public static void deletDatebase(Context context) {
        deletLocDatebase(context);
        deletSdDatebase();
    }

    public static void deleteAccountAllInfo(String id) {
        DatabaseService service = new DatabaseService();
        if (service != null) {
            try {
                service.ExecSQL("delete from cash_data where account=?", new String[]{id});
                service.ExecSQL("delete from search_data where account=?", new String[]{id});
                service.ExecSQL("delete from mark_data where account=?", new String[]{id});
                service.ExecSQL("delete from draft_box where account=?", new Object[]{id});
                service.ExecSQL("delete from account_data where id=?", new Object[]{id});
            } catch (Exception ex) {
                TiebaLog.e("DatabaseService", "deleteAccountAllInfo", ex.getMessage());
            }
        }
    }
}
