package com.baidu.tieba;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.minivideo.plugin.capture.report.ReportConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.AbstractMap;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class lf9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, pf9 pf9Var, of9 of9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, pf9Var, of9Var) == null) {
            if (dj9.a) {
                dj9.c("UGC_ArKpiReport", "perf_record_arperf, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + of9Var.toString());
            }
            jf9 g = gf9.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (of9Var != null) {
                    arrayList = new ArrayList();
                    arrayList.add(new AbstractMap.SimpleEntry("sft", of9Var.a));
                    arrayList.add(new AbstractMap.SimpleEntry("bft", of9Var.b));
                    arrayList.add(new AbstractMap.SimpleEntry("mem", of9Var.f));
                    arrayList.add(new AbstractMap.SimpleEntry("fc", of9Var.c));
                    arrayList.add(new AbstractMap.SimpleEntry("time", of9Var.d + ""));
                }
                g.a("perf_record_arperf", str, pf9Var.a, pf9Var.b, pf9Var.c, pf9Var.d, pf9Var.e, null, arrayList);
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (dj9.a) {
                dj9.c("UGC_ArKpiReport", "perf_publish_debug, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
            }
            jf9 g = gf9.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (str2 != null) {
                    arrayList = new ArrayList(3);
                    arrayList.add(new AbstractMap.SimpleEntry<>("ext", str2));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vername", bj9.a(gf9.c().getContext())));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vercode", String.valueOf(bj9.b(gf9.c().getContext()))));
                }
                g.a(ReportConfig.LOG_KEY_PUBLISH_DEBUG, str, null, null, null, null, null, null, arrayList);
            }
        }
    }
}
