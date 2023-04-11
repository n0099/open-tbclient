package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.tieba.rs2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class s04 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, str2, Long.valueOf(j)}) == null) {
            r04 r04Var = new r04();
            r04Var.b = str;
            r04Var.e = str2;
            if (u73.M() != null && u73.M().Y() != null) {
                rs2.a Y = u73.M().Y();
                r04Var.a = ne3.n(Y.G());
                r04Var.f = Y.H();
                r04Var.c = Y.T();
                r04Var.a("play_time", Long.valueOf(j));
            }
            ne3.y("916", "68", r04Var);
        }
    }

    public static void b(String str, String str2) {
        String str3;
        rs2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (u73.M() != null && u73.M().Y() != null) {
                aVar = u73.M().Y();
                str3 = ne3.n(aVar.G());
            } else {
                str3 = "";
                aVar = null;
            }
            if (aVar != null && TextUtils.equals(str3, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME)) {
                r04 r04Var = new r04();
                r04Var.b = str;
                r04Var.e = str2;
                r04Var.a = str3;
                r04Var.f = aVar.H();
                r04Var.c = aVar.T();
                ne3.y("916", "68", r04Var);
            }
        }
    }

    public static void c(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            r04 r04Var = new r04();
            r04Var.b = str;
            r04Var.e = str2;
            if (u73.M() != null && u73.M().Y() != null) {
                rs2.a Y = u73.M().Y();
                r04Var.a = ne3.n(Y.G());
                r04Var.f = Y.H();
                r04Var.c = Y.T();
            }
            r04Var.k = str3;
            ne3.y("916", "68", r04Var);
        }
    }

    public static void d(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            r04 r04Var = new r04();
            r04Var.b = str;
            r04Var.e = "show";
            if (u73.M() != null && u73.M().Y() != null) {
                rs2.a Y = u73.M().Y();
                r04Var.a = ne3.n(Y.G());
                r04Var.f = Y.H();
                r04Var.c = Y.T();
            }
            if (e()) {
                str2 = "0";
            } else {
                str2 = "1";
            }
            r04Var.a("early", str2);
            ne3.y("916", "68", r04Var);
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (r84.c() > 0 && e44.c() && System.currentTimeMillis() - r84.c() > LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
