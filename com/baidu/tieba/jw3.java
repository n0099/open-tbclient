package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.tieba.io2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class jw3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, str2, Long.valueOf(j)}) == null) {
            iw3 iw3Var = new iw3();
            iw3Var.b = str;
            iw3Var.e = str2;
            if (l33.M() != null && l33.M().Y() != null) {
                io2.a Y = l33.M().Y();
                iw3Var.a = ea3.n(Y.G());
                iw3Var.f = Y.H();
                iw3Var.c = Y.T();
                iw3Var.a("play_time", Long.valueOf(j));
            }
            ea3.y("916", "68", iw3Var);
        }
    }

    public static void b(String str, String str2) {
        String str3;
        io2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (l33.M() == null || l33.M().Y() == null) {
                str3 = "";
                aVar = null;
            } else {
                aVar = l33.M().Y();
                str3 = ea3.n(aVar.G());
            }
            if (aVar == null || !TextUtils.equals(str3, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME)) {
                return;
            }
            iw3 iw3Var = new iw3();
            iw3Var.b = str;
            iw3Var.e = str2;
            iw3Var.a = str3;
            iw3Var.f = aVar.H();
            iw3Var.c = aVar.T();
            ea3.y("916", "68", iw3Var);
        }
    }

    public static void c(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            iw3 iw3Var = new iw3();
            iw3Var.b = str;
            iw3Var.e = str2;
            if (l33.M() != null && l33.M().Y() != null) {
                io2.a Y = l33.M().Y();
                iw3Var.a = ea3.n(Y.G());
                iw3Var.f = Y.H();
                iw3Var.c = Y.T();
            }
            iw3Var.k = str3;
            ea3.y("916", "68", iw3Var);
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            iw3 iw3Var = new iw3();
            iw3Var.b = str;
            iw3Var.e = "show";
            if (l33.M() != null && l33.M().Y() != null) {
                io2.a Y = l33.M().Y();
                iw3Var.a = ea3.n(Y.G());
                iw3Var.f = Y.H();
                iw3Var.c = Y.T();
            }
            iw3Var.a("early", e() ? "0" : "1");
            ea3.y("916", "68", iw3Var);
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? i44.c() > 0 && vz3.c() && System.currentTimeMillis() - i44.c() > LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION : invokeV.booleanValue;
    }
}
