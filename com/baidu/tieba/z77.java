package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes9.dex */
public final class z77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final y77 a(q57 q57Var, Map<String, String> businessInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, q57Var, businessInfo)) == null) {
            Intrinsics.checkNotNullParameter(businessInfo, "businessInfo");
            try {
                String str = businessInfo.get("forum_id");
                nd7.b(str, null, 1, null);
                String str2 = businessInfo.get("thread_id");
                nd7.b(str2, null, 1, null);
                y77 y77Var = new y77(str, str2);
                y77Var.d(q57Var);
                return y77Var;
            } catch (Exception unused) {
                return null;
            }
        }
        return (y77) invokeLL.objValue;
    }
}
