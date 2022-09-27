package com.baidu.tieba;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.minivideo.plugin.capture.report.ReportConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.AbstractMap;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class yc9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, cd9 cd9Var, bd9 bd9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, cd9Var, bd9Var) == null) {
            if (qg9.a) {
                qg9.c("UGC_ArKpiReport", "perf_record_arperf, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + bd9Var.toString());
            }
            wc9 g = tc9.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (bd9Var != null) {
                    arrayList = new ArrayList();
                    arrayList.add(new AbstractMap.SimpleEntry("sft", bd9Var.a));
                    arrayList.add(new AbstractMap.SimpleEntry("bft", bd9Var.b));
                    arrayList.add(new AbstractMap.SimpleEntry("mem", bd9Var.f));
                    arrayList.add(new AbstractMap.SimpleEntry("fc", bd9Var.c));
                    arrayList.add(new AbstractMap.SimpleEntry("time", bd9Var.d + ""));
                }
                g.a("perf_record_arperf", str, cd9Var.a, cd9Var.b, cd9Var.c, cd9Var.d, cd9Var.e, null, arrayList);
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (qg9.a) {
                qg9.c("UGC_ArKpiReport", "perf_publish_debug, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
            }
            wc9 g = tc9.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (str2 != null) {
                    arrayList = new ArrayList(3);
                    arrayList.add(new AbstractMap.SimpleEntry<>("ext", str2));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vername", og9.a(tc9.c().getContext())));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vercode", String.valueOf(og9.b(tc9.c().getContext()))));
                }
                g.a(ReportConfig.LOG_KEY_PUBLISH_DEBUG, str, null, null, null, null, null, null, arrayList);
            }
        }
    }
}
