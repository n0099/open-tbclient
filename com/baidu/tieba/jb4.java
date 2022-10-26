package com.baidu.tieba;

import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public abstract class jb4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jb4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract boolean a(lc4 lc4Var, PMSAppInfo pMSAppInfo);

    public abstract boolean b(lc4 lc4Var, List list, jc4 jc4Var, hc4 hc4Var, PMSAppInfo pMSAppInfo);

    public abstract void c(String str);

    public abstract void d(String str, String str2);

    public abstract boolean e(Class cls, String str);

    public abstract boolean f(nc4 nc4Var);

    public abstract boolean g(List list);

    public abstract boolean h(String str);

    public abstract int j(String str);

    public abstract List k(String str, int i);

    public abstract boolean l(PMSAppInfo pMSAppInfo);

    public abstract boolean m(kc4 kc4Var);

    public abstract boolean n(String str, String str2, String str3);

    public abstract kc4 o(Class cls, String str);

    public abstract Map p();

    public abstract nc4 q(String str, long j, long j2);

    public abstract List r(String str, String[] strArr);

    public abstract List s(String str, long j, long j2);

    public abstract oc4 t(String str);

    public abstract PMSAppInfo u(String str);

    public abstract Map v();

    public abstract List w(String str);

    public abstract boolean x(nc4 nc4Var);

    public abstract boolean y(PMSAppInfo pMSAppInfo);

    public abstract boolean z(String str, int i);

    public jb4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static jb4 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (jb4.class) {
                    if (a == null) {
                        a = new kb4();
                    }
                }
            }
            return a;
        }
        return (jb4) invokeV.objValue;
    }
}
