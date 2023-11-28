package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class v77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final u77 a(m57 m57Var, Map<String, String> businessInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, m57Var, businessInfo)) == null) {
            Intrinsics.checkNotNullParameter(businessInfo, "businessInfo");
            try {
                String str = businessInfo.get("forum_id");
                jd7.b(str, null, 1, null);
                String str2 = businessInfo.get("thread_id");
                jd7.b(str2, null, 1, null);
                u77 u77Var = new u77(str, str2);
                u77Var.d(m57Var);
                return u77Var;
            } catch (Exception unused) {
                return null;
            }
        }
        return (u77) invokeLL.objValue;
    }
}
