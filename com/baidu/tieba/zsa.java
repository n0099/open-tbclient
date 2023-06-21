package com.baidu.tieba;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.minivideo.plugin.capture.report.ReportConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.AbstractMap;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class zsa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, dta dtaVar, cta ctaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, dtaVar, ctaVar) == null) {
            if (rwa.a) {
                rwa.c("UGC_ArKpiReport", "perf_record_arperf, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + ctaVar.toString());
            }
            xsa g = usa.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (ctaVar != null) {
                    arrayList = new ArrayList();
                    arrayList.add(new AbstractMap.SimpleEntry("sft", ctaVar.a));
                    arrayList.add(new AbstractMap.SimpleEntry("bft", ctaVar.b));
                    arrayList.add(new AbstractMap.SimpleEntry("mem", ctaVar.f));
                    arrayList.add(new AbstractMap.SimpleEntry("fc", ctaVar.c));
                    arrayList.add(new AbstractMap.SimpleEntry("time", ctaVar.d + ""));
                }
                g.a("perf_record_arperf", str, dtaVar.a, dtaVar.b, dtaVar.c, dtaVar.d, dtaVar.e, null, arrayList);
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (rwa.a) {
                rwa.c("UGC_ArKpiReport", "perf_publish_debug, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
            }
            xsa g = usa.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (str2 != null) {
                    arrayList = new ArrayList(3);
                    arrayList.add(new AbstractMap.SimpleEntry<>("ext", str2));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vername", pwa.a(usa.c().getContext())));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vercode", String.valueOf(pwa.b(usa.c().getContext()))));
                }
                g.a(ReportConfig.LOG_KEY_PUBLISH_DEBUG, str, null, null, null, null, null, null, arrayList);
            }
        }
    }
}
