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
public class t83 extends u83 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948135034, "Lcom/baidu/tieba/t83;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948135034, "Lcom/baidu/tieba/t83;");
                return;
            }
        }
        b = ho1.a;
    }

    public t83() {
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

    @Override // com.baidu.tieba.u83
    public void a() {
        List<u93> b2;
        List<u93> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
            b(new ns2(this));
            b(new k52(this));
            b(new p52(this));
            b(new d52(this));
            b(new q93(this));
            b(new b93(this));
            b(new cb3(this));
            b(new ri2(this));
            b(new aj2(this));
            b(new si2(this));
            b(new wi2(this));
            b(new xi2(this));
            b(new vi2(this));
            b(new bj2(this));
            b(new ui2(this));
            b(new zi2(this));
            b(new on3(this));
            b(new yi2(this));
            b(new ti2(this));
            cp1 d = fr2.d();
            if (d != null && (a = d.a(this)) != null && !a.isEmpty()) {
                for (u93 u93Var : a) {
                    b(u93Var);
                }
            }
            if (b) {
                b(new cj2(this));
                b(new v83(this));
                if (d != null && (b2 = d.b(this)) != null && !b2.isEmpty()) {
                    for (u93 u93Var2 : b2) {
                        b(u93Var2);
                    }
                }
            }
        }
    }
}
