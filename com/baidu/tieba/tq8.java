package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.log.Logger;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class tq8 {
    public static /* synthetic */ Interceptable $ic;
    public static tq8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public tq8() {
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

    public static tq8 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (tq8.class) {
                    if (a == null) {
                        a = new tq8();
                    }
                }
            }
            return a;
        }
        return (tq8) invokeV.objValue;
    }

    public SQLiteStatement a(String str) {
        InterceptResult invokeL;
        SQLiteDatabase c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (c = sq8.c()) == null) {
                return null;
            }
            try {
                return c.compileStatement(str);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return (SQLiteStatement) invokeL.objValue;
    }

    public boolean b(String str, String str2, String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, strArr)) == null) {
            SQLiteDatabase c = sq8.c();
            if (c == null || TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                if (c.delete(str, str2, strArr) <= 0) {
                    return false;
                }
                return true;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public void c() {
        SQLiteDatabase c;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (c = sq8.c()) == null) {
            return;
        }
        BdLog.i("begin commit transaction");
        if (c.inTransaction()) {
            try {
                c.setTransactionSuccessful();
                c.endTransaction();
                return;
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "endTransaction", new Object[0]);
                BdLog.e(e.getMessage());
                Logger.addLog("im", -1L, 0, "im_check: endTransaction error:" + e.getMessage(), -1, "", new Object[0]);
                return;
            }
        }
        BdLog.e("there is no current transaction");
    }

    public void h() {
        SQLiteDatabase c;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || (c = sq8.c()) == null) {
            return;
        }
        if (c.inTransaction()) {
            BdLog.e("there is exist transaction");
            return;
        }
        try {
            c.beginTransaction();
            BdLog.i("db.beginTransaction");
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "startTransaction", new Object[0]);
            BdLog.e(e.getMessage());
            Logger.addLog("im", -1L, 0, "im_check: startTransaction error:" + e.getMessage(), -1, "", new Object[0]);
        }
    }

    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            SQLiteDatabase c = sq8.c();
            if (c == null) {
                return false;
            }
            try {
                c.execSQL(str);
                return true;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                Logger.addLog("im", -1L, 0, "im_check: execSQL error:" + e.getMessage(), -1, "", new Object[0]);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public long f(String str, String str2, ContentValues contentValues) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, str, str2, contentValues)) == null) {
            SQLiteDatabase c = sq8.c();
            if (c == null || TextUtils.isEmpty(str)) {
                return -1L;
            }
            try {
                return c.insert(str, str2, contentValues);
            } catch (Exception e) {
                Logger.addLog("im", -1L, 0, "im_check: insertOrUpdate error:" + e.getMessage(), -1, "", new Object[0]);
                BdLog.e(e.getMessage());
                return -1L;
            }
        }
        return invokeLLL.longValue;
    }

    public Cursor g(String str, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, strArr)) == null) {
            SQLiteDatabase c = sq8.c();
            if (c == null) {
                return null;
            }
            try {
                return c.rawQuery(str, strArr);
            } catch (Exception e) {
                BdLog.e(e.getMessage() + str);
                return null;
            }
        }
        return (Cursor) invokeLL.objValue;
    }

    public int i(String str, ContentValues contentValues, String str2, String[] strArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, str, contentValues, str2, strArr)) == null) {
            SQLiteDatabase c = sq8.c();
            if (c == null || TextUtils.isEmpty(str)) {
                return -1;
            }
            try {
                return c.update(str, contentValues, str2, strArr);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                Logger.addLog("im", -1L, 0, "im_check: update error" + e.getMessage(), -1, "", new Object[0]);
                return -1;
            }
        }
        return invokeLLLL.intValue;
    }
}
