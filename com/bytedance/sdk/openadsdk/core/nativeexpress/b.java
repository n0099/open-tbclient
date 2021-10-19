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
    public static Set<b> f67207j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AdSlot f67208a;

    /* renamed from: b  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.core.p f67209b;

    /* renamed from: c  reason: collision with root package name */
    public Context f67210c;

    /* renamed from: d  reason: collision with root package name */
    public TTAdNative.NativeExpressAdListener f67211d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicBoolean f67212e;

    /* renamed from: f  reason: collision with root package name */
    public List<com.bytedance.sdk.openadsdk.core.e.m> f67213f;

    /* renamed from: g  reason: collision with root package name */
    public List<com.bytedance.sdk.openadsdk.core.e.m> f67214g;

    /* renamed from: h  reason: collision with root package name */
    public a f67215h;

    /* renamed from: i  reason: collision with root package name */
    public int f67216i;
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
        f67207j = Collections.synchronizedSet(new HashSet());
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
        this.f67212e = new AtomicBoolean(false);
        this.f67216i = 5;
        this.k = null;
        this.l = null;
        this.m = null;
        this.f67209b = com.bytedance.sdk.openadsdk.core.o.f();
        if (context != null) {
            this.f67210c = context.getApplicationContext();
        } else {
            this.f67210c = com.bytedance.sdk.openadsdk.core.o.a();
        }
        f67207j.add(this);
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
            f67207j.remove(this);
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
            if (this.f67212e.get()) {
                com.bytedance.sdk.component.utils.k.f("ExpressAdLoadManager", "express ad is loading...");
                return;
            }
            this.f67216i = i2;
            this.f67212e.set(true);
            this.f67208a = adSlot;
            this.f67211d = nativeExpressAdListener;
            this.f67215h = aVar;
            a(adSlot, currentTimeMillis);
        }
    }

    private void a(AdSlot adSlot, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(65548, this, adSlot, j2) == null) || adSlot == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.e.n nVar = new com.bytedance.sdk.openadsdk.core.e.n();
        nVar.f66839e = 2;
        this.f67209b.a(adSlot, nVar, this.f67216i, new p.b(this, adSlot, j2) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ AdSlot f67217a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f67218b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b f67219c;

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
                this.f67219c = this;
                this.f67217a = adSlot;
                this.f67218b = j2;
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.b
            public void a(int i2, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                    this.f67219c.a(i2, str);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.b
            public void a(com.bytedance.sdk.openadsdk.core.e.a aVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                    if (aVar.c() != null && !aVar.c().isEmpty()) {
                        this.f67219c.f67213f = aVar.c();
                        this.f67219c.f67214g = aVar.c();
                        this.f67219c.a(this.f67217a);
                        this.f67219c.a(this.f67218b);
                        return;
                    }
                    this.f67219c.a(-3, com.bytedance.sdk.openadsdk.core.g.a(-3));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdSlot adSlot) {
        List<com.bytedance.sdk.openadsdk.core.e.m> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, this, adSlot) == null) || (list = this.f67213f) == null) {
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
        if ((interceptable == null || interceptable.invokeJ(65546, this, j2) == null) && this.f67212e.getAndSet(false)) {
            new Handler(Looper.getMainLooper()).post(new Runnable(this, j2) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ long f67220a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f67221b;

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
                    this.f67221b = this;
                    this.f67220a = j2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.f67221b.f67214g == null || this.f67221b.f67214g.size() <= 0) {
                            if (this.f67221b.f67211d != null) {
                                this.f67221b.f67211d.onError(108, com.bytedance.sdk.openadsdk.core.g.a(108));
                                this.f67221b.a(108);
                            }
                            if (this.f67221b.f67215h != null) {
                                this.f67221b.f67215h.a();
                            }
                        } else {
                            if (this.f67221b.f67211d != null) {
                                ArrayList arrayList = new ArrayList(this.f67221b.f67214g.size());
                                for (com.bytedance.sdk.openadsdk.core.e.m mVar : this.f67221b.f67214g) {
                                    arrayList.add(this.f67221b.a(mVar));
                                }
                                if (!arrayList.isEmpty()) {
                                    com.bytedance.sdk.openadsdk.e.d.a(this.f67221b.f67210c, (com.bytedance.sdk.openadsdk.core.e.m) this.f67221b.f67214g.get(0), com.bytedance.sdk.openadsdk.q.q.b(this.f67221b.f67208a.getDurationSlotType()), this.f67220a);
                                    this.f67221b.f67211d.onNativeExpressAdLoad(arrayList);
                                } else {
                                    this.f67221b.f67211d.onError(103, com.bytedance.sdk.openadsdk.core.g.a(103));
                                    this.f67221b.a(103);
                                }
                            }
                            if (this.f67221b.f67215h != null) {
                                this.f67221b.f67215h.a(this.f67221b.f67214g);
                            }
                        }
                        this.f67221b.a();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65544, this, i2) == null) {
            List<com.bytedance.sdk.openadsdk.core.e.m> list = this.f67213f;
            com.bytedance.sdk.openadsdk.j.a.c f2 = com.bytedance.sdk.openadsdk.j.a.c.b().a(this.f67216i).c(this.f67208a.getCodeId()).f((list == null || list.size() <= 0) ? "" : com.bytedance.sdk.openadsdk.q.q.h(this.f67213f.get(0).ao()));
            f2.b(i2).g(com.bytedance.sdk.openadsdk.core.g.a(i2));
            com.bytedance.sdk.openadsdk.j.a.a().h(f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(65545, this, i2, str) == null) && this.f67212e.getAndSet(false)) {
            TTAdNative.NativeExpressAdListener nativeExpressAdListener = this.f67211d;
            if (nativeExpressAdListener != null) {
                nativeExpressAdListener.onError(i2, str);
            }
            a aVar = this.f67215h;
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
            int i2 = this.f67216i;
            if (i2 == 1) {
                if (mVar.V() != null) {
                    return new com.bytedance.sdk.openadsdk.core.bannerexpress.c(this.f67210c, mVar, this.f67208a);
                }
                return new com.bytedance.sdk.openadsdk.core.bannerexpress.b(this.f67210c, mVar, this.f67208a);
            } else if (i2 == 2) {
                if (mVar.V() != null) {
                    return new com.bytedance.sdk.openadsdk.core.d.c(this.f67210c, mVar, this.f67208a);
                }
                return new com.bytedance.sdk.openadsdk.core.d.b(this.f67210c, mVar, this.f67208a);
            } else if (i2 != 5) {
                if (i2 != 9) {
                    return null;
                }
                return new s(this.f67210c, mVar, this.f67208a);
            } else if (mVar.V() != null) {
                return new u(this.f67210c, mVar, this.f67208a);
            } else {
                return new q(this.f67210c, mVar, this.f67208a);
            }
        }
        return (TTNativeExpressAd) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            List<com.bytedance.sdk.openadsdk.core.e.m> list = this.f67213f;
            if (list != null) {
                list.clear();
            }
            List<com.bytedance.sdk.openadsdk.core.e.m> list2 = this.f67214g;
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
