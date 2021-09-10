package com.baidu.wallet.base.camera.util;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes8.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Thread[] f60292a;

    /* renamed from: b  reason: collision with root package name */
    public LinkedBlockingQueue<Runnable> f60293b;

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
        this.f60292a = null;
        this.f60293b = null;
        this.f60293b = new LinkedBlockingQueue<>();
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
            int a2 = a(i2);
            c cVar = new c();
            cVar.f60292a = new Thread[a2];
            for (int i3 = a2 - 1; i3 >= 0; i3 += -1) {
                cVar.f60292a[i3] = new Thread(new d(cVar.f60293b));
                cVar.f60292a[i3].setPriority(5);
                cVar.f60292a[i3].setName(str + " " + a2 + "." + (i3 + 1));
                cVar.f60292a[i3].start();
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
            this.f60293b.put(runnable);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    public void a() {
        Thread[] threadArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f60293b.clear();
            for (Thread thread : this.f60292a) {
                if (thread.isAlive()) {
                    this.f60293b.offer(new b());
                }
            }
            for (Thread thread2 : this.f60292a) {
                if (thread2.isAlive()) {
                    try {
                        synchronized (this) {
                            wait(2000 / this.f60292a.length);
                        }
                    } catch (InterruptedException unused) {
                    }
                    thread2.interrupt();
                }
            }
        }
    }
}
