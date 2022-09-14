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
/* loaded from: classes6.dex */
public class vp5 {
    public static /* synthetic */ Interceptable $ic;
    public static vp5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public vp5() {
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

    public static vp5 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (vp5.class) {
                if (a == null) {
                    a = new vp5();
                }
            }
            return a;
        }
        return (vp5) invokeV.objValue;
    }

    public boolean a(i25 i25Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, i25Var)) == null) {
            SQLiteDatabase b = xp5.b();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (b != null && i25Var != null && !TextUtils.isEmpty(currentAccount)) {
                try {
                    ContentValues c = c(i25Var);
                    if (b.update("table_" + currentAccount, c, "id = ?", new String[]{String.valueOf(i25Var.d())}) == 0) {
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

    public synchronized boolean b(qp5 qp5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qp5Var)) == null) {
            synchronized (this) {
                SQLiteDatabase b = xp5.b();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (b != null && qp5Var != null && !TextUtils.isEmpty(currentAccount)) {
                    b.execSQL("DROP TABLE IF EXISTS table_" + currentAccount);
                    b.execSQL("CREATE TABLE IF NOT EXISTS table_" + currentAccount + "(name TEXT NOT NULL UNIQUE, id LONG, name_show TEXT, portrait TEXT, quanpin TEXT, first_letter TEXT, location_hide INT, location_distance TEXT ,location_time LONG, user_type INT);");
                    b.beginTransaction();
                    try {
                        for (up5 up5Var : qp5Var.a()) {
                            for (i25 i25Var : up5Var.a()) {
                                ContentValues c = c(i25Var);
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

    public final ContentValues c(i25 i25Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, i25Var)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", i25Var.e());
            contentValues.put("id", Long.valueOf(i25Var.d()));
            contentValues.put("user_type", Integer.valueOf(i25Var.h()));
            contentValues.put("portrait", i25Var.g());
            contentValues.put("quanpin", i25Var.c());
            contentValues.put("first_letter", i25Var.a());
            contentValues.put("name_show", i25Var.f());
            if (i25Var.b() != null) {
                contentValues.put("location_hide", Integer.valueOf(i25Var.b().b()));
                contentValues.put("location_distance", i25Var.b().a());
                contentValues.put("location_time", Long.valueOf(i25Var.b().c()));
            }
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public boolean d(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
            SQLiteDatabase b = xp5.b();
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

    public synchronized List<i25> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                SQLiteDatabase b = xp5.b();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                Cursor cursor = null;
                ArrayList arrayList = new ArrayList();
                if (b != null && !TextUtils.isEmpty(currentAccount)) {
                    b.beginTransaction();
                    char c = 0;
                    try {
                        String[] strArr = k25.a;
                        int length = strArr.length;
                        int i = 0;
                        while (i < length) {
                            String str = strArr[i];
                            ArrayList arrayList2 = new ArrayList();
                            i25 i25Var = new i25();
                            i25Var.j(str);
                            arrayList2.add(i25Var);
                            String[] strArr2 = new String[1];
                            strArr2[c] = str;
                            cursor = b.rawQuery("SELECT * FROM table_" + currentAccount + " WHERE first_letter=?", strArr2);
                            if (cursor != null) {
                                while (cursor.moveToNext()) {
                                    i25 i25Var2 = new i25();
                                    i25Var2.j(str);
                                    i25Var2.n(cursor.getString(cursor.getColumnIndex("name")));
                                    i25Var2.o(cursor.getString(cursor.getColumnIndex("name_show")));
                                    i25Var2.m(cursor.getLong(cursor.getColumnIndex("id")));
                                    i25Var2.q(cursor.getInt(cursor.getColumnIndex("user_type")));
                                    i25Var2.p(cursor.getString(cursor.getColumnIndex("portrait")));
                                    i25Var2.l(cursor.getString(cursor.getColumnIndex("quanpin")));
                                    i25Var2.k(new j25(cursor.getString(cursor.getColumnIndex("location_distance")), cursor.getLong(cursor.getColumnIndex("location_time")), cursor.getInt(cursor.getColumnIndex("location_hide"))));
                                    arrayList2.add(i25Var2);
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

    public synchronized ArrayList<i25> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                SQLiteDatabase b = xp5.b();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                Cursor cursor = null;
                ArrayList<i25> arrayList = new ArrayList<>();
                if (b != null && !TextUtils.isEmpty(currentAccount)) {
                    b.beginTransaction();
                    char c = 0;
                    try {
                        String[] strArr = k25.a;
                        int length = strArr.length;
                        int i = 0;
                        while (i < length) {
                            String str = strArr[i];
                            ArrayList arrayList2 = new ArrayList();
                            i25 i25Var = new i25();
                            i25Var.j(str);
                            arrayList2.add(i25Var);
                            String[] strArr2 = new String[2];
                            strArr2[c] = str;
                            strArr2[1] = "1";
                            cursor = b.rawQuery("SELECT * FROM table_" + currentAccount + " WHERE first_letter = ? AND user_type = ? ", strArr2);
                            if (cursor != null) {
                                while (cursor.moveToNext()) {
                                    i25 i25Var2 = new i25();
                                    i25Var2.j(str);
                                    i25Var2.n(cursor.getString(cursor.getColumnIndex("name")));
                                    i25Var2.o(cursor.getString(cursor.getColumnIndex("name_show")));
                                    i25Var2.m(cursor.getLong(cursor.getColumnIndex("id")));
                                    i25Var2.q(cursor.getInt(cursor.getColumnIndex("user_type")));
                                    i25Var2.p(cursor.getString(cursor.getColumnIndex("portrait")));
                                    i25Var2.l(cursor.getString(cursor.getColumnIndex("quanpin")));
                                    i25Var2.k(new j25(cursor.getString(cursor.getColumnIndex("location_distance")), cursor.getLong(cursor.getColumnIndex("location_time")), cursor.getInt(cursor.getColumnIndex("location_hide"))));
                                    arrayList2.add(i25Var2);
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
