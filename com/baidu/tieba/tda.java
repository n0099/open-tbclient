package com.baidu.tieba;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.minivideo.plugin.capture.report.ReportConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.AbstractMap;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class tda {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, xda xdaVar, wda wdaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, xdaVar, wdaVar) == null) {
            if (lha.a) {
                lha.c("UGC_ArKpiReport", "perf_record_arperf, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + wdaVar.toString());
            }
            rda g = oda.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (wdaVar != null) {
                    arrayList = new ArrayList();
                    arrayList.add(new AbstractMap.SimpleEntry("sft", wdaVar.a));
                    arrayList.add(new AbstractMap.SimpleEntry("bft", wdaVar.b));
                    arrayList.add(new AbstractMap.SimpleEntry("mem", wdaVar.f));
                    arrayList.add(new AbstractMap.SimpleEntry("fc", wdaVar.c));
                    arrayList.add(new AbstractMap.SimpleEntry("time", wdaVar.d + ""));
                }
                g.a("perf_record_arperf", str, xdaVar.a, xdaVar.b, xdaVar.c, xdaVar.d, xdaVar.e, null, arrayList);
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (lha.a) {
                lha.c("UGC_ArKpiReport", "perf_publish_debug, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
            }
            rda g = oda.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (str2 != null) {
                    arrayList = new ArrayList(3);
                    arrayList.add(new AbstractMap.SimpleEntry<>("ext", str2));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vername", jha.a(oda.c().getContext())));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vercode", String.valueOf(jha.b(oda.c().getContext()))));
                }
                g.a(ReportConfig.LOG_KEY_PUBLISH_DEBUG, str, null, null, null, null, null, null, arrayList);
            }
        }
    }
}
