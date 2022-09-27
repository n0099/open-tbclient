package com.baidu.tieba;

import android.util.Log;
import com.baidu.searchbox.v8engine.console.DebugConsole;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class sz3 implements DebugConsole {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948168669, "Lcom/baidu/tieba/sz3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948168669, "Lcom/baidu/tieba/sz3;");
                return;
            }
        }
        b = vj1.a;
    }

    public sz3() {
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

    @Override // com.baidu.searchbox.v8engine.console.DebugConsole
    public void onReceiveInfo(int i, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) && b && !i44.d()) {
            if (i == 0) {
                Log.d("arConsole", String.format("%s: %s %s", "queue event", "", str));
            } else if (i == 1) {
                this.a = System.currentTimeMillis();
                Log.d("arConsole", String.format("%s: %s %s", "run event start", "", str));
            } else if (i != 2) {
            } else {
                Log.d("arConsole", String.format("%s: %s %s", "run event end", Long.valueOf(System.currentTimeMillis() - this.a), str));
            }
        }
    }
}
