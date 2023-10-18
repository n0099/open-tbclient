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
/* loaded from: classes7.dex */
public class lv2 {
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
            Bundle b = c23.b(mv2.class, null);
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
            return ej3.f("3.200.101");
        }
        return invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            SwanAppConfigData t = cr2.V().t();
            if (t == null) {
                return false;
            }
            return TextUtils.equals("none", t.e.q);
        }
        return invokeV.booleanValue;
    }

    public static NgWebView c(v42 v42Var) {
        InterceptResult invokeL;
        HashMap<String, yr1> W;
        yr1 yr1Var;
        xr1 webView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, v42Var)) == null) {
            if (v42Var instanceof x42) {
                wr1 v3 = ((x42) v42Var).v3();
                if (v3 != null && v3.j() != null) {
                    return (NgWebView) v3.j().getWebView();
                }
                if (v3 == null) {
                    return null;
                }
                return (NgWebView) v3.getWebView();
            } else if (!(v42Var instanceof c52) || (W = jc2.V().W()) == null || W.size() <= 0 || (yr1Var = W.get(hl3.c().h())) == null || !(yr1Var instanceof SwanWebModeWidget) || (webView = yr1Var.getWebView()) == null || !(webView instanceof NgWebView)) {
                return null;
            } else {
                return (NgWebView) webView;
            }
        }
        return (NgWebView) invokeL.objValue;
    }

    public static void g(int i, int i2) {
        SwanAppActivity w;
        y42 Y;
        v42 m;
        NgWebView c;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeII(65542, null, i, i2) != null) || (w = o53.K().w()) == null || (Y = w.Y()) == null || (m = Y.m()) == null || (c = c(m)) == null) {
            return;
        }
        if (!f()) {
            c.getSettings().setTextZoom(a(i));
            kv2.a(Integer.valueOf(i + 1), String.valueOf(i2));
        }
        h(i);
    }

    public static void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65543, null, i) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("key_text_size", i);
            f23.e().h(new h23(22, bundle));
        }
    }
}
