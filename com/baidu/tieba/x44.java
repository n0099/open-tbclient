package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.tieba.ww2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
/* loaded from: classes8.dex */
public class x44 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, str2, Long.valueOf(j)}) == null) {
            w44 w44Var = new w44();
            w44Var.b = str;
            w44Var.e = str2;
            if (zb3.M() != null && zb3.M().Y() != null) {
                ww2.a Y = zb3.M().Y();
                w44Var.a = si3.n(Y.G());
                w44Var.f = Y.H();
                w44Var.c = Y.T();
                w44Var.a("play_time", Long.valueOf(j));
            }
            si3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, w44Var);
        }
    }

    public static void b(String str, String str2) {
        String str3;
        ww2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (zb3.M() != null && zb3.M().Y() != null) {
                aVar = zb3.M().Y();
                str3 = si3.n(aVar.G());
            } else {
                str3 = "";
                aVar = null;
            }
            if (aVar != null && TextUtils.equals(str3, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME)) {
                w44 w44Var = new w44();
                w44Var.b = str;
                w44Var.e = str2;
                w44Var.a = str3;
                w44Var.f = aVar.H();
                w44Var.c = aVar.T();
                si3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, w44Var);
            }
        }
    }

    public static void c(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            w44 w44Var = new w44();
            w44Var.b = str;
            w44Var.e = str2;
            if (zb3.M() != null && zb3.M().Y() != null) {
                ww2.a Y = zb3.M().Y();
                w44Var.a = si3.n(Y.G());
                w44Var.f = Y.H();
                w44Var.c = Y.T();
            }
            w44Var.k = str3;
            si3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, w44Var);
        }
    }

    public static void d(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            w44 w44Var = new w44();
            w44Var.b = str;
            w44Var.e = "show";
            if (zb3.M() != null && zb3.M().Y() != null) {
                ww2.a Y = zb3.M().Y();
                w44Var.a = si3.n(Y.G());
                w44Var.f = Y.H();
                w44Var.c = Y.T();
            }
            if (e()) {
                str2 = "0";
            } else {
                str2 = "1";
            }
            w44Var.a("early", str2);
            si3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, w44Var);
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (wc4.c() > 0 && j84.c() && System.currentTimeMillis() - wc4.c() > LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
