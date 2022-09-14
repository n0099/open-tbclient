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
/* loaded from: classes6.dex */
public class u33 extends v33 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948160020, "Lcom/baidu/tieba/u33;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948160020, "Lcom/baidu/tieba/u33;");
                return;
            }
        }
        b = ij1.a;
    }

    public u33() {
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

    @Override // com.baidu.tieba.v33
    public void a() {
        List<v43> b2;
        List<v43> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
            b(new on2(this));
            b(new l02(this));
            b(new q02(this));
            b(new e02(this));
            b(new r43(this));
            b(new c43(this));
            b(new d63(this));
            b(new sd2(this));
            b(new be2(this));
            b(new td2(this));
            b(new xd2(this));
            b(new yd2(this));
            b(new wd2(this));
            b(new ce2(this));
            b(new vd2(this));
            b(new ae2(this));
            b(new pi3(this));
            b(new zd2(this));
            b(new ud2(this));
            dk1 d = gm2.d();
            if (d != null && (a = d.a(this)) != null && !a.isEmpty()) {
                for (v43 v43Var : a) {
                    b(v43Var);
                }
            }
            if (b) {
                b(new de2(this));
                b(new w33(this));
                if (d == null || (b2 = d.b(this)) == null || b2.isEmpty()) {
                    return;
                }
                for (v43 v43Var2 : b2) {
                    b(v43Var2);
                }
            }
        }
    }
}
