package com.baidu.tts;

import android.content.Context;
import android.os.Process;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.k;
import com.baidu.tts.l;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes9.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final e1<l, l.a> a;
    public final e1<k, k.a> b;

    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final g a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1850296577, "Lcom/baidu/tts/g$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1850296577, "Lcom/baidu/tts/g$a;");
                    return;
                }
            }
            a = new g();
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Callable<k.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final t1 a;
        public final /* synthetic */ g b;

        public b(g gVar, t1 t1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, t1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gVar;
            this.a = t1Var;
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.baidu.tts.k$a, java.lang.Object] */
        @Override // java.util.concurrent.Callable
        public k.a call() throws Exception {
            InterceptResult invokeV;
            Context context;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Integer num = k2.b;
                if (num != null) {
                    Process.setThreadPriority(num.intValue());
                }
                k.a aVar = new k.a();
                a1 a = b1.d().a();
                if (a == null) {
                    aVar.a(z0.a().a(u0.H0));
                    return aVar;
                }
                t1 t1Var = this.a;
                String str = t1Var.q;
                String str2 = t1Var.r;
                String str3 = t1Var.s;
                String str4 = t1Var.p;
                if (w0.b(str4)) {
                    if (a.c == null) {
                        WeakReference<Context> weakReference = a.a;
                        if (weakReference == null) {
                            context = null;
                        } else {
                            context = weakReference.get();
                        }
                        if (context != null) {
                            a.c = context.getFilesDir().getAbsolutePath() + File.separator + "baidu_tts_license";
                        }
                    }
                    str4 = a.c;
                }
                LoggerProxy.d("AuthClient", "appCode=" + str + " , licenseFilePath=" + str4);
                k kVar = new k();
                kVar.a = str;
                kVar.b = str2;
                kVar.c = str3;
                kVar.d = str4;
                return this.b.b.a(kVar);
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Callable<l.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final u1 a;
        public final /* synthetic */ g b;

        public c(g gVar, u1 u1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, u1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gVar;
            this.a = u1Var;
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.baidu.tts.l$a, java.lang.Object] */
        @Override // java.util.concurrent.Callable
        public l.a call() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                u1 u1Var = this.a;
                String str = u1Var.h;
                String str2 = u1Var.l;
                String str3 = u1Var.m;
                String str4 = u1Var.n;
                LoggerProxy.d("AuthClient", "pid=" + str);
                LoggerProxy.d("AuthClient", "key=" + str4);
                LoggerProxy.d("AuthClient", "ak=" + str2);
                LoggerProxy.d("AuthClient", "sk=" + str3);
                l lVar = new l();
                lVar.a = str;
                return this.b.a.a(lVar);
            }
            return invokeV.objValue;
        }
    }

    public g() {
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
        this.a = new e1<>();
        this.b = new e1<>();
    }

    public h a(t0 t0Var, x1 x1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, t0Var, x1Var)) == null) {
            q1 q1Var = x1Var.b;
            h hVar = new h();
            hVar.a = t0Var;
            int ordinal = t0Var.ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (ordinal == 2) {
                        LoggerProxy.d("AuthClient", "enter authMix");
                        CountDownLatch countDownLatch = new CountDownLatch(2);
                        FutureTask futureTask = new FutureTask(new e(this, q1Var, countDownLatch));
                        FutureTask futureTask2 = new FutureTask(new f(this, q1Var, countDownLatch));
                        new i2(futureTask, "bds-online").start();
                        new i2(futureTask2, "bds-offline").start();
                        try {
                            LoggerProxy.d("AuthClient", "+ await");
                            countDownLatch.await();
                            LoggerProxy.d("AuthClient", "- await");
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                            futureTask.cancel(true);
                            futureTask2.cancel(true);
                        }
                        l.a aVar = new l.a();
                        LoggerProxy.d("AuthClient", "+ mix online get onlineResult=" + aVar);
                        try {
                            aVar = (l.a) futureTask.get();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            futureTask.cancel(true);
                            d a2 = z0.a().a(u0.f);
                            a2.a = e;
                            aVar.a(a2);
                        } catch (CancellationException e2) {
                            d a3 = z0.a().a(u0.r);
                            a3.a = e2;
                            aVar.a(a3);
                        } catch (ExecutionException e3) {
                            z0 a4 = z0.a();
                            u0 u0Var = u0.g;
                            Throwable cause = e3.getCause();
                            d a5 = a4.a(u0Var);
                            a5.a = cause;
                            aVar.a(a5);
                        }
                        LoggerProxy.d("AuthClient", "- online get");
                        k.a aVar2 = new k.a();
                        LoggerProxy.d("AuthClient", "+ mix offline get offlineResult=" + aVar2);
                        try {
                            aVar2 = (k.a) futureTask2.get();
                        } catch (InterruptedException e4) {
                            Thread.currentThread().interrupt();
                            futureTask2.cancel(true);
                            d a6 = z0.a().a(u0.f1189T);
                            a6.a = e4;
                            aVar2.a(a6);
                        } catch (CancellationException e5) {
                            d a7 = z0.a().a(u0.g0);
                            a7.a = e5;
                            aVar2.a(a7);
                        } catch (ExecutionException e6) {
                            z0 a8 = z0.a();
                            u0 u0Var2 = u0.U;
                            Throwable cause2 = e6.getCause();
                            d a9 = a8.a(u0Var2);
                            a9.a = cause2;
                            aVar2.a(a9);
                        }
                        LoggerProxy.d("AuthClient", "- offline get");
                        h hVar2 = new h();
                        hVar2.a = t0.e;
                        hVar2.b = aVar;
                        hVar2.c = aVar2;
                        LoggerProxy.d("AuthClient", "end authMix");
                        return hVar2;
                    }
                    return hVar;
                }
                hVar.c = a(q1Var.b);
                return hVar;
            }
            hVar.b = a(q1Var.a);
            return hVar;
        }
        return (h) invokeLL.objValue;
    }

    public k.a a(t1 t1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t1Var)) == null) {
            k.a aVar = new k.a();
            try {
                return (k.a) a(new b(this, t1Var), LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                d a2 = z0.a().a(u0.f1189T);
                a2.a = e;
                aVar.a(a2);
                return aVar;
            } catch (CancellationException e2) {
                d a3 = z0.a().a(u0.g0);
                a3.a = e2;
                aVar.a(a3);
                return aVar;
            } catch (ExecutionException e3) {
                z0 a4 = z0.a();
                u0 u0Var = u0.U;
                Throwable cause = e3.getCause();
                d a5 = a4.a(u0Var);
                a5.a = cause;
                aVar.a(a5);
                return aVar;
            } catch (TimeoutException e4) {
                d a6 = z0.a().a(u0.V);
                a6.a = e4;
                aVar.a(a6);
                return aVar;
            }
        }
        return (k.a) invokeL.objValue;
    }

    public l.a a(u1 u1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, u1Var)) == null) {
            l.a aVar = new l.a();
            try {
                return (l.a) a(new c(this, u1Var), LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                d a2 = z0.a().a(u0.f);
                a2.a = e;
                aVar.a(a2);
                return aVar;
            } catch (CancellationException e2) {
                d a3 = z0.a().a(u0.r);
                a3.a = e2;
                aVar.a(a3);
                return aVar;
            } catch (ExecutionException e3) {
                z0 a4 = z0.a();
                u0 u0Var = u0.g;
                Throwable cause = e3.getCause();
                d a5 = a4.a(u0Var);
                a5.a = cause;
                aVar.a(a5);
                return aVar;
            } catch (TimeoutException e4) {
                d a6 = z0.a().a(u0.h);
                a6.a = e4;
                aVar.a(a6);
                return aVar;
            }
        }
        return (l.a) invokeL.objValue;
    }

    public final <T> T a(Callable<T> callable, long j) throws InterruptedException, ExecutionException, TimeoutException {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048579, this, callable, j)) == null) {
            FutureTask futureTask = new FutureTask(callable);
            new i2(futureTask, "bds-auth").start();
            return (T) futureTask.get(j, TimeUnit.MILLISECONDS);
        }
        return (T) invokeLJ.objValue;
    }
}
