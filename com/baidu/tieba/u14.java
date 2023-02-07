package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.tieba.tt2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class u14 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, str2, Long.valueOf(j)}) == null) {
            t14 t14Var = new t14();
            t14Var.b = str;
            t14Var.e = str2;
            if (w83.M() != null && w83.M().Y() != null) {
                tt2.a Y = w83.M().Y();
                t14Var.a = pf3.n(Y.G());
                t14Var.f = Y.H();
                t14Var.c = Y.T();
                t14Var.a("play_time", Long.valueOf(j));
            }
            pf3.y("916", "68", t14Var);
        }
    }

    public static void b(String str, String str2) {
        String str3;
        tt2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (w83.M() != null && w83.M().Y() != null) {
                aVar = w83.M().Y();
                str3 = pf3.n(aVar.G());
            } else {
                str3 = "";
                aVar = null;
            }
            if (aVar != null && TextUtils.equals(str3, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME)) {
                t14 t14Var = new t14();
                t14Var.b = str;
                t14Var.e = str2;
                t14Var.a = str3;
                t14Var.f = aVar.H();
                t14Var.c = aVar.T();
                pf3.y("916", "68", t14Var);
            }
        }
    }

    public static void c(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            t14 t14Var = new t14();
            t14Var.b = str;
            t14Var.e = str2;
            if (w83.M() != null && w83.M().Y() != null) {
                tt2.a Y = w83.M().Y();
                t14Var.a = pf3.n(Y.G());
                t14Var.f = Y.H();
                t14Var.c = Y.T();
            }
            t14Var.k = str3;
            pf3.y("916", "68", t14Var);
        }
    }

    public static void d(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            t14 t14Var = new t14();
            t14Var.b = str;
            t14Var.e = "show";
            if (w83.M() != null && w83.M().Y() != null) {
                tt2.a Y = w83.M().Y();
                t14Var.a = pf3.n(Y.G());
                t14Var.f = Y.H();
                t14Var.c = Y.T();
            }
            if (e()) {
                str2 = "0";
            } else {
                str2 = "1";
            }
            t14Var.a("early", str2);
            pf3.y("916", "68", t14Var);
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (t94.c() > 0 && g54.c() && System.currentTimeMillis() - t94.c() > LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
