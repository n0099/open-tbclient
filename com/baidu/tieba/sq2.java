package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.tieba.dt2;
import com.baidu.tieba.vq2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.nio.channels.Pipe;
/* loaded from: classes6.dex */
public class sq2 extends vq2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;
    public final pf4 e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948159989, "Lcom/baidu/tieba/sq2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948159989, "Lcom/baidu/tieba/sq2;");
                return;
            }
        }
        f = ho1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sq2(String str, pf4 pf4Var) {
        super("check_sign");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, pf4Var};
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
        this.e = pf4Var;
    }

    @Override // com.baidu.tieba.vq2.f
    public boolean g(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        qj3 qj3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, sourceChannel, bundle)) == null) {
            ct2 d = ct2.d(bundle.getString("launch_id"));
            dt2.b e = d.e();
            e.b("SignChecker");
            boolean z = true;
            e.d(1);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                try {
                    qj3Var = pb2.a(sourceChannel, this.d, this.e);
                } catch (IOException e2) {
                    if (f) {
                        e2.printStackTrace();
                    }
                    qj3 qj3Var2 = new qj3();
                    qj3Var2.k(11L);
                    qj3Var2.i(2300L);
                    qj3Var2.f("inputStream IOException:" + e2.toString());
                    uj3.a().f(qj3Var2);
                    d.g("SignChecker", qj3Var2.toString());
                    km3.a(sourceChannel);
                    qj3Var = qj3Var2;
                }
                d.g("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
                if (qj3Var != null) {
                    z = false;
                }
                if (qj3Var != null) {
                    d.g("SignChecker", qj3Var.toString());
                    c().putLong("result_error_code", qj3Var.a());
                }
                d.g("SignChecker", "done: " + z);
                return z;
            } finally {
                km3.a(sourceChannel);
            }
        }
        return invokeLL.booleanValue;
    }
}
