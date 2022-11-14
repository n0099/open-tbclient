package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.nadcore.model.MonitorUrl;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes4.dex */
public final class jo0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(ClogBuilder.LogType logType, String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{logType, str, str2, str3, str4, str5}) == null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(logType);
            clogBuilder.j(str2);
            clogBuilder.u(ClogBuilder.Page.WELFAREMAXLP);
            clogBuilder.p(str);
            clogBuilder.k(str3);
            clogBuilder.l(str4);
            clogBuilder.m(str5);
            a11.b(clogBuilder);
        }
    }

    public static /* synthetic */ void b(ClogBuilder.LogType logType, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        String str6;
        String str7;
        String str8;
        String str9;
        if ((i & 4) != 0) {
            str6 = "";
        } else {
            str6 = str2;
        }
        if ((i & 8) != 0) {
            str7 = "";
        } else {
            str7 = str3;
        }
        if ((i & 16) != 0) {
            str8 = "";
        } else {
            str8 = str4;
        }
        if ((i & 32) != 0) {
            str9 = "";
        } else {
            str9 = str5;
        }
        a(logType, str, str6, str7, str8, str9);
    }

    public static final void c(String str, String coin, String sessionInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, coin, sessionInfo) == null) {
            Intrinsics.checkNotNullParameter(coin, "coin");
            Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
            if (str != null) {
                b(ClogBuilder.LogType.FREE_SHOW, str, "popper", coin, sessionInfo, null, 32, null);
            }
        }
    }

    public static final void d(String str, boolean z) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65539, null, str, z) == null) && str != null) {
            ClogBuilder.LogType logType = ClogBuilder.LogType.FREE_CLICK;
            if (z) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            b(logType, str, "close", str2, null, null, 48, null);
        }
    }

    public static final void e(xp0 model) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, model) == null) {
            Intrinsics.checkNotNullParameter(model, "model");
            String ext = model.f.d;
            ClogBuilder.LogType logType = ClogBuilder.LogType.SHOW;
            Intrinsics.checkNotNullExpressionValue(ext, "ext");
            b(logType, ext, null, null, null, null, 60, null);
            List<MonitorUrl> list = model.e;
            Intrinsics.checkNotNullExpressionValue(list, "model.monitorUrls");
            ArrayList<MonitorUrl> arrayList = new ArrayList();
            for (Object obj : list) {
                String str = ((MonitorUrl) obj).showUrl;
                if (str != null && !StringsKt__StringsJVMKt.isBlank(str)) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    arrayList.add(obj);
                }
            }
            for (MonitorUrl monitorUrl : arrayList) {
                b11.b(monitorUrl.showUrl);
            }
        }
    }
}
