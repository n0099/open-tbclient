package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class s32 implements r32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, d53> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948100407, "Lcom/baidu/tieba/s32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948100407, "Lcom/baidu/tieba/s32;");
                return;
            }
        }
        b = fs1.a;
    }

    public s32() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new ConcurrentHashMap();
    }

    @Override // com.baidu.tieba.r32
    public void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || this.a.containsKey(str)) {
            return;
        }
        if (b) {
            Log.d("Api-FirstRecorder", "markStart: " + str);
        }
        d53 d53Var = new d53();
        this.a.put(str, d53Var);
        d53Var.i(System.currentTimeMillis());
        d53Var.f(str);
    }

    @Override // com.baidu.tieba.r32
    @SuppressLint({"BDThrowableCheck"})
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            d53 d53Var = this.a.get(str);
            if (d53Var == null) {
                if (!b) {
                    return;
                }
                throw new RuntimeException(str + " markEnd before markStart");
            } else if (d53Var.d() > 0) {
            } else {
                d53Var.h(System.currentTimeMillis());
                if (b) {
                    Log.d("Api-FirstRecorder", str + " first called cost " + d53Var.c());
                }
                if (TextUtils.equals(str, "request")) {
                    if (b) {
                        Log.d("Api-FirstRecorder", "record first request api called " + d53Var.toString());
                    }
                    HybridUbcFlow p = a53.p("startup");
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("first_request_api_call_start");
                    ubcFlowEvent.h(d53Var.e());
                    p.F(ubcFlowEvent);
                    UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("first_request_api_call_end");
                    ubcFlowEvent2.h(d53Var.d());
                    p.F(ubcFlowEvent2);
                }
            }
        }
    }
}
