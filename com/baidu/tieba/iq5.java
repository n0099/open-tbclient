package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class iq5 {
    public static /* synthetic */ Interceptable $ic;
    public static iq5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public iq5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static iq5 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (iq5.class) {
                if (a == null) {
                    a = new iq5();
                }
            }
            return a;
        }
        return (iq5) invokeV.objValue;
    }

    public boolean a(v25 v25Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, v25Var)) == null) {
            SQLiteDatabase b = kq5.b();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (b != null && v25Var != null && !TextUtils.isEmpty(currentAccount)) {
                try {
                    ContentValues c = c(v25Var);
                    if (b.update("table_" + currentAccount, c, "id = ?", new String[]{String.valueOf(v25Var.d())}) == 0) {
                        b.insert("table_" + currentAccount, null, c);
                    }
                    return true;
                } catch (Exception e) {
                    TiebaStatic.printDBExceptionLog(e, "RelationshipDao.addContactItem", new Object[0]);
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public synchronized boolean b(dq5 dq5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dq5Var)) == null) {
            synchronized (this) {
                SQLiteDatabase b = kq5.b();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (b != null && dq5Var != null && !TextUtils.isEmpty(currentAccount)) {
                    b.execSQL("DROP TABLE IF EXISTS table_" + currentAccount);
                    b.execSQL("CREATE TABLE IF NOT EXISTS table_" + currentAccount + "(name TEXT NOT NULL UNIQUE, id LONG, name_show TEXT, portrait TEXT, quanpin TEXT, first_letter TEXT, location_hide INT, location_distance TEXT ,location_time LONG, user_type INT);");
                    b.beginTransaction();
                    try {
                        for (hq5 hq5Var : dq5Var.a()) {
                            for (v25 v25Var : hq5Var.a()) {
                                ContentValues c = c(v25Var);
                                b.insert("table_" + currentAccount, null, c);
                            }
                        }
                        b.setTransactionSuccessful();
                        b.endTransaction();
                        return true;
                    } catch (Exception e) {
                        BdLog.e(e.toString());
                        TiebaStatic.printDBExceptionLog(e, "RelationshipDao.addContactItems", new Object[0]);
                        b.endTransaction();
                        return false;
                    }
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final ContentValues c(v25 v25Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, v25Var)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", v25Var.e());
            contentValues.put("id", Long.valueOf(v25Var.d()));
            contentValues.put("user_type", Integer.valueOf(v25Var.h()));
            contentValues.put("portrait", v25Var.g());
            contentValues.put("quanpin", v25Var.c());
            contentValues.put("first_letter", v25Var.a());
            contentValues.put("name_show", v25Var.f());
            if (v25Var.b() != null) {
                contentValues.put("location_hide", Integer.valueOf(v25Var.b().b()));
                contentValues.put("location_distance", v25Var.b().a());
                contentValues.put("location_time", Long.valueOf(v25Var.b().c()));
            }
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public boolean d(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
            SQLiteDatabase b = kq5.b();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (b != null && j >= 0 && !TextUtils.isEmpty(currentAccount)) {
                try {
                    b.delete("table_" + currentAccount, "id = ?", new String[]{String.valueOf(j)});
                    return true;
                } catch (Exception e) {
                    TiebaStatic.printDBExceptionLog(e, "RelationshipDao.deleteContactItem", new Object[0]);
                }
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    public synchronized List<v25> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                SQLiteDatabase b = kq5.b();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                Cursor cursor = null;
                ArrayList arrayList = new ArrayList();
                if (b != null && !TextUtils.isEmpty(currentAccount)) {
                    b.beginTransaction();
                    char c = 0;
                    try {
                        String[] strArr = x25.a;
                        int length = strArr.length;
                        int i = 0;
                        while (i < length) {
                            String str = strArr[i];
                            ArrayList arrayList2 = new ArrayList();
                            v25 v25Var = new v25();
                            v25Var.j(str);
                            arrayList2.add(v25Var);
                            String[] strArr2 = new String[1];
                            strArr2[c] = str;
                            cursor = b.rawQuery("SELECT * FROM table_" + currentAccount + " WHERE first_letter=?", strArr2);
                            if (cursor != null) {
                                while (cursor.moveToNext()) {
                                    v25 v25Var2 = new v25();
                                    v25Var2.j(str);
                                    v25Var2.n(cursor.getString(cursor.getColumnIndex("name")));
                                    v25Var2.o(cursor.getString(cursor.getColumnIndex("name_show")));
                                    v25Var2.m(cursor.getLong(cursor.getColumnIndex("id")));
                                    v25Var2.q(cursor.getInt(cursor.getColumnIndex("user_type")));
                                    v25Var2.p(cursor.getString(cursor.getColumnIndex("portrait")));
                                    v25Var2.l(cursor.getString(cursor.getColumnIndex("quanpin")));
                                    v25Var2.k(new w25(cursor.getString(cursor.getColumnIndex("location_distance")), cursor.getLong(cursor.getColumnIndex("location_time")), cursor.getInt(cursor.getColumnIndex("location_hide"))));
                                    arrayList2.add(v25Var2);
                                }
                            }
                            if (arrayList2.size() > 1) {
                                arrayList.addAll(arrayList2);
                            }
                            fj.a(cursor);
                            i++;
                            c = 0;
                        }
                        b.setTransactionSuccessful();
                        fj.a(cursor);
                    } catch (Exception e) {
                        BdLog.e(e.toString());
                        TiebaStatic.printDBExceptionLog(e, "RelationshipDao.getContactList", new Object[0]);
                        fj.a(cursor);
                    }
                    b.endTransaction();
                    return arrayList;
                }
                return arrayList;
            }
        }
        return (List) invokeV.objValue;
    }

    public synchronized ArrayList<v25> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                SQLiteDatabase b = kq5.b();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                Cursor cursor = null;
                ArrayList<v25> arrayList = new ArrayList<>();
                if (b != null && !TextUtils.isEmpty(currentAccount)) {
                    b.beginTransaction();
                    char c = 0;
                    try {
                        String[] strArr = x25.a;
                        int length = strArr.length;
                        int i = 0;
                        while (i < length) {
                            String str = strArr[i];
                            ArrayList arrayList2 = new ArrayList();
                            v25 v25Var = new v25();
                            v25Var.j(str);
                            arrayList2.add(v25Var);
                            String[] strArr2 = new String[2];
                            strArr2[c] = str;
                            strArr2[1] = "1";
                            cursor = b.rawQuery("SELECT * FROM table_" + currentAccount + " WHERE first_letter = ? AND user_type = ? ", strArr2);
                            if (cursor != null) {
                                while (cursor.moveToNext()) {
                                    v25 v25Var2 = new v25();
                                    v25Var2.j(str);
                                    v25Var2.n(cursor.getString(cursor.getColumnIndex("name")));
                                    v25Var2.o(cursor.getString(cursor.getColumnIndex("name_show")));
                                    v25Var2.m(cursor.getLong(cursor.getColumnIndex("id")));
                                    v25Var2.q(cursor.getInt(cursor.getColumnIndex("user_type")));
                                    v25Var2.p(cursor.getString(cursor.getColumnIndex("portrait")));
                                    v25Var2.l(cursor.getString(cursor.getColumnIndex("quanpin")));
                                    v25Var2.k(new w25(cursor.getString(cursor.getColumnIndex("location_distance")), cursor.getLong(cursor.getColumnIndex("location_time")), cursor.getInt(cursor.getColumnIndex("location_hide"))));
                                    arrayList2.add(v25Var2);
                                }
                            }
                            if (arrayList2.size() > 1) {
                                arrayList.addAll(arrayList2);
                            }
                            fj.a(cursor);
                            i++;
                            c = 0;
                        }
                        b.setTransactionSuccessful();
                        fj.a(cursor);
                    } catch (Exception e) {
                        BdLog.e(e.toString());
                        TiebaStatic.printDBExceptionLog(e, "RelationshipDao.getOfficialAccountList", new Object[0]);
                        fj.a(cursor);
                    }
                    b.endTransaction();
                    return arrayList;
                }
                return arrayList;
            }
        }
        return (ArrayList) invokeV.objValue;
    }
}
