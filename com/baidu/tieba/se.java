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
public class se {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final o9 a;

    public se(Context context, o9 o9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, o9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = o9Var;
    }

    public void a(ke keVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, keVar) == null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("nameSpace", keVar.a);
                contentValues.put("tableName", keVar.b);
                contentValues.put("maxSize", Integer.valueOf(keVar.c));
                contentValues.put("cacheVersion", Integer.valueOf(keVar.e));
                contentValues.put("cacheType", keVar.d);
                contentValues.put("lastActiveTime", Long.valueOf(keVar.f));
                SQLiteDatabase f = this.a.f();
                if (f != null && f.update("cache_meta_info", contentValues, "nameSpace = ?", new String[]{keVar.a}) == 0) {
                    f.insert("cache_meta_info", null, contentValues);
                }
            } catch (Throwable th) {
                this.a.h(th, "addOrUpdate");
            }
        }
    }

    public ke b(String str) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            try {
                cursor = this.a.f().rawQuery("SELECT nameSpace, tableName, maxSize, cacheType, cacheVersion, lastActiveTime FROM cache_meta_info where nameSpace = ?", new String[]{str});
            } catch (Throwable th) {
                th = th;
                cursor = null;
            }
            try {
                if (cursor.moveToNext()) {
                    ke keVar = new ke();
                    keVar.a = cursor.getString(0);
                    keVar.b = cursor.getString(1);
                    keVar.c = cursor.getInt(2);
                    keVar.d = cursor.getString(3);
                    keVar.e = cursor.getInt(4);
                    keVar.f = cursor.getLong(5);
                    return keVar;
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
        return (ke) invokeL.objValue;
    }

    public int delete(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            try {
                if (b(str) == null) {
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
