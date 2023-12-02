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
/* loaded from: classes9.dex */
public class yc2 {
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

    public yc2() {
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

    public static Map<String, String> a(yc2 yc2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, yc2Var)) == null) {
            TreeMap treeMap = new TreeMap();
            if (yc2Var == null) {
                return treeMap;
            }
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, yc2Var.a);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, yc2Var.b);
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, yc2Var.c);
            treeMap.put(PrefetchEvent.EVENT_KEY_PAGE_URL, yc2Var.d);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, yc2Var.f);
            treeMap.put("root", yc2Var.g);
            if (!TextUtils.isEmpty(yc2Var.e)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, yc2Var.e);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(yc2Var.h));
            treeMap.put("pageType", yc2Var.i);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(yc2Var.j));
            if (!TextUtils.isEmpty(yc2Var.k)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, yc2Var.k);
            }
            i23.a(treeMap, "app ready event");
            ca3.a(yc2Var.d, treeMap);
            if (o52.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (ic3.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (ic3.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            treeMap.put("slaveReady", String.valueOf(yc2Var.l));
            if (!TextUtils.isEmpty(yc2Var.m)) {
                treeMap.put(PrefetchEvent.EVENT_USER_ACTION_APIS, yc2Var.m);
            }
            return treeMap;
        }
        return (Map) invokeL.objValue;
    }

    public static lg2 b(yc2 yc2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, yc2Var)) == null) {
            Map<String, String> a = a(yc2Var);
            lg2 lg2Var = new lg2("AppReady", a);
            PrefetchEvent.c createFromAppReadyEvent = PrefetchEvent.createFromAppReadyEvent(a);
            if (createFromAppReadyEvent == null) {
                return lg2Var;
            }
            ad2 ad2Var = new ad2();
            ad2Var.t(createFromAppReadyEvent);
            ad2Var.t(lg2Var);
            return ad2Var;
        }
        return (lg2) invokeL.objValue;
    }

    public static String c(k63 k63Var, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, k63Var, str)) == null) {
            if (k63Var != null) {
                str2 = k63Var.d0(ck3.f(str));
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
