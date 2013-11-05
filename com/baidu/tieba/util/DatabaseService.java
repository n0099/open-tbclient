package com.baidu.tieba.util;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.data.MarkData;
import com.baidu.tieba.data.WriteData;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class DatabaseService {

    /* renamed from: a  reason: collision with root package name */
    private static Boolean f2402a = true;
    private static Boolean b = true;
    private static volatile SQLiteDatabase c = null;
    private static volatile SQLiteDatabase d = null;
    private DatabaseLocation e;

    /* loaded from: classes.dex */
    public enum DatabaseLocation {
        INNER,
        SDCARD
    }

    public DatabaseService() {
        synchronized (DatabaseService.class) {
            this.e = DatabaseLocation.INNER;
            if (c == null || !c.isOpen()) {
                try {
                    c = new k(TiebaApplication.g()).getWritableDatabase();
                } catch (Exception e) {
                    be.b("DatabaseService", "DatabaseService", "error = " + e.getMessage());
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
                            l lVar = new l();
                            lVar.a(new n(this));
                            d = lVar.a();
                        } else {
                            c = new k(TiebaApplication.g()).getWritableDatabase();
                        }
                    } catch (Exception e) {
                        be.b("DatabaseService", "DatabaseService", "error = " + e.getMessage());
                    }
                }
            }
        }
    }

    public void a(String str) {
        try {
            if (this.e == DatabaseLocation.SDCARD && d != null) {
                d.execSQL(str);
            } else if (this.e == DatabaseLocation.INNER && c != null) {
                c.execSQL(str);
            }
        } catch (Exception e) {
            be.a(3, "DatabaseService", "ExecSQL", str + "   error = " + e.getMessage());
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
            be.b("DatabaseService", "ExecSQL", "error = " + e.getMessage());
            be.b("DatabaseService", "ExecSQL", str);
            return false;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004b -> B:7:0x0010). Please submit an issue!!! */
    public Cursor a(String str, String[] strArr) {
        try {
        } catch (Exception e) {
            be.b("DatabaseService", "rawQuery", "error = " + e.getMessage() + " sql = " + str);
        }
        if (this.e == DatabaseLocation.SDCARD && d != null) {
            return d.rawQuery(str, strArr);
        }
        if (this.e == DatabaseLocation.INNER && c != null) {
            return c.rawQuery(str, strArr);
        }
        return null;
    }

    public static Bitmap b(String str) {
        return d("pb_photo", str);
    }

    public static Bitmap c(String str) {
        return d("friend_photo", str);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0077 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Bitmap d(String str, String str2) {
        Cursor cursor;
        Throwable th;
        Bitmap bitmap = null;
        if (str2 != null) {
            DatabaseService databaseService = new DatabaseService(DatabaseLocation.SDCARD);
            if (databaseService != null) {
                try {
                    cursor = databaseService.a("select * from " + str + " where key = ?", new String[]{str2});
                    if (cursor != null) {
                        try {
                            try {
                                if (cursor.moveToFirst()) {
                                    bitmap = e.a(cursor.getBlob(1));
                                }
                            } catch (Exception e) {
                                e = e;
                                be.b("DatabaseService", "getPhoto", "error = " + e.getMessage());
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e2) {
                                    }
                                }
                                return bitmap;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e3) {
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
            } else {
                cursor = null;
            }
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e5) {
                }
            }
        }
        return bitmap;
    }

    public static void a(String str, Bitmap bitmap) {
        a("pb_photo", 5000, str, bitmap);
    }

    public static void b(String str, Bitmap bitmap) {
        a("friend_photo", (int) BdWebErrorView.ERROR_CODE_500, str, bitmap);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0149 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(String str, int i, String str2, Bitmap bitmap) {
        Cursor a2;
        Cursor cursor = null;
        if (str2 != null) {
            DatabaseService databaseService = new DatabaseService(DatabaseLocation.SDCARD);
            if (databaseService != null) {
                try {
                    Cursor a3 = databaseService.a("select count(*) from " + str, (String[]) null);
                    if (a3 != null) {
                        try {
                            try {
                                r0 = a3.moveToFirst() ? a3.getInt(0) : 0;
                                a3.close();
                            } catch (Exception e) {
                                e = e;
                                be.b("DatabaseService", "cashPhoto", "error = " + e.getMessage());
                                if (0 != 0) {
                                    try {
                                        cursor.close();
                                        return;
                                    } catch (Exception e2) {
                                        return;
                                    }
                                }
                                return;
                            }
                        } catch (Throwable th) {
                            th = th;
                            cursor = null;
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e3) {
                                }
                            }
                            throw th;
                        }
                    }
                    if (r0 >= i && (a2 = databaseService.a("select * from " + str + " order by date asc limit 1", (String[]) null)) != null) {
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
                    databaseService.a("Insert into " + str + "(key,image,date) values(?,?,?)", new Object[]{str2, e.c(bitmap, 80), Long.valueOf(new Date().getTime())});
                } catch (Exception e4) {
                    e = e4;
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                    }
                    throw th;
                }
            }
            if (0 != 0) {
                try {
                    cursor.close();
                } catch (Exception e5) {
                }
            }
        }
    }

    public static void d(String str) {
        a(0, str);
    }

    public static void e(String str) {
        a(13, str);
    }

    public static void b() {
        c(0);
    }

    public static String c() {
        return d(0);
    }

    public static String d() {
        return d(13);
    }

    public static void a(String str, String str2) {
        a(0, str, str2);
    }

    public static void f(String str) {
        b(0, str);
    }

    public static void g(String str) {
        b(13, str);
    }

    public static String h(String str) {
        return c(0, str);
    }

    public static void i(String str) {
        a(2, str);
    }

    public static String e() {
        return d(2);
    }

    public static void f() {
        c(2);
    }

    public static void j(String str) {
        a(3, str);
    }

    public static void g() {
        c(3);
    }

    public static String h() {
        return d(3);
    }

    public static void k(String str) {
        a(4, str);
    }

    public static void i() {
        c(4);
    }

    public static String j() {
        return d(4);
    }

    private static void a(int i, String str) {
        DatabaseService databaseService;
        if (TiebaApplication.C() != null && (databaseService = new DatabaseService()) != null) {
            try {
                databaseService.a("delete from cash_data where type=? and account=?", (Object[]) new String[]{String.valueOf(i), TiebaApplication.C()});
                databaseService.a("Insert into cash_data(account,type,data) values(?,?,?)", new Object[]{TiebaApplication.C(), Integer.valueOf(i), str});
            } catch (Exception e) {
                be.b("DatabaseService", "cachData", "error = " + e.getMessage());
            }
        }
    }

    private static void c(int i) {
        if (TiebaApplication.C() != null) {
            DatabaseService databaseService = new DatabaseService();
            if (databaseService != null) {
                try {
                    databaseService.a("delete from cash_data where type=? and account=?", (Object[]) new String[]{String.valueOf(i), TiebaApplication.C()});
                } catch (Exception e) {
                    be.b("DatabaseService", "cachData", "error = " + e.getMessage());
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String d(int i) {
        Cursor cursor;
        String str;
        Exception e;
        Cursor cursor2;
        if (TiebaApplication.C() == null) {
            return null;
        }
        DatabaseService databaseService = new DatabaseService();
        if (databaseService != null) {
            try {
                cursor = databaseService.a("select * from cash_data where type = ? and account=?", new String[]{String.valueOf(i), TiebaApplication.C()});
                if (cursor != null) {
                    try {
                        try {
                            str = cursor.moveToFirst() ? cursor.getString(2) : null;
                            try {
                                cursor.close();
                            } catch (Exception e2) {
                                e = e2;
                                be.b("DatabaseService", "getCachData", "error = " + e.getMessage());
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e3) {
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
            }
        }
        return str;
    }

    private static void a(int i, String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            str2 = SocialConstants.FALSE;
        }
        DatabaseService databaseService = new DatabaseService();
        if (databaseService != null) {
            try {
                databaseService.a("delete from cash_data where type=? and account=?", (Object[]) new String[]{String.valueOf(i), str2});
                databaseService.a("Insert into cash_data(account,type,data) values(?,?,?)", new Object[]{str2, Integer.valueOf(i), str});
            } catch (Exception e) {
                be.b("DatabaseService", "cachData", "error = " + e.getMessage());
            }
        }
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
                be.b("DatabaseService", "cachData", "error = " + e.getMessage());
            }
        }
    }

    private static String c(int i, String str) {
        Cursor cursor;
        String str2;
        Exception e;
        Cursor cursor2;
        Cursor cursor3 = null;
        if (str == null || str.length() == 0) {
            str = SocialConstants.FALSE;
        }
        DatabaseService databaseService = new DatabaseService();
        try {
            if (databaseService != null) {
                try {
                    cursor = databaseService.a("select * from cash_data where type = ? and account=?", new String[]{String.valueOf(i), str});
                    if (cursor != null) {
                        try {
                            str2 = cursor.moveToFirst() ? cursor.getString(2) : null;
                            try {
                                cursor.close();
                            } catch (Exception e2) {
                                e = e2;
                                be.b("DatabaseService", "getCachData", "error = " + e.getMessage());
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e3) {
                                    }
                                }
                                return str2;
                            }
                        } catch (Exception e4) {
                            str2 = null;
                            e = e4;
                        }
                    } else {
                        str2 = null;
                    }
                    cursor2 = null;
                } catch (Exception e5) {
                    cursor = null;
                    str2 = null;
                    e = e5;
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        try {
                            cursor3.close();
                        } catch (Exception e6) {
                        }
                    }
                    throw th;
                }
            } else {
                cursor2 = null;
                str2 = null;
            }
            if (0 != 0) {
                try {
                    cursor2.close();
                } catch (Exception e7) {
                }
            }
            return str2;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void a(AccountData accountData) {
        if (accountData != null && accountData.getAccount() != null) {
            if (accountData.getIsActive() == 1) {
                k();
            }
            DatabaseService databaseService = new DatabaseService();
            try {
                Date date = new Date();
                if (databaseService != null) {
                    databaseService.a("delete from account_data where id=?", (Object[]) new String[]{accountData.getID()});
                    databaseService.a("Insert into account_data(id,account,password,bduss,isactive,tbs,time,portrait) values(?,?,?,?,?,?,?,?)", new Object[]{accountData.getID(), accountData.getAccount(), accountData.getPassword(), accountData.getBDUSS(), Integer.valueOf(accountData.getIsActive()), accountData.getTbs(), Long.valueOf(date.getTime()), accountData.getPortrait()});
                }
            } catch (Exception e) {
                be.b("DatabaseService", "saveAccountData", "error = " + e.getMessage());
            }
        }
    }

    public static void k() {
        DatabaseService databaseService = new DatabaseService();
        if (databaseService != null) {
            try {
                databaseService.a("update account_data set isactive=0 where isactive=1");
            } catch (Exception e) {
                be.b("DatabaseService", "clearActiveAccount", "error = " + e.getMessage());
            }
        }
    }

    public static void b(String str, String str2) {
        DatabaseService databaseService;
        if (str != null && str2 != null && (databaseService = new DatabaseService()) != null) {
            try {
                databaseService.a("update account_data set bduss=? where account=?", (Object[]) new String[]{str2, str});
            } catch (Exception e) {
                be.b("DatabaseService", "updateAccountToken", "error = " + e.getMessage());
            }
        }
    }

    public static void c(String str, String str2) {
        DatabaseService databaseService;
        if (str != null && str2 != null && (databaseService = new DatabaseService()) != null) {
            try {
                databaseService.a("update account_data set portrait=? where account=?", (Object[]) new String[]{str2, str});
            } catch (Exception e) {
                be.b("DatabaseService", "updateAccountPortrait", "error = " + e.getMessage());
            }
        }
    }

    public static ArrayList<AccountData> l() {
        Cursor cursor;
        Cursor cursor2;
        Cursor cursor3 = null;
        DatabaseService databaseService = new DatabaseService();
        ArrayList<AccountData> arrayList = new ArrayList<>();
        try {
            if (databaseService != null) {
                try {
                    cursor = databaseService.a("select * from account_data order by time desc", (String[]) null);
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
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
                                be.b("DatabaseService", "getAllAccountData", "error = " + e.getMessage());
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e2) {
                                    }
                                }
                                return arrayList;
                            }
                        }
                        cursor.close();
                    }
                    cursor2 = null;
                } catch (Exception e3) {
                    e = e3;
                    cursor = null;
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        try {
                            cursor3.close();
                        } catch (Exception e4) {
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
                } catch (Exception e5) {
                }
            }
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    public static int m() {
        Cursor cursor = null;
        int i = 0;
        DatabaseService databaseService = new DatabaseService();
        try {
            if (databaseService != null) {
                try {
                    cursor = databaseService.a("select count(*) from account_data", (String[]) null);
                    if (cursor != null && cursor.moveToFirst()) {
                        i = cursor.getInt(0);
                    }
                } catch (Exception e) {
                    be.b("DatabaseService", "getAccountNum", e.getMessage());
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e2) {
                        }
                    }
                }
            }
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e3) {
                }
            }
            return i;
        } catch (Throwable th) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e4) {
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0096 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AccountData n() {
        Cursor cursor;
        AccountData accountData;
        Exception e;
        Cursor cursor2;
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
                                } catch (Exception e2) {
                                    e = e2;
                                    accountData = accountData2;
                                    be.b("DatabaseService", "getActiveAccountData", "error = " + e.getMessage());
                                    if (cursor != null) {
                                        try {
                                            cursor.close();
                                        } catch (Exception e3) {
                                        }
                                    }
                                    return accountData;
                                }
                            } else {
                                accountData = null;
                            }
                        } catch (Exception e4) {
                            accountData = null;
                            e = e4;
                        }
                        try {
                            cursor.close();
                        } catch (Exception e5) {
                            e = e5;
                            be.b("DatabaseService", "getActiveAccountData", "error = " + e.getMessage());
                            if (cursor != null) {
                            }
                            return accountData;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception e6) {
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
            }
        } else {
            cursor2 = null;
            accountData = null;
        }
        if (0 != 0) {
            try {
                cursor2.close();
            } catch (Exception e8) {
            }
        }
        return accountData;
    }

    public static ArrayList<String> o() {
        return e(0);
    }

    public static ArrayList<String> p() {
        return e(1);
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0013 A[EXC_TOP_SPLITTER, LOOP:0: B:54:0x0013->B:59:0x0013, LOOP_START, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
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
                                        be.b("DatabaseService", "getAllSearchData", "error = " + e.getMessage());
                                        if (cursor2 != null) {
                                            try {
                                                cursor2.close();
                                            } catch (Exception e2) {
                                            }
                                        }
                                        return arrayList;
                                    } catch (Throwable th) {
                                        th = th;
                                        cursor2 = a2;
                                        break;
                                    }
                                }
                                a2.close();
                            }
                            cursor = null;
                            break;
                        case 1:
                            a2 = databaseService.a("select * from search_post_data order by time desc limit 10", (String[]) null);
                            if (a2 != null) {
                            }
                            cursor = null;
                            break;
                        default:
                            a2 = null;
                            if (a2 != null) {
                            }
                            cursor = null;
                            break;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            if (cursor2 != null) {
                try {
                    cursor2.close();
                } catch (Exception e4) {
                }
            }
            throw th;
        }
        cursor = null;
        if (0 != 0) {
            try {
                cursor.close();
            } catch (Exception e5) {
            }
        }
        return arrayList;
    }

    public static void l(String str) {
        d(0, str);
    }

    public static void m(String str) {
        d(1, str);
    }

    private static void d(int i, String str) {
        DatabaseService databaseService = new DatabaseService();
        if (databaseService != null && str != null) {
            try {
                Date date = new Date();
                switch (i) {
                    case 0:
                        databaseService.a("delete from search_data where key=?", (Object[]) new String[]{str});
                        databaseService.a("Insert into search_data(key,account,time) values(?,?,?)", new Object[]{str, TiebaApplication.C(), Long.valueOf(date.getTime())});
                        break;
                    case 1:
                        databaseService.a("delete from search_post_data where key=?", (Object[]) new String[]{str});
                        databaseService.a("Insert into search_post_data(key,account,time) values(?,?,?)", new Object[]{str, TiebaApplication.C(), Long.valueOf(date.getTime())});
                        break;
                }
            } catch (Exception e) {
                be.b("DatabaseService", "saveSearchData", "error = " + e.getMessage());
            }
        }
    }

    public static void q() {
        a(0);
    }

    public static void r() {
        a(1);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x0012 -> B:15:0x000a). Please submit an issue!!! */
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
                be.b("DatabaseService", "delAllSearchData", "error = " + e.getMessage());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0121 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<MarkData> s() {
        Cursor cursor;
        Throwable th;
        Exception e;
        Cursor cursor2 = null;
        if (TiebaApplication.C() == null) {
            return null;
        }
        DatabaseService databaseService = new DatabaseService();
        ArrayList<MarkData> arrayList = new ArrayList<>();
        if (databaseService != null) {
            try {
                cursor = databaseService.a("select * from mark_data where account=? order by time desc", new String[]{TiebaApplication.C()});
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        try {
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
                                be.b("DatabaseService", "getAllMarkData", "error = " + e.getMessage());
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e3) {
                                    }
                                }
                                be.a("DatabaseService", "getAllMarkData", "success = " + String.valueOf(arrayList.size()));
                                return arrayList;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e4) {
                                }
                            }
                            throw th;
                        }
                    }
                    cursor.close();
                }
                a((Boolean) false);
            } catch (Exception e5) {
                cursor = null;
                e = e5;
            } catch (Throwable th3) {
                cursor = null;
                th = th3;
                if (cursor != null) {
                }
                throw th;
            }
        }
        if (0 != 0) {
            try {
                cursor2.close();
            } catch (Exception e6) {
            }
        }
        be.a("DatabaseService", "getAllMarkData", "success = " + String.valueOf(arrayList.size()));
        return arrayList;
    }

    public static void a(Boolean bool) {
        f2402a = bool;
    }

    public static void b(Boolean bool) {
        b = bool;
    }

    public static void a(WriteData writeData) {
        if (TiebaApplication.C() != null) {
            DatabaseService databaseService = new DatabaseService();
            try {
                if (writeData.getType() == 0) {
                    databaseService.a("delete from draft_box where account=? and type=? and forum_id=?", new Object[]{TiebaApplication.C(), 0, writeData.getForumId()});
                } else if (writeData.getType() == 1) {
                    databaseService.a("delete from draft_box where account=? and type=? and thread_id=?", new Object[]{TiebaApplication.C(), 1, writeData.getThreadId()});
                } else {
                    databaseService.a("delete from draft_box where account=? and type=? and thread_id=? and floor_id=?", new Object[]{TiebaApplication.C(), 2, writeData.getThreadId(), writeData.getFloor()});
                }
            } catch (Exception e) {
                be.b("DatabaseService", "deleteDraftBox", "error = " + e.getMessage());
            }
        }
    }

    public static void t() {
        long time = new Date().getTime() - 604800000;
        try {
            new DatabaseService().a("delete from draft_box where time<?", new Object[]{Long.valueOf(time)});
        } catch (Exception e) {
            be.b("DatabaseService", "delMouthAgoDraft", "error = " + e.getMessage());
        }
    }

    public static void b(WriteData writeData) {
        if (TiebaApplication.C() != null) {
            a(writeData);
            try {
                new DatabaseService().a("Insert into draft_box(account,type,forum_id,forum_name,thread_id,floor_id,title,content,time) values(?,?,?,?,?,?,?,?,?)", new Object[]{TiebaApplication.C(), Integer.valueOf(writeData.getType()), writeData.getForumId(), writeData.getForumName(), writeData.getThreadId(), writeData.getFloor(), writeData.getTitle(), writeData.getContent(), Long.valueOf(new Date().getTime())});
            } catch (Exception e) {
                be.b("DatabaseService", "saveDraftBox", "error = " + e.getMessage());
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x00c6 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:40:0x00d6 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:8:0x002a */
    /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: com.baidu.tieba.data.WriteData */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static WriteData a(int i, String str, String str2, String str3) {
        Throwable th;
        Cursor cursor;
        WriteData writeData = 0;
        writeData = 0;
        writeData = 0;
        writeData = 0;
        writeData = 0;
        if (TiebaApplication.C() != null) {
            DatabaseService databaseService = new DatabaseService();
            try {
                try {
                    if (i == 0) {
                        cursor = databaseService.a("select * from draft_box where account=? and type=? and forum_id=?", new String[]{TiebaApplication.C(), String.valueOf(i), str});
                    } else if (i == 1) {
                        cursor = databaseService.a("select * from draft_box where account=? and type=? and thread_id=?", new String[]{TiebaApplication.C(), String.valueOf(i), str2});
                    } else {
                        cursor = databaseService.a("select * from draft_box where account=? and type=? and thread_id=? and floor_id=?", new String[]{TiebaApplication.C(), String.valueOf(i), str2, str3});
                    }
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                WriteData writeData2 = new WriteData();
                                try {
                                    writeData2.setType(i);
                                    writeData2.setForumId(str);
                                    writeData2.setForumName(cursor.getString(3));
                                    writeData2.setThreadId(str2);
                                    writeData2.setFloor(str3);
                                    writeData2.setTitle(cursor.getString(6));
                                    writeData2.setContent(cursor.getString(7));
                                    writeData = writeData2;
                                } catch (Exception e) {
                                    writeData = writeData2;
                                    e = e;
                                    be.b("DatabaseService", "getDraftBox", "error = " + e.getMessage());
                                    if (cursor != null) {
                                        try {
                                            cursor.close();
                                        } catch (Exception e2) {
                                        }
                                    }
                                    return writeData;
                                }
                            }
                        } catch (Exception e3) {
                            e = e3;
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
                    if (0 != 0) {
                        try {
                            writeData.close();
                        } catch (Exception e5) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
                if (0 != 0) {
                }
                throw th;
            }
        }
        return writeData;
    }

    public static void u() {
        if (TiebaApplication.C() != null) {
            DatabaseService databaseService = new DatabaseService();
            try {
                databaseService.a("delete from setting where account=?", new Object[]{TiebaApplication.C()});
                Object[] objArr = new Object[10];
                objArr[0] = TiebaApplication.C();
                objArr[1] = Integer.valueOf(TiebaApplication.g().R());
                objArr[2] = Integer.valueOf(TiebaApplication.g().aa() ? 1 : 0);
                objArr[3] = Integer.valueOf(TiebaApplication.g().ac() ? 1 : 0);
                objArr[4] = Integer.valueOf(TiebaApplication.g().ab() ? 1 : 0);
                objArr[5] = Integer.valueOf(TiebaApplication.g().Z());
                objArr[6] = Integer.valueOf(TiebaApplication.g().ad() ? 1 : 0);
                objArr[7] = Integer.valueOf(TiebaApplication.g().U() ? 1 : 0);
                objArr[8] = TiebaApplication.g().V();
                objArr[9] = TiebaApplication.g().W();
                databaseService.a("Insert into setting(account,frequency,fans_switch,reply_me_switch,at_me_switch,remind_tone,msg_chat_switch,nodisturb_switch,nodisturb_start_time,nodisturb_end_time) values(?,?,?,?,?,?,?,?,?,?)", objArr);
            } catch (Exception e) {
                be.b("DatabaseService", "saveDraftBox", "error = " + e.getMessage());
            }
        }
    }

    public static void v() {
        be.a("databaseService", "getSetting", TiebaApplication.H());
        if (TiebaApplication.C() == null || TiebaApplication.C().length() <= 0 || TiebaApplication.H() == null) {
            TiebaApplication.g().d(0);
            return;
        }
        Cursor cursor = null;
        try {
            try {
                Cursor a2 = new DatabaseService().a("select * from setting where account=?", new String[]{TiebaApplication.C()});
                if (a2 != null && a2.moveToFirst()) {
                    TiebaApplication.g().d(a2.getInt(1));
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
                    TiebaApplication.g().c(a2.getInt(5));
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
                    TiebaApplication.g().d(300);
                    TiebaApplication.g().m(true);
                    TiebaApplication.g().o(true);
                    TiebaApplication.g().n(true);
                    TiebaApplication.g().j(true);
                    TiebaApplication.g().l(false);
                    TiebaApplication.g().p(true);
                    TiebaApplication.g().k(false);
                    TiebaApplication.g().o("23:00");
                    TiebaApplication.g().p("09:00");
                }
                if (a2 != null) {
                    try {
                        a2.close();
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
                be.b("DatabaseService", "getDraftBox", "error = " + e2.getMessage());
                if (0 != 0) {
                    try {
                        cursor.close();
                    } catch (Exception e3) {
                    }
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    cursor.close();
                } catch (Exception e4) {
                }
            }
            throw th;
        }
    }

    public static void w() {
        DatabaseService databaseService;
        if (TiebaApplication.C() != null && (databaseService = new DatabaseService()) != null) {
            try {
                databaseService.a("delete from chunk_upload_data where strftime('%s','now') - time > 48 * 3600 and account=?", (Object[]) new String[]{TiebaApplication.C()});
            } catch (Exception e) {
                be.b("DatabaseService", "delChunkUploadData", "error = " + e.getMessage());
            }
        }
    }

    public static void n(String str) {
        if (TiebaApplication.C() != null) {
            DatabaseService databaseService = new DatabaseService();
            if (str != null && databaseService != null) {
                try {
                    databaseService.a("delete from chunk_upload_data where md5=? and account=?", (Object[]) new String[]{str, TiebaApplication.C()});
                } catch (Exception e) {
                    be.b("DatabaseService", "delChunkUploadData", "error = " + e.getMessage());
                }
            }
        }
    }

    public static boolean a(com.baidu.tieba.data.e eVar) {
        if (TiebaApplication.C() == null) {
            return false;
        }
        DatabaseService databaseService = new DatabaseService();
        Date date = new Date();
        if (eVar == null || databaseService == null) {
            return false;
        }
        try {
            databaseService.a("delete from chunk_upload_data where md5=? and account=?", (Object[]) new String[]{eVar.a(), TiebaApplication.C()});
            return databaseService.a("Insert into chunk_upload_data(md5,total_length,chunk_no,account,time) values(?,?,?,?,?)", new Object[]{eVar.a(), Long.valueOf(eVar.b()), Integer.valueOf(eVar.c()), TiebaApplication.C(), Long.valueOf(date.getTime() / 1000)}).booleanValue();
        } catch (Exception e) {
            be.b("DatabaseService", "saveChunkUploadData", "error = " + e.getMessage());
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0073 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x007d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.baidu.tieba.data.e o(String str) {
        Cursor cursor;
        Exception e;
        com.baidu.tieba.data.e eVar;
        Cursor cursor2;
        if (TiebaApplication.C() == null) {
            return null;
        }
        DatabaseService databaseService = new DatabaseService();
        if (databaseService != null) {
            try {
                Cursor a2 = databaseService.a("select * from chunk_upload_data where md5=? and account=? and strftime('%s','now') - time < 48 * 3600", new String[]{str, TiebaApplication.C()});
                if (a2 != null) {
                    try {
                        try {
                            if (a2.moveToFirst()) {
                                com.baidu.tieba.data.e eVar2 = new com.baidu.tieba.data.e();
                                try {
                                    eVar2.a(str);
                                    eVar2.a(a2.getInt(3));
                                    eVar2.a(a2.getLong(2));
                                    eVar = eVar2;
                                } catch (Exception e2) {
                                    e = e2;
                                    eVar = eVar2;
                                    cursor = a2;
                                    try {
                                        be.b("DatabaseService", "getChunkUploadDataByMd5", "error = " + e.getMessage());
                                        if (cursor != null) {
                                            try {
                                                cursor.close();
                                            } catch (Exception e3) {
                                            }
                                        }
                                        return eVar;
                                    } catch (Throwable th) {
                                        th = th;
                                        if (cursor != null) {
                                        }
                                        throw th;
                                    }
                                }
                            } else {
                                eVar = null;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            cursor = a2;
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e4) {
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e5) {
                        cursor = a2;
                        e = e5;
                        eVar = null;
                    }
                    try {
                        a2.close();
                    } catch (Exception e6) {
                        e = e6;
                        cursor = a2;
                        be.b("DatabaseService", "getChunkUploadDataByMd5", "error = " + e.getMessage());
                        if (cursor != null) {
                        }
                        return eVar;
                    }
                } else {
                    eVar = null;
                }
                cursor2 = null;
            } catch (Exception e7) {
                cursor = null;
                e = e7;
                eVar = null;
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
            }
        } else {
            eVar = null;
            cursor2 = null;
        }
        if (0 != 0) {
            try {
                cursor2.close();
            } catch (Exception e8) {
            }
        }
        return eVar;
    }

    public static void x() {
        synchronized (DatabaseService.class) {
            try {
                d.close();
            } catch (Exception e) {
            }
            try {
                w.j("tieba_database.db");
            } catch (Exception e2) {
            }
            d = null;
        }
    }

    public static void p(String str) {
        DatabaseService databaseService;
        if (str != null && (databaseService = new DatabaseService()) != null) {
            try {
                databaseService.a("delete from cash_data where account=?", (Object[]) new String[]{str});
                databaseService.a("delete from mark_data where account=?", (Object[]) new String[]{str});
                databaseService.a("delete from draft_box where account=?", new Object[]{str});
                databaseService.a("delete from account_data where id=?", new Object[]{str});
                databaseService.a("delete from setting where account=?", new Object[]{str});
            } catch (Exception e) {
                be.b("DatabaseService", "deleteAccountAllInfo", e.getMessage());
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
                be.b("DatabaseService", "cashHostspot", "error = " + e.getMessage());
                return false;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x005e A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
                                be.b("DatabaseService", "getHotspot", "error = " + e.getMessage());
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e3) {
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
            }
        }
        return str;
    }

    public static void q(String str) {
        DatabaseService databaseService = new DatabaseService();
        if (databaseService != null && str != null) {
            try {
                databaseService.a("delete from frs_image_forums where forum_name=?", (Object[]) new String[]{str});
                databaseService.a("Insert into frs_image_forums(forum_name) values(?)", new Object[]{str});
            } catch (Exception e) {
                be.b("DatabaseService", "insertFrsImageForum", e.getMessage());
            }
        }
    }

    public static void r(String str) {
        DatabaseService databaseService = new DatabaseService();
        if (databaseService != null) {
            if (str != null) {
                try {
                    databaseService.a("delete from frs_image_forums where forum_name=?", (Object[]) new String[]{str});
                } catch (Exception e) {
                    be.b("DatabaseService", "delFrsImageForum", e.getMessage());
                }
            }
        }
    }

    public static ArrayList<String> y() {
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
                                    be.b("DatabaseService", "getAllFrsImageForums", e.getMessage());
                                    if (cursor != null) {
                                        try {
                                            cursor.close();
                                        } catch (Exception e3) {
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
            }
        } else {
            arrayList = null;
            cursor2 = null;
        }
        if (0 != 0) {
            try {
                cursor2.close();
            } catch (Exception e7) {
                e7.printStackTrace();
            }
        }
        return arrayList;
    }
}
