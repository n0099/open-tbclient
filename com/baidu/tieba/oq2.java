package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.tieba.rq2;
import com.baidu.tieba.zs2;
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
public class oq2 extends rq2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;
    public final lf4 e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948040825, "Lcom/baidu/tieba/oq2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948040825, "Lcom/baidu/tieba/oq2;");
                return;
            }
        }
        f = do1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oq2(String str, lf4 lf4Var) {
        super("check_sign");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, lf4Var};
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
        this.e = lf4Var;
    }

    @Override // com.baidu.tieba.rq2.f
    public boolean g(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        mj3 mj3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, sourceChannel, bundle)) == null) {
            ys2 d = ys2.d(bundle.getString("launch_id"));
            zs2.b e = d.e();
            e.b("SignChecker");
            boolean z = true;
            e.d(1);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                try {
                    mj3Var = lb2.a(sourceChannel, this.d, this.e);
                } catch (IOException e2) {
                    if (f) {
                        e2.printStackTrace();
                    }
                    mj3 mj3Var2 = new mj3();
                    mj3Var2.k(11L);
                    mj3Var2.i(2300L);
                    mj3Var2.f("inputStream IOException:" + e2.toString());
                    qj3.a().f(mj3Var2);
                    d.g("SignChecker", mj3Var2.toString());
                    gm3.a(sourceChannel);
                    mj3Var = mj3Var2;
                }
                d.g("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
                if (mj3Var != null) {
                    z = false;
                }
                if (mj3Var != null) {
                    d.g("SignChecker", mj3Var.toString());
                    c().putLong("result_error_code", mj3Var.a());
                }
                d.g("SignChecker", "done: " + z);
                return z;
            } finally {
                gm3.a(sourceChannel);
            }
        }
        return invokeLL.booleanValue;
    }
}
