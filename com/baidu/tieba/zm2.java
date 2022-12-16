package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.tieba.cn2;
import com.baidu.tieba.kp2;
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
public class zm2 extends cn2.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    public final String d;
    public final wb4 e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948364682, "Lcom/baidu/tieba/zm2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948364682, "Lcom/baidu/tieba/zm2;");
                return;
            }
        }
        f = ok1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zm2(String str, wb4 wb4Var) {
        super("check_sign");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, wb4Var};
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
        this.e = wb4Var;
    }

    @Override // com.baidu.tieba.cn2.f
    public boolean g(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        xf3 xf3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, sourceChannel, bundle)) == null) {
            jp2 d = jp2.d(bundle.getString("launch_id"));
            kp2.b e = d.e();
            e.b("SignChecker");
            boolean z = true;
            e.d(1);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                try {
                    xf3Var = w72.a(sourceChannel, this.d, this.e);
                } catch (IOException e2) {
                    if (f) {
                        e2.printStackTrace();
                    }
                    xf3 xf3Var2 = new xf3();
                    xf3Var2.k(11L);
                    xf3Var2.i(2300L);
                    xf3Var2.f("inputStream IOException:" + e2.toString());
                    bg3.a().f(xf3Var2);
                    d.g("SignChecker", xf3Var2.toString());
                    ri3.a(sourceChannel);
                    xf3Var = xf3Var2;
                }
                d.g("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
                if (xf3Var != null) {
                    z = false;
                }
                if (xf3Var != null) {
                    d.g("SignChecker", xf3Var.toString());
                    c().putLong("result_error_code", xf3Var.a());
                }
                d.g("SignChecker", "done: " + z);
                return z;
            } finally {
                ri3.a(sourceChannel);
            }
        }
        return invokeLL.booleanValue;
    }
}
