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
/* loaded from: classes7.dex */
public class rc3 extends sc3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948116775, "Lcom/baidu/tieba/rc3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948116775, "Lcom/baidu/tieba/rc3;");
                return;
            }
        }
        b = fs1.a;
    }

    public rc3() {
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

    @Override // com.baidu.tieba.sc3
    public void a() {
        List<sd3> b2;
        List<sd3> a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.clear();
            b(new lw2(this));
            b(new i92(this));
            b(new n92(this));
            b(new b92(this));
            b(new od3(this));
            b(new zc3(this));
            b(new af3(this));
            b(new pm2(this));
            b(new ym2(this));
            b(new qm2(this));
            b(new um2(this));
            b(new vm2(this));
            b(new tm2(this));
            b(new zm2(this));
            b(new sm2(this));
            b(new xm2(this));
            b(new mr3(this));
            b(new wm2(this));
            b(new rm2(this));
            at1 d = dv2.d();
            if (d != null && (a = d.a(this)) != null && !a.isEmpty()) {
                for (sd3 sd3Var : a) {
                    b(sd3Var);
                }
            }
            if (b) {
                b(new an2(this));
                b(new tc3(this));
                if (d != null && (b2 = d.b(this)) != null && !b2.isEmpty()) {
                    for (sd3 sd3Var2 : b2) {
                        b(sd3Var2);
                    }
                }
            }
        }
    }
}
