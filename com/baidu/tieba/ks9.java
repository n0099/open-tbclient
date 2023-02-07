package com.baidu.tieba;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.minivideo.plugin.capture.report.ReportConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.AbstractMap;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class ks9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, os9 os9Var, ns9 ns9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, os9Var, ns9Var) == null) {
            if (cw9.a) {
                cw9.c("UGC_ArKpiReport", "perf_record_arperf, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + ns9Var.toString());
            }
            is9 g = fs9.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (ns9Var != null) {
                    arrayList = new ArrayList();
                    arrayList.add(new AbstractMap.SimpleEntry("sft", ns9Var.a));
                    arrayList.add(new AbstractMap.SimpleEntry("bft", ns9Var.b));
                    arrayList.add(new AbstractMap.SimpleEntry("mem", ns9Var.f));
                    arrayList.add(new AbstractMap.SimpleEntry("fc", ns9Var.c));
                    arrayList.add(new AbstractMap.SimpleEntry("time", ns9Var.d + ""));
                }
                g.a("perf_record_arperf", str, os9Var.a, os9Var.b, os9Var.c, os9Var.d, os9Var.e, null, arrayList);
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (cw9.a) {
                cw9.c("UGC_ArKpiReport", "perf_publish_debug, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
            }
            is9 g = fs9.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (str2 != null) {
                    arrayList = new ArrayList(3);
                    arrayList.add(new AbstractMap.SimpleEntry<>("ext", str2));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vername", aw9.a(fs9.c().getContext())));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vercode", String.valueOf(aw9.b(fs9.c().getContext()))));
                }
                g.a(ReportConfig.LOG_KEY_PUBLISH_DEBUG, str, null, null, null, null, null, null, arrayList);
            }
        }
    }
}
