package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class up9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int[] SVGImageView;
    public static final int SVGImageView_css = 0;
    public static final int SVGImageView_svg = 1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948218827, "Lcom/baidu/tieba/up9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948218827, "Lcom/baidu/tieba/up9;");
                return;
            }
        }
        SVGImageView = new int[]{R.attr.obfuscated_res_0x7f0401ef, R.attr.obfuscated_res_0x7f04066d};
    }
}
