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
public class rh2 {
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

    public rh2() {
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

    public static Map<String, String> a(rh2 rh2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, rh2Var)) == null) {
            TreeMap treeMap = new TreeMap();
            if (rh2Var == null) {
                return treeMap;
            }
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, rh2Var.a);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, rh2Var.b);
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, rh2Var.c);
            treeMap.put(PrefetchEvent.EVENT_KEY_PAGE_URL, rh2Var.d);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, rh2Var.f);
            treeMap.put("root", rh2Var.g);
            if (!TextUtils.isEmpty(rh2Var.e)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, rh2Var.e);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(rh2Var.h));
            treeMap.put("pageType", rh2Var.i);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(rh2Var.j));
            if (!TextUtils.isEmpty(rh2Var.k)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, rh2Var.k);
            }
            b73.a(treeMap, "app ready event");
            ve3.a(rh2Var.d, treeMap);
            if (ha2.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (bh3.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (bh3.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            treeMap.put("slaveReady", String.valueOf(rh2Var.l));
            if (!TextUtils.isEmpty(rh2Var.m)) {
                treeMap.put(PrefetchEvent.EVENT_USER_ACTION_APIS, rh2Var.m);
            }
            return treeMap;
        }
        return (Map) invokeL.objValue;
    }

    public static el2 b(rh2 rh2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, rh2Var)) == null) {
            Map<String, String> a = a(rh2Var);
            el2 el2Var = new el2("AppReady", a);
            PrefetchEvent.c createFromAppReadyEvent = PrefetchEvent.createFromAppReadyEvent(a);
            if (createFromAppReadyEvent == null) {
                return el2Var;
            }
            th2 th2Var = new th2();
            th2Var.t(createFromAppReadyEvent);
            th2Var.t(el2Var);
            return th2Var;
        }
        return (el2) invokeL.objValue;
    }

    public static String c(db3 db3Var, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, db3Var, str)) == null) {
            if (db3Var != null) {
                str2 = db3Var.c0(vo3.f(str));
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
