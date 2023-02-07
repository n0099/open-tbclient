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
public class kf2 {
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

    public kf2() {
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

    public static Map<String, String> a(kf2 kf2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, kf2Var)) == null) {
            TreeMap treeMap = new TreeMap();
            if (kf2Var == null) {
                return treeMap;
            }
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, kf2Var.a);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, kf2Var.b);
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, kf2Var.c);
            treeMap.put(PrefetchEvent.EVENT_KEY_PAGE_URL, kf2Var.d);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, kf2Var.f);
            treeMap.put("root", kf2Var.g);
            if (!TextUtils.isEmpty(kf2Var.e)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, kf2Var.e);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(kf2Var.h));
            treeMap.put("pageType", kf2Var.i);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(kf2Var.j));
            if (!TextUtils.isEmpty(kf2Var.k)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, kf2Var.k);
            }
            u43.a(treeMap, "app ready event");
            oc3.a(kf2Var.d, treeMap);
            if (a82.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (ue3.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (ue3.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            treeMap.put("slaveReady", String.valueOf(kf2Var.l));
            if (!TextUtils.isEmpty(kf2Var.m)) {
                treeMap.put(PrefetchEvent.EVENT_USER_ACTION_APIS, kf2Var.m);
            }
            return treeMap;
        }
        return (Map) invokeL.objValue;
    }

    public static xi2 b(kf2 kf2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, kf2Var)) == null) {
            Map<String, String> a = a(kf2Var);
            xi2 xi2Var = new xi2("AppReady", a);
            PrefetchEvent.c createFromAppReadyEvent = PrefetchEvent.createFromAppReadyEvent(a);
            if (createFromAppReadyEvent == null) {
                return xi2Var;
            }
            mf2 mf2Var = new mf2();
            mf2Var.t(createFromAppReadyEvent);
            mf2Var.t(xi2Var);
            return mf2Var;
        }
        return (xi2) invokeL.objValue;
    }

    public static String c(w83 w83Var, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, w83Var, str)) == null) {
            if (w83Var != null) {
                str2 = w83Var.c0(om3.f(str));
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
