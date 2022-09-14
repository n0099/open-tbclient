package com.baidu.tieba;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.minivideo.plugin.capture.report.ReportConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.AbstractMap;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class jc9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, nc9 nc9Var, mc9 mc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, nc9Var, mc9Var) == null) {
            if (bg9.a) {
                bg9.c("UGC_ArKpiReport", "perf_record_arperf, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + mc9Var.toString());
            }
            hc9 g = ec9.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (mc9Var != null) {
                    arrayList = new ArrayList();
                    arrayList.add(new AbstractMap.SimpleEntry("sft", mc9Var.a));
                    arrayList.add(new AbstractMap.SimpleEntry("bft", mc9Var.b));
                    arrayList.add(new AbstractMap.SimpleEntry("mem", mc9Var.f));
                    arrayList.add(new AbstractMap.SimpleEntry("fc", mc9Var.c));
                    arrayList.add(new AbstractMap.SimpleEntry("time", mc9Var.d + ""));
                }
                g.a("perf_record_arperf", str, nc9Var.a, nc9Var.b, nc9Var.c, nc9Var.d, nc9Var.e, null, arrayList);
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (bg9.a) {
                bg9.c("UGC_ArKpiReport", "perf_publish_debug, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
            }
            hc9 g = ec9.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (str2 != null) {
                    arrayList = new ArrayList(3);
                    arrayList.add(new AbstractMap.SimpleEntry<>("ext", str2));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vername", zf9.a(ec9.c().getContext())));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vercode", String.valueOf(zf9.b(ec9.c().getContext()))));
                }
                g.a(ReportConfig.LOG_KEY_PUBLISH_DEBUG, str, null, null, null, null, null, null, arrayList);
            }
        }
    }
}
