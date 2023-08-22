package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.lib.safe.BdCloseHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class se extends ee<String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String h;

    @Override // com.baidu.tieba.ee
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ee
    public void k(String str, String str2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048579, this, str, str2, i, i2) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public se(n9 n9Var, String str) {
        super(n9Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {n9Var, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((n9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = str;
    }

    @Override // com.baidu.tieba.ee
    public Cursor q(SQLiteDatabase sQLiteDatabase, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, sQLiteDatabase, str)) == null) {
            return sQLiteDatabase.rawQuery("select * from " + this.b + " where m_ns = ?", new String[]{str});
        }
        return (Cursor) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.ee
    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                this.a.f().delete(this.b, "m_ns = ?", new String[]{str});
                return true;
            } catch (Throwable th) {
                this.a.h(th, "clearData");
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Type inference failed for: r0v14, types: [T, java.lang.String] */
    @Override // com.baidu.tieba.ee
    public ie<String> i(SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase, str)) == null) {
            Cursor cursor = null;
            try {
                Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT m_key, m_ns, saveTime, lastHitTime, timeToExpire, m_value  FROM " + this.b + " where m_key = ?", new String[]{str});
                try {
                    if (rawQuery.moveToNext()) {
                        ie<String> ieVar = new ie<>();
                        ieVar.a = rawQuery.getString(0);
                        ieVar.c = rawQuery.getString(1);
                        ieVar.d = rawQuery.getLong(2);
                        ieVar.e = rawQuery.getLong(3);
                        ieVar.f = rawQuery.getLong(4);
                        ieVar.b = rawQuery.getString(5);
                        BdCloseHelper.close(rawQuery);
                        return ieVar;
                    }
                    BdCloseHelper.close(rawQuery);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    cursor = rawQuery;
                    BdCloseHelper.close(cursor);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            return (ie) invokeLL.objValue;
        }
    }

    @Override // com.baidu.tieba.ee
    public String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            this.a.d("CREATE TABLE IF NOT EXISTS " + this.h + "(m_key VARCHAR(64) PRIMARY KEY, m_ns varchar(128), saveTime bigint(21) default 0, lastHitTime bigint(21) default 0, timeToExpire bigint(21) default 0, m_value text)");
            this.a.d("CREATE INDEX if not exists idx_mi_ns ON " + this.h + "(m_ns)");
            return this.h;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ee
    public ContentValues p(ie<String> ieVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ieVar)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("m_key", ieVar.a);
            contentValues.put("m_ns", ieVar.c);
            contentValues.put("m_value", ieVar.b);
            contentValues.put("saveTime", Long.valueOf(ieVar.d));
            contentValues.put("lastHitTime", Long.valueOf(ieVar.e));
            contentValues.put("timeToExpire", Long.valueOf(ieVar.f));
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }
}
