package com.baidu.tieba;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.minivideo.plugin.capture.report.ReportConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.AbstractMap;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class lx9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, px9 px9Var, ox9 ox9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, px9Var, ox9Var) == null) {
            if (d1a.a) {
                d1a.c("UGC_ArKpiReport", "perf_record_arperf, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + ox9Var.toString());
            }
            jx9 g = gx9.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (ox9Var != null) {
                    arrayList = new ArrayList();
                    arrayList.add(new AbstractMap.SimpleEntry("sft", ox9Var.a));
                    arrayList.add(new AbstractMap.SimpleEntry("bft", ox9Var.b));
                    arrayList.add(new AbstractMap.SimpleEntry("mem", ox9Var.f));
                    arrayList.add(new AbstractMap.SimpleEntry("fc", ox9Var.c));
                    arrayList.add(new AbstractMap.SimpleEntry("time", ox9Var.d + ""));
                }
                g.a("perf_record_arperf", str, px9Var.a, px9Var.b, px9Var.c, px9Var.d, px9Var.e, null, arrayList);
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (d1a.a) {
                d1a.c("UGC_ArKpiReport", "perf_publish_debug, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
            }
            jx9 g = gx9.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (str2 != null) {
                    arrayList = new ArrayList(3);
                    arrayList.add(new AbstractMap.SimpleEntry<>("ext", str2));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vername", b1a.a(gx9.c().getContext())));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vercode", String.valueOf(b1a.b(gx9.c().getContext()))));
                }
                g.a(ReportConfig.LOG_KEY_PUBLISH_DEBUG, str, null, null, null, null, null, null, arrayList);
            }
        }
    }
}
