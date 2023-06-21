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
/* loaded from: classes8.dex */
public class vc3 extends wc3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948235939, "Lcom/baidu/tieba/vc3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948235939, "Lcom/baidu/tieba/vc3;");
                return;
            }
        }
        b = js1.a;
    }

    public vc3() {
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

    @Override // com.baidu.tieba.wc3
    public void a() {
        List<wd3> b2;
        List<wd3> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
            b(new pw2(this));
            b(new m92(this));
            b(new r92(this));
            b(new f92(this));
            b(new sd3(this));
            b(new dd3(this));
            b(new ef3(this));
            b(new tm2(this));
            b(new cn2(this));
            b(new um2(this));
            b(new ym2(this));
            b(new zm2(this));
            b(new xm2(this));
            b(new dn2(this));
            b(new wm2(this));
            b(new bn2(this));
            b(new qr3(this));
            b(new an2(this));
            b(new vm2(this));
            et1 d = hv2.d();
            if (d != null && (a = d.a(this)) != null && !a.isEmpty()) {
                for (wd3 wd3Var : a) {
                    b(wd3Var);
                }
            }
            if (b) {
                b(new en2(this));
                b(new xc3(this));
                if (d != null && (b2 = d.b(this)) != null && !b2.isEmpty()) {
                    for (wd3 wd3Var2 : b2) {
                        b(wd3Var2);
                    }
                }
            }
        }
    }
}
