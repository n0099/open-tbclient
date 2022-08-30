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
public class w13 extends x13 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948217680, "Lcom/baidu/tieba/w13;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948217680, "Lcom/baidu/tieba/w13;");
                return;
            }
        }
        b = kh1.a;
    }

    public w13() {
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

    @Override // com.baidu.tieba.x13
    public void a() {
        List<x23> b2;
        List<x23> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
            b(new ql2(this));
            b(new ny1(this));
            b(new sy1(this));
            b(new gy1(this));
            b(new t23(this));
            b(new e23(this));
            b(new f43(this));
            b(new ub2(this));
            b(new dc2(this));
            b(new vb2(this));
            b(new zb2(this));
            b(new ac2(this));
            b(new yb2(this));
            b(new ec2(this));
            b(new xb2(this));
            b(new cc2(this));
            b(new rg3(this));
            b(new bc2(this));
            b(new wb2(this));
            fi1 d = ik2.d();
            if (d != null && (a = d.a(this)) != null && !a.isEmpty()) {
                for (x23 x23Var : a) {
                    b(x23Var);
                }
            }
            if (b) {
                b(new fc2(this));
                b(new y13(this));
                if (d == null || (b2 = d.b(this)) == null || b2.isEmpty()) {
                    return;
                }
                for (x23 x23Var2 : b2) {
                    b(x23Var2);
                }
            }
        }
    }
}
