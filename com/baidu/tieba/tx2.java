package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.core.slave.SwanWebModeWidget;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class tx2 {
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
            Bundle b = k43.b(ux2.class, null);
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
            return ml3.f("3.200.101");
        }
        return invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            SwanAppConfigData s = kt2.U().s();
            if (s == null) {
                return false;
            }
            return TextUtils.equals("none", s.e.q);
        }
        return invokeV.booleanValue;
    }

    public static NgWebView c(d72 d72Var) {
        InterceptResult invokeL;
        HashMap<String, fu1> V;
        fu1 fu1Var;
        eu1 s;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, d72Var)) == null) {
            if (d72Var instanceof f72) {
                du1 r3 = ((f72) d72Var).r3();
                if (r3 != null && r3.k() != null) {
                    return (NgWebView) r3.k().s();
                }
                if (r3 == null) {
                    return null;
                }
                return (NgWebView) r3.s();
            } else if (!(d72Var instanceof k72) || (V = re2.U().V()) == null || V.size() <= 0 || (fu1Var = V.get(pn3.c().h())) == null || !(fu1Var instanceof SwanWebModeWidget) || (s = fu1Var.s()) == null || !(s instanceof NgWebView)) {
                return null;
            } else {
                return (NgWebView) s;
            }
        }
        return (NgWebView) invokeL.objValue;
    }

    public static void g(int i, int i2) {
        SwanAppActivity w;
        g72 Z;
        d72 m;
        NgWebView c;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeII(65542, null, i, i2) != null) || (w = w73.K().w()) == null || (Z = w.Z()) == null || (m = Z.m()) == null || (c = c(m)) == null) {
            return;
        }
        if (!f()) {
            c.getSettings().setTextZoom(a(i));
            sx2.a(Integer.valueOf(i + 1), String.valueOf(i2));
        }
        h(i);
    }

    public static void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65543, null, i) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt(QuickPersistConfigConst.KEY_TEXT_SIZE, i);
            n43.e().h(new p43(22, bundle));
        }
    }
}
