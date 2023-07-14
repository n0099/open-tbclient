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
public final class mi2 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947973555, "Lcom/baidu/tieba/mi2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947973555, "Lcom/baidu/tieba/mi2;");
                return;
            }
        }
        n = fs1.a;
    }

    public mi2() {
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

    public static wl2 a(mi2 mi2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, mi2Var)) == null) {
            TreeMap treeMap = new TreeMap();
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, mi2Var.a);
            treeMap.put("pagePath", mi2Var.b);
            treeMap.put("pageType", mi2Var.c);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, mi2Var.e);
            if (!TextUtils.isEmpty(mi2Var.f)) {
                if (n) {
                    Log.d("PageReadyEvent", "add initData: " + mi2Var.f);
                }
                treeMap.put("initData", mi2Var.f);
            }
            if (!TextUtils.isEmpty(mi2Var.d)) {
                treeMap.put("onReachBottomDistance", mi2Var.d);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(mi2Var.g));
            if (!TextUtils.isEmpty(mi2Var.h)) {
                treeMap.put("routeId", mi2Var.h);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(mi2Var.i));
            if (!TextUtils.isEmpty(mi2Var.j)) {
                treeMap.put("slavePreload", mi2Var.j);
            }
            treeMap.put("root", mi2Var.k);
            t73.a(treeMap, "page ready event");
            nf3.a(mi2Var.b, treeMap);
            String f = np3.f(nf3.b(mi2Var.b));
            v82.k("PageReadyEvent", "#createPageReadyMessage pagePath=" + ((String) treeMap.get("pagePath")));
            String c = fc3.c(mi2Var.a, f);
            mi2Var.l = c;
            if (!TextUtils.isEmpty(c)) {
                treeMap.put("pageConfig", mi2Var.l);
            }
            rd2 W = pi2.U().W();
            if (W != null) {
                treeMap.put("masterId", W.a());
            }
            if (mi2Var.m) {
                treeMap.put("isFirstPage", YYOption.IsLive.VALUE_TRUE);
            }
            if (za2.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (th3.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (th3.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            return new wl2("PageReady", treeMap);
        }
        return (wl2) invokeL.objValue;
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
