package com.baidu.tieba;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.minivideo.plugin.capture.report.ReportConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.AbstractMap;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class qeb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, ueb uebVar, teb tebVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, str, uebVar, tebVar) == null) {
            if (iib.a) {
                iib.c("UGC_ArKpiReport", "perf_record_arperf, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + tebVar.toString());
            }
            oeb g = leb.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (tebVar != null) {
                    arrayList = new ArrayList();
                    arrayList.add(new AbstractMap.SimpleEntry("sft", tebVar.a));
                    arrayList.add(new AbstractMap.SimpleEntry("bft", tebVar.b));
                    arrayList.add(new AbstractMap.SimpleEntry("mem", tebVar.f));
                    arrayList.add(new AbstractMap.SimpleEntry("fc", tebVar.c));
                    arrayList.add(new AbstractMap.SimpleEntry("time", tebVar.d + ""));
                }
                g.a("perf_record_arperf", str, uebVar.a, uebVar.b, uebVar.c, uebVar.d, uebVar.e, null, arrayList);
            }
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (iib.a) {
                iib.c("UGC_ArKpiReport", "perf_publish_debug, " + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2);
            }
            oeb g = leb.c().g();
            if (g != null) {
                ArrayList arrayList = null;
                if (str2 != null) {
                    arrayList = new ArrayList(3);
                    arrayList.add(new AbstractMap.SimpleEntry<>("ext", str2));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vername", gib.a(leb.c().getContext())));
                    arrayList.add(new AbstractMap.SimpleEntry<>("capture_vercode", String.valueOf(gib.b(leb.c().getContext()))));
                }
                g.a(ReportConfig.LOG_KEY_PUBLISH_DEBUG, str, null, null, null, null, null, null, arrayList);
            }
        }
    }
}
