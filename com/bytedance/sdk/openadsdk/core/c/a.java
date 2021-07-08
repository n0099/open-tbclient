package com.bytedance.sdk.openadsdk.core.c;

import android.os.Handler;
import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.core.j.h;
import com.bytedance.sdk.openadsdk.core.o;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f29892a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f29893b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile long f29894c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public final Queue<C0336a> f29895d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f29896e;

    /* renamed from: f  reason: collision with root package name */
    public final h f29897f;

    /* renamed from: com.bytedance.sdk.openadsdk.core.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0336a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final long f29899a;

        /* renamed from: b  reason: collision with root package name */
        public final String f29900b;

        public C0336a(long j, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29899a = j;
            this.f29900b = str;
        }
    }

    public a() {
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
        this.f29895d = new LinkedList();
        this.f29897f = o.h();
    }

    private synchronized boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str)) == null) {
            synchronized (this) {
                long currentTimeMillis = System.currentTimeMillis();
                int l = this.f29897f.l();
                long k = this.f29897f.k();
                if (this.f29895d.size() > 0 && this.f29895d.size() >= l) {
                    long abs = Math.abs(currentTimeMillis - this.f29895d.peek().f29899a);
                    if (abs <= k) {
                        b(k - abs);
                        return true;
                    }
                    this.f29895d.poll();
                    this.f29895d.offer(new C0336a(currentTimeMillis, str));
                } else {
                    this.f29895d.offer(new C0336a(currentTimeMillis, str));
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public synchronized String c() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                HashMap hashMap = new HashMap();
                for (C0336a c0336a : this.f29895d) {
                    if (hashMap.containsKey(c0336a.f29900b)) {
                        hashMap.put(c0336a.f29900b, Integer.valueOf(((Integer) hashMap.get(c0336a.f29900b)).intValue() + 1));
                    } else {
                        hashMap.put(c0336a.f29900b, 1);
                    }
                }
                int i2 = Integer.MIN_VALUE;
                str = "";
                for (String str2 : hashMap.keySet()) {
                    int intValue = ((Integer) hashMap.get(str2)).intValue();
                    if (i2 < intValue) {
                        str = str2;
                        i2 = intValue;
                    }
                }
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f29892a == null) {
                synchronized (a.class) {
                    if (f29892a == null) {
                        f29892a = new a();
                    }
                }
            }
            return f29892a;
        }
        return (a) invokeV.objValue;
    }

    public synchronized boolean a(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (this) {
                if (b(str)) {
                    a(true);
                    a(f29894c);
                } else {
                    a(false);
                }
                z = f29893b;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    private synchronized void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, this, j) == null) {
            synchronized (this) {
                if (this.f29896e == null) {
                    this.f29896e = new Handler(Looper.getMainLooper());
                }
                this.f29896e.postDelayed(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.core.c.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f29898a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f29898a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f29898a.a(false);
                        }
                    }
                }, j);
            }
        }
    }

    public synchronized boolean b() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                z = f29893b;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    private synchronized void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(AdIconUtil.AD_TEXT_ID, this, j) == null) {
            synchronized (this) {
                f29894c = j;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, this, z) == null) {
            synchronized (this) {
                f29893b = z;
            }
        }
    }
}
