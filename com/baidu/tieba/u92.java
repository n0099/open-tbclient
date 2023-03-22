package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class u92 implements V8ThreadDelegatePolicy, xs2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public transient /* synthetic */ FieldHolder $fh;
    public V8Engine c;
    public Thread d;
    public Handler e;
    public final Thread f;
    public Runnable g;
    public int h;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u92 a;

        public a(u92 u92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u92Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Looper.prepare();
                this.a.e = new Handler();
                this.a.c.startEngineInternal();
                Looper.loop();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948165755, "Lcom/baidu/tieba/u92;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948165755, "Lcom/baidu/tieba/u92;");
                return;
            }
        }
        i = ak3.a();
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public Thread getThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Handler handler = this.e;
            if (handler != null) {
                return handler.getLooper().getThread();
            }
            return null;
        }
        return (Thread) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public void shutdown() {
        Handler handler;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (handler = this.e) != null) {
            handler.removeCallbacksAndMessages(null);
            this.e.getLooper().quitSafely();
        }
    }

    public u92() {
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
        this.c = null;
        this.d = null;
        this.e = null;
        this.g = null;
        this.h = 0;
        this.f = Looper.getMainLooper().getThread();
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public void doDelegateRunnable(Runnable runnable, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLJ(1048579, this, runnable, j) == null) && this.e != null && !c(runnable)) {
            this.e.postDelayed(runnable, j);
        }
    }

    public void d(@NonNull V8Engine v8Engine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v8Engine) == null) {
            this.c = v8Engine;
        }
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public void doDelegateRunnable(Runnable runnable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, runnable) == null) && this.e != null && !c(runnable)) {
            this.e.post(runnable);
        }
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public void doDelegateRunnableDirectly(Runnable runnable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, runnable) == null) && this.e != null && !c(runnable)) {
            this.e.post(runnable);
        }
    }

    public final boolean c(Runnable runnable) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
            if (runnable != null && this.e != null) {
                Thread currentThread = Thread.currentThread();
                String name = currentThread.getName();
                if (!TextUtils.isEmpty(name) && (name.startsWith("OkHttp") || name.equals("NetworkService"))) {
                    this.e.postAtFrontOfQueue(runnable);
                    return true;
                }
                if (this.f == currentThread) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    if (i) {
                        Runnable runnable2 = this.g;
                        if (runnable2 == null) {
                            this.e.postAtFrontOfQueue(runnable);
                        } else if (this.e.hasCallbacks(runnable2)) {
                            this.e.post(runnable);
                        } else {
                            this.e.postAtFrontOfQueue(runnable);
                        }
                        this.g = runnable;
                    } else {
                        boolean hasMessages = this.e.hasMessages(this.h);
                        this.h++;
                        Message obtain = Message.obtain(this.e, runnable);
                        obtain.what = this.h;
                        if (hasMessages) {
                            this.e.sendMessage(obtain);
                        } else {
                            this.e.sendMessageAtFrontOfQueue(obtain);
                        }
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    @SuppressLint({"MobilebdThread"})
    public void startV8Engine(@NonNull V8Engine v8Engine) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, v8Engine) == null) && this.d == null) {
            Thread thread = new Thread(new a(this));
            this.d = thread;
            thread.setName(v8Engine.threadName());
            this.d.setPriority(10);
            this.d.start();
        }
    }
}
