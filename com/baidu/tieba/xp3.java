package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes8.dex */
public abstract class xp3<OuT> implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final aq3<OuT> a;
    public OuT b;

    public abstract void c();

    /* loaded from: classes8.dex */
    public static class a extends xp3<OuT> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CountDownLatch c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(aq3 aq3Var, CountDownLatch countDownLatch) {
            super(aq3Var, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aq3Var, countDownLatch};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((aq3) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = countDownLatch;
        }

        @Override // com.baidu.tieba.xp3
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.countDown();
            }
        }
    }

    public xp3(aq3<OuT> aq3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aq3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.a = aq3Var;
    }

    public static <OuT> OuT b(aq3<OuT> aq3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, aq3Var)) == null) {
            return (OuT) a(Looper.getMainLooper(), aq3Var);
        }
        return (OuT) invokeL.objValue;
    }

    public /* synthetic */ xp3(aq3 aq3Var, a aVar) {
        this(aq3Var);
    }

    public static <OuT> OuT a(Looper looper, aq3<OuT> aq3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, looper, aq3Var)) == null) {
            if (aq3Var == null) {
                return null;
            }
            if (looper != null && Thread.currentThread() != looper.getThread()) {
                CountDownLatch countDownLatch = new CountDownLatch(1);
                a aVar = new a(aq3Var, countDownLatch);
                new Handler(looper).post(aVar);
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    g82.o("Awaiting", "callOnLooper: Thread=" + Thread.currentThread().getName() + " ret by InterruptedException " + e);
                    e.printStackTrace();
                }
                return aVar.b;
            }
            return aq3Var.create();
        }
        return (OuT) invokeLL.objValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                try {
                    this.b = this.a.create();
                } catch (Exception e) {
                    g82.o("Awaiting", "catch: " + e + "\n" + Log.getStackTraceString(e));
                }
            } finally {
                c();
            }
        }
    }
}
