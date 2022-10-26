package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.tieba.jo2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class kw3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, str2, Long.valueOf(j)}) == null) {
            jw3 jw3Var = new jw3();
            jw3Var.b = str;
            jw3Var.e = str2;
            if (m33.M() != null && m33.M().Y() != null) {
                jo2.a Y = m33.M().Y();
                jw3Var.a = fa3.n(Y.G());
                jw3Var.f = Y.H();
                jw3Var.c = Y.T();
                jw3Var.a("play_time", Long.valueOf(j));
            }
            fa3.y("916", "68", jw3Var);
        }
    }

    public static void b(String str, String str2) {
        String str3;
        jo2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (m33.M() != null && m33.M().Y() != null) {
                aVar = m33.M().Y();
                str3 = fa3.n(aVar.G());
            } else {
                str3 = "";
                aVar = null;
            }
            if (aVar != null && TextUtils.equals(str3, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME)) {
                jw3 jw3Var = new jw3();
                jw3Var.b = str;
                jw3Var.e = str2;
                jw3Var.a = str3;
                jw3Var.f = aVar.H();
                jw3Var.c = aVar.T();
                fa3.y("916", "68", jw3Var);
            }
        }
    }

    public static void c(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            jw3 jw3Var = new jw3();
            jw3Var.b = str;
            jw3Var.e = str2;
            if (m33.M() != null && m33.M().Y() != null) {
                jo2.a Y = m33.M().Y();
                jw3Var.a = fa3.n(Y.G());
                jw3Var.f = Y.H();
                jw3Var.c = Y.T();
            }
            jw3Var.k = str3;
            fa3.y("916", "68", jw3Var);
        }
    }

    public static void d(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            jw3 jw3Var = new jw3();
            jw3Var.b = str;
            jw3Var.e = "show";
            if (m33.M() != null && m33.M().Y() != null) {
                jo2.a Y = m33.M().Y();
                jw3Var.a = fa3.n(Y.G());
                jw3Var.f = Y.H();
                jw3Var.c = Y.T();
            }
            if (e()) {
                str2 = "0";
            } else {
                str2 = "1";
            }
            jw3Var.a("early", str2);
            fa3.y("916", "68", jw3Var);
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (j44.c() > 0 && wz3.c() && System.currentTimeMillis() - j44.c() > LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
