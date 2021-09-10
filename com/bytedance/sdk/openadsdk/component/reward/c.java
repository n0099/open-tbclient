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
    public static volatile c f65808a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Context f65809b;

    /* renamed from: c  reason: collision with root package name */
    public final p f65810c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f65811d;

    /* renamed from: e  reason: collision with root package name */
    public List<a> f65812e;

    /* renamed from: f  reason: collision with root package name */
    public final BroadcastReceiver f65813f;

    /* loaded from: classes9.dex */
    public class a extends com.bytedance.sdk.component.d.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public m f65837a;

        /* renamed from: b  reason: collision with root package name */
        public AdSlot f65838b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f65839c;

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
            this.f65839c = cVar;
            this.f65837a = mVar;
            this.f65838b = adSlot;
        }

        @Override // java.lang.Runnable
        public void run() {
            m mVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (mVar = this.f65837a) == null) {
                return;
            }
            if (Build.VERSION.SDK_INT < 23) {
                com.bytedance.sdk.openadsdk.component.reward.a.a(this.f65839c.f65809b).a(this.f65837a, new a.InterfaceC1894a<Object>(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.c.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f65851a;

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
                        this.f65851a = this;
                    }

                    @Override // com.bytedance.sdk.openadsdk.component.reward.a.InterfaceC1894a
                    public void a(boolean z, Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZL(1048576, this, z, obj) == null) {
                            if (z) {
                                com.bytedance.sdk.openadsdk.component.reward.a a2 = com.bytedance.sdk.openadsdk.component.reward.a.a(this.f65851a.f65839c.f65809b);
                                a aVar = this.f65851a;
                                a2.a(aVar.f65838b, aVar.f65837a);
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
                bVar.a(this.f65838b);
                bVar.a(this.f65837a);
                com.bytedance.sdk.component.utils.k.c("FullScreenVideoLoadManager", "FullScreenLog: preload video ");
                com.bytedance.sdk.openadsdk.core.video.d.c.a(bVar, new com.bytedance.sdk.component.video.a.c.b(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.c.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f65850a;

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
                        this.f65850a = this;
                    }

                    @Override // com.bytedance.sdk.component.video.a.c.a.InterfaceC1891a
                    public void a(com.bytedance.sdk.component.video.b.a aVar, int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, aVar, i2) == null) {
                            com.bytedance.sdk.openadsdk.component.reward.a a2 = com.bytedance.sdk.openadsdk.component.reward.a.a(this.f65850a.f65839c.f65809b);
                            a aVar2 = this.f65850a;
                            a2.a(aVar2.f65838b, aVar2.f65837a);
                            com.bytedance.sdk.component.utils.k.c("FullScreenVideoLoadManager", "FullScreenLog: preload video success with net change ");
                        }
                    }

                    @Override // com.bytedance.sdk.component.video.a.c.a.InterfaceC1891a
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
        this.f65811d = new AtomicBoolean(false);
        this.f65812e = Collections.synchronizedList(new ArrayList());
        this.f65813f = new BroadcastReceiver(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.c.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f65836a;

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
                this.f65836a = this;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeLL(1048576, this, context2, intent) == null) && "android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) && n.c(this.f65836a.f65809b) != 0) {
                    Iterator it = this.f65836a.f65812e.iterator();
                    while (it.hasNext()) {
                        com.bytedance.sdk.component.d.e.a((com.bytedance.sdk.component.d.g) it.next(), 1);
                        it.remove();
                    }
                }
            }
        };
        this.f65810c = o.f();
        this.f65809b = context == null ? o.a() : context.getApplicationContext();
        c();
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || this.f65811d.get()) {
            return;
        }
        this.f65811d.set(true);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            this.f65809b.registerReceiver(this.f65813f, intentFilter);
        } catch (Exception unused) {
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65545, this) == null) && this.f65811d.get()) {
            this.f65811d.set(false);
            try {
                this.f65809b.unregisterReceiver(this.f65813f);
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
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (b2 = com.bytedance.sdk.openadsdk.component.reward.a.a(this.f65809b).b()) == null || TextUtils.isEmpty(b2.getCodeId()) || com.bytedance.sdk.openadsdk.component.reward.a.a(this.f65809b).c(b2.getCodeId()) != null) {
            return;
        }
        b(b2);
    }

    public static c a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f65808a == null) {
                synchronized (c.class) {
                    if (f65808a == null) {
                        f65808a = new c(context);
                    }
                }
            }
            return f65808a;
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
                com.bytedance.sdk.openadsdk.component.reward.a.a(this.f65809b).a();
            } catch (Throwable unused) {
            }
        }
    }

    public void a(AdSlot adSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adSlot) == null) {
            com.bytedance.sdk.openadsdk.component.reward.a.a(this.f65809b).b(adSlot);
        }
    }

    @Nullable
    public AdSlot b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? com.bytedance.sdk.openadsdk.component.reward.a.a(this.f65809b).b(str) : (AdSlot) invokeL.objValue;
    }

    public void a(AdSlot adSlot, TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, adSlot, fullScreenVideoAdListener) == null) {
            com.bytedance.sdk.component.utils.k.b("FullScreenVideoLoadManager", "load full screen video: " + String.valueOf(adSlot));
            com.bytedance.sdk.component.utils.k.b("bidding", "load full video: BidAdm->MD5->" + com.bytedance.sdk.openadsdk.n.g.b.a(adSlot.getBidAdm()));
            com.bytedance.sdk.openadsdk.component.reward.a.a(this.f65809b).a(adSlot);
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
            m c2 = com.bytedance.sdk.openadsdk.component.reward.a.a(this.f65809b).c(adSlot.getCodeId());
            if (c2 != null) {
                j jVar = new j(this.f65809b, c2, adSlot);
                if (!com.bytedance.sdk.openadsdk.core.e.o.j(c2)) {
                    jVar.a(com.bytedance.sdk.openadsdk.component.reward.a.a(this.f65809b).a(c2));
                }
                com.bytedance.sdk.openadsdk.e.d.a(c2);
                if (fullScreenVideoAdListener != null) {
                    fullScreenVideoAdListener.onFullScreenVideoAdLoad(jVar);
                    if (!com.bytedance.sdk.openadsdk.core.e.o.j(c2)) {
                        com.bytedance.sdk.openadsdk.e.d.a(this.f65809b, c2, q.b(adSlot.getDurationSlotType()), currentTimeMillis);
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
                                public final /* synthetic */ TTAdNative.FullScreenVideoAdListener f65814a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ x f65815b;

                                /* renamed from: c  reason: collision with root package name */
                                public final /* synthetic */ c f65816c;

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
                                    this.f65816c = this;
                                    this.f65814a = fullScreenVideoAdListener;
                                    this.f65815b = V;
                                }

                                @Override // com.bytedance.sdk.component.video.a.c.a.InterfaceC1891a
                                public void a(com.bytedance.sdk.component.video.b.a aVar, int i2) {
                                    TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener2;
                                    Interceptable interceptable2 = $ic;
                                    if (!(interceptable2 == null || interceptable2.invokeLI(1048576, this, aVar, i2) == null) || (fullScreenVideoAdListener2 = this.f65814a) == null) {
                                        return;
                                    }
                                    fullScreenVideoAdListener2.onFullScreenVideoCached();
                                    com.bytedance.sdk.component.utils.k.c("FullScreenVideoLoadManager", "FullScreenLog: Cached ad onFullScreenVideoCached");
                                }

                                @Override // com.bytedance.sdk.component.video.a.c.a.InterfaceC1891a
                                public void a(com.bytedance.sdk.component.video.b.a aVar, int i2, String str) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, i2, str) == null) {
                                        com.bytedance.sdk.component.utils.k.c("FullScreenVideoLoadManager", "FullScreenLog: Cached ad onVideoPreloadFail");
                                        if (this.f65814a == null || !this.f65815b.s()) {
                                            return;
                                        }
                                        this.f65814a.onFullScreenVideoCached();
                                        com.bytedance.sdk.component.utils.k.c("FullScreenVideoLoadManager", "FullScreenLog: Cached ad onVideoPreloadFail and exec onFullScreenVideoCached");
                                    }
                                }
                            });
                        } else {
                            fullScreenVideoAdListener.onFullScreenVideoCached();
                        }
                    }
                }
                com.bytedance.sdk.openadsdk.core.h.a.a().a(c2, new a.InterfaceC1905a(this, fullScreenVideoAdListener, c2, adSlot, currentTimeMillis) { // from class: com.bytedance.sdk.openadsdk.component.reward.c.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.FullScreenVideoAdListener f65817a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ m f65818b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ AdSlot f65819c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ long f65820d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ c f65821e;

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
                        this.f65821e = this;
                        this.f65817a = fullScreenVideoAdListener;
                        this.f65818b = c2;
                        this.f65819c = adSlot;
                        this.f65820d = currentTimeMillis;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.h.a.InterfaceC1905a
                    public void a(boolean z2) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeZ(1048576, this, z2) == null) && this.f65817a != null && com.bytedance.sdk.openadsdk.core.e.o.j(this.f65818b)) {
                            com.bytedance.sdk.openadsdk.e.d.a(this.f65821e.f65809b, this.f65818b, q.b(this.f65819c.getDurationSlotType()), this.f65820d);
                            this.f65817a.onFullScreenVideoCached();
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
            nVar.f66491c = z ? 2 : 1;
            if (o.h().i(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f) {
                nVar.f66493e = 2;
            }
            this.f65810c.a(adSlot, nVar, 8, new p.b(this, z, fullScreenVideoAdListener, adSlot, j2) { // from class: com.bytedance.sdk.openadsdk.component.reward.c.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f65822a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ TTAdNative.FullScreenVideoAdListener f65823b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ AdSlot f65824c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ long f65825d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ c f65826e;

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
                    this.f65826e = this;
                    this.f65822a = z;
                    this.f65823b = fullScreenVideoAdListener;
                    this.f65824c = adSlot;
                    this.f65825d = j2;
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.b
                public void a(int i2, String str) {
                    TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) || this.f65822a || (fullScreenVideoAdListener2 = this.f65823b) == null) {
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
                            com.bytedance.sdk.component.utils.k.b("FullScreenVideoLoadManager", "get material data success isPreload=" + this.f65822a);
                            m mVar = aVar.c().get(0);
                            try {
                                l Y = mVar.Y();
                                if (Y != null && !TextUtils.isEmpty(Y.a())) {
                                    com.bytedance.sdk.openadsdk.k.b bVar = new com.bytedance.sdk.openadsdk.k.b(true);
                                    bVar.a(this.f65824c.getCodeId());
                                    bVar.a(8);
                                    bVar.c(mVar.ak());
                                    bVar.d(mVar.ao());
                                    bVar.b(q.h(mVar.ao()));
                                    ImageLoaderWrapper.from(Y).to(bVar);
                                }
                            } catch (Throwable unused) {
                            }
                            j jVar = new j(this.f65826e.f65809b, mVar, this.f65824c);
                            if (!this.f65822a && (fullScreenVideoAdListener4 = this.f65823b) != null) {
                                fullScreenVideoAdListener4.onFullScreenVideoAdLoad(jVar);
                            }
                            com.bytedance.sdk.openadsdk.core.h.a.a().a(mVar, new a.InterfaceC1905a(this, mVar) { // from class: com.bytedance.sdk.openadsdk.component.reward.c.3.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ m f65827a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass3 f65828b;

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
                                    this.f65828b = this;
                                    this.f65827a = mVar;
                                }

                                @Override // com.bytedance.sdk.openadsdk.core.h.a.InterfaceC1905a
                                public void a(boolean z2) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeZ(1048576, this, z2) == null) {
                                        AnonymousClass3 anonymousClass3 = this.f65828b;
                                        if (anonymousClass3.f65822a || anonymousClass3.f65823b == null || !com.bytedance.sdk.openadsdk.core.e.o.j(this.f65827a)) {
                                            return;
                                        }
                                        com.bytedance.sdk.openadsdk.e.d.a(this.f65828b.f65826e.f65809b, this.f65827a, q.b(this.f65828b.f65824c.getDurationSlotType()), this.f65828b.f65825d);
                                        this.f65828b.f65823b.onFullScreenVideoCached();
                                    }
                                }
                            });
                            if (mVar.aK()) {
                                if (this.f65822a && !com.bytedance.sdk.openadsdk.core.e.o.j(mVar) && o.h().q(this.f65824c.getCodeId()).f66669d == 1) {
                                    if (n.d(this.f65826e.f65809b)) {
                                        return;
                                    }
                                    c cVar = this.f65826e;
                                    cVar.a(new a(cVar, mVar, this.f65824c));
                                } else if (com.bytedance.sdk.openadsdk.core.e.o.j(mVar)) {
                                    com.bytedance.sdk.openadsdk.component.reward.a.a(this.f65826e.f65809b).a(this.f65824c, mVar);
                                } else if (Build.VERSION.SDK_INT < 23) {
                                    com.bytedance.sdk.openadsdk.component.reward.a.a(this.f65826e.f65809b).a(mVar, new a.InterfaceC1894a<Object>(this, mVar, jVar) { // from class: com.bytedance.sdk.openadsdk.component.reward.c.3.3
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;

                                        /* renamed from: a  reason: collision with root package name */
                                        public final /* synthetic */ m f65833a;

                                        /* renamed from: b  reason: collision with root package name */
                                        public final /* synthetic */ j f65834b;

                                        /* renamed from: c  reason: collision with root package name */
                                        public final /* synthetic */ AnonymousClass3 f65835c;

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
                                            this.f65835c = this;
                                            this.f65833a = mVar;
                                            this.f65834b = jVar;
                                        }

                                        @Override // com.bytedance.sdk.openadsdk.component.reward.a.InterfaceC1894a
                                        public void a(boolean z2, Object obj) {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeZL(1048576, this, z2, obj) == null) {
                                                com.bytedance.sdk.component.utils.k.b("FullScreenVideoLoadManager", "download video file: " + z2 + ", preload: " + this.f65835c.f65822a);
                                                if (z2) {
                                                    this.f65834b.a(com.bytedance.sdk.openadsdk.component.reward.a.a(this.f65835c.f65826e.f65809b).a(this.f65833a));
                                                }
                                                AnonymousClass3 anonymousClass3 = this.f65835c;
                                                if (anonymousClass3.f65822a) {
                                                    if (z2) {
                                                        com.bytedance.sdk.openadsdk.component.reward.a.a(anonymousClass3.f65826e.f65809b).a(this.f65835c.f65824c, this.f65833a);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                com.bytedance.sdk.openadsdk.e.d.a(this.f65833a);
                                                if (z2) {
                                                    AnonymousClass3 anonymousClass32 = this.f65835c;
                                                    if (anonymousClass32.f65823b != null) {
                                                        com.bytedance.sdk.openadsdk.e.d.a(anonymousClass32.f65826e.f65809b, this.f65833a, q.b(this.f65835c.f65824c.getDurationSlotType()), this.f65835c.f65825d);
                                                        this.f65835c.f65823b.onFullScreenVideoCached();
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
                                        bVar2.a(this.f65824c);
                                        bVar2.a(mVar);
                                        long elapsedRealtime = SystemClock.elapsedRealtime();
                                        com.bytedance.sdk.component.utils.k.c("FullScreenVideoLoadManager", "FullScreenLog: preload video ");
                                        com.bytedance.sdk.openadsdk.core.video.d.c.a(bVar2, new com.bytedance.sdk.component.video.a.c.b(this, elapsedRealtime, mVar, V) { // from class: com.bytedance.sdk.openadsdk.component.reward.c.3.2
                                            public static /* synthetic */ Interceptable $ic;
                                            public transient /* synthetic */ FieldHolder $fh;

                                            /* renamed from: a  reason: collision with root package name */
                                            public final /* synthetic */ long f65829a;

                                            /* renamed from: b  reason: collision with root package name */
                                            public final /* synthetic */ m f65830b;

                                            /* renamed from: c  reason: collision with root package name */
                                            public final /* synthetic */ x f65831c;

                                            /* renamed from: d  reason: collision with root package name */
                                            public final /* synthetic */ AnonymousClass3 f65832d;

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
                                                this.f65832d = this;
                                                this.f65829a = elapsedRealtime;
                                                this.f65830b = mVar;
                                                this.f65831c = V;
                                            }

                                            @Override // com.bytedance.sdk.component.video.a.c.a.InterfaceC1891a
                                            public void a(com.bytedance.sdk.component.video.b.a aVar2, int i2) {
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 == null || interceptable3.invokeLI(1048576, this, aVar2, i2) == null) {
                                                    com.bytedance.sdk.component.utils.k.c("FullScreenVideoLoadManager", "FullScreenLog:  onVideoPreloadSuccess");
                                                    AnonymousClass3 anonymousClass3 = this.f65832d;
                                                    if (anonymousClass3.f65822a) {
                                                        com.bytedance.sdk.openadsdk.component.reward.a.a(anonymousClass3.f65826e.f65809b).a(this.f65832d.f65824c, this.f65830b);
                                                        com.bytedance.sdk.component.utils.k.c("FullScreenVideoLoadManager", "FullScreenLog:  ad json save");
                                                        return;
                                                    }
                                                    TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener5 = anonymousClass3.f65823b;
                                                    if (fullScreenVideoAdListener5 != null) {
                                                        fullScreenVideoAdListener5.onFullScreenVideoCached();
                                                    }
                                                    com.bytedance.sdk.openadsdk.component.reward.a.a(this.f65832d.f65826e.f65809b, true, this.f65830b, i2, SystemClock.elapsedRealtime() - this.f65829a, null);
                                                    com.bytedance.sdk.component.utils.k.c("FullScreenVideoLoadManager", "FullScreenLog: onFullScreenVideoCached");
                                                }
                                            }

                                            @Override // com.bytedance.sdk.component.video.a.c.a.InterfaceC1891a
                                            public void a(com.bytedance.sdk.component.video.b.a aVar2, int i2, String str) {
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 == null || interceptable3.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar2, i2, str) == null) {
                                                    com.bytedance.sdk.openadsdk.component.reward.a.a(this.f65832d.f65826e.f65809b, false, this.f65830b, i2, SystemClock.elapsedRealtime() - this.f65829a, str);
                                                    com.bytedance.sdk.component.utils.k.c("FullScreenVideoLoadManager", "FullScreenLog:  onVideoPreloadFail");
                                                    if (this.f65832d.f65823b == null || !this.f65831c.s()) {
                                                        return;
                                                    }
                                                    this.f65832d.f65823b.onFullScreenVideoCached();
                                                    com.bytedance.sdk.component.utils.k.c("FullScreenVideoLoadManager", "FullScreenLog:  onVideoPreloadFail and exec onFullScreenVideoCached");
                                                }
                                            }
                                        });
                                    }
                                }
                            } else if (this.f65822a || (fullScreenVideoAdListener3 = this.f65823b) == null) {
                            } else {
                                fullScreenVideoAdListener3.onError(-4, com.bytedance.sdk.openadsdk.core.g.a(-4));
                            }
                        } else if (this.f65822a || (fullScreenVideoAdListener2 = this.f65823b) == null) {
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
            com.bytedance.sdk.openadsdk.component.reward.a.a(this.f65809b).a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, aVar) == null) || aVar == null) {
            return;
        }
        if (this.f65812e.size() >= 1) {
            this.f65812e.remove(0);
        }
        this.f65812e.add(aVar);
    }
}
