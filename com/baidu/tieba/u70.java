package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.core.Call;
import com.baidu.searchbox.network.outback.core.Request;
import com.baidu.searchbox.network.outback.core.internal.Util;
import com.baidu.searchbox.network.support.dns.Dns;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
/* loaded from: classes8.dex */
public class u70 implements Cloneable, Call.Factory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public final o70 b;
    @Nullable
    public final Proxy c;
    public final List<p70> d;
    public final List<p70> e;
    public final ProxySelector f;
    public final SSLSocketFactory g;
    public final HostnameVerifier h;
    public final Dns i;
    public final int j;
    public final int k;
    public final int l;
    public a80 m;
    public boolean n;
    public boolean o;
    public String p;

    /* loaded from: classes8.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;
        public o70 b;
        @Nullable
        public Proxy c;
        public final List<p70> d;
        public final List<p70> e;
        public ProxySelector f;
        @Nullable
        public SSLSocketFactory g;
        public HostnameVerifier h;
        public boolean i;
        public boolean j;
        public Dns k;
        public int l;
        public int m;
        public int n;
        public a80 o;
        public String p;

        public a() {
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
            this.d = new ArrayList();
            this.e = new ArrayList();
            this.b = new o70();
            ProxySelector proxySelector = ProxySelector.getDefault();
            this.f = proxySelector;
            if (proxySelector == null) {
                this.f = new s70();
            }
            SocketFactory.getDefault();
            this.h = null;
            this.k = Dns.SYSTEM;
            this.l = 10000;
            this.m = 10000;
            this.n = 10000;
            this.o = new y70();
        }

        public a(u70 u70Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u70Var};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.d = new ArrayList();
            this.e = new ArrayList();
            this.b = u70Var.b;
            this.c = u70Var.c;
            this.d.addAll(u70Var.d);
            this.e.addAll(u70Var.e);
            this.f = u70Var.f;
            this.k = u70Var.i;
            this.l = u70Var.j;
            this.m = u70Var.k;
            this.n = u70Var.l;
            this.o = u70Var.m;
            this.i = u70Var.n;
            this.j = u70Var.o;
            this.p = u70Var.p;
            this.h = u70Var.h;
            this.g = u70Var.g;
        }

        public a a(p70 p70Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, p70Var)) == null) {
                if (p70Var != null) {
                    this.d.add(p70Var);
                    return this;
                }
                throw new IllegalArgumentException("interceptor == null");
            }
            return (a) invokeL.objValue;
        }

        public a c(o70 o70Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, o70Var)) == null) {
                if (o70Var != null) {
                    this.b = o70Var;
                    return this;
                }
                throw new IllegalArgumentException("dispatcher == null");
            }
            return (a) invokeL.objValue;
        }

        public a d(a80 a80Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, a80Var)) == null) {
                this.o = a80Var;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public u70 b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new u70(this);
            }
            return (u70) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948163771, "Lcom/baidu/tieba/u70;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948163771, "Lcom/baidu/tieba/u70;");
                return;
            }
        }
        new ArrayList(2);
    }

    public SSLSocketFactory B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.g;
        }
        return (SSLSocketFactory) invokeV.objValue;
    }

    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.p;
        }
        return (String) invokeV.objValue;
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.j;
        }
        return invokeV.intValue;
    }

    public o70 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b;
        }
        return (o70) invokeV.objValue;
    }

    public Dns q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.i;
        }
        return (Dns) invokeV.objValue;
    }

    public HostnameVerifier r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.h;
        }
        return (HostnameVerifier) invokeV.objValue;
    }

    public a80 s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.m;
        }
        return (a80) invokeV.objValue;
    }

    public List<p70> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.d;
        }
        return (List) invokeV.objValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.o;
        }
        return invokeV.booleanValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.n;
        }
        return invokeV.booleanValue;
    }

    public List<p70> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.e;
        }
        return (List) invokeV.objValue;
    }

    public a x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return new a(this);
        }
        return (a) invokeV.objValue;
    }

    public ProxySelector y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.f;
        }
        return (ProxySelector) invokeV.objValue;
    }

    public int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.k;
        }
        return invokeV.intValue;
    }

    public u70(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.n = false;
        this.o = false;
        this.p = null;
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = Util.immutableList(aVar.d);
        this.e = Util.immutableList(aVar.e);
        this.f = aVar.f;
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.k;
        this.j = aVar.l;
        this.k = aVar.m;
        this.l = aVar.n;
        if (!this.d.contains(null)) {
            if (!this.e.contains(null)) {
                this.m = aVar.o;
                this.n = aVar.i;
                this.o = aVar.j;
                this.p = aVar.p;
                return;
            }
            throw new IllegalStateException("Null network interceptor: " + this.e);
        }
        throw new IllegalStateException("Null interceptor: " + this.d);
    }

    public void A(a80 a80Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, a80Var) != null) || a80Var == null) {
            return;
        }
        this.m = a80Var;
    }

    @Override // com.baidu.searchbox.network.outback.core.Call.Factory
    public Call newCall(Request request) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, request)) == null) {
            return t70.c(request, this, false);
        }
        return (Call) invokeL.objValue;
    }
}
