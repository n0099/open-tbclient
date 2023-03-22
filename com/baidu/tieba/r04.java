package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.tieba.qs2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class r04 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, str2, Long.valueOf(j)}) == null) {
            q04 q04Var = new q04();
            q04Var.b = str;
            q04Var.e = str2;
            if (t73.M() != null && t73.M().Y() != null) {
                qs2.a Y = t73.M().Y();
                q04Var.a = me3.n(Y.G());
                q04Var.f = Y.H();
                q04Var.c = Y.T();
                q04Var.a("play_time", Long.valueOf(j));
            }
            me3.y("916", "68", q04Var);
        }
    }

    public static void b(String str, String str2) {
        String str3;
        qs2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (t73.M() != null && t73.M().Y() != null) {
                aVar = t73.M().Y();
                str3 = me3.n(aVar.G());
            } else {
                str3 = "";
                aVar = null;
            }
            if (aVar != null && TextUtils.equals(str3, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME)) {
                q04 q04Var = new q04();
                q04Var.b = str;
                q04Var.e = str2;
                q04Var.a = str3;
                q04Var.f = aVar.H();
                q04Var.c = aVar.T();
                me3.y("916", "68", q04Var);
            }
        }
    }

    public static void c(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            q04 q04Var = new q04();
            q04Var.b = str;
            q04Var.e = str2;
            if (t73.M() != null && t73.M().Y() != null) {
                qs2.a Y = t73.M().Y();
                q04Var.a = me3.n(Y.G());
                q04Var.f = Y.H();
                q04Var.c = Y.T();
            }
            q04Var.k = str3;
            me3.y("916", "68", q04Var);
        }
    }

    public static void d(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            q04 q04Var = new q04();
            q04Var.b = str;
            q04Var.e = "show";
            if (t73.M() != null && t73.M().Y() != null) {
                qs2.a Y = t73.M().Y();
                q04Var.a = me3.n(Y.G());
                q04Var.f = Y.H();
                q04Var.c = Y.T();
            }
            if (e()) {
                str2 = "0";
            } else {
                str2 = "1";
            }
            q04Var.a("early", str2);
            me3.y("916", "68", q04Var);
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (q84.c() > 0 && d44.c() && System.currentTimeMillis() - q84.c() > LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
