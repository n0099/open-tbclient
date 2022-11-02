package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class se extends te<byte[]> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.te
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.te
    public void k(String str, String str2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048579, this, str, str2, i, i2) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public se(y9 y9Var) {
        super(y9Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {y9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((y9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.te
    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            y9 y9Var = this.a;
            y9Var.d("DROP TABLE IF EXISTS " + this.b);
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [T, byte[]] */
    @Override // com.baidu.tieba.te
    public xe<byte[]> i(SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase, str)) == null) {
            Cursor cursor = null;
            try {
                Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT m_key, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.b + " where m_key = ?", new String[]{str});
                try {
                    if (rawQuery.moveToNext()) {
                        xe<byte[]> xeVar = new xe<>();
                        xeVar.a = rawQuery.getString(0);
                        xeVar.d = rawQuery.getLong(1);
                        xeVar.e = rawQuery.getLong(2);
                        xeVar.f = rawQuery.getLong(3);
                        xeVar.b = rawQuery.getBlob(4);
                        vg.a(rawQuery);
                        return xeVar;
                    }
                    vg.a(rawQuery);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    cursor = rawQuery;
                    vg.a(cursor);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            return (xe) invokeLL.objValue;
        }
    }

    @Override // com.baidu.tieba.te
    public String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            int hashCode = str.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            String str2 = "cache_kv_b" + hashCode;
            this.a.d("CREATE TABLE IF NOT EXISTS " + str2 + "(m_key VARCHAR(64) PRIMARY KEY, saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value blob)");
            return str2;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.te
    public ContentValues p(xe<byte[]> xeVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, xeVar)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("m_key", xeVar.a);
            contentValues.put("m_value", xeVar.b);
            contentValues.put("saveTime", Long.valueOf(xeVar.d));
            contentValues.put("lastHitTime", Long.valueOf(xeVar.e));
            contentValues.put("timeToExpire", Long.valueOf(xeVar.f));
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    @Override // com.baidu.tieba.te
    public Cursor q(SQLiteDatabase sQLiteDatabase, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, sQLiteDatabase, str)) == null) {
            return sQLiteDatabase.rawQuery("select * from " + this.b, new String[0]);
        }
        return (Cursor) invokeLL.objValue;
    }
}
