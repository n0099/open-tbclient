package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class pc4 extends jc4<kd4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public pc4() {
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
    @Override // com.baidu.tieba.jc4
    /* renamed from: g */
    public kd4 d(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cursor)) == null) {
            if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                return h(cursor);
            }
            return null;
        }
        return (kd4) invokeL.objValue;
    }

    @Override // com.baidu.tieba.jc4
    public List<kd4> e(Cursor cursor) {
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
    @Override // com.baidu.tieba.jc4
    /* renamed from: f */
    public ContentValues c(kd4 kd4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, kd4Var)) == null) {
            ContentValues a = super.a(kd4Var);
            a.put("max_age", Long.valueOf(kd4Var.o));
            a.put("token", kd4Var.p);
            a.put("domains", kd4Var.q);
            a.put("app_key", kd4Var.r);
            a.put("app_name", kd4Var.s);
            return a;
        }
        return (ContentValues) invokeL.objValue;
    }

    public final kd4 h(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cursor)) == null) {
            if (cursor != null) {
                int columnIndex = cursor.getColumnIndex("max_age");
                int columnIndex2 = cursor.getColumnIndex("token");
                int columnIndex3 = cursor.getColumnIndex("domains");
                int columnIndex4 = cursor.getColumnIndex("app_key");
                int columnIndex5 = cursor.getColumnIndex("app_name");
                kd4 kd4Var = new kd4();
                if (b(cursor, kd4Var)) {
                    kd4Var.o = cursor.getLong(columnIndex);
                    kd4Var.p = cursor.getString(columnIndex2);
                    kd4Var.q = cursor.getString(columnIndex3);
                    kd4Var.r = cursor.getString(columnIndex4);
                    kd4Var.s = cursor.getString(columnIndex5);
                    return kd4Var;
                }
                return null;
            }
            return null;
        }
        return (kd4) invokeL.objValue;
    }
}
