package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.TreeMap;
/* loaded from: classes5.dex */
public final class me2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean n;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public boolean g;
    public String h;
    public boolean i;
    public String j;
    public String k;
    public String l;
    public boolean m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947969711, "Lcom/baidu/tieba/me2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947969711, "Lcom/baidu/tieba/me2;");
                return;
            }
        }
        n = fo1.a;
    }

    public me2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static wh2 a(me2 me2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, me2Var)) == null) {
            TreeMap treeMap = new TreeMap();
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, me2Var.a);
            treeMap.put("pagePath", me2Var.b);
            treeMap.put("pageType", me2Var.c);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, me2Var.e);
            if (!TextUtils.isEmpty(me2Var.f)) {
                if (n) {
                    Log.d("PageReadyEvent", "add initData: " + me2Var.f);
                }
                treeMap.put("initData", me2Var.f);
            }
            if (!TextUtils.isEmpty(me2Var.d)) {
                treeMap.put("onReachBottomDistance", me2Var.d);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(me2Var.g));
            if (!TextUtils.isEmpty(me2Var.h)) {
                treeMap.put("routeId", me2Var.h);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(me2Var.i));
            if (!TextUtils.isEmpty(me2Var.j)) {
                treeMap.put("slavePreload", me2Var.j);
            }
            treeMap.put("root", me2Var.k);
            t33.a(treeMap, "page ready event");
            nb3.a(me2Var.b, treeMap);
            String f = nl3.f(nb3.b(me2Var.b));
            v42.k("PageReadyEvent", "#createPageReadyMessage pagePath=" + ((String) treeMap.get("pagePath")));
            String c = f83.c(me2Var.a, f);
            me2Var.l = c;
            if (!TextUtils.isEmpty(c)) {
                treeMap.put("pageConfig", me2Var.l);
            }
            r92 W = pe2.U().W();
            if (W != null) {
                treeMap.put("masterId", W.a());
            }
            if (me2Var.m) {
                treeMap.put("isFirstPage", "true");
            }
            if (z62.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (td3.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (td3.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            return new wh2("PageReady", treeMap);
        }
        return (wh2) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "PageReadyEvent{appPath='" + this.a + "', pagePath='" + this.b + "', pageType='" + this.c + "', onReachBottomDistance='" + this.d + "', sConsole='" + this.e + "', initData='" + this.f + "', showPerformancePanel=" + this.g + ", routeId='" + this.h + "', isT7Available=" + this.i + ", preloadFile='" + this.j + "', rootPath='" + this.k + "', pageConfig='" + this.l + "'}";
        }
        return (String) invokeV.objValue;
    }
}
