package com.baidu.tieba;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.thread.task.ElasticTask;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class o21 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile o21 g;
    public transient /* synthetic */ FieldHolder $fh;
    public HandlerThread a;
    public Handler b;
    public m21 c;
    public n21 d;
    public l21 e;
    public p21 f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947980251, "Lcom/baidu/tieba/o21;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947980251, "Lcom/baidu/tieba/o21;");
        }
    }

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o21 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(o21 o21Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o21Var, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o21Var;
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                switch (message.what) {
                    case 1:
                        Object obj = message.obj;
                        if (obj instanceof b) {
                            b bVar = (b) obj;
                            this.a.e.d(bVar.a, bVar.b, bVar.c);
                        }
                        this.a.r();
                        return;
                    case 2:
                        this.a.r();
                        return;
                    case 3:
                        if (this.a.d.a() > 0) {
                            this.a.r();
                            return;
                        }
                        return;
                    case 4:
                        Object obj2 = message.obj;
                        if (obj2 instanceof b) {
                            b bVar2 = (b) obj2;
                            this.a.f.b(bVar2.a, bVar2.b, bVar2.c);
                            this.a.t();
                            return;
                        }
                        return;
                    case 5:
                        this.a.t();
                        return;
                    case 6:
                        this.a.f.a();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Runnable a;
        public String b;
        public int c;

        public b(Runnable runnable, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {runnable, str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = runnable;
            this.b = str;
            this.c = i;
        }
    }

    public o21() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        synchronized (z11.b()) {
            h();
        }
    }

    public static o21 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (g == null) {
                synchronized (o21.class) {
                    if (g == null) {
                        g = new o21();
                    }
                }
            }
            return g;
        }
        return (o21) invokeV.objValue;
    }

    public l21 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.e;
        }
        return (l21) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            j(0L);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            l(0L);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            p(0L);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            do {
            } while (s());
            i();
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f.c();
        }
    }

    public void j(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            Message obtain = Message.obtain();
            obtain.what = 3;
            this.b.sendMessageDelayed(obtain, j);
        }
    }

    public void l(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            Message obtain = Message.obtain();
            obtain.what = 2;
            this.b.sendMessageDelayed(obtain, j);
        }
    }

    public void n(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            Message obtain = Message.obtain();
            obtain.what = 6;
            this.b.sendMessageDelayed(obtain, j);
        }
    }

    public void p(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            Message obtain = Message.obtain();
            obtain.what = 5;
            this.b.sendMessageDelayed(obtain, j);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c = new m21();
            this.d = new n21();
            this.e = new l21();
            this.f = new p21();
            HandlerThread handlerThread = new HandlerThread("ElasticSchedulerThread");
            this.a = handlerThread;
            handlerThread.start();
            this.a.setPriority(10);
            this.b = new a(this, this.a.getLooper());
        }
    }

    public void m(Runnable runnable, String str, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{runnable, str, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = new b(runnable, str, i);
            this.b.sendMessageDelayed(obtain, j);
        }
    }

    public void q(Runnable runnable, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{runnable, str, Long.valueOf(j)}) == null) {
            Message obtain = Message.obtain();
            obtain.what = 4;
            obtain.obj = new b(runnable, str, 4);
            this.b.sendMessageDelayed(obtain, j);
        }
    }

    public final boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ElasticTask b2 = this.e.b();
            if (b2 == null) {
                return false;
            }
            if (this.c.a(b2)) {
                this.e.e(b2);
                return true;
            } else if (!this.d.c(b2)) {
                return false;
            } else {
                this.e.e(b2);
                return true;
            }
        }
        return invokeV.booleanValue;
    }
}
