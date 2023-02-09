package com.baidu.tieba;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.minivideo.plugin.capture.report.ReportConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.AbstractMap;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class ot9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, st9 st9Var, rt9 rt9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, st9Var, rt9Var) == null) {
            if (gx9.a) {
                gx9.c("UGC_ArKpiReport", "perf_record_arperf, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + rt9Var.toString());
            }
            mt9 g = jt9.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (rt9Var != null) {
                    arrayList = new ArrayList();
                    arrayList.add(new AbstractMap.SimpleEntry("sft", rt9Var.a));
                    arrayList.add(new AbstractMap.SimpleEntry("bft", rt9Var.b));
                    arrayList.add(new AbstractMap.SimpleEntry("mem", rt9Var.f));
                    arrayList.add(new AbstractMap.SimpleEntry("fc", rt9Var.c));
                    arrayList.add(new AbstractMap.SimpleEntry("time", rt9Var.d + ""));
                }
                g.a("perf_record_arperf", str, st9Var.a, st9Var.b, st9Var.c, st9Var.d, st9Var.e, null, arrayList);
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (gx9.a) {
                gx9.c("UGC_ArKpiReport", "perf_publish_debug, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
            }
            mt9 g = jt9.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (str2 != null) {
                    arrayList = new ArrayList(3);
                    arrayList.add(new AbstractMap.SimpleEntry<>("ext", str2));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vername", ex9.a(jt9.c().getContext())));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vercode", String.valueOf(ex9.b(jt9.c().getContext()))));
                }
                g.a(ReportConfig.LOG_KEY_PUBLISH_DEBUG, str, null, null, null, null, null, null, arrayList);
            }
        }
    }
}
