package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.tieba.hr2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
/* loaded from: classes6.dex */
public class iz3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, str2, Long.valueOf(j)}) == null) {
            hz3 hz3Var = new hz3();
            hz3Var.b = str;
            hz3Var.e = str2;
            if (k63.M() != null && k63.M().Z() != null) {
                hr2.a Z = k63.M().Z();
                hz3Var.a = dd3.n(Z.H());
                hz3Var.f = Z.I();
                hz3Var.c = Z.U();
                hz3Var.a("play_time", Long.valueOf(j));
            }
            dd3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, hz3Var);
        }
    }

    public static void b(String str, String str2) {
        String str3;
        hr2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (k63.M() != null && k63.M().Z() != null) {
                aVar = k63.M().Z();
                str3 = dd3.n(aVar.H());
            } else {
                str3 = "";
                aVar = null;
            }
            if (aVar != null && TextUtils.equals(str3, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME)) {
                hz3 hz3Var = new hz3();
                hz3Var.b = str;
                hz3Var.e = str2;
                hz3Var.a = str3;
                hz3Var.f = aVar.I();
                hz3Var.c = aVar.U();
                dd3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, hz3Var);
            }
        }
    }

    public static void c(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            hz3 hz3Var = new hz3();
            hz3Var.b = str;
            hz3Var.e = str2;
            if (k63.M() != null && k63.M().Z() != null) {
                hr2.a Z = k63.M().Z();
                hz3Var.a = dd3.n(Z.H());
                hz3Var.f = Z.I();
                hz3Var.c = Z.U();
            }
            hz3Var.k = str3;
            dd3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, hz3Var);
        }
    }

    public static void d(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            hz3 hz3Var = new hz3();
            hz3Var.b = str;
            hz3Var.e = "show";
            if (k63.M() != null && k63.M().Z() != null) {
                hr2.a Z = k63.M().Z();
                hz3Var.a = dd3.n(Z.H());
                hz3Var.f = Z.I();
                hz3Var.c = Z.U();
            }
            if (e()) {
                str2 = "0";
            } else {
                str2 = "1";
            }
            hz3Var.a("early", str2);
            dd3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, hz3Var);
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (h74.c() > 0 && u24.c() && System.currentTimeMillis() - h74.c() > LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
