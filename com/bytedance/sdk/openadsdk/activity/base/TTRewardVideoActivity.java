package com.bytedance.sdk.openadsdk.activity.base;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.cons.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
import com.bytedance.sdk.component.e.e;
import com.bytedance.sdk.component.e.g;
import com.bytedance.sdk.component.utils.j;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.component.utils.r;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.t;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.widget.d;
import com.bytedance.sdk.openadsdk.n.a;
import com.bytedance.sdk.openadsdk.r.o;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class TTRewardVideoActivity extends TTBaseVideoActivity {
    public static /* synthetic */ Interceptable $ic;
    public static TTRewardVideoAd.RewardAdInteractionListener K;
    public transient /* synthetic */ FieldHolder $fh;
    public int D;
    public int E;
    public TTRewardVideoAd.RewardAdInteractionListener F;
    public String G;
    public int H;
    public String I;
    public String J;
    public AtomicBoolean L;
    public int M;

    public TTRewardVideoActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.L = new AtomicBoolean(false);
        this.M = -1;
    }

    private JSONObject E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("oversea_version_type", 0);
                jSONObject.put("reward_name", this.G);
                jSONObject.put("reward_amount", this.H);
                jSONObject.put("network", m.c(this.f29083b));
                jSONObject.put(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, "3.6.1.3");
                jSONObject.put(b.f1842b, o.b());
                jSONObject.put("extra", new JSONObject(this.f29084c.ao()));
                jSONObject.put("media_extra", this.I);
                jSONObject.put(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, this.n.z());
                jSONObject.put("play_start_ts", this.D);
                jSONObject.put("play_end_ts", this.E);
                jSONObject.put("duration", this.n.s());
                jSONObject.put("user_id", this.J);
                jSONObject.put("trans_id", UUID.randomUUID().toString().replace("-", ""));
                a.a(this.f29083b, jSONObject);
                return jSONObject;
            } catch (Throwable unused) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, str) == null) {
            a(str, false, 0, "", 0, "");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.b
    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b("onAdShow");
            if (y()) {
                this.p.i();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.b
    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b("onAdVideoBarClick");
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.L.get()) {
            return;
        }
        this.L.set(true);
        if (com.bytedance.sdk.openadsdk.core.o.h().m(String.valueOf(this.f29085d))) {
            a(true, this.H, this.G, 0, "");
            return;
        }
        com.bytedance.sdk.openadsdk.core.o.f().a(E(), new p.c(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTRewardVideoActivity.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TTRewardVideoActivity f29192a;

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
                this.f29192a = this;
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.c
            public void a(int i2, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                    this.f29192a.a(false, 0, "", i2, str);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.c
            public void a(q.c cVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
                    this.f29192a.a(cVar.f30519b, cVar.f30520c.a(), cVar.f30520c.b(), 0, "");
                }
            }
        });
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.y) {
            return;
        }
        this.y = true;
        b("onAdClose");
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.w.post(new Runnable(this, str) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTRewardVideoActivity.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f29206a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ TTRewardVideoActivity f29207b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f29207b = this;
                    this.f29206a = str;
                }

                /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                @Override // java.lang.Runnable
                public void run() {
                    char c2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        String str2 = this.f29206a;
                        switch (str2.hashCode()) {
                            case -1489027186:
                                if (str2.equals("onAdVideoBarClick")) {
                                    c2 = 0;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -9706699:
                                if (str2.equals("onVideoComplete")) {
                                    c2 = 4;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 157941942:
                                if (str2.equals("onAdClose")) {
                                    c2 = 3;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 598434061:
                                if (str2.equals("recycleRes")) {
                                    c2 = 6;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 916539050:
                                if (str2.equals("onSkippedVideo")) {
                                    c2 = 2;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 975399039:
                                if (str2.equals("onAdShow")) {
                                    c2 = 1;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case 1698677132:
                                if (str2.equals("onVideoError")) {
                                    c2 = 5;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            default:
                                c2 = 65535;
                                break;
                        }
                        switch (c2) {
                            case 0:
                                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                                    this.f29207b.c("onAdVideoBarClick");
                                    return;
                                }
                                TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.f29207b.F;
                                if (rewardAdInteractionListener != null) {
                                    rewardAdInteractionListener.onAdVideoBarClick();
                                    return;
                                }
                                return;
                            case 1:
                                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                                    this.f29207b.c("onAdShow");
                                    return;
                                }
                                TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener2 = this.f29207b.F;
                                if (rewardAdInteractionListener2 != null) {
                                    rewardAdInteractionListener2.onAdShow();
                                    return;
                                }
                                return;
                            case 2:
                                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                                    this.f29207b.c("onSkippedVideo");
                                    return;
                                }
                                TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener3 = this.f29207b.F;
                                if (rewardAdInteractionListener3 != null) {
                                    rewardAdInteractionListener3.onSkippedVideo();
                                    return;
                                }
                                return;
                            case 3:
                                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                                    this.f29207b.c("onAdClose");
                                    return;
                                }
                                TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener4 = this.f29207b.F;
                                if (rewardAdInteractionListener4 != null) {
                                    rewardAdInteractionListener4.onAdClose();
                                    return;
                                }
                                return;
                            case 4:
                                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                                    this.f29207b.c("onVideoComplete");
                                    return;
                                }
                                TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener5 = this.f29207b.F;
                                if (rewardAdInteractionListener5 != null) {
                                    rewardAdInteractionListener5.onVideoComplete();
                                    return;
                                }
                                return;
                            case 5:
                                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                                    this.f29207b.c("onVideoError");
                                    return;
                                }
                                TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener6 = this.f29207b.F;
                                if (rewardAdInteractionListener6 != null) {
                                    rewardAdInteractionListener6.onVideoError();
                                    return;
                                }
                                return;
                            case 6:
                                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                                    this.f29207b.c("recycleRes");
                                }
                                this.f29207b.F = null;
                                return;
                            default:
                                return;
                        }
                    }
                }
            });
        }
    }

    public void finalize() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.finalize();
            K = null;
        }
    }

    @Override // android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            D();
            super.finish();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            b("onVideoComplete");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.core.video.b.b
    public void o() {
        boolean b2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && x()) {
            int i2 = com.bytedance.sdk.openadsdk.core.o.h().q(String.valueOf(this.f29085d)).f30276f;
            if (com.bytedance.sdk.openadsdk.core.e.o.k(this.f29084c)) {
                b2 = (1.0d - (((double) this.v) / this.n.z())) * 100.0d >= ((double) i2);
            } else {
                b2 = this.o.b(i2);
            }
            if (b2) {
                p();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDestroy();
            D();
            b("recycleRes");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bundle) == null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            K = this.F;
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            C();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity
    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity
    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.k.a(new com.bytedance.sdk.openadsdk.component.reward.top.b(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTRewardVideoActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTRewardVideoActivity f29186a;

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
                    this.f29186a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.top.b
                public void a(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        TTRewardVideoActivity tTRewardVideoActivity = this.f29186a;
                        tTRewardVideoActivity.a(com.bytedance.sdk.openadsdk.core.e.o.j(tTRewardVideoActivity.f29084c), false);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.top.b
                public void b(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                        this.f29186a.a();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.top.b
                public void c(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
                        this.f29186a.b();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.top.b
                public void d(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048579, this, view) == null) || this.f29186a.w()) {
                        return;
                    }
                    if (com.bytedance.sdk.openadsdk.core.e.o.j(this.f29186a.f29084c)) {
                        this.f29186a.a(true, true);
                    } else {
                        this.f29186a.c();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity
    public boolean a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle)) == null) {
            if (!com.bytedance.sdk.openadsdk.multipro.b.b()) {
                this.F = t.a().d();
            }
            if (bundle != null && this.F == null) {
                this.F = K;
                K = null;
            }
            return super.a(bundle);
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (!com.bytedance.sdk.openadsdk.core.o.h().d(String.valueOf(this.f29085d)) || this.L.get()) {
                if (z) {
                    if (!z2) {
                        b("onSkippedVideo");
                    }
                    c();
                    return;
                }
                d();
                return;
            }
            this.s.set(true);
            this.n.l();
            if (z) {
                this.o.j();
                this.w.removeMessages(600);
            }
            d dVar = new d(this);
            this.x = dVar;
            if (z) {
                this.o.a(this.f29085d, dVar);
            } else {
                dVar.a("观看完整视频才能获得奖励").b("继续观看").c("放弃奖励");
            }
            this.x.a(new d.a(this, dVar, z, z2) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTRewardVideoActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f29187a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f29188b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ boolean f29189c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ TTRewardVideoActivity f29190d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, dVar, Boolean.valueOf(z), Boolean.valueOf(z2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f29190d = this;
                    this.f29187a = dVar;
                    this.f29188b = z;
                    this.f29189c = z2;
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.d.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f29187a.dismiss();
                        this.f29190d.s.set(false);
                        this.f29190d.n.k();
                        if (this.f29188b) {
                            this.f29190d.o.k();
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.d.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.f29187a.dismiss();
                        this.f29190d.s.set(false);
                        this.f29190d.o.i();
                        if (this.f29188b) {
                            this.f29190d.o.a();
                            if (!this.f29189c) {
                                this.f29190d.b("onSkippedVideo");
                            }
                            this.f29190d.finish();
                            return;
                        }
                        this.f29190d.d();
                    }
                }
            }).show();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity
    public void a(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, intent) == null) {
            super.a(intent);
            if (intent == null) {
                return;
            }
            this.G = intent.getStringExtra("reward_name");
            this.H = intent.getIntExtra("reward_amount", 0);
            this.I = intent.getStringExtra("media_extra");
            this.J = intent.getStringExtra("user_id");
        }
    }

    public void a(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            if (this.M == -1) {
                this.M = com.bytedance.sdk.openadsdk.core.o.h().q(String.valueOf(this.f29085d)).f30276f;
            }
            if (j2 <= 0) {
                return;
            }
            if (j2 >= 30000 && j >= 27000) {
                C();
            } else if (((float) (j * 100)) / ((float) j2) >= this.M) {
                C();
            }
        }
    }

    public boolean a(long j, boolean z) {
        InterceptResult invokeCommon;
        HashMap hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            j.b("TTRewardVideoActivity", "bindVideoAd execute");
            this.n.a(this.f29090i.e(), this.f29084c, this.f29082a, x());
            if (TextUtils.isEmpty(this.f29087f)) {
                hashMap = null;
            } else {
                hashMap = new HashMap();
                hashMap.put("rit_scene", this.f29087f);
            }
            this.n.a(hashMap);
            this.n.a(new c.a(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTRewardVideoActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTRewardVideoActivity f29191a;

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
                    this.f29191a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
                public void a(long j2, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
                        this.f29191a.w.removeMessages(300);
                        this.f29191a.s();
                        this.f29191a.n();
                        this.f29191a.c(false);
                        this.f29191a.E = (int) (System.currentTimeMillis() / 1000);
                        this.f29191a.C();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
                public void b(long j2, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
                        this.f29191a.w.removeMessages(300);
                        this.f29191a.b("onVideoError");
                        this.f29191a.r();
                        if (this.f29191a.n.a()) {
                            return;
                        }
                        this.f29191a.s();
                        this.f29191a.n.j();
                        this.f29191a.C();
                        if (this.f29191a.t()) {
                            this.f29191a.n.a(1);
                        }
                        this.f29191a.c(false);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f29191a.w.removeMessages(300);
                        this.f29191a.s();
                        this.f29191a.c(false);
                        this.f29191a.n.a(0);
                        this.f29191a.n.j();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
                public void a(long j2, long j3) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) || this.f29191a.q.get()) {
                        return;
                    }
                    this.f29191a.w.removeMessages(300);
                    if (j2 != this.f29191a.n.A()) {
                        this.f29191a.s();
                    }
                    if (this.f29191a.n.a()) {
                        this.f29191a.n.b(j2);
                        TTRewardVideoActivity tTRewardVideoActivity = this.f29191a;
                        long j4 = j2 / 1000;
                        tTRewardVideoActivity.v = (int) (tTRewardVideoActivity.n.z() - j4);
                        int i2 = (int) j4;
                        int g2 = com.bytedance.sdk.openadsdk.core.o.h().g(String.valueOf(this.f29191a.f29085d));
                        boolean z2 = g2 >= 0;
                        if ((this.f29191a.s.get() || this.f29191a.u()) && this.f29191a.n.a()) {
                            this.f29191a.n.l();
                        }
                        this.f29191a.f29090i.c(i2);
                        this.f29191a.a(j2, j3);
                        TTRewardVideoActivity tTRewardVideoActivity2 = this.f29191a;
                        if (tTRewardVideoActivity2.v > 0) {
                            tTRewardVideoActivity2.k.d(true);
                            if (z2 && i2 >= g2) {
                                this.f29191a.r.getAndSet(true);
                                TTRewardVideoActivity tTRewardVideoActivity3 = this.f29191a;
                                com.bytedance.sdk.openadsdk.component.reward.b.c cVar = tTRewardVideoActivity3.k;
                                String valueOf = String.valueOf(tTRewardVideoActivity3.v);
                                TTRewardVideoActivity tTRewardVideoActivity4 = this.f29191a;
                                cVar.a(valueOf, tTRewardVideoActivity4.getString(r.b(tTRewardVideoActivity4.f29083b, "tt_reward_screen_skip_tx")));
                                this.f29191a.k.f(true);
                                return;
                            }
                            TTRewardVideoActivity tTRewardVideoActivity5 = this.f29191a;
                            tTRewardVideoActivity5.k.a(String.valueOf(tTRewardVideoActivity5.v), null);
                            return;
                        }
                        tTRewardVideoActivity2.c(false);
                    }
                }
            });
            boolean a2 = a(j, z, hashMap);
            if (a2 && !z) {
                this.D = (int) (System.currentTimeMillis() / 1000);
            }
            return a2;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.b
    public void a(View view, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            b("onAdVideoBarClick");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, int i2, String str2, int i3, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{str, Boolean.valueOf(z), Integer.valueOf(i2), str2, Integer.valueOf(i3), str3}) == null) {
            e.c(new g(this, "executeMultiProcessCallback", str, z, i2, str2, i3, str3) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTRewardVideoActivity.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f29193a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f29194b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ int f29195c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f29196d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ int f29197e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ String f29198f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ TTRewardVideoActivity f29199g;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, str, Boolean.valueOf(z), Integer.valueOf(i2), str2, Integer.valueOf(i3), str3};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f29199g = this;
                    this.f29193a = str;
                    this.f29194b = z;
                    this.f29195c = i2;
                    this.f29196d = str2;
                    this.f29197e = i3;
                    this.f29198f = str3;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.f29199g.c(0).executeRewardVideoCallback(this.f29199g.f29086e, this.f29193a, this.f29194b, this.f29195c, this.f29196d, this.f29197e, this.f29198f);
                        } catch (Throwable th) {
                            j.c("TTRewardVideoActivity", "executeRewardVideoCallback execute throw Exception : ", th);
                        }
                    }
                }
            }, 5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, int i2, String str, int i3, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), str, Integer.valueOf(i3), str2}) == null) {
            this.w.post(new Runnable(this, z, i2, str, i3, str2) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTRewardVideoActivity.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f29200a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f29201b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f29202c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ int f29203d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ String f29204e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ TTRewardVideoActivity f29205f;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z), Integer.valueOf(i2), str, Integer.valueOf(i3), str2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f29205f = this;
                    this.f29200a = z;
                    this.f29201b = i2;
                    this.f29202c = str;
                    this.f29203d = i3;
                    this.f29204e = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                            this.f29205f.a("onRewardVerify", this.f29200a, this.f29201b, this.f29202c, this.f29203d, this.f29204e);
                            return;
                        }
                        TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.f29205f.F;
                        if (rewardAdInteractionListener != null) {
                            rewardAdInteractionListener.onRewardVerify(this.f29200a, this.f29201b, this.f29202c, this.f29203d, this.f29204e);
                        }
                    }
                }
            });
        }
    }
}
