package com.baidu.tieba;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.l20;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
/* loaded from: classes6.dex */
public class p20 extends l20 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile com.baidu.helios.bridge.multiprocess.g c;
    public volatile n20 d;
    public volatile boolean e;
    public volatile boolean f;
    public volatile boolean g;
    public volatile Future<Boolean> h;
    public volatile Future<Boolean> i;
    public volatile boolean j;
    public String k;
    public Object l;
    public Object m;

    /* loaded from: classes6.dex */
    public class a implements Callable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p20 a;

        public a(p20 p20Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p20Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p20Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.a.d = new n20();
                this.a.d.b(this.a.a);
                this.a.d.c(this.a.b);
                this.a.f = true;
                return Boolean.TRUE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Callable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p20 a;

        public b(p20 p20Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p20Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p20Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                p20 p20Var = this.a;
                p20Var.c = new com.baidu.helios.bridge.multiprocess.g(p20Var, p20Var.k);
                this.a.c.b(this.a.a);
                this.a.c.c(this.a.b);
                this.a.g = true;
                if (this.a.c.o()) {
                    this.a.j = true;
                    return Boolean.TRUE;
                }
                this.a.j = false;
                this.a.e = false;
                this.a.q();
                return Boolean.FALSE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    public p20(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new Object();
        this.m = new Object();
        this.e = true;
        this.f = false;
        this.k = str;
    }

    @Override // com.baidu.tieba.l20
    public void a(String str, Bundle bundle, l20.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, bundle, cVar) == null) {
            if (this.e) {
                t();
                if (this.j) {
                    this.c.a(str, bundle, cVar);
                    return;
                }
            }
            n();
            this.d.a(str, bundle, cVar);
        }
    }

    @Override // com.baidu.tieba.l20
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.e) {
                t();
                if (this.j && this.c != null) {
                    this.c.d();
                    return;
                }
            }
            n();
            if (this.d != null) {
                this.d.d();
            }
        }
    }

    @Override // com.baidu.tieba.l20
    public boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (this.e) {
                t();
                if (this.j) {
                    return this.c.e(str);
                }
            }
            n();
            return this.d.e(str);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.l20
    public void f(l20.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            if (this.e) {
                synchronized (this.l) {
                    w();
                }
                return;
            }
            synchronized (this.m) {
                q();
            }
        }
    }

    @Override // com.baidu.tieba.l20
    public l20.d g(String str, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, bundle)) == null) {
            if (this.e) {
                t();
                if (this.j) {
                    l20.d g = this.c.g(str, bundle);
                    if (g.b()) {
                        return g;
                    }
                    this.e = false;
                }
            }
            n();
            return this.d.g(str, bundle);
        }
        return (l20.d) invokeLL.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.e = false;
            q();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.e || this.f) {
            return;
        }
        synchronized (this.m) {
            q();
        }
        try {
            this.i.get();
        } catch (Exception unused) {
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && !this.f && this.i == null) {
            this.i = this.a.d.submit(new a(this));
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.e) {
            if (!this.g) {
                synchronized (this.l) {
                    w();
                }
            }
            try {
                this.h.get();
            } catch (Exception unused) {
            }
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && !this.g && this.h == null) {
            this.h = this.a.d.submit(new b(this));
        }
    }
}
