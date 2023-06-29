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
public class yc3 extends zc3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948325312, "Lcom/baidu/tieba/yc3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948325312, "Lcom/baidu/tieba/yc3;");
                return;
            }
        }
        b = ms1.a;
    }

    public yc3() {
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

    @Override // com.baidu.tieba.zc3
    public void a() {
        List<zd3> b2;
        List<zd3> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
            b(new sw2(this));
            b(new p92(this));
            b(new u92(this));
            b(new i92(this));
            b(new vd3(this));
            b(new gd3(this));
            b(new hf3(this));
            b(new wm2(this));
            b(new fn2(this));
            b(new xm2(this));
            b(new bn2(this));
            b(new cn2(this));
            b(new an2(this));
            b(new gn2(this));
            b(new zm2(this));
            b(new en2(this));
            b(new tr3(this));
            b(new dn2(this));
            b(new ym2(this));
            ht1 d = kv2.d();
            if (d != null && (a = d.a(this)) != null && !a.isEmpty()) {
                for (zd3 zd3Var : a) {
                    b(zd3Var);
                }
            }
            if (b) {
                b(new hn2(this));
                b(new ad3(this));
                if (d != null && (b2 = d.b(this)) != null && !b2.isEmpty()) {
                    for (zd3 zd3Var2 : b2) {
                        b(zd3Var2);
                    }
                }
            }
        }
    }
}
