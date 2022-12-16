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
/* loaded from: classes6.dex */
public class se extends ue<byte[]> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String h;

    @Override // com.baidu.tieba.ue
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ue
    public void k(String str, String str2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048579, this, str, str2, i, i2) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public se(z9 z9Var, String str) {
        super(z9Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {z9Var, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((z9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = str;
    }

    @Override // com.baidu.tieba.ue
    public Cursor q(SQLiteDatabase sQLiteDatabase, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, sQLiteDatabase, str)) == null) {
            return sQLiteDatabase.rawQuery("select * from " + this.b + " where m_ns = ?", new String[]{str});
        }
        return (Cursor) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.ue
    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                this.a.f().delete(this.b, "m_ns = ?", new String[]{str});
                return true;
            } catch (Throwable th) {
                z9 z9Var = this.a;
                z9Var.i(th, "failed to clear from " + str);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Type inference failed for: r0v14, types: [byte[], T] */
    @Override // com.baidu.tieba.ue
    public ye<byte[]> i(SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase, str)) == null) {
            Cursor cursor = null;
            try {
                Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT m_key, m_ns, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.b + " where m_key = ?", new String[]{str});
                try {
                    if (rawQuery.moveToNext()) {
                        ye<byte[]> yeVar = new ye<>();
                        yeVar.a = rawQuery.getString(0);
                        yeVar.c = rawQuery.getString(1);
                        yeVar.d = rawQuery.getLong(2);
                        yeVar.e = rawQuery.getLong(3);
                        yeVar.f = rawQuery.getLong(4);
                        yeVar.b = rawQuery.getBlob(5);
                        wg.a(rawQuery);
                        return yeVar;
                    }
                    wg.a(rawQuery);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    cursor = rawQuery;
                    wg.a(cursor);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            return (ye) invokeLL.objValue;
        }
    }

    @Override // com.baidu.tieba.ue
    public String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            this.a.d("CREATE TABLE IF NOT EXISTS " + this.h + "(m_key VARCHAR(64) PRIMARY KEY, m_ns varchar(128), saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value blob)");
            this.a.d("CREATE INDEX if not exists idx_mi_ns ON " + this.h + "(m_ns)");
            return this.h;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ue
    public ContentValues p(ye<byte[]> yeVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, yeVar)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("m_key", yeVar.a);
            contentValues.put("m_ns", yeVar.c);
            contentValues.put("m_value", yeVar.b);
            contentValues.put("saveTime", Long.valueOf(yeVar.d));
            contentValues.put("lastHitTime", Long.valueOf(yeVar.e));
            contentValues.put("timeToExpire", Long.valueOf(yeVar.f));
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }
}
