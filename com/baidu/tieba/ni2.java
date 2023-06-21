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
public class ni2 {
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

    public ni2() {
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

    public static Map<String, String> a(ni2 ni2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ni2Var)) == null) {
            TreeMap treeMap = new TreeMap();
            if (ni2Var == null) {
                return treeMap;
            }
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, ni2Var.a);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, ni2Var.b);
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, ni2Var.c);
            treeMap.put(PrefetchEvent.EVENT_KEY_PAGE_URL, ni2Var.d);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, ni2Var.f);
            treeMap.put("root", ni2Var.g);
            if (!TextUtils.isEmpty(ni2Var.e)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, ni2Var.e);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(ni2Var.h));
            treeMap.put("pageType", ni2Var.i);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(ni2Var.j));
            if (!TextUtils.isEmpty(ni2Var.k)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, ni2Var.k);
            }
            x73.a(treeMap, "app ready event");
            rf3.a(ni2Var.d, treeMap);
            if (db2.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (xh3.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (xh3.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            treeMap.put("slaveReady", String.valueOf(ni2Var.l));
            if (!TextUtils.isEmpty(ni2Var.m)) {
                treeMap.put(PrefetchEvent.EVENT_USER_ACTION_APIS, ni2Var.m);
            }
            return treeMap;
        }
        return (Map) invokeL.objValue;
    }

    public static am2 b(ni2 ni2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ni2Var)) == null) {
            Map<String, String> a = a(ni2Var);
            am2 am2Var = new am2("AppReady", a);
            PrefetchEvent.c createFromAppReadyEvent = PrefetchEvent.createFromAppReadyEvent(a);
            if (createFromAppReadyEvent == null) {
                return am2Var;
            }
            pi2 pi2Var = new pi2();
            pi2Var.t(createFromAppReadyEvent);
            pi2Var.t(am2Var);
            return pi2Var;
        }
        return (am2) invokeL.objValue;
    }

    public static String c(zb3 zb3Var, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, zb3Var, str)) == null) {
            if (zb3Var != null) {
                str2 = zb3Var.c0(rp3.f(str));
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
