package com.baidu.tieba;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.minivideo.plugin.capture.report.ReportConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.AbstractMap;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class ui9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, yi9 yi9Var, xi9 xi9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, yi9Var, xi9Var) == null) {
            if (mm9.a) {
                mm9.c("UGC_ArKpiReport", "perf_record_arperf, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + xi9Var.toString());
            }
            si9 g = pi9.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (xi9Var != null) {
                    arrayList = new ArrayList();
                    arrayList.add(new AbstractMap.SimpleEntry("sft", xi9Var.a));
                    arrayList.add(new AbstractMap.SimpleEntry("bft", xi9Var.b));
                    arrayList.add(new AbstractMap.SimpleEntry("mem", xi9Var.f));
                    arrayList.add(new AbstractMap.SimpleEntry("fc", xi9Var.c));
                    arrayList.add(new AbstractMap.SimpleEntry("time", xi9Var.d + ""));
                }
                g.a("perf_record_arperf", str, yi9Var.a, yi9Var.b, yi9Var.c, yi9Var.d, yi9Var.e, null, arrayList);
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (mm9.a) {
                mm9.c("UGC_ArKpiReport", "perf_publish_debug, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
            }
            si9 g = pi9.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (str2 != null) {
                    arrayList = new ArrayList(3);
                    arrayList.add(new AbstractMap.SimpleEntry<>("ext", str2));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vername", km9.a(pi9.c().getContext())));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vercode", String.valueOf(km9.b(pi9.c().getContext()))));
                }
                g.a(ReportConfig.LOG_KEY_PUBLISH_DEBUG, str, null, null, null, null, null, null, arrayList);
            }
        }
    }
}
