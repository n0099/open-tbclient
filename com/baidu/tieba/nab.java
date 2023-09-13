package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import org.chromium.base.Log;
/* loaded from: classes7.dex */
public class nab implements Executor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BlockingQueue<Runnable> a;
    public boolean b;
    public boolean c;
    public InterruptedIOException d;
    public RuntimeException e;
    public final String f;

    public nab(String str) {
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
        this.f = str;
        this.a = new LinkedBlockingQueue();
    }

    public void a() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b(0);
        }
    }

    public void quit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.b = false;
        }
    }

    public void b(int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            long nanoTime = System.nanoTime();
            long convert = TimeUnit.NANOSECONDS.convert(i, TimeUnit.MILLISECONDS);
            if (this.c) {
                InterruptedIOException interruptedIOException = this.d;
                if (interruptedIOException != null) {
                    throw interruptedIOException;
                }
                throw this.e;
            } else if (!this.b) {
                this.b = true;
                while (this.b) {
                    if (i == 0) {
                        try {
                            c(false, 0L).run();
                        } catch (InterruptedIOException e) {
                            this.b = false;
                            this.c = true;
                            this.d = e;
                            throw e;
                        } catch (RuntimeException e2) {
                            this.b = false;
                            this.c = true;
                            this.e = e2;
                            throw e2;
                        }
                    } else {
                        c(true, (convert - System.nanoTime()) + nanoTime).run();
                    }
                }
            } else {
                throw new IllegalStateException("Cannot run loop when it is already running.");
            }
        }
    }

    public final Runnable c(boolean z, long j) throws InterruptedIOException {
        Runnable poll;
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)})) == null) {
            try {
                if (!z) {
                    poll = this.a.take();
                } else {
                    poll = this.a.poll(j, TimeUnit.NANOSECONDS);
                }
                if (poll != null) {
                    return poll;
                }
                Log.e("cr_CronetHttpURLConn", "****** Messageloop timeout exception, url is: %s", this.f);
                throw new SocketTimeoutException();
            } catch (InterruptedException e) {
                InterruptedIOException interruptedIOException = new InterruptedIOException();
                interruptedIOException.initCause(e);
                throw interruptedIOException;
            }
        }
        return (Runnable) invokeCommon.objValue;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) throws RejectedExecutionException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, runnable) == null) {
            if (runnable != null) {
                try {
                    this.a.put(runnable);
                    return;
                } catch (InterruptedException e) {
                    throw new RejectedExecutionException(e);
                }
            }
            throw new IllegalArgumentException();
        }
    }
}
