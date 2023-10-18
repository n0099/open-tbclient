package com.baidu.tieba;

import com.baidu.pyramid.annotation.Service;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
@Service
/* loaded from: classes7.dex */
public class l63 extends m63 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947894784, "Lcom/baidu/tieba/l63;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947894784, "Lcom/baidu/tieba/l63;");
                return;
            }
        }
        b = am1.a;
    }

    public l63() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.m63
    public void a() {
        List<m73> b2;
        List<m73> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
            b(new fq2(this));
            b(new c32(this));
            b(new h32(this));
            b(new v22(this));
            b(new i73(this));
            b(new t63(this));
            b(new u83(this));
            b(new jg2(this));
            b(new sg2(this));
            b(new kg2(this));
            b(new og2(this));
            b(new pg2(this));
            b(new ng2(this));
            b(new tg2(this));
            b(new mg2(this));
            b(new rg2(this));
            b(new gl3(this));
            b(new qg2(this));
            b(new lg2(this));
            vm1 d = xo2.d();
            if (d != null && (a = d.a(this)) != null && !a.isEmpty()) {
                for (m73 m73Var : a) {
                    b(m73Var);
                }
            }
            if (b) {
                b(new ug2(this));
                b(new n63(this));
                if (d != null && (b2 = d.b(this)) != null && !b2.isEmpty()) {
                    for (m73 m73Var2 : b2) {
                        b(m73Var2);
                    }
                }
            }
        }
    }
}
