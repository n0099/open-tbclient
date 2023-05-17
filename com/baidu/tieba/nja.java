package com.baidu.tieba;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.minivideo.plugin.capture.report.ReportConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.AbstractMap;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class nja {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, rja rjaVar, qja qjaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, rjaVar, qjaVar) == null) {
            if (fna.a) {
                fna.c("UGC_ArKpiReport", "perf_record_arperf, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + qjaVar.toString());
            }
            lja g = ija.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (qjaVar != null) {
                    arrayList = new ArrayList();
                    arrayList.add(new AbstractMap.SimpleEntry("sft", qjaVar.a));
                    arrayList.add(new AbstractMap.SimpleEntry("bft", qjaVar.b));
                    arrayList.add(new AbstractMap.SimpleEntry("mem", qjaVar.f));
                    arrayList.add(new AbstractMap.SimpleEntry("fc", qjaVar.c));
                    arrayList.add(new AbstractMap.SimpleEntry("time", qjaVar.d + ""));
                }
                g.a("perf_record_arperf", str, rjaVar.a, rjaVar.b, rjaVar.c, rjaVar.d, rjaVar.e, null, arrayList);
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (fna.a) {
                fna.c("UGC_ArKpiReport", "perf_publish_debug, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
            }
            lja g = ija.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (str2 != null) {
                    arrayList = new ArrayList(3);
                    arrayList.add(new AbstractMap.SimpleEntry<>("ext", str2));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vername", dna.a(ija.c().getContext())));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vercode", String.valueOf(dna.b(ija.c().getContext()))));
                }
                g.a(ReportConfig.LOG_KEY_PUBLISH_DEBUG, str, null, null, null, null, null, null, arrayList);
            }
        }
    }
}
