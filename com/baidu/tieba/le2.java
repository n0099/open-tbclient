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
public final class le2 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947939920, "Lcom/baidu/tieba/le2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947939920, "Lcom/baidu/tieba/le2;");
                return;
            }
        }
        n = eo1.a;
    }

    public le2() {
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

    public static vh2 a(le2 le2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, le2Var)) == null) {
            TreeMap treeMap = new TreeMap();
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, le2Var.a);
            treeMap.put("pagePath", le2Var.b);
            treeMap.put("pageType", le2Var.c);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, le2Var.e);
            if (!TextUtils.isEmpty(le2Var.f)) {
                if (n) {
                    Log.d("PageReadyEvent", "add initData: " + le2Var.f);
                }
                treeMap.put("initData", le2Var.f);
            }
            if (!TextUtils.isEmpty(le2Var.d)) {
                treeMap.put("onReachBottomDistance", le2Var.d);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(le2Var.g));
            if (!TextUtils.isEmpty(le2Var.h)) {
                treeMap.put("routeId", le2Var.h);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(le2Var.i));
            if (!TextUtils.isEmpty(le2Var.j)) {
                treeMap.put("slavePreload", le2Var.j);
            }
            treeMap.put("root", le2Var.k);
            s33.a(treeMap, "page ready event");
            mb3.a(le2Var.b, treeMap);
            String f = ml3.f(mb3.b(le2Var.b));
            u42.k("PageReadyEvent", "#createPageReadyMessage pagePath=" + ((String) treeMap.get("pagePath")));
            String c = e83.c(le2Var.a, f);
            le2Var.l = c;
            if (!TextUtils.isEmpty(c)) {
                treeMap.put("pageConfig", le2Var.l);
            }
            q92 W = oe2.U().W();
            if (W != null) {
                treeMap.put("masterId", W.a());
            }
            if (le2Var.m) {
                treeMap.put("isFirstPage", "true");
            }
            if (y62.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (sd3.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (sd3.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            return new vh2("PageReady", treeMap);
        }
        return (vh2) invokeL.objValue;
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
