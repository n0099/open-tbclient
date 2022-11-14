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
/* loaded from: classes6.dex */
public final class wa2 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948263777, "Lcom/baidu/tieba/wa2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948263777, "Lcom/baidu/tieba/wa2;");
                return;
            }
        }
        n = pk1.a;
    }

    public wa2() {
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

    public static ge2 a(wa2 wa2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, wa2Var)) == null) {
            TreeMap treeMap = new TreeMap();
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, wa2Var.a);
            treeMap.put("pagePath", wa2Var.b);
            treeMap.put("pageType", wa2Var.c);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, wa2Var.e);
            if (!TextUtils.isEmpty(wa2Var.f)) {
                if (n) {
                    Log.d("PageReadyEvent", "add initData: " + wa2Var.f);
                }
                treeMap.put("initData", wa2Var.f);
            }
            if (!TextUtils.isEmpty(wa2Var.d)) {
                treeMap.put("onReachBottomDistance", wa2Var.d);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(wa2Var.g));
            if (!TextUtils.isEmpty(wa2Var.h)) {
                treeMap.put("routeId", wa2Var.h);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(wa2Var.i));
            if (!TextUtils.isEmpty(wa2Var.j)) {
                treeMap.put("slavePreload", wa2Var.j);
            }
            treeMap.put("root", wa2Var.k);
            d03.a(treeMap, "page ready event");
            x73.a(wa2Var.b, treeMap);
            String f = xh3.f(x73.b(wa2Var.b));
            f12.k("PageReadyEvent", "#createPageReadyMessage pagePath=" + ((String) treeMap.get("pagePath")));
            String c = p43.c(wa2Var.a, f);
            wa2Var.l = c;
            if (!TextUtils.isEmpty(c)) {
                treeMap.put("pageConfig", wa2Var.l);
            }
            b62 W = za2.U().W();
            if (W != null) {
                treeMap.put("masterId", W.a());
            }
            if (wa2Var.m) {
                treeMap.put("isFirstPage", "true");
            }
            if (j32.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (da3.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (da3.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            return new ge2("PageReady", treeMap);
        }
        return (ge2) invokeL.objValue;
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
