package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.tieba.at2;
import com.baidu.tieba.sq2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.nio.channels.Pipe;
/* loaded from: classes5.dex */
public class pq2 extends sq2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;
    public final mf4 e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948070616, "Lcom/baidu/tieba/pq2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948070616, "Lcom/baidu/tieba/pq2;");
                return;
            }
        }
        f = eo1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pq2(String str, mf4 mf4Var) {
        super("check_sign");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, mf4Var};
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
        this.e = mf4Var;
    }

    @Override // com.baidu.tieba.sq2.f
    public boolean g(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        nj3 nj3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, sourceChannel, bundle)) == null) {
            zs2 d = zs2.d(bundle.getString("launch_id"));
            at2.b e = d.e();
            e.b("SignChecker");
            boolean z = true;
            e.d(1);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                try {
                    nj3Var = mb2.a(sourceChannel, this.d, this.e);
                } catch (IOException e2) {
                    if (f) {
                        e2.printStackTrace();
                    }
                    nj3 nj3Var2 = new nj3();
                    nj3Var2.k(11L);
                    nj3Var2.i(2300L);
                    nj3Var2.f("inputStream IOException:" + e2.toString());
                    rj3.a().f(nj3Var2);
                    d.g("SignChecker", nj3Var2.toString());
                    hm3.a(sourceChannel);
                    nj3Var = nj3Var2;
                }
                d.g("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
                if (nj3Var != null) {
                    z = false;
                }
                if (nj3Var != null) {
                    d.g("SignChecker", nj3Var.toString());
                    c().putLong("result_error_code", nj3Var.a());
                }
                d.g("SignChecker", "done: " + z);
                return z;
            } finally {
                hm3.a(sourceChannel);
            }
        }
        return invokeLL.booleanValue;
    }
}
