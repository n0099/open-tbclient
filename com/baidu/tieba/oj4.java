package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.utils.AbiType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class oj4 extends hj4<jk4> implements Object {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public oj4() {
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

    public static int f(@NonNull Cursor cursor, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, cursor, str)) == null) {
            return cursor.getColumnIndex(str);
        }
        return invokeLL.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.hj4
    /* renamed from: h */
    public jk4 d(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cursor)) == null) {
            if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                return i(cursor);
            }
            return null;
        }
        return (jk4) invokeL.objValue;
    }

    @Override // com.baidu.tieba.hj4
    public List<jk4> e(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cursor)) == null) {
            ArrayList arrayList = new ArrayList();
            if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                do {
                    arrayList.add(i(cursor));
                } while (cursor.moveToNext());
                return arrayList;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.hj4
    /* renamed from: g */
    public ContentValues c(jk4 jk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jk4Var)) == null) {
            ContentValues a = super.a(jk4Var);
            a.put("max_age", Long.valueOf(jk4Var.o));
            a.put("abi", jk4Var.q.id);
            a.put("lib_name", jk4Var.p);
            return a;
        }
        return (ContentValues) invokeL.objValue;
    }

    public final jk4 i(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cursor)) == null) {
            if (cursor != null) {
                jk4 jk4Var = new jk4();
                if (b(cursor, jk4Var)) {
                    jk4Var.o = cursor.getLong(f(cursor, "max_age"));
                    jk4Var.q = AbiType.findById(cursor.getString(f(cursor, "abi")), null);
                    jk4Var.p = cursor.getString(f(cursor, "lib_name"));
                    return jk4Var;
                }
            }
            return null;
        }
        return (jk4) invokeL.objValue;
    }
}
