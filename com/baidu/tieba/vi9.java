package com.baidu.tieba;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.minivideo.plugin.capture.report.ReportConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.AbstractMap;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class vi9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, zi9 zi9Var, yi9 yi9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, zi9Var, yi9Var) == null) {
            if (nm9.a) {
                nm9.c("UGC_ArKpiReport", "perf_record_arperf, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + yi9Var.toString());
            }
            ti9 g = qi9.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (yi9Var != null) {
                    arrayList = new ArrayList();
                    arrayList.add(new AbstractMap.SimpleEntry("sft", yi9Var.a));
                    arrayList.add(new AbstractMap.SimpleEntry("bft", yi9Var.b));
                    arrayList.add(new AbstractMap.SimpleEntry("mem", yi9Var.f));
                    arrayList.add(new AbstractMap.SimpleEntry("fc", yi9Var.c));
                    arrayList.add(new AbstractMap.SimpleEntry("time", yi9Var.d + ""));
                }
                g.a("perf_record_arperf", str, zi9Var.a, zi9Var.b, zi9Var.c, zi9Var.d, zi9Var.e, null, arrayList);
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (nm9.a) {
                nm9.c("UGC_ArKpiReport", "perf_publish_debug, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
            }
            ti9 g = qi9.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (str2 != null) {
                    arrayList = new ArrayList(3);
                    arrayList.add(new AbstractMap.SimpleEntry<>("ext", str2));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vername", lm9.a(qi9.c().getContext())));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vercode", String.valueOf(lm9.b(qi9.c().getContext()))));
                }
                g.a(ReportConfig.LOG_KEY_PUBLISH_DEBUG, str, null, null, null, null, null, null, arrayList);
            }
        }
    }
}
