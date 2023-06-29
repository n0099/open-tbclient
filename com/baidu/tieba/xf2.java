package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.tieba.yu2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes8.dex */
public class xf2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948298373, "Lcom/baidu/tieba/xf2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948298373, "Lcom/baidu/tieba/xf2;");
                return;
            }
        }
        boolean z = ms1.a;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return b(bc3.K().q().W().e0());
        }
        return invokeV.booleanValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            jv2.g0().getSwitch("swan_app_precreate_video_switch_v2", false);
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                str = px2.T().g();
            }
            String f = up3.f(str);
            boolean z = px2.T().e(f, px2.T().s(), yu2.e.i(bc3.K().getAppId(), bc3.K().q().W().v1()).getPath() + File.separator).o;
            c92.i("PreCreateVideoHelper", "hasVideoInPage path : " + f + " has video :" + z);
            return z;
        }
        return invokeL.booleanValue;
    }
}
