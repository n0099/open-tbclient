package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class jg8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static Object a(@NonNull dg8 dg8Var, @NonNull eg8 eg8Var, @NonNull Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, dg8Var, eg8Var, obj)) == null) {
            try {
                return dg8Var.b(eg8Var, obj);
            } catch (Exception e) {
                BdLog.e(e);
                return null;
            }
        }
        return invokeLLL.objValue;
    }

    @Nullable
    public static Object b(@NonNull dg8 dg8Var, @NonNull eg8 eg8Var, @NonNull Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, dg8Var, eg8Var, obj)) == null) {
            try {
                return dg8Var.a(eg8Var, obj);
            } catch (Exception e) {
                e.printStackTrace();
                BdLog.e(e);
                return null;
            }
        }
        return invokeLLL.objValue;
    }
}
