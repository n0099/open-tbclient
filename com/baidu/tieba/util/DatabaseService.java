package com.baidu.tieba.util;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteException;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.data.MarkData;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class DatabaseService {
    private static Boolean a = true;
    private static Boolean b = true;
    private static volatile SQLiteDatabase c = null;
    private static volatile SQLiteDatabase d = null;
    private DatabaseLocation e;

    /* loaded from: classes.dex */
    public enum DatabaseLocation {
        INNER,
        SDCARD;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static DatabaseLocation[] valuesCustom() {
            DatabaseLocation[] valuesCustom = values();
            int length = valuesCustom.length;
            DatabaseLocation[] databaseLocationArr = new DatabaseLocation[length];
            System.arraycopy(valuesCustom, 0, databaseLocationArr, 0, length);
            return databaseLocationArr;
        }
    }

    public static void a(Throwable th, String str) {
        if (th != null) {
            cb.a(th, str, new Object[0]);
            if ((th instanceof SQLiteException) && (((SQLiteException) th) instanceof SQLiteDatabaseCorruptException)) {
                com.baidu.adp.lib.util.e.c("database corrupted.  recreate!");
                try {
                    y.a(TiebaApplication.g().b());
                } catch (Throwable th2) {
                    com.baidu.adp.lib.util.e.b("failed to drop database. msg:" + th2.getMessage());
                }
                c = null;
            }
        }
    }

    public DatabaseService() {
        synchronized (DatabaseService.class) {
            this.e = DatabaseLocation.INNER;
            if (c == null || !c.isOpen()) {
                try {
                    c = new y(TiebaApplication.g().b()).getWritableDatabase();
                } catch (Exception e) {
                    cb.a(e, "DatabaseService", new Object[0]);
                    com.baidu.adp.lib.util.e.b("DatabaseService", "DatabaseService", "error = " + e.getMessage());
                }
            }
        }
    }

    private DatabaseService(DatabaseLocation databaseLocation) {
        synchronized (DatabaseService.class) {
            this.e = databaseLocation;
            if (this.e != DatabaseLocation.SDCARD || d == null || !d.isOpen()) {
                if (this.e == DatabaseLocation.INNER && c != null && c.isOpen()) {
                    return;
                }
                try {
                    if (this.e == DatabaseLocation.SDCARD) {
                        z zVar = new z();
                        zVar.a(new ab(this));
                        d = zVar.a();
                    } else {
                        c = new y(TiebaApplication.g().b()).getWritableDatabase();
                    }
                } catch (Exception e) {
                    cb.a(e, "DatabaseService", new Object[0]);
                    com.baidu.adp.lib.util.e.b("DatabaseService", "DatabaseService", "error = " + e.getMessage());
                }
            }
        }
    }

    private boolean o(String str) {
        try {
            if (this.e == DatabaseLocation.SDCARD && d != null) {
                d.execSQL(str);
                return true;
            } else if (this.e == DatabaseLocation.INNER && c != null) {
                c.execSQL(str);
                return true;
            } else {
                return true;
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "ExecSQL", String.valueOf(str) + "   error = " + e.getMessage());
            throw e;
        }
    }

    public static SQLiteDatabase a() {
        new DatabaseService();
        return c;
    }

    private Boolean a(String str, Object[] objArr) {
        try {
            if (this.e == DatabaseLocation.SDCARD && d != null) {
                d.execSQL(str, objArr);
            } else if (this.e == DatabaseLocation.INNER && c != null) {
                c.execSQL(str, objArr);
            }
            return true;
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b("DatabaseService", "ExecSQL", "error = " + e.getMessage());
            com.baidu.adp.lib.util.e.b("DatabaseService", "ExecSQL", str);
            throw e;
        }
    }

    private Cursor a(String str, String[] strArr) {
        try {
            if (this.e == DatabaseLocation.SDCARD && d != null) {
                return d.rawQuery(str, strArr);
            }
            if (this.e != DatabaseLocation.INNER || c == null) {
                return null;
            }
            return c.rawQuery(str, strArr);
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b("DatabaseService", "rawQuery", "error = " + e.getMessage() + " sql = " + str);
            throw e;
        }
    }

    public static com.baidu.tieba.util.a.f a(String str, long j) {
        return a("pb_photo", str, j);
    }

    public static com.baidu.tieba.util.a.f b(String str, long j) {
        return a("friend_photo", str, j);
    }

    public static com.baidu.tieba.util.a.f a(String str) {
        return a("user_icon", str, 0L);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [325=5, 326=5, 328=5, 329=5] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:55:0x0144 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0124 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.baidu.tieba.util.DatabaseService$DatabaseLocation] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static com.baidu.tieba.util.a.f a(String str, String str2, long j) {
        Throwable th;
        Cursor cursor;
        com.baidu.tieba.util.a.f fVar = null;
        if (str2 != null) {
            ?? r2 = DatabaseLocation.SDCARD;
            try {
                try {
                    cursor = new DatabaseService(r2).a("select * from " + str + " where key = ?", new String[]{str2});
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                long j2 = cursor.getLong(3);
                                if (j2 != 0 || j == 0) {
                                    if (j2 == 0 || j == 0 || j <= j2) {
                                        com.baidu.tieba.util.a.f fVar2 = new com.baidu.tieba.util.a.f();
                                        try {
                                            fVar2.a = n.a(cursor.getBlob(1));
                                            fVar2.b = j2;
                                            fVar = fVar2;
                                        } catch (Exception e) {
                                            fVar = fVar2;
                                            e = e;
                                            com.baidu.adp.lib.util.e.b("DatabaseService", "getPhoto", "error = " + e.getMessage());
                                            cb.a(e, "DatabaseService.getPhoto" + str, new Object[0]);
                                            if (cursor != null) {
                                                try {
                                                    cursor.close();
                                                } catch (Exception e2) {
                                                    cb.a(e2, "DatabaseService.getPhoto" + str + "close cursor", new Object[0]);
                                                }
                                            }
                                            return fVar;
                                        }
                                    } else if (cursor != null) {
                                        try {
                                            cursor.close();
                                        } catch (Exception e3) {
                                            cb.a(e3, "DatabaseService.getPhoto" + str + "close cursor", new Object[0]);
                                        }
                                    }
                                } else if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e4) {
                                        cb.a(e4, "DatabaseService.getPhoto" + str + "close cursor", new Object[0]);
                                    }
                                }
                            }
                        } catch (Exception e5) {
                            e = e5;
                        }
                    }
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e6) {
                            cb.a(e6, "DatabaseService.getPhoto" + str + "close cursor", new Object[0]);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (r2 != 0) {
                        try {
                            r2.close();
                        } catch (Exception e7) {
                            cb.a(e7, "DatabaseService.getPhoto" + str + "close cursor", new Object[0]);
                        }
                    }
                    throw th;
                }
            } catch (Exception e8) {
                e = e8;
                cursor = null;
            } catch (Throwable th3) {
                r2 = 0;
                th = th3;
                if (r2 != 0) {
                }
                throw th;
            }
        }
        return fVar;
    }

    public static void a(String str, Bitmap bitmap, long j) {
        a("pb_photo", 500, str, bitmap, j);
    }

    public static void a(String str, Bitmap bitmap) {
        a("user_icon", 100, str, bitmap, 0L);
    }

    public static void b(String str, Bitmap bitmap, long j) {
        a("friend_photo", 500, str, bitmap, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0158 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(String str, int i, String str2, Bitmap bitmap, long j) {
        Cursor cursor;
        int i2;
        Cursor a2;
        if (str2 != null) {
            DatabaseService databaseService = new DatabaseService(DatabaseLocation.SDCARD);
            try {
                Cursor a3 = databaseService.a("select count(*) from " + str, (String[]) null);
                if (a3 != null) {
                    try {
                        try {
                            i2 = a3.moveToFirst() ? a3.getInt(0) : 0;
                            a3.close();
                        } catch (Exception e) {
                            e = e;
                            com.baidu.adp.lib.util.e.b("DatabaseService", "cashPhoto", "error = " + e.getMessage());
                            cb.a(e, "DatabaseService.cashPhoto" + str, new Object[0]);
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                    return;
                                } catch (Exception e2) {
                                    cb.a(e2, "DatabaseService.cashPhoto" + str + "close cursor", new Object[0]);
                                    return;
                                }
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception e3) {
                                cb.a(e3, "DatabaseService.cashPhoto" + str + "close cursor", new Object[0]);
                            }
                        }
                        throw th;
                    }
                } else {
                    i2 = 0;
                }
                if (i2 >= i && (a2 = databaseService.a("select * from " + str + " order by date asc limit 1", (String[]) null)) != null) {
                    a2.moveToFirst();
                    databaseService.a("delete from " + str + " where key=?", (Object[]) new String[]{a2.getString(0)});
                    a2.close();
                }
                Cursor a4 = databaseService.a("select * from " + str + " where key = ?", new String[]{str2});
                if (a4 != null) {
                    if (a4.moveToFirst()) {
                        databaseService.a("delete from " + str + " where key=?", (Object[]) new String[]{str2});
                    }
                    a4.close();
                }
                databaseService.a("Insert into " + str + "(key,image,date,stamp) values(?,?,?,?)", new Object[]{str2, n.c(bitmap, 80), Long.valueOf(new Date().getTime()), Long.valueOf(j)});
            } catch (Exception e4) {
                e = e4;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                if (cursor != null) {
                }
                throw th;
            }
        }
    }

    public static void b(String str) {
        a(13, str);
    }

    public static String b() {
        return c(13);
    }

    public static void c(String str) {
        if (str == null || str.length() == 0) {
            str = SocialConstants.FALSE;
        }
        try {
            new DatabaseService().a("delete from cash_data where type=? and account=?", (Object[]) new String[]{String.valueOf(13), str});
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b("DatabaseService", "cachData", "error = " + e.getMessage());
            cb.a(e, new StringBuilder("DatabaseService.delCachData13").toString(), new Object[0]);
        }
    }

    public static void d(String str) {
        a(2, str);
    }

    public static String c() {
        return c(2);
    }

    public static void d() {
        b(2);
    }

    public static void e(String str) {
        a(3, str);
    }

    public static void e() {
        b(3);
    }

    public static String f() {
        return c(3);
    }

    public static void f(String str) {
        a(4, str);
    }

    public static void g() {
        b(4);
    }

    public static String h() {
        return c(4);
    }

    private static void a(int i, String str) {
        if (TiebaApplication.v() != null) {
            DatabaseService databaseService = new DatabaseService();
            try {
                databaseService.a("delete from cash_data where type=? and account=?", (Object[]) new String[]{String.valueOf(i), TiebaApplication.v()});
                databaseService.a("Insert into cash_data(account,type,data) values(?,?,?)", new Object[]{TiebaApplication.v(), Integer.valueOf(i), str});
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b("DatabaseService", "cachData", "error = " + e.getMessage());
                cb.a(e, "DatabaseService.cashData" + i, new Object[0]);
            }
        }
    }

    private static void b(int i) {
        if (TiebaApplication.v() != null) {
            try {
                new DatabaseService().a("delete from cash_data where type=? and account=?", (Object[]) new String[]{String.valueOf(i), TiebaApplication.v()});
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b("DatabaseService", "cachData", "error = " + e.getMessage());
                cb.a(e, "DatabaseService.delCachData" + i, new Object[0]);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x008d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String c(int i) {
        Cursor cursor;
        Throwable th;
        if (TiebaApplication.v() != null) {
            try {
                cursor = new DatabaseService().a("select * from cash_data where type = ? and account=?", new String[]{String.valueOf(i), TiebaApplication.v()});
                if (cursor != null) {
                    try {
                        try {
                            r0 = cursor.moveToFirst() ? cursor.getString(2) : null;
                            cursor.close();
                        } catch (Exception e) {
                            e = e;
                            com.baidu.adp.lib.util.e.b("DatabaseService", "getCachData", "error = " + e.getMessage());
                            cb.a(e, "DatabaseService.getCachData" + i, new Object[0]);
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e2) {
                                    cb.a(e2, "DatabaseService.getCachData" + i + "close cursor", new Object[0]);
                                }
                            }
                            return r0;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception e3) {
                                cb.a(e3, "DatabaseService.getCachData" + i + "close cursor", new Object[0]);
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                cursor = null;
            } catch (Throwable th3) {
                cursor = null;
                th = th3;
                if (cursor != null) {
                }
                throw th;
            }
        }
        return r0;
    }

    private static boolean p(String str) {
        try {
            return new DatabaseService().a("delete from account_data where account=?", (Object[]) new String[]{str}).booleanValue();
        } catch (Exception e) {
            cb.a(e, "DatabaseService.delAccountData", new Object[0]);
            return false;
        }
    }

    private static boolean a(AccountData accountData, DatabaseService databaseService) {
        try {
            return databaseService.a("Insert into account_data(id,account,password,bduss,isactive,tbs,time,portrait) values(?,?,?,?,?,?,?,?)", new Object[]{accountData.getID(), accountData.getAccount(), accountData.getPassword(), accountData.getBDUSS(), Integer.valueOf(accountData.getIsActive()), accountData.getTbs(), Long.valueOf(new Date().getTime()), accountData.getPortrait()}).booleanValue();
        } catch (Exception e) {
            cb.a(e, "DatabaseService.addAccountData", new Object[0]);
            return false;
        }
    }

    public static void a(AccountData accountData) {
        if (accountData != null && accountData.getAccount() != null) {
            if (accountData.getIsActive() == 1) {
                i();
            }
            DatabaseService databaseService = new DatabaseService();
            try {
                if (!p(accountData.getAccount()) || !a(accountData, databaseService)) {
                    databaseService.o("DROP TABLE IF EXISTS account_data");
                    databaseService.o("CREATE TABLE if not exists account_data(id,account,password,bduss,isactive int,tbs,time,portrait varchar(255))");
                    a(accountData, databaseService);
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b("DatabaseService", "saveAccountData", "error = " + e.getMessage());
                cb.a(e, "DatabaseService.saveAccountData", new Object[0]);
            }
        }
    }

    public static void i() {
        try {
            new DatabaseService().o("update account_data set isactive=0 where isactive=1");
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b("DatabaseService", "clearActiveAccount", "error = " + e.getMessage());
            cb.a(e, "DatabaseService.clearActiveAccount", new Object[0]);
        }
    }

    public static void b(AccountData accountData) {
        i();
        try {
            new DatabaseService().a("update account_data set isactive=1 where account=?", (Object[]) new String[]{accountData.getAccount()});
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b("DatabaseService", "clearActiveAccount", "error = " + e.getMessage());
            cb.a(e, "DatabaseService.setActiveAccount", new Object[0]);
        }
    }

    public static void a(String str, String str2) {
        if (str != null && str2 != null) {
            try {
                new DatabaseService().a("update account_data set portrait=? where account=?", (Object[]) new String[]{str2, str});
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b("DatabaseService", "updateAccountPortrait", "error = " + e.getMessage());
                cb.a(e, "DatabaseService.updateAccountPortrait", new Object[0]);
            }
        }
    }

    public static ArrayList<AccountData> j() {
        Cursor cursor = null;
        DatabaseService databaseService = new DatabaseService();
        ArrayList<AccountData> arrayList = new ArrayList<>();
        try {
            try {
                cursor = databaseService.a("select * from account_data order by time desc", (String[]) null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        AccountData accountData = new AccountData();
                        accountData.setID(cursor.getString(0));
                        accountData.setAccount(cursor.getString(1));
                        accountData.setPassword(cursor.getString(2));
                        accountData.setBDUSS(cursor.getString(3));
                        accountData.setIsActive(cursor.getInt(4));
                        accountData.setTbs(cursor.getString(5));
                        accountData.setTime(cursor.getLong(6));
                        accountData.setPortrait(cursor.getString(7));
                        arrayList.add(accountData);
                    }
                    cursor.close();
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b("DatabaseService", "getAllAccountData", "error = " + e.getMessage());
                cb.a(e, "DatabaseService.getAllAccountData", new Object[0]);
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e2) {
                        cb.a(e2, "DatabaseService.getAllAccountData close cursor", new Object[0]);
                    }
                }
            }
            return arrayList;
        } catch (Throwable th) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e3) {
                    cb.a(e3, "DatabaseService.getAllAccountData close cursor", new Object[0]);
                }
            }
            throw th;
        }
    }

    public static int k() {
        Cursor cursor = null;
        try {
            try {
                cursor = new DatabaseService().a("select count(*) from account_data", (String[]) null);
                int i = (cursor == null || !cursor.moveToFirst()) ? 0 : cursor.getInt(0);
                if (cursor != null) {
                    try {
                        cursor.close();
                        return i;
                    } catch (Exception e) {
                        cb.a(e, "DatabaseService.getAccountNum close cursor", new Object[0]);
                        return i;
                    }
                }
                return i;
            } catch (Throwable th) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e2) {
                        cb.a(e2, "DatabaseService.getAccountNum close cursor", new Object[0]);
                    }
                }
                throw th;
            }
        } catch (Exception e3) {
            com.baidu.adp.lib.util.e.b("DatabaseService", "getAccountNum", e3.getMessage());
            cb.a(e3, "DatabaseService.getAccountNum", new Object[0]);
            if (cursor != null) {
                try {
                    cursor.close();
                    return 0;
                } catch (Exception e4) {
                    cb.a(e4, "DatabaseService.getAccountNum close cursor", new Object[0]);
                    return 0;
                }
            }
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AccountData l() {
        Cursor cursor;
        Exception exc;
        AccountData accountData;
        Cursor cursor2 = null;
        try {
            cursor = new DatabaseService().a("select * from account_data where isactive=?", new String[]{String.valueOf(1)});
        } catch (Exception e) {
            exc = e;
            accountData = null;
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        if (cursor != null) {
            try {
                try {
                } catch (Exception e2) {
                    accountData = null;
                    cursor2 = cursor;
                    exc = e2;
                }
                if (cursor.moveToFirst()) {
                    AccountData accountData2 = new AccountData();
                    try {
                        accountData2.setID(cursor.getString(0));
                        accountData2.setAccount(cursor.getString(1));
                        accountData2.setPassword(cursor.getString(2));
                        accountData2.setBDUSS(cursor.getString(3));
                        accountData2.setIsActive(cursor.getInt(4));
                        accountData2.setTbs(cursor.getString(5));
                        accountData2.setTime(cursor.getLong(6));
                        accountData2.setPortrait(cursor.getString(7));
                        accountData = accountData2;
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception e3) {
                                cb.a(e3, "DatabaseService.getActiveAccountData close cursor", new Object[0]);
                            }
                        }
                    } catch (Exception e4) {
                        cursor2 = cursor;
                        exc = e4;
                        accountData = accountData2;
                        try {
                            com.baidu.adp.lib.util.e.b("DatabaseService", "getActiveAccountData", "error = " + exc.getMessage());
                            cb.a(exc, "DatabaseService.getActiveAccountData", new Object[0]);
                            if (cursor2 != null) {
                                try {
                                    cursor2.close();
                                } catch (Exception e5) {
                                    cb.a(e5, "DatabaseService.getActiveAccountData close cursor", new Object[0]);
                                }
                            }
                            return accountData;
                        } catch (Throwable th2) {
                            th = th2;
                            cursor = cursor2;
                            if (cursor != null) {
                            }
                            throw th;
                        }
                    }
                    return accountData;
                }
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e6) {
                        cb.a(e6, "DatabaseService.getActiveAccountData close cursor", new Object[0]);
                    }
                }
                throw th;
            }
        }
        accountData = null;
        if (cursor != null) {
        }
        return accountData;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x009d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AccountData g(String str) {
        Cursor cursor;
        Throwable th;
        AccountData accountData = null;
        try {
            cursor = new DatabaseService().a("select * from account_data where account=?", new String[]{str});
            if (cursor != null) {
                try {
                    try {
                        if (cursor.moveToFirst()) {
                            AccountData accountData2 = new AccountData();
                            try {
                                accountData2.setID(cursor.getString(0));
                                accountData2.setAccount(cursor.getString(1));
                                accountData2.setPassword(cursor.getString(2));
                                accountData2.setBDUSS(cursor.getString(3));
                                accountData2.setIsActive(cursor.getInt(4));
                                accountData2.setTbs(cursor.getString(5));
                                accountData2.setTime(cursor.getLong(6));
                                accountData2.setPortrait(cursor.getString(7));
                                accountData = accountData2;
                            } catch (Exception e) {
                                accountData = accountData2;
                                e = e;
                                com.baidu.adp.lib.util.e.b("DatabaseService", "getAccountData", "error = " + e.getMessage());
                                cb.a(e, "DatabaseService.getAccountData", new Object[0]);
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e2) {
                                        cb.a(e2, "DatabaseService.getAccountData close cursor", new Object[0]);
                                    }
                                }
                                return accountData;
                            }
                        }
                        cursor.close();
                    } catch (Exception e3) {
                        e = e3;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e4) {
                            cb.a(e4, "DatabaseService.getAccountData close cursor", new Object[0]);
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e5) {
            e = e5;
            cursor = null;
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
            if (cursor != null) {
            }
            throw th;
        }
        return accountData;
    }

    public static ArrayList<String> m() {
        return d(0);
    }

    public static ArrayList<String> n() {
        return d(1);
    }

    private static ArrayList<String> d(int i) {
        Cursor cursor = null;
        DatabaseService databaseService = new DatabaseService();
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            try {
                switch (i) {
                    case 0:
                        cursor = databaseService.a("select * from search_data order by time desc limit 10", (String[]) null);
                        break;
                    case 1:
                        cursor = databaseService.a("select * from search_post_data order by time desc limit 10", (String[]) null);
                        break;
                }
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        String string = cursor.getString(0);
                        if (string != null && string.length() > 0) {
                            arrayList.add(string);
                        }
                    }
                    cursor.close();
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b("DatabaseService", "getAllSearchData", "error = " + e.getMessage());
                cb.a(e, "DatabaseService.getAllSearchData", new Object[0]);
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e2) {
                        cb.a(e2, "DatabaseService.getAllSearchData close cursor", new Object[0]);
                    }
                }
            }
            return arrayList;
        } catch (Throwable th) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e3) {
                    cb.a(e3, "DatabaseService.getAllSearchData close cursor", new Object[0]);
                }
            }
            throw th;
        }
    }

    public static void h(String str) {
        b(0, str);
    }

    public static void i(String str) {
        b(1, str);
    }

    private static void b(int i, String str) {
        DatabaseService databaseService = new DatabaseService();
        if (str != null) {
            try {
                Date date = new Date();
                switch (i) {
                    case 0:
                        databaseService.a("delete from search_data where key=?", (Object[]) new String[]{str});
                        databaseService.a("Insert into search_data(key,account,time) values(?,?,?)", new Object[]{str, TiebaApplication.v(), Long.valueOf(date.getTime())});
                        break;
                    case 1:
                        databaseService.a("delete from search_post_data where key=?", (Object[]) new String[]{str});
                        databaseService.a("Insert into search_post_data(key,account,time) values(?,?,?)", new Object[]{str, TiebaApplication.v(), Long.valueOf(date.getTime())});
                        break;
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b("DatabaseService", "saveSearchData", "error = " + e.getMessage());
                cb.a(e, "DatabaseService.saveOneSearchData", new Object[0]);
            }
        }
    }

    public static void o() {
        e(0);
    }

    public static void p() {
        e(1);
    }

    private static void e(int i) {
        DatabaseService databaseService = new DatabaseService();
        try {
            switch (i) {
                case 0:
                    databaseService.o("delete from search_data");
                    break;
                case 1:
                    databaseService.o("delete from search_post_data");
                    break;
                default:
                    return;
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b("DatabaseService", "delAllSearchData", "error = " + e.getMessage());
            cb.a(e, "DatabaseService.delAllSearchData", new Object[0]);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x012d */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0120 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.baidu.tieba.util.DatabaseService] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v4, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<MarkData> q() {
        Throwable th;
        Cursor cursor;
        Exception e;
        if (TiebaApplication.v() == null) {
            return null;
        }
        ?? databaseService = new DatabaseService();
        ArrayList<MarkData> arrayList = new ArrayList<>();
        try {
            try {
                cursor = databaseService.a("select * from mark_data where account=? order by time desc", new String[]{TiebaApplication.v()});
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        try {
                            MarkData markData = new MarkData();
                            markData.setId(cursor.getString(0));
                            markData.setFloor(cursor.getInt(1));
                            markData.setTime(cursor.getInt(2));
                            markData.setTitle(cursor.getString(3));
                            markData.setSequence(Boolean.valueOf(cursor.getInt(4) == 1));
                            markData.setHostMode(cursor.getInt(5) == 1);
                            markData.setPostId(cursor.getString(6));
                            markData.setAccount(cursor.getString(7));
                            markData.setAuthorName(cursor.getString(8));
                            markData.setReplyNum(cursor.getInt(9));
                            markData.setSubPost(cursor.getInt(10));
                            markData.setForumName(cursor.getString(11));
                            markData.setForumId(cursor.getString(12));
                            markData.setThreadId(cursor.getString(13));
                            arrayList.add(markData);
                        } catch (Exception e2) {
                            e = e2;
                            com.baidu.adp.lib.util.e.b("DatabaseService", "getAllMarkData", "error = " + e.getMessage());
                            cb.a(e, "DatabaseService.getAllMarkData", new Object[0]);
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e3) {
                                    cb.a(e3, "DatabaseService.getAllMarkData close cursor", new Object[0]);
                                }
                            }
                            com.baidu.adp.lib.util.e.a("DatabaseService", "getAllMarkData", "success = " + String.valueOf(arrayList.size()));
                            return arrayList;
                        }
                    }
                    cursor.close();
                }
                a = false;
            } catch (Throwable th2) {
                th = th2;
                if (databaseService != 0) {
                    try {
                        databaseService.close();
                    } catch (Exception e4) {
                        cb.a(e4, "DatabaseService.getAllMarkData close cursor", new Object[0]);
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            cursor = null;
            e = e5;
        } catch (Throwable th3) {
            databaseService = 0;
            th = th3;
            if (databaseService != 0) {
            }
            throw th;
        }
        com.baidu.adp.lib.util.e.a("DatabaseService", "getAllMarkData", "success = " + String.valueOf(arrayList.size()));
        return arrayList;
    }

    public static void a(Boolean bool) {
        b = bool;
    }

    public static void r() {
        if (TiebaApplication.v() != null) {
            DatabaseService databaseService = new DatabaseService();
            try {
                databaseService.a("delete from setting where account=?", new Object[]{TiebaApplication.v()});
                Object[] objArr = new Object[10];
                objArr[0] = TiebaApplication.v();
                objArr[1] = Integer.valueOf(TiebaApplication.g().G());
                objArr[2] = Integer.valueOf(TiebaApplication.g().O() ? 1 : 0);
                objArr[3] = Integer.valueOf(TiebaApplication.g().Q() ? 1 : 0);
                objArr[4] = Integer.valueOf(TiebaApplication.g().P() ? 1 : 0);
                objArr[5] = Integer.valueOf(TiebaApplication.g().N());
                objArr[6] = Integer.valueOf(TiebaApplication.g().R() ? 1 : 0);
                objArr[7] = Integer.valueOf(TiebaApplication.g().I() ? 1 : 0);
                objArr[8] = TiebaApplication.g().J();
                objArr[9] = TiebaApplication.g().K();
                databaseService.a("Insert into setting(account,frequency,fans_switch,reply_me_switch,at_me_switch,remind_tone,msg_chat_switch,nodisturb_switch,nodisturb_start_time,nodisturb_end_time) values(?,?,?,?,?,?,?,?,?,?)", objArr);
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b("DatabaseService", "saveDraftBox", "error = " + e.getMessage());
                cb.a(e, "DatabaseService.saveSettingData", new Object[0]);
            }
        }
    }

    public static void s() {
        com.baidu.adp.lib.util.e.a("databaseService", "getSetting", TiebaApplication.z());
        if (TiebaApplication.v() == null || TiebaApplication.v().length() <= 0 || TiebaApplication.z() == null) {
            TiebaApplication.g().b(0);
            return;
        }
        Cursor cursor = null;
        try {
            try {
                Cursor a2 = new DatabaseService().a("select * from setting where account=?", new String[]{TiebaApplication.v()});
                if (a2 != null && a2.moveToFirst()) {
                    TiebaApplication.g().b(a2.getInt(1));
                    if (a2.getInt(2) == 0) {
                        TiebaApplication.g().l(false);
                    } else {
                        TiebaApplication.g().l(true);
                    }
                    if (a2.getInt(3) == 0) {
                        TiebaApplication.g().n(false);
                    } else {
                        TiebaApplication.g().n(true);
                    }
                    if (a2.getInt(4) == 0) {
                        TiebaApplication.g().m(false);
                    } else {
                        TiebaApplication.g().m(true);
                    }
                    TiebaApplication.g();
                    TiebaApplication.a(a2.getInt(5));
                    if (a2.getInt(6) == 0) {
                        TiebaApplication.g().o(false);
                    } else {
                        TiebaApplication.g().o(true);
                    }
                    if (a2.getInt(7) == 0) {
                        TiebaApplication.g().j(false);
                    } else {
                        TiebaApplication.g().j(true);
                    }
                    String string = a2.getString(8);
                    if (TextUtils.isEmpty(string)) {
                        TiebaApplication.g().o("23:00");
                    } else {
                        TiebaApplication.g().o(string);
                    }
                    String string2 = a2.getString(9);
                    if (TextUtils.isEmpty(string2)) {
                        TiebaApplication.g().p("09:00");
                    } else {
                        TiebaApplication.g().p(string2);
                    }
                } else {
                    TiebaApplication.g().b(300);
                    TiebaApplication.g().l(true);
                    TiebaApplication.g().n(true);
                    TiebaApplication.g().m(true);
                    TiebaApplication.g().i(true);
                    TiebaApplication.g().k(false);
                    TiebaApplication.g().o(true);
                    TiebaApplication.g().j(false);
                    TiebaApplication.g().o("23:00");
                    TiebaApplication.g().p("09:00");
                }
                if (a2 != null) {
                    try {
                        a2.close();
                    } catch (Exception e) {
                        cb.a(e, "DatabaseService.getSettingData close cursor", new Object[0]);
                    }
                }
            } catch (Exception e2) {
                com.baidu.adp.lib.util.e.b("DatabaseService", "getDraftBox", "error = " + e2.getMessage());
                cb.a(e2, "DatabaseService.getSettingData", new Object[0]);
                if (0 != 0) {
                    try {
                        cursor.close();
                    } catch (Exception e3) {
                        cb.a(e3, "DatabaseService.getSettingData close cursor", new Object[0]);
                    }
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    cursor.close();
                } catch (Exception e4) {
                    cb.a(e4, "DatabaseService.getSettingData close cursor", new Object[0]);
                }
            }
            throw th;
        }
    }

    public static void t() {
        if (TiebaApplication.v() != null) {
            try {
                new DatabaseService().a("delete from chunk_upload_data where strftime('%s','now') - time > 48 * 3600 and account=?", (Object[]) new String[]{TiebaApplication.v()});
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b("DatabaseService", "delChunkUploadData", "error = " + e.getMessage());
                cb.a(e, "DatabaseService.delOverdueChunkUploadData", new Object[0]);
            }
        }
    }

    public static void j(String str) {
        if (TiebaApplication.v() != null) {
            DatabaseService databaseService = new DatabaseService();
            if (str != null) {
                try {
                    databaseService.a("delete from chunk_upload_data where md5=? and account=?", (Object[]) new String[]{str, TiebaApplication.v()});
                } catch (Exception e) {
                    com.baidu.adp.lib.util.e.b("DatabaseService", "delChunkUploadData", "error = " + e.getMessage());
                    cb.a(e, "DatabaseService.delChunkUploadData", new Object[0]);
                }
            }
        }
    }

    public static boolean a(com.baidu.tieba.data.f fVar) {
        if (TiebaApplication.v() == null) {
            return false;
        }
        DatabaseService databaseService = new DatabaseService();
        Date date = new Date();
        if (fVar != null) {
            try {
                databaseService.a("delete from chunk_upload_data where md5=? and account=?", (Object[]) new String[]{fVar.a(), TiebaApplication.v()});
                return databaseService.a("Insert into chunk_upload_data(md5,total_length,chunk_no,account,time) values(?,?,?,?,?)", new Object[]{fVar.a(), Long.valueOf(fVar.b()), Integer.valueOf(fVar.c()), TiebaApplication.v(), Long.valueOf(date.getTime() / 1000)}).booleanValue();
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b("DatabaseService", "saveChunkUploadData", "error = " + e.getMessage());
                cb.a(e, "DatabaseService.saveChunkUploadData", new Object[0]);
                return false;
            }
        }
        return false;
    }

    public static com.baidu.tieba.data.f k(String str) {
        Cursor cursor;
        Throwable th;
        com.baidu.tieba.data.f fVar = null;
        if (TiebaApplication.v() != null) {
            try {
                cursor = new DatabaseService().a("select * from chunk_upload_data where md5=? and account=? and strftime('%s','now') - time < 48 * 3600", new String[]{str, TiebaApplication.v()});
                if (cursor != null) {
                    try {
                        try {
                            if (cursor.moveToFirst()) {
                                com.baidu.tieba.data.f fVar2 = new com.baidu.tieba.data.f();
                                try {
                                    fVar2.a(str);
                                    fVar2.a(cursor.getInt(3));
                                    fVar2.a(cursor.getLong(2));
                                    fVar = fVar2;
                                } catch (Exception e) {
                                    fVar = fVar2;
                                    e = e;
                                    com.baidu.adp.lib.util.e.b("DatabaseService", "getChunkUploadDataByMd5", "error = " + e.getMessage());
                                    cb.a(e, "DatabaseService.getChunkUploadDataByMd5", new Object[0]);
                                    if (cursor != null) {
                                        try {
                                            cursor.close();
                                        } catch (Exception e2) {
                                            cb.a(e2, "DatabaseService.getChunkUploadDataByMd5 close cursor", new Object[0]);
                                        }
                                    }
                                    return fVar;
                                }
                            }
                            cursor.close();
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e3) {
                                    cb.a(e3, "DatabaseService.getChunkUploadDataByMd5 close cursor", new Object[0]);
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e4) {
                        e = e4;
                    }
                }
            } catch (Exception e5) {
                e = e5;
                cursor = null;
            } catch (Throwable th3) {
                cursor = null;
                th = th3;
            }
        }
        return fVar;
    }

    public static void u() {
        synchronized (DatabaseService.class) {
            try {
                d.close();
            } catch (Exception e) {
            }
            try {
                af.j("tieba_database.db");
            } catch (Exception e2) {
            }
            d = null;
        }
    }

    public static void l(String str) {
        if (str != null) {
            DatabaseService databaseService = new DatabaseService();
            try {
                databaseService.a("delete from cash_data where account=?", (Object[]) new String[]{str});
                databaseService.a("delete from mark_data where account=?", (Object[]) new String[]{str});
                databaseService.a("delete from draft_box where account=?", new Object[]{str});
                databaseService.a("delete from account_data where id=?", new Object[]{str});
                databaseService.a("delete from setting where account=?", new Object[]{str});
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b("DatabaseService", "deleteAccountAllInfo", e.getMessage());
                cb.a(e, "DatabaseService.deleteAccountAllInfo", new Object[0]);
            }
        }
    }

    public static boolean a(String str, int i) {
        DatabaseService databaseService = new DatabaseService();
        try {
            databaseService.a("delete from cash_data where type=?", (Object[]) new String[]{String.valueOf(7)});
            return databaseService.a("Insert into cash_data(type ,account ,data ) values(?,?,?)", (Object[]) new String[]{String.valueOf(7), "", str}).booleanValue();
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b("DatabaseService", "cashHostspot", "error = " + e.getMessage());
            cb.a(e, new StringBuilder("DatabaseService.cashNoAccountData7").toString(), new Object[0]);
            return false;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x0097 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x001a */
    /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r0v13, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r0v14, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: java.lang.String */
    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(int i) {
        Throwable th;
        Cursor cursor;
        Cursor cursor2 = null;
        cursor2 = null;
        String str = 0;
        try {
            try {
                cursor = new DatabaseService().a("select * from cash_data where type=? ", new String[]{String.valueOf(7)});
                if (cursor != null) {
                    try {
                        cursor2 = cursor.moveToFirst() ? cursor.getString(2) : null;
                        cursor.close();
                        str = cursor2;
                    } catch (Exception e) {
                        e = e;
                        com.baidu.adp.lib.util.e.b("DatabaseService", "getHotspot", "error = " + e.getMessage());
                        cb.a(e, new StringBuilder("DatabaseService.getNoAccountData7").toString(), new Object[0]);
                        str = cursor2;
                        if (cursor != null) {
                            try {
                                cursor.close();
                                str = cursor2;
                            } catch (Exception e2) {
                                cb.a(e2, "DatabaseService.getNoAccountData7close cursor", new Object[0]);
                                str = cursor2;
                            }
                        }
                        return str;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (0 != 0) {
                    try {
                        cursor2.close();
                    } catch (Exception e3) {
                        cb.a(e3, "DatabaseService.getNoAccountData7close cursor", new Object[0]);
                    }
                }
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            if (0 != 0) {
            }
            throw th;
        }
        return str;
    }

    public static void m(String str) {
        DatabaseService databaseService = new DatabaseService();
        if (str != null) {
            try {
                databaseService.a("delete from frs_image_forums where forum_name=?", (Object[]) new String[]{str});
                databaseService.a("Insert into frs_image_forums(forum_name) values(?)", new Object[]{str});
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b("DatabaseService", "insertFrsImageForum", e.getMessage());
                cb.a(e, "DatabaseService.insertFrsImageForum", new Object[0]);
            }
        }
    }

    public static void n(String str) {
        DatabaseService databaseService = new DatabaseService();
        if (str != null) {
            try {
                databaseService.a("delete from frs_image_forums where forum_name=?", (Object[]) new String[]{str});
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b("DatabaseService", "delFrsImageForum", e.getMessage());
                cb.a(e, "DatabaseService.delFrsImageForum", new Object[0]);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0052 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<String> v() {
        Cursor cursor;
        Exception e;
        ArrayList<String> arrayList;
        Cursor cursor2 = null;
        try {
            try {
                cursor = new DatabaseService().a("select * from frs_image_forums", (String[]) null);
                if (cursor == null) {
                    return null;
                }
                try {
                    arrayList = new ArrayList<>();
                    while (cursor.moveToNext()) {
                        try {
                            arrayList.add(cursor.getString(0));
                        } catch (Exception e2) {
                            e = e2;
                            com.baidu.adp.lib.util.e.b("DatabaseService", "getAllFrsImageForums", e.getMessage());
                            cb.a(e, "DatabaseService.getAllFrsImageForums", new Object[0]);
                            if (cursor == null) {
                                return arrayList;
                            }
                            try {
                                cursor.close();
                                return arrayList;
                            } catch (Exception e3) {
                                cb.a(e3, "DatabaseService.getAllFrsImageForums close cursor", new Object[0]);
                                e3.printStackTrace();
                                return arrayList;
                            }
                        }
                    }
                    cursor.close();
                    return arrayList;
                } catch (Exception e4) {
                    arrayList = null;
                    e = e4;
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        cursor2.close();
                    } catch (Exception e5) {
                        cb.a(e5, "DatabaseService.getAllFrsImageForums close cursor", new Object[0]);
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            cursor = null;
            e = e6;
            arrayList = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
            }
            throw th;
        }
    }
}
