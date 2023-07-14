package com.baidu.tieba;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.minivideo.plugin.capture.report.ReportConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.AbstractMap;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class n6b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, r6b r6bVar, q6b q6bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, r6bVar, q6bVar) == null) {
            if (fab.a) {
                fab.c("UGC_ArKpiReport", "perf_record_arperf, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + q6bVar.toString());
            }
            l6b g = i6b.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (q6bVar != null) {
                    arrayList = new ArrayList();
                    arrayList.add(new AbstractMap.SimpleEntry("sft", q6bVar.a));
                    arrayList.add(new AbstractMap.SimpleEntry("bft", q6bVar.b));
                    arrayList.add(new AbstractMap.SimpleEntry("mem", q6bVar.f));
                    arrayList.add(new AbstractMap.SimpleEntry("fc", q6bVar.c));
                    arrayList.add(new AbstractMap.SimpleEntry("time", q6bVar.d + ""));
                }
                g.a("perf_record_arperf", str, r6bVar.a, r6bVar.b, r6bVar.c, r6bVar.d, r6bVar.e, null, arrayList);
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (fab.a) {
                fab.c("UGC_ArKpiReport", "perf_publish_debug, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
            }
            l6b g = i6b.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (str2 != null) {
                    arrayList = new ArrayList(3);
                    arrayList.add(new AbstractMap.SimpleEntry<>("ext", str2));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vername", dab.a(i6b.c().getContext())));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vercode", String.valueOf(dab.b(i6b.c().getContext()))));
                }
                g.a(ReportConfig.LOG_KEY_PUBLISH_DEBUG, str, null, null, null, null, null, null, arrayList);
            }
        }
    }
}
