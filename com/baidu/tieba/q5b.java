package com.baidu.tieba;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.minivideo.plugin.capture.report.ReportConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.AbstractMap;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class q5b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, u5b u5bVar, t5b t5bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, u5bVar, t5bVar) == null) {
            if (i9b.a) {
                i9b.c("UGC_ArKpiReport", "perf_record_arperf, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + t5bVar.toString());
            }
            o5b g = l5b.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (t5bVar != null) {
                    arrayList = new ArrayList();
                    arrayList.add(new AbstractMap.SimpleEntry("sft", t5bVar.a));
                    arrayList.add(new AbstractMap.SimpleEntry("bft", t5bVar.b));
                    arrayList.add(new AbstractMap.SimpleEntry("mem", t5bVar.f));
                    arrayList.add(new AbstractMap.SimpleEntry("fc", t5bVar.c));
                    arrayList.add(new AbstractMap.SimpleEntry("time", t5bVar.d + ""));
                }
                g.a("perf_record_arperf", str, u5bVar.a, u5bVar.b, u5bVar.c, u5bVar.d, u5bVar.e, null, arrayList);
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (i9b.a) {
                i9b.c("UGC_ArKpiReport", "perf_publish_debug, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
            }
            o5b g = l5b.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (str2 != null) {
                    arrayList = new ArrayList(3);
                    arrayList.add(new AbstractMap.SimpleEntry<>("ext", str2));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vername", g9b.a(l5b.c().getContext())));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vercode", String.valueOf(g9b.b(l5b.c().getContext()))));
                }
                g.a(ReportConfig.LOG_KEY_PUBLISH_DEBUG, str, null, null, null, null, null, null, arrayList);
            }
        }
    }
}
