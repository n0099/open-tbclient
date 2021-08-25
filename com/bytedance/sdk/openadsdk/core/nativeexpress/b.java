package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirConstants;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.core.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: j  reason: collision with root package name */
    public static Set<b> f66681j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AdSlot f66682a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.core.p f66683b;

    /* renamed from: c  reason: collision with root package name */
    public Context f66684c;

    /* renamed from: d  reason: collision with root package name */
    public TTAdNative.NativeExpressAdListener f66685d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicBoolean f66686e;

    /* renamed from: f  reason: collision with root package name */
    public List<com.bytedance.sdk.openadsdk.core.e.m> f66687f;

    /* renamed from: g  reason: collision with root package name */
    public List<com.bytedance.sdk.openadsdk.core.e.m> f66688g;

    /* renamed from: h  reason: collision with root package name */
    public a f66689h;

    /* renamed from: i  reason: collision with root package name */
    public int f66690i;
    public ScheduledFuture<?> k;
    public ScheduledFuture<?> l;
    public ScheduledFuture<?> m;

    /* loaded from: classes9.dex */
    public interface a {
        void a();

        void a(List<com.bytedance.sdk.openadsdk.core.e.m> list);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-364922262, "Lcom/bytedance/sdk/openadsdk/core/nativeexpress/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-364922262, "Lcom/bytedance/sdk/openadsdk/core/nativeexpress/b;");
                return;
            }
        }
        f66681j = Collections.synchronizedSet(new HashSet());
    }

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f66686e = new AtomicBoolean(false);
        this.f66690i = 5;
        this.k = null;
        this.l = null;
        this.m = null;
        this.f66683b = com.bytedance.sdk.openadsdk.core.o.f();
        if (context != null) {
            this.f66684c = context.getApplicationContext();
        } else {
            this.f66684c = com.bytedance.sdk.openadsdk.core.o.a();
        }
        f66681j.add(this);
    }

    private void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65559, this, z) == null) {
            try {
                if (this.k == null || this.k.isCancelled()) {
                    return;
                }
                boolean cancel = this.k.cancel(z);
                com.bytedance.sdk.component.utils.k.f("ExpressAdLoadManager", "TimeOutFutureTask-->cancel......success=" + cancel);
            } catch (Throwable unused) {
            }
        }
    }

    private void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65557, this, z) == null) {
            try {
                if (this.m == null || this.m.isCancelled()) {
                    return;
                }
                boolean cancel = this.m.cancel(z);
                com.bytedance.sdk.component.utils.k.b("ExpressAdLoadManager", "CheckValidDoneFutureTask-->cancel.....success=" + cancel);
            } catch (Throwable unused) {
            }
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            f66681j.remove(this);
        }
    }

    public static b a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? new b(context) : (b) invokeL.objValue;
    }

    public void a(AdSlot adSlot, int i2, @NonNull TTAdNative.NativeExpressAdListener nativeExpressAdListener, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adSlot, Integer.valueOf(i2), nativeExpressAdListener, Integer.valueOf(i3)}) == null) {
            a(adSlot, i2, nativeExpressAdListener, null, i3);
        }
    }

    public void a(AdSlot adSlot, int i2, @Nullable TTAdNative.NativeExpressAdListener nativeExpressAdListener, @Nullable a aVar, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{adSlot, Integer.valueOf(i2), nativeExpressAdListener, aVar, Integer.valueOf(i3)}) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f66686e.get()) {
                com.bytedance.sdk.component.utils.k.f("ExpressAdLoadManager", "express ad is loading...");
                return;
            }
            this.f66690i = i2;
            this.f66686e.set(true);
            this.f66682a = adSlot;
            this.f66685d = nativeExpressAdListener;
            this.f66689h = aVar;
            a(adSlot, currentTimeMillis);
        }
    }

    private void a(AdSlot adSlot, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(65548, this, adSlot, j2) == null) || adSlot == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.e.n nVar = new com.bytedance.sdk.openadsdk.core.e.n();
        nVar.f66313e = 2;
        this.f66683b.a(adSlot, nVar, this.f66690i, new p.b(this, adSlot, j2) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ AdSlot f66691a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f66692b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b f66693c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, adSlot, Long.valueOf(j2)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f66693c = this;
                this.f66691a = adSlot;
                this.f66692b = j2;
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.b
            public void a(int i2, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                    this.f66693c.a(i2, str);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.b
            public void a(com.bytedance.sdk.openadsdk.core.e.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                    if (aVar.c() != null && !aVar.c().isEmpty()) {
                        this.f66693c.f66687f = aVar.c();
                        this.f66693c.f66688g = aVar.c();
                        this.f66693c.a(this.f66691a);
                        this.f66693c.a(this.f66692b);
                        return;
                    }
                    this.f66693c.a(-3, com.bytedance.sdk.openadsdk.core.g.a(-3));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdSlot adSlot) {
        List<com.bytedance.sdk.openadsdk.core.e.m> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, this, adSlot) == null) || (list = this.f66687f) == null) {
            return;
        }
        for (com.bytedance.sdk.openadsdk.core.e.m mVar : list) {
            if (mVar.aK() && mVar.ad() != null && !mVar.ad().isEmpty()) {
                for (com.bytedance.sdk.openadsdk.core.e.l lVar : mVar.ad()) {
                    if (!TextUtils.isEmpty(lVar.a())) {
                        com.bytedance.sdk.openadsdk.k.d.b().d().a(new com.bytedance.sdk.openadsdk.k.a(lVar.a(), lVar.g()), com.bytedance.sdk.openadsdk.k.a.a.b(), lVar.b(), lVar.c(), false);
                    }
                }
            }
            if (com.bytedance.sdk.openadsdk.core.e.m.b(mVar) && mVar.V() != null && mVar.V().i() != null) {
                if (com.bytedance.sdk.openadsdk.core.o.h().a(String.valueOf(com.bytedance.sdk.openadsdk.q.q.d(mVar.ao()))) && com.bytedance.sdk.openadsdk.core.o.h().M()) {
                    com.bytedance.sdk.openadsdk.n.f.b bVar = new com.bytedance.sdk.openadsdk.n.f.b();
                    bVar.a(mVar.V().i());
                    bVar.a(mVar.V().m());
                    bVar.b(mVar.V().l());
                    bVar.c(CacheDirConstants.getFeedCacheDir());
                    bVar.a(mVar);
                    bVar.a(adSlot);
                    bVar.b(mVar.V().d());
                    bVar.a(adSlot);
                    bVar.a(mVar);
                    com.bytedance.sdk.openadsdk.core.video.d.c.a(bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(65546, this, j2) == null) && this.f66686e.getAndSet(false)) {
            new Handler(Looper.getMainLooper()).post(new Runnable(this, j2) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ long f66694a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f66695b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f66695b = this;
                    this.f66694a = j2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.f66695b.f66688g == null || this.f66695b.f66688g.size() <= 0) {
                            if (this.f66695b.f66685d != null) {
                                this.f66695b.f66685d.onError(108, com.bytedance.sdk.openadsdk.core.g.a(108));
                                this.f66695b.a(108);
                            }
                            if (this.f66695b.f66689h != null) {
                                this.f66695b.f66689h.a();
                            }
                        } else {
                            if (this.f66695b.f66685d != null) {
                                ArrayList arrayList = new ArrayList(this.f66695b.f66688g.size());
                                for (com.bytedance.sdk.openadsdk.core.e.m mVar : this.f66695b.f66688g) {
                                    arrayList.add(this.f66695b.a(mVar));
                                }
                                if (!arrayList.isEmpty()) {
                                    com.bytedance.sdk.openadsdk.e.d.a(this.f66695b.f66684c, (com.bytedance.sdk.openadsdk.core.e.m) this.f66695b.f66688g.get(0), com.bytedance.sdk.openadsdk.q.q.b(this.f66695b.f66682a.getDurationSlotType()), this.f66694a);
                                    this.f66695b.f66685d.onNativeExpressAdLoad(arrayList);
                                } else {
                                    this.f66695b.f66685d.onError(103, com.bytedance.sdk.openadsdk.core.g.a(103));
                                    this.f66695b.a(103);
                                }
                            }
                            if (this.f66695b.f66689h != null) {
                                this.f66695b.f66689h.a(this.f66695b.f66688g);
                            }
                        }
                        this.f66695b.a();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65544, this, i2) == null) {
            List<com.bytedance.sdk.openadsdk.core.e.m> list = this.f66687f;
            com.bytedance.sdk.openadsdk.j.a.c f2 = com.bytedance.sdk.openadsdk.j.a.c.b().a(this.f66690i).c(this.f66682a.getCodeId()).f((list == null || list.size() <= 0) ? "" : com.bytedance.sdk.openadsdk.q.q.h(this.f66687f.get(0).ao()));
            f2.b(i2).g(com.bytedance.sdk.openadsdk.core.g.a(i2));
            com.bytedance.sdk.openadsdk.j.a.a().h(f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(65545, this, i2, str) == null) && this.f66686e.getAndSet(false)) {
            TTAdNative.NativeExpressAdListener nativeExpressAdListener = this.f66685d;
            if (nativeExpressAdListener != null) {
                nativeExpressAdListener.onError(i2, str);
            }
            a aVar = this.f66689h;
            if (aVar != null) {
                aVar.a();
            }
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TTNativeExpressAd a(com.bytedance.sdk.openadsdk.core.e.m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, mVar)) == null) {
            int i2 = this.f66690i;
            if (i2 == 1) {
                if (mVar.V() != null) {
                    return new com.bytedance.sdk.openadsdk.core.bannerexpress.c(this.f66684c, mVar, this.f66682a);
                }
                return new com.bytedance.sdk.openadsdk.core.bannerexpress.b(this.f66684c, mVar, this.f66682a);
            } else if (i2 == 2) {
                if (mVar.V() != null) {
                    return new com.bytedance.sdk.openadsdk.core.d.c(this.f66684c, mVar, this.f66682a);
                }
                return new com.bytedance.sdk.openadsdk.core.d.b(this.f66684c, mVar, this.f66682a);
            } else if (i2 != 5) {
                if (i2 != 9) {
                    return null;
                }
                return new s(this.f66684c, mVar, this.f66682a);
            } else if (mVar.V() != null) {
                return new u(this.f66684c, mVar, this.f66682a);
            } else {
                return new q(this.f66684c, mVar, this.f66682a);
            }
        }
        return (TTNativeExpressAd) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            List<com.bytedance.sdk.openadsdk.core.e.m> list = this.f66687f;
            if (list != null) {
                list.clear();
            }
            List<com.bytedance.sdk.openadsdk.core.e.m> list2 = this.f66688g;
            if (list2 != null) {
                list2.clear();
            }
            a(true);
            b(true);
            c(true);
            b();
        }
    }

    private void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65553, this, z) == null) {
            try {
                if (this.l == null || this.l.isCancelled()) {
                    return;
                }
                boolean cancel = this.l.cancel(z);
                com.bytedance.sdk.component.utils.k.f("ExpressAdLoadManager", "CheckValidFutureTask-->cancel......success=" + cancel);
            } catch (Throwable unused) {
            }
        }
    }
}
