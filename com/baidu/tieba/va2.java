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
public final class va2 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948233986, "Lcom/baidu/tieba/va2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948233986, "Lcom/baidu/tieba/va2;");
                return;
            }
        }
        n = ok1.a;
    }

    public va2() {
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

    public static fe2 a(va2 va2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, va2Var)) == null) {
            TreeMap treeMap = new TreeMap();
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, va2Var.a);
            treeMap.put("pagePath", va2Var.b);
            treeMap.put("pageType", va2Var.c);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, va2Var.e);
            if (!TextUtils.isEmpty(va2Var.f)) {
                if (n) {
                    Log.d("PageReadyEvent", "add initData: " + va2Var.f);
                }
                treeMap.put("initData", va2Var.f);
            }
            if (!TextUtils.isEmpty(va2Var.d)) {
                treeMap.put("onReachBottomDistance", va2Var.d);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(va2Var.g));
            if (!TextUtils.isEmpty(va2Var.h)) {
                treeMap.put("routeId", va2Var.h);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(va2Var.i));
            if (!TextUtils.isEmpty(va2Var.j)) {
                treeMap.put("slavePreload", va2Var.j);
            }
            treeMap.put("root", va2Var.k);
            c03.a(treeMap, "page ready event");
            w73.a(va2Var.b, treeMap);
            String f = wh3.f(w73.b(va2Var.b));
            e12.k("PageReadyEvent", "#createPageReadyMessage pagePath=" + ((String) treeMap.get("pagePath")));
            String c = o43.c(va2Var.a, f);
            va2Var.l = c;
            if (!TextUtils.isEmpty(c)) {
                treeMap.put("pageConfig", va2Var.l);
            }
            a62 W = ya2.U().W();
            if (W != null) {
                treeMap.put("masterId", W.a());
            }
            if (va2Var.m) {
                treeMap.put("isFirstPage", "true");
            }
            if (i32.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (ca3.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (ca3.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            return new fe2("PageReady", treeMap);
        }
        return (fe2) invokeL.objValue;
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
