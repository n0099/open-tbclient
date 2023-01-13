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
public class xa2 {
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

    public xa2() {
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

    public static Map<String, String> a(xa2 xa2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, xa2Var)) == null) {
            TreeMap treeMap = new TreeMap();
            if (xa2Var == null) {
                return treeMap;
            }
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, xa2Var.a);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, xa2Var.b);
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, xa2Var.c);
            treeMap.put(PrefetchEvent.EVENT_KEY_PAGE_URL, xa2Var.d);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, xa2Var.f);
            treeMap.put("root", xa2Var.g);
            if (!TextUtils.isEmpty(xa2Var.e)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, xa2Var.e);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(xa2Var.h));
            treeMap.put("pageType", xa2Var.i);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(xa2Var.j));
            if (!TextUtils.isEmpty(xa2Var.k)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, xa2Var.k);
            }
            h03.a(treeMap, "app ready event");
            b83.a(xa2Var.d, treeMap);
            if (n32.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (ha3.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (ha3.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            treeMap.put("slaveReady", String.valueOf(xa2Var.l));
            if (!TextUtils.isEmpty(xa2Var.m)) {
                treeMap.put(PrefetchEvent.EVENT_USER_ACTION_APIS, xa2Var.m);
            }
            return treeMap;
        }
        return (Map) invokeL.objValue;
    }

    public static ke2 b(xa2 xa2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, xa2Var)) == null) {
            Map<String, String> a = a(xa2Var);
            ke2 ke2Var = new ke2("AppReady", a);
            PrefetchEvent.c createFromAppReadyEvent = PrefetchEvent.createFromAppReadyEvent(a);
            if (createFromAppReadyEvent == null) {
                return ke2Var;
            }
            za2 za2Var = new za2();
            za2Var.t(createFromAppReadyEvent);
            za2Var.t(ke2Var);
            return za2Var;
        }
        return (ke2) invokeL.objValue;
    }

    public static String c(j43 j43Var, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, j43Var, str)) == null) {
            if (j43Var != null) {
                str2 = j43Var.c0(bi3.f(str));
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
