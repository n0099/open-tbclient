package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.tieba.sw2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
/* loaded from: classes8.dex */
public class t44 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, str2, Long.valueOf(j)}) == null) {
            s44 s44Var = new s44();
            s44Var.b = str;
            s44Var.e = str2;
            if (vb3.M() != null && vb3.M().Y() != null) {
                sw2.a Y = vb3.M().Y();
                s44Var.a = oi3.n(Y.G());
                s44Var.f = Y.H();
                s44Var.c = Y.T();
                s44Var.a("play_time", Long.valueOf(j));
            }
            oi3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, s44Var);
        }
    }

    public static void b(String str, String str2) {
        String str3;
        sw2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (vb3.M() != null && vb3.M().Y() != null) {
                aVar = vb3.M().Y();
                str3 = oi3.n(aVar.G());
            } else {
                str3 = "";
                aVar = null;
            }
            if (aVar != null && TextUtils.equals(str3, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME)) {
                s44 s44Var = new s44();
                s44Var.b = str;
                s44Var.e = str2;
                s44Var.a = str3;
                s44Var.f = aVar.H();
                s44Var.c = aVar.T();
                oi3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, s44Var);
            }
        }
    }

    public static void c(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            s44 s44Var = new s44();
            s44Var.b = str;
            s44Var.e = str2;
            if (vb3.M() != null && vb3.M().Y() != null) {
                sw2.a Y = vb3.M().Y();
                s44Var.a = oi3.n(Y.G());
                s44Var.f = Y.H();
                s44Var.c = Y.T();
            }
            s44Var.k = str3;
            oi3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, s44Var);
        }
    }

    public static void d(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            s44 s44Var = new s44();
            s44Var.b = str;
            s44Var.e = "show";
            if (vb3.M() != null && vb3.M().Y() != null) {
                sw2.a Y = vb3.M().Y();
                s44Var.a = oi3.n(Y.G());
                s44Var.f = Y.H();
                s44Var.c = Y.T();
            }
            if (e()) {
                str2 = "0";
            } else {
                str2 = "1";
            }
            s44Var.a("early", str2);
            oi3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, s44Var);
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (sc4.c() > 0 && f84.c() && System.currentTimeMillis() - sc4.c() > LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
