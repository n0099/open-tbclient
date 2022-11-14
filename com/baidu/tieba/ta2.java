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
/* loaded from: classes6.dex */
public class ta2 {
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

    public ta2() {
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

    public static Map<String, String> a(ta2 ta2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ta2Var)) == null) {
            TreeMap treeMap = new TreeMap();
            if (ta2Var == null) {
                return treeMap;
            }
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, ta2Var.a);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, ta2Var.b);
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, ta2Var.c);
            treeMap.put(PrefetchEvent.EVENT_KEY_PAGE_URL, ta2Var.d);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, ta2Var.f);
            treeMap.put("root", ta2Var.g);
            if (!TextUtils.isEmpty(ta2Var.e)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, ta2Var.e);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(ta2Var.h));
            treeMap.put("pageType", ta2Var.i);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(ta2Var.j));
            if (!TextUtils.isEmpty(ta2Var.k)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, ta2Var.k);
            }
            d03.a(treeMap, "app ready event");
            x73.a(ta2Var.d, treeMap);
            if (j32.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (da3.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (da3.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            treeMap.put("slaveReady", String.valueOf(ta2Var.l));
            if (!TextUtils.isEmpty(ta2Var.m)) {
                treeMap.put(PrefetchEvent.EVENT_USER_ACTION_APIS, ta2Var.m);
            }
            return treeMap;
        }
        return (Map) invokeL.objValue;
    }

    public static ge2 b(ta2 ta2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ta2Var)) == null) {
            Map<String, String> a = a(ta2Var);
            ge2 ge2Var = new ge2("AppReady", a);
            PrefetchEvent.c createFromAppReadyEvent = PrefetchEvent.createFromAppReadyEvent(a);
            if (createFromAppReadyEvent == null) {
                return ge2Var;
            }
            va2 va2Var = new va2();
            va2Var.t(createFromAppReadyEvent);
            va2Var.t(ge2Var);
            return va2Var;
        }
        return (ge2) invokeL.objValue;
    }

    public static String c(f43 f43Var, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, f43Var, str)) == null) {
            if (f43Var != null) {
                str2 = f43Var.c0(xh3.f(str));
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
