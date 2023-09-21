package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.searchbox.player.model.YYOption;
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
public final class xh2 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948300295, "Lcom/baidu/tieba/xh2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948300295, "Lcom/baidu/tieba/xh2;");
                return;
            }
        }
        n = qr1.a;
    }

    public xh2() {
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

    public static hl2 a(xh2 xh2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, xh2Var)) == null) {
            TreeMap treeMap = new TreeMap();
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, xh2Var.a);
            treeMap.put("pagePath", xh2Var.b);
            treeMap.put("pageType", xh2Var.c);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, xh2Var.e);
            if (!TextUtils.isEmpty(xh2Var.f)) {
                if (n) {
                    Log.d("PageReadyEvent", "add initData: " + xh2Var.f);
                }
                treeMap.put("initData", xh2Var.f);
            }
            if (!TextUtils.isEmpty(xh2Var.d)) {
                treeMap.put("onReachBottomDistance", xh2Var.d);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(xh2Var.g));
            if (!TextUtils.isEmpty(xh2Var.h)) {
                treeMap.put("routeId", xh2Var.h);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(xh2Var.i));
            if (!TextUtils.isEmpty(xh2Var.j)) {
                treeMap.put("slavePreload", xh2Var.j);
            }
            treeMap.put("root", xh2Var.k);
            e73.a(treeMap, "page ready event");
            ye3.a(xh2Var.b, treeMap);
            String f = yo3.f(ye3.b(xh2Var.b));
            g82.k("PageReadyEvent", "#createPageReadyMessage pagePath=" + ((String) treeMap.get("pagePath")));
            String c = qb3.c(xh2Var.a, f);
            xh2Var.l = c;
            if (!TextUtils.isEmpty(c)) {
                treeMap.put("pageConfig", xh2Var.l);
            }
            cd2 W = ai2.U().W();
            if (W != null) {
                treeMap.put("masterId", W.a());
            }
            if (xh2Var.m) {
                treeMap.put("isFirstPage", YYOption.IsLive.VALUE_TRUE);
            }
            if (ka2.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (eh3.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (eh3.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            return new hl2("PageReady", treeMap);
        }
        return (hl2) invokeL.objValue;
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
