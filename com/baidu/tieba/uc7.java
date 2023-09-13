package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public interface uc7 extends tc7 {
    String c(f87 f87Var);

    /* loaded from: classes8.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static String b(uc7 uc7Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, uc7Var)) == null) ? "" : (String) invokeL.objValue;
        }

        public static Map<String, String> a(uc7 uc7Var, f87 businessInfo) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, uc7Var, businessInfo)) == null) {
                Intrinsics.checkNotNullParameter(businessInfo, "businessInfo");
                return new HashMap();
            }
            return (Map) invokeLL.objValue;
        }
    }
}
