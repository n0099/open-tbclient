package com.baidu.tieba;

import android.util.Log;
import com.baidu.swan.apps.api.pending.queue.operation.BasePendingOperation;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class w22 extends u22 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948218610, "Lcom/baidu/tieba/w22;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948218610, "Lcom/baidu/tieba/w22;");
                return;
            }
        }
        b = rr1.a;
    }

    public w22() {
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

    @Override // com.baidu.tieba.v22
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (BasePendingOperation basePendingOperation : this.a) {
                if (b) {
                    Log.d("MainThreadOperation", "  *************** 【Execute pending module】:" + basePendingOperation.b() + " params:" + basePendingOperation.c());
                }
                bp3.e0(basePendingOperation);
            }
            this.a.clear();
        }
    }
}
