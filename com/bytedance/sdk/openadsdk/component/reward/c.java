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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.n;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirConstants;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.component.reward.a;
import com.bytedance.sdk.openadsdk.core.e.l;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.e.x;
import com.bytedance.sdk.openadsdk.core.h.a;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.img.ImageLoaderWrapper;
import com.bytedance.sdk.openadsdk.q.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f66154a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Context f66155b;

    /* renamed from: c  reason: collision with root package name */
    public final p f66156c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f66157d;

    /* renamed from: e  reason: collision with root package name */
    public List<a> f66158e;

    /* renamed from: f  reason: collision with root package name */
    public final BroadcastReceiver f66159f;

    /* loaded from: classes9.dex */
    public class a extends com.bytedance.sdk.component.d.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public m f66183a;

        /* renamed from: b  reason: collision with root package name */
        public AdSlot f66184b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f66185c;

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
            this.f66185c = cVar;
            this.f66183a = mVar;
            this.f66184b = adSlot;
        }

        @Override // java.lang.Runnable
        public void run() {
            m mVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (mVar = this.f66183a) == null) {
                return;
            }
            if (Build.VERSION.SDK_INT < 23) {
                com.bytedance.sdk.openadsdk.component.reward.a.a(this.f66185c.f66155b).a(this.f66183a, new a.InterfaceC1900a<Object>(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.c.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f66197a;

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
                        this.f66197a = this;
                    }

                    @Override // com.bytedance.sdk.openadsdk.component.reward.a.InterfaceC1900a
                    public void a(boolean z, Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZL(1048576, this, z, obj) == null) {
                            if (z) {
                                com.bytedance.sdk.openadsdk.component.reward.a a2 = com.bytedance.sdk.openadsdk.component.reward.a.a(this.f66197a.f66185c.f66155b);
                                a aVar = this.f66197a;
                                a2.a(aVar.f66184b, aVar.f66183a);
                                com.bytedance.sdk.component.utils.k.c("FullScreenVideoLoadManager", "FullScreenLog: preload video success with net change ");
                                return;
                            }
                            com.bytedance.sdk.component.utils.k.c("FullScreenVideoLoadManager", "FullScreenLog: preload video success with net fail ");
                        }
                    }
                });
                return;
            }
            x V = mVar.V();
            if (V != null) {
                com.bytedance.sdk.openadsdk.n.f.b bVar = new com.bytedance.sdk.openadsdk.n.f.b();
                bVar.b(V.l());
                bVar.a(V.i());
                bVar.a(V.m());
                bVar.b(V.d());
                bVar.b(V.t());
                bVar.c(CacheDirConstants.getRewardFullCacheDir());
                bVar.a(this.f66184b);
                bVar.a(this.f66183a);
                com.bytedance.sdk.component.utils.k.c("FullScreenVideoLoadManager", "FullScreenLog: preload video ");
                com.bytedance.sdk.openadsdk.core.video.d.c.a(bVar, new com.bytedance.sdk.component.video.a.c.b(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.c.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f66196a;

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
                        this.f66196a = this;
                    }

                    @Override // com.bytedance.sdk.component.video.a.c.a.InterfaceC1897a
                    public void a(com.bytedance.sdk.component.video.b.a aVar, int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, aVar, i2) == null) {
                            com.bytedance.sdk.openadsdk.component.reward.a a2 = com.bytedance.sdk.openadsdk.component.reward.a.a(this.f66196a.f66185c.f66155b);
                            a aVar2 = this.f66196a;
                            a2.a(aVar2.f66184b, aVar2.f66183a);
                            com.bytedance.sdk.component.utils.k.c("FullScreenVideoLoadManager", "FullScreenLog: preload video success with net change ");
                        }
                    }

                    @Override // com.bytedance.sdk.component.video.a.c.a.InterfaceC1897a
                    public void a(com.bytedance.sdk.component.video.b.a aVar, int i2, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, i2, str) == null) {
                            com.bytedance.sdk.component.utils.k.c("FullScreenVideoLoadManager", "FullScreenLog: preload video success with net fail with net change ");
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
        this.f66157d = new AtomicBoolean(false);
        this.f66158e = Collections.synchronizedList(new ArrayList());
        this.f66159f = new BroadcastReceiver(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.c.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f66182a;

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
                this.f66182a = this;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeLL(1048576, this, context2, intent) == null) && "android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) && n.c(this.f66182a.f66155b) != 0) {
                    Iterator it = this.f66182a.f66158e.iterator();
                    while (it.hasNext()) {
                        com.bytedance.sdk.component.d.e.a((com.bytedance.sdk.component.d.g) it.next(), 1);
                        it.remove();
                    }
                }
            }
        };
        this.f66156c = o.f();
        this.f66155b = context == null ? o.a() : context.getApplicationContext();
        c();
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || this.f66157d.get()) {
            return;
        }
        this.f66157d.set(true);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            this.f66155b.registerReceiver(this.f66159f, intentFilter);
        } catch (Exception unused) {
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65545, this) == null) && this.f66157d.get()) {
            this.f66157d.set(false);
            try {
                this.f66155b.unregisterReceiver(this.f66159f);
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
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (b2 = com.bytedance.sdk.openadsdk.component.reward.a.a(this.f66155b).b()) == null || TextUtils.isEmpty(b2.getCodeId()) || com.bytedance.sdk.openadsdk.component.reward.a.a(this.f66155b).c(b2.getCodeId()) != null) {
            return;
        }
        b(b2);
    }

    public static c a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f66154a == null) {
                synchronized (c.class) {
                    if (f66154a == null) {
                        f66154a = new c(context);
                    }
                }
            }
            return f66154a;
        }
        return (c) invokeL.objValue;
    }

    public void b(AdSlot adSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, adSlot) == null) {
            if (adSlot != null && !TextUtils.isEmpty(adSlot.getBidAdm())) {
                com.bytedance.sdk.component.utils.k.b("bidding", "preload bidding 逻辑不走预加载逻辑：BidAdm->MD5->" + com.bytedance.sdk.openadsdk.n.g.b.a(adSlot.getBidAdm()));
                return;
            }
            com.bytedance.sdk.component.utils.k.b("FullScreenVideoLoadManager", "preload full screen video: " + String.valueOf(adSlot));
            a(adSlot, true, null);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                com.bytedance.sdk.openadsdk.component.reward.a.a(this.f66155b).a();
            } catch (Throwable unused) {
            }
        }
    }

    public void a(AdSlot adSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adSlot) == null) {
            com.bytedance.sdk.openadsdk.component.reward.a.a(this.f66155b).b(adSlot);
        }
    }

    @Nullable
    public AdSlot b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? com.bytedance.sdk.openadsdk.component.reward.a.a(this.f66155b).b(str) : (AdSlot) invokeL.objValue;
    }

    public void a(AdSlot adSlot, TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, adSlot, fullScreenVideoAdListener) == null) {
            com.bytedance.sdk.component.utils.k.b("FullScreenVideoLoadManager", "load full screen video: " + String.valueOf(adSlot));
            com.bytedance.sdk.component.utils.k.b("bidding", "load full video: BidAdm->MD5->" + com.bytedance.sdk.openadsdk.n.g.b.a(adSlot.getBidAdm()));
            com.bytedance.sdk.openadsdk.component.reward.a.a(this.f66155b).a(adSlot);
            a(adSlot, false, fullScreenVideoAdListener);
        }
    }

    private void a(AdSlot adSlot, boolean z, TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{adSlot, Boolean.valueOf(z), fullScreenVideoAdListener}) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (z) {
                a(adSlot, true, fullScreenVideoAdListener, currentTimeMillis);
                return;
            }
            m c2 = com.bytedance.sdk.openadsdk.component.reward.a.a(this.f66155b).c(adSlot.getCodeId());
            if (c2 != null) {
                j jVar = new j(this.f66155b, c2, adSlot);
                if (!com.bytedance.sdk.openadsdk.core.e.o.j(c2)) {
                    jVar.a(com.bytedance.sdk.openadsdk.component.reward.a.a(this.f66155b).a(c2));
                }
                com.bytedance.sdk.openadsdk.e.d.a(c2);
                if (fullScreenVideoAdListener != null) {
                    fullScreenVideoAdListener.onFullScreenVideoAdLoad(jVar);
                    if (!com.bytedance.sdk.openadsdk.core.e.o.j(c2)) {
                        com.bytedance.sdk.openadsdk.e.d.a(this.f66155b, c2, q.b(adSlot.getDurationSlotType()), currentTimeMillis);
                        if (Build.VERSION.SDK_INT >= 23) {
                            x V = c2.V();
                            com.bytedance.sdk.openadsdk.n.f.b bVar = new com.bytedance.sdk.openadsdk.n.f.b();
                            bVar.b(V.l());
                            bVar.a(V.i());
                            bVar.a(V.m());
                            bVar.b(V.d());
                            bVar.b(V.t());
                            bVar.c(CacheDirConstants.getRewardFullCacheDir());
                            bVar.a(adSlot);
                            bVar.a(c2);
                            com.bytedance.sdk.openadsdk.core.video.d.c.a(bVar, new com.bytedance.sdk.component.video.a.c.b(this, fullScreenVideoAdListener, V) { // from class: com.bytedance.sdk.openadsdk.component.reward.c.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ TTAdNative.FullScreenVideoAdListener f66160a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ x f66161b;

                                /* renamed from: c  reason: collision with root package name */
                                public final /* synthetic */ c f66162c;

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
                                    this.f66162c = this;
                                    this.f66160a = fullScreenVideoAdListener;
                                    this.f66161b = V;
                                }

                                @Override // com.bytedance.sdk.component.video.a.c.a.InterfaceC1897a
                                public void a(com.bytedance.sdk.component.video.b.a aVar, int i2) {
                                    TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener2;
                                    Interceptable interceptable2 = $ic;
                                    if (!(interceptable2 == null || interceptable2.invokeLI(1048576, this, aVar, i2) == null) || (fullScreenVideoAdListener2 = this.f66160a) == null) {
                                        return;
                                    }
                                    fullScreenVideoAdListener2.onFullScreenVideoCached();
                                    com.bytedance.sdk.component.utils.k.c("FullScreenVideoLoadManager", "FullScreenLog: Cached ad onFullScreenVideoCached");
                                }

                                @Override // com.bytedance.sdk.component.video.a.c.a.InterfaceC1897a
                                public void a(com.bytedance.sdk.component.video.b.a aVar, int i2, String str) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, i2, str) == null) {
                                        com.bytedance.sdk.component.utils.k.c("FullScreenVideoLoadManager", "FullScreenLog: Cached ad onVideoPreloadFail");
                                        if (this.f66160a == null || !this.f66161b.s()) {
                                            return;
                                        }
                                        this.f66160a.onFullScreenVideoCached();
                                        com.bytedance.sdk.component.utils.k.c("FullScreenVideoLoadManager", "FullScreenLog: Cached ad onVideoPreloadFail and exec onFullScreenVideoCached");
                                    }
                                }
                            });
                        } else {
                            fullScreenVideoAdListener.onFullScreenVideoCached();
                        }
                    }
                }
                com.bytedance.sdk.openadsdk.core.h.a.a().a(c2, new a.InterfaceC1911a(this, fullScreenVideoAdListener, c2, adSlot, currentTimeMillis) { // from class: com.bytedance.sdk.openadsdk.component.reward.c.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.FullScreenVideoAdListener f66163a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ m f66164b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ AdSlot f66165c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ long f66166d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ c f66167e;

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
                        this.f66167e = this;
                        this.f66163a = fullScreenVideoAdListener;
                        this.f66164b = c2;
                        this.f66165c = adSlot;
                        this.f66166d = currentTimeMillis;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.h.a.InterfaceC1911a
                    public void a(boolean z2) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeZ(1048576, this, z2) == null) && this.f66163a != null && com.bytedance.sdk.openadsdk.core.e.o.j(this.f66164b)) {
                            com.bytedance.sdk.openadsdk.e.d.a(this.f66167e.f66155b, this.f66164b, q.b(this.f66165c.getDurationSlotType()), this.f66166d);
                            this.f66163a.onFullScreenVideoCached();
                        }
                    }
                });
                com.bytedance.sdk.component.utils.k.b("FullScreenVideoLoadManager", "get cache data success");
                return;
            }
            com.bytedance.sdk.component.utils.k.b("TTMediationSDK", "全屏视频从网络获取 smartLook参数不为null时.....");
            a(adSlot, false, fullScreenVideoAdListener, currentTimeMillis);
        }
    }

    private void a(AdSlot adSlot, boolean z, TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{adSlot, Boolean.valueOf(z), fullScreenVideoAdListener, Long.valueOf(j2)}) == null) {
            com.bytedance.sdk.component.utils.k.b("bidding", "full video doNetwork 获取新物料:BidAdm->MD5->" + com.bytedance.sdk.openadsdk.n.g.b.a(adSlot.getBidAdm()));
            com.bytedance.sdk.openadsdk.core.e.n nVar = new com.bytedance.sdk.openadsdk.core.e.n();
            nVar.f66837c = z ? 2 : 1;
            if (o.h().i(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f) {
                nVar.f66839e = 2;
            }
            this.f66156c.a(adSlot, nVar, 8, new p.b(this, z, fullScreenVideoAdListener, adSlot, j2) { // from class: com.bytedance.sdk.openadsdk.component.reward.c.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f66168a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ TTAdNative.FullScreenVideoAdListener f66169b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ AdSlot f66170c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ long f66171d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ c f66172e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z), fullScreenVideoAdListener, adSlot, Long.valueOf(j2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f66172e = this;
                    this.f66168a = z;
                    this.f66169b = fullScreenVideoAdListener;
                    this.f66170c = adSlot;
                    this.f66171d = j2;
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.b
                public void a(int i2, String str) {
                    TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) || this.f66168a || (fullScreenVideoAdListener2 = this.f66169b) == null) {
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
                            com.bytedance.sdk.component.utils.k.b("FullScreenVideoLoadManager", "get material data success isPreload=" + this.f66168a);
                            m mVar = aVar.c().get(0);
                            try {
                                l Y = mVar.Y();
                                if (Y != null && !TextUtils.isEmpty(Y.a())) {
                                    com.bytedance.sdk.openadsdk.k.b bVar = new com.bytedance.sdk.openadsdk.k.b(true);
                                    bVar.a(this.f66170c.getCodeId());
                                    bVar.a(8);
                                    bVar.c(mVar.ak());
                                    bVar.d(mVar.ao());
                                    bVar.b(q.h(mVar.ao()));
                                    ImageLoaderWrapper.from(Y).to(bVar);
                                }
                            } catch (Throwable unused) {
                            }
                            j jVar = new j(this.f66172e.f66155b, mVar, this.f66170c);
                            if (!this.f66168a && (fullScreenVideoAdListener4 = this.f66169b) != null) {
                                fullScreenVideoAdListener4.onFullScreenVideoAdLoad(jVar);
                            }
                            com.bytedance.sdk.openadsdk.core.h.a.a().a(mVar, new a.InterfaceC1911a(this, mVar) { // from class: com.bytedance.sdk.openadsdk.component.reward.c.3.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ m f66173a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass3 f66174b;

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
                                    this.f66174b = this;
                                    this.f66173a = mVar;
                                }

                                @Override // com.bytedance.sdk.openadsdk.core.h.a.InterfaceC1911a
                                public void a(boolean z2) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeZ(1048576, this, z2) == null) {
                                        AnonymousClass3 anonymousClass3 = this.f66174b;
                                        if (anonymousClass3.f66168a || anonymousClass3.f66169b == null || !com.bytedance.sdk.openadsdk.core.e.o.j(this.f66173a)) {
                                            return;
                                        }
                                        com.bytedance.sdk.openadsdk.e.d.a(this.f66174b.f66172e.f66155b, this.f66173a, q.b(this.f66174b.f66170c.getDurationSlotType()), this.f66174b.f66171d);
                                        this.f66174b.f66169b.onFullScreenVideoCached();
                                    }
                                }
                            });
                            if (mVar.aK()) {
                                if (this.f66168a && !com.bytedance.sdk.openadsdk.core.e.o.j(mVar) && o.h().q(this.f66170c.getCodeId()).f67015d == 1) {
                                    if (n.d(this.f66172e.f66155b)) {
                                        return;
                                    }
                                    c cVar = this.f66172e;
                                    cVar.a(new a(cVar, mVar, this.f66170c));
                                } else if (com.bytedance.sdk.openadsdk.core.e.o.j(mVar)) {
                                    com.bytedance.sdk.openadsdk.component.reward.a.a(this.f66172e.f66155b).a(this.f66170c, mVar);
                                } else if (Build.VERSION.SDK_INT < 23) {
                                    com.bytedance.sdk.openadsdk.component.reward.a.a(this.f66172e.f66155b).a(mVar, new a.InterfaceC1900a<Object>(this, mVar, jVar) { // from class: com.bytedance.sdk.openadsdk.component.reward.c.3.3
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;

                                        /* renamed from: a  reason: collision with root package name */
                                        public final /* synthetic */ m f66179a;

                                        /* renamed from: b  reason: collision with root package name */
                                        public final /* synthetic */ j f66180b;

                                        /* renamed from: c  reason: collision with root package name */
                                        public final /* synthetic */ AnonymousClass3 f66181c;

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
                                            this.f66181c = this;
                                            this.f66179a = mVar;
                                            this.f66180b = jVar;
                                        }

                                        @Override // com.bytedance.sdk.openadsdk.component.reward.a.InterfaceC1900a
                                        public void a(boolean z2, Object obj) {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeZL(1048576, this, z2, obj) == null) {
                                                com.bytedance.sdk.component.utils.k.b("FullScreenVideoLoadManager", "download video file: " + z2 + ", preload: " + this.f66181c.f66168a);
                                                if (z2) {
                                                    this.f66180b.a(com.bytedance.sdk.openadsdk.component.reward.a.a(this.f66181c.f66172e.f66155b).a(this.f66179a));
                                                }
                                                AnonymousClass3 anonymousClass3 = this.f66181c;
                                                if (anonymousClass3.f66168a) {
                                                    if (z2) {
                                                        com.bytedance.sdk.openadsdk.component.reward.a.a(anonymousClass3.f66172e.f66155b).a(this.f66181c.f66170c, this.f66179a);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                com.bytedance.sdk.openadsdk.e.d.a(this.f66179a);
                                                if (z2) {
                                                    AnonymousClass3 anonymousClass32 = this.f66181c;
                                                    if (anonymousClass32.f66169b != null) {
                                                        com.bytedance.sdk.openadsdk.e.d.a(anonymousClass32.f66172e.f66155b, this.f66179a, q.b(this.f66181c.f66170c.getDurationSlotType()), this.f66181c.f66171d);
                                                        this.f66181c.f66169b.onFullScreenVideoCached();
                                                    }
                                                }
                                            }
                                        }
                                    });
                                } else {
                                    x V = mVar.V();
                                    if (V != null) {
                                        com.bytedance.sdk.openadsdk.n.f.b bVar2 = new com.bytedance.sdk.openadsdk.n.f.b();
                                        bVar2.b(V.l());
                                        bVar2.a(V.i());
                                        bVar2.a(V.m());
                                        bVar2.b(V.d());
                                        bVar2.b(V.t());
                                        bVar2.c(CacheDirConstants.getRewardFullCacheDir());
                                        bVar2.a(this.f66170c);
                                        bVar2.a(mVar);
                                        long elapsedRealtime = SystemClock.elapsedRealtime();
                                        com.bytedance.sdk.component.utils.k.c("FullScreenVideoLoadManager", "FullScreenLog: preload video ");
                                        com.bytedance.sdk.openadsdk.core.video.d.c.a(bVar2, new com.bytedance.sdk.component.video.a.c.b(this, elapsedRealtime, mVar, V) { // from class: com.bytedance.sdk.openadsdk.component.reward.c.3.2
                                            public static /* synthetic */ Interceptable $ic;
                                            public transient /* synthetic */ FieldHolder $fh;

                                            /* renamed from: a  reason: collision with root package name */
                                            public final /* synthetic */ long f66175a;

                                            /* renamed from: b  reason: collision with root package name */
                                            public final /* synthetic */ m f66176b;

                                            /* renamed from: c  reason: collision with root package name */
                                            public final /* synthetic */ x f66177c;

                                            /* renamed from: d  reason: collision with root package name */
                                            public final /* synthetic */ AnonymousClass3 f66178d;

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
                                                this.f66178d = this;
                                                this.f66175a = elapsedRealtime;
                                                this.f66176b = mVar;
                                                this.f66177c = V;
                                            }

                                            @Override // com.bytedance.sdk.component.video.a.c.a.InterfaceC1897a
                                            public void a(com.bytedance.sdk.component.video.b.a aVar2, int i2) {
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 == null || interceptable3.invokeLI(1048576, this, aVar2, i2) == null) {
                                                    com.bytedance.sdk.component.utils.k.c("FullScreenVideoLoadManager", "FullScreenLog:  onVideoPreloadSuccess");
                                                    AnonymousClass3 anonymousClass3 = this.f66178d;
                                                    if (anonymousClass3.f66168a) {
                                                        com.bytedance.sdk.openadsdk.component.reward.a.a(anonymousClass3.f66172e.f66155b).a(this.f66178d.f66170c, this.f66176b);
                                                        com.bytedance.sdk.component.utils.k.c("FullScreenVideoLoadManager", "FullScreenLog:  ad json save");
                                                        return;
                                                    }
                                                    TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener5 = anonymousClass3.f66169b;
                                                    if (fullScreenVideoAdListener5 != null) {
                                                        fullScreenVideoAdListener5.onFullScreenVideoCached();
                                                    }
                                                    com.bytedance.sdk.openadsdk.component.reward.a.a(this.f66178d.f66172e.f66155b, true, this.f66176b, i2, SystemClock.elapsedRealtime() - this.f66175a, null);
                                                    com.bytedance.sdk.component.utils.k.c("FullScreenVideoLoadManager", "FullScreenLog: onFullScreenVideoCached");
                                                }
                                            }

                                            @Override // com.bytedance.sdk.component.video.a.c.a.InterfaceC1897a
                                            public void a(com.bytedance.sdk.component.video.b.a aVar2, int i2, String str) {
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 == null || interceptable3.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar2, i2, str) == null) {
                                                    com.bytedance.sdk.openadsdk.component.reward.a.a(this.f66178d.f66172e.f66155b, false, this.f66176b, i2, SystemClock.elapsedRealtime() - this.f66175a, str);
                                                    com.bytedance.sdk.component.utils.k.c("FullScreenVideoLoadManager", "FullScreenLog:  onVideoPreloadFail");
                                                    if (this.f66178d.f66169b == null || !this.f66177c.s()) {
                                                        return;
                                                    }
                                                    this.f66178d.f66169b.onFullScreenVideoCached();
                                                    com.bytedance.sdk.component.utils.k.c("FullScreenVideoLoadManager", "FullScreenLog:  onVideoPreloadFail and exec onFullScreenVideoCached");
                                                }
                                            }
                                        });
                                    }
                                }
                            } else if (this.f66168a || (fullScreenVideoAdListener3 = this.f66169b) == null) {
                            } else {
                                fullScreenVideoAdListener3.onError(-4, com.bytedance.sdk.openadsdk.core.g.a(-4));
                            }
                        } else if (this.f66168a || (fullScreenVideoAdListener2 = this.f66169b) == null) {
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
            com.bytedance.sdk.openadsdk.component.reward.a.a(this.f66155b).a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, aVar) == null) || aVar == null) {
            return;
        }
        if (this.f66158e.size() >= 1) {
            this.f66158e.remove(0);
        }
        this.f66158e.add(aVar);
    }
}
