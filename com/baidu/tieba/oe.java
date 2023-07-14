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
/* loaded from: classes7.dex */
public class oe extends pe<byte[]> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.pe
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.pe
    public void k(String str, String str2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048579, this, str, str2, i, i2) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oe(t9 t9Var) {
        super(t9Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((t9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.pe
    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            t9 t9Var = this.a;
            t9Var.d("DROP TABLE IF EXISTS " + this.b);
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [T, byte[]] */
    @Override // com.baidu.tieba.pe
    public te<byte[]> i(SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase, str)) == null) {
            Cursor cursor = null;
            try {
                Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT m_key, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.b + " where m_key = ?", new String[]{str});
                try {
                    if (rawQuery.moveToNext()) {
                        te<byte[]> teVar = new te<>();
                        teVar.a = rawQuery.getString(0);
                        teVar.d = rawQuery.getLong(1);
                        teVar.e = rawQuery.getLong(2);
                        teVar.f = rawQuery.getLong(3);
                        teVar.b = rawQuery.getBlob(4);
                        vg.a(rawQuery);
                        return teVar;
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
            return (te) invokeLL.objValue;
        }
    }

    @Override // com.baidu.tieba.pe
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

    @Override // com.baidu.tieba.pe
    public ContentValues p(te<byte[]> teVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, teVar)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("m_key", teVar.a);
            contentValues.put("m_value", teVar.b);
            contentValues.put("saveTime", Long.valueOf(teVar.d));
            contentValues.put("lastHitTime", Long.valueOf(teVar.e));
            contentValues.put("timeToExpire", Long.valueOf(teVar.f));
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    @Override // com.baidu.tieba.pe
    public Cursor q(SQLiteDatabase sQLiteDatabase, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, sQLiteDatabase, str)) == null) {
            return sQLiteDatabase.rawQuery("select * from " + this.b, new String[0]);
        }
        return (Cursor) invokeLL.objValue;
    }
}
