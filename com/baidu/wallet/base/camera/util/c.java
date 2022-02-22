package com.baidu.wallet.base.camera.util;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes13.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Thread[] a;

    /* renamed from: b  reason: collision with root package name */
    public LinkedBlockingQueue<Runnable> f50716b;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f50716b = null;
        this.f50716b = new LinkedBlockingQueue<>();
    }

    public static int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            if (i2 <= 0 || 20 < i2) {
                return 4;
            }
            return i2;
        }
        return invokeI.intValue;
    }

    public static c a(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65538, null, i2, str)) == null) {
            if (str == null) {
                str = "";
            }
            int a = a(i2);
            c cVar = new c();
            cVar.a = new Thread[a];
            for (int i3 = a - 1; i3 >= 0; i3 += -1) {
                cVar.a[i3] = new Thread(new d(cVar.f50716b));
                cVar.a[i3].setPriority(5);
                cVar.a[i3].setName(str + " " + a + "." + (i3 + 1));
                cVar.a[i3].start();
            }
            return cVar;
        }
        return (c) invokeIL.objValue;
    }

    public void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable) == null) || runnable == null) {
            return;
        }
        try {
            this.f50716b.put(runnable);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    public void a() {
        Thread[] threadArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f50716b.clear();
            for (Thread thread : this.a) {
                if (thread.isAlive()) {
                    this.f50716b.offer(new b());
                }
            }
            for (Thread thread2 : this.a) {
                if (thread2.isAlive()) {
                    try {
                        synchronized (this) {
                            wait(2000 / this.a.length);
                        }
                    } catch (InterruptedException unused) {
                    }
                    thread2.interrupt();
                }
            }
        }
    }
}
