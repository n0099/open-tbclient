package com.baidu.tieba;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.minivideo.plugin.capture.report.ReportConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.AbstractMap;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class pxa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, txa txaVar, sxa sxaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, txaVar, sxaVar) == null) {
            if (h1b.a) {
                h1b.c("UGC_ArKpiReport", "perf_record_arperf, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + sxaVar.toString());
            }
            nxa g = kxa.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (sxaVar != null) {
                    arrayList = new ArrayList();
                    arrayList.add(new AbstractMap.SimpleEntry("sft", sxaVar.a));
                    arrayList.add(new AbstractMap.SimpleEntry("bft", sxaVar.b));
                    arrayList.add(new AbstractMap.SimpleEntry("mem", sxaVar.f));
                    arrayList.add(new AbstractMap.SimpleEntry("fc", sxaVar.c));
                    arrayList.add(new AbstractMap.SimpleEntry("time", sxaVar.d + ""));
                }
                g.a("perf_record_arperf", str, txaVar.a, txaVar.b, txaVar.c, txaVar.d, txaVar.e, null, arrayList);
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (h1b.a) {
                h1b.c("UGC_ArKpiReport", "perf_publish_debug, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
            }
            nxa g = kxa.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (str2 != null) {
                    arrayList = new ArrayList(3);
                    arrayList.add(new AbstractMap.SimpleEntry<>("ext", str2));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vername", f1b.a(kxa.c().getContext())));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vercode", String.valueOf(f1b.b(kxa.c().getContext()))));
                }
                g.a(ReportConfig.LOG_KEY_PUBLISH_DEBUG, str, null, null, null, null, null, null, arrayList);
            }
        }
    }
}
