package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public final class vf1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int[] ValidationWebView;
    public static final int ValidationWebView_bottom_left = 0;
    public static final int ValidationWebView_bottom_right = 1;
    public static final int ValidationWebView_top_left = 2;
    public static final int ValidationWebView_top_right = 3;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948238760, "Lcom/baidu/tieba/vf1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948238760, "Lcom/baidu/tieba/vf1;");
                return;
            }
        }
        ValidationWebView = new int[]{R.attr.bottom_left, R.attr.bottom_right, R.attr.top_left, R.attr.top_right};
    }
}
