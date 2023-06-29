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
public final class ti2 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948182092, "Lcom/baidu/tieba/ti2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948182092, "Lcom/baidu/tieba/ti2;");
                return;
            }
        }
        n = ms1.a;
    }

    public ti2() {
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

    public static dm2 a(ti2 ti2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ti2Var)) == null) {
            TreeMap treeMap = new TreeMap();
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, ti2Var.a);
            treeMap.put("pagePath", ti2Var.b);
            treeMap.put("pageType", ti2Var.c);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, ti2Var.e);
            if (!TextUtils.isEmpty(ti2Var.f)) {
                if (n) {
                    Log.d("PageReadyEvent", "add initData: " + ti2Var.f);
                }
                treeMap.put("initData", ti2Var.f);
            }
            if (!TextUtils.isEmpty(ti2Var.d)) {
                treeMap.put("onReachBottomDistance", ti2Var.d);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(ti2Var.g));
            if (!TextUtils.isEmpty(ti2Var.h)) {
                treeMap.put("routeId", ti2Var.h);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(ti2Var.i));
            if (!TextUtils.isEmpty(ti2Var.j)) {
                treeMap.put("slavePreload", ti2Var.j);
            }
            treeMap.put("root", ti2Var.k);
            a83.a(treeMap, "page ready event");
            uf3.a(ti2Var.b, treeMap);
            String f = up3.f(uf3.b(ti2Var.b));
            c92.k("PageReadyEvent", "#createPageReadyMessage pagePath=" + ((String) treeMap.get("pagePath")));
            String c = mc3.c(ti2Var.a, f);
            ti2Var.l = c;
            if (!TextUtils.isEmpty(c)) {
                treeMap.put("pageConfig", ti2Var.l);
            }
            yd2 W = wi2.U().W();
            if (W != null) {
                treeMap.put("masterId", W.a());
            }
            if (ti2Var.m) {
                treeMap.put("isFirstPage", YYOption.IsLive.VALUE_TRUE);
            }
            if (gb2.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (ai3.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (ai3.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            return new dm2("PageReady", treeMap);
        }
        return (dm2) invokeL.objValue;
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
