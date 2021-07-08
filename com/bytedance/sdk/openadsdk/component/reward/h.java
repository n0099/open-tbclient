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
import com.bytedance.sdk.openadsdk.component.reward.f;
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
public class h {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    public static volatile h f29513a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Context f29514b;

    /* renamed from: c  reason: collision with root package name */
    public final p f29515c;

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f29516d;

    /* renamed from: e  reason: collision with root package name */
    public List<a> f29517e;

    /* renamed from: f  reason: collision with root package name */
    public final BroadcastReceiver f29518f;

    /* loaded from: classes5.dex */
    public class a extends com.bytedance.sdk.component.e.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public m f29542a;

        /* renamed from: b  reason: collision with root package name */
        public AdSlot f29543b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ h f29544c;

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
            this.f29544c = hVar;
            this.f29542a = mVar;
            this.f29543b = adSlot;
        }

        @Override // java.lang.Runnable
        public void run() {
            m mVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (mVar = this.f29542a) == null) {
                return;
            }
            if (Build.VERSION.SDK_INT < 23) {
                f.a(this.f29544c.f29514b).a(this.f29542a, new f.a<Object>(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.h.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f29546a;

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
                        this.f29546a = this;
                    }

                    @Override // com.bytedance.sdk.openadsdk.component.reward.f.a
                    public void a(boolean z, Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZL(1048576, this, z, obj) == null) {
                            if (z) {
                                com.bytedance.sdk.component.utils.j.c("RewardVideoLoadManager", "RewardVideoLog: onVideoPreloadSuccess with net change !!");
                                f a2 = f.a(this.f29546a.f29544c.f29514b);
                                a aVar = this.f29546a;
                                a2.a(aVar.f29543b, aVar.f29542a);
                                return;
                            }
                            com.bytedance.sdk.component.utils.j.c("RewardVideoLoadManager", "RewardVideoLog: onVideoPreloadFail with net change !!");
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
                com.bytedance.sdk.openadsdk.core.video.d.c.a(bVar, new com.bytedance.sdk.component.video.a.c.b(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.h.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f29545a;

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
                        this.f29545a = this;
                    }

                    @Override // com.bytedance.sdk.component.video.a.c.a.InterfaceC0325a
                    public void a(com.bytedance.sdk.component.video.b.a aVar, int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLI(1048576, this, aVar, i2) == null) {
                            com.bytedance.sdk.component.utils.j.c("RewardVideoLoadManager", "RewardVideoLog: onVideoPreloadSuccess with net change !!");
                            f a2 = f.a(this.f29545a.f29544c.f29514b);
                            a aVar2 = this.f29545a;
                            a2.a(aVar2.f29543b, aVar2.f29542a);
                        }
                    }

                    @Override // com.bytedance.sdk.component.video.a.c.a.InterfaceC0325a
                    public void a(com.bytedance.sdk.component.video.b.a aVar, int i2, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, i2, str) == null) {
                            com.bytedance.sdk.component.utils.j.c("RewardVideoLoadManager", "RewardVideoLog: onVideoPreloadFail with net change !!");
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
        this.f29516d = new AtomicBoolean(false);
        this.f29517e = Collections.synchronizedList(new ArrayList());
        this.f29518f = new BroadcastReceiver(this) { // from class: com.bytedance.sdk.openadsdk.component.reward.h.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ h f29541a;

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
                this.f29541a = this;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeLL(1048576, this, context2, intent) == null) && "android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) && com.bytedance.sdk.component.utils.m.c(this.f29541a.f29514b) != 0) {
                    Iterator it = this.f29541a.f29517e.iterator();
                    while (it.hasNext()) {
                        com.bytedance.sdk.component.e.e.a((com.bytedance.sdk.component.e.g) it.next(), 1);
                        it.remove();
                    }
                }
            }
        };
        this.f29515c = o.f();
        this.f29514b = context == null ? o.a() : context.getApplicationContext();
        c();
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || this.f29516d.get()) {
            return;
        }
        this.f29516d.set(true);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            this.f29514b.registerReceiver(this.f29518f, intentFilter);
        } catch (Exception unused) {
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65545, this) == null) && this.f29516d.get()) {
            this.f29516d.set(false);
            try {
                this.f29514b.unregisterReceiver(this.f29518f);
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
                f.a(this.f29514b).a();
            } catch (Throwable unused) {
            }
        }
    }

    public static h a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f29513a == null) {
                synchronized (h.class) {
                    if (f29513a == null) {
                        f29513a = new h(context);
                    }
                }
            }
            return f29513a;
        }
        return (h) invokeL.objValue;
    }

    public void b(AdSlot adSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, adSlot) == null) {
            if (adSlot != null && !TextUtils.isEmpty(adSlot.getBidAdm())) {
                com.bytedance.sdk.component.utils.j.b("bidding", "preload bidding 逻辑不走预加载逻辑：BidAdm->MD5->" + com.bytedance.sdk.openadsdk.o.g.b.a(adSlot.getBidAdm()));
                return;
            }
            com.bytedance.sdk.component.utils.j.b("RewardVideoLoadManager", "preload reward video: " + String.valueOf(adSlot));
            a(adSlot, true, null);
        }
    }

    @Nullable
    public AdSlot b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? f.a(this.f29514b).b(str) : (AdSlot) invokeL.objValue;
    }

    public void a() {
        AdSlot b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (b2 = f.a(this.f29514b).b()) == null || TextUtils.isEmpty(b2.getCodeId()) || f.a(this.f29514b).c(b2.getCodeId()) != null) {
            return;
        }
        b(b2);
    }

    public void a(AdSlot adSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adSlot) == null) {
            f.a(this.f29514b).b(adSlot);
        }
    }

    public void a(AdSlot adSlot, TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, adSlot, rewardVideoAdListener) == null) {
            com.bytedance.sdk.component.utils.j.b("RewardVideoLoadManager", "load reward vide: " + String.valueOf(adSlot));
            com.bytedance.sdk.component.utils.j.b("bidding", "load reward vide: BidAdm->MD5->" + com.bytedance.sdk.openadsdk.o.g.b.a(adSlot.getBidAdm()));
            f.a(this.f29514b).a(adSlot);
            a(adSlot, false, rewardVideoAdListener);
        }
    }

    private void a(AdSlot adSlot, boolean z, TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{adSlot, Boolean.valueOf(z), rewardVideoAdListener}) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (z) {
                if (adSlot.getExtraSmartLookParam() != null) {
                    com.bytedance.sdk.component.utils.j.b("TTMediationSDK", "smartLook参数不为null时 激励视频不需要缓存");
                    return;
                } else {
                    a(adSlot, true, rewardVideoAdListener, currentTimeMillis);
                    return;
                }
            }
            m c2 = f.a(this.f29514b).c(adSlot.getCodeId());
            if (c2 != null && adSlot.getExtraSmartLookParam() == null) {
                k kVar = new k(this.f29514b, c2, adSlot);
                if (!com.bytedance.sdk.openadsdk.core.e.o.j(c2)) {
                    kVar.a(f.a(this.f29514b).a(c2));
                }
                com.bytedance.sdk.openadsdk.e.d.a(c2);
                if (rewardVideoAdListener != null) {
                    rewardVideoAdListener.onRewardVideoAdLoad(kVar);
                    if (!com.bytedance.sdk.openadsdk.core.e.o.j(c2)) {
                        com.bytedance.sdk.openadsdk.e.d.a(this.f29514b, c2, com.bytedance.sdk.openadsdk.r.o.b(adSlot.getDurationSlotType()), currentTimeMillis);
                        if (Build.VERSION.SDK_INT >= 23) {
                            x V = c2.V();
                            com.bytedance.sdk.openadsdk.o.f.b bVar = new com.bytedance.sdk.openadsdk.o.f.b();
                            bVar.b(V.l());
                            bVar.a(V.i());
                            bVar.a(V.m());
                            bVar.b(V.d());
                            bVar.b(V.t());
                            bVar.c(CacheDirConstants.getRewardFullCacheDir());
                            com.bytedance.sdk.openadsdk.core.video.d.c.a(bVar, new com.bytedance.sdk.component.video.a.c.b(this, rewardVideoAdListener, V) { // from class: com.bytedance.sdk.openadsdk.component.reward.h.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ TTAdNative.RewardVideoAdListener f29519a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ x f29520b;

                                /* renamed from: c  reason: collision with root package name */
                                public final /* synthetic */ h f29521c;

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
                                    this.f29521c = this;
                                    this.f29519a = rewardVideoAdListener;
                                    this.f29520b = V;
                                }

                                @Override // com.bytedance.sdk.component.video.a.c.a.InterfaceC0325a
                                public void a(com.bytedance.sdk.component.video.b.a aVar, int i2) {
                                    TTAdNative.RewardVideoAdListener rewardVideoAdListener2;
                                    Interceptable interceptable2 = $ic;
                                    if (!(interceptable2 == null || interceptable2.invokeLI(1048576, this, aVar, i2) == null) || (rewardVideoAdListener2 = this.f29519a) == null) {
                                        return;
                                    }
                                    rewardVideoAdListener2.onRewardVideoCached();
                                    com.bytedance.sdk.component.utils.j.c("RewardVideoLoadManager", "RewardVideoLog: Cached ad  onRewardVideoCached");
                                }

                                @Override // com.bytedance.sdk.component.video.a.c.a.InterfaceC0325a
                                public void a(com.bytedance.sdk.component.video.b.a aVar, int i2, String str) {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, i2, str) == null) {
                                        com.bytedance.sdk.component.utils.j.c("RewardVideoLoadManager", "RewardVideoLog: Cached ad  onVideoPreloadFail");
                                        if (this.f29519a == null || !this.f29520b.s()) {
                                            return;
                                        }
                                        this.f29519a.onRewardVideoCached();
                                        com.bytedance.sdk.component.utils.j.c("RewardVideoLoadManager", "RewardVideoLog: Cached ad  onVideoPreloadFail and exec onRewardVideoCached");
                                    }
                                }
                            });
                        } else {
                            rewardVideoAdListener.onRewardVideoCached();
                        }
                    }
                }
                com.bytedance.sdk.openadsdk.core.h.a.a().a(c2, new a.InterfaceC0339a(this, rewardVideoAdListener, c2, adSlot, currentTimeMillis) { // from class: com.bytedance.sdk.openadsdk.component.reward.h.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ TTAdNative.RewardVideoAdListener f29522a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ m f29523b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ AdSlot f29524c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ long f29525d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ h f29526e;

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
                        this.f29526e = this;
                        this.f29522a = rewardVideoAdListener;
                        this.f29523b = c2;
                        this.f29524c = adSlot;
                        this.f29525d = currentTimeMillis;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.h.a.InterfaceC0339a
                    public void a(boolean z2) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeZ(1048576, this, z2) == null) && this.f29522a != null && com.bytedance.sdk.openadsdk.core.e.o.j(this.f29523b)) {
                            com.bytedance.sdk.openadsdk.e.d.a(this.f29526e.f29514b, this.f29523b, com.bytedance.sdk.openadsdk.r.o.b(this.f29524c.getDurationSlotType()), this.f29525d);
                            this.f29522a.onRewardVideoCached();
                        }
                    }
                });
                com.bytedance.sdk.component.utils.j.b("RewardVideoLoadManager", "get cache data success");
                return;
            }
            com.bytedance.sdk.component.utils.j.b("TTMediationSDK", "激励视频从网络获取 smartLook参数不为null时.....");
            a(adSlot, false, rewardVideoAdListener, currentTimeMillis);
        }
    }

    private void a(AdSlot adSlot, boolean z, TTAdNative.RewardVideoAdListener rewardVideoAdListener, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{adSlot, Boolean.valueOf(z), rewardVideoAdListener, Long.valueOf(j)}) == null) {
            com.bytedance.sdk.component.utils.j.b("bidding", "reward video doNetwork 获取新物料:BidAdm->MD5->" + com.bytedance.sdk.openadsdk.o.g.b.a(adSlot.getBidAdm()));
            n nVar = new n();
            nVar.f30101b = z ? 2 : 1;
            if (o.h().i(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f) {
                nVar.f30104e = 2;
            }
            this.f29515c.a(adSlot, nVar, 7, new p.b(this, z, rewardVideoAdListener, adSlot, j) { // from class: com.bytedance.sdk.openadsdk.component.reward.h.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f29527a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ TTAdNative.RewardVideoAdListener f29528b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ AdSlot f29529c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ long f29530d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ h f29531e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z), rewardVideoAdListener, adSlot, Long.valueOf(j)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f29531e = this;
                    this.f29527a = z;
                    this.f29528b = rewardVideoAdListener;
                    this.f29529c = adSlot;
                    this.f29530d = j;
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.b
                public void a(int i2, String str) {
                    TTAdNative.RewardVideoAdListener rewardVideoAdListener2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) || this.f29527a || (rewardVideoAdListener2 = this.f29528b) == null) {
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
                            com.bytedance.sdk.component.utils.j.b("RewardVideoLoadManager", "get material data success isPreload=" + this.f29527a);
                            m mVar = aVar.c().get(0);
                            try {
                                l Y = mVar.Y();
                                if (Y != null && !TextUtils.isEmpty(Y.a())) {
                                    com.bytedance.sdk.openadsdk.l.c cVar = new com.bytedance.sdk.openadsdk.l.c(true);
                                    cVar.a(this.f29529c.getCodeId());
                                    cVar.a(7);
                                    cVar.c(mVar.ak());
                                    cVar.d(mVar.ao());
                                    cVar.b(com.bytedance.sdk.openadsdk.r.o.h(mVar.ao()));
                                    com.bytedance.sdk.openadsdk.g.a.a(Y).a(cVar);
                                }
                            } catch (Throwable unused) {
                            }
                            k kVar = new k(this.f29531e.f29514b, mVar, this.f29529c);
                            if (!this.f29527a && (rewardVideoAdListener4 = this.f29528b) != null) {
                                rewardVideoAdListener4.onRewardVideoAdLoad(kVar);
                            }
                            com.bytedance.sdk.openadsdk.core.h.a.a().a(mVar, new a.InterfaceC0339a(this, mVar) { // from class: com.bytedance.sdk.openadsdk.component.reward.h.3.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ m f29532a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass3 f29533b;

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
                                    this.f29533b = this;
                                    this.f29532a = mVar;
                                }

                                @Override // com.bytedance.sdk.openadsdk.core.h.a.InterfaceC0339a
                                public void a(boolean z2) {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeZ(1048576, this, z2) == null) {
                                        AnonymousClass3 anonymousClass3 = this.f29533b;
                                        if (anonymousClass3.f29527a || anonymousClass3.f29528b == null || !com.bytedance.sdk.openadsdk.core.e.o.j(this.f29532a)) {
                                            return;
                                        }
                                        com.bytedance.sdk.openadsdk.e.d.a(this.f29533b.f29531e.f29514b, this.f29532a, com.bytedance.sdk.openadsdk.r.o.b(this.f29533b.f29529c.getDurationSlotType()), this.f29533b.f29530d);
                                        this.f29533b.f29528b.onRewardVideoCached();
                                    }
                                }
                            });
                            if (mVar.aK()) {
                                if (this.f29527a && !com.bytedance.sdk.openadsdk.core.e.o.j(mVar) && o.h().q(this.f29529c.getCodeId()).f30274d == 1) {
                                    if (com.bytedance.sdk.component.utils.m.d(this.f29531e.f29514b)) {
                                        return;
                                    }
                                    h hVar = this.f29531e;
                                    hVar.a(new a(hVar, mVar, this.f29529c));
                                } else if (com.bytedance.sdk.openadsdk.core.e.o.j(mVar)) {
                                    f.a(this.f29531e.f29514b).a(this.f29529c, mVar);
                                } else if (Build.VERSION.SDK_INT < 23) {
                                    f.a(this.f29531e.f29514b).a(mVar, new f.a<Object>(this, mVar, kVar) { // from class: com.bytedance.sdk.openadsdk.component.reward.h.3.3
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;

                                        /* renamed from: a  reason: collision with root package name */
                                        public final /* synthetic */ m f29538a;

                                        /* renamed from: b  reason: collision with root package name */
                                        public final /* synthetic */ k f29539b;

                                        /* renamed from: c  reason: collision with root package name */
                                        public final /* synthetic */ AnonymousClass3 f29540c;

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
                                            this.f29540c = this;
                                            this.f29538a = mVar;
                                            this.f29539b = kVar;
                                        }

                                        @Override // com.bytedance.sdk.openadsdk.component.reward.f.a
                                        public void a(boolean z2, Object obj) {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeZL(1048576, this, z2, obj) == null) {
                                                com.bytedance.sdk.component.utils.j.b("RewardVideoLoadManager", "download video file: " + z2 + ", preload: " + this.f29540c.f29527a);
                                                if (z2) {
                                                    this.f29539b.a(f.a(this.f29540c.f29531e.f29514b).a(this.f29538a));
                                                }
                                                AnonymousClass3 anonymousClass3 = this.f29540c;
                                                if (anonymousClass3.f29527a) {
                                                    if (z2) {
                                                        f.a(anonymousClass3.f29531e.f29514b).a(this.f29540c.f29529c, this.f29538a);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                com.bytedance.sdk.openadsdk.e.d.a(this.f29538a);
                                                if (z2) {
                                                    AnonymousClass3 anonymousClass32 = this.f29540c;
                                                    if (anonymousClass32.f29528b != null) {
                                                        com.bytedance.sdk.openadsdk.e.d.a(anonymousClass32.f29531e.f29514b, this.f29538a, com.bytedance.sdk.openadsdk.r.o.b(this.f29540c.f29529c.getDurationSlotType()), this.f29540c.f29530d);
                                                        this.f29540c.f29528b.onRewardVideoCached();
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
                                        com.bytedance.sdk.openadsdk.core.video.d.c.a(bVar, new com.bytedance.sdk.component.video.a.c.b(this, SystemClock.elapsedRealtime(), mVar, V) { // from class: com.bytedance.sdk.openadsdk.component.reward.h.3.2
                                            public static /* synthetic */ Interceptable $ic;
                                            public transient /* synthetic */ FieldHolder $fh;

                                            /* renamed from: a  reason: collision with root package name */
                                            public final /* synthetic */ long f29534a;

                                            /* renamed from: b  reason: collision with root package name */
                                            public final /* synthetic */ m f29535b;

                                            /* renamed from: c  reason: collision with root package name */
                                            public final /* synthetic */ x f29536c;

                                            /* renamed from: d  reason: collision with root package name */
                                            public final /* synthetic */ AnonymousClass3 f29537d;

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
                                                this.f29537d = this;
                                                this.f29534a = r7;
                                                this.f29535b = mVar;
                                                this.f29536c = V;
                                            }

                                            @Override // com.bytedance.sdk.component.video.a.c.a.InterfaceC0325a
                                            public void a(com.bytedance.sdk.component.video.b.a aVar2, int i2) {
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 == null || interceptable3.invokeLI(1048576, this, aVar2, i2) == null) {
                                                    com.bytedance.sdk.component.utils.j.c("RewardVideoLoadManager", "RewardVideoLog: onVideoPreloadSuccess");
                                                    AnonymousClass3 anonymousClass3 = this.f29537d;
                                                    if (anonymousClass3.f29527a) {
                                                        f.a(anonymousClass3.f29531e.f29514b).a(this.f29537d.f29529c, this.f29535b);
                                                        com.bytedance.sdk.component.utils.j.c("RewardVideoLoadManager", "RewardVideoLog: ad json save");
                                                        return;
                                                    }
                                                    TTAdNative.RewardVideoAdListener rewardVideoAdListener5 = anonymousClass3.f29528b;
                                                    if (rewardVideoAdListener5 != null) {
                                                        rewardVideoAdListener5.onRewardVideoCached();
                                                        com.bytedance.sdk.component.utils.j.c("RewardVideoLoadManager", "RewardVideoLog: onRewardVideoCached");
                                                    }
                                                    f.a(this.f29537d.f29531e.f29514b, true, this.f29535b, i2, SystemClock.elapsedRealtime() - this.f29534a, null);
                                                }
                                            }

                                            @Override // com.bytedance.sdk.component.video.a.c.a.InterfaceC0325a
                                            public void a(com.bytedance.sdk.component.video.b.a aVar2, int i2, String str) {
                                                Interceptable interceptable3 = $ic;
                                                if (interceptable3 == null || interceptable3.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar2, i2, str) == null) {
                                                    com.bytedance.sdk.component.utils.j.c("RewardVideoLoadManager", "RewardVideoLog: onVideoPreloadFail");
                                                    f.a(this.f29537d.f29531e.f29514b, false, this.f29535b, i2, SystemClock.elapsedRealtime() - this.f29534a, str);
                                                    if (this.f29537d.f29528b == null || !this.f29536c.s()) {
                                                        return;
                                                    }
                                                    this.f29537d.f29528b.onRewardVideoCached();
                                                    com.bytedance.sdk.component.utils.j.c("RewardVideoLoadManager", "RewardVideoLog:  onVideoPreloadFail and exec onRewardVideoCached");
                                                }
                                            }
                                        });
                                    }
                                }
                            } else if (this.f29527a || (rewardVideoAdListener3 = this.f29528b) == null) {
                            } else {
                                rewardVideoAdListener3.onError(-4, com.bytedance.sdk.openadsdk.core.g.a(-4));
                            }
                        } else if (this.f29527a || (rewardVideoAdListener2 = this.f29528b) == null) {
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
            f.a(this.f29514b).a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, aVar) == null) || aVar == null) {
            return;
        }
        if (this.f29517e.size() >= 1) {
            this.f29517e.remove(0);
        }
        this.f29517e.add(aVar);
    }
}
