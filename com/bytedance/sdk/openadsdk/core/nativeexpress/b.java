package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
import com.bytedance.sdk.openadsdk.l.a.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static Set<b> j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AdSlot f30309a;

    /* renamed from: b  reason: collision with root package name */
    public final p f30310b;

    /* renamed from: c  reason: collision with root package name */
    public Context f30311c;

    /* renamed from: d  reason: collision with root package name */
    public TTAdNative.NativeExpressAdListener f30312d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicBoolean f30313e;

    /* renamed from: f  reason: collision with root package name */
    public List<com.bytedance.sdk.openadsdk.core.e.m> f30314f;

    /* renamed from: g  reason: collision with root package name */
    public List<com.bytedance.sdk.openadsdk.core.e.m> f30315g;

    /* renamed from: h  reason: collision with root package name */
    public a f30316h;

    /* renamed from: i  reason: collision with root package name */
    public int f30317i;
    public ScheduledFuture<?> k;
    public ScheduledFuture<?> l;
    public ScheduledFuture<?> m;

    /* loaded from: classes6.dex */
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
        j = Collections.synchronizedSet(new HashSet());
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
        this.f30313e = new AtomicBoolean(false);
        this.f30317i = 5;
        this.k = null;
        this.l = null;
        this.m = null;
        this.f30310b = com.bytedance.sdk.openadsdk.core.o.f();
        if (context != null) {
            this.f30311c = context.getApplicationContext();
        } else {
            this.f30311c = com.bytedance.sdk.openadsdk.core.o.a();
        }
        j.add(this);
    }

    private void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65558, this, z) == null) {
            try {
                if (this.k == null || this.k.isCancelled()) {
                    return;
                }
                boolean cancel = this.k.cancel(z);
                com.bytedance.sdk.component.utils.j.f("ExpressAdLoadManager", "TimeOutFutureTask-->cancel......success=" + cancel);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            List<com.bytedance.sdk.openadsdk.core.e.m> list = this.f30314f;
            if (list != null) {
                list.clear();
            }
            List<com.bytedance.sdk.openadsdk.core.e.m> list2 = this.f30315g;
            if (list2 != null) {
                list2.clear();
            }
            a(true);
            b(true);
            c(true);
            c();
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            j.remove(this);
        }
    }

    public static b a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65540, null, context)) == null) ? new b(context) : (b) invokeL.objValue;
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
            if (this.f30313e.get()) {
                com.bytedance.sdk.component.utils.j.f("ExpressAdLoadManager", "express ad is loading...");
                return;
            }
            this.f30317i = i2;
            this.f30313e.set(true);
            this.f30309a = adSlot;
            this.f30312d = nativeExpressAdListener;
            this.f30316h = aVar;
            a(adSlot, currentTimeMillis);
        }
    }

    private void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65555, this, z) == null) {
            try {
                if (this.m == null || this.m.isCancelled()) {
                    return;
                }
                boolean cancel = this.m.cancel(z);
                com.bytedance.sdk.component.utils.j.b("ExpressAdLoadManager", "CheckValidDoneFutureTask-->cancel.....success=" + cancel);
            } catch (Throwable unused) {
            }
        }
    }

    private void a(AdSlot adSlot, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(65546, this, adSlot, j2) == null) || adSlot == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.e.n nVar = new com.bytedance.sdk.openadsdk.core.e.n();
        nVar.f29994e = 2;
        this.f30310b.a(adSlot, nVar, this.f30317i, new p.b(this, j2) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f30318a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f30319b;

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
                this.f30319b = this;
                this.f30318a = j2;
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.b
            public void a(int i2, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                    this.f30319b.a(i2, str);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.b
            public void a(com.bytedance.sdk.openadsdk.core.e.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                    if (aVar.c() != null && !aVar.c().isEmpty()) {
                        this.f30319b.f30314f = aVar.c();
                        this.f30319b.f30315g = aVar.c();
                        this.f30319b.a();
                        this.f30319b.a(this.f30318a);
                        return;
                    }
                    this.f30319b.a(-3, com.bytedance.sdk.openadsdk.core.g.a(-3));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        List<com.bytedance.sdk.openadsdk.core.e.m> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) || (list = this.f30314f) == null) {
            return;
        }
        for (com.bytedance.sdk.openadsdk.core.e.m mVar : list) {
            if (mVar.aK() && mVar.ad() != null && !mVar.ad().isEmpty()) {
                for (com.bytedance.sdk.openadsdk.core.e.l lVar : mVar.ad()) {
                    if (!TextUtils.isEmpty(lVar.a())) {
                        com.bytedance.sdk.openadsdk.l.e.b().e().a(new com.bytedance.sdk.openadsdk.l.b(lVar.a(), lVar.g()), (b.InterfaceC0354b) com.bytedance.sdk.openadsdk.l.a.b.a(), lVar.b(), lVar.c(), false);
                    }
                }
            }
            if (com.bytedance.sdk.openadsdk.core.e.m.b(mVar) && mVar.V() != null && mVar.V().i() != null) {
                if (com.bytedance.sdk.openadsdk.core.o.h().a(String.valueOf(com.bytedance.sdk.openadsdk.r.o.d(mVar.ao()))) && com.bytedance.sdk.openadsdk.core.o.h().N()) {
                    com.bytedance.sdk.openadsdk.o.f.b bVar = new com.bytedance.sdk.openadsdk.o.f.b();
                    bVar.a(mVar.V().i());
                    bVar.a(mVar.V().m());
                    bVar.b(mVar.V().l());
                    bVar.c(CacheDirConstants.getFeedCacheDir());
                    bVar.b(mVar.V().d());
                    com.bytedance.sdk.openadsdk.core.video.d.c.a(bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(65545, this, j2) == null) && this.f30313e.getAndSet(false)) {
            new Handler(Looper.getMainLooper()).post(new Runnable(this, j2) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ long f30320a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f30321b;

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
                    this.f30321b = this;
                    this.f30320a = j2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.f30321b.f30315g == null || this.f30321b.f30315g.size() <= 0) {
                            if (this.f30321b.f30312d != null) {
                                this.f30321b.f30312d.onError(108, com.bytedance.sdk.openadsdk.core.g.a(108));
                                this.f30321b.a(108);
                            }
                            if (this.f30321b.f30316h != null) {
                                this.f30321b.f30316h.a();
                            }
                        } else {
                            if (this.f30321b.f30312d != null) {
                                ArrayList arrayList = new ArrayList(this.f30321b.f30315g.size());
                                for (com.bytedance.sdk.openadsdk.core.e.m mVar : this.f30321b.f30315g) {
                                    arrayList.add(this.f30321b.a(mVar));
                                }
                                if (!arrayList.isEmpty()) {
                                    com.bytedance.sdk.openadsdk.e.d.a(this.f30321b.f30311c, (com.bytedance.sdk.openadsdk.core.e.m) this.f30321b.f30315g.get(0), com.bytedance.sdk.openadsdk.r.o.b(this.f30321b.f30309a.getDurationSlotType()), this.f30320a);
                                    this.f30321b.f30312d.onNativeExpressAdLoad(arrayList);
                                } else {
                                    this.f30321b.f30312d.onError(103, com.bytedance.sdk.openadsdk.core.g.a(103));
                                    this.f30321b.a(103);
                                }
                            }
                            if (this.f30321b.f30316h != null) {
                                this.f30321b.f30316h.a(this.f30321b.f30315g);
                            }
                        }
                        this.f30321b.b();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65543, this, i2) == null) {
            List<com.bytedance.sdk.openadsdk.core.e.m> list = this.f30314f;
            com.bytedance.sdk.openadsdk.k.a.c g2 = com.bytedance.sdk.openadsdk.k.a.c.b().a(this.f30317i).c(this.f30309a.getCodeId()).g((list == null || list.size() <= 0) ? "" : com.bytedance.sdk.openadsdk.r.o.h(this.f30314f.get(0).ao()));
            g2.b(i2).h(com.bytedance.sdk.openadsdk.core.g.a(i2));
            com.bytedance.sdk.openadsdk.k.a.a().h(g2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(65544, this, i2, str) == null) && this.f30313e.getAndSet(false)) {
            TTAdNative.NativeExpressAdListener nativeExpressAdListener = this.f30312d;
            if (nativeExpressAdListener != null) {
                nativeExpressAdListener.onError(i2, str);
            }
            a aVar = this.f30316h;
            if (aVar != null) {
                aVar.a();
            }
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TTNativeExpressAd a(com.bytedance.sdk.openadsdk.core.e.m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, mVar)) == null) {
            int i2 = this.f30317i;
            if (i2 == 1) {
                if (mVar.V() != null) {
                    return new com.bytedance.sdk.openadsdk.core.bannerexpress.c(this.f30311c, mVar, this.f30309a);
                }
                return new com.bytedance.sdk.openadsdk.core.bannerexpress.b(this.f30311c, mVar, this.f30309a);
            } else if (i2 == 2) {
                if (mVar.V() != null) {
                    return new com.bytedance.sdk.openadsdk.core.d.c(this.f30311c, mVar, this.f30309a);
                }
                return new com.bytedance.sdk.openadsdk.core.d.b(this.f30311c, mVar, this.f30309a);
            } else if (i2 != 5) {
                if (i2 != 9) {
                    return null;
                }
                return new m(this.f30311c, mVar, this.f30309a);
            } else if (mVar.V() != null) {
                return new o(this.f30311c, mVar, this.f30309a);
            } else {
                return new k(this.f30311c, mVar, this.f30309a);
            }
        }
        return (TTNativeExpressAd) invokeL.objValue;
    }

    private void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65551, this, z) == null) {
            try {
                if (this.l == null || this.l.isCancelled()) {
                    return;
                }
                boolean cancel = this.l.cancel(z);
                com.bytedance.sdk.component.utils.j.f("ExpressAdLoadManager", "CheckValidFutureTask-->cancel......success=" + cancel);
            } catch (Throwable unused) {
            }
        }
    }
}
