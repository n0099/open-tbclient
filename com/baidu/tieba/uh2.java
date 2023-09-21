package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes8.dex */
public class uh2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public boolean h;
    public String i;
    public boolean j;
    public String k;
    public boolean l;
    public String m;

    public uh2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static Map<String, String> a(uh2 uh2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, uh2Var)) == null) {
            TreeMap treeMap = new TreeMap();
            if (uh2Var == null) {
                return treeMap;
            }
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, uh2Var.a);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, uh2Var.b);
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, uh2Var.c);
            treeMap.put(PrefetchEvent.EVENT_KEY_PAGE_URL, uh2Var.d);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, uh2Var.f);
            treeMap.put("root", uh2Var.g);
            if (!TextUtils.isEmpty(uh2Var.e)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, uh2Var.e);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(uh2Var.h));
            treeMap.put("pageType", uh2Var.i);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(uh2Var.j));
            if (!TextUtils.isEmpty(uh2Var.k)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, uh2Var.k);
            }
            e73.a(treeMap, "app ready event");
            ye3.a(uh2Var.d, treeMap);
            if (ka2.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (eh3.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (eh3.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            treeMap.put("slaveReady", String.valueOf(uh2Var.l));
            if (!TextUtils.isEmpty(uh2Var.m)) {
                treeMap.put(PrefetchEvent.EVENT_USER_ACTION_APIS, uh2Var.m);
            }
            return treeMap;
        }
        return (Map) invokeL.objValue;
    }

    public static hl2 b(uh2 uh2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, uh2Var)) == null) {
            Map<String, String> a = a(uh2Var);
            hl2 hl2Var = new hl2("AppReady", a);
            PrefetchEvent.c createFromAppReadyEvent = PrefetchEvent.createFromAppReadyEvent(a);
            if (createFromAppReadyEvent == null) {
                return hl2Var;
            }
            wh2 wh2Var = new wh2();
            wh2Var.t(createFromAppReadyEvent);
            wh2Var.t(hl2Var);
            return wh2Var;
        }
        return (hl2) invokeL.objValue;
    }

    public static String c(gb3 gb3Var, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, gb3Var, str)) == null) {
            if (gb3Var != null) {
                str2 = gb3Var.c0(yo3.f(str));
            } else {
                str2 = null;
            }
            if (str2 == null) {
                return "";
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }
}
