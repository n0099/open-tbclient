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
    public static volatile a f65886a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f65887b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile long f65888c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public final Queue<C1899a> f65889d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f65890e;

    /* renamed from: f  reason: collision with root package name */
    public final h f65891f;

    /* renamed from: com.bytedance.sdk.openadsdk.core.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1899a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final long f65893a;

        /* renamed from: b  reason: collision with root package name */
        public final String f65894b;

        public C1899a(long j2, String str) {
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
            this.f65893a = j2;
            this.f65894b = str;
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
        this.f65889d = new LinkedList();
        this.f65891f = o.h();
    }

    private synchronized boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str)) == null) {
            synchronized (this) {
                long currentTimeMillis = System.currentTimeMillis();
                int l = this.f65891f.l();
                long k = this.f65891f.k();
                if (this.f65889d.size() > 0 && this.f65889d.size() >= l) {
                    long abs = Math.abs(currentTimeMillis - this.f65889d.peek().f65893a);
                    if (abs <= k) {
                        b(k - abs);
                        return true;
                    }
                    this.f65889d.poll();
                    this.f65889d.offer(new C1899a(currentTimeMillis, str));
                } else {
                    this.f65889d.offer(new C1899a(currentTimeMillis, str));
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
                for (C1899a c1899a : this.f65889d) {
                    if (hashMap.containsKey(c1899a.f65894b)) {
                        hashMap.put(c1899a.f65894b, Integer.valueOf(((Integer) hashMap.get(c1899a.f65894b)).intValue() + 1));
                    } else {
                        hashMap.put(c1899a.f65894b, 1);
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
            if (f65886a == null) {
                synchronized (a.class) {
                    if (f65886a == null) {
                        f65886a = new a();
                    }
                }
            }
            return f65886a;
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
                    a(f65888c);
                } else {
                    a(false);
                }
                z = f65887b;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    private synchronized void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, this, j2) == null) {
            synchronized (this) {
                if (this.f65890e == null) {
                    this.f65890e = new Handler(Looper.getMainLooper());
                }
                this.f65890e.postDelayed(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.core.c.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f65892a;

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
                        this.f65892a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f65892a.a(false);
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
                z = f65887b;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    private synchronized void b(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(AdIconUtil.AD_TEXT_ID, this, j2) == null) {
            synchronized (this) {
                f65888c = j2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, this, z) == null) {
            synchronized (this) {
                f65887b = z;
            }
        }
    }
}
