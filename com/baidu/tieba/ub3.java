package com.baidu.tieba;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.tieba.yw2;
import com.baidu.tieba.zb3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
/* loaded from: classes8.dex */
public abstract class ub3 extends rb3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public static volatile ub3 j;
    public static Handler k;
    public transient /* synthetic */ FieldHolder $fh;
    public ys1 a;
    public final Set<oq3<zb3.a>> b;
    public volatile int c;
    public final Queue<Runnable> d;
    public Runnable e;
    public el4 f;
    public fe3 g;
    public boolean h;

    public abstract el4 I();

    public abstract fe3 J();

    public abstract void Q();

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zb3.a a;
        public final /* synthetic */ ub3 b;

        /* renamed from: com.baidu.tieba.ub3$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC0502a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ oq3 a;
            public final /* synthetic */ a b;

            public RunnableC0502a(a aVar, oq3 oq3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, oq3Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = oq3Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a(this.b.a);
                }
            }
        }

        public a(ub3 ub3Var, zb3.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ub3Var, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ub3Var;
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    z = true;
                } else {
                    z = false;
                }
                for (oq3 oq3Var : this.b.b) {
                    if (z && !this.a.d("event_flag_force_post", false)) {
                        oq3Var.a(this.a);
                    } else {
                        ub3.M().post(new RunnableC0502a(this, oq3Var));
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oq3 a;
        public final /* synthetic */ ub3 b;

        public b(ub3 ub3Var, oq3 oq3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ub3Var, oq3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ub3Var;
            this.a = oq3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.b.add(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oq3 a;
        public final /* synthetic */ ub3 b;

        public c(ub3 ub3Var, oq3 oq3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ub3Var, oq3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ub3Var;
            this.a = oq3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.b.remove(this.a);
            }
        }
    }

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
        i = fs1.a;
    }

    public static ub3 K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            ub3 L = L();
            if (!L.h) {
                L.O();
            }
            return L;
        }
        return (ub3) invokeV.objValue;
    }

    public static Handler M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (k == null) {
                k = new Handler(Looper.getMainLooper());
            }
            return k;
        }
        return (Handler) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yb3
    public fe3 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.g == null) {
                this.g = J();
            }
            return this.g;
        }
        return (fe3) invokeV.objValue;
    }

    public el4 N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f == null) {
                this.f = I();
            }
            return this.f;
        }
        return (el4) invokeV.objValue;
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && !this.h) {
            P();
            N();
            h83.S();
            Q();
            this.h = true;
        }
    }

    public final void P() {
        fe3 B;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (B = B()) != null) {
            B.J();
        }
    }

    @Override // com.baidu.tieba.yb3
    public ys1 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.a == null) {
                this.a = new ys1();
            }
            return this.a;
        }
        return (ys1) invokeV.objValue;
    }

    public ub3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        new yw2.a();
        this.b = new HashSet();
        this.c = 0;
        this.d = new ArrayDeque();
        this.e = null;
        this.h = false;
    }

    @Override // com.baidu.tieba.yb3
    public void o(oq3<zb3.a> oq3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, oq3Var) == null) && oq3Var != null) {
            R(new c(this, oq3Var));
        }
    }

    @Override // com.baidu.tieba.yb3
    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            v(str, null);
        }
    }

    @Override // com.baidu.tieba.yb3
    public void u(oq3<zb3.a> oq3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, oq3Var) == null) && oq3Var != null) {
            R(new b(this, oq3Var));
        }
    }

    public static ub3 L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (j instanceof ac3) {
                return j;
            }
            synchronized (ub3.class) {
                if (j instanceof ac3) {
                    return j;
                }
                SwanAppProcessInfo current = SwanAppProcessInfo.current();
                if (current.isSwanClient) {
                    if (i && j != null) {
                        throw new IllegalStateException("When convinced current process is swan client，but Swan instance already init with: " + j);
                    }
                    j = new ac3();
                    return j;
                } else if (current.isSwanService) {
                    if (!(j instanceof cc3)) {
                        if (i && j != null) {
                            throw new IllegalStateException("When convinced current process is swan service，but Swan instance already init with: " + j);
                        }
                        j = new cc3();
                    }
                    return j;
                } else {
                    if (j == null) {
                        j = new tb3();
                    }
                    return j;
                }
            }
        }
        return (ub3) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yb3
    public void A(zb3.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            if (i) {
                Log.i("SwanImpl", "SwanEvent dispatchEvent: " + aVar + " mEventCallbacks:" + this.b.size());
            }
            if (aVar != null) {
                R(new a(this, aVar));
            }
        }
    }

    public final synchronized void R(@NonNull Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, runnable) == null) {
            synchronized (this) {
                this.d.offer(runnable);
                if (this.e == null) {
                    while (!this.d.isEmpty()) {
                        Runnable poll = this.d.poll();
                        this.e = poll;
                        if (poll != null) {
                            poll.run();
                        }
                        this.e = null;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.yb3
    public void v(String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, bundle) == null) {
            A(new zb3.a(str, bundle));
        }
    }
}
