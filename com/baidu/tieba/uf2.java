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
/* loaded from: classes7.dex */
public class uf2 {
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

    public uf2() {
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

    public static Map<String, String> a(uf2 uf2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, uf2Var)) == null) {
            TreeMap treeMap = new TreeMap();
            if (uf2Var == null) {
                return treeMap;
            }
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, uf2Var.a);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, uf2Var.b);
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, uf2Var.c);
            treeMap.put(PrefetchEvent.EVENT_KEY_PAGE_URL, uf2Var.d);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, uf2Var.f);
            treeMap.put("root", uf2Var.g);
            if (!TextUtils.isEmpty(uf2Var.e)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, uf2Var.e);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(uf2Var.h));
            treeMap.put("pageType", uf2Var.i);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(uf2Var.j));
            if (!TextUtils.isEmpty(uf2Var.k)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, uf2Var.k);
            }
            e53.a(treeMap, "app ready event");
            yc3.a(uf2Var.d, treeMap);
            if (k82.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (ef3.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (ef3.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            treeMap.put("slaveReady", String.valueOf(uf2Var.l));
            if (!TextUtils.isEmpty(uf2Var.m)) {
                treeMap.put(PrefetchEvent.EVENT_USER_ACTION_APIS, uf2Var.m);
            }
            return treeMap;
        }
        return (Map) invokeL.objValue;
    }

    public static hj2 b(uf2 uf2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, uf2Var)) == null) {
            Map<String, String> a = a(uf2Var);
            hj2 hj2Var = new hj2("AppReady", a);
            PrefetchEvent.c createFromAppReadyEvent = PrefetchEvent.createFromAppReadyEvent(a);
            if (createFromAppReadyEvent == null) {
                return hj2Var;
            }
            wf2 wf2Var = new wf2();
            wf2Var.t(createFromAppReadyEvent);
            wf2Var.t(hj2Var);
            return wf2Var;
        }
        return (hj2) invokeL.objValue;
    }

    public static String c(g93 g93Var, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, g93Var, str)) == null) {
            if (g93Var != null) {
                str2 = g93Var.c0(ym3.f(str));
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
