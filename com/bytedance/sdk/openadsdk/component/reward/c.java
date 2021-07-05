package com.bytedance.sdk.openadsdk.component.reward;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirConstants;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.component.reward.a;
import com.bytedance.sdk.openadsdk.core.e.l;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.e.n;
import com.bytedance.sdk.openadsdk.core.e.x;
import com.bytedance.sdk.openadsdk.core.h.a;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f29334a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Context f29335b;

    /* renamed from: c  reason: collision with root package name */
    public final p f29336c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f29337d;

    /* renamed from: e  reason: collision with root package name */
    public List<a> f29338e;

    /* renamed from: f  reason: collision with root package name */
    public final BroadcastReceiver f29339f;

    /* loaded from: classes6.dex */
    public class a extends com.bytedance.sdk.component.e.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public m f29363a;

        /* renamed from: b  reason: collision with root package name */
        public AdSlot f29364b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f29365c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, m mVar, AdSlot adSlot) {
            super("Fullscreen Task");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, mVar, adSlot};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29365c = cVar;
            this.f29363a = mVar;
            this.f29364b = adSlot;
        }

        @Override // java.lang.Runnable
        public void run() {
            m mVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (mVar = this.f29363a) == null) {
                return;
            }
            if (Build.VERSION.SDK_INT < 23) {
                com.bytedance.sdk.openadsdk.component.reward.a.a(this.f29365c.f29335b).a(this.f29363a, new a.InterfaceC0328a<Object>(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.c.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f29376a;

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
                        this.f29376a = this;
                    }

                    @Override // com.bytedance.sdk.openadsdk.component.reward.a.InterfaceC0328a
                    public void a(boolean z, Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZL(1048576, this, z, obj) == null) {
                            if (z) {
                                com.bytedance.sdk.openadsdk.component.reward.a a2 = com.bytedance.sdk.openadsdk.component.reward.a.a(this.f29376a.f29365c.f29335b);
                                a aVar = this.f29376a;
                                a2.a(aVar.f29364b, aVar.f29363a);
                                com.bytedance.sdk.component.utils.j.c("FullScreenVideoLoadManager", "FullScreenLog: preload video success with net change ");
                                return;
                            }
                            com.bytedance.sdk.component.utils.j.c("FullScreenVideoLoadManager", "FullScreenLog: preload video success with net fail ");
                        }
                    }
                });
                return;
            }
            x V = mVar.V();
            if (V != null) {
                com.bytedance.sdk.openadsdk.o.f.b bVar = new com.bytedance.sdk.openadsdk.o.f.b();
                bVar.b(V.l());
                bVar.a(V.i());
                bVar.a(V.m());
                bVar.b(V.d());
                bVar.b(V.t());
                bVar.c(CacheDirConstants.getRewardFullCacheDir());
                com.bytedance.sdk.component.utils.j.c("FullScreenVideoLoadManager", "FullScreenLog: preload video ");
                com.bytedance.sdk.openadsdk.core.video.d.c.a(bVar, new com.bytedance.sdk.component.video.a.c.b(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.c.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f29375a;

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
                        this.f29375a = this;
                    }

                    @Override // com.bytedance.sdk.component.video.a.c.a.InterfaceC0325a
                    public void a(com.bytedance.sdk.component.video.b.a aVar, int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, aVar, i2) == null) {
                            com.bytedance.sdk.openadsdk.component.reward.a a2 = com.bytedance.sdk.openadsdk.component.reward.a.a(this.f29375a.f29365c.f29335b);
                            a aVar2 = this.f29375a;
                            a2.a(aVar2.f29364b, aVar2.f29363a);
                            com.bytedance.sdk.component.utils.j.c("FullScreenVideoLoadManager", "FullScreenLog: preload video success with net change ");
                        }
                    }

                    @Override // com.bytedance.sdk.component.video.a.c.a.InterfaceC0325a
                    public void a(com.bytedance.sdk.component.video.b.a aVar, int i2, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, i2, str) == null) {
                            com.bytedance.sdk.component.utils.j.c("FullScreenVideoLoadManager", "FullScreenLog: preload video success with net fail with net change ");
                        }
                    }
                });
            }
        }
    }

    public c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f29337d = new AtomicBoolean(false);
        this.f29338e = Collections.synchronizedList(new ArrayList());
        this.f29339f = new BroadcastReceiver(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.c.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f29362a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f29362a = this;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeLL(1048576, this, context2, intent) == null) && "android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) && com.bytedance.sdk.component.utils.m.c(this.f29362a.f29335b) != 0) {
                    Iterator it = this.f29362a.f29338e.iterator();
                    while (it.hasNext()) {
                        com.bytedance.sdk.component.e.e.a((com.bytedance.sdk.component.e.g) it.next(), 1);
                        it.remove();
                    }
                }
            }
        };
        this.f29336c = o.f();
        this.f29335b = context == null ? o.a() : context.getApplicationContext();
        c();
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || this.f29337d.get()) {
            return;
        }
        this.f29337d.set(true);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            this.f29335b.registerReceiver(this.f29339f, intentFilter);
        } catch (Exception unused) {
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65545, this) == null) && this.f29337d.get()) {
            this.f29337d.set(false);
            try {
                this.f29335b.unregisterReceiver(this.f29339f);
            } catch (Exception unused) {
            }
        }
    }

    public void finalize() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.finalize();
            d();
        }
    }

    public void b() {
        AdSlot b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (b2 = com.bytedance.sdk.openadsdk.component.reward.a.a(this.f29335b).b()) == null || TextUtils.isEmpty(b2.getCodeId()) || com.bytedance.sdk.openadsdk.component.reward.a.a(this.f29335b).c(b2.getCodeId()) != null) {
            return;
        }
        b(b2);
    }

    public static c a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f29334a == null) {
                synchronized (c.class) {
                    if (f29334a == null) {
                        f29334a = new c(context);
                    }
                }
            }
            return f29334a;
        }
        return (c) invokeL.objValue;
    }

    public void b(AdSlot adSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, adSlot) == null) {
            if (adSlot != null && !TextUtils.isEmpty(adSlot.getBidAdm())) {
                com.bytedance.sdk.component.utils.j.b("bidding", "preload bidding 逻辑不走预加载逻辑：BidAdm->MD5->" + com.bytedance.sdk.openadsdk.o.g.b.a(adSlot.getBidAdm()));
                return;
            }
            com.bytedance.sdk.component.utils.j.b("FullScreenVideoLoadManager", "preload full screen video: " + String.valueOf(adSlot));
            a(adSlot, true, null);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                com.bytedance.sdk.openadsdk.component.reward.a.a(this.f29335b).a();
            } catch (Throwable unused) {
            }
        }
    }

    public void a(AdSlot adSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adSlot) == null) {
            com.bytedance.sdk.openadsdk.component.reward.a.a(this.f29335b).b(adSlot);
        }
    }

    @Nullable
    public AdSlot b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? com.bytedance.sdk.openadsdk.component.reward.a.a(this.f29335b).b(str) : (AdSlot) invokeL.objValue;
    }

    public void a(AdSlot adSlot, TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, adSlot, fullScreenVideoAdListener) == null) {
            com.bytedance.sdk.component.utils.j.b("FullScreenVideoLoadManager", "load full screen video: " + String.valueOf(adSlot));
            com.bytedance.sdk.component.utils.j.b("bidding", "load full video: BidAdm->MD5->" + com.bytedance.sdk.openadsdk.o.g.b.a(adSlot.getBidAdm()));
            com.bytedance.sdk.openadsdk.component.reward.a.a(this.f29335b).a(adSlot);
            a(adSlot, false, fullScreenVideoAdListener);
        }
    }

    private void a(AdSlot adSlot, boolean z, TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{adSlot, Boolean.valueOf(z), fullScreenVideoAdListener}) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (z) {
                if (adSlot.getExtraSmartLookParam() != null) {
                    return;
                }
                a(adSlot, true, fullScreenVideoAdListener, currentTimeMillis);
                return;
            }
            m c2 = com.bytedance.sdk.openadsdk.component.reward.a.a(this.f29335b).c(adSlot.getCodeId());
            if (c2 != null && adSlot.getExtraSmartLookParam() == null) {
                j jVar = new j(this.f29335b, c2, adSlot);
                if (!com.bytedance.sdk.openadsdk.core.e.o.j(c2)) {
                    jVar.a(com.bytedance.sdk.openadsdk.component.reward.a.a(this.f29335b).a(c2));
                }
                com.bytedance.sdk.openadsdk.e.d.a(c2);
                if (fullScreenVideoAdListener != null) {
                    fullScreenVideoAdListener.onFullScreenVideoAdLoad(jVar);
                    if (!com.bytedance.sdk.openadsdk.core.e.o.j(c2)) {
                        com.bytedance.sdk.openadsdk.e.d.a(this.f29335b, c2, com.bytedance.sdk.openadsdk.r.o.b(adSlot.getDurationSlotType()), currentTimeMillis);
                        if (Build.VERSION.SDK_INT >= 23) {
                            x V = c2.V();
                            com.bytedance.sdk.openadsdk.o.f.b bVar = new com.bytedance.sdk.openadsdk.o.f.b();
                            bVar.b(V.l());
                            bVar.a(V.i());
                            bVar.a(V.m());
                            bVar.b(V.d());
                            bVar.b(V.t());
                            bVar.c(CacheDirConstants.getRewardFullCacheDir());
                            com.bytedance.sdk.openadsdk.core.video.d.c.a(bVar, new com.bytedance.sdk.component.video.a.c.b(this, fullScreenVideoAdListener, V) { // from class: com.bytedance.sdk.openadsdk.component.reward.c.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ TTAdNative.FullScreenVideoAdListener f29340a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ x f29341b;

                                /* renamed from: c  reason: collision with root package name */
                                public final /* synthetic */ c f29342c;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, fullScreenVideoAdListener, V};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f29342c = this;
                                    this.f29340a = fullScreenVideoAdListener;
                                    this.f29341b = V;
                                }

                                @Override // com.bytedance.sdk.component.video.a.c.a.InterfaceC0325a
                                public void a(com.bytedance.sdk.component.video.b.a aVar, int i2) {
                                    TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener2;
                                    Interceptable interceptable2 = $ic;
                                    if (!(interceptable2 == null || interceptable2.invokeLI(1048576, this, aVar, i2) == null) || (fullScreenVideoAdListener2 = this.f29340a) == null) {
                                        return;
                                    }
                                    fullScreenVideoAdListener2.onFullScreenVideoCached();
                                    com.bytedance.sdk.component.utils.j.c("FullScreenVideoLoadManager", "FullScreenLog: Cached ad onFullScreenVideoCached");
                                }

                                @Override // com.bytedance.sdk.component.video.a.c.a.InterfaceC0325a
                                public void a(com.bytedance.sdk.component.video.b.a aVar, int i2, String str) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, i2, str) == null) {
                                        com.bytedance.sdk.component.utils.j.c("FullScreenVideoLoadManager", "FullScreenLog: Cached ad onVideoPreloadFail");
                                        if (this.f29340a == null || !this.f29341b.s()) {
                                            return;
                                        }
                                        this.f29340a.onFullScreenVideoCached();
                                        com.bytedance.sdk.component.utils.j.c("FullScreenVideoLoadManager", "FullScreenLog: Cached ad onVideoPreloadFail and exec onFullScreenVideoCached");
                                    }
                                }
                            });
                        } else {
                            fullScreenVideoAdListener.onFullScreenVideoCached();
                        }
                    }
                }
                com.bytedance.sdk.openadsdk.core.h.a.a().a(c2, new a.InterfaceC0339a(this, fullScreenVideoAdListener, c2, adSlot, currentTimeMillis) { // from class: com.bytedance.sdk.openadsdk.component.reward.c.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.FullScreenVideoAdListener f29343a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ m f29344b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ AdSlot f29345c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ long f29346d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ c f29347e;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, fullScreenVideoAdListener, c2, adSlot, Long.valueOf(currentTimeMillis)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f29347e = this;
                        this.f29343a = fullScreenVideoAdListener;
                        this.f29344b = c2;
                        this.f29345c = adSlot;
                        this.f29346d = currentTimeMillis;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.h.a.InterfaceC0339a
                    public void a(boolean z2) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeZ(1048576, this, z2) == null) && this.f29343a != null && com.bytedance.sdk.openadsdk.core.e.o.j(this.f29344b)) {
                            com.bytedance.sdk.openadsdk.e.d.a(this.f29347e.f29335b, this.f29344b, com.bytedance.sdk.openadsdk.r.o.b(this.f29345c.getDurationSlotType()), this.f29346d);
                            this.f29343a.onFullScreenVideoCached();
                        }
                    }
                });
                com.bytedance.sdk.component.utils.j.b("FullScreenVideoLoadManager", "get cache data success");
                return;
            }
            com.bytedance.sdk.component.utils.j.b("TTMediationSDK", "全屏视频从网络获取 smartLook参数不为null时.....");
            a(adSlot, false, fullScreenVideoAdListener, currentTimeMillis);
        }
    }

    private void a(AdSlot adSlot, boolean z, TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65540, this, new Object[]{adSlot, Boolean.valueOf(z), fullScreenVideoAdListener, Long.valueOf(j)}) == null) {
            com.bytedance.sdk.component.utils.j.b("bidding", "full video doNetwork 获取新物料:BidAdm->MD5->" + com.bytedance.sdk.openadsdk.o.g.b.a(adSlot.getBidAdm()));
            n nVar = new n();
            nVar.f29992c = z ? 2 : 1;
            if (o.h().i(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f) {
                nVar.f29994e = 2;
            }
            this.f29336c.a(adSlot, nVar, 8, new p.b(this, z, fullScreenVideoAdListener, adSlot, j) { // from class: com.bytedance.sdk.openadsdk.component.reward.c.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f29348a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ TTAdNative.FullScreenVideoAdListener f29349b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ AdSlot f29350c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ long f29351d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ c f29352e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z), fullScreenVideoAdListener, adSlot, Long.valueOf(j)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f29352e = this;
                    this.f29348a = z;
                    this.f29349b = fullScreenVideoAdListener;
                    this.f29350c = adSlot;
                    this.f29351d = j;
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.b
                public void a(int i2, String str) {
                    TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) || this.f29348a || (fullScreenVideoAdListener2 = this.f29349b) == null) {
                        return;
                    }
                    fullScreenVideoAdListener2.onError(i2, str);
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.b
                public void a(com.bytedance.sdk.openadsdk.core.e.a aVar) {
                    TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener2;
                    TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener3;
                    TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener4;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                        if (aVar.c() != null && !aVar.c().isEmpty()) {
                            com.bytedance.sdk.component.utils.j.b("FullScreenVideoLoadManager", "get material data success isPreload=" + this.f29348a);
                            m mVar = aVar.c().get(0);
                            try {
                                l Y = mVar.Y();
                                if (Y != null && !TextUtils.isEmpty(Y.a())) {
                                    com.bytedance.sdk.openadsdk.l.c cVar = new com.bytedance.sdk.openadsdk.l.c(true);
                                    cVar.a(this.f29350c.getCodeId());
                                    cVar.a(8);
                                    cVar.c(mVar.ak());
                                    cVar.d(mVar.ao());
                                    cVar.b(com.bytedance.sdk.openadsdk.r.o.h(mVar.ao()));
                                    com.bytedance.sdk.openadsdk.g.a.a(Y).a(cVar);
                                }
                            } catch (Throwable unused) {
                            }
                            j jVar = new j(this.f29352e.f29335b, mVar, this.f29350c);
                            if (!this.f29348a && (fullScreenVideoAdListener4 = this.f29349b) != null) {
                                fullScreenVideoAdListener4.onFullScreenVideoAdLoad(jVar);
                            }
                            com.bytedance.sdk.openadsdk.core.h.a.a().a(mVar, new a.InterfaceC0339a(this, mVar) { // from class: com.bytedance.sdk.openadsdk.component.reward.c.3.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ m f29353a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass3 f29354b;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, mVar};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f29354b = this;
                                    this.f29353a = mVar;
                                }

                                @Override // com.bytedance.sdk.openadsdk.core.h.a.InterfaceC0339a
                                public void a(boolean z2) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeZ(1048576, this, z2) == null) {
                                        AnonymousClass3 anonymousClass3 = this.f29354b;
                                        if (anonymousClass3.f29348a || anonymousClass3.f29349b == null || !com.bytedance.sdk.openadsdk.core.e.o.j(this.f29353a)) {
                                            return;
                                        }
                                        com.bytedance.sdk.openadsdk.e.d.a(this.f29354b.f29352e.f29335b, this.f29353a, com.bytedance.sdk.openadsdk.r.o.b(this.f29354b.f29350c.getDurationSlotType()), this.f29354b.f29351d);
                                        this.f29354b.f29349b.onFullScreenVideoCached();
                                    }
                                }
                            });
                            if (mVar.aK()) {
                                if (this.f29348a && !com.bytedance.sdk.openadsdk.core.e.o.j(mVar) && o.h().q(this.f29350c.getCodeId()).f30164d == 1) {
                                    if (com.bytedance.sdk.component.utils.m.d(this.f29352e.f29335b)) {
                                        return;
                                    }
                                    c cVar2 = this.f29352e;
                                    cVar2.a(new a(cVar2, mVar, this.f29350c));
                                } else if (com.bytedance.sdk.openadsdk.core.e.o.j(mVar)) {
                                    com.bytedance.sdk.openadsdk.component.reward.a.a(this.f29352e.f29335b).a(this.f29350c, mVar);
                                } else if (Build.VERSION.SDK_INT < 23) {
                                    com.bytedance.sdk.openadsdk.component.reward.a.a(this.f29352e.f29335b).a(mVar, new a.InterfaceC0328a<Object>(this, mVar, jVar) { // from class: com.bytedance.sdk.openadsdk.component.reward.c.3.3
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;

                                        /* renamed from: a  reason: collision with root package name */
                                        public final /* synthetic */ m f29359a;

                                        /* renamed from: b  reason: collision with root package name */
                                        public final /* synthetic */ j f29360b;

                                        /* renamed from: c  reason: collision with root package name */
                                        public final /* synthetic */ AnonymousClass3 f29361c;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this, mVar, jVar};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i2 = newInitContext.flag;
                                                if ((i2 & 1) != 0) {
                                                    int i3 = i2 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.f29361c = this;
                                            this.f29359a = mVar;
                                            this.f29360b = jVar;
                                        }

                                        @Override // com.bytedance.sdk.openadsdk.component.reward.a.InterfaceC0328a
                                        public void a(boolean z2, Object obj) {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeZL(1048576, this, z2, obj) == null) {
                                                com.bytedance.sdk.component.utils.j.b("FullScreenVideoLoadManager", "download video file: " + z2 + ", preload: " + this.f29361c.f29348a);
                                                if (z2) {
                                                    this.f29360b.a(com.bytedance.sdk.openadsdk.component.reward.a.a(this.f29361c.f29352e.f29335b).a(this.f29359a));
                                                }
                                                AnonymousClass3 anonymousClass3 = this.f29361c;
                                                if (anonymousClass3.f29348a) {
                                                    if (z2) {
                                                        com.bytedance.sdk.openadsdk.component.reward.a.a(anonymousClass3.f29352e.f29335b).a(this.f29361c.f29350c, this.f29359a);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                com.bytedance.sdk.openadsdk.e.d.a(this.f29359a);
                                                if (z2) {
                                                    AnonymousClass3 anonymousClass32 = this.f29361c;
                                                    if (anonymousClass32.f29349b != null) {
                                                        com.bytedance.sdk.openadsdk.e.d.a(anonymousClass32.f29352e.f29335b, this.f29359a, com.bytedance.sdk.openadsdk.r.o.b(this.f29361c.f29350c.getDurationSlotType()), this.f29361c.f29351d);
                                                        this.f29361c.f29349b.onFullScreenVideoCached();
                                                    }
                                                }
                                            }
                                        }
                                    });
                                } else {
                                    x V = mVar.V();
                                    if (V != null) {
                                        com.bytedance.sdk.openadsdk.o.f.b bVar = new com.bytedance.sdk.openadsdk.o.f.b();
                                        bVar.b(V.l());
                                        bVar.a(V.i());
                                        bVar.a(V.m());
                                        bVar.b(V.d());
                                        bVar.b(V.t());
                                        bVar.c(CacheDirConstants.getRewardFullCacheDir());
                                        long elapsedRealtime = SystemClock.elapsedRealtime();
                                        com.bytedance.sdk.component.utils.j.c("FullScreenVideoLoadManager", "FullScreenLog: preload video ");
                                        com.bytedance.sdk.openadsdk.core.video.d.c.a(bVar, new com.bytedance.sdk.component.video.a.c.b(this, elapsedRealtime, mVar, V) { // from class: com.bytedance.sdk.openadsdk.component.reward.c.3.2
                                            public static /* synthetic */ Interceptable $ic;
                                            public transient /* synthetic */ FieldHolder $fh;

                                            /* renamed from: a  reason: collision with root package name */
                                            public final /* synthetic */ long f29355a;

                                            /* renamed from: b  reason: collision with root package name */
                                            public final /* synthetic */ m f29356b;

                                            /* renamed from: c  reason: collision with root package name */
                                            public final /* synthetic */ x f29357c;

                                            /* renamed from: d  reason: collision with root package name */
                                            public final /* synthetic */ AnonymousClass3 f29358d;

                                            {
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 != null) {
                                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                                    newInitContext.initArgs = r2;
                                                    Object[] objArr = {this, Long.valueOf(elapsedRealtime), mVar, V};
                                                    interceptable3.invokeUnInit(65536, newInitContext);
                                                    int i2 = newInitContext.flag;
                                                    if ((i2 & 1) != 0) {
                                                        int i3 = i2 & 2;
                                                        newInitContext.thisArg = this;
                                                        interceptable3.invokeInitBody(65536, newInitContext);
                                                        return;
                                                    }
                                                }
                                                this.f29358d = this;
                                                this.f29355a = elapsedRealtime;
                                                this.f29356b = mVar;
                                                this.f29357c = V;
                                            }

                                            @Override // com.bytedance.sdk.component.video.a.c.a.InterfaceC0325a
                                            public void a(com.bytedance.sdk.component.video.b.a aVar2, int i2) {
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 == null || interceptable3.invokeLI(1048576, this, aVar2, i2) == null) {
                                                    com.bytedance.sdk.component.utils.j.c("FullScreenVideoLoadManager", "FullScreenLog:  onVideoPreloadSuccess");
                                                    AnonymousClass3 anonymousClass3 = this.f29358d;
                                                    if (anonymousClass3.f29348a) {
                                                        com.bytedance.sdk.openadsdk.component.reward.a.a(anonymousClass3.f29352e.f29335b).a(this.f29358d.f29350c, this.f29356b);
                                                        com.bytedance.sdk.component.utils.j.c("FullScreenVideoLoadManager", "FullScreenLog:  ad json save");
                                                        return;
                                                    }
                                                    TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener5 = anonymousClass3.f29349b;
                                                    if (fullScreenVideoAdListener5 != null) {
                                                        fullScreenVideoAdListener5.onFullScreenVideoCached();
                                                    }
                                                    com.bytedance.sdk.openadsdk.component.reward.a.a(this.f29358d.f29352e.f29335b, true, this.f29356b, i2, SystemClock.elapsedRealtime() - this.f29355a, null);
                                                    com.bytedance.sdk.component.utils.j.c("FullScreenVideoLoadManager", "FullScreenLog: onFullScreenVideoCached");
                                                }
                                            }

                                            @Override // com.bytedance.sdk.component.video.a.c.a.InterfaceC0325a
                                            public void a(com.bytedance.sdk.component.video.b.a aVar2, int i2, String str) {
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 == null || interceptable3.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar2, i2, str) == null) {
                                                    com.bytedance.sdk.openadsdk.component.reward.a.a(this.f29358d.f29352e.f29335b, false, this.f29356b, i2, SystemClock.elapsedRealtime() - this.f29355a, str);
                                                    com.bytedance.sdk.component.utils.j.c("FullScreenVideoLoadManager", "FullScreenLog:  onVideoPreloadFail");
                                                    if (this.f29358d.f29349b == null || !this.f29357c.s()) {
                                                        return;
                                                    }
                                                    this.f29358d.f29349b.onFullScreenVideoCached();
                                                    com.bytedance.sdk.component.utils.j.c("FullScreenVideoLoadManager", "FullScreenLog:  onVideoPreloadFail and exec onFullScreenVideoCached");
                                                }
                                            }
                                        });
                                    }
                                }
                            } else if (this.f29348a || (fullScreenVideoAdListener3 = this.f29349b) == null) {
                            } else {
                                fullScreenVideoAdListener3.onError(-4, com.bytedance.sdk.openadsdk.core.g.a(-4));
                            }
                        } else if (this.f29348a || (fullScreenVideoAdListener2 = this.f29349b) == null) {
                        } else {
                            fullScreenVideoAdListener2.onError(-3, com.bytedance.sdk.openadsdk.core.g.a(-3));
                        }
                    }
                }
            });
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            com.bytedance.sdk.openadsdk.component.reward.a.a(this.f29335b).a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, aVar) == null) || aVar == null) {
            return;
        }
        if (this.f29338e.size() >= 1) {
            this.f29338e.remove(0);
        }
        this.f29338e.add(aVar);
    }
}
