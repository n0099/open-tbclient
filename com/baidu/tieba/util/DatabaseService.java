package com.baidu.tieba.util;

import android.content.Context;
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
                com.baidu.adp.lib.util.f.c("database corrupted.  recreate!");
                try {
                    y.a(TiebaApplication.g().b());
                } catch (Throwable th2) {
                    com.baidu.adp.lib.util.f.b("failed to drop database. msg:" + th2.getMessage());
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
                    com.baidu.adp.lib.util.f.b("DatabaseService", "DatabaseService", "error = " + e.getMessage());
                }
            }
        }
    }

    public DatabaseService(DatabaseLocation databaseLocation) {
        synchronized (DatabaseService.class) {
            this.e = databaseLocation;
            if (this.e != DatabaseLocation.SDCARD || d == null || !d.isOpen()) {
                if (this.e != DatabaseLocation.INNER || c == null || !c.isOpen()) {
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
                        com.baidu.adp.lib.util.f.b("DatabaseService", "DatabaseService", "error = " + e.getMessage());
                    }
                }
            }
        }
    }

    public boolean a(String str) {
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
            com.baidu.adp.lib.util.f.b(getClass().getName(), "ExecSQL", String.valueOf(str) + "   error = " + e.getMessage());
            throw e;
        }
    }

    public static SQLiteDatabase a() {
        new DatabaseService();
        return c;
    }

    public Boolean a(String str, Object[] objArr) {
        try {
            if (this.e == DatabaseLocation.SDCARD && d != null) {
                d.execSQL(str, objArr);
            } else if (this.e == DatabaseLocation.INNER && c != null) {
                c.execSQL(str, objArr);
            }
            return true;
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("DatabaseService", "ExecSQL", "error = " + e.getMessage());
            com.baidu.adp.lib.util.f.b("DatabaseService", "ExecSQL", str);
            throw e;
        }
    }

    public Cursor a(String str, String[] strArr) {
        try {
            if (this.e == DatabaseLocation.SDCARD && d != null) {
                return d.rawQuery(str, strArr);
            }
            if (this.e != DatabaseLocation.INNER || c == null) {
                return null;
            }
            return c.rawQuery(str, strArr);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("DatabaseService", "rawQuery", "error = " + e.getMessage() + " sql = " + str);
            throw e;
        }
    }

    public static com.baidu.tieba.util.a.f a(String str, long j) {
        return a("pb_photo", str, j);
    }

    public static com.baidu.tieba.util.a.f b(String str, long j) {
        return a("friend_photo", str, j);
    }

    public static com.baidu.tieba.util.a.f b(String str) {
        return a("user_icon", str, 0L);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [325=5, 326=5, 328=5, 329=5] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0126 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static com.baidu.tieba.util.a.f a(String str, String str2, long j) {
        Cursor cursor;
        Throwable th;
        com.baidu.tieba.util.a.f fVar = null;
        if (str2 != null) {
            DatabaseService databaseService = new DatabaseService(DatabaseLocation.SDCARD);
            if (databaseService != null) {
                try {
                    cursor = databaseService.a("select * from " + str + " where key = ?", new String[]{str2});
                    if (cursor != null) {
                        try {
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
                                                com.baidu.adp.lib.util.f.b("DatabaseService", "getPhoto", "error = " + e.getMessage());
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
                            } catch (Throwable th2) {
                                th = th2;
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e5) {
                                        cb.a(e5, "DatabaseService.getPhoto" + str + "close cursor", new Object[0]);
                                    }
                                }
                                throw th;
                            }
                        } catch (Exception e6) {
                            e = e6;
                        }
                    }
                } catch (Exception e7) {
                    e = e7;
                    cursor = null;
                } catch (Throwable th3) {
                    cursor = null;
                    th = th3;
                    if (cursor != null) {
                    }
                    throw th;
                }
            } else {
                cursor = null;
            }
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e8) {
                    cb.a(e8, "DatabaseService.getPhoto" + str + "close cursor", new Object[0]);
                }
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

    /* JADX WARN: Removed duplicated region for block: B:59:0x017d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(String str, int i, String str2, Bitmap bitmap, long j) {
        Cursor cursor;
        int i2;
        Cursor cursor2;
        Cursor a2;
        if (str2 != null) {
            DatabaseService databaseService = new DatabaseService(DatabaseLocation.SDCARD);
            if (databaseService != null) {
                try {
                    Cursor a3 = databaseService.a("select count(*) from " + str, (String[]) null);
                    if (a3 != null) {
                        try {
                            try {
                                i2 = a3.moveToFirst() ? a3.getInt(0) : 0;
                                a3.close();
                            } catch (Exception e) {
                                e = e;
                                com.baidu.adp.lib.util.f.b("DatabaseService", "cashPhoto", "error = " + e.getMessage());
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
                    cursor2 = null;
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
            } else {
                cursor2 = null;
            }
            if (0 != 0) {
                try {
                    cursor2.close();
                } catch (Exception e5) {
                    cb.a(e5, "DatabaseService.cashPhoto" + str + "close cursor", new Object[0]);
                }
            }
        }
    }

    public static void c(String str) {
        a(13, str);
    }

    public static String b() {
        return d(13);
    }

    public static void d(String str) {
        b(13, str);
    }

    public static void e(String str) {
        a(2, str);
    }

    public static String c() {
        return d(2);
    }

    public static void d() {
        c(2);
    }

    public static void f(String str) {
        a(3, str);
    }

    public static void e() {
        c(3);
    }

    public static String f() {
        return d(3);
    }

    public static void g(String str) {
        a(4, str);
    }

    public static void g() {
        c(4);
    }

    public static String h() {
        return d(4);
    }

    private static void a(int i, String str) {
        DatabaseService databaseService;
        if (TiebaApplication.A() != null && (databaseService = new DatabaseService()) != null) {
            try {
                databaseService.a("delete from cash_data where type=? and account=?", (Object[]) new String[]{String.valueOf(i), TiebaApplication.A()});
                databaseService.a("Insert into cash_data(account,type,data) values(?,?,?)", new Object[]{TiebaApplication.A(), Integer.valueOf(i), str});
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("DatabaseService", "cachData", "error = " + e.getMessage());
                cb.a(e, "DatabaseService.cashData" + i, new Object[0]);
            }
        }
    }

    private static void c(int i) {
        DatabaseService databaseService;
        if (TiebaApplication.A() != null && (databaseService = new DatabaseService()) != null) {
            try {
                databaseService.a("delete from cash_data where type=? and account=?", (Object[]) new String[]{String.valueOf(i), TiebaApplication.A()});
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("DatabaseService", "cachData", "error = " + e.getMessage());
                cb.a(e, "DatabaseService.delCachData" + i, new Object[0]);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0099 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String d(int i) {
        Cursor cursor;
        String str;
        Exception e;
        Cursor cursor2;
        if (TiebaApplication.A() == null) {
            return null;
        }
        DatabaseService databaseService = new DatabaseService();
        if (databaseService != null) {
            try {
                cursor = databaseService.a("select * from cash_data where type = ? and account=?", new String[]{String.valueOf(i), TiebaApplication.A()});
                if (cursor != null) {
                    try {
                        try {
                            str = cursor.moveToFirst() ? cursor.getString(2) : null;
                            try {
                                cursor.close();
                            } catch (Exception e2) {
                                e = e2;
                                com.baidu.adp.lib.util.f.b("DatabaseService", "getCachData", "error = " + e.getMessage());
                                cb.a(e, "DatabaseService.getCachData" + i, new Object[0]);
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e3) {
                                        cb.a(e3, "DatabaseService.getCachData" + i + "close cursor", new Object[0]);
                                    }
                                }
                                return str;
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e4) {
                                    cb.a(e4, "DatabaseService.getCachData" + i + "close cursor", new Object[0]);
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e5) {
                        str = null;
                        e = e5;
                    }
                } else {
                    str = null;
                }
                cursor2 = null;
            } catch (Exception e6) {
                cursor = null;
                str = null;
                e = e6;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                if (cursor != null) {
                }
                throw th;
            }
        } else {
            cursor2 = null;
            str = null;
        }
        if (0 != 0) {
            try {
                cursor2.close();
            } catch (Exception e7) {
                cb.a(e7, "DatabaseService.getCachData" + i + "close cursor", new Object[0]);
            }
        }
        return str;
    }

    private static void b(int i, String str) {
        if (str == null || str.length() == 0) {
            str = SocialConstants.FALSE;
        }
        DatabaseService databaseService = new DatabaseService();
        if (databaseService != null) {
            try {
                databaseService.a("delete from cash_data where type=? and account=?", (Object[]) new String[]{String.valueOf(i), str});
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("DatabaseService", "cachData", "error = " + e.getMessage());
                cb.a(e, "DatabaseService.delCachData" + i, new Object[0]);
            }
        }
    }

    public static boolean h(String str) {
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
            if (databaseService != null) {
                try {
                    if (!h(accountData.getAccount()) || !a(accountData, databaseService)) {
                        if (!databaseService.a("DROP TABLE IF EXISTS account_data")) {
                            a(TiebaApplication.g().b());
                            databaseService = new DatabaseService();
                        }
                        databaseService.a("CREATE TABLE if not exists account_data(id,account,password,bduss,isactive int,tbs,time,portrait varchar(255))");
                        a(accountData, databaseService);
                    }
                } catch (Exception e) {
                    com.baidu.adp.lib.util.f.b("DatabaseService", "saveAccountData", "error = " + e.getMessage());
                    cb.a(e, "DatabaseService.saveAccountData", new Object[0]);
                }
            }
        }
    }

    public static void i() {
        DatabaseService databaseService = new DatabaseService();
        if (databaseService != null) {
            try {
                databaseService.a("update account_data set isactive=0 where isactive=1");
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("DatabaseService", "clearActiveAccount", "error = " + e.getMessage());
                cb.a(e, "DatabaseService.clearActiveAccount", new Object[0]);
            }
        }
    }

    public static void b(AccountData accountData) {
        i();
        DatabaseService databaseService = new DatabaseService();
        if (databaseService != null) {
            try {
                databaseService.a("update account_data set isactive=1 where account=?", (Object[]) new String[]{accountData.getAccount()});
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("DatabaseService", "clearActiveAccount", "error = " + e.getMessage());
                cb.a(e, "DatabaseService.setActiveAccount", new Object[0]);
            }
        }
    }

    public static void a(String str, String str2) {
        DatabaseService databaseService;
        if (str != null && str2 != null && (databaseService = new DatabaseService()) != null) {
            try {
                databaseService.a("update account_data set portrait=? where account=?", (Object[]) new String[]{str2, str});
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("DatabaseService", "updateAccountPortrait", "error = " + e.getMessage());
                cb.a(e, "DatabaseService.updateAccountPortrait", new Object[0]);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<AccountData> j() {
        Cursor cursor;
        Cursor cursor2;
        DatabaseService databaseService = new DatabaseService();
        ArrayList<AccountData> arrayList = new ArrayList<>();
        if (databaseService != null) {
            try {
                cursor = databaseService.a("select * from account_data order by time desc", (String[]) null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        try {
                            try {
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
                            } catch (Exception e) {
                                e = e;
                                com.baidu.adp.lib.util.f.b("DatabaseService", "getAllAccountData", "error = " + e.getMessage());
                                cb.a(e, "DatabaseService.getAllAccountData", new Object[0]);
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e2) {
                                        cb.a(e2, "DatabaseService.getAllAccountData close cursor", new Object[0]);
                                    }
                                }
                                return arrayList;
                            }
                        } catch (Throwable th) {
                            th = th;
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
                    cursor.close();
                }
                cursor2 = null;
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
        } else {
            cursor2 = null;
        }
        if (0 != 0) {
            try {
                cursor2.close();
            } catch (Exception e5) {
                cb.a(e5, "DatabaseService.getAllAccountData close cursor", new Object[0]);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x001f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int k() {
        int i;
        Cursor cursor = null;
        DatabaseService databaseService = new DatabaseService();
        try {
            if (databaseService != null) {
                try {
                    cursor = databaseService.a("select count(*) from account_data", (String[]) null);
                    if (cursor != null && cursor.moveToFirst()) {
                        i = cursor.getInt(0);
                        if (cursor != null) {
                            try {
                                cursor.close();
                                return i;
                            } catch (Exception e) {
                                cb.a(e, "DatabaseService.getAccountNum close cursor", new Object[0]);
                            }
                        }
                        return i;
                    }
                } catch (Exception e2) {
                    com.baidu.adp.lib.util.f.b("DatabaseService", "getAccountNum", e2.getMessage());
                    cb.a(e2, "DatabaseService.getAccountNum", new Object[0]);
                    if (cursor != null) {
                        try {
                            cursor.close();
                            return 0;
                        } catch (Exception e3) {
                            cb.a(e3, "DatabaseService.getAccountNum close cursor", new Object[0]);
                            return 0;
                        }
                    }
                    return 0;
                }
            }
            i = 0;
            if (cursor != null) {
            }
            return i;
        } catch (Throwable th) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e4) {
                    cb.a(e4, "DatabaseService.getAccountNum close cursor", new Object[0]);
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AccountData l() {
        Cursor cursor;
        Exception exc;
        AccountData accountData;
        Cursor cursor2 = null;
        DatabaseService databaseService = new DatabaseService();
        if (databaseService != null) {
            try {
                cursor = databaseService.a("select * from account_data where isactive=?", new String[]{String.valueOf(1)});
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
                                    cursor2 = cursor;
                                    exc = e;
                                    accountData = accountData2;
                                    try {
                                        com.baidu.adp.lib.util.f.b("DatabaseService", "getActiveAccountData", "error = " + exc.getMessage());
                                        cb.a(exc, "DatabaseService.getActiveAccountData", new Object[0]);
                                        if (cursor2 != null) {
                                            try {
                                                cursor2.close();
                                            } catch (Exception e2) {
                                                cb.a(e2, "DatabaseService.getActiveAccountData close cursor", new Object[0]);
                                            }
                                        }
                                        return accountData;
                                    } catch (Throwable th) {
                                        th = th;
                                        cursor = cursor2;
                                        if (cursor != null) {
                                        }
                                        throw th;
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e3) {
                                    cb.a(e3, "DatabaseService.getActiveAccountData close cursor", new Object[0]);
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e4) {
                        accountData = null;
                        cursor2 = cursor;
                        exc = e4;
                    }
                }
                accountData = null;
            } catch (Exception e5) {
                exc = e5;
                accountData = null;
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
            }
        } else {
            cursor = null;
            accountData = null;
        }
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Exception e6) {
                cb.a(e6, "DatabaseService.getActiveAccountData close cursor", new Object[0]);
            }
        }
        return accountData;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0096 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AccountData i(String str) {
        Cursor cursor;
        AccountData accountData;
        Exception e;
        Cursor cursor2;
        DatabaseService databaseService = new DatabaseService();
        if (databaseService != null) {
            try {
                cursor = databaseService.a("select * from account_data where account=?", new String[]{str});
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
                                } catch (Exception e2) {
                                    e = e2;
                                    accountData = accountData2;
                                    com.baidu.adp.lib.util.f.b("DatabaseService", "getAccountData", "error = " + e.getMessage());
                                    cb.a(e, "DatabaseService.getAccountData", new Object[0]);
                                    if (cursor != null) {
                                    }
                                    return accountData;
                                }
                            } else {
                                accountData = null;
                            }
                        } catch (Exception e3) {
                            accountData = null;
                            e = e3;
                        }
                        try {
                            cursor.close();
                        } catch (Exception e4) {
                            e = e4;
                            com.baidu.adp.lib.util.f.b("DatabaseService", "getAccountData", "error = " + e.getMessage());
                            cb.a(e, "DatabaseService.getAccountData", new Object[0]);
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e5) {
                                    cb.a(e5, "DatabaseService.getAccountData close cursor", new Object[0]);
                                }
                            }
                            return accountData;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception e6) {
                                cb.a(e6, "DatabaseService.getAccountData close cursor", new Object[0]);
                            }
                        }
                        throw th;
                    }
                } else {
                    accountData = null;
                }
                cursor2 = null;
            } catch (Exception e7) {
                cursor = null;
                accountData = null;
                e = e7;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                if (cursor != null) {
                }
                throw th;
            }
        } else {
            cursor2 = null;
            accountData = null;
        }
        if (0 != 0) {
            try {
                cursor2.close();
            } catch (Exception e8) {
                cb.a(e8, "DatabaseService.getAccountData close cursor", new Object[0]);
            }
        }
        return accountData;
    }

    public static ArrayList<String> m() {
        return e(0);
    }

    public static ArrayList<String> n() {
        return e(1);
    }

    private static ArrayList<String> e(int i) {
        Cursor a2;
        Cursor cursor;
        Cursor cursor2 = null;
        DatabaseService databaseService = new DatabaseService();
        ArrayList<String> arrayList = new ArrayList<>();
        if (databaseService != null) {
            try {
                try {
                    switch (i) {
                        case 0:
                            a2 = databaseService.a("select * from search_data order by time desc limit 10", (String[]) null);
                            break;
                        case 1:
                            a2 = databaseService.a("select * from search_post_data order by time desc limit 10", (String[]) null);
                            break;
                        default:
                            a2 = null;
                            break;
                    }
                    if (a2 != null) {
                        while (a2.moveToNext()) {
                            try {
                                String string = a2.getString(0);
                                if (string != null && string.length() > 0) {
                                    arrayList.add(string);
                                }
                            } catch (Exception e) {
                                e = e;
                                cursor2 = a2;
                                com.baidu.adp.lib.util.f.b("DatabaseService", "getAllSearchData", "error = " + e.getMessage());
                                cb.a(e, "DatabaseService.getAllSearchData", new Object[0]);
                                if (cursor2 != null) {
                                    try {
                                        cursor2.close();
                                    } catch (Exception e2) {
                                        cb.a(e2, "DatabaseService.getAllSearchData close cursor", new Object[0]);
                                    }
                                }
                                return arrayList;
                            } catch (Throwable th) {
                                th = th;
                                cursor2 = a2;
                                if (cursor2 != null) {
                                    try {
                                        cursor2.close();
                                    } catch (Exception e3) {
                                        cb.a(e3, "DatabaseService.getAllSearchData close cursor", new Object[0]);
                                    }
                                }
                                throw th;
                            }
                        }
                        a2.close();
                    }
                    cursor = null;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e4) {
                e = e4;
            }
        } else {
            cursor = null;
        }
        if (0 != 0) {
            try {
                cursor.close();
            } catch (Exception e5) {
                cb.a(e5, "DatabaseService.getAllSearchData close cursor", new Object[0]);
            }
        }
        return arrayList;
    }

    public static void j(String str) {
        c(0, str);
    }

    public static void k(String str) {
        c(1, str);
    }

    private static void c(int i, String str) {
        DatabaseService databaseService = new DatabaseService();
        if (databaseService != null && str != null) {
            try {
                Date date = new Date();
                switch (i) {
                    case 0:
                        databaseService.a("delete from search_data where key=?", (Object[]) new String[]{str});
                        databaseService.a("Insert into search_data(key,account,time) values(?,?,?)", new Object[]{str, TiebaApplication.A(), Long.valueOf(date.getTime())});
                        break;
                    case 1:
                        databaseService.a("delete from search_post_data where key=?", (Object[]) new String[]{str});
                        databaseService.a("Insert into search_post_data(key,account,time) values(?,?,?)", new Object[]{str, TiebaApplication.A(), Long.valueOf(date.getTime())});
                        break;
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("DatabaseService", "saveSearchData", "error = " + e.getMessage());
                cb.a(e, "DatabaseService.saveOneSearchData", new Object[0]);
            }
        }
    }

    public static void o() {
        a(0);
    }

    public static void p() {
        a(1);
    }

    public static void a(int i) {
        DatabaseService databaseService = new DatabaseService();
        if (databaseService != null) {
            try {
                switch (i) {
                    case 0:
                        databaseService.a("delete from search_data");
                        break;
                    case 1:
                        databaseService.a("delete from search_post_data");
                        break;
                    default:
                        return;
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("DatabaseService", "delAllSearchData", "error = " + e.getMessage());
                cb.a(e, "DatabaseService.delAllSearchData", new Object[0]);
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:44:0x0140 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.baidu.tieba.util.DatabaseService] */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public static ArrayList<MarkData> q() {
        Cursor cursor;
        Exception e;
        Cursor cursor2;
        if (TiebaApplication.A() == null) {
            return null;
        }
        ?? databaseService = new DatabaseService();
        ArrayList<MarkData> arrayList = new ArrayList<>();
        try {
            if (databaseService != 0) {
                try {
                    cursor = databaseService.a("select * from mark_data where account=? order by time desc", new String[]{TiebaApplication.A()});
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
                                com.baidu.adp.lib.util.f.b("DatabaseService", "getAllMarkData", "error = " + e.getMessage());
                                cb.a(e, "DatabaseService.getAllMarkData", new Object[0]);
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e3) {
                                        cb.a(e3, "DatabaseService.getAllMarkData close cursor", new Object[0]);
                                    }
                                }
                                com.baidu.adp.lib.util.f.a("DatabaseService", "getAllMarkData", "success = " + String.valueOf(arrayList.size()));
                                return arrayList;
                            }
                        }
                        cursor.close();
                    }
                    a((Boolean) false);
                    cursor2 = null;
                } catch (Exception e4) {
                    cursor = null;
                    e = e4;
                } catch (Throwable th) {
                    databaseService = 0;
                    th = th;
                    if (databaseService != 0) {
                        try {
                            databaseService.close();
                        } catch (Exception e5) {
                            cb.a(e5, "DatabaseService.getAllMarkData close cursor", new Object[0]);
                        }
                    }
                    throw th;
                }
            } else {
                cursor2 = null;
            }
            if (0 != 0) {
                try {
                    cursor2.close();
                } catch (Exception e6) {
                    cb.a(e6, "DatabaseService.getAllMarkData close cursor", new Object[0]);
                }
            }
            com.baidu.adp.lib.util.f.a("DatabaseService", "getAllMarkData", "success = " + String.valueOf(arrayList.size()));
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void a(Boolean bool) {
        a = bool;
    }

    public static void b(Boolean bool) {
        b = bool;
    }

    public static void r() {
        if (TiebaApplication.A() != null) {
            DatabaseService databaseService = new DatabaseService();
            try {
                databaseService.a("delete from setting where account=?", new Object[]{TiebaApplication.A()});
                Object[] objArr = new Object[10];
                objArr[0] = TiebaApplication.A();
                objArr[1] = Integer.valueOf(TiebaApplication.g().M());
                objArr[2] = Integer.valueOf(TiebaApplication.g().U() ? 1 : 0);
                objArr[3] = Integer.valueOf(TiebaApplication.g().W() ? 1 : 0);
                objArr[4] = Integer.valueOf(TiebaApplication.g().V() ? 1 : 0);
                objArr[5] = Integer.valueOf(TiebaApplication.g().T());
                objArr[6] = Integer.valueOf(TiebaApplication.g().X() ? 1 : 0);
                objArr[7] = Integer.valueOf(TiebaApplication.g().O() ? 1 : 0);
                objArr[8] = TiebaApplication.g().P();
                objArr[9] = TiebaApplication.g().Q();
                databaseService.a("Insert into setting(account,frequency,fans_switch,reply_me_switch,at_me_switch,remind_tone,msg_chat_switch,nodisturb_switch,nodisturb_start_time,nodisturb_end_time) values(?,?,?,?,?,?,?,?,?,?)", objArr);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("DatabaseService", "saveDraftBox", "error = " + e.getMessage());
                cb.a(e, "DatabaseService.saveSettingData", new Object[0]);
            }
        }
    }

    public static void s() {
        com.baidu.adp.lib.util.f.a("databaseService", "getSetting", TiebaApplication.F());
        if (TiebaApplication.A() == null || TiebaApplication.A().length() <= 0 || TiebaApplication.F() == null) {
            TiebaApplication.g().b(0);
            return;
        }
        Cursor cursor = null;
        try {
            try {
                Cursor a2 = new DatabaseService().a("select * from setting where account=?", new String[]{TiebaApplication.A()});
                if (a2 != null && a2.moveToFirst()) {
                    TiebaApplication.g().b(a2.getInt(1));
                    if (a2.getInt(2) == 0) {
                        TiebaApplication.g().m(false);
                    } else {
                        TiebaApplication.g().m(true);
                    }
                    if (a2.getInt(3) == 0) {
                        TiebaApplication.g().o(false);
                    } else {
                        TiebaApplication.g().o(true);
                    }
                    if (a2.getInt(4) == 0) {
                        TiebaApplication.g().n(false);
                    } else {
                        TiebaApplication.g().n(true);
                    }
                    TiebaApplication.g().a(a2.getInt(5));
                    if (a2.getInt(6) == 0) {
                        TiebaApplication.g().p(false);
                    } else {
                        TiebaApplication.g().p(true);
                    }
                    if (a2.getInt(7) == 0) {
                        TiebaApplication.g().k(false);
                    } else {
                        TiebaApplication.g().k(true);
                    }
                    String string = a2.getString(8);
                    if (TextUtils.isEmpty(string)) {
                        TiebaApplication.g().n("23:00");
                    } else {
                        TiebaApplication.g().n(string);
                    }
                    String string2 = a2.getString(9);
                    if (TextUtils.isEmpty(string2)) {
                        TiebaApplication.g().o("09:00");
                    } else {
                        TiebaApplication.g().o(string2);
                    }
                } else {
                    TiebaApplication.g().b(300);
                    TiebaApplication.g().m(true);
                    TiebaApplication.g().o(true);
                    TiebaApplication.g().n(true);
                    TiebaApplication.g().j(true);
                    TiebaApplication.g().l(false);
                    TiebaApplication.g().p(true);
                    TiebaApplication.g().k(false);
                    TiebaApplication.g().n("23:00");
                    TiebaApplication.g().o("09:00");
                }
                if (a2 != null) {
                    try {
                        a2.close();
                    } catch (Exception e) {
                        cb.a(e, "DatabaseService.getSettingData close cursor", new Object[0]);
                    }
                }
            } catch (Exception e2) {
                com.baidu.adp.lib.util.f.b("DatabaseService", "getDraftBox", "error = " + e2.getMessage());
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
        DatabaseService databaseService;
        if (TiebaApplication.A() != null && (databaseService = new DatabaseService()) != null) {
            try {
                databaseService.a("delete from chunk_upload_data where strftime('%s','now') - time > 48 * 3600 and account=?", (Object[]) new String[]{TiebaApplication.A()});
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("DatabaseService", "delChunkUploadData", "error = " + e.getMessage());
                cb.a(e, "DatabaseService.delOverdueChunkUploadData", new Object[0]);
            }
        }
    }

    public static void l(String str) {
        if (TiebaApplication.A() != null) {
            DatabaseService databaseService = new DatabaseService();
            if (str != null && databaseService != null) {
                try {
                    databaseService.a("delete from chunk_upload_data where md5=? and account=?", (Object[]) new String[]{str, TiebaApplication.A()});
                } catch (Exception e) {
                    com.baidu.adp.lib.util.f.b("DatabaseService", "delChunkUploadData", "error = " + e.getMessage());
                    cb.a(e, "DatabaseService.delChunkUploadData", new Object[0]);
                }
            }
        }
    }

    public static boolean a(com.baidu.tieba.data.f fVar) {
        if (TiebaApplication.A() == null) {
            return false;
        }
        DatabaseService databaseService = new DatabaseService();
        Date date = new Date();
        if (fVar == null || databaseService == null) {
            return false;
        }
        try {
            databaseService.a("delete from chunk_upload_data where md5=? and account=?", (Object[]) new String[]{fVar.a(), TiebaApplication.A()});
            return databaseService.a("Insert into chunk_upload_data(md5,total_length,chunk_no,account,time) values(?,?,?,?,?)", new Object[]{fVar.a(), Long.valueOf(fVar.b()), Integer.valueOf(fVar.c()), TiebaApplication.A(), Long.valueOf(date.getTime() / 1000)}).booleanValue();
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("DatabaseService", "saveChunkUploadData", "error = " + e.getMessage());
            cb.a(e, "DatabaseService.saveChunkUploadData", new Object[0]);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0089 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0078 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.baidu.tieba.data.f m(String str) {
        Cursor cursor;
        Exception e;
        com.baidu.tieba.data.f fVar;
        Cursor cursor2;
        if (TiebaApplication.A() == null) {
            return null;
        }
        DatabaseService databaseService = new DatabaseService();
        if (databaseService != null) {
            try {
                Cursor a2 = databaseService.a("select * from chunk_upload_data where md5=? and account=? and strftime('%s','now') - time < 48 * 3600", new String[]{str, TiebaApplication.A()});
                if (a2 != null) {
                    try {
                        try {
                            if (a2.moveToFirst()) {
                                com.baidu.tieba.data.f fVar2 = new com.baidu.tieba.data.f();
                                try {
                                    fVar2.a(str);
                                    fVar2.a(a2.getInt(3));
                                    fVar2.a(a2.getLong(2));
                                    fVar = fVar2;
                                } catch (Exception e2) {
                                    e = e2;
                                    fVar = fVar2;
                                    cursor = a2;
                                    try {
                                        com.baidu.adp.lib.util.f.b("DatabaseService", "getChunkUploadDataByMd5", "error = " + e.getMessage());
                                        cb.a(e, "DatabaseService.getChunkUploadDataByMd5", new Object[0]);
                                        if (cursor != null) {
                                        }
                                        return fVar;
                                    } catch (Throwable th) {
                                        th = th;
                                        if (cursor != null) {
                                            try {
                                                cursor.close();
                                            } catch (Exception e3) {
                                                cb.a(e3, "DatabaseService.getChunkUploadDataByMd5 close cursor", new Object[0]);
                                            }
                                        }
                                        throw th;
                                    }
                                }
                            } else {
                                fVar = null;
                            }
                            try {
                                a2.close();
                            } catch (Exception e4) {
                                e = e4;
                                cursor = a2;
                                com.baidu.adp.lib.util.f.b("DatabaseService", "getChunkUploadDataByMd5", "error = " + e.getMessage());
                                cb.a(e, "DatabaseService.getChunkUploadDataByMd5", new Object[0]);
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e5) {
                                        cb.a(e5, "DatabaseService.getChunkUploadDataByMd5 close cursor", new Object[0]);
                                    }
                                }
                                return fVar;
                            }
                        } catch (Exception e6) {
                            cursor = a2;
                            e = e6;
                            fVar = null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = a2;
                        if (cursor != null) {
                        }
                        throw th;
                    }
                } else {
                    fVar = null;
                }
                cursor2 = null;
            } catch (Exception e7) {
                cursor = null;
                e = e7;
                fVar = null;
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
            }
        } else {
            fVar = null;
            cursor2 = null;
        }
        if (0 != 0) {
            try {
                cursor2.close();
            } catch (Exception e8) {
                cb.a(e8, "DatabaseService.getChunkUploadDataByMd5 close cursor", new Object[0]);
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

    public static void a(Context context) {
        synchronized (DatabaseService.class) {
            try {
                c.close();
            } catch (Exception e) {
            }
            try {
                context.deleteDatabase("baidu_tieba.db");
            } catch (Exception e2) {
                com.baidu.adp.lib.util.f.b("DatabaseService", "deletDatebase", "error = " + e2.getMessage());
            }
            c = null;
        }
    }

    public static void n(String str) {
        DatabaseService databaseService;
        if (str != null && (databaseService = new DatabaseService()) != null) {
            try {
                databaseService.a("delete from cash_data where account=?", (Object[]) new String[]{str});
                databaseService.a("delete from mark_data where account=?", (Object[]) new String[]{str});
                databaseService.a("delete from draft_box where account=?", new Object[]{str});
                databaseService.a("delete from account_data where id=?", new Object[]{str});
                databaseService.a("delete from setting where account=?", new Object[]{str});
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("DatabaseService", "deleteAccountAllInfo", e.getMessage());
                cb.a(e, "DatabaseService.deleteAccountAllInfo", new Object[0]);
            }
        }
    }

    public static boolean a(String str, int i) {
        DatabaseService databaseService = new DatabaseService();
        if (databaseService != null) {
            try {
                databaseService.a("delete from cash_data where type=?", (Object[]) new String[]{String.valueOf(i)});
                return databaseService.a("Insert into cash_data(type ,account ,data ) values(?,?,?)", (Object[]) new String[]{String.valueOf(i), "", str}).booleanValue();
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("DatabaseService", "cashHostspot", "error = " + e.getMessage());
                cb.a(e, "DatabaseService.cashNoAccountData" + i, new Object[0]);
                return false;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(int i) {
        Cursor cursor;
        Exception e;
        String str;
        Cursor cursor2;
        DatabaseService databaseService = new DatabaseService();
        if (databaseService != null) {
            try {
                cursor = databaseService.a("select * from cash_data where type=? ", new String[]{String.valueOf(i)});
                if (cursor != null) {
                    try {
                        try {
                            str = cursor.moveToFirst() ? cursor.getString(2) : null;
                            try {
                                cursor.close();
                            } catch (Exception e2) {
                                e = e2;
                                com.baidu.adp.lib.util.f.b("DatabaseService", "getHotspot", "error = " + e.getMessage());
                                cb.a(e, "DatabaseService.getNoAccountData" + i, new Object[0]);
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e3) {
                                        cb.a(e3, "DatabaseService.getNoAccountData" + i + "close cursor", new Object[0]);
                                    }
                                }
                                return str;
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e4) {
                                    cb.a(e4, "DatabaseService.getNoAccountData" + i + "close cursor", new Object[0]);
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e5) {
                        str = null;
                        e = e5;
                    }
                } else {
                    str = null;
                }
                cursor2 = null;
            } catch (Exception e6) {
                cursor = null;
                e = e6;
                str = null;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                if (cursor != null) {
                }
                throw th;
            }
        } else {
            str = null;
            cursor2 = null;
        }
        if (0 != 0) {
            try {
                cursor2.close();
            } catch (Exception e7) {
                cb.a(e7, "DatabaseService.getNoAccountData" + i + "close cursor", new Object[0]);
            }
        }
        return str;
    }

    public static void o(String str) {
        DatabaseService databaseService = new DatabaseService();
        if (databaseService != null && str != null) {
            try {
                databaseService.a("delete from frs_image_forums where forum_name=?", (Object[]) new String[]{str});
                databaseService.a("Insert into frs_image_forums(forum_name) values(?)", new Object[]{str});
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("DatabaseService", "insertFrsImageForum", e.getMessage());
                cb.a(e, "DatabaseService.insertFrsImageForum", new Object[0]);
            }
        }
    }

    public static void p(String str) {
        DatabaseService databaseService = new DatabaseService();
        if (databaseService != null && str != null) {
            try {
                databaseService.a("delete from frs_image_forums where forum_name=?", (Object[]) new String[]{str});
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("DatabaseService", "delFrsImageForum", e.getMessage());
                cb.a(e, "DatabaseService.delFrsImageForum", new Object[0]);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x005a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<String> v() {
        Cursor cursor;
        Exception e;
        ArrayList<String> arrayList;
        Cursor cursor2;
        DatabaseService databaseService = new DatabaseService();
        if (databaseService != null) {
            try {
                cursor = databaseService.a("select * from frs_image_forums", (String[]) null);
                if (cursor != null) {
                    try {
                        try {
                            arrayList = new ArrayList<>();
                            while (cursor.moveToNext()) {
                                try {
                                    arrayList.add(cursor.getString(0));
                                } catch (Exception e2) {
                                    e = e2;
                                    com.baidu.adp.lib.util.f.b("DatabaseService", "getAllFrsImageForums", e.getMessage());
                                    cb.a(e, "DatabaseService.getAllFrsImageForums", new Object[0]);
                                    if (cursor != null) {
                                        try {
                                            cursor.close();
                                        } catch (Exception e3) {
                                            cb.a(e3, "DatabaseService.getAllFrsImageForums close cursor", new Object[0]);
                                            e3.printStackTrace();
                                        }
                                    }
                                    return arrayList;
                                }
                            }
                            cursor.close();
                        } catch (Exception e4) {
                            arrayList = null;
                            e = e4;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception e5) {
                                cb.a(e5, "DatabaseService.getAllFrsImageForums close cursor", new Object[0]);
                                e5.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } else {
                    arrayList = null;
                }
                cursor2 = null;
            } catch (Exception e6) {
                cursor = null;
                e = e6;
                arrayList = null;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                if (cursor != null) {
                }
                throw th;
            }
        } else {
            arrayList = null;
            cursor2 = null;
        }
        if (0 != 0) {
            try {
                cursor2.close();
            } catch (Exception e7) {
                cb.a(e7, "DatabaseService.getAllFrsImageForums close cursor", new Object[0]);
                e7.printStackTrace();
            }
        }
        return arrayList;
    }
}
