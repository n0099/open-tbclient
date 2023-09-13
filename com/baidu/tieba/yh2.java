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
public final class yh2 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948330086, "Lcom/baidu/tieba/yh2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948330086, "Lcom/baidu/tieba/yh2;");
                return;
            }
        }
        n = rr1.a;
    }

    public yh2() {
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

    public static il2 a(yh2 yh2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, yh2Var)) == null) {
            TreeMap treeMap = new TreeMap();
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, yh2Var.a);
            treeMap.put("pagePath", yh2Var.b);
            treeMap.put("pageType", yh2Var.c);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, yh2Var.e);
            if (!TextUtils.isEmpty(yh2Var.f)) {
                if (n) {
                    Log.d("PageReadyEvent", "add initData: " + yh2Var.f);
                }
                treeMap.put("initData", yh2Var.f);
            }
            if (!TextUtils.isEmpty(yh2Var.d)) {
                treeMap.put("onReachBottomDistance", yh2Var.d);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(yh2Var.g));
            if (!TextUtils.isEmpty(yh2Var.h)) {
                treeMap.put("routeId", yh2Var.h);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(yh2Var.i));
            if (!TextUtils.isEmpty(yh2Var.j)) {
                treeMap.put("slavePreload", yh2Var.j);
            }
            treeMap.put("root", yh2Var.k);
            f73.a(treeMap, "page ready event");
            ze3.a(yh2Var.b, treeMap);
            String f = zo3.f(ze3.b(yh2Var.b));
            h82.k("PageReadyEvent", "#createPageReadyMessage pagePath=" + ((String) treeMap.get("pagePath")));
            String c = rb3.c(yh2Var.a, f);
            yh2Var.l = c;
            if (!TextUtils.isEmpty(c)) {
                treeMap.put("pageConfig", yh2Var.l);
            }
            dd2 W = bi2.U().W();
            if (W != null) {
                treeMap.put("masterId", W.a());
            }
            if (yh2Var.m) {
                treeMap.put("isFirstPage", YYOption.IsLive.VALUE_TRUE);
            }
            if (la2.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (fh3.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (fh3.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            return new il2("PageReady", treeMap);
        }
        return (il2) invokeL.objValue;
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
