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
/* loaded from: classes8.dex */
public class z32 implements y32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, k53> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948308944, "Lcom/baidu/tieba/z32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948308944, "Lcom/baidu/tieba/z32;");
                return;
            }
        }
        b = ms1.a;
    }

    public z32() {
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

    @Override // com.baidu.tieba.y32
    public void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || this.a.containsKey(str)) {
            return;
        }
        if (b) {
            Log.d("Api-FirstRecorder", "markStart: " + str);
        }
        k53 k53Var = new k53();
        this.a.put(str, k53Var);
        k53Var.i(System.currentTimeMillis());
        k53Var.f(str);
    }

    @Override // com.baidu.tieba.y32
    @SuppressLint({"BDThrowableCheck"})
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            k53 k53Var = this.a.get(str);
            if (k53Var == null) {
                if (!b) {
                    return;
                }
                throw new RuntimeException(str + " markEnd before markStart");
            } else if (k53Var.d() > 0) {
            } else {
                k53Var.h(System.currentTimeMillis());
                if (b) {
                    Log.d("Api-FirstRecorder", str + " first called cost " + k53Var.c());
                }
                if (TextUtils.equals(str, "request")) {
                    if (b) {
                        Log.d("Api-FirstRecorder", "record first request api called " + k53Var.toString());
                    }
                    HybridUbcFlow p = h53.p("startup");
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("first_request_api_call_start");
                    ubcFlowEvent.h(k53Var.e());
                    p.F(ubcFlowEvent);
                    UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("first_request_api_call_end");
                    ubcFlowEvent2.h(k53Var.d());
                    p.F(ubcFlowEvent2);
                }
            }
        }
    }
}
