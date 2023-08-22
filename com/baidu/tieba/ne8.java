package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public class ne8 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public static volatile SQLiteDatabase b;
    public static HashMap<String, SQLiteDatabase> c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947999688, "Lcom/baidu/tieba/ne8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947999688, "Lcom/baidu/tieba/ne8;");
                return;
            }
        }
        c = new HashMap<>();
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            try {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        oe8.d().f();
                        Iterator<String> it = b().iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            if (next != null) {
                                if (next.equals("tb_message_center")) {
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put("is_hidden", (Integer) 1);
                                    oe8.d().update("tb_message_center", contentValues, null, null);
                                } else if (!next.equals("tb_new_friends") && !next.startsWith("tb_group_chat_room_") && !next.equals("tb_chat_sys_notify")) {
                                    oe8.d().delete(next, null, null);
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    TiebaStatic.printDBExceptionLog(e, "ImDatabaseManager.deleteImDb", new Object[0]);
                    e.printStackTrace();
                }
            } finally {
                oe8.d().b();
            }
        }
    }

    public static LinkedList<String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            SQLiteDatabase c2 = c();
            LinkedList<String> linkedList = new LinkedList<>();
            Cursor cursor = null;
            try {
                if (c2 != null) {
                    try {
                        cursor = c2.rawQuery("select * from sqlite_master where type='table'", null);
                        if (cursor != null) {
                            cursor.moveToFirst();
                            while (cursor.moveToNext()) {
                                linkedList.add(cursor.getString(cursor.getColumnIndex("name")));
                            }
                        }
                    } catch (Exception e) {
                        TiebaStatic.printDBExceptionLog(e, "ImDatabaseManager.getAllTables", new Object[0]);
                        e.printStackTrace();
                    }
                }
                return linkedList;
            } finally {
                ei.a(cursor);
            }
        }
        return (LinkedList) invokeV.objValue;
    }

    public static synchronized SQLiteDatabase c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (ne8.class) {
                try {
                } catch (Exception e) {
                    TiebaStatic.printDBExceptionLog(e, "ImDatabaseHelper.getImDataBase", new Object[0]);
                }
                if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                    return null;
                }
                String str = TbadkCoreApplication.getCurrentAccount() + ".db";
                if (c.containsKey(str)) {
                    return c.get(str);
                }
                if (b != null && str.equals(a) && b.isOpen()) {
                    return b;
                }
                if (b != null) {
                    ei.b(b);
                }
                me8 me8Var = new me8(TbadkCoreApplication.getInst().getApp(), str);
                a = str;
                b = me8Var.getWritableDatabase();
                return b;
            }
        }
        return (SQLiteDatabase) invokeV.objValue;
    }
}
