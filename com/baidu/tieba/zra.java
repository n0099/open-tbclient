package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.rra;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
import rx.exceptions.OnErrorNotImplementedException;
/* loaded from: classes7.dex */
public class zra extends rra {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler a;

    /* loaded from: classes7.dex */
    public static class a extends rra.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Handler a;
        public final xra b;
        public volatile boolean c;

        public a(Handler handler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {handler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = handler;
            this.b = wra.a().b();
        }

        @Override // com.baidu.tieba.rra.a
        public vra b(bsa bsaVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bsaVar)) == null) {
                return c(bsaVar, 0L, TimeUnit.MILLISECONDS);
            }
            return (vra) invokeL.objValue;
        }

        @Override // com.baidu.tieba.rra.a
        public vra c(bsa bsaVar, long j, TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bsaVar, Long.valueOf(j), timeUnit})) == null) {
                if (this.c) {
                    return lwa.c();
                }
                this.b.c(bsaVar);
                b bVar = new b(bsaVar, this.a);
                Message obtain = Message.obtain(this.a, bVar);
                obtain.obj = this;
                this.a.sendMessageDelayed(obtain, timeUnit.toMillis(j));
                if (this.c) {
                    this.a.removeCallbacks(bVar);
                    return lwa.c();
                }
                return bVar;
            }
            return (vra) invokeCommon.objValue;
        }

        @Override // com.baidu.tieba.vra
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.c;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.vra
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.c = true;
                this.a.removeCallbacksAndMessages(this);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements Runnable, vra {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final bsa a;
        public final Handler b;
        public volatile boolean c;

        public b(bsa bsaVar, Handler handler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bsaVar, handler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bsaVar;
            this.b = handler;
        }

        @Override // com.baidu.tieba.vra
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.c;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.vra
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.c = true;
                this.b.removeCallbacks(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IllegalStateException illegalStateException;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                try {
                    this.a.call();
                } catch (Throwable th) {
                    if (th instanceof OnErrorNotImplementedException) {
                        illegalStateException = new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", th);
                    } else {
                        illegalStateException = new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", th);
                    }
                    yva.c().b().a(illegalStateException);
                    Thread currentThread = Thread.currentThread();
                    currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, illegalStateException);
                }
            }
        }
    }

    public zra(Looper looper) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {looper};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new Handler(looper);
    }

    @Override // com.baidu.tieba.rra
    public rra.a createWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new a(this.a);
        }
        return (rra.a) invokeV.objValue;
    }
}
