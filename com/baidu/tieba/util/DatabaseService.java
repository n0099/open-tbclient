package com.baidu.tieba.util;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.mapapi.MKEvent;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.data.MarkData;
import com.baidu.tieba.model.WriteModel;
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

    public DatabaseService() {
        synchronized (DatabaseService.class) {
            this.e = DatabaseLocation.INNER;
            if (c == null || !c.isOpen()) {
                try {
                    c = new h(TiebaApplication.f()).getWritableDatabase();
                } catch (Exception e) {
                    z.b("DatabaseService", "DatabaseService", "error = " + e.getMessage());
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
                            i iVar = new i();
                            iVar.a(new k(this));
                            d = iVar.a();
                        } else {
                            c = new h(TiebaApplication.f()).getWritableDatabase();
                        }
                    } catch (Exception e) {
                        z.b("DatabaseService", "DatabaseService", "error = " + e.getMessage());
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
            z.a(3, "DatabaseService", "ExecSQL", String.valueOf(str) + "   error = " + e.getMessage());
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
            z.b("DatabaseService", "ExecSQL", "error = " + e.getMessage());
            z.b("DatabaseService", "ExecSQL", str);
            return false;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0047 -> B:7:0x0010). Please submit an issue!!! */
    public Cursor a(String str, String[] strArr) {
        try {
        } catch (Exception e) {
            z.b("DatabaseService", "rawQuery", "error = " + e.getMessage() + " sql = " + str);
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x0074 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.baidu.tieba.util.DatabaseService$DatabaseLocation] */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v2 */
    private static Bitmap d(String str, String str2) {
        Cursor cursor;
        Bitmap bitmap = null;
        if (str2 != null) {
            ?? r2 = DatabaseLocation.SDCARD;
            DatabaseService databaseService = new DatabaseService(r2);
            try {
                if (databaseService != null) {
                    try {
                        cursor = databaseService.a("select * from " + str + " where key = ?", new String[]{str2});
                        if (cursor != null) {
                            try {
                                if (cursor.moveToFirst()) {
                                    bitmap = d.a(cursor.getBlob(1));
                                }
                            } catch (Exception e) {
                                e = e;
                                z.b("DatabaseService", "getPhoto", "error = " + e.getMessage());
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e2) {
                                    }
                                }
                                return bitmap;
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        cursor = null;
                    } catch (Throwable th) {
                        r2 = 0;
                        th = th;
                        if (r2 != 0) {
                            try {
                                r2.close();
                            } catch (Exception e4) {
                            }
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
            } catch (Throwable th2) {
                th = th2;
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

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.util.DatabaseService$DatabaseLocation */
    /* JADX WARN: Multi-variable type inference failed */
    private static void a(String str, int i, String str2, Bitmap bitmap) {
        Cursor cursor;
        Cursor a2;
        Cursor cursor2 = null;
        if (str2 != null) {
            DatabaseLocation databaseLocation = DatabaseLocation.SDCARD;
            DatabaseService databaseService = new DatabaseService(databaseLocation);
            try {
                if (databaseService != null) {
                    try {
                        Cursor a3 = databaseService.a("select count(*) from " + str, (String[]) null);
                        if (a3 != null) {
                            try {
                                r0 = a3.moveToFirst() ? a3.getInt(0) : 0;
                                a3.close();
                            } catch (Exception e) {
                                e = e;
                                z.b("DatabaseService", "cashPhoto", "error = " + e.getMessage());
                                if (0 != 0) {
                                    try {
                                        cursor2.close();
                                        return;
                                    } catch (Exception e2) {
                                        return;
                                    }
                                }
                                return;
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
                        databaseService.a("Insert into " + str + "(key,image,date) values(?,?,?)", new Object[]{str2, d.c(bitmap, 80), Long.valueOf(new Date().getTime())});
                        cursor = null;
                    } catch (Exception e3) {
                        e = e3;
                    } catch (Throwable th) {
                        th = th;
                        if (cursor2 != null) {
                            try {
                                cursor2.close();
                            } catch (Exception e4) {
                            }
                        }
                        throw th;
                    }
                } else {
                    cursor = null;
                }
                if (0 != 0) {
                    try {
                        cursor.close();
                    } catch (Exception e5) {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                cursor2 = databaseLocation;
            }
        }
    }

    public static void d(String str) {
        a(0, str);
    }

    public static void e(String str) {
        a(10, str);
    }

    public static void b() {
        c(0);
    }

    public static void c() {
        c(10);
    }

    public static String d() {
        return d(0);
    }

    public static String e() {
        return d(10);
    }

    public static void a(String str, String str2) {
        a(0, str, str2);
    }

    public static void b(String str, String str2) {
        a(10, str, str2);
    }

    public static void f(String str) {
        b(0, str);
    }

    public static void g(String str) {
        b(10, str);
    }

    public static String h(String str) {
        return c(0, str);
    }

    public static String i(String str) {
        return c(10, str);
    }

    public static void j(String str) {
        a(2, str);
    }

    public static void k(String str) {
        a(5, str);
    }

    public static String f() {
        return d(5);
    }

    public static String g() {
        return d(2);
    }

    public static void h() {
        c(2);
    }

    public static void l(String str) {
        a(3, str);
    }

    public static void i() {
        c(3);
    }

    public static String j() {
        return d(3);
    }

    public static void m(String str) {
        a(4, str);
    }

    public static void k() {
        c(4);
    }

    public static String l() {
        return d(4);
    }

    private static void a(int i, String str) {
        DatabaseService databaseService;
        if (TiebaApplication.E() != null && (databaseService = new DatabaseService()) != null) {
            try {
                databaseService.a("delete from cash_data where type=? and account=?", (Object[]) new String[]{String.valueOf(i), TiebaApplication.E()});
                databaseService.a("Insert into cash_data(account,type,data) values(?,?,?)", new Object[]{TiebaApplication.E(), Integer.valueOf(i), str});
            } catch (Exception e) {
                z.b("DatabaseService", "cachData", "error = " + e.getMessage());
            }
        }
    }

    private static void c(int i) {
        DatabaseService databaseService;
        if (TiebaApplication.E() != null && (databaseService = new DatabaseService()) != null) {
            try {
                databaseService.a("delete from cash_data where type=? and account=?", (Object[]) new String[]{String.valueOf(i), TiebaApplication.E()});
            } catch (Exception e) {
                z.b("DatabaseService", "cachData", "error = " + e.getMessage());
            }
        }
    }

    private static String d(int i) {
        Cursor cursor;
        String str;
        Exception e;
        Cursor cursor2;
        Cursor cursor3 = null;
        if (TiebaApplication.E() == null) {
            return null;
        }
        DatabaseService databaseService = new DatabaseService();
        try {
            if (databaseService != null) {
                try {
                    cursor = databaseService.a("select * from cash_data where type = ? and account=?", new String[]{String.valueOf(i), TiebaApplication.E()});
                    if (cursor != null) {
                        try {
                            str = cursor.moveToFirst() ? cursor.getString(2) : null;
                            try {
                                cursor.close();
                            } catch (Exception e2) {
                                e = e2;
                                z.b("DatabaseService", "getCachData", "error = " + e.getMessage());
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e3) {
                                    }
                                }
                                return str;
                            }
                        } catch (Exception e4) {
                            str = null;
                            e = e4;
                        }
                    } else {
                        str = null;
                    }
                    cursor2 = null;
                } catch (Exception e5) {
                    cursor = null;
                    str = null;
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
                str = null;
            }
            if (0 != 0) {
                try {
                    cursor2.close();
                } catch (Exception e7) {
                }
            }
            return str;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void a(int i, String str, String str2) {
        str2 = (str2 == null || str2.length() == 0) ? "0" : "0";
        DatabaseService databaseService = new DatabaseService();
        if (databaseService != null) {
            try {
                databaseService.a("delete from cash_data where type=? and account=?", (Object[]) new String[]{String.valueOf(i), str2});
                databaseService.a("Insert into cash_data(account,type,data) values(?,?,?)", new Object[]{str2, Integer.valueOf(i), str});
            } catch (Exception e) {
                z.b("DatabaseService", "cachData", "error = " + e.getMessage());
            }
        }
    }

    private static void b(int i, String str) {
        str = (str == null || str.length() == 0) ? "0" : "0";
        DatabaseService databaseService = new DatabaseService();
        if (databaseService != null) {
            try {
                databaseService.a("delete from cash_data where type=? and account=?", (Object[]) new String[]{String.valueOf(i), str});
            } catch (Exception e) {
                z.b("DatabaseService", "cachData", "error = " + e.getMessage());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0067 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String c(int i, String str) {
        Cursor cursor;
        String str2;
        Exception e;
        Cursor cursor2;
        str = (str == null || str.length() == 0) ? "0" : "0";
        DatabaseService databaseService = new DatabaseService();
        if (databaseService != null) {
            try {
                cursor = databaseService.a("select * from cash_data where type = ? and account=?", new String[]{String.valueOf(i), str});
                if (cursor != null) {
                    try {
                        try {
                            str2 = cursor.moveToFirst() ? cursor.getString(2) : null;
                            try {
                                cursor.close();
                            } catch (Exception e2) {
                                e = e2;
                                z.b("DatabaseService", "getCachData", "error = " + e.getMessage());
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
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception e5) {
                            }
                        }
                        throw th;
                    }
                } else {
                    str2 = null;
                }
                cursor2 = null;
            } catch (Exception e6) {
                cursor = null;
                str2 = null;
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
            str2 = null;
        }
        if (0 != 0) {
            try {
                cursor2.close();
            } catch (Exception e7) {
            }
        }
        return str2;
    }

    public static void a(AccountData accountData) {
        if (accountData != null && accountData.getAccount() != null) {
            if (accountData.getIsActive() == 1) {
                m();
            }
            DatabaseService databaseService = new DatabaseService();
            try {
                Date date = new Date();
                if (databaseService != null) {
                    databaseService.a("delete from account_data where id=?", (Object[]) new String[]{accountData.getID()});
                    databaseService.a("Insert into account_data(id,account,password,bduss,isactive,tbs,time) values(?,?,?,?,?,?,?)", new Object[]{accountData.getID(), accountData.getAccount(), accountData.getPassword(), accountData.getBDUSS(), Integer.valueOf(accountData.getIsActive()), accountData.getTbs(), Long.valueOf(date.getTime())});
                }
            } catch (Exception e) {
                z.b("DatabaseService", "saveAccountData", "error = " + e.getMessage());
            }
        }
    }

    public static void m() {
        DatabaseService databaseService = new DatabaseService();
        if (databaseService != null) {
            try {
                databaseService.a("update account_data set isactive=0 where isactive=1");
            } catch (Exception e) {
                z.b("DatabaseService", "clearActiveAccount", "error = " + e.getMessage());
            }
        }
    }

    public static void c(String str, String str2) {
        DatabaseService databaseService;
        if (str != null && str2 != null && (databaseService = new DatabaseService()) != null) {
            try {
                databaseService.a("update account_data set bduss=? where account=?", (Object[]) new String[]{str2, str});
            } catch (Exception e) {
                z.b("DatabaseService", "updateAccountToken", "error = " + e.getMessage());
            }
        }
    }

    public static ArrayList n() {
        Cursor cursor;
        Cursor cursor2;
        Cursor cursor3 = null;
        DatabaseService databaseService = new DatabaseService();
        ArrayList arrayList = new ArrayList();
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
                                arrayList.add(accountData);
                            } catch (Exception e) {
                                e = e;
                                z.b("DatabaseService", "getAllAccountData", "error = " + e.getMessage());
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
    public static int o() {
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
                    z.b("DatabaseService", "getAccountNum", e.getMessage());
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

    /* JADX WARN: Removed duplicated region for block: B:45:0x008a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0094 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AccountData p() {
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
                                    accountData = accountData2;
                                } catch (Exception e2) {
                                    e = e2;
                                    accountData = accountData2;
                                    z.b("DatabaseService", "getActiveAccountData", "error = " + e.getMessage());
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
                            z.b("DatabaseService", "getActiveAccountData", "error = " + e.getMessage());
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e5) {
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
            }
        }
        return accountData;
    }

    public static ArrayList q() {
        return e(0);
    }

    public static ArrayList r() {
        return e(1);
    }

    private static ArrayList e(int i) {
        Cursor a2;
        Cursor cursor;
        Cursor cursor2 = null;
        DatabaseService databaseService = new DatabaseService();
        ArrayList arrayList = new ArrayList();
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
                                z.b("DatabaseService", "getAllSearchData", "error = " + e.getMessage());
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
                                if (cursor2 != null) {
                                    try {
                                        cursor2.close();
                                    } catch (Exception e3) {
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
            }
        }
        return arrayList;
    }

    public static void n(String str) {
        d(0, str);
    }

    public static void o(String str) {
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
                        databaseService.a("Insert into search_data(key,account,time) values(?,?,?)", new Object[]{str, TiebaApplication.E(), Long.valueOf(date.getTime())});
                        break;
                    case 1:
                        databaseService.a("delete from search_post_data where key=?", (Object[]) new String[]{str});
                        databaseService.a("Insert into search_post_data(key,account,time) values(?,?,?)", new Object[]{str, TiebaApplication.E(), Long.valueOf(date.getTime())});
                        break;
                }
            } catch (Exception e) {
                z.b("DatabaseService", "saveSearchData", "error = " + e.getMessage());
            }
        }
    }

    public static void s() {
        a(0);
    }

    public static void t() {
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
                z.b("DatabaseService", "delAllSearchData", "error = " + e.getMessage());
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:44:0x0122 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.baidu.tieba.util.DatabaseService] */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public static ArrayList u() {
        Cursor cursor;
        Exception e;
        Cursor cursor2;
        if (TiebaApplication.E() == null) {
            return null;
        }
        ?? databaseService = new DatabaseService();
        ArrayList arrayList = new ArrayList();
        try {
            if (databaseService != 0) {
                try {
                    cursor = databaseService.a("select * from mark_data where account=? order by time desc", new String[]{TiebaApplication.E()});
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
                                z.b("DatabaseService", "getAllMarkData", "error = " + e.getMessage());
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e3) {
                                    }
                                }
                                z.a("DatabaseService", "getAllMarkData", "success = " + String.valueOf(arrayList.size()));
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
                }
            }
            z.a("DatabaseService", "getAllMarkData", "success = " + String.valueOf(arrayList.size()));
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

    public static void a(WriteModel writeModel) {
        if (TiebaApplication.E() != null) {
            DatabaseService databaseService = new DatabaseService();
            try {
                if (writeModel.getType() == 0) {
                    databaseService.a("delete from draft_box where account=? and type=? and forum_id=?", new Object[]{TiebaApplication.E(), 0, writeModel.getForumId()});
                } else if (writeModel.getType() == 1) {
                    databaseService.a("delete from draft_box where account=? and type=? and thread_id=?", new Object[]{TiebaApplication.E(), 1, writeModel.getThreadId()});
                } else {
                    databaseService.a("delete from draft_box where account=? and type=? and thread_id=? and floor_id=?", new Object[]{TiebaApplication.E(), 2, writeModel.getThreadId(), writeModel.getFloor()});
                }
            } catch (Exception e) {
                z.b("DatabaseService", "deleteDraftBox", "error = " + e.getMessage());
            }
        }
    }

    public static void v() {
        long time = new Date().getTime() - 604800000;
        try {
            new DatabaseService().a("delete from draft_box where time<?", new Object[]{Long.valueOf(time)});
        } catch (Exception e) {
            z.b("DatabaseService", "delMouthAgoDraft", "error = " + e.getMessage());
        }
    }

    public static void b(WriteModel writeModel) {
        if (TiebaApplication.E() != null) {
            a(writeModel);
            try {
                new DatabaseService().a("Insert into draft_box(account,type,forum_id,forum_name,thread_id,floor_id,title,content,time) values(?,?,?,?,?,?,?,?,?)", new Object[]{TiebaApplication.E(), Integer.valueOf(writeModel.getType()), writeModel.getForumId(), writeModel.getForumName(), writeModel.getThreadId(), writeModel.getFloor(), writeModel.getTitle(), writeModel.getContent(), Long.valueOf(new Date().getTime())});
            } catch (Exception e) {
                z.b("DatabaseService", "saveDraftBox", "error = " + e.getMessage());
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x00d0 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static WriteModel a(int i, String str, String str2, String str3) {
        Throwable th;
        Cursor cursor;
        WriteModel writeModel = null;
        ?? r2 = 1;
        if (TiebaApplication.E() != null) {
            DatabaseService databaseService = new DatabaseService();
            try {
                try {
                    if (i == 0) {
                        cursor = databaseService.a("select * from draft_box where account=? and type=? and forum_id=?", new String[]{TiebaApplication.E(), String.valueOf(i), str});
                    } else if (i == 1) {
                        cursor = databaseService.a("select * from draft_box where account=? and type=? and thread_id=?", new String[]{TiebaApplication.E(), String.valueOf(i), str2});
                    } else {
                        cursor = databaseService.a("select * from draft_box where account=? and type=? and thread_id=? and floor_id=?", new String[]{TiebaApplication.E(), String.valueOf(i), str2, str3});
                    }
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                WriteModel writeModel2 = new WriteModel();
                                try {
                                    writeModel2.setType(i);
                                    writeModel2.setForumId(str);
                                    writeModel2.setForumName(cursor.getString(3));
                                    writeModel2.setThreadId(str2);
                                    writeModel2.setFloor(str3);
                                    writeModel2.setTitle(cursor.getString(6));
                                    writeModel2.setContent(cursor.getString(7));
                                    writeModel = writeModel2;
                                } catch (Exception e) {
                                    writeModel = writeModel2;
                                    e = e;
                                    z.b("DatabaseService", "getDraftBox", "error = " + e.getMessage());
                                    if (cursor != null) {
                                        try {
                                            cursor.close();
                                        } catch (Exception e2) {
                                        }
                                    }
                                    return writeModel;
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
                    if (r2 != 0) {
                        try {
                            r2.close();
                        } catch (Exception e5) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                cursor = null;
            } catch (Throwable th3) {
                r2 = 0;
                th = th3;
                if (r2 != 0) {
                }
                throw th;
            }
        }
        return writeModel;
    }

    public static void w() {
        if (TiebaApplication.E() != null) {
            DatabaseService databaseService = new DatabaseService();
            try {
                databaseService.a("delete from setting where account=?", new Object[]{TiebaApplication.E()});
                Object[] objArr = new Object[6];
                objArr[0] = TiebaApplication.E();
                objArr[1] = Integer.valueOf(TiebaApplication.f().R());
                objArr[2] = Integer.valueOf(TiebaApplication.f().X() ? 1 : 0);
                objArr[3] = Integer.valueOf(TiebaApplication.f().Z() ? 1 : 0);
                objArr[4] = Integer.valueOf(TiebaApplication.f().Y() ? 1 : 0);
                objArr[5] = Integer.valueOf(TiebaApplication.f().W());
                databaseService.a("Insert into setting(account,frequency,fans_switch,reply_me_switch,at_me_switch,remind_tone) values(?,?,?,?,?,?)", objArr);
            } catch (Exception e) {
                z.b("DatabaseService", "saveDraftBox", "error = " + e.getMessage());
            }
        }
    }

    public static void x() {
        z.a("databaseService", "getSetting", TiebaApplication.H());
        if (TiebaApplication.E() == null || TiebaApplication.E().length() <= 0 || TiebaApplication.H() == null) {
            TiebaApplication.f().f(0);
            return;
        }
        Cursor cursor = null;
        try {
            try {
                Cursor a2 = new DatabaseService().a("select * from setting where account=?", new String[]{TiebaApplication.E()});
                if (a2 != null && a2.moveToFirst()) {
                    TiebaApplication.f().f(a2.getInt(1));
                    if (a2.getInt(2) == 0) {
                        TiebaApplication.f().m(false);
                    } else {
                        TiebaApplication.f().m(true);
                    }
                    if (a2.getInt(3) == 0) {
                        TiebaApplication.f().o(false);
                    } else {
                        TiebaApplication.f().o(true);
                    }
                    if (a2.getInt(4) == 0) {
                        TiebaApplication.f().n(false);
                    } else {
                        TiebaApplication.f().n(true);
                    }
                    TiebaApplication.f().e(a2.getInt(5));
                } else {
                    TiebaApplication.f().f(MKEvent.ERROR_PERMISSION_DENIED);
                    TiebaApplication.f().m(true);
                    TiebaApplication.f().o(true);
                    TiebaApplication.f().n(true);
                    TiebaApplication.f().k(true);
                    TiebaApplication.f().l(false);
                }
                if (a2 != null) {
                    try {
                        a2.close();
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
                z.b("DatabaseService", "getDraftBox", "error = " + e2.getMessage());
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

    public static void y() {
        DatabaseService databaseService;
        if (TiebaApplication.E() != null && (databaseService = new DatabaseService()) != null) {
            try {
                databaseService.a("delete from chunk_upload_data where strftime('%s','now') - time > 48 * 3600 and account=?", (Object[]) new String[]{TiebaApplication.E()});
            } catch (Exception e) {
                z.b("DatabaseService", "delChunkUploadData", "error = " + e.getMessage());
            }
        }
    }

    public static void p(String str) {
        if (TiebaApplication.E() != null) {
            DatabaseService databaseService = new DatabaseService();
            if (str != null && databaseService != null) {
                try {
                    databaseService.a("delete from chunk_upload_data where md5=? and account=?", (Object[]) new String[]{str, TiebaApplication.E()});
                } catch (Exception e) {
                    z.b("DatabaseService", "delChunkUploadData", "error = " + e.getMessage());
                }
            }
        }
    }

    public static boolean a(com.baidu.tieba.data.d dVar) {
        if (TiebaApplication.E() == null) {
            return false;
        }
        DatabaseService databaseService = new DatabaseService();
        Date date = new Date();
        if (dVar == null || databaseService == null) {
            return false;
        }
        try {
            databaseService.a("delete from chunk_upload_data where md5=? and account=?", (Object[]) new String[]{dVar.a(), TiebaApplication.E()});
            return databaseService.a("Insert into chunk_upload_data(md5,total_length,chunk_no,account,time) values(?,?,?,?,?)", new Object[]{dVar.a(), Long.valueOf(dVar.b()), Integer.valueOf(dVar.c()), TiebaApplication.E(), Long.valueOf(date.getTime() / 1000)}).booleanValue();
        } catch (Exception e) {
            z.b("DatabaseService", "saveChunkUploadData", "error = " + e.getMessage());
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.baidu.tieba.data.d q(String str) {
        Cursor cursor;
        Cursor cursor2;
        Exception e;
        com.baidu.tieba.data.d dVar;
        Cursor cursor3;
        if (TiebaApplication.E() == null) {
            return null;
        }
        DatabaseService databaseService = new DatabaseService();
        if (databaseService != null) {
            try {
                cursor = databaseService.a("select * from chunk_upload_data where md5=? and account=? and strftime('%s','now') - time < 48 * 3600", new String[]{str, TiebaApplication.E()});
                if (cursor != null) {
                    try {
                        try {
                            if (cursor.moveToFirst()) {
                                com.baidu.tieba.data.d dVar2 = new com.baidu.tieba.data.d();
                                try {
                                    dVar2.a(str);
                                    dVar2.a(cursor.getInt(3));
                                    dVar2.a(cursor.getLong(2));
                                    dVar = dVar2;
                                } catch (Exception e2) {
                                    e = e2;
                                    dVar = dVar2;
                                    cursor2 = cursor;
                                    try {
                                        z.b("DatabaseService", "getChunkUploadDataByMd5", "error = " + e.getMessage());
                                        if (cursor2 != null) {
                                            try {
                                                cursor2.close();
                                            } catch (Exception e3) {
                                            }
                                        }
                                        return dVar;
                                    } catch (Throwable th) {
                                        th = th;
                                        cursor = cursor2;
                                        if (cursor != null) {
                                        }
                                        throw th;
                                    }
                                }
                            } else {
                                dVar = null;
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
                    } catch (Exception e5) {
                        cursor2 = cursor;
                        e = e5;
                        dVar = null;
                    }
                    try {
                        cursor.close();
                    } catch (Exception e6) {
                        e = e6;
                        cursor2 = cursor;
                        z.b("DatabaseService", "getChunkUploadDataByMd5", "error = " + e.getMessage());
                        if (cursor2 != null) {
                        }
                        return dVar;
                    }
                } else {
                    dVar = null;
                }
                cursor3 = null;
            } catch (Exception e7) {
                cursor2 = null;
                e = e7;
                dVar = null;
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
            }
        } else {
            dVar = null;
            cursor3 = null;
        }
        if (0 != 0) {
            try {
                cursor3.close();
            } catch (Exception e8) {
            }
        }
        return dVar;
    }

    public static void z() {
        synchronized (DatabaseService.class) {
            try {
                d.close();
            } catch (Exception e) {
            }
            try {
                m.h("tieba_database.db");
            } catch (Exception e2) {
            }
            d = null;
        }
    }

    public static void r(String str) {
        DatabaseService databaseService;
        if (str != null && (databaseService = new DatabaseService()) != null) {
            try {
                databaseService.a("delete from cash_data where account=?", (Object[]) new String[]{str});
                databaseService.a("delete from mark_data where account=?", (Object[]) new String[]{str});
                databaseService.a("delete from draft_box where account=?", new Object[]{str});
                databaseService.a("delete from account_data where id=?", new Object[]{str});
                databaseService.a("delete from setting where account=?", new Object[]{str});
            } catch (Exception e) {
                z.b("DatabaseService", "deleteAccountAllInfo", e.getMessage());
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
                z.b("DatabaseService", "cashHostspot", "error = " + e.getMessage());
                return false;
            }
        }
        return false;
    }

    public static String b(int i) {
        Cursor cursor;
        Exception e;
        String str;
        Cursor cursor2;
        Cursor cursor3 = null;
        DatabaseService databaseService = new DatabaseService();
        try {
            if (databaseService != null) {
                try {
                    cursor = databaseService.a("select * from cash_data where type=? ", new String[]{String.valueOf(i)});
                    if (cursor != null) {
                        try {
                            str = cursor.moveToFirst() ? cursor.getString(2) : null;
                            try {
                                cursor.close();
                            } catch (Exception e2) {
                                e = e2;
                                z.b("DatabaseService", "getHotspot", "error = " + e.getMessage());
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e3) {
                                    }
                                }
                                return str;
                            }
                        } catch (Exception e4) {
                            str = null;
                            e = e4;
                        }
                    } else {
                        str = null;
                    }
                    cursor2 = null;
                } catch (Exception e5) {
                    cursor = null;
                    e = e5;
                    str = null;
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
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void s(String str) {
        DatabaseService databaseService = new DatabaseService();
        if (databaseService != null && str != null) {
            try {
                databaseService.a("delete from frs_image_forums where forum_name=?", (Object[]) new String[]{str});
                databaseService.a("Insert into frs_image_forums(forum_name) values(?)", new Object[]{str});
            } catch (Exception e) {
                z.b("DatabaseService", "insertFrsImageForum", e.getMessage());
            }
        }
    }

    public static void t(String str) {
        DatabaseService databaseService = new DatabaseService();
        if (databaseService != null && str != null) {
            try {
                databaseService.a("delete from frs_image_forums where forum_name=?", (Object[]) new String[]{str});
            } catch (Exception e) {
                z.b("DatabaseService", "delFrsImageForum", e.getMessage());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x004a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList A() {
        Cursor cursor;
        Exception e;
        ArrayList arrayList;
        Cursor cursor2;
        DatabaseService databaseService = new DatabaseService();
        if (databaseService != null) {
            try {
                cursor = databaseService.a("select * from frs_image_forums", (String[]) null);
                if (cursor != null) {
                    try {
                        try {
                            arrayList = new ArrayList();
                            while (cursor.moveToNext()) {
                                try {
                                    arrayList.add(cursor.getString(0));
                                } catch (Exception e2) {
                                    e = e2;
                                    z.b("DatabaseService", "getAllFrsImageForums", e.getMessage());
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
                e7.printStackTrace();
            }
        }
        return arrayList;
    }
}
