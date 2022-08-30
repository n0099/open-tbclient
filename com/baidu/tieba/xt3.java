package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.tieba.xl2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class xt3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, str2, Long.valueOf(j)}) == null) {
            wt3 wt3Var = new wt3();
            wt3Var.b = str;
            wt3Var.e = str2;
            if (a13.M() != null && a13.M().Y() != null) {
                xl2.a Y = a13.M().Y();
                wt3Var.a = t73.n(Y.G());
                wt3Var.f = Y.H();
                wt3Var.c = Y.T();
                wt3Var.a("play_time", Long.valueOf(j));
            }
            t73.y("916", "68", wt3Var);
        }
    }

    public static void b(String str, String str2) {
        String str3;
        xl2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (a13.M() == null || a13.M().Y() == null) {
                str3 = "";
                aVar = null;
            } else {
                aVar = a13.M().Y();
                str3 = t73.n(aVar.G());
            }
            if (aVar == null || !TextUtils.equals(str3, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME)) {
                return;
            }
            wt3 wt3Var = new wt3();
            wt3Var.b = str;
            wt3Var.e = str2;
            wt3Var.a = str3;
            wt3Var.f = aVar.H();
            wt3Var.c = aVar.T();
            t73.y("916", "68", wt3Var);
        }
    }

    public static void c(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            wt3 wt3Var = new wt3();
            wt3Var.b = str;
            wt3Var.e = str2;
            if (a13.M() != null && a13.M().Y() != null) {
                xl2.a Y = a13.M().Y();
                wt3Var.a = t73.n(Y.G());
                wt3Var.f = Y.H();
                wt3Var.c = Y.T();
            }
            wt3Var.k = str3;
            t73.y("916", "68", wt3Var);
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            wt3 wt3Var = new wt3();
            wt3Var.b = str;
            wt3Var.e = "show";
            if (a13.M() != null && a13.M().Y() != null) {
                xl2.a Y = a13.M().Y();
                wt3Var.a = t73.n(Y.G());
                wt3Var.f = Y.H();
                wt3Var.c = Y.T();
            }
            wt3Var.a("early", e() ? "0" : "1");
            t73.y("916", "68", wt3Var);
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? w14.c() > 0 && jx3.c() && System.currentTimeMillis() - w14.c() > LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION : invokeV.booleanValue;
    }
}
