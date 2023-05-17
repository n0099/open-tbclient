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
/* loaded from: classes8.dex */
public final class xf2 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948298373, "Lcom/baidu/tieba/xf2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948298373, "Lcom/baidu/tieba/xf2;");
                return;
            }
        }
        n = qp1.a;
    }

    public xf2() {
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

    public static hj2 a(xf2 xf2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, xf2Var)) == null) {
            TreeMap treeMap = new TreeMap();
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, xf2Var.a);
            treeMap.put("pagePath", xf2Var.b);
            treeMap.put("pageType", xf2Var.c);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, xf2Var.e);
            if (!TextUtils.isEmpty(xf2Var.f)) {
                if (n) {
                    Log.d("PageReadyEvent", "add initData: " + xf2Var.f);
                }
                treeMap.put("initData", xf2Var.f);
            }
            if (!TextUtils.isEmpty(xf2Var.d)) {
                treeMap.put("onReachBottomDistance", xf2Var.d);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(xf2Var.g));
            if (!TextUtils.isEmpty(xf2Var.h)) {
                treeMap.put("routeId", xf2Var.h);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(xf2Var.i));
            if (!TextUtils.isEmpty(xf2Var.j)) {
                treeMap.put("slavePreload", xf2Var.j);
            }
            treeMap.put("root", xf2Var.k);
            e53.a(treeMap, "page ready event");
            yc3.a(xf2Var.b, treeMap);
            String f = ym3.f(yc3.b(xf2Var.b));
            g62.k("PageReadyEvent", "#createPageReadyMessage pagePath=" + ((String) treeMap.get("pagePath")));
            String c = q93.c(xf2Var.a, f);
            xf2Var.l = c;
            if (!TextUtils.isEmpty(c)) {
                treeMap.put("pageConfig", xf2Var.l);
            }
            cb2 W = ag2.U().W();
            if (W != null) {
                treeMap.put("masterId", W.a());
            }
            if (xf2Var.m) {
                treeMap.put("isFirstPage", "true");
            }
            if (k82.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (ef3.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (ef3.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            return new hj2("PageReady", treeMap);
        }
        return (hj2) invokeL.objValue;
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
