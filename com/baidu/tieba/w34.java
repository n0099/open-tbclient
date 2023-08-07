package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.tieba.vv2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
/* loaded from: classes8.dex */
public class w34 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, str2, Long.valueOf(j)}) == null) {
            v34 v34Var = new v34();
            v34Var.b = str;
            v34Var.e = str2;
            if (ya3.M() != null && ya3.M().Y() != null) {
                vv2.a Y = ya3.M().Y();
                v34Var.a = rh3.n(Y.G());
                v34Var.f = Y.H();
                v34Var.c = Y.T();
                v34Var.a("play_time", Long.valueOf(j));
            }
            rh3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, v34Var);
        }
    }

    public static void b(String str, String str2) {
        String str3;
        vv2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (ya3.M() != null && ya3.M().Y() != null) {
                aVar = ya3.M().Y();
                str3 = rh3.n(aVar.G());
            } else {
                str3 = "";
                aVar = null;
            }
            if (aVar != null && TextUtils.equals(str3, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME)) {
                v34 v34Var = new v34();
                v34Var.b = str;
                v34Var.e = str2;
                v34Var.a = str3;
                v34Var.f = aVar.H();
                v34Var.c = aVar.T();
                rh3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, v34Var);
            }
        }
    }

    public static void c(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            v34 v34Var = new v34();
            v34Var.b = str;
            v34Var.e = str2;
            if (ya3.M() != null && ya3.M().Y() != null) {
                vv2.a Y = ya3.M().Y();
                v34Var.a = rh3.n(Y.G());
                v34Var.f = Y.H();
                v34Var.c = Y.T();
            }
            v34Var.k = str3;
            rh3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, v34Var);
        }
    }

    public static void d(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            v34 v34Var = new v34();
            v34Var.b = str;
            v34Var.e = "show";
            if (ya3.M() != null && ya3.M().Y() != null) {
                vv2.a Y = ya3.M().Y();
                v34Var.a = rh3.n(Y.G());
                v34Var.f = Y.H();
                v34Var.c = Y.T();
            }
            if (e()) {
                str2 = "0";
            } else {
                str2 = "1";
            }
            v34Var.a("early", str2);
            rh3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, v34Var);
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (vb4.c() > 0 && i74.c() && System.currentTimeMillis() - vb4.c() > LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
