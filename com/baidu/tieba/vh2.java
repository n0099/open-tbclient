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
public class vh2 {
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

    public vh2() {
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

    public static Map<String, String> a(vh2 vh2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, vh2Var)) == null) {
            TreeMap treeMap = new TreeMap();
            if (vh2Var == null) {
                return treeMap;
            }
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, vh2Var.a);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, vh2Var.b);
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, vh2Var.c);
            treeMap.put(PrefetchEvent.EVENT_KEY_PAGE_URL, vh2Var.d);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, vh2Var.f);
            treeMap.put("root", vh2Var.g);
            if (!TextUtils.isEmpty(vh2Var.e)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, vh2Var.e);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(vh2Var.h));
            treeMap.put("pageType", vh2Var.i);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(vh2Var.j));
            if (!TextUtils.isEmpty(vh2Var.k)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, vh2Var.k);
            }
            f73.a(treeMap, "app ready event");
            ze3.a(vh2Var.d, treeMap);
            if (la2.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (fh3.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (fh3.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            treeMap.put("slaveReady", String.valueOf(vh2Var.l));
            if (!TextUtils.isEmpty(vh2Var.m)) {
                treeMap.put(PrefetchEvent.EVENT_USER_ACTION_APIS, vh2Var.m);
            }
            return treeMap;
        }
        return (Map) invokeL.objValue;
    }

    public static il2 b(vh2 vh2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, vh2Var)) == null) {
            Map<String, String> a = a(vh2Var);
            il2 il2Var = new il2("AppReady", a);
            PrefetchEvent.c createFromAppReadyEvent = PrefetchEvent.createFromAppReadyEvent(a);
            if (createFromAppReadyEvent == null) {
                return il2Var;
            }
            xh2 xh2Var = new xh2();
            xh2Var.t(createFromAppReadyEvent);
            xh2Var.t(il2Var);
            return xh2Var;
        }
        return (il2) invokeL.objValue;
    }

    public static String c(hb3 hb3Var, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, hb3Var, str)) == null) {
            if (hb3Var != null) {
                str2 = hb3Var.c0(zo3.f(str));
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
