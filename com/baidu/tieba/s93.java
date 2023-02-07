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
public class s93 extends t93 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948106204, "Lcom/baidu/tieba/s93;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948106204, "Lcom/baidu/tieba/s93;");
                return;
            }
        }
        b = gp1.a;
    }

    public s93() {
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

    @Override // com.baidu.tieba.t93
    public void a() {
        List<ta3> b2;
        List<ta3> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
            b(new mt2(this));
            b(new j62(this));
            b(new o62(this));
            b(new c62(this));
            b(new pa3(this));
            b(new aa3(this));
            b(new bc3(this));
            b(new qj2(this));
            b(new zj2(this));
            b(new rj2(this));
            b(new vj2(this));
            b(new wj2(this));
            b(new uj2(this));
            b(new ak2(this));
            b(new tj2(this));
            b(new yj2(this));
            b(new no3(this));
            b(new xj2(this));
            b(new sj2(this));
            bq1 d = es2.d();
            if (d != null && (a = d.a(this)) != null && !a.isEmpty()) {
                for (ta3 ta3Var : a) {
                    b(ta3Var);
                }
            }
            if (b) {
                b(new bk2(this));
                b(new u93(this));
                if (d != null && (b2 = d.b(this)) != null && !b2.isEmpty()) {
                    for (ta3 ta3Var2 : b2) {
                        b(ta3Var2);
                    }
                }
            }
        }
    }
}
