package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.tieba.gm2;
import com.baidu.tieba.yj2;
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
public class vj2 extends yj2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;
    public final q84 e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948242635, "Lcom/baidu/tieba/vj2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948242635, "Lcom/baidu/tieba/vj2;");
                return;
            }
        }
        f = kh1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vj2(String str, q84 q84Var) {
        super("check_sign");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, q84Var};
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
        this.e = q84Var;
    }

    @Override // com.baidu.tieba.yj2.f
    public boolean g(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        tc3 tc3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, sourceChannel, bundle)) == null) {
            fm2 d = fm2.d(bundle.getString("launch_id"));
            gm2.b e = d.e();
            e.b("SignChecker");
            e.d(1);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                try {
                    tc3Var = s42.a(sourceChannel, this.d, this.e);
                } catch (IOException e2) {
                    if (f) {
                        e2.printStackTrace();
                    }
                    tc3 tc3Var2 = new tc3();
                    tc3Var2.k(11L);
                    tc3Var2.i(2300L);
                    tc3Var2.f("inputStream IOException:" + e2.toString());
                    xc3.a().f(tc3Var2);
                    d.g("SignChecker", tc3Var2.toString());
                    nf3.a(sourceChannel);
                    tc3Var = tc3Var2;
                }
                d.g("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
                boolean z = tc3Var == null;
                if (tc3Var != null) {
                    d.g("SignChecker", tc3Var.toString());
                    c().putLong("result_error_code", tc3Var.a());
                }
                d.g("SignChecker", "done: " + z);
                return z;
            } finally {
                nf3.a(sourceChannel);
            }
        }
        return invokeLL.booleanValue;
    }
}
