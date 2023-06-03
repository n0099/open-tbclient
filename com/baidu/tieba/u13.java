package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.core.slave.SwanWebModeWidget;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class u13 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i)) == null) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return i != 3 ? 100 : 118;
                    }
                    return 112;
                }
                return 100;
            }
            return 82;
        }
        return invokeI.intValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            Bundle b = l83.b(v13.class, null);
            if (b == null) {
                return 1;
            }
            return b.getInt("font_size_level", 1);
        }
        return invokeV.intValue;
    }

    public static int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b() + 1;
        }
        return invokeV.intValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return np3.f("3.200.101");
        }
        return invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            SwanAppConfigData s = lx2.T().s();
            if (s == null) {
                return false;
            }
            return TextUtils.equals("none", s.e.q);
        }
        return invokeV.booleanValue;
    }

    public static NgWebView c(eb2 eb2Var) {
        InterceptResult invokeL;
        HashMap<String, gy1> V;
        gy1 gy1Var;
        fy1 r;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, eb2Var)) == null) {
            if (eb2Var instanceof gb2) {
                ey1 q3 = ((gb2) eb2Var).q3();
                if (q3 != null && q3.j() != null) {
                    return (NgWebView) q3.j().r();
                }
                if (q3 == null) {
                    return null;
                }
                return (NgWebView) q3.r();
            } else if (!(eb2Var instanceof lb2) || (V = si2.U().V()) == null || V.size() <= 0 || (gy1Var = V.get(qr3.c().h())) == null || !(gy1Var instanceof SwanWebModeWidget) || (r = gy1Var.r()) == null || !(r instanceof NgWebView)) {
                return null;
            } else {
                return (NgWebView) r;
            }
        }
        return (NgWebView) invokeL.objValue;
    }

    public static void g(int i, int i2) {
        SwanAppActivity w;
        hb2 Y;
        eb2 m;
        NgWebView c;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeII(65542, null, i, i2) != null) || (w = xb3.K().w()) == null || (Y = w.Y()) == null || (m = Y.m()) == null || (c = c(m)) == null) {
            return;
        }
        if (!f()) {
            c.getSettings().setTextZoom(a(i));
            t13.a(Integer.valueOf(i + 1), String.valueOf(i2));
        }
        h(i);
    }

    public static void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65543, null, i) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("key_text_size", i);
            o83.e().h(new q83(22, bundle));
        }
    }
}
