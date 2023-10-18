package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.tieba.mq2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
/* loaded from: classes7.dex */
public class ny3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, str2, Long.valueOf(j)}) == null) {
            my3 my3Var = new my3();
            my3Var.b = str;
            my3Var.e = str2;
            if (p53.M() != null && p53.M().Z() != null) {
                mq2.a Z = p53.M().Z();
                my3Var.a = ic3.n(Z.H());
                my3Var.f = Z.I();
                my3Var.c = Z.U();
                my3Var.a("play_time", Long.valueOf(j));
            }
            ic3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, my3Var);
        }
    }

    public static void b(String str, String str2) {
        String str3;
        mq2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (p53.M() != null && p53.M().Z() != null) {
                aVar = p53.M().Z();
                str3 = ic3.n(aVar.H());
            } else {
                str3 = "";
                aVar = null;
            }
            if (aVar != null && TextUtils.equals(str3, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME)) {
                my3 my3Var = new my3();
                my3Var.b = str;
                my3Var.e = str2;
                my3Var.a = str3;
                my3Var.f = aVar.I();
                my3Var.c = aVar.U();
                ic3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, my3Var);
            }
        }
    }

    public static void c(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            my3 my3Var = new my3();
            my3Var.b = str;
            my3Var.e = str2;
            if (p53.M() != null && p53.M().Z() != null) {
                mq2.a Z = p53.M().Z();
                my3Var.a = ic3.n(Z.H());
                my3Var.f = Z.I();
                my3Var.c = Z.U();
            }
            my3Var.k = str3;
            ic3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, my3Var);
        }
    }

    public static void d(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            my3 my3Var = new my3();
            my3Var.b = str;
            my3Var.e = "show";
            if (p53.M() != null && p53.M().Z() != null) {
                mq2.a Z = p53.M().Z();
                my3Var.a = ic3.n(Z.H());
                my3Var.f = Z.I();
                my3Var.c = Z.U();
            }
            if (e()) {
                str2 = "0";
            } else {
                str2 = "1";
            }
            my3Var.a("early", str2);
            ic3.y("916", PayUVEventType.PAY_AMOUNT_DIALOG_CHANNEL_CLICK, my3Var);
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (m64.c() > 0 && z14.c() && System.currentTimeMillis() - m64.c() > LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
