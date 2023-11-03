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
public class uc2 {
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

    public uc2() {
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

    public static Map<String, String> a(uc2 uc2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, uc2Var)) == null) {
            TreeMap treeMap = new TreeMap();
            if (uc2Var == null) {
                return treeMap;
            }
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, uc2Var.a);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, uc2Var.b);
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, uc2Var.c);
            treeMap.put(PrefetchEvent.EVENT_KEY_PAGE_URL, uc2Var.d);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, uc2Var.f);
            treeMap.put("root", uc2Var.g);
            if (!TextUtils.isEmpty(uc2Var.e)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, uc2Var.e);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(uc2Var.h));
            treeMap.put("pageType", uc2Var.i);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(uc2Var.j));
            if (!TextUtils.isEmpty(uc2Var.k)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, uc2Var.k);
            }
            e23.a(treeMap, "app ready event");
            y93.a(uc2Var.d, treeMap);
            if (k52.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (ec3.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (ec3.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            treeMap.put("slaveReady", String.valueOf(uc2Var.l));
            if (!TextUtils.isEmpty(uc2Var.m)) {
                treeMap.put(PrefetchEvent.EVENT_USER_ACTION_APIS, uc2Var.m);
            }
            return treeMap;
        }
        return (Map) invokeL.objValue;
    }

    public static hg2 b(uc2 uc2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, uc2Var)) == null) {
            Map<String, String> a = a(uc2Var);
            hg2 hg2Var = new hg2("AppReady", a);
            PrefetchEvent.c createFromAppReadyEvent = PrefetchEvent.createFromAppReadyEvent(a);
            if (createFromAppReadyEvent == null) {
                return hg2Var;
            }
            wc2 wc2Var = new wc2();
            wc2Var.t(createFromAppReadyEvent);
            wc2Var.t(hg2Var);
            return wc2Var;
        }
        return (hg2) invokeL.objValue;
    }

    public static String c(g63 g63Var, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, g63Var, str)) == null) {
            if (g63Var != null) {
                str2 = g63Var.d0(yj3.f(str));
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
