package com.baidu.tieba;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class le0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String h = "le0";
    public transient /* synthetic */ FieldHolder $fh;
    public HandlerThread a;
    public Handler b;
    public od0 c;
    public se0 d;
    public qe0 e;
    public volatile boolean f;
    public boolean g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947939858, "Lcom/baidu/tieba/le0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947939858, "Lcom/baidu/tieba/le0;");
        }
    }

    /* loaded from: classes6.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ArrayList<ce0> a;
        public pe0 b;

        public a(le0 le0Var, ArrayList<ce0> arrayList, pe0 pe0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {le0Var, arrayList, pe0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = arrayList;
            this.b = pe0Var;
        }
    }

    /* loaded from: classes6.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ le0 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(le0 le0Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {le0Var, looper};
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
            this.a = le0Var;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                switch (message.what) {
                    case 1001:
                        a aVar = (a) message.obj;
                        this.a.n(aVar.a, aVar.b);
                        return;
                    case 1002:
                        this.a.o();
                        return;
                    case 1003:
                        this.a.r((ArrayList) message.obj);
                        return;
                    case 1004:
                        this.a.q((vd0) message.obj);
                        return;
                    case 1005:
                        this.a.k((message.arg1 << 32) | (message.arg2 & 4294967295L));
                        return;
                    case 1006:
                        this.a.p();
                        return;
                    case 1007:
                        this.a.m();
                        return;
                    case 1008:
                        this.a.l();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public le0() {
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
        this.f = false;
        this.g = false;
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            se0 se0Var = this.d;
            if (se0Var != null) {
                return se0Var.d();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Handler handler = this.b;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.b = null;
            }
            HandlerThread handlerThread = this.a;
            if (handlerThread != null) {
                handlerThread.quit();
                this.a = null;
            }
        }
    }

    public final void m() {
        se0 se0Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || Build.VERSION.SDK_INT < 18 || (se0Var = this.d) == null) {
            return;
        }
        se0Var.i();
        this.d.e();
        this.d = null;
        this.e = null;
        this.c.c();
        this.c = null;
    }

    public final void o() {
        se0 se0Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || Build.VERSION.SDK_INT < 18 || (se0Var = this.d) == null) {
            return;
        }
        se0Var.h();
    }

    public final void p() {
        se0 se0Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || Build.VERSION.SDK_INT < 18 || (se0Var = this.d) == null) {
            return;
        }
        se0Var.c(true);
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            HandlerThread handlerThread = this.a;
            if (handlerThread != null && handlerThread.isAlive()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void u() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.b != null && this.f) {
            this.b.removeMessages(1005);
        }
    }

    public void v() {
        Handler handler;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (handler = this.b) != null) {
            handler.removeCallbacksAndMessages(null);
            Handler handler2 = this.b;
            handler2.sendMessage(handler2.obtainMessage(1007));
            Handler handler3 = this.b;
            handler3.sendMessage(handler3.obtainMessage(1008));
        }
    }

    public void x() {
        Handler handler;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (handler = this.b) != null) {
            handler.sendMessage(handler.obtainMessage(1002));
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.b != null && this.f) {
            this.f = false;
            this.b.removeMessages(1005);
            Handler handler = this.b;
            handler.sendMessage(handler.obtainMessage(1006));
        }
    }

    public final void k(long j) {
        se0 se0Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) != null) || Build.VERSION.SDK_INT < 18 || (se0Var = this.d) == null) {
            return;
        }
        se0Var.c(false);
        this.c.a(j);
    }

    public final void q(vd0 vd0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, vd0Var) == null) && Build.VERSION.SDK_INT >= 18) {
            this.c.d(vd0Var);
        }
    }

    public final void r(ArrayList<ce0> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, arrayList) == null) && Build.VERSION.SDK_INT >= 18) {
            this.c.e(arrayList);
        }
    }

    public void z(ArrayList<ce0> arrayList) {
        Handler handler;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, arrayList) == null) && (handler = this.b) != null) {
            handler.sendMessage(handler.obtainMessage(1003, arrayList));
        }
    }

    public final void n(ArrayList<ce0> arrayList, pe0 pe0Var) {
        se0 se0Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048581, this, arrayList, pe0Var) != null) || Build.VERSION.SDK_INT < 18 || (se0Var = this.d) == null) {
            return;
        }
        se0Var.l(pe0Var, this.e);
        if (this.c == null) {
            this.c = new od0(this.d.k(), arrayList);
        }
    }

    public void i(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            int i = (int) (j >> 32);
            int i2 = (int) j;
            if (this.b != null && this.f) {
                Handler handler = this.b;
                handler.sendMessage(handler.obtainMessage(1005, i, i2));
                synchronized (this.c) {
                    try {
                        if (this.g) {
                            this.c.wait(12L);
                        } else {
                            this.c.wait(2L);
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    public final void s(qe0 qe0Var, oe0 oe0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, qe0Var, oe0Var) == null) {
            HandlerThread handlerThread = new HandlerThread("VideoRecorderThread");
            this.a = handlerThread;
            handlerThread.start();
            this.b = new b(this, this.a.getLooper());
            if (Build.VERSION.SDK_INT >= 18) {
                try {
                    this.d = new se0();
                } catch (VerifyError unused) {
                    Log.e(h, "initRecorder videorecorder verifyError");
                    if (this.d == null) {
                        return;
                    }
                }
                this.d.f(oe0Var);
                this.e = qe0Var;
            }
            if (Build.HARDWARE.toLowerCase().startsWith("kirin")) {
                this.g = true;
            } else {
                this.g = false;
            }
        }
    }

    public boolean w(ArrayList<ce0> arrayList, pe0 pe0Var, qe0 qe0Var, oe0 oe0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, arrayList, pe0Var, qe0Var, oe0Var)) == null) {
            if (t()) {
                Log.e(h, "setupRecorder error! As last video recorder thread is alive!");
                return false;
            }
            s(qe0Var, oe0Var);
            a aVar = new a(this, arrayList, pe0Var);
            Handler handler = this.b;
            handler.sendMessage(handler.obtainMessage(1001, aVar));
            this.f = true;
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
