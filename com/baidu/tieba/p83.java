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
/* loaded from: classes5.dex */
public class p83 extends q83 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948015870, "Lcom/baidu/tieba/p83;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948015870, "Lcom/baidu/tieba/p83;");
                return;
            }
        }
        b = do1.a;
    }

    public p83() {
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

    @Override // com.baidu.tieba.q83
    public void a() {
        List<q93> b2;
        List<q93> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
            b(new js2(this));
            b(new g52(this));
            b(new l52(this));
            b(new z42(this));
            b(new m93(this));
            b(new x83(this));
            b(new ya3(this));
            b(new ni2(this));
            b(new wi2(this));
            b(new oi2(this));
            b(new si2(this));
            b(new ti2(this));
            b(new ri2(this));
            b(new xi2(this));
            b(new qi2(this));
            b(new vi2(this));
            b(new kn3(this));
            b(new ui2(this));
            b(new pi2(this));
            yo1 d = br2.d();
            if (d != null && (a = d.a(this)) != null && !a.isEmpty()) {
                for (q93 q93Var : a) {
                    b(q93Var);
                }
            }
            if (b) {
                b(new yi2(this));
                b(new r83(this));
                if (d != null && (b2 = d.b(this)) != null && !b2.isEmpty()) {
                    for (q93 q93Var2 : b2) {
                        b(q93Var2);
                    }
                }
            }
        }
    }
}
