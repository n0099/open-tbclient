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
public class vc2 {
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

    public vc2() {
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

    public static Map<String, String> a(vc2 vc2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, vc2Var)) == null) {
            TreeMap treeMap = new TreeMap();
            if (vc2Var == null) {
                return treeMap;
            }
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, vc2Var.a);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, vc2Var.b);
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, vc2Var.c);
            treeMap.put(PrefetchEvent.EVENT_KEY_PAGE_URL, vc2Var.d);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, vc2Var.f);
            treeMap.put("root", vc2Var.g);
            if (!TextUtils.isEmpty(vc2Var.e)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, vc2Var.e);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(vc2Var.h));
            treeMap.put("pageType", vc2Var.i);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(vc2Var.j));
            if (!TextUtils.isEmpty(vc2Var.k)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, vc2Var.k);
            }
            f23.a(treeMap, "app ready event");
            z93.a(vc2Var.d, treeMap);
            if (l52.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (fc3.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (fc3.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            treeMap.put("slaveReady", String.valueOf(vc2Var.l));
            if (!TextUtils.isEmpty(vc2Var.m)) {
                treeMap.put(PrefetchEvent.EVENT_USER_ACTION_APIS, vc2Var.m);
            }
            return treeMap;
        }
        return (Map) invokeL.objValue;
    }

    public static ig2 b(vc2 vc2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, vc2Var)) == null) {
            Map<String, String> a = a(vc2Var);
            ig2 ig2Var = new ig2("AppReady", a);
            PrefetchEvent.c createFromAppReadyEvent = PrefetchEvent.createFromAppReadyEvent(a);
            if (createFromAppReadyEvent == null) {
                return ig2Var;
            }
            xc2 xc2Var = new xc2();
            xc2Var.t(createFromAppReadyEvent);
            xc2Var.t(ig2Var);
            return xc2Var;
        }
        return (ig2) invokeL.objValue;
    }

    public static String c(h63 h63Var, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, h63Var, str)) == null) {
            if (h63Var != null) {
                str2 = h63Var.d0(zj3.f(str));
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
