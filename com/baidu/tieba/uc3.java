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
public class uc3 extends vc3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948206148, "Lcom/baidu/tieba/uc3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948206148, "Lcom/baidu/tieba/uc3;");
                return;
            }
        }
        b = is1.a;
    }

    public uc3() {
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

    @Override // com.baidu.tieba.vc3
    public void a() {
        List<vd3> b2;
        List<vd3> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
            b(new ow2(this));
            b(new l92(this));
            b(new q92(this));
            b(new e92(this));
            b(new rd3(this));
            b(new cd3(this));
            b(new df3(this));
            b(new sm2(this));
            b(new bn2(this));
            b(new tm2(this));
            b(new xm2(this));
            b(new ym2(this));
            b(new wm2(this));
            b(new cn2(this));
            b(new vm2(this));
            b(new an2(this));
            b(new pr3(this));
            b(new zm2(this));
            b(new um2(this));
            dt1 d = gv2.d();
            if (d != null && (a = d.a(this)) != null && !a.isEmpty()) {
                for (vd3 vd3Var : a) {
                    b(vd3Var);
                }
            }
            if (b) {
                b(new dn2(this));
                b(new wc3(this));
                if (d != null && (b2 = d.b(this)) != null && !b2.isEmpty()) {
                    for (vd3 vd3Var2 : b2) {
                        b(vd3Var2);
                    }
                }
            }
        }
    }
}
