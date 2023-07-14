package com.baidu.tieba;

import com.baidu.tieba.lvb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Executor;
/* loaded from: classes7.dex */
public abstract class nwb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public lvb a;
    public boolean b;

    public abstract void A(yub yubVar);

    public abstract void B(dvb dvbVar);

    public abstract void C(evb evbVar);

    public abstract void D(fvb fvbVar);

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

    public abstract void q(Executor executor, lvb.d dVar);

    public abstract void r(long j);

    public abstract void s(qub qubVar);

    public abstract void t(qub qubVar);

    public abstract void u(int i);

    public abstract void v(int i);

    public abstract void w(Executor executor, sub subVar);

    public abstract void x(tub tubVar);

    public abstract void y(vub vubVar);

    public abstract void z(xub xubVar);

    public nwb() {
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
