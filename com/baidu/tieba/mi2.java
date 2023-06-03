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
public class mi2 {
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

    public mi2() {
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

    public static Map<String, String> a(mi2 mi2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, mi2Var)) == null) {
            TreeMap treeMap = new TreeMap();
            if (mi2Var == null) {
                return treeMap;
            }
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, mi2Var.a);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, mi2Var.b);
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, mi2Var.c);
            treeMap.put(PrefetchEvent.EVENT_KEY_PAGE_URL, mi2Var.d);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, mi2Var.f);
            treeMap.put("root", mi2Var.g);
            if (!TextUtils.isEmpty(mi2Var.e)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, mi2Var.e);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(mi2Var.h));
            treeMap.put("pageType", mi2Var.i);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(mi2Var.j));
            if (!TextUtils.isEmpty(mi2Var.k)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, mi2Var.k);
            }
            w73.a(treeMap, "app ready event");
            qf3.a(mi2Var.d, treeMap);
            if (cb2.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (wh3.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (wh3.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            treeMap.put("slaveReady", String.valueOf(mi2Var.l));
            if (!TextUtils.isEmpty(mi2Var.m)) {
                treeMap.put(PrefetchEvent.EVENT_USER_ACTION_APIS, mi2Var.m);
            }
            return treeMap;
        }
        return (Map) invokeL.objValue;
    }

    public static zl2 b(mi2 mi2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, mi2Var)) == null) {
            Map<String, String> a = a(mi2Var);
            zl2 zl2Var = new zl2("AppReady", a);
            PrefetchEvent.c createFromAppReadyEvent = PrefetchEvent.createFromAppReadyEvent(a);
            if (createFromAppReadyEvent == null) {
                return zl2Var;
            }
            oi2 oi2Var = new oi2();
            oi2Var.t(createFromAppReadyEvent);
            oi2Var.t(zl2Var);
            return oi2Var;
        }
        return (zl2) invokeL.objValue;
    }

    public static String c(yb3 yb3Var, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, yb3Var, str)) == null) {
            if (yb3Var != null) {
                str2 = yb3Var.c0(qp3.f(str));
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
