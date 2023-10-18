package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class vd4 extends pd4<qe4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public vd4() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pd4
    /* renamed from: g */
    public qe4 d(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cursor)) == null) {
            if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                return h(cursor);
            }
            return null;
        }
        return (qe4) invokeL.objValue;
    }

    @Override // com.baidu.tieba.pd4
    public List<qe4> e(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cursor)) == null) {
            ArrayList arrayList = new ArrayList();
            if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                do {
                    arrayList.add(h(cursor));
                } while (cursor.moveToNext());
                return arrayList;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pd4
    /* renamed from: f */
    public ContentValues c(qe4 qe4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, qe4Var)) == null) {
            ContentValues a = super.a(qe4Var);
            a.put("max_age", Long.valueOf(qe4Var.o));
            a.put("token", qe4Var.p);
            a.put("domains", qe4Var.q);
            a.put(GameGuideConfigInfo.KEY_APP_KEY, qe4Var.r);
            a.put("app_name", qe4Var.s);
            return a;
        }
        return (ContentValues) invokeL.objValue;
    }

    public final qe4 h(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cursor)) == null) {
            if (cursor != null) {
                int columnIndex = cursor.getColumnIndex("max_age");
                int columnIndex2 = cursor.getColumnIndex("token");
                int columnIndex3 = cursor.getColumnIndex("domains");
                int columnIndex4 = cursor.getColumnIndex(GameGuideConfigInfo.KEY_APP_KEY);
                int columnIndex5 = cursor.getColumnIndex("app_name");
                qe4 qe4Var = new qe4();
                if (b(cursor, qe4Var)) {
                    qe4Var.o = cursor.getLong(columnIndex);
                    qe4Var.p = cursor.getString(columnIndex2);
                    qe4Var.q = cursor.getString(columnIndex3);
                    qe4Var.r = cursor.getString(columnIndex4);
                    qe4Var.s = cursor.getString(columnIndex5);
                    return qe4Var;
                }
                return null;
            }
            return null;
        }
        return (qe4) invokeL.objValue;
    }
}
