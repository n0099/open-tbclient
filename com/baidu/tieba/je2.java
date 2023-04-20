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
/* loaded from: classes5.dex */
public class je2 {
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

    public je2() {
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

    public static Map<String, String> a(je2 je2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, je2Var)) == null) {
            TreeMap treeMap = new TreeMap();
            if (je2Var == null) {
                return treeMap;
            }
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, je2Var.a);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, je2Var.b);
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, je2Var.c);
            treeMap.put(PrefetchEvent.EVENT_KEY_PAGE_URL, je2Var.d);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, je2Var.f);
            treeMap.put("root", je2Var.g);
            if (!TextUtils.isEmpty(je2Var.e)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, je2Var.e);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(je2Var.h));
            treeMap.put("pageType", je2Var.i);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(je2Var.j));
            if (!TextUtils.isEmpty(je2Var.k)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, je2Var.k);
            }
            t33.a(treeMap, "app ready event");
            nb3.a(je2Var.d, treeMap);
            if (z62.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (td3.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (td3.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            treeMap.put("slaveReady", String.valueOf(je2Var.l));
            if (!TextUtils.isEmpty(je2Var.m)) {
                treeMap.put(PrefetchEvent.EVENT_USER_ACTION_APIS, je2Var.m);
            }
            return treeMap;
        }
        return (Map) invokeL.objValue;
    }

    public static wh2 b(je2 je2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, je2Var)) == null) {
            Map<String, String> a = a(je2Var);
            wh2 wh2Var = new wh2("AppReady", a);
            PrefetchEvent.c createFromAppReadyEvent = PrefetchEvent.createFromAppReadyEvent(a);
            if (createFromAppReadyEvent == null) {
                return wh2Var;
            }
            le2 le2Var = new le2();
            le2Var.t(createFromAppReadyEvent);
            le2Var.t(wh2Var);
            return le2Var;
        }
        return (wh2) invokeL.objValue;
    }

    public static String c(v73 v73Var, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, v73Var, str)) == null) {
            if (v73Var != null) {
                str2 = v73Var.c0(nl3.f(str));
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
