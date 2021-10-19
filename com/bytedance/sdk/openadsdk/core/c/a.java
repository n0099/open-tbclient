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
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f66612a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f66613b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile long f66614c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public final Queue<C1909a> f66615d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f66616e;

    /* renamed from: f  reason: collision with root package name */
    public final h f66617f;

    /* renamed from: com.bytedance.sdk.openadsdk.core.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1909a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final long f66619a;

        /* renamed from: b  reason: collision with root package name */
        public final String f66620b;

        public C1909a(long j2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66619a = j2;
            this.f66620b = str;
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
        this.f66615d = new LinkedList();
        this.f66617f = o.h();
    }

    private synchronized boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str)) == null) {
            synchronized (this) {
                long currentTimeMillis = System.currentTimeMillis();
                int l = this.f66617f.l();
                long k = this.f66617f.k();
                if (this.f66615d.size() > 0 && this.f66615d.size() >= l) {
                    long abs = Math.abs(currentTimeMillis - this.f66615d.peek().f66619a);
                    if (abs <= k) {
                        b(k - abs);
                        return true;
                    }
                    this.f66615d.poll();
                    this.f66615d.offer(new C1909a(currentTimeMillis, str));
                } else {
                    this.f66615d.offer(new C1909a(currentTimeMillis, str));
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
                for (C1909a c1909a : this.f66615d) {
                    if (hashMap.containsKey(c1909a.f66620b)) {
                        hashMap.put(c1909a.f66620b, Integer.valueOf(((Integer) hashMap.get(c1909a.f66620b)).intValue() + 1));
                    } else {
                        hashMap.put(c1909a.f66620b, 1);
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
            if (f66612a == null) {
                synchronized (a.class) {
                    if (f66612a == null) {
                        f66612a = new a();
                    }
                }
            }
            return f66612a;
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
                    a(f66614c);
                } else {
                    a(false);
                }
                z = f66613b;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    private synchronized void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, this, j2) == null) {
            synchronized (this) {
                if (this.f66616e == null) {
                    this.f66616e = new Handler(Looper.getMainLooper());
                }
                this.f66616e.postDelayed(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.core.c.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f66618a;

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
                        this.f66618a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f66618a.a(false);
                        }
                    }
                }, j2);
            }
        }
    }

    public synchronized boolean b() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                z = f66613b;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    private synchronized void b(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(AdIconUtil.AD_TEXT_ID, this, j2) == null) {
            synchronized (this) {
                f66614c = j2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, this, z) == null) {
            synchronized (this) {
                f66613b = z;
            }
        }
    }
}
