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
public class qi2 {
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

    public qi2() {
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

    public static Map<String, String> a(qi2 qi2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, qi2Var)) == null) {
            TreeMap treeMap = new TreeMap();
            if (qi2Var == null) {
                return treeMap;
            }
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, qi2Var.a);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, qi2Var.b);
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, qi2Var.c);
            treeMap.put(PrefetchEvent.EVENT_KEY_PAGE_URL, qi2Var.d);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, qi2Var.f);
            treeMap.put("root", qi2Var.g);
            if (!TextUtils.isEmpty(qi2Var.e)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, qi2Var.e);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(qi2Var.h));
            treeMap.put("pageType", qi2Var.i);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(qi2Var.j));
            if (!TextUtils.isEmpty(qi2Var.k)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, qi2Var.k);
            }
            a83.a(treeMap, "app ready event");
            uf3.a(qi2Var.d, treeMap);
            if (gb2.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (ai3.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (ai3.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            treeMap.put("slaveReady", String.valueOf(qi2Var.l));
            if (!TextUtils.isEmpty(qi2Var.m)) {
                treeMap.put(PrefetchEvent.EVENT_USER_ACTION_APIS, qi2Var.m);
            }
            return treeMap;
        }
        return (Map) invokeL.objValue;
    }

    public static dm2 b(qi2 qi2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, qi2Var)) == null) {
            Map<String, String> a = a(qi2Var);
            dm2 dm2Var = new dm2("AppReady", a);
            PrefetchEvent.c createFromAppReadyEvent = PrefetchEvent.createFromAppReadyEvent(a);
            if (createFromAppReadyEvent == null) {
                return dm2Var;
            }
            si2 si2Var = new si2();
            si2Var.t(createFromAppReadyEvent);
            si2Var.t(dm2Var);
            return si2Var;
        }
        return (dm2) invokeL.objValue;
    }

    public static String c(cc3 cc3Var, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, cc3Var, str)) == null) {
            if (cc3Var != null) {
                str2 = cc3Var.c0(up3.f(str));
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
