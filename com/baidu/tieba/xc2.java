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
/* loaded from: classes9.dex */
public final class xc2 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948295490, "Lcom/baidu/tieba/xc2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948295490, "Lcom/baidu/tieba/xc2;");
                return;
            }
        }
        n = rm1.a;
    }

    public xc2() {
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

    public static hg2 a(xc2 xc2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, xc2Var)) == null) {
            TreeMap treeMap = new TreeMap();
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, xc2Var.a);
            treeMap.put("pagePath", xc2Var.b);
            treeMap.put("pageType", xc2Var.c);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, xc2Var.e);
            if (!TextUtils.isEmpty(xc2Var.f)) {
                if (n) {
                    Log.d("PageReadyEvent", "add initData: " + xc2Var.f);
                }
                treeMap.put("initData", xc2Var.f);
            }
            if (!TextUtils.isEmpty(xc2Var.d)) {
                treeMap.put("onReachBottomDistance", xc2Var.d);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(xc2Var.g));
            if (!TextUtils.isEmpty(xc2Var.h)) {
                treeMap.put("routeId", xc2Var.h);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(xc2Var.i));
            if (!TextUtils.isEmpty(xc2Var.j)) {
                treeMap.put("slavePreload", xc2Var.j);
            }
            treeMap.put("root", xc2Var.k);
            e23.a(treeMap, "page ready event");
            y93.a(xc2Var.b, treeMap);
            String f = yj3.f(y93.b(xc2Var.b));
            g32.k("PageReadyEvent", "#createPageReadyMessage pagePath=" + ((String) treeMap.get("pagePath")));
            String c = q63.c(xc2Var.a, f);
            xc2Var.l = c;
            if (!TextUtils.isEmpty(c)) {
                treeMap.put("pageConfig", xc2Var.l);
            }
            c82 X = ad2.V().X();
            if (X != null) {
                treeMap.put("masterId", X.a());
            }
            if (xc2Var.m) {
                treeMap.put("isFirstPage", YYOption.IsLive.VALUE_TRUE);
            }
            if (k52.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (ec3.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (ec3.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            return new hg2("PageReady", treeMap);
        }
        return (hg2) invokeL.objValue;
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
