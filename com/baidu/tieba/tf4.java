package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Arrays;
import java.util.HashSet;
/* loaded from: classes6.dex */
public final class tf4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    @SuppressLint({"LambdaLast"})
    public static Bundle a(@NonNull qf4 qf4Var, @Nullable Bundle bundle, String... strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, qf4Var, bundle, strArr)) == null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            if (bundle.getLong("timestamp", -1L) < 0) {
                bundle.putLong("timestamp", System.currentTimeMillis());
            }
            return qf4Var.m(bundle, new HashSet(Arrays.asList(strArr)));
        }
        return (Bundle) invokeLLL.objValue;
    }

    @NonNull
    @SuppressLint({"LambdaLast"})
    public static Bundle b(@NonNull qf4 qf4Var, @NonNull String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, qf4Var, strArr)) == null) {
            return a(qf4Var, null, strArr);
        }
        return (Bundle) invokeLL.objValue;
    }
}
