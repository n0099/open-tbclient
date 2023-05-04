package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.tieba.us2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class v04 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, str2, Long.valueOf(j)}) == null) {
            u04 u04Var = new u04();
            u04Var.b = str;
            u04Var.e = str2;
            if (x73.M() != null && x73.M().Y() != null) {
                us2.a Y = x73.M().Y();
                u04Var.a = qe3.n(Y.G());
                u04Var.f = Y.H();
                u04Var.c = Y.T();
                u04Var.a("play_time", Long.valueOf(j));
            }
            qe3.y("916", "68", u04Var);
        }
    }

    public static void b(String str, String str2) {
        String str3;
        us2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (x73.M() != null && x73.M().Y() != null) {
                aVar = x73.M().Y();
                str3 = qe3.n(aVar.G());
            } else {
                str3 = "";
                aVar = null;
            }
            if (aVar != null && TextUtils.equals(str3, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME)) {
                u04 u04Var = new u04();
                u04Var.b = str;
                u04Var.e = str2;
                u04Var.a = str3;
                u04Var.f = aVar.H();
                u04Var.c = aVar.T();
                qe3.y("916", "68", u04Var);
            }
        }
    }

    public static void c(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            u04 u04Var = new u04();
            u04Var.b = str;
            u04Var.e = str2;
            if (x73.M() != null && x73.M().Y() != null) {
                us2.a Y = x73.M().Y();
                u04Var.a = qe3.n(Y.G());
                u04Var.f = Y.H();
                u04Var.c = Y.T();
            }
            u04Var.k = str3;
            qe3.y("916", "68", u04Var);
        }
    }

    public static void d(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            u04 u04Var = new u04();
            u04Var.b = str;
            u04Var.e = "show";
            if (x73.M() != null && x73.M().Y() != null) {
                us2.a Y = x73.M().Y();
                u04Var.a = qe3.n(Y.G());
                u04Var.f = Y.H();
                u04Var.c = Y.T();
            }
            if (e()) {
                str2 = "0";
            } else {
                str2 = "1";
            }
            u04Var.a("early", str2);
            qe3.y("916", "68", u04Var);
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (u84.c() > 0 && h44.c() && System.currentTimeMillis() - u84.c() > LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
