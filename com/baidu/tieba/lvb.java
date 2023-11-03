package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public final class lvb {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int[] SVGImageView;
    public static final int SVGImageView_css = 0;
    public static final int SVGImageView_svg = 1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947957745, "Lcom/baidu/tieba/lvb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947957745, "Lcom/baidu/tieba/lvb;");
                return;
            }
        }
        SVGImageView = new int[]{R.attr.obfuscated_res_0x7f040206, R.attr.obfuscated_res_0x7f0406de};
    }
}
