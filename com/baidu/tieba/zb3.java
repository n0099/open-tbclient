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
/* loaded from: classes9.dex */
public class zb3 extends ac3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948354142, "Lcom/baidu/tieba/zb3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948354142, "Lcom/baidu/tieba/zb3;");
                return;
            }
        }
        b = nr1.a;
    }

    public zb3() {
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

    @Override // com.baidu.tieba.ac3
    public void a() {
        List<ad3> b2;
        List<ad3> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
            b(new tv2(this));
            b(new q82(this));
            b(new v82(this));
            b(new j82(this));
            b(new wc3(this));
            b(new hc3(this));
            b(new ie3(this));
            b(new xl2(this));
            b(new gm2(this));
            b(new yl2(this));
            b(new cm2(this));
            b(new dm2(this));
            b(new bm2(this));
            b(new hm2(this));
            b(new am2(this));
            b(new fm2(this));
            b(new uq3(this));
            b(new em2(this));
            b(new zl2(this));
            is1 d = lu2.d();
            if (d != null && (a = d.a(this)) != null && !a.isEmpty()) {
                for (ad3 ad3Var : a) {
                    b(ad3Var);
                }
            }
            if (b) {
                b(new im2(this));
                b(new bc3(this));
                if (d != null && (b2 = d.b(this)) != null && !b2.isEmpty()) {
                    for (ad3 ad3Var2 : b2) {
                        b(ad3Var2);
                    }
                }
            }
        }
    }
}
