package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.tieba.vw2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
/* loaded from: classes8.dex */
public class w44 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, str2, Long.valueOf(j)}) == null) {
            v44 v44Var = new v44();
            v44Var.b = str;
            v44Var.e = str2;
            if (yb3.M() != null && yb3.M().Y() != null) {
                vw2.a Y = yb3.M().Y();
                v44Var.a = ri3.n(Y.G());
                v44Var.f = Y.H();
                v44Var.c = Y.T();
                v44Var.a("play_time", Long.valueOf(j));
            }
            ri3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, v44Var);
        }
    }

    public static void b(String str, String str2) {
        String str3;
        vw2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (yb3.M() != null && yb3.M().Y() != null) {
                aVar = yb3.M().Y();
                str3 = ri3.n(aVar.G());
            } else {
                str3 = "";
                aVar = null;
            }
            if (aVar != null && TextUtils.equals(str3, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME)) {
                v44 v44Var = new v44();
                v44Var.b = str;
                v44Var.e = str2;
                v44Var.a = str3;
                v44Var.f = aVar.H();
                v44Var.c = aVar.T();
                ri3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, v44Var);
            }
        }
    }

    public static void c(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            v44 v44Var = new v44();
            v44Var.b = str;
            v44Var.e = str2;
            if (yb3.M() != null && yb3.M().Y() != null) {
                vw2.a Y = yb3.M().Y();
                v44Var.a = ri3.n(Y.G());
                v44Var.f = Y.H();
                v44Var.c = Y.T();
            }
            v44Var.k = str3;
            ri3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, v44Var);
        }
    }

    public static void d(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            v44 v44Var = new v44();
            v44Var.b = str;
            v44Var.e = "show";
            if (yb3.M() != null && yb3.M().Y() != null) {
                vw2.a Y = yb3.M().Y();
                v44Var.a = ri3.n(Y.G());
                v44Var.f = Y.H();
                v44Var.c = Y.T();
            }
            if (e()) {
                str2 = "0";
            } else {
                str2 = "1";
            }
            v44Var.a("early", str2);
            ri3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, v44Var);
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (vc4.c() > 0 && i84.c() && System.currentTimeMillis() - vc4.c() > LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
