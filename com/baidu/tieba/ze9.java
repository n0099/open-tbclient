package com.baidu.tieba;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.minivideo.plugin.capture.report.ReportConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.AbstractMap;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class ze9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, df9 df9Var, cf9 cf9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, df9Var, cf9Var) == null) {
            if (ri9.a) {
                ri9.c("UGC_ArKpiReport", "perf_record_arperf, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + cf9Var.toString());
            }
            xe9 g = ue9.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (cf9Var != null) {
                    arrayList = new ArrayList();
                    arrayList.add(new AbstractMap.SimpleEntry("sft", cf9Var.a));
                    arrayList.add(new AbstractMap.SimpleEntry("bft", cf9Var.b));
                    arrayList.add(new AbstractMap.SimpleEntry("mem", cf9Var.f));
                    arrayList.add(new AbstractMap.SimpleEntry("fc", cf9Var.c));
                    arrayList.add(new AbstractMap.SimpleEntry("time", cf9Var.d + ""));
                }
                g.a("perf_record_arperf", str, df9Var.a, df9Var.b, df9Var.c, df9Var.d, df9Var.e, null, arrayList);
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (ri9.a) {
                ri9.c("UGC_ArKpiReport", "perf_publish_debug, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
            }
            xe9 g = ue9.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (str2 != null) {
                    arrayList = new ArrayList(3);
                    arrayList.add(new AbstractMap.SimpleEntry<>("ext", str2));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vername", pi9.a(ue9.c().getContext())));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vercode", String.valueOf(pi9.b(ue9.c().getContext()))));
                }
                g.a(ReportConfig.LOG_KEY_PUBLISH_DEBUG, str, null, null, null, null, null, null, arrayList);
            }
        }
    }
}
