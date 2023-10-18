package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public interface m77 extends l77 {
    String c(v27 v27Var);

    /* loaded from: classes7.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static String b(m77 m77Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, m77Var)) == null) ? "" : (String) invokeL.objValue;
        }

        public static Map<String, String> a(m77 m77Var, v27 businessInfo) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, m77Var, businessInfo)) == null) {
                Intrinsics.checkNotNullParameter(businessInfo, "businessInfo");
                return new HashMap();
            }
            return (Map) invokeLL.objValue;
        }
    }
}
