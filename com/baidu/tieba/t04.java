package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.tieba.ss2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class t04 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, str2, Long.valueOf(j)}) == null) {
            s04 s04Var = new s04();
            s04Var.b = str;
            s04Var.e = str2;
            if (v73.M() != null && v73.M().Y() != null) {
                ss2.a Y = v73.M().Y();
                s04Var.a = oe3.n(Y.G());
                s04Var.f = Y.H();
                s04Var.c = Y.T();
                s04Var.a("play_time", Long.valueOf(j));
            }
            oe3.y("916", "68", s04Var);
        }
    }

    public static void b(String str, String str2) {
        String str3;
        ss2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (v73.M() != null && v73.M().Y() != null) {
                aVar = v73.M().Y();
                str3 = oe3.n(aVar.G());
            } else {
                str3 = "";
                aVar = null;
            }
            if (aVar != null && TextUtils.equals(str3, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME)) {
                s04 s04Var = new s04();
                s04Var.b = str;
                s04Var.e = str2;
                s04Var.a = str3;
                s04Var.f = aVar.H();
                s04Var.c = aVar.T();
                oe3.y("916", "68", s04Var);
            }
        }
    }

    public static void c(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            s04 s04Var = new s04();
            s04Var.b = str;
            s04Var.e = str2;
            if (v73.M() != null && v73.M().Y() != null) {
                ss2.a Y = v73.M().Y();
                s04Var.a = oe3.n(Y.G());
                s04Var.f = Y.H();
                s04Var.c = Y.T();
            }
            s04Var.k = str3;
            oe3.y("916", "68", s04Var);
        }
    }

    public static void d(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            s04 s04Var = new s04();
            s04Var.b = str;
            s04Var.e = "show";
            if (v73.M() != null && v73.M().Y() != null) {
                ss2.a Y = v73.M().Y();
                s04Var.a = oe3.n(Y.G());
                s04Var.f = Y.H();
                s04Var.c = Y.T();
            }
            if (e()) {
                str2 = "0";
            } else {
                str2 = "1";
            }
            s04Var.a("early", str2);
            oe3.y("916", "68", s04Var);
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (s84.c() > 0 && f44.c() && System.currentTimeMillis() - s84.c() > LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
