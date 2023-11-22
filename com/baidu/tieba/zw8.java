package com.baidu.tieba;

import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes9.dex */
public final class zw8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948374478, "Lcom/baidu/tieba/zw8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948374478, "Lcom/baidu/tieba/zw8;");
        }
    }

    @JvmStatic
    public static final void a(MultiImageView multiImageView, ArrayList<String> data, boolean z, boolean z2, Function0<Unit> function0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{multiImageView, data, Boolean.valueOf(z), Boolean.valueOf(z2), function0}) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            if (z && z2) {
                if (multiImageView != null) {
                    multiImageView.setUrlData(data);
                }
                if (function0 != null) {
                    function0.invoke();
                }
            }
        }
    }
}
