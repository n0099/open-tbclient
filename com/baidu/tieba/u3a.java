package com.baidu.tieba;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.minivideo.plugin.capture.report.ReportConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.AbstractMap;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class u3a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, y3a y3aVar, x3a x3aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, y3aVar, x3aVar) == null) {
            if (m7a.a) {
                m7a.c("UGC_ArKpiReport", "perf_record_arperf, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + x3aVar.toString());
            }
            s3a g = p3a.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (x3aVar != null) {
                    arrayList = new ArrayList();
                    arrayList.add(new AbstractMap.SimpleEntry("sft", x3aVar.a));
                    arrayList.add(new AbstractMap.SimpleEntry("bft", x3aVar.b));
                    arrayList.add(new AbstractMap.SimpleEntry("mem", x3aVar.f));
                    arrayList.add(new AbstractMap.SimpleEntry("fc", x3aVar.c));
                    arrayList.add(new AbstractMap.SimpleEntry("time", x3aVar.d + ""));
                }
                g.a("perf_record_arperf", str, y3aVar.a, y3aVar.b, y3aVar.c, y3aVar.d, y3aVar.e, null, arrayList);
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (m7a.a) {
                m7a.c("UGC_ArKpiReport", "perf_publish_debug, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
            }
            s3a g = p3a.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (str2 != null) {
                    arrayList = new ArrayList(3);
                    arrayList.add(new AbstractMap.SimpleEntry<>("ext", str2));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vername", k7a.a(p3a.c().getContext())));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vercode", String.valueOf(k7a.b(p3a.c().getContext()))));
                }
                g.a(ReportConfig.LOG_KEY_PUBLISH_DEBUG, str, null, null, null, null, null, null, arrayList);
            }
        }
    }
}
