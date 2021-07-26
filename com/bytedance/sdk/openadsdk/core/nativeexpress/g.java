package com.bytedance.sdk.openadsdk.core.nativeexpress;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2, com.bytedance.sdk.openadsdk.core.e.m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, mVar) == null) {
            com.bytedance.sdk.openadsdk.j.a.a().a(com.bytedance.sdk.openadsdk.j.a.c.b().a(a(str)).c(str2).f(com.bytedance.sdk.openadsdk.q.q.h(mVar.ao())).a("dynamic_backup_render_new"));
        }
    }

    public static void a(int i2, String str, String str2, com.bytedance.sdk.openadsdk.core.e.m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i2), str, str2, mVar}) == null) {
            com.bytedance.sdk.openadsdk.j.a.a().h(com.bytedance.sdk.openadsdk.j.a.c.b().a(a(str)).c(str2).f(com.bytedance.sdk.openadsdk.q.q.h(mVar.ao())).b(i2).g(com.bytedance.sdk.openadsdk.core.g.a(i2)));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int a(String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            switch (str.hashCode()) {
                case -1695837674:
                    if (str.equals("banner_ad")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1364000502:
                    if (str.equals("rewarded_video")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -891990144:
                    if (str.equals("stream")) {
                        c2 = 7;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -764631662:
                    if (str.equals("fullscreen_interstitial_ad")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -712491894:
                    if (str.equals("embeded_ad")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 174971131:
                    if (str.equals("splash_ad")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1844104722:
                    if (str.equals("interaction")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1912999166:
                    if (str.equals("draw_ad")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 1:
                    return 9;
                case 2:
                    return 7;
                case 3:
                    return 8;
                case 4:
                    return 1;
                case 5:
                    return 2;
                case 6:
                    return 3;
                case 7:
                    return 6;
                default:
                    return 5;
            }
        }
        return invokeL.intValue;
    }
}
