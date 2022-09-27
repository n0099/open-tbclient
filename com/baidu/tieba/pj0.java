package com.baidu.tieba;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class pj0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ij0 a;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final pj0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-516422315, "Lcom/baidu/tieba/pj0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-516422315, "Lcom/baidu/tieba/pj0$b;");
                    return;
                }
            }
            a = new pj0(null);
        }
    }

    public /* synthetic */ pj0(a aVar) {
        this();
    }

    public static pj0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.a : (pj0) invokeV.objValue;
    }

    public String a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            pp0 a2 = this.a.a();
            if (z) {
                if (a2 != null && !TextUtils.isEmpty(a2.a)) {
                    return a2.a;
                }
                return zi0.d().a();
            } else if (this.a.h()) {
                return (a2 == null || a2.b == 3) ? "" : a2.a;
            } else {
                return zi0.d().a();
            }
        }
        return (String) invokeZ.objValue;
    }

    public String b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            pp0 e = this.a.e();
            if (z) {
                if (e != null && !TextUtils.isEmpty(e.a)) {
                    return e.a;
                }
                return zi0.d().e();
            } else if (this.a.h()) {
                return (e == null || e.b == 3) ? "" : e.a;
            } else {
                return zi0.d().e();
            }
        }
        return (String) invokeZ.objValue;
    }

    public String d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            pp0 f = this.a.f();
            if (z) {
                if (f != null && !TextUtils.isEmpty(f.a)) {
                    return f.a;
                }
                return zi0.d().f();
            } else if (this.a.h()) {
                return (f == null || f.b == 3) ? "" : f.a;
            } else {
                return zi0.d().f();
            }
        }
        return (String) invokeZ.objValue;
    }

    public String e(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            pp0 d = this.a.d();
            if (z) {
                if (d != null && !TextUtils.isEmpty(d.a)) {
                    return d.a;
                }
                return zi0.d().d();
            } else if (this.a.h()) {
                return (d == null || d.b == 3) ? "" : d.a;
            } else {
                return zi0.d().d();
            }
        }
        return (String) invokeZ.objValue;
    }

    public String f(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            pp0 c = this.a.c();
            if (z) {
                if (c != null && !TextUtils.isEmpty(c.a)) {
                    return c.a;
                }
                return zi0.d().c();
            } else if (this.a.h()) {
                return (c == null || c.b == 3) ? "" : c.a;
            } else {
                return zi0.d().c();
            }
        }
        return (String) invokeZ.objValue;
    }

    public String g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            pp0 g = this.a.g();
            if (z) {
                if (g != null && !TextUtils.isEmpty(g.a)) {
                    return g.a;
                }
                return Build.MANUFACTURER;
            } else if (this.a.h()) {
                return (g == null || g.b == 3) ? "" : g.a;
            } else {
                return Build.MANUFACTURER;
            }
        }
        return (String) invokeZ.objValue;
    }

    public String h(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            pp0 b2 = this.a.b();
            if (z) {
                if (b2 != null && !TextUtils.isEmpty(b2.a)) {
                    return b2.a;
                }
                return zi0.d().b();
            } else if (this.a.h()) {
                return (b2 == null || b2.b == 3) ? "" : b2.a;
            } else {
                return zi0.d().b();
            }
        }
        return (String) invokeZ.objValue;
    }

    public pj0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        synchronized (pj0.class) {
            ij0 ij0Var = (ij0) ServiceManager.getService(ij0.a);
            this.a = ij0Var;
            if (ij0Var == null) {
                this.a = ij0.b;
            }
        }
    }
}
