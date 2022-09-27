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
public class z92 {
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

    public z92() {
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

    public static Map<String, String> a(z92 z92Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, z92Var)) == null) {
            TreeMap treeMap = new TreeMap();
            if (z92Var == null) {
                return treeMap;
            }
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, z92Var.a);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, z92Var.b);
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, z92Var.c);
            treeMap.put(PrefetchEvent.EVENT_KEY_PAGE_URL, z92Var.d);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, z92Var.f);
            treeMap.put("root", z92Var.g);
            if (!TextUtils.isEmpty(z92Var.e)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, z92Var.e);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(z92Var.h));
            treeMap.put("pageType", z92Var.i);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(z92Var.j));
            if (!TextUtils.isEmpty(z92Var.k)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, z92Var.k);
            }
            jz2.a(treeMap, "app ready event");
            d73.a(z92Var.d, treeMap);
            if (p22.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (j93.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (j93.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            treeMap.put("slaveReady", String.valueOf(z92Var.l));
            if (!TextUtils.isEmpty(z92Var.m)) {
                treeMap.put(PrefetchEvent.EVENT_USER_ACTION_APIS, z92Var.m);
            }
            return treeMap;
        }
        return (Map) invokeL.objValue;
    }

    public static md2 b(z92 z92Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, z92Var)) == null) {
            Map<String, String> a = a(z92Var);
            md2 md2Var = new md2("AppReady", a);
            PrefetchEvent.c createFromAppReadyEvent = PrefetchEvent.createFromAppReadyEvent(a);
            if (createFromAppReadyEvent == null) {
                return md2Var;
            }
            ba2 ba2Var = new ba2();
            ba2Var.t(createFromAppReadyEvent);
            ba2Var.t(md2Var);
            return ba2Var;
        }
        return (md2) invokeL.objValue;
    }

    public static String c(l33 l33Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, l33Var, str)) == null) {
            String c0 = l33Var != null ? l33Var.c0(dh3.f(str)) : null;
            return c0 == null ? "" : c0;
        }
        return (String) invokeLL.objValue;
    }
}
