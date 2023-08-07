package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.tieba.ew2;
import com.baidu.tieba.wt2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.nio.channels.Pipe;
/* loaded from: classes8.dex */
public class tt2 extends wt2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;
    public final qi4 e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948192663, "Lcom/baidu/tieba/tt2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948192663, "Lcom/baidu/tieba/tt2;");
                return;
            }
        }
        f = ir1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tt2(String str, qi4 qi4Var) {
        super("check_sign");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, qi4Var};
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
        this.e = qi4Var;
    }

    @Override // com.baidu.tieba.wt2.f
    public boolean g(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        rm3 rm3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, sourceChannel, bundle)) == null) {
            dw2 d = dw2.d(bundle.getString("launch_id"));
            ew2.b e = d.e();
            e.b("SignChecker");
            boolean z = true;
            e.d(1);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                try {
                    rm3Var = qe2.a(sourceChannel, this.d, this.e);
                } catch (IOException e2) {
                    if (f) {
                        e2.printStackTrace();
                    }
                    rm3 rm3Var2 = new rm3();
                    rm3Var2.k(11L);
                    rm3Var2.i(2300L);
                    rm3Var2.f("inputStream IOException:" + e2.toString());
                    vm3.a().f(rm3Var2);
                    d.g("SignChecker", rm3Var2.toString());
                    lp3.a(sourceChannel);
                    rm3Var = rm3Var2;
                }
                d.g("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
                if (rm3Var != null) {
                    z = false;
                }
                if (rm3Var != null) {
                    d.g("SignChecker", rm3Var.toString());
                    c().putLong("result_error_code", rm3Var.a());
                }
                d.g("SignChecker", "done: " + z);
                return z;
            } finally {
                lp3.a(sourceChannel);
            }
        }
        return invokeLL.booleanValue;
    }
}
