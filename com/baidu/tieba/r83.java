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
public class r83 extends s83 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948075452, "Lcom/baidu/tieba/r83;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948075452, "Lcom/baidu/tieba/r83;");
                return;
            }
        }
        b = fo1.a;
    }

    public r83() {
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

    @Override // com.baidu.tieba.s83
    public void a() {
        List<s93> b2;
        List<s93> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
            b(new ls2(this));
            b(new i52(this));
            b(new n52(this));
            b(new b52(this));
            b(new o93(this));
            b(new z83(this));
            b(new ab3(this));
            b(new pi2(this));
            b(new yi2(this));
            b(new qi2(this));
            b(new ui2(this));
            b(new vi2(this));
            b(new ti2(this));
            b(new zi2(this));
            b(new si2(this));
            b(new xi2(this));
            b(new mn3(this));
            b(new wi2(this));
            b(new ri2(this));
            ap1 d = dr2.d();
            if (d != null && (a = d.a(this)) != null && !a.isEmpty()) {
                for (s93 s93Var : a) {
                    b(s93Var);
                }
            }
            if (b) {
                b(new aj2(this));
                b(new t83(this));
                if (d != null && (b2 = d.b(this)) != null && !b2.isEmpty()) {
                    for (s93 s93Var2 : b2) {
                        b(s93Var2);
                    }
                }
            }
        }
    }
}
