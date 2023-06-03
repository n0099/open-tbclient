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
/* loaded from: classes7.dex */
public final class pi2 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948062928, "Lcom/baidu/tieba/pi2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948062928, "Lcom/baidu/tieba/pi2;");
                return;
            }
        }
        n = is1.a;
    }

    public pi2() {
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

    public static zl2 a(pi2 pi2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, pi2Var)) == null) {
            TreeMap treeMap = new TreeMap();
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, pi2Var.a);
            treeMap.put("pagePath", pi2Var.b);
            treeMap.put("pageType", pi2Var.c);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, pi2Var.e);
            if (!TextUtils.isEmpty(pi2Var.f)) {
                if (n) {
                    Log.d("PageReadyEvent", "add initData: " + pi2Var.f);
                }
                treeMap.put("initData", pi2Var.f);
            }
            if (!TextUtils.isEmpty(pi2Var.d)) {
                treeMap.put("onReachBottomDistance", pi2Var.d);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(pi2Var.g));
            if (!TextUtils.isEmpty(pi2Var.h)) {
                treeMap.put("routeId", pi2Var.h);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(pi2Var.i));
            if (!TextUtils.isEmpty(pi2Var.j)) {
                treeMap.put("slavePreload", pi2Var.j);
            }
            treeMap.put("root", pi2Var.k);
            w73.a(treeMap, "page ready event");
            qf3.a(pi2Var.b, treeMap);
            String f = qp3.f(qf3.b(pi2Var.b));
            y82.k("PageReadyEvent", "#createPageReadyMessage pagePath=" + ((String) treeMap.get("pagePath")));
            String c = ic3.c(pi2Var.a, f);
            pi2Var.l = c;
            if (!TextUtils.isEmpty(c)) {
                treeMap.put("pageConfig", pi2Var.l);
            }
            ud2 W = si2.U().W();
            if (W != null) {
                treeMap.put("masterId", W.a());
            }
            if (pi2Var.m) {
                treeMap.put("isFirstPage", YYOption.IsLive.VALUE_TRUE);
            }
            if (cb2.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (wh3.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (wh3.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            return new zl2("PageReady", treeMap);
        }
        return (zl2) invokeL.objValue;
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
