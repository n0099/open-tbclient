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
/* loaded from: classes6.dex */
public final class zd9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SQLiteDatabase a;

    public zd9() {
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
        this.a = yd9.a().c();
    }

    public final List<com.baidu.ubs.analytics.a.i> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Cursor rawQuery = this.a.rawQuery("SELECT * FROM tb_ab_netlog order by _id ", null);
            ArrayList arrayList = new ArrayList();
            while (rawQuery.moveToNext()) {
                com.baidu.ubs.analytics.a.i iVar = new com.baidu.ubs.analytics.a.i();
                iVar.setUrl(rawQuery.getString(rawQuery.getColumnIndex("_url")));
                iVar.setType(rawQuery.getString(rawQuery.getColumnIndex("_type")));
                iVar.u(rawQuery.getString(rawQuery.getColumnIndex("_timeStamp")));
                iVar.setParameters(rawQuery.getString(rawQuery.getColumnIndex("_parameters")));
                iVar.x(rawQuery.getString(rawQuery.getColumnIndex("_sessionId")));
                iVar.setId(rawQuery.getInt(rawQuery.getColumnIndex("_id")));
                arrayList.add(iVar);
            }
            rawQuery.close();
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.a.execSQL("delete from tb_ab_netlog where _id <= " + i);
        }
    }
}
