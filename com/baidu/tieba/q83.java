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
public class q83 extends r83 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948045661, "Lcom/baidu/tieba/q83;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948045661, "Lcom/baidu/tieba/q83;");
                return;
            }
        }
        b = eo1.a;
    }

    public q83() {
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

    @Override // com.baidu.tieba.r83
    public void a() {
        List<r93> b2;
        List<r93> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
            b(new ks2(this));
            b(new h52(this));
            b(new m52(this));
            b(new a52(this));
            b(new n93(this));
            b(new y83(this));
            b(new za3(this));
            b(new oi2(this));
            b(new xi2(this));
            b(new pi2(this));
            b(new ti2(this));
            b(new ui2(this));
            b(new si2(this));
            b(new yi2(this));
            b(new ri2(this));
            b(new wi2(this));
            b(new ln3(this));
            b(new vi2(this));
            b(new qi2(this));
            zo1 d = cr2.d();
            if (d != null && (a = d.a(this)) != null && !a.isEmpty()) {
                for (r93 r93Var : a) {
                    b(r93Var);
                }
            }
            if (b) {
                b(new zi2(this));
                b(new s83(this));
                if (d != null && (b2 = d.b(this)) != null && !b2.isEmpty()) {
                    for (r93 r93Var2 : b2) {
                        b(r93Var2);
                    }
                }
            }
        }
    }
}
