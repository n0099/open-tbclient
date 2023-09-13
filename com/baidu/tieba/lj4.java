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
/* loaded from: classes6.dex */
public class lj4 extends hj4<gk4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public lj4() {
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
    @Override // com.baidu.tieba.hj4
    /* renamed from: f */
    public ContentValues c(gk4 gk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, gk4Var)) == null) {
            ContentValues a = super.a(gk4Var);
            a.put("pkg_type", Integer.valueOf(gk4Var.o));
            return a;
        }
        return (ContentValues) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.hj4
    /* renamed from: g */
    public gk4 d(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cursor)) == null) {
            if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                gk4 gk4Var = new gk4();
                if (b(cursor, gk4Var)) {
                    return gk4Var;
                }
                return null;
            }
            return null;
        }
        return (gk4) invokeL.objValue;
    }

    @Override // com.baidu.tieba.hj4
    public List<gk4> e(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cursor)) == null) {
            ArrayList arrayList = new ArrayList();
            if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                do {
                    gk4 gk4Var = new gk4();
                    if (b(cursor, gk4Var)) {
                        arrayList.add(gk4Var);
                    }
                } while (cursor.moveToNext());
                return arrayList;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
