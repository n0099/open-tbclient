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
public final class p92 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948016800, "Lcom/baidu/tieba/p92;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948016800, "Lcom/baidu/tieba/p92;");
                return;
            }
        }
        n = ij1.a;
    }

    public p92() {
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

    public static zc2 a(p92 p92Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, p92Var)) == null) {
            TreeMap treeMap = new TreeMap();
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, p92Var.a);
            treeMap.put("pagePath", p92Var.b);
            treeMap.put("pageType", p92Var.c);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, p92Var.e);
            if (!TextUtils.isEmpty(p92Var.f)) {
                if (n) {
                    Log.d("PageReadyEvent", "add initData: " + p92Var.f);
                }
                treeMap.put("initData", p92Var.f);
            }
            if (!TextUtils.isEmpty(p92Var.d)) {
                treeMap.put("onReachBottomDistance", p92Var.d);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(p92Var.g));
            if (!TextUtils.isEmpty(p92Var.h)) {
                treeMap.put("routeId", p92Var.h);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(p92Var.i));
            if (!TextUtils.isEmpty(p92Var.j)) {
                treeMap.put("slavePreload", p92Var.j);
            }
            treeMap.put("root", p92Var.k);
            wy2.a(treeMap, "page ready event");
            q63.a(p92Var.b, treeMap);
            String f = qg3.f(q63.b(p92Var.b));
            yz1.k("PageReadyEvent", "#createPageReadyMessage pagePath=" + ((String) treeMap.get("pagePath")));
            String c = i33.c(p92Var.a, f);
            p92Var.l = c;
            if (!TextUtils.isEmpty(c)) {
                treeMap.put("pageConfig", p92Var.l);
            }
            u42 W = s92.U().W();
            if (W != null) {
                treeMap.put("masterId", W.a());
            }
            if (p92Var.m) {
                treeMap.put("isFirstPage", "true");
            }
            if (c22.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (w83.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (w83.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            return new zc2("PageReady", treeMap);
        }
        return (zc2) invokeL.objValue;
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
