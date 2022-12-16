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
public class sa2 {
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

    public sa2() {
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

    public static Map<String, String> a(sa2 sa2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, sa2Var)) == null) {
            TreeMap treeMap = new TreeMap();
            if (sa2Var == null) {
                return treeMap;
            }
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, sa2Var.a);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, sa2Var.b);
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, sa2Var.c);
            treeMap.put(PrefetchEvent.EVENT_KEY_PAGE_URL, sa2Var.d);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, sa2Var.f);
            treeMap.put("root", sa2Var.g);
            if (!TextUtils.isEmpty(sa2Var.e)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, sa2Var.e);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(sa2Var.h));
            treeMap.put("pageType", sa2Var.i);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(sa2Var.j));
            if (!TextUtils.isEmpty(sa2Var.k)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, sa2Var.k);
            }
            c03.a(treeMap, "app ready event");
            w73.a(sa2Var.d, treeMap);
            if (i32.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (ca3.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (ca3.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            treeMap.put("slaveReady", String.valueOf(sa2Var.l));
            if (!TextUtils.isEmpty(sa2Var.m)) {
                treeMap.put(PrefetchEvent.EVENT_USER_ACTION_APIS, sa2Var.m);
            }
            return treeMap;
        }
        return (Map) invokeL.objValue;
    }

    public static fe2 b(sa2 sa2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, sa2Var)) == null) {
            Map<String, String> a = a(sa2Var);
            fe2 fe2Var = new fe2("AppReady", a);
            PrefetchEvent.c createFromAppReadyEvent = PrefetchEvent.createFromAppReadyEvent(a);
            if (createFromAppReadyEvent == null) {
                return fe2Var;
            }
            ua2 ua2Var = new ua2();
            ua2Var.t(createFromAppReadyEvent);
            ua2Var.t(fe2Var);
            return ua2Var;
        }
        return (fe2) invokeL.objValue;
    }

    public static String c(e43 e43Var, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, e43Var, str)) == null) {
            if (e43Var != null) {
                str2 = e43Var.c0(wh3.f(str));
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
