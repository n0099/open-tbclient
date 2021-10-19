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
import com.bytedance.sdk.openadsdk.component.reward.f;
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
public class h {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    public static volatile h f66223a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Context f66224b;

    /* renamed from: c  reason: collision with root package name */
    public final p f66225c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f66226d;

    /* renamed from: e  reason: collision with root package name */
    public List<a> f66227e;

    /* renamed from: f  reason: collision with root package name */
    public final BroadcastReceiver f66228f;

    /* loaded from: classes9.dex */
    public class a extends com.bytedance.sdk.component.d.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public m f66252a;

        /* renamed from: b  reason: collision with root package name */
        public AdSlot f66253b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ h f66254c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(h hVar, m mVar, AdSlot adSlot) {
            super("Reward Task");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, mVar, adSlot};
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
            this.f66254c = hVar;
            this.f66252a = mVar;
            this.f66253b = adSlot;
        }

        @Override // java.lang.Runnable
        public void run() {
            m mVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (mVar = this.f66252a) == null) {
                return;
            }
            if (Build.VERSION.SDK_INT < 23) {
                f.a(this.f66254c.f66224b).a(this.f66252a, new f.a<Object>(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.h.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f66256a;

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
                        this.f66256a = this;
                    }

                    @Override // com.bytedance.sdk.openadsdk.component.reward.f.a
                    public void a(boolean z, Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZL(1048576, this, z, obj) == null) {
                            if (z) {
                                com.bytedance.sdk.component.utils.k.c("RewardVideoLoadManager", "RewardVideoLog: onVideoPreloadSuccess with net change !!");
                                f a2 = f.a(this.f66256a.f66254c.f66224b);
                                a aVar = this.f66256a;
                                a2.a(aVar.f66253b, aVar.f66252a);
                                return;
                            }
                            com.bytedance.sdk.component.utils.k.c("RewardVideoLoadManager", "RewardVideoLog: onVideoPreloadFail with net change !!");
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
                bVar.a(this.f66253b);
                bVar.a(this.f66252a);
                com.bytedance.sdk.openadsdk.core.video.d.c.a(bVar, new com.bytedance.sdk.component.video.a.c.b(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.h.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f66255a;

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
                        this.f66255a = this;
                    }

                    @Override // com.bytedance.sdk.component.video.a.c.a.InterfaceC1897a
                    public void a(com.bytedance.sdk.component.video.b.a aVar, int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, aVar, i2) == null) {
                            com.bytedance.sdk.component.utils.k.c("RewardVideoLoadManager", "RewardVideoLog: onVideoPreloadSuccess with net change !!");
                            f a2 = f.a(this.f66255a.f66254c.f66224b);
                            a aVar2 = this.f66255a;
                            a2.a(aVar2.f66253b, aVar2.f66252a);
                        }
                    }

                    @Override // com.bytedance.sdk.component.video.a.c.a.InterfaceC1897a
                    public void a(com.bytedance.sdk.component.video.b.a aVar, int i2, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, i2, str) == null) {
                            com.bytedance.sdk.component.utils.k.c("RewardVideoLoadManager", "RewardVideoLog: onVideoPreloadFail with net change !!");
                        }
                    }
                });
            }
        }
    }

    public h(Context context) {
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
        this.f66226d = new AtomicBoolean(false);
        this.f66227e = Collections.synchronizedList(new ArrayList());
        this.f66228f = new BroadcastReceiver(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.h.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ h f66251a;

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
                this.f66251a = this;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeLL(1048576, this, context2, intent) == null) && "android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) && n.c(this.f66251a.f66224b) != 0) {
                    Iterator it = this.f66251a.f66227e.iterator();
                    while (it.hasNext()) {
                        com.bytedance.sdk.component.d.e.a((com.bytedance.sdk.component.d.g) it.next(), 1);
                        it.remove();
                    }
                }
            }
        };
        this.f66225c = o.f();
        this.f66224b = context == null ? o.a() : context.getApplicationContext();
        c();
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || this.f66226d.get()) {
            return;
        }
        this.f66226d.set(true);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            this.f66224b.registerReceiver(this.f66228f, intentFilter);
        } catch (Exception unused) {
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65545, this) == null) && this.f66226d.get()) {
            this.f66226d.set(false);
            try {
                this.f66224b.unregisterReceiver(this.f66228f);
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            try {
                f.a(this.f66224b).a();
            } catch (Throwable unused) {
            }
        }
    }

    public static h a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f66223a == null) {
                synchronized (h.class) {
                    if (f66223a == null) {
                        f66223a = new h(context);
                    }
                }
            }
            return f66223a;
        }
        return (h) invokeL.objValue;
    }

    public void b(AdSlot adSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, adSlot) == null) {
            if (adSlot != null && !TextUtils.isEmpty(adSlot.getBidAdm())) {
                com.bytedance.sdk.component.utils.k.b("bidding", "preload bidding 逻辑不走预加载逻辑：BidAdm->MD5->" + com.bytedance.sdk.openadsdk.n.g.b.a(adSlot.getBidAdm()));
                return;
            }
            com.bytedance.sdk.component.utils.k.b("RewardVideoLoadManager", "preload reward video: " + String.valueOf(adSlot));
            a(adSlot, true, null);
        }
    }

    @Nullable
    public AdSlot b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? f.a(this.f66224b).b(str) : (AdSlot) invokeL.objValue;
    }

    public void a() {
        AdSlot b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (b2 = f.a(this.f66224b).b()) == null || TextUtils.isEmpty(b2.getCodeId()) || f.a(this.f66224b).c(b2.getCodeId()) != null) {
            return;
        }
        b(b2);
    }

    public void a(AdSlot adSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adSlot) == null) {
            f.a(this.f66224b).b(adSlot);
        }
    }

    public void a(AdSlot adSlot, TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, adSlot, rewardVideoAdListener) == null) {
            com.bytedance.sdk.component.utils.k.b("RewardVideoLoadManager", "load reward vide: " + String.valueOf(adSlot));
            com.bytedance.sdk.component.utils.k.b("bidding", "load reward vide: BidAdm->MD5->" + com.bytedance.sdk.openadsdk.n.g.b.a(adSlot.getBidAdm()));
            f.a(this.f66224b).a(adSlot);
            a(adSlot, false, rewardVideoAdListener);
        }
    }

    private void a(AdSlot adSlot, boolean z, TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{adSlot, Boolean.valueOf(z), rewardVideoAdListener}) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (z) {
                a(adSlot, true, rewardVideoAdListener, currentTimeMillis);
                return;
            }
            m c2 = f.a(this.f66224b).c(adSlot.getCodeId());
            if (c2 != null) {
                k kVar = new k(this.f66224b, c2, adSlot);
                if (!com.bytedance.sdk.openadsdk.core.e.o.j(c2)) {
                    kVar.a(f.a(this.f66224b).a(c2));
                }
                com.bytedance.sdk.openadsdk.e.d.a(c2);
                if (rewardVideoAdListener != null) {
                    rewardVideoAdListener.onRewardVideoAdLoad(kVar);
                    if (!com.bytedance.sdk.openadsdk.core.e.o.j(c2)) {
                        com.bytedance.sdk.openadsdk.e.d.a(this.f66224b, c2, q.b(adSlot.getDurationSlotType()), currentTimeMillis);
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
                            com.bytedance.sdk.openadsdk.core.video.d.c.a(bVar, new com.bytedance.sdk.component.video.a.c.b(this, rewardVideoAdListener, V) { // from class: com.bytedance.sdk.openadsdk.component.reward.h.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ TTAdNative.RewardVideoAdListener f66229a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ x f66230b;

                                /* renamed from: c  reason: collision with root package name */
                                public final /* synthetic */ h f66231c;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, rewardVideoAdListener, V};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f66231c = this;
                                    this.f66229a = rewardVideoAdListener;
                                    this.f66230b = V;
                                }

                                @Override // com.bytedance.sdk.component.video.a.c.a.InterfaceC1897a
                                public void a(com.bytedance.sdk.component.video.b.a aVar, int i2) {
                                    TTAdNative.RewardVideoAdListener rewardVideoAdListener2;
                                    Interceptable interceptable2 = $ic;
                                    if (!(interceptable2 == null || interceptable2.invokeLI(1048576, this, aVar, i2) == null) || (rewardVideoAdListener2 = this.f66229a) == null) {
                                        return;
                                    }
                                    rewardVideoAdListener2.onRewardVideoCached();
                                    com.bytedance.sdk.component.utils.k.c("RewardVideoLoadManager", "RewardVideoLog: Cached ad  onRewardVideoCached");
                                }

                                @Override // com.bytedance.sdk.component.video.a.c.a.InterfaceC1897a
                                public void a(com.bytedance.sdk.component.video.b.a aVar, int i2, String str) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, i2, str) == null) {
                                        com.bytedance.sdk.component.utils.k.c("RewardVideoLoadManager", "RewardVideoLog: Cached ad  onVideoPreloadFail");
                                        if (this.f66229a == null || !this.f66230b.s()) {
                                            return;
                                        }
                                        this.f66229a.onRewardVideoCached();
                                        com.bytedance.sdk.component.utils.k.c("RewardVideoLoadManager", "RewardVideoLog: Cached ad  onVideoPreloadFail and exec onRewardVideoCached");
                                    }
                                }
                            });
                        } else {
                            rewardVideoAdListener.onRewardVideoCached();
                        }
                    }
                }
                com.bytedance.sdk.openadsdk.core.h.a.a().a(c2, new a.InterfaceC1911a(this, rewardVideoAdListener, c2, adSlot, currentTimeMillis) { // from class: com.bytedance.sdk.openadsdk.component.reward.h.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.RewardVideoAdListener f66232a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ m f66233b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ AdSlot f66234c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ long f66235d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ h f66236e;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, rewardVideoAdListener, c2, adSlot, Long.valueOf(currentTimeMillis)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f66236e = this;
                        this.f66232a = rewardVideoAdListener;
                        this.f66233b = c2;
                        this.f66234c = adSlot;
                        this.f66235d = currentTimeMillis;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.h.a.InterfaceC1911a
                    public void a(boolean z2) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeZ(1048576, this, z2) == null) && this.f66232a != null && com.bytedance.sdk.openadsdk.core.e.o.j(this.f66233b)) {
                            com.bytedance.sdk.openadsdk.e.d.a(this.f66236e.f66224b, this.f66233b, q.b(this.f66234c.getDurationSlotType()), this.f66235d);
                            this.f66232a.onRewardVideoCached();
                        }
                    }
                });
                com.bytedance.sdk.component.utils.k.b("RewardVideoLoadManager", "get cache data success");
                return;
            }
            com.bytedance.sdk.component.utils.k.b("TTMediationSDK", "激励视频从网络获取 smartLook参数不为null时.....");
            a(adSlot, false, rewardVideoAdListener, currentTimeMillis);
        }
    }

    private void a(AdSlot adSlot, boolean z, TTAdNative.RewardVideoAdListener rewardVideoAdListener, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{adSlot, Boolean.valueOf(z), rewardVideoAdListener, Long.valueOf(j2)}) == null) {
            com.bytedance.sdk.component.utils.k.b("bidding", "reward video doNetwork 获取新物料:BidAdm->MD5->" + com.bytedance.sdk.openadsdk.n.g.b.a(adSlot.getBidAdm()));
            com.bytedance.sdk.openadsdk.core.e.n nVar = new com.bytedance.sdk.openadsdk.core.e.n();
            nVar.f66836b = z ? 2 : 1;
            if (o.h().i(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f) {
                nVar.f66839e = 2;
            }
            this.f66225c.a(adSlot, nVar, 7, new p.b(this, z, rewardVideoAdListener, adSlot, j2) { // from class: com.bytedance.sdk.openadsdk.component.reward.h.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f66237a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ TTAdNative.RewardVideoAdListener f66238b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ AdSlot f66239c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ long f66240d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ h f66241e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z), rewardVideoAdListener, adSlot, Long.valueOf(j2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f66241e = this;
                    this.f66237a = z;
                    this.f66238b = rewardVideoAdListener;
                    this.f66239c = adSlot;
                    this.f66240d = j2;
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.b
                public void a(int i2, String str) {
                    TTAdNative.RewardVideoAdListener rewardVideoAdListener2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) || this.f66237a || (rewardVideoAdListener2 = this.f66238b) == null) {
                        return;
                    }
                    rewardVideoAdListener2.onError(i2, str);
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.b
                public void a(com.bytedance.sdk.openadsdk.core.e.a aVar) {
                    TTAdNative.RewardVideoAdListener rewardVideoAdListener2;
                    TTAdNative.RewardVideoAdListener rewardVideoAdListener3;
                    TTAdNative.RewardVideoAdListener rewardVideoAdListener4;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                        if (aVar.c() != null && !aVar.c().isEmpty()) {
                            com.bytedance.sdk.component.utils.k.b("RewardVideoLoadManager", "get material data success isPreload=" + this.f66237a);
                            m mVar = aVar.c().get(0);
                            try {
                                l Y = mVar.Y();
                                if (Y != null && !TextUtils.isEmpty(Y.a())) {
                                    com.bytedance.sdk.openadsdk.k.b bVar = new com.bytedance.sdk.openadsdk.k.b(true);
                                    bVar.a(this.f66239c.getCodeId());
                                    bVar.a(7);
                                    bVar.c(mVar.ak());
                                    bVar.d(mVar.ao());
                                    bVar.b(q.h(mVar.ao()));
                                    ImageLoaderWrapper.from(Y).to(bVar);
                                }
                            } catch (Throwable unused) {
                            }
                            k kVar = new k(this.f66241e.f66224b, mVar, this.f66239c);
                            if (!this.f66237a && (rewardVideoAdListener4 = this.f66238b) != null) {
                                rewardVideoAdListener4.onRewardVideoAdLoad(kVar);
                            }
                            com.bytedance.sdk.openadsdk.core.h.a.a().a(mVar, new a.InterfaceC1911a(this, mVar) { // from class: com.bytedance.sdk.openadsdk.component.reward.h.3.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ m f66242a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass3 f66243b;

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
                                    this.f66243b = this;
                                    this.f66242a = mVar;
                                }

                                @Override // com.bytedance.sdk.openadsdk.core.h.a.InterfaceC1911a
                                public void a(boolean z2) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeZ(1048576, this, z2) == null) {
                                        AnonymousClass3 anonymousClass3 = this.f66243b;
                                        if (anonymousClass3.f66237a || anonymousClass3.f66238b == null || !com.bytedance.sdk.openadsdk.core.e.o.j(this.f66242a)) {
                                            return;
                                        }
                                        com.bytedance.sdk.openadsdk.e.d.a(this.f66243b.f66241e.f66224b, this.f66242a, q.b(this.f66243b.f66239c.getDurationSlotType()), this.f66243b.f66240d);
                                        this.f66243b.f66238b.onRewardVideoCached();
                                    }
                                }
                            });
                            if (mVar.aK()) {
                                if (this.f66237a && !com.bytedance.sdk.openadsdk.core.e.o.j(mVar) && o.h().q(this.f66239c.getCodeId()).f67015d == 1) {
                                    if (n.d(this.f66241e.f66224b)) {
                                        return;
                                    }
                                    h hVar = this.f66241e;
                                    hVar.a(new a(hVar, mVar, this.f66239c));
                                } else if (com.bytedance.sdk.openadsdk.core.e.o.j(mVar)) {
                                    f.a(this.f66241e.f66224b).a(this.f66239c, mVar);
                                } else if (Build.VERSION.SDK_INT < 23) {
                                    f.a(this.f66241e.f66224b).a(mVar, new f.a<Object>(this, mVar, kVar) { // from class: com.bytedance.sdk.openadsdk.component.reward.h.3.3
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;

                                        /* renamed from: a  reason: collision with root package name */
                                        public final /* synthetic */ m f66248a;

                                        /* renamed from: b  reason: collision with root package name */
                                        public final /* synthetic */ k f66249b;

                                        /* renamed from: c  reason: collision with root package name */
                                        public final /* synthetic */ AnonymousClass3 f66250c;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this, mVar, kVar};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i2 = newInitContext.flag;
                                                if ((i2 & 1) != 0) {
                                                    int i3 = i2 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.f66250c = this;
                                            this.f66248a = mVar;
                                            this.f66249b = kVar;
                                        }

                                        @Override // com.bytedance.sdk.openadsdk.component.reward.f.a
                                        public void a(boolean z2, Object obj) {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeZL(1048576, this, z2, obj) == null) {
                                                com.bytedance.sdk.component.utils.k.b("RewardVideoLoadManager", "download video file: " + z2 + ", preload: " + this.f66250c.f66237a);
                                                if (z2) {
                                                    this.f66249b.a(f.a(this.f66250c.f66241e.f66224b).a(this.f66248a));
                                                }
                                                AnonymousClass3 anonymousClass3 = this.f66250c;
                                                if (anonymousClass3.f66237a) {
                                                    if (z2) {
                                                        f.a(anonymousClass3.f66241e.f66224b).a(this.f66250c.f66239c, this.f66248a);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                com.bytedance.sdk.openadsdk.e.d.a(this.f66248a);
                                                if (z2) {
                                                    AnonymousClass3 anonymousClass32 = this.f66250c;
                                                    if (anonymousClass32.f66238b != null) {
                                                        com.bytedance.sdk.openadsdk.e.d.a(anonymousClass32.f66241e.f66224b, this.f66248a, q.b(this.f66250c.f66239c.getDurationSlotType()), this.f66250c.f66240d);
                                                        this.f66250c.f66238b.onRewardVideoCached();
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
                                        bVar2.a(this.f66239c);
                                        bVar2.a(mVar);
                                        com.bytedance.sdk.openadsdk.core.video.d.c.a(bVar2, new com.bytedance.sdk.component.video.a.c.b(this, SystemClock.elapsedRealtime(), mVar, V) { // from class: com.bytedance.sdk.openadsdk.component.reward.h.3.2
                                            public static /* synthetic */ Interceptable $ic;
                                            public transient /* synthetic */ FieldHolder $fh;

                                            /* renamed from: a  reason: collision with root package name */
                                            public final /* synthetic */ long f66244a;

                                            /* renamed from: b  reason: collision with root package name */
                                            public final /* synthetic */ m f66245b;

                                            /* renamed from: c  reason: collision with root package name */
                                            public final /* synthetic */ x f66246c;

                                            /* renamed from: d  reason: collision with root package name */
                                            public final /* synthetic */ AnonymousClass3 f66247d;

                                            {
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 != null) {
                                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                                    newInitContext.initArgs = r2;
                                                    Object[] objArr = {this, Long.valueOf(r7), mVar, V};
                                                    interceptable3.invokeUnInit(65536, newInitContext);
                                                    int i2 = newInitContext.flag;
                                                    if ((i2 & 1) != 0) {
                                                        int i3 = i2 & 2;
                                                        newInitContext.thisArg = this;
                                                        interceptable3.invokeInitBody(65536, newInitContext);
                                                        return;
                                                    }
                                                }
                                                this.f66247d = this;
                                                this.f66244a = r7;
                                                this.f66245b = mVar;
                                                this.f66246c = V;
                                            }

                                            @Override // com.bytedance.sdk.component.video.a.c.a.InterfaceC1897a
                                            public void a(com.bytedance.sdk.component.video.b.a aVar2, int i2) {
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 == null || interceptable3.invokeLI(1048576, this, aVar2, i2) == null) {
                                                    com.bytedance.sdk.component.utils.k.c("RewardVideoLoadManager", "RewardVideoLog: onVideoPreloadSuccess");
                                                    AnonymousClass3 anonymousClass3 = this.f66247d;
                                                    if (anonymousClass3.f66237a) {
                                                        f.a(anonymousClass3.f66241e.f66224b).a(this.f66247d.f66239c, this.f66245b);
                                                        com.bytedance.sdk.component.utils.k.c("RewardVideoLoadManager", "RewardVideoLog: ad json save");
                                                        return;
                                                    }
                                                    TTAdNative.RewardVideoAdListener rewardVideoAdListener5 = anonymousClass3.f66238b;
                                                    if (rewardVideoAdListener5 != null) {
                                                        rewardVideoAdListener5.onRewardVideoCached();
                                                        com.bytedance.sdk.component.utils.k.c("RewardVideoLoadManager", "RewardVideoLog: onRewardVideoCached");
                                                    }
                                                    f.a(this.f66247d.f66241e.f66224b, true, this.f66245b, i2, SystemClock.elapsedRealtime() - this.f66244a, null);
                                                }
                                            }

                                            @Override // com.bytedance.sdk.component.video.a.c.a.InterfaceC1897a
                                            public void a(com.bytedance.sdk.component.video.b.a aVar2, int i2, String str) {
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 == null || interceptable3.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar2, i2, str) == null) {
                                                    com.bytedance.sdk.component.utils.k.c("RewardVideoLoadManager", "RewardVideoLog: onVideoPreloadFail");
                                                    f.a(this.f66247d.f66241e.f66224b, false, this.f66245b, i2, SystemClock.elapsedRealtime() - this.f66244a, str);
                                                    if (this.f66247d.f66238b == null || !this.f66246c.s()) {
                                                        return;
                                                    }
                                                    this.f66247d.f66238b.onRewardVideoCached();
                                                    com.bytedance.sdk.component.utils.k.c("RewardVideoLoadManager", "RewardVideoLog:  onVideoPreloadFail and exec onRewardVideoCached");
                                                }
                                            }
                                        });
                                    }
                                }
                            } else if (this.f66237a || (rewardVideoAdListener3 = this.f66238b) == null) {
                            } else {
                                rewardVideoAdListener3.onError(-4, com.bytedance.sdk.openadsdk.core.g.a(-4));
                            }
                        } else if (this.f66237a || (rewardVideoAdListener2 = this.f66238b) == null) {
                        } else {
                            rewardVideoAdListener2.onError(-3, com.bytedance.sdk.openadsdk.core.g.a(-3));
                        }
                    }
                }
            });
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            f.a(this.f66224b).a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, aVar) == null) || aVar == null) {
            return;
        }
        if (this.f66227e.size() >= 1) {
            this.f66227e.remove(0);
        }
        this.f66227e.add(aVar);
    }
}
