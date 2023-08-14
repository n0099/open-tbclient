package com.baidu.tieba;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.minivideo.plugin.capture.report.ReportConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.AbstractMap;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class r5b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, v5b v5bVar, u5b u5bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, v5bVar, u5bVar) == null) {
            if (j9b.a) {
                j9b.c("UGC_ArKpiReport", "perf_record_arperf, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + u5bVar.toString());
            }
            p5b g = m5b.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (u5bVar != null) {
                    arrayList = new ArrayList();
                    arrayList.add(new AbstractMap.SimpleEntry("sft", u5bVar.a));
                    arrayList.add(new AbstractMap.SimpleEntry("bft", u5bVar.b));
                    arrayList.add(new AbstractMap.SimpleEntry("mem", u5bVar.f));
                    arrayList.add(new AbstractMap.SimpleEntry("fc", u5bVar.c));
                    arrayList.add(new AbstractMap.SimpleEntry("time", u5bVar.d + ""));
                }
                g.a("perf_record_arperf", str, v5bVar.a, v5bVar.b, v5bVar.c, v5bVar.d, v5bVar.e, null, arrayList);
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (j9b.a) {
                j9b.c("UGC_ArKpiReport", "perf_publish_debug, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
            }
            p5b g = m5b.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (str2 != null) {
                    arrayList = new ArrayList(3);
                    arrayList.add(new AbstractMap.SimpleEntry<>("ext", str2));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vername", h9b.a(m5b.c().getContext())));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vercode", String.valueOf(h9b.b(m5b.c().getContext()))));
                }
                g.a(ReportConfig.LOG_KEY_PUBLISH_DEBUG, str, null, null, null, null, null, null, arrayList);
            }
        }
    }
}
