package com.baidu.tieba;

import android.util.DisplayMetrics;
import com.baidu.pass.biometrics.base.utils.SapiSystemBarTintManager;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class zs {
    public static /* synthetic */ Interceptable $ic;
    public static final DisplayMetrics a;
    public static final float b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448323988, "Lcom/baidu/tieba/zs;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448323988, "Lcom/baidu/tieba/zs;");
                return;
            }
        }
        DisplayMetrics displayMetrics = zq.c.h().getAppContext().getResources().getDisplayMetrics();
        a = displayMetrics;
        b = displayMetrics.density;
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            int identifier = zq.c.h().getAppContext().getResources().getIdentifier(SapiSystemBarTintManager.SystemBarConfig.g, EMABTest.TYPE_DIMEN, "android");
            int i = 0;
            if (identifier > 0) {
                try {
                    i = zq.c.h().getAppContext().getResources().getDimensionPixelSize(identifier);
                } catch (Exception unused) {
                }
            }
            if (i == 0) {
                return (int) (b * 25.0f);
            }
            return i;
        }
        return invokeV.intValue;
    }
}
