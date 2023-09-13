package com.baidu.tieba;

import com.baidu.tieba.j4c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Executor;
/* loaded from: classes6.dex */
public abstract class l5c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public j4c a;
    public boolean b;

    public abstract void A(w3c w3cVar);

    public abstract void B(b4c b4cVar);

    public abstract void C(c4c c4cVar);

    public abstract void D(d4c d4cVar);

    public abstract void E(int i);

    public abstract void F(int i, long j);

    public abstract void G();

    public abstract void e();

    public abstract void f();

    public abstract long g();

    public abstract long h();

    public abstract Object i();

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? "12.1.0.34" : (String) invokeV.objValue;
    }

    public abstract int k();

    public abstract int l();

    public abstract void m();

    public abstract void n();

    public abstract void o();

    public abstract void p();

    public abstract void q(Executor executor, j4c.d dVar);

    public abstract void r(long j);

    public abstract void s(o3c o3cVar);

    public abstract void t(o3c o3cVar);

    public abstract void u(int i);

    public abstract void v(int i);

    public abstract void w(Executor executor, q3c q3cVar);

    public abstract void x(r3c r3cVar);

    public abstract void y(t3c t3cVar);

    public abstract void z(v3c v3cVar);

    public l5c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
