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
public class mh2 {
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

    public mh2() {
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

    public static Map<String, String> a(mh2 mh2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, mh2Var)) == null) {
            TreeMap treeMap = new TreeMap();
            if (mh2Var == null) {
                return treeMap;
            }
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_CONFIG, mh2Var.a);
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, mh2Var.b);
            treeMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, mh2Var.c);
            treeMap.put(PrefetchEvent.EVENT_KEY_PAGE_URL, mh2Var.d);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, mh2Var.f);
            treeMap.put("root", mh2Var.g);
            if (!TextUtils.isEmpty(mh2Var.e)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, mh2Var.e);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(mh2Var.h));
            treeMap.put("pageType", mh2Var.i);
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(mh2Var.j));
            if (!TextUtils.isEmpty(mh2Var.k)) {
                treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, mh2Var.k);
            }
            w63.a(treeMap, "app ready event");
            qe3.a(mh2Var.d, treeMap);
            if (ca2.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (wg3.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (wg3.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            treeMap.put("slaveReady", String.valueOf(mh2Var.l));
            if (!TextUtils.isEmpty(mh2Var.m)) {
                treeMap.put(PrefetchEvent.EVENT_USER_ACTION_APIS, mh2Var.m);
            }
            return treeMap;
        }
        return (Map) invokeL.objValue;
    }

    public static zk2 b(mh2 mh2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, mh2Var)) == null) {
            Map<String, String> a = a(mh2Var);
            zk2 zk2Var = new zk2("AppReady", a);
            PrefetchEvent.c createFromAppReadyEvent = PrefetchEvent.createFromAppReadyEvent(a);
            if (createFromAppReadyEvent == null) {
                return zk2Var;
            }
            oh2 oh2Var = new oh2();
            oh2Var.t(createFromAppReadyEvent);
            oh2Var.t(zk2Var);
            return oh2Var;
        }
        return (zk2) invokeL.objValue;
    }

    public static String c(ya3 ya3Var, String str) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, ya3Var, str)) == null) {
            if (ya3Var != null) {
                str2 = ya3Var.c0(qo3.f(str));
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
