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
public final class ph2 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948061967, "Lcom/baidu/tieba/ph2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948061967, "Lcom/baidu/tieba/ph2;");
                return;
            }
        }
        n = ir1.a;
    }

    public ph2() {
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

    public static zk2 a(ph2 ph2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ph2Var)) == null) {
            TreeMap treeMap = new TreeMap();
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, ph2Var.a);
            treeMap.put("pagePath", ph2Var.b);
            treeMap.put("pageType", ph2Var.c);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, ph2Var.e);
            if (!TextUtils.isEmpty(ph2Var.f)) {
                if (n) {
                    Log.d("PageReadyEvent", "add initData: " + ph2Var.f);
                }
                treeMap.put("initData", ph2Var.f);
            }
            if (!TextUtils.isEmpty(ph2Var.d)) {
                treeMap.put("onReachBottomDistance", ph2Var.d);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(ph2Var.g));
            if (!TextUtils.isEmpty(ph2Var.h)) {
                treeMap.put("routeId", ph2Var.h);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(ph2Var.i));
            if (!TextUtils.isEmpty(ph2Var.j)) {
                treeMap.put("slavePreload", ph2Var.j);
            }
            treeMap.put("root", ph2Var.k);
            w63.a(treeMap, "page ready event");
            qe3.a(ph2Var.b, treeMap);
            String f = qo3.f(qe3.b(ph2Var.b));
            y72.k("PageReadyEvent", "#createPageReadyMessage pagePath=" + ((String) treeMap.get("pagePath")));
            String c = ib3.c(ph2Var.a, f);
            ph2Var.l = c;
            if (!TextUtils.isEmpty(c)) {
                treeMap.put("pageConfig", ph2Var.l);
            }
            uc2 W = sh2.U().W();
            if (W != null) {
                treeMap.put("masterId", W.a());
            }
            if (ph2Var.m) {
                treeMap.put("isFirstPage", YYOption.IsLive.VALUE_TRUE);
            }
            if (ca2.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (wg3.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (wg3.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            return new zk2("PageReady", treeMap);
        }
        return (zk2) invokeL.objValue;
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
