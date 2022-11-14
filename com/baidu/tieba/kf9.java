package com.baidu.tieba;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.minivideo.plugin.capture.report.ReportConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.AbstractMap;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class kf9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, of9 of9Var, nf9 nf9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, of9Var, nf9Var) == null) {
            if (cj9.a) {
                cj9.c("UGC_ArKpiReport", "perf_record_arperf, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + nf9Var.toString());
            }
            if9 g = ff9.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (nf9Var != null) {
                    arrayList = new ArrayList();
                    arrayList.add(new AbstractMap.SimpleEntry("sft", nf9Var.a));
                    arrayList.add(new AbstractMap.SimpleEntry("bft", nf9Var.b));
                    arrayList.add(new AbstractMap.SimpleEntry("mem", nf9Var.f));
                    arrayList.add(new AbstractMap.SimpleEntry("fc", nf9Var.c));
                    arrayList.add(new AbstractMap.SimpleEntry("time", nf9Var.d + ""));
                }
                g.a("perf_record_arperf", str, of9Var.a, of9Var.b, of9Var.c, of9Var.d, of9Var.e, null, arrayList);
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (cj9.a) {
                cj9.c("UGC_ArKpiReport", "perf_publish_debug, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
            }
            if9 g = ff9.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (str2 != null) {
                    arrayList = new ArrayList(3);
                    arrayList.add(new AbstractMap.SimpleEntry<>("ext", str2));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vername", aj9.a(ff9.c().getContext())));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vercode", String.valueOf(aj9.b(ff9.c().getContext()))));
                }
                g.a(ReportConfig.LOG_KEY_PUBLISH_DEBUG, str, null, null, null, null, null, null, arrayList);
            }
        }
    }
}
