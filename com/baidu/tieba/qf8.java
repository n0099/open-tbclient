package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class qf8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static Object a(@NonNull kf8 kf8Var, @NonNull lf8 lf8Var, @NonNull Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, kf8Var, lf8Var, obj)) == null) {
            try {
                return kf8Var.b(lf8Var, obj);
            } catch (Exception e) {
                BdLog.e(e);
                return null;
            }
        }
        return invokeLLL.objValue;
    }

    @Nullable
    public static Object b(@NonNull kf8 kf8Var, @NonNull lf8 lf8Var, @NonNull Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, kf8Var, lf8Var, obj)) == null) {
            try {
                return kf8Var.a(lf8Var, obj);
            } catch (Exception e) {
                e.printStackTrace();
                BdLog.e(e);
                return null;
            }
        }
        return invokeLLL.objValue;
    }
}
