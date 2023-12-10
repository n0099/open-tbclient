package com.baidu.tieba;

import com.baidu.tieba.vhc;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Executor;
/* loaded from: classes9.dex */
public abstract class xic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vhc a;
    public boolean b;

    public abstract void A(ihc ihcVar);

    public abstract void B(nhc nhcVar);

    public abstract void C(ohc ohcVar);

    public abstract void D(phc phcVar);

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

    public abstract void q(Executor executor, vhc.d dVar);

    public abstract void r(long j);

    public abstract void s(ahc ahcVar);

    public abstract void t(ahc ahcVar);

    public abstract void u(int i);

    public abstract void v(int i);

    public abstract void w(Executor executor, chc chcVar);

    public abstract void x(dhc dhcVar);

    public abstract void y(fhc fhcVar);

    public abstract void z(hhc hhcVar);

    public xic() {
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
