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
public class ub3 extends vb3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948205187, "Lcom/baidu/tieba/ub3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948205187, "Lcom/baidu/tieba/ub3;");
                return;
            }
        }
        b = ir1.a;
    }

    public ub3() {
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

    @Override // com.baidu.tieba.vb3
    public void a() {
        List<vc3> b2;
        List<vc3> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
            b(new ov2(this));
            b(new l82(this));
            b(new q82(this));
            b(new e82(this));
            b(new rc3(this));
            b(new cc3(this));
            b(new de3(this));
            b(new sl2(this));
            b(new bm2(this));
            b(new tl2(this));
            b(new xl2(this));
            b(new yl2(this));
            b(new wl2(this));
            b(new cm2(this));
            b(new vl2(this));
            b(new am2(this));
            b(new pq3(this));
            b(new zl2(this));
            b(new ul2(this));
            ds1 d = gu2.d();
            if (d != null && (a = d.a(this)) != null && !a.isEmpty()) {
                for (vc3 vc3Var : a) {
                    b(vc3Var);
                }
            }
            if (b) {
                b(new dm2(this));
                b(new wb3(this));
                if (d != null && (b2 = d.b(this)) != null && !b2.isEmpty()) {
                    for (vc3 vc3Var2 : b2) {
                        b(vc3Var2);
                    }
                }
            }
        }
    }
}
