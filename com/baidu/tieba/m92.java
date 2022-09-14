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
public class m92 {
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

    public m92() {
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

    public static Map<String, String> a(m92 m92Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, m92Var)) == null) {
            TreeMap treeMap = new TreeMap();
            if (m92Var == null) {
                return treeMap;
            }
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, m92Var.a);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, m92Var.b);
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, m92Var.c);
            treeMap.put(PrefetchEvent.EVENT_KEY_PAGE_URL, m92Var.d);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, m92Var.f);
            treeMap.put("root", m92Var.g);
            if (!TextUtils.isEmpty(m92Var.e)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, m92Var.e);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(m92Var.h));
            treeMap.put("pageType", m92Var.i);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(m92Var.j));
            if (!TextUtils.isEmpty(m92Var.k)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, m92Var.k);
            }
            wy2.a(treeMap, "app ready event");
            q63.a(m92Var.d, treeMap);
            if (c22.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (w83.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (w83.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            treeMap.put("slaveReady", String.valueOf(m92Var.l));
            if (!TextUtils.isEmpty(m92Var.m)) {
                treeMap.put(PrefetchEvent.EVENT_USER_ACTION_APIS, m92Var.m);
            }
            return treeMap;
        }
        return (Map) invokeL.objValue;
    }

    public static zc2 b(m92 m92Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, m92Var)) == null) {
            Map<String, String> a = a(m92Var);
            zc2 zc2Var = new zc2("AppReady", a);
            PrefetchEvent.c createFromAppReadyEvent = PrefetchEvent.createFromAppReadyEvent(a);
            if (createFromAppReadyEvent == null) {
                return zc2Var;
            }
            o92 o92Var = new o92();
            o92Var.t(createFromAppReadyEvent);
            o92Var.t(zc2Var);
            return o92Var;
        }
        return (zc2) invokeL.objValue;
    }

    public static String c(y23 y23Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, y23Var, str)) == null) {
            String c0 = y23Var != null ? y23Var.c0(qg3.f(str)) : null;
            return c0 == null ? "" : c0;
        }
        return (String) invokeLL.objValue;
    }
}
