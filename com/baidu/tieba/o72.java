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
public class o72 {
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

    public o72() {
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

    public static Map<String, String> a(o72 o72Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, o72Var)) == null) {
            TreeMap treeMap = new TreeMap();
            if (o72Var == null) {
                return treeMap;
            }
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, o72Var.a);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, o72Var.b);
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, o72Var.c);
            treeMap.put(PrefetchEvent.EVENT_KEY_PAGE_URL, o72Var.d);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, o72Var.f);
            treeMap.put("root", o72Var.g);
            if (!TextUtils.isEmpty(o72Var.e)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, o72Var.e);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(o72Var.h));
            treeMap.put("pageType", o72Var.i);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(o72Var.j));
            if (!TextUtils.isEmpty(o72Var.k)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, o72Var.k);
            }
            yw2.a(treeMap, "app ready event");
            s43.a(o72Var.d, treeMap);
            if (e02.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (y63.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (y63.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            treeMap.put("slaveReady", String.valueOf(o72Var.l));
            if (!TextUtils.isEmpty(o72Var.m)) {
                treeMap.put(PrefetchEvent.EVENT_USER_ACTION_APIS, o72Var.m);
            }
            return treeMap;
        }
        return (Map) invokeL.objValue;
    }

    public static bb2 b(o72 o72Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, o72Var)) == null) {
            Map<String, String> a = a(o72Var);
            bb2 bb2Var = new bb2("AppReady", a);
            PrefetchEvent.c createFromAppReadyEvent = PrefetchEvent.createFromAppReadyEvent(a);
            if (createFromAppReadyEvent == null) {
                return bb2Var;
            }
            q72 q72Var = new q72();
            q72Var.t(createFromAppReadyEvent);
            q72Var.t(bb2Var);
            return q72Var;
        }
        return (bb2) invokeL.objValue;
    }

    public static String c(a13 a13Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, a13Var, str)) == null) {
            String c0 = a13Var != null ? a13Var.c0(se3.f(str)) : null;
            return c0 == null ? "" : c0;
        }
        return (String) invokeLL.objValue;
    }
}
