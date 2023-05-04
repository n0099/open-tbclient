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
public final class oe2 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948029293, "Lcom/baidu/tieba/oe2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948029293, "Lcom/baidu/tieba/oe2;");
                return;
            }
        }
        n = ho1.a;
    }

    public oe2() {
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

    public static yh2 a(oe2 oe2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, oe2Var)) == null) {
            TreeMap treeMap = new TreeMap();
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, oe2Var.a);
            treeMap.put("pagePath", oe2Var.b);
            treeMap.put("pageType", oe2Var.c);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, oe2Var.e);
            if (!TextUtils.isEmpty(oe2Var.f)) {
                if (n) {
                    Log.d("PageReadyEvent", "add initData: " + oe2Var.f);
                }
                treeMap.put("initData", oe2Var.f);
            }
            if (!TextUtils.isEmpty(oe2Var.d)) {
                treeMap.put("onReachBottomDistance", oe2Var.d);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(oe2Var.g));
            if (!TextUtils.isEmpty(oe2Var.h)) {
                treeMap.put("routeId", oe2Var.h);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(oe2Var.i));
            if (!TextUtils.isEmpty(oe2Var.j)) {
                treeMap.put("slavePreload", oe2Var.j);
            }
            treeMap.put("root", oe2Var.k);
            v33.a(treeMap, "page ready event");
            pb3.a(oe2Var.b, treeMap);
            String f = pl3.f(pb3.b(oe2Var.b));
            x42.k("PageReadyEvent", "#createPageReadyMessage pagePath=" + ((String) treeMap.get("pagePath")));
            String c = h83.c(oe2Var.a, f);
            oe2Var.l = c;
            if (!TextUtils.isEmpty(c)) {
                treeMap.put("pageConfig", oe2Var.l);
            }
            t92 W = re2.U().W();
            if (W != null) {
                treeMap.put("masterId", W.a());
            }
            if (oe2Var.m) {
                treeMap.put("isFirstPage", "true");
            }
            if (b72.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (vd3.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (vd3.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            return new yh2("PageReady", treeMap);
        }
        return (yh2) invokeL.objValue;
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
