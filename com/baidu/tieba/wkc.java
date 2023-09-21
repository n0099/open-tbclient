package com.baidu.tieba;

import android.graphics.Color;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
/* loaded from: classes8.dex */
public final class wkc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948274906, "Lcom/baidu/tieba/wkc;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948274906, "Lcom/baidu/tieba/wkc;");
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? c(str, 0, 2, null) : invokeL.intValue;
    }

    @JvmStatic
    @JvmOverloads
    public static final int b(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            try {
                return Color.parseColor(str);
            } catch (Exception e) {
                RLog.error("ColorUtil", e.getLocalizedMessage(), new Object[0]);
                return i;
            }
        }
        return invokeLI.intValue;
    }

    public static /* synthetic */ int c(String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -16777216;
        }
        return b(str, i);
    }
}
