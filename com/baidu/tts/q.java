package com.baidu.tts;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.util.concurrent.ScheduledThreadPoolExecutor;
/* loaded from: classes9.dex */
public class q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final ScheduledThreadPoolExecutor b;
    public final m c;
    public u1 d;
    public byte e;
    public n1 f;

    public q(String str, m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, mVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = str;
        w0.a("OnlineSynthesizer", str);
        this.b = new ScheduledThreadPoolExecutor(1, new x0(str, "bds-cTimer"));
        this.c = mVar;
    }

    public d a(w1 w1Var) throws InterruptedException {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, w1Var)) == null) {
            if (d0.a(this.a).a()) {
                return z0.a().a(u0.G0);
            }
            byte b = (byte) (this.e + 1);
            this.e = b;
            n1 n1Var = new n1(this.a, this.c, b, this.d, this.b);
            this.f = n1Var;
            try {
                n1Var.m = System.currentTimeMillis();
                String str2 = w1Var.g;
                n1Var.e = str2;
                n1Var.f = w1Var;
                w1Var.n = n1Var.d;
                d a = n1Var.c.a(new k1(w1Var, w0.a(1, n1Var.d, n1Var.a(str2, w1Var, n1Var.g)), n1Var));
                if (a != null) {
                    n1Var.f.a("net_exception", -3);
                } else {
                    n1Var.k = System.currentTimeMillis();
                    n1Var.a(n1Var.g.o);
                    try {
                        n1Var.h.acquire();
                        n1Var.b();
                        a = n1Var.j;
                    } catch (InterruptedException e) {
                        LoggerProxy.d(n1Var.a, "because interrupt close");
                        n1Var.a();
                        e.printStackTrace();
                        throw e;
                    }
                }
                w1Var.a("ctimeout", Integer.valueOf(this.d.o));
                int length = w1Var.a.length();
                if (length == w1Var.h) {
                    str = w1Var.a;
                } else if (length > w1Var.h) {
                    str = w1Var.a.substring(0, w1Var.h);
                } else {
                    str = null;
                }
                w1Var.a("syn_text", str);
                return a;
            } finally {
                n1Var.b();
            }
        }
        return (d) invokeL.objValue;
    }
}
