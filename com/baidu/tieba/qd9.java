package com.baidu.tieba;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.minivideo.plugin.capture.report.ReportConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.AbstractMap;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class qd9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, ud9 ud9Var, td9 td9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, ud9Var, td9Var) == null) {
            if (ih9.a) {
                ih9.c("UGC_ArKpiReport", "perf_record_arperf, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + td9Var.toString());
            }
            od9 g = ld9.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (td9Var != null) {
                    arrayList = new ArrayList();
                    arrayList.add(new AbstractMap.SimpleEntry("sft", td9Var.a));
                    arrayList.add(new AbstractMap.SimpleEntry("bft", td9Var.b));
                    arrayList.add(new AbstractMap.SimpleEntry("mem", td9Var.f));
                    arrayList.add(new AbstractMap.SimpleEntry("fc", td9Var.c));
                    arrayList.add(new AbstractMap.SimpleEntry("time", td9Var.d + ""));
                }
                g.a("perf_record_arperf", str, ud9Var.a, ud9Var.b, ud9Var.c, ud9Var.d, ud9Var.e, null, arrayList);
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (ih9.a) {
                ih9.c("UGC_ArKpiReport", "perf_publish_debug, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
            }
            od9 g = ld9.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (str2 != null) {
                    arrayList = new ArrayList(3);
                    arrayList.add(new AbstractMap.SimpleEntry<>("ext", str2));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vername", gh9.a(ld9.c().getContext())));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vercode", String.valueOf(gh9.b(ld9.c().getContext()))));
                }
                g.a(ReportConfig.LOG_KEY_PUBLISH_DEBUG, str, null, null, null, null, null, null, arrayList);
            }
        }
    }
}
