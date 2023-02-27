package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.tieba.ju2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class k24 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, str2, Long.valueOf(j)}) == null) {
            j24 j24Var = new j24();
            j24Var.b = str;
            j24Var.e = str2;
            if (m93.M() != null && m93.M().Y() != null) {
                ju2.a Y = m93.M().Y();
                j24Var.a = fg3.n(Y.G());
                j24Var.f = Y.H();
                j24Var.c = Y.T();
                j24Var.a("play_time", Long.valueOf(j));
            }
            fg3.y("916", "68", j24Var);
        }
    }

    public static void b(String str, String str2) {
        String str3;
        ju2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (m93.M() != null && m93.M().Y() != null) {
                aVar = m93.M().Y();
                str3 = fg3.n(aVar.G());
            } else {
                str3 = "";
                aVar = null;
            }
            if (aVar != null && TextUtils.equals(str3, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME)) {
                j24 j24Var = new j24();
                j24Var.b = str;
                j24Var.e = str2;
                j24Var.a = str3;
                j24Var.f = aVar.H();
                j24Var.c = aVar.T();
                fg3.y("916", "68", j24Var);
            }
        }
    }

    public static void c(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            j24 j24Var = new j24();
            j24Var.b = str;
            j24Var.e = str2;
            if (m93.M() != null && m93.M().Y() != null) {
                ju2.a Y = m93.M().Y();
                j24Var.a = fg3.n(Y.G());
                j24Var.f = Y.H();
                j24Var.c = Y.T();
            }
            j24Var.k = str3;
            fg3.y("916", "68", j24Var);
        }
    }

    public static void d(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            j24 j24Var = new j24();
            j24Var.b = str;
            j24Var.e = "show";
            if (m93.M() != null && m93.M().Y() != null) {
                ju2.a Y = m93.M().Y();
                j24Var.a = fg3.n(Y.G());
                j24Var.f = Y.H();
                j24Var.c = Y.T();
            }
            if (e()) {
                str2 = "0";
            } else {
                str2 = "1";
            }
            j24Var.a("early", str2);
            fg3.y("916", "68", j24Var);
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (ja4.c() > 0 && w54.c() && System.currentTimeMillis() - ja4.c() > LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
