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
public final class qi2 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948092719, "Lcom/baidu/tieba/qi2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948092719, "Lcom/baidu/tieba/qi2;");
                return;
            }
        }
        n = js1.a;
    }

    public qi2() {
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

    public static am2 a(qi2 qi2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, qi2Var)) == null) {
            TreeMap treeMap = new TreeMap();
            treeMap.put(PrefetchEvent.EVENT_KEY_APP_PATH, qi2Var.a);
            treeMap.put("pagePath", qi2Var.b);
            treeMap.put("pageType", qi2Var.c);
            treeMap.put(PrefetchEvent.EVENT_DATA_DEBUG_SCONSOLE, qi2Var.e);
            if (!TextUtils.isEmpty(qi2Var.f)) {
                if (n) {
                    Log.d("PageReadyEvent", "add initData: " + qi2Var.f);
                }
                treeMap.put("initData", qi2Var.f);
            }
            if (!TextUtils.isEmpty(qi2Var.d)) {
                treeMap.put("onReachBottomDistance", qi2Var.d);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_SHOW_PERFORMANCE_PANEL, String.valueOf(qi2Var.g));
            if (!TextUtils.isEmpty(qi2Var.h)) {
                treeMap.put("routeId", qi2Var.h);
            }
            treeMap.put(PrefetchEvent.EVENT_DATA_T7_AVAILABLE, String.valueOf(qi2Var.i));
            if (!TextUtils.isEmpty(qi2Var.j)) {
                treeMap.put("slavePreload", qi2Var.j);
            }
            treeMap.put("root", qi2Var.k);
            x73.a(treeMap, "page ready event");
            rf3.a(qi2Var.b, treeMap);
            String f = rp3.f(rf3.b(qi2Var.b));
            z82.k("PageReadyEvent", "#createPageReadyMessage pagePath=" + ((String) treeMap.get("pagePath")));
            String c = jc3.c(qi2Var.a, f);
            qi2Var.l = c;
            if (!TextUtils.isEmpty(c)) {
                treeMap.put("pageConfig", qi2Var.l);
            }
            vd2 W = ti2.U().W();
            if (W != null) {
                treeMap.put("masterId", W.a());
            }
            if (qi2Var.m) {
                treeMap.put("isFirstPage", YYOption.IsLive.VALUE_TRUE);
            }
            if (db2.c()) {
                treeMap.put("offlinePerfTool", String.valueOf(1));
            }
            if (xh3.d()) {
                treeMap.put("performanceType", CloudStabilityUBCUtils.VALUE_TYPE);
            }
            if (xh3.f()) {
                treeMap.put("performanceType", "stabilityProfile");
            }
            return new am2("PageReady", treeMap);
        }
        return (am2) invokeL.objValue;
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
