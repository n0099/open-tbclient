package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.pm4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class ll4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ml4 a;
    public BlockingQueue<Runnable> b;
    public ThreadPoolExecutor c;
    public xl4 d;
    public final AtomicBoolean e;
    @SuppressLint({"SyntheticAccessor"})
    public final tl4 f;
    public final dm4 g;
    public sl4 h;

    /* loaded from: classes6.dex */
    public class a implements tl4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ll4 a;

        public a(ll4 ll4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ll4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ll4Var;
        }

        @Override // com.baidu.tieba.tl4
        public <T> void a(xl4<T> xl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, xl4Var) != null) {
                return;
            }
            this.a.d = xl4Var;
        }

        @Override // com.baidu.tieba.tl4
        public <T> void b(xl4<T> xl4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xl4Var) != null) || this.a.d != xl4Var) {
                return;
            }
            this.a.d = null;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements sl4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ll4 a;

        public b(ll4 ll4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ll4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ll4Var;
        }

        @Override // com.baidu.tieba.sl4
        public Runnable a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
                return this.a.d(z);
            }
            return (Runnable) invokeZ.objValue;
        }
    }

    public ll4() {
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
        this.e = new AtomicBoolean(false);
        this.f = new a(this);
        this.g = new dm4(this.f);
        this.h = new b(this);
        this.a = new ml4();
        this.b = new LinkedBlockingQueue();
        this.c = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, this.b);
        c(this.a);
    }

    public void c(tl4 tl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tl4Var) == null) {
            this.g.c(tl4Var);
        }
    }

    public synchronized Runnable d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            synchronized (this) {
                if (this.a != null) {
                    if (z) {
                        return this.a.g();
                    }
                    return this.a.i();
                }
                return null;
            }
        }
        return (Runnable) invokeZ.objValue;
    }

    public synchronized <T> void g(xl4<T> xl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, xl4Var) == null) {
            synchronized (this) {
                this.a.h(xl4Var);
            }
        }
    }

    public synchronized <T> void h(xl4<T> xl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, xl4Var) == null) {
            synchronized (this) {
                g(xl4Var);
                j();
            }
        }
    }

    public void i(tl4 tl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, tl4Var) == null) {
            this.g.d(tl4Var);
        }
    }

    public synchronized boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            synchronized (this) {
                if (this.d == null) {
                    return false;
                }
                Object f = this.d.f();
                if (f instanceof uk4) {
                    return TextUtils.equals(((uk4) f).g, str);
                }
                if (!(f instanceof pm4.a)) {
                    return false;
                }
                return TextUtils.equals(((pm4.a) f).b, str);
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            synchronized (this) {
                Iterator<xl4> f = this.a.f();
                while (f.hasNext()) {
                    xl4 next = f.next();
                    if (next != null) {
                        Object f2 = next.f();
                        if (f2 instanceof uk4) {
                            if (TextUtils.equals(((uk4) f2).g, str)) {
                                return true;
                            }
                        } else if ((f2 instanceof pm4.a) && TextUtils.equals(((pm4.a) f2).b, str)) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                if (this.b.size() < 1) {
                    this.c.execute(new yl4(this.e, this.g, this.h));
                }
            }
        }
    }
}
