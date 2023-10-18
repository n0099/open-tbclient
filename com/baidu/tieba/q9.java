package com.baidu.tieba;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.safe.BdCloseHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class q9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final m4 a;

    public q9(Context context, m4 m4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, m4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = m4Var;
    }

    public void a(i9 i9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, i9Var) == null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("nameSpace", i9Var.a);
                contentValues.put("tableName", i9Var.b);
                contentValues.put("maxSize", Integer.valueOf(i9Var.c));
                contentValues.put("cacheVersion", Integer.valueOf(i9Var.e));
                contentValues.put("cacheType", i9Var.d);
                contentValues.put("lastActiveTime", Long.valueOf(i9Var.f));
                SQLiteDatabase f = this.a.f();
                if (f != null && f.update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{i9Var.a}) == 0) {
                    f.insert("cache_meta_info", null, contentValues);
                }
            } catch (Throwable th) {
                this.a.h(th, "addOrUpdate");
            }
        }
    }

    public i9 c(String str) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            try {
                cursor = this.a.f().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
            try {
                if (cursor.moveToNext()) {
                    i9 i9Var = new i9();
                    i9Var.a = cursor.getString(0);
                    i9Var.b = cursor.getString(1);
                    i9Var.c = cursor.getInt(2);
                    i9Var.d = cursor.getString(3);
                    i9Var.e = cursor.getInt(4);
                    i9Var.f = cursor.getLong(5);
                    return i9Var;
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    this.a.h(th, CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE);
                    return null;
                } finally {
                    BdCloseHelper.close(cursor);
                }
            }
            return null;
        }
        return (i9) invokeL.objValue;
    }

    public int b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            try {
                if (c(str) == null) {
                    return 0;
                }
                return this.a.f().delete("cache_meta_info", "nameSpace = ?", new String[]{str});
            } catch (Throwable th) {
                this.a.h(th, "delete");
                return 0;
            }
        }
        return invokeL.intValue;
    }
}
