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
public class le2 {
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

    public le2() {
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

    public static Map<String, String> a(le2 le2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, le2Var)) == null) {
            TreeMap treeMap = new TreeMap();
            if (le2Var == null) {
                return treeMap;
            }
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, le2Var.a);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, le2Var.b);
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, le2Var.c);
            treeMap.put(PrefetchEvent.EVENT_KEY_PAGE_URL, le2Var.d);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, le2Var.f);
            treeMap.put("root", le2Var.g);
            if (!TextUtils.isEmpty(le2Var.e)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, le2Var.e);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(le2Var.h));
            treeMap.put("pageType", le2Var.i);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(le2Var.j));
            if (!TextUtils.isEmpty(le2Var.k)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, le2Var.k);
            }
            v33.a(treeMap, "app ready event");
            pb3.a(le2Var.d, treeMap);
            if (b72.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (vd3.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (vd3.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            treeMap.put("slaveReady", String.valueOf(le2Var.l));
            if (!TextUtils.isEmpty(le2Var.m)) {
                treeMap.put(PrefetchEvent.EVENT_USER_ACTION_APIS, le2Var.m);
            }
            return treeMap;
        }
        return (Map) invokeL.objValue;
    }

    public static yh2 b(le2 le2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, le2Var)) == null) {
            Map<String, String> a = a(le2Var);
            yh2 yh2Var = new yh2("AppReady", a);
            PrefetchEvent.c createFromAppReadyEvent = PrefetchEvent.createFromAppReadyEvent(a);
            if (createFromAppReadyEvent == null) {
                return yh2Var;
            }
            ne2 ne2Var = new ne2();
            ne2Var.t(createFromAppReadyEvent);
            ne2Var.t(yh2Var);
            return ne2Var;
        }
        return (yh2) invokeL.objValue;
    }

    public static String c(x73 x73Var, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, x73Var, str)) == null) {
            if (x73Var != null) {
                str2 = x73Var.c0(pl3.f(str));
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
