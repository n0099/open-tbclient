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
public class ji2 {
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

    public ji2() {
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

    public static Map<String, String> a(ji2 ji2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ji2Var)) == null) {
            TreeMap treeMap = new TreeMap();
            if (ji2Var == null) {
                return treeMap;
            }
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, ji2Var.a);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, ji2Var.b);
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, ji2Var.c);
            treeMap.put(PrefetchEvent.EVENT_KEY_PAGE_URL, ji2Var.d);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, ji2Var.f);
            treeMap.put("root", ji2Var.g);
            if (!TextUtils.isEmpty(ji2Var.e)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, ji2Var.e);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(ji2Var.h));
            treeMap.put("pageType", ji2Var.i);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(ji2Var.j));
            if (!TextUtils.isEmpty(ji2Var.k)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, ji2Var.k);
            }
            t73.a(treeMap, "app ready event");
            nf3.a(ji2Var.d, treeMap);
            if (za2.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (th3.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (th3.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            treeMap.put("slaveReady", String.valueOf(ji2Var.l));
            if (!TextUtils.isEmpty(ji2Var.m)) {
                treeMap.put(PrefetchEvent.EVENT_USER_ACTION_APIS, ji2Var.m);
            }
            return treeMap;
        }
        return (Map) invokeL.objValue;
    }

    public static wl2 b(ji2 ji2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ji2Var)) == null) {
            Map<String, String> a = a(ji2Var);
            wl2 wl2Var = new wl2("AppReady", a);
            PrefetchEvent.c createFromAppReadyEvent = PrefetchEvent.createFromAppReadyEvent(a);
            if (createFromAppReadyEvent == null) {
                return wl2Var;
            }
            li2 li2Var = new li2();
            li2Var.t(createFromAppReadyEvent);
            li2Var.t(wl2Var);
            return li2Var;
        }
        return (wl2) invokeL.objValue;
    }

    public static String c(vb3 vb3Var, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, vb3Var, str)) == null) {
            if (vb3Var != null) {
                str2 = vb3Var.c0(np3.f(str));
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
