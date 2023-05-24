package com.baidu.tieba;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.minivideo.plugin.capture.report.ReportConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.AbstractMap;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class oja {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, sja sjaVar, rja rjaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, sjaVar, rjaVar) == null) {
            if (gna.a) {
                gna.c("UGC_ArKpiReport", "perf_record_arperf, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + rjaVar.toString());
            }
            mja g = jja.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (rjaVar != null) {
                    arrayList = new ArrayList();
                    arrayList.add(new AbstractMap.SimpleEntry("sft", rjaVar.a));
                    arrayList.add(new AbstractMap.SimpleEntry("bft", rjaVar.b));
                    arrayList.add(new AbstractMap.SimpleEntry("mem", rjaVar.f));
                    arrayList.add(new AbstractMap.SimpleEntry("fc", rjaVar.c));
                    arrayList.add(new AbstractMap.SimpleEntry("time", rjaVar.d + ""));
                }
                g.a("perf_record_arperf", str, sjaVar.a, sjaVar.b, sjaVar.c, sjaVar.d, sjaVar.e, null, arrayList);
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (gna.a) {
                gna.c("UGC_ArKpiReport", "perf_publish_debug, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
            }
            mja g = jja.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (str2 != null) {
                    arrayList = new ArrayList(3);
                    arrayList.add(new AbstractMap.SimpleEntry<>("ext", str2));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vername", ena.a(jja.c().getContext())));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vercode", String.valueOf(ena.b(jja.c().getContext()))));
                }
                g.a(ReportConfig.LOG_KEY_PUBLISH_DEBUG, str, null, null, null, null, null, null, arrayList);
            }
        }
    }
}
