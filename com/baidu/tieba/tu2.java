package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.tieba.ex2;
import com.baidu.tieba.wu2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.nio.channels.Pipe;
/* loaded from: classes7.dex */
public class tu2 extends wu2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;
    public final qj4 e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948193624, "Lcom/baidu/tieba/tu2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948193624, "Lcom/baidu/tieba/tu2;");
                return;
            }
        }
        f = is1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tu2(String str, qj4 qj4Var) {
        super("check_sign");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, qj4Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = str;
        this.e = qj4Var;
    }

    @Override // com.baidu.tieba.wu2.f
    public boolean g(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        rn3 rn3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, sourceChannel, bundle)) == null) {
            dx2 d = dx2.d(bundle.getString("launch_id"));
            ex2.b e = d.e();
            e.b("SignChecker");
            boolean z = true;
            e.d(1);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                try {
                    rn3Var = qf2.a(sourceChannel, this.d, this.e);
                } catch (IOException e2) {
                    if (f) {
                        e2.printStackTrace();
                    }
                    rn3 rn3Var2 = new rn3();
                    rn3Var2.k(11L);
                    rn3Var2.i(2300L);
                    rn3Var2.f("inputStream IOException:" + e2.toString());
                    vn3.a().f(rn3Var2);
                    d.g("SignChecker", rn3Var2.toString());
                    lq3.a(sourceChannel);
                    rn3Var = rn3Var2;
                }
                d.g("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
                if (rn3Var != null) {
                    z = false;
                }
                if (rn3Var != null) {
                    d.g("SignChecker", rn3Var.toString());
                    c().putLong("result_error_code", rn3Var.a());
                }
                d.g("SignChecker", "done: " + z);
                return z;
            } finally {
                lq3.a(sourceChannel);
            }
        }
        return invokeLL.booleanValue;
    }
}
