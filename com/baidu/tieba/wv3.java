package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.tieba.vn2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class wv3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, str2, Long.valueOf(j)}) == null) {
            vv3 vv3Var = new vv3();
            vv3Var.b = str;
            vv3Var.e = str2;
            if (y23.M() != null && y23.M().Y() != null) {
                vn2.a Y = y23.M().Y();
                vv3Var.a = r93.n(Y.G());
                vv3Var.f = Y.H();
                vv3Var.c = Y.T();
                vv3Var.a("play_time", Long.valueOf(j));
            }
            r93.y("916", "68", vv3Var);
        }
    }

    public static void b(String str, String str2) {
        String str3;
        vn2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (y23.M() == null || y23.M().Y() == null) {
                str3 = "";
                aVar = null;
            } else {
                aVar = y23.M().Y();
                str3 = r93.n(aVar.G());
            }
            if (aVar == null || !TextUtils.equals(str3, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME)) {
                return;
            }
            vv3 vv3Var = new vv3();
            vv3Var.b = str;
            vv3Var.e = str2;
            vv3Var.a = str3;
            vv3Var.f = aVar.H();
            vv3Var.c = aVar.T();
            r93.y("916", "68", vv3Var);
        }
    }

    public static void c(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            vv3 vv3Var = new vv3();
            vv3Var.b = str;
            vv3Var.e = str2;
            if (y23.M() != null && y23.M().Y() != null) {
                vn2.a Y = y23.M().Y();
                vv3Var.a = r93.n(Y.G());
                vv3Var.f = Y.H();
                vv3Var.c = Y.T();
            }
            vv3Var.k = str3;
            r93.y("916", "68", vv3Var);
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            vv3 vv3Var = new vv3();
            vv3Var.b = str;
            vv3Var.e = "show";
            if (y23.M() != null && y23.M().Y() != null) {
                vn2.a Y = y23.M().Y();
                vv3Var.a = r93.n(Y.G());
                vv3Var.f = Y.H();
                vv3Var.c = Y.T();
            }
            vv3Var.a("early", e() ? "0" : "1");
            r93.y("916", "68", vv3Var);
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? v34.c() > 0 && iz3.c() && System.currentTimeMillis() - v34.c() > LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION : invokeV.booleanValue;
    }
}
