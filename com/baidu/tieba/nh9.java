package com.baidu.tieba;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public final class nh9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SQLiteDatabase a;

    public nh9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ih9.a().c();
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.a.execSQL("delete from tb_ab_sessionlog where not ( _sessionId = ? )", new String[]{str});
        }
    }

    public final boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            Cursor rawQuery = this.a.rawQuery("select * from tb_ab_sessionlog where _sessionId = ? ", new String[]{str});
            int count = rawQuery.getCount();
            rawQuery.close();
            if (count > 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void d(com.baidu.ubs.analytics.a.n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, nVar) == null) {
            this.a.execSQL("INSERT INTO tb_ab_sessionlog(_startTime,_keepTime,_endTime,_sessionId) VALUES (?,?,?,?);", new String[]{nVar.N(), nVar.P(), nVar.O(), nVar.I()});
        }
    }

    public final void e(com.baidu.ubs.analytics.a.n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, nVar) == null) {
            this.a.execSQL("UPDATE tb_ab_sessionlog SET _keepTime= ? , _endTime = ? WHERE _sessionId= ?", new String[]{nVar.P(), nVar.O(), nVar.I()});
        }
    }

    public final List<com.baidu.ubs.analytics.a.n> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Cursor rawQuery = this.a.rawQuery("SELECT * FROM  tb_ab_sessionlog", null);
            ArrayList arrayList = new ArrayList();
            while (rawQuery.moveToNext()) {
                com.baidu.ubs.analytics.a.n nVar = new com.baidu.ubs.analytics.a.n();
                nVar.x(rawQuery.getString(rawQuery.getColumnIndex("_sessionId")));
                nVar.setStartTime(rawQuery.getString(rawQuery.getColumnIndex("_startTime")));
                nVar.A(rawQuery.getString(rawQuery.getColumnIndex("_keepTime")));
                nVar.z(rawQuery.getString(rawQuery.getColumnIndex("_endTime")));
                arrayList.add(nVar);
            }
            rawQuery.close();
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}
