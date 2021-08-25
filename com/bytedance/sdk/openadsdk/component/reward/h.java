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
    public static volatile h f65697a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Context f65698b;

    /* renamed from: c  reason: collision with root package name */
    public final p f65699c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f65700d;

    /* renamed from: e  reason: collision with root package name */
    public List<a> f65701e;

    /* renamed from: f  reason: collision with root package name */
    public final BroadcastReceiver f65702f;

    /* loaded from: classes9.dex */
    public class a extends com.bytedance.sdk.component.d.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public m f65726a;

        /* renamed from: b  reason: collision with root package name */
        public AdSlot f65727b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ h f65728c;

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
            this.f65728c = hVar;
            this.f65726a = mVar;
            this.f65727b = adSlot;
        }

        @Override // java.lang.Runnable
        public void run() {
            m mVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (mVar = this.f65726a) == null) {
                return;
            }
            if (Build.VERSION.SDK_INT < 23) {
                f.a(this.f65728c.f65698b).a(this.f65726a, new f.a<Object>(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.h.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f65730a;

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
                        this.f65730a = this;
                    }

                    @Override // com.bytedance.sdk.openadsdk.component.reward.f.a
                    public void a(boolean z, Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZL(1048576, this, z, obj) == null) {
                            if (z) {
                                com.bytedance.sdk.component.utils.k.c("RewardVideoLoadManager", "RewardVideoLog: onVideoPreloadSuccess with net change !!");
                                f a2 = f.a(this.f65730a.f65728c.f65698b);
                                a aVar = this.f65730a;
                                a2.a(aVar.f65727b, aVar.f65726a);
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
                bVar.a(this.f65727b);
                bVar.a(this.f65726a);
                com.bytedance.sdk.openadsdk.core.video.d.c.a(bVar, new com.bytedance.sdk.component.video.a.c.b(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.h.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f65729a;

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
                        this.f65729a = this;
                    }

                    @Override // com.bytedance.sdk.component.video.a.c.a.InterfaceC1891a
                    public void a(com.bytedance.sdk.component.video.b.a aVar, int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, aVar, i2) == null) {
                            com.bytedance.sdk.component.utils.k.c("RewardVideoLoadManager", "RewardVideoLog: onVideoPreloadSuccess with net change !!");
                            f a2 = f.a(this.f65729a.f65728c.f65698b);
                            a aVar2 = this.f65729a;
                            a2.a(aVar2.f65727b, aVar2.f65726a);
                        }
                    }

                    @Override // com.bytedance.sdk.component.video.a.c.a.InterfaceC1891a
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
        this.f65700d = new AtomicBoolean(false);
        this.f65701e = Collections.synchronizedList(new ArrayList());
        this.f65702f = new BroadcastReceiver(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.h.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ h f65725a;

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
                this.f65725a = this;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeLL(1048576, this, context2, intent) == null) && "android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) && n.c(this.f65725a.f65698b) != 0) {
                    Iterator it = this.f65725a.f65701e.iterator();
                    while (it.hasNext()) {
                        com.bytedance.sdk.component.d.e.a((com.bytedance.sdk.component.d.g) it.next(), 1);
                        it.remove();
                    }
                }
            }
        };
        this.f65699c = o.f();
        this.f65698b = context == null ? o.a() : context.getApplicationContext();
        c();
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || this.f65700d.get()) {
            return;
        }
        this.f65700d.set(true);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            this.f65698b.registerReceiver(this.f65702f, intentFilter);
        } catch (Exception unused) {
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65545, this) == null) && this.f65700d.get()) {
            this.f65700d.set(false);
            try {
                this.f65698b.unregisterReceiver(this.f65702f);
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
                f.a(this.f65698b).a();
            } catch (Throwable unused) {
            }
        }
    }

    public static h a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f65697a == null) {
                synchronized (h.class) {
                    if (f65697a == null) {
                        f65697a = new h(context);
                    }
                }
            }
            return f65697a;
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? f.a(this.f65698b).b(str) : (AdSlot) invokeL.objValue;
    }

    public void a() {
        AdSlot b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (b2 = f.a(this.f65698b).b()) == null || TextUtils.isEmpty(b2.getCodeId()) || f.a(this.f65698b).c(b2.getCodeId()) != null) {
            return;
        }
        b(b2);
    }

    public void a(AdSlot adSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adSlot) == null) {
            f.a(this.f65698b).b(adSlot);
        }
    }

    public void a(AdSlot adSlot, TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, adSlot, rewardVideoAdListener) == null) {
            com.bytedance.sdk.component.utils.k.b("RewardVideoLoadManager", "load reward vide: " + String.valueOf(adSlot));
            com.bytedance.sdk.component.utils.k.b("bidding", "load reward vide: BidAdm->MD5->" + com.bytedance.sdk.openadsdk.n.g.b.a(adSlot.getBidAdm()));
            f.a(this.f65698b).a(adSlot);
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
            m c2 = f.a(this.f65698b).c(adSlot.getCodeId());
            if (c2 != null) {
                k kVar = new k(this.f65698b, c2, adSlot);
                if (!com.bytedance.sdk.openadsdk.core.e.o.j(c2)) {
                    kVar.a(f.a(this.f65698b).a(c2));
                }
                com.bytedance.sdk.openadsdk.e.d.a(c2);
                if (rewardVideoAdListener != null) {
                    rewardVideoAdListener.onRewardVideoAdLoad(kVar);
                    if (!com.bytedance.sdk.openadsdk.core.e.o.j(c2)) {
                        com.bytedance.sdk.openadsdk.e.d.a(this.f65698b, c2, q.b(adSlot.getDurationSlotType()), currentTimeMillis);
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
                                public final /* synthetic */ TTAdNative.RewardVideoAdListener f65703a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ x f65704b;

                                /* renamed from: c  reason: collision with root package name */
                                public final /* synthetic */ h f65705c;

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
                                    this.f65705c = this;
                                    this.f65703a = rewardVideoAdListener;
                                    this.f65704b = V;
                                }

                                @Override // com.bytedance.sdk.component.video.a.c.a.InterfaceC1891a
                                public void a(com.bytedance.sdk.component.video.b.a aVar, int i2) {
                                    TTAdNative.RewardVideoAdListener rewardVideoAdListener2;
                                    Interceptable interceptable2 = $ic;
                                    if (!(interceptable2 == null || interceptable2.invokeLI(1048576, this, aVar, i2) == null) || (rewardVideoAdListener2 = this.f65703a) == null) {
                                        return;
                                    }
                                    rewardVideoAdListener2.onRewardVideoCached();
                                    com.bytedance.sdk.component.utils.k.c("RewardVideoLoadManager", "RewardVideoLog: Cached ad  onRewardVideoCached");
                                }

                                @Override // com.bytedance.sdk.component.video.a.c.a.InterfaceC1891a
                                public void a(com.bytedance.sdk.component.video.b.a aVar, int i2, String str) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, i2, str) == null) {
                                        com.bytedance.sdk.component.utils.k.c("RewardVideoLoadManager", "RewardVideoLog: Cached ad  onVideoPreloadFail");
                                        if (this.f65703a == null || !this.f65704b.s()) {
                                            return;
                                        }
                                        this.f65703a.onRewardVideoCached();
                                        com.bytedance.sdk.component.utils.k.c("RewardVideoLoadManager", "RewardVideoLog: Cached ad  onVideoPreloadFail and exec onRewardVideoCached");
                                    }
                                }
                            });
                        } else {
                            rewardVideoAdListener.onRewardVideoCached();
                        }
                    }
                }
                com.bytedance.sdk.openadsdk.core.h.a.a().a(c2, new a.InterfaceC1905a(this, rewardVideoAdListener, c2, adSlot, currentTimeMillis) { // from class: com.bytedance.sdk.openadsdk.component.reward.h.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.RewardVideoAdListener f65706a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ m f65707b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ AdSlot f65708c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ long f65709d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ h f65710e;

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
                        this.f65710e = this;
                        this.f65706a = rewardVideoAdListener;
                        this.f65707b = c2;
                        this.f65708c = adSlot;
                        this.f65709d = currentTimeMillis;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.h.a.InterfaceC1905a
                    public void a(boolean z2) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeZ(1048576, this, z2) == null) && this.f65706a != null && com.bytedance.sdk.openadsdk.core.e.o.j(this.f65707b)) {
                            com.bytedance.sdk.openadsdk.e.d.a(this.f65710e.f65698b, this.f65707b, q.b(this.f65708c.getDurationSlotType()), this.f65709d);
                            this.f65706a.onRewardVideoCached();
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
            nVar.f66310b = z ? 2 : 1;
            if (o.h().i(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f) {
                nVar.f66313e = 2;
            }
            this.f65699c.a(adSlot, nVar, 7, new p.b(this, z, rewardVideoAdListener, adSlot, j2) { // from class: com.bytedance.sdk.openadsdk.component.reward.h.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f65711a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ TTAdNative.RewardVideoAdListener f65712b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ AdSlot f65713c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ long f65714d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ h f65715e;

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
                    this.f65715e = this;
                    this.f65711a = z;
                    this.f65712b = rewardVideoAdListener;
                    this.f65713c = adSlot;
                    this.f65714d = j2;
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.b
                public void a(int i2, String str) {
                    TTAdNative.RewardVideoAdListener rewardVideoAdListener2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) || this.f65711a || (rewardVideoAdListener2 = this.f65712b) == null) {
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
                            com.bytedance.sdk.component.utils.k.b("RewardVideoLoadManager", "get material data success isPreload=" + this.f65711a);
                            m mVar = aVar.c().get(0);
                            try {
                                l Y = mVar.Y();
                                if (Y != null && !TextUtils.isEmpty(Y.a())) {
                                    com.bytedance.sdk.openadsdk.k.b bVar = new com.bytedance.sdk.openadsdk.k.b(true);
                                    bVar.a(this.f65713c.getCodeId());
                                    bVar.a(7);
                                    bVar.c(mVar.ak());
                                    bVar.d(mVar.ao());
                                    bVar.b(q.h(mVar.ao()));
                                    ImageLoaderWrapper.from(Y).to(bVar);
                                }
                            } catch (Throwable unused) {
                            }
                            k kVar = new k(this.f65715e.f65698b, mVar, this.f65713c);
                            if (!this.f65711a && (rewardVideoAdListener4 = this.f65712b) != null) {
                                rewardVideoAdListener4.onRewardVideoAdLoad(kVar);
                            }
                            com.bytedance.sdk.openadsdk.core.h.a.a().a(mVar, new a.InterfaceC1905a(this, mVar) { // from class: com.bytedance.sdk.openadsdk.component.reward.h.3.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ m f65716a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass3 f65717b;

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
                                    this.f65717b = this;
                                    this.f65716a = mVar;
                                }

                                @Override // com.bytedance.sdk.openadsdk.core.h.a.InterfaceC1905a
                                public void a(boolean z2) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeZ(1048576, this, z2) == null) {
                                        AnonymousClass3 anonymousClass3 = this.f65717b;
                                        if (anonymousClass3.f65711a || anonymousClass3.f65712b == null || !com.bytedance.sdk.openadsdk.core.e.o.j(this.f65716a)) {
                                            return;
                                        }
                                        com.bytedance.sdk.openadsdk.e.d.a(this.f65717b.f65715e.f65698b, this.f65716a, q.b(this.f65717b.f65713c.getDurationSlotType()), this.f65717b.f65714d);
                                        this.f65717b.f65712b.onRewardVideoCached();
                                    }
                                }
                            });
                            if (mVar.aK()) {
                                if (this.f65711a && !com.bytedance.sdk.openadsdk.core.e.o.j(mVar) && o.h().q(this.f65713c.getCodeId()).f66489d == 1) {
                                    if (n.d(this.f65715e.f65698b)) {
                                        return;
                                    }
                                    h hVar = this.f65715e;
                                    hVar.a(new a(hVar, mVar, this.f65713c));
                                } else if (com.bytedance.sdk.openadsdk.core.e.o.j(mVar)) {
                                    f.a(this.f65715e.f65698b).a(this.f65713c, mVar);
                                } else if (Build.VERSION.SDK_INT < 23) {
                                    f.a(this.f65715e.f65698b).a(mVar, new f.a<Object>(this, mVar, kVar) { // from class: com.bytedance.sdk.openadsdk.component.reward.h.3.3
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;

                                        /* renamed from: a  reason: collision with root package name */
                                        public final /* synthetic */ m f65722a;

                                        /* renamed from: b  reason: collision with root package name */
                                        public final /* synthetic */ k f65723b;

                                        /* renamed from: c  reason: collision with root package name */
                                        public final /* synthetic */ AnonymousClass3 f65724c;

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
                                            this.f65724c = this;
                                            this.f65722a = mVar;
                                            this.f65723b = kVar;
                                        }

                                        @Override // com.bytedance.sdk.openadsdk.component.reward.f.a
                                        public void a(boolean z2, Object obj) {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeZL(1048576, this, z2, obj) == null) {
                                                com.bytedance.sdk.component.utils.k.b("RewardVideoLoadManager", "download video file: " + z2 + ", preload: " + this.f65724c.f65711a);
                                                if (z2) {
                                                    this.f65723b.a(f.a(this.f65724c.f65715e.f65698b).a(this.f65722a));
                                                }
                                                AnonymousClass3 anonymousClass3 = this.f65724c;
                                                if (anonymousClass3.f65711a) {
                                                    if (z2) {
                                                        f.a(anonymousClass3.f65715e.f65698b).a(this.f65724c.f65713c, this.f65722a);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                com.bytedance.sdk.openadsdk.e.d.a(this.f65722a);
                                                if (z2) {
                                                    AnonymousClass3 anonymousClass32 = this.f65724c;
                                                    if (anonymousClass32.f65712b != null) {
                                                        com.bytedance.sdk.openadsdk.e.d.a(anonymousClass32.f65715e.f65698b, this.f65722a, q.b(this.f65724c.f65713c.getDurationSlotType()), this.f65724c.f65714d);
                                                        this.f65724c.f65712b.onRewardVideoCached();
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
                                        bVar2.a(this.f65713c);
                                        bVar2.a(mVar);
                                        com.bytedance.sdk.openadsdk.core.video.d.c.a(bVar2, new com.bytedance.sdk.component.video.a.c.b(this, SystemClock.elapsedRealtime(), mVar, V) { // from class: com.bytedance.sdk.openadsdk.component.reward.h.3.2
                                            public static /* synthetic */ Interceptable $ic;
                                            public transient /* synthetic */ FieldHolder $fh;

                                            /* renamed from: a  reason: collision with root package name */
                                            public final /* synthetic */ long f65718a;

                                            /* renamed from: b  reason: collision with root package name */
                                            public final /* synthetic */ m f65719b;

                                            /* renamed from: c  reason: collision with root package name */
                                            public final /* synthetic */ x f65720c;

                                            /* renamed from: d  reason: collision with root package name */
                                            public final /* synthetic */ AnonymousClass3 f65721d;

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
                                                this.f65721d = this;
                                                this.f65718a = r7;
                                                this.f65719b = mVar;
                                                this.f65720c = V;
                                            }

                                            @Override // com.bytedance.sdk.component.video.a.c.a.InterfaceC1891a
                                            public void a(com.bytedance.sdk.component.video.b.a aVar2, int i2) {
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 == null || interceptable3.invokeLI(1048576, this, aVar2, i2) == null) {
                                                    com.bytedance.sdk.component.utils.k.c("RewardVideoLoadManager", "RewardVideoLog: onVideoPreloadSuccess");
                                                    AnonymousClass3 anonymousClass3 = this.f65721d;
                                                    if (anonymousClass3.f65711a) {
                                                        f.a(anonymousClass3.f65715e.f65698b).a(this.f65721d.f65713c, this.f65719b);
                                                        com.bytedance.sdk.component.utils.k.c("RewardVideoLoadManager", "RewardVideoLog: ad json save");
                                                        return;
                                                    }
                                                    TTAdNative.RewardVideoAdListener rewardVideoAdListener5 = anonymousClass3.f65712b;
                                                    if (rewardVideoAdListener5 != null) {
                                                        rewardVideoAdListener5.onRewardVideoCached();
                                                        com.bytedance.sdk.component.utils.k.c("RewardVideoLoadManager", "RewardVideoLog: onRewardVideoCached");
                                                    }
                                                    f.a(this.f65721d.f65715e.f65698b, true, this.f65719b, i2, SystemClock.elapsedRealtime() - this.f65718a, null);
                                                }
                                            }

                                            @Override // com.bytedance.sdk.component.video.a.c.a.InterfaceC1891a
                                            public void a(com.bytedance.sdk.component.video.b.a aVar2, int i2, String str) {
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 == null || interceptable3.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar2, i2, str) == null) {
                                                    com.bytedance.sdk.component.utils.k.c("RewardVideoLoadManager", "RewardVideoLog: onVideoPreloadFail");
                                                    f.a(this.f65721d.f65715e.f65698b, false, this.f65719b, i2, SystemClock.elapsedRealtime() - this.f65718a, str);
                                                    if (this.f65721d.f65712b == null || !this.f65720c.s()) {
                                                        return;
                                                    }
                                                    this.f65721d.f65712b.onRewardVideoCached();
                                                    com.bytedance.sdk.component.utils.k.c("RewardVideoLoadManager", "RewardVideoLog:  onVideoPreloadFail and exec onRewardVideoCached");
                                                }
                                            }
                                        });
                                    }
                                }
                            } else if (this.f65711a || (rewardVideoAdListener3 = this.f65712b) == null) {
                            } else {
                                rewardVideoAdListener3.onError(-4, com.bytedance.sdk.openadsdk.core.g.a(-4));
                            }
                        } else if (this.f65711a || (rewardVideoAdListener2 = this.f65712b) == null) {
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
            f.a(this.f65698b).a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, aVar) == null) || aVar == null) {
            return;
        }
        if (this.f65701e.size() >= 1) {
            this.f65701e.remove(0);
        }
        this.f65701e.add(aVar);
    }
}
