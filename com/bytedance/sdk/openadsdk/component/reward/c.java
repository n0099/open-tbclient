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
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f29444a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Context f29445b;

    /* renamed from: c  reason: collision with root package name */
    public final p f29446c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f29447d;

    /* renamed from: e  reason: collision with root package name */
    public List<a> f29448e;

    /* renamed from: f  reason: collision with root package name */
    public final BroadcastReceiver f29449f;

    /* loaded from: classes5.dex */
    public class a extends com.bytedance.sdk.component.e.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public m f29473a;

        /* renamed from: b  reason: collision with root package name */
        public AdSlot f29474b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f29475c;

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
            this.f29475c = cVar;
            this.f29473a = mVar;
            this.f29474b = adSlot;
        }

        @Override // java.lang.Runnable
        public void run() {
            m mVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (mVar = this.f29473a) == null) {
                return;
            }
            if (Build.VERSION.SDK_INT < 23) {
                com.bytedance.sdk.openadsdk.component.reward.a.a(this.f29475c.f29445b).a(this.f29473a, new a.InterfaceC0328a<Object>(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.c.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f29486a;

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
                        this.f29486a = this;
                    }

                    @Override // com.bytedance.sdk.openadsdk.component.reward.a.InterfaceC0328a
                    public void a(boolean z, Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZL(1048576, this, z, obj) == null) {
                            if (z) {
                                com.bytedance.sdk.openadsdk.component.reward.a a2 = com.bytedance.sdk.openadsdk.component.reward.a.a(this.f29486a.f29475c.f29445b);
                                a aVar = this.f29486a;
                                a2.a(aVar.f29474b, aVar.f29473a);
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
                    public final /* synthetic */ a f29485a;

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
                        this.f29485a = this;
                    }

                    @Override // com.bytedance.sdk.component.video.a.c.a.InterfaceC0325a
                    public void a(com.bytedance.sdk.component.video.b.a aVar, int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, aVar, i2) == null) {
                            com.bytedance.sdk.openadsdk.component.reward.a a2 = com.bytedance.sdk.openadsdk.component.reward.a.a(this.f29485a.f29475c.f29445b);
                            a aVar2 = this.f29485a;
                            a2.a(aVar2.f29474b, aVar2.f29473a);
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
        this.f29447d = new AtomicBoolean(false);
        this.f29448e = Collections.synchronizedList(new ArrayList());
        this.f29449f = new BroadcastReceiver(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.c.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f29472a;

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
                this.f29472a = this;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeLL(1048576, this, context2, intent) == null) && "android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) && com.bytedance.sdk.component.utils.m.c(this.f29472a.f29445b) != 0) {
                    Iterator it = this.f29472a.f29448e.iterator();
                    while (it.hasNext()) {
                        com.bytedance.sdk.component.e.e.a((com.bytedance.sdk.component.e.g) it.next(), 1);
                        it.remove();
                    }
                }
            }
        };
        this.f29446c = o.f();
        this.f29445b = context == null ? o.a() : context.getApplicationContext();
        c();
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || this.f29447d.get()) {
            return;
        }
        this.f29447d.set(true);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            this.f29445b.registerReceiver(this.f29449f, intentFilter);
        } catch (Exception unused) {
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65545, this) == null) && this.f29447d.get()) {
            this.f29447d.set(false);
            try {
                this.f29445b.unregisterReceiver(this.f29449f);
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
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (b2 = com.bytedance.sdk.openadsdk.component.reward.a.a(this.f29445b).b()) == null || TextUtils.isEmpty(b2.getCodeId()) || com.bytedance.sdk.openadsdk.component.reward.a.a(this.f29445b).c(b2.getCodeId()) != null) {
            return;
        }
        b(b2);
    }

    public static c a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f29444a == null) {
                synchronized (c.class) {
                    if (f29444a == null) {
                        f29444a = new c(context);
                    }
                }
            }
            return f29444a;
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
                com.bytedance.sdk.openadsdk.component.reward.a.a(this.f29445b).a();
            } catch (Throwable unused) {
            }
        }
    }

    public void a(AdSlot adSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adSlot) == null) {
            com.bytedance.sdk.openadsdk.component.reward.a.a(this.f29445b).b(adSlot);
        }
    }

    @Nullable
    public AdSlot b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? com.bytedance.sdk.openadsdk.component.reward.a.a(this.f29445b).b(str) : (AdSlot) invokeL.objValue;
    }

    public void a(AdSlot adSlot, TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, adSlot, fullScreenVideoAdListener) == null) {
            com.bytedance.sdk.component.utils.j.b("FullScreenVideoLoadManager", "load full screen video: " + String.valueOf(adSlot));
            com.bytedance.sdk.component.utils.j.b("bidding", "load full video: BidAdm->MD5->" + com.bytedance.sdk.openadsdk.o.g.b.a(adSlot.getBidAdm()));
            com.bytedance.sdk.openadsdk.component.reward.a.a(this.f29445b).a(adSlot);
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
            m c2 = com.bytedance.sdk.openadsdk.component.reward.a.a(this.f29445b).c(adSlot.getCodeId());
            if (c2 != null && adSlot.getExtraSmartLookParam() == null) {
                j jVar = new j(this.f29445b, c2, adSlot);
                if (!com.bytedance.sdk.openadsdk.core.e.o.j(c2)) {
                    jVar.a(com.bytedance.sdk.openadsdk.component.reward.a.a(this.f29445b).a(c2));
                }
                com.bytedance.sdk.openadsdk.e.d.a(c2);
                if (fullScreenVideoAdListener != null) {
                    fullScreenVideoAdListener.onFullScreenVideoAdLoad(jVar);
                    if (!com.bytedance.sdk.openadsdk.core.e.o.j(c2)) {
                        com.bytedance.sdk.openadsdk.e.d.a(this.f29445b, c2, com.bytedance.sdk.openadsdk.r.o.b(adSlot.getDurationSlotType()), currentTimeMillis);
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
                                public final /* synthetic */ TTAdNative.FullScreenVideoAdListener f29450a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ x f29451b;

                                /* renamed from: c  reason: collision with root package name */
                                public final /* synthetic */ c f29452c;

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
                                    this.f29452c = this;
                                    this.f29450a = fullScreenVideoAdListener;
                                    this.f29451b = V;
                                }

                                @Override // com.bytedance.sdk.component.video.a.c.a.InterfaceC0325a
                                public void a(com.bytedance.sdk.component.video.b.a aVar, int i2) {
                                    TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener2;
                                    Interceptable interceptable2 = $ic;
                                    if (!(interceptable2 == null || interceptable2.invokeLI(1048576, this, aVar, i2) == null) || (fullScreenVideoAdListener2 = this.f29450a) == null) {
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
                                        if (this.f29450a == null || !this.f29451b.s()) {
                                            return;
                                        }
                                        this.f29450a.onFullScreenVideoCached();
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
                    public final /* synthetic */ TTAdNative.FullScreenVideoAdListener f29453a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ m f29454b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ AdSlot f29455c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ long f29456d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ c f29457e;

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
                        this.f29457e = this;
                        this.f29453a = fullScreenVideoAdListener;
                        this.f29454b = c2;
                        this.f29455c = adSlot;
                        this.f29456d = currentTimeMillis;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.h.a.InterfaceC0339a
                    public void a(boolean z2) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeZ(1048576, this, z2) == null) && this.f29453a != null && com.bytedance.sdk.openadsdk.core.e.o.j(this.f29454b)) {
                            com.bytedance.sdk.openadsdk.e.d.a(this.f29457e.f29445b, this.f29454b, com.bytedance.sdk.openadsdk.r.o.b(this.f29455c.getDurationSlotType()), this.f29456d);
                            this.f29453a.onFullScreenVideoCached();
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
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{adSlot, Boolean.valueOf(z), fullScreenVideoAdListener, Long.valueOf(j)}) == null) {
            com.bytedance.sdk.component.utils.j.b("bidding", "full video doNetwork 获取新物料:BidAdm->MD5->" + com.bytedance.sdk.openadsdk.o.g.b.a(adSlot.getBidAdm()));
            n nVar = new n();
            nVar.f30102c = z ? 2 : 1;
            if (o.h().i(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f) {
                nVar.f30104e = 2;
            }
            this.f29446c.a(adSlot, nVar, 8, new p.b(this, z, fullScreenVideoAdListener, adSlot, j) { // from class: com.bytedance.sdk.openadsdk.component.reward.c.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f29458a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ TTAdNative.FullScreenVideoAdListener f29459b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ AdSlot f29460c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ long f29461d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ c f29462e;

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
                    this.f29462e = this;
                    this.f29458a = z;
                    this.f29459b = fullScreenVideoAdListener;
                    this.f29460c = adSlot;
                    this.f29461d = j;
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.b
                public void a(int i2, String str) {
                    TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) || this.f29458a || (fullScreenVideoAdListener2 = this.f29459b) == null) {
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
                            com.bytedance.sdk.component.utils.j.b("FullScreenVideoLoadManager", "get material data success isPreload=" + this.f29458a);
                            m mVar = aVar.c().get(0);
                            try {
                                l Y = mVar.Y();
                                if (Y != null && !TextUtils.isEmpty(Y.a())) {
                                    com.bytedance.sdk.openadsdk.l.c cVar = new com.bytedance.sdk.openadsdk.l.c(true);
                                    cVar.a(this.f29460c.getCodeId());
                                    cVar.a(8);
                                    cVar.c(mVar.ak());
                                    cVar.d(mVar.ao());
                                    cVar.b(com.bytedance.sdk.openadsdk.r.o.h(mVar.ao()));
                                    com.bytedance.sdk.openadsdk.g.a.a(Y).a(cVar);
                                }
                            } catch (Throwable unused) {
                            }
                            j jVar = new j(this.f29462e.f29445b, mVar, this.f29460c);
                            if (!this.f29458a && (fullScreenVideoAdListener4 = this.f29459b) != null) {
                                fullScreenVideoAdListener4.onFullScreenVideoAdLoad(jVar);
                            }
                            com.bytedance.sdk.openadsdk.core.h.a.a().a(mVar, new a.InterfaceC0339a(this, mVar) { // from class: com.bytedance.sdk.openadsdk.component.reward.c.3.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ m f29463a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass3 f29464b;

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
                                    this.f29464b = this;
                                    this.f29463a = mVar;
                                }

                                @Override // com.bytedance.sdk.openadsdk.core.h.a.InterfaceC0339a
                                public void a(boolean z2) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeZ(1048576, this, z2) == null) {
                                        AnonymousClass3 anonymousClass3 = this.f29464b;
                                        if (anonymousClass3.f29458a || anonymousClass3.f29459b == null || !com.bytedance.sdk.openadsdk.core.e.o.j(this.f29463a)) {
                                            return;
                                        }
                                        com.bytedance.sdk.openadsdk.e.d.a(this.f29464b.f29462e.f29445b, this.f29463a, com.bytedance.sdk.openadsdk.r.o.b(this.f29464b.f29460c.getDurationSlotType()), this.f29464b.f29461d);
                                        this.f29464b.f29459b.onFullScreenVideoCached();
                                    }
                                }
                            });
                            if (mVar.aK()) {
                                if (this.f29458a && !com.bytedance.sdk.openadsdk.core.e.o.j(mVar) && o.h().q(this.f29460c.getCodeId()).f30274d == 1) {
                                    if (com.bytedance.sdk.component.utils.m.d(this.f29462e.f29445b)) {
                                        return;
                                    }
                                    c cVar2 = this.f29462e;
                                    cVar2.a(new a(cVar2, mVar, this.f29460c));
                                } else if (com.bytedance.sdk.openadsdk.core.e.o.j(mVar)) {
                                    com.bytedance.sdk.openadsdk.component.reward.a.a(this.f29462e.f29445b).a(this.f29460c, mVar);
                                } else if (Build.VERSION.SDK_INT < 23) {
                                    com.bytedance.sdk.openadsdk.component.reward.a.a(this.f29462e.f29445b).a(mVar, new a.InterfaceC0328a<Object>(this, mVar, jVar) { // from class: com.bytedance.sdk.openadsdk.component.reward.c.3.3
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;

                                        /* renamed from: a  reason: collision with root package name */
                                        public final /* synthetic */ m f29469a;

                                        /* renamed from: b  reason: collision with root package name */
                                        public final /* synthetic */ j f29470b;

                                        /* renamed from: c  reason: collision with root package name */
                                        public final /* synthetic */ AnonymousClass3 f29471c;

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
                                            this.f29471c = this;
                                            this.f29469a = mVar;
                                            this.f29470b = jVar;
                                        }

                                        @Override // com.bytedance.sdk.openadsdk.component.reward.a.InterfaceC0328a
                                        public void a(boolean z2, Object obj) {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeZL(1048576, this, z2, obj) == null) {
                                                com.bytedance.sdk.component.utils.j.b("FullScreenVideoLoadManager", "download video file: " + z2 + ", preload: " + this.f29471c.f29458a);
                                                if (z2) {
                                                    this.f29470b.a(com.bytedance.sdk.openadsdk.component.reward.a.a(this.f29471c.f29462e.f29445b).a(this.f29469a));
                                                }
                                                AnonymousClass3 anonymousClass3 = this.f29471c;
                                                if (anonymousClass3.f29458a) {
                                                    if (z2) {
                                                        com.bytedance.sdk.openadsdk.component.reward.a.a(anonymousClass3.f29462e.f29445b).a(this.f29471c.f29460c, this.f29469a);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                com.bytedance.sdk.openadsdk.e.d.a(this.f29469a);
                                                if (z2) {
                                                    AnonymousClass3 anonymousClass32 = this.f29471c;
                                                    if (anonymousClass32.f29459b != null) {
                                                        com.bytedance.sdk.openadsdk.e.d.a(anonymousClass32.f29462e.f29445b, this.f29469a, com.bytedance.sdk.openadsdk.r.o.b(this.f29471c.f29460c.getDurationSlotType()), this.f29471c.f29461d);
                                                        this.f29471c.f29459b.onFullScreenVideoCached();
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
                                            public final /* synthetic */ long f29465a;

                                            /* renamed from: b  reason: collision with root package name */
                                            public final /* synthetic */ m f29466b;

                                            /* renamed from: c  reason: collision with root package name */
                                            public final /* synthetic */ x f29467c;

                                            /* renamed from: d  reason: collision with root package name */
                                            public final /* synthetic */ AnonymousClass3 f29468d;

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
                                                this.f29468d = this;
                                                this.f29465a = elapsedRealtime;
                                                this.f29466b = mVar;
                                                this.f29467c = V;
                                            }

                                            @Override // com.bytedance.sdk.component.video.a.c.a.InterfaceC0325a
                                            public void a(com.bytedance.sdk.component.video.b.a aVar2, int i2) {
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 == null || interceptable3.invokeLI(1048576, this, aVar2, i2) == null) {
                                                    com.bytedance.sdk.component.utils.j.c("FullScreenVideoLoadManager", "FullScreenLog:  onVideoPreloadSuccess");
                                                    AnonymousClass3 anonymousClass3 = this.f29468d;
                                                    if (anonymousClass3.f29458a) {
                                                        com.bytedance.sdk.openadsdk.component.reward.a.a(anonymousClass3.f29462e.f29445b).a(this.f29468d.f29460c, this.f29466b);
                                                        com.bytedance.sdk.component.utils.j.c("FullScreenVideoLoadManager", "FullScreenLog:  ad json save");
                                                        return;
                                                    }
                                                    TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener5 = anonymousClass3.f29459b;
                                                    if (fullScreenVideoAdListener5 != null) {
                                                        fullScreenVideoAdListener5.onFullScreenVideoCached();
                                                    }
                                                    com.bytedance.sdk.openadsdk.component.reward.a.a(this.f29468d.f29462e.f29445b, true, this.f29466b, i2, SystemClock.elapsedRealtime() - this.f29465a, null);
                                                    com.bytedance.sdk.component.utils.j.c("FullScreenVideoLoadManager", "FullScreenLog: onFullScreenVideoCached");
                                                }
                                            }

                                            @Override // com.bytedance.sdk.component.video.a.c.a.InterfaceC0325a
                                            public void a(com.bytedance.sdk.component.video.b.a aVar2, int i2, String str) {
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 == null || interceptable3.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar2, i2, str) == null) {
                                                    com.bytedance.sdk.openadsdk.component.reward.a.a(this.f29468d.f29462e.f29445b, false, this.f29466b, i2, SystemClock.elapsedRealtime() - this.f29465a, str);
                                                    com.bytedance.sdk.component.utils.j.c("FullScreenVideoLoadManager", "FullScreenLog:  onVideoPreloadFail");
                                                    if (this.f29468d.f29459b == null || !this.f29467c.s()) {
                                                        return;
                                                    }
                                                    this.f29468d.f29459b.onFullScreenVideoCached();
                                                    com.bytedance.sdk.component.utils.j.c("FullScreenVideoLoadManager", "FullScreenLog:  onVideoPreloadFail and exec onFullScreenVideoCached");
                                                }
                                            }
                                        });
                                    }
                                }
                            } else if (this.f29458a || (fullScreenVideoAdListener3 = this.f29459b) == null) {
                            } else {
                                fullScreenVideoAdListener3.onError(-4, com.bytedance.sdk.openadsdk.core.g.a(-4));
                            }
                        } else if (this.f29458a || (fullScreenVideoAdListener2 = this.f29459b) == null) {
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
            com.bytedance.sdk.openadsdk.component.reward.a.a(this.f29445b).a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, aVar) == null) || aVar == null) {
            return;
        }
        if (this.f29448e.size() >= 1) {
            this.f29448e.remove(0);
        }
        this.f29448e.add(aVar);
    }
}
