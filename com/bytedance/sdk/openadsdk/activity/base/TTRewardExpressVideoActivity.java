package com.bytedance.sdk.openadsdk.activity.base;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class TTRewardExpressVideoActivity extends TTRewardVideoActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public TTRewardExpressVideoActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTRewardVideoActivity, com.bytedance.sdk.openadsdk.core.video.b.b
    public boolean a(long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            k.b("TTRewardExpressVideoActivity", "bindVideoAd execute");
            this.n.a(this.p.b(), this.f29183c, this.f29181a, x());
            HashMap hashMap = new HashMap();
            hashMap.put("dynamic_show_type", Integer.valueOf(this.p.h() ? 1 : 0));
            if (!TextUtils.isEmpty(this.f29186f)) {
                hashMap.put("rit_scene", this.f29186f);
            }
            this.n.a(hashMap);
            this.n.a(new c.a(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTRewardExpressVideoActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTRewardExpressVideoActivity f29285a;

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
                    this.f29285a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
                public void a(long j2, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
                        this.f29285a.w.removeMessages(300);
                        this.f29285a.s();
                        this.f29285a.p.b(true);
                        this.f29285a.n();
                        this.f29285a.c(false);
                        ((TTRewardVideoActivity) this.f29285a).E = (int) (System.currentTimeMillis() / 1000);
                        this.f29285a.C();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
                public void b(long j2, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
                        this.f29285a.w.removeMessages(300);
                        this.f29285a.b("onVideoError");
                        this.f29285a.r();
                        if (this.f29285a.n.a()) {
                            return;
                        }
                        this.f29285a.s();
                        this.f29285a.n.j();
                        this.f29285a.C();
                        if (this.f29285a.t()) {
                            this.f29285a.n.a(1, 2);
                        }
                        this.f29285a.p.a(true);
                        this.f29285a.c(false);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f29285a.w.removeMessages(300);
                        this.f29285a.s();
                        this.f29285a.c(false);
                        this.f29285a.n.a(0, 1);
                        this.f29285a.n.j();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
                public void a(long j2, long j3) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) || this.f29285a.q.get()) {
                        return;
                    }
                    this.f29285a.w.removeMessages(300);
                    if (j2 != this.f29285a.n.C()) {
                        this.f29285a.s();
                    }
                    if (this.f29285a.n.a()) {
                        this.f29285a.n.b(j2);
                        int g2 = o.h().g(String.valueOf(this.f29285a.f29184d));
                        boolean z2 = this.f29285a.p.h() && g2 >= 0;
                        TTRewardExpressVideoActivity tTRewardExpressVideoActivity = this.f29285a;
                        long j4 = j2 / 1000;
                        tTRewardExpressVideoActivity.v = (int) (tTRewardExpressVideoActivity.n.B() - j4);
                        int i2 = (int) j4;
                        if (this.f29285a.s.get() || this.f29285a.u()) {
                            this.f29285a.n.t();
                        }
                        this.f29285a.f29189i.c(i2);
                        this.f29285a.a(j2, j3);
                        TTRewardExpressVideoActivity tTRewardExpressVideoActivity2 = this.f29285a;
                        if (tTRewardExpressVideoActivity2.v <= 0) {
                            tTRewardExpressVideoActivity2.c(false);
                        } else if (z2 && i2 >= g2) {
                            tTRewardExpressVideoActivity2.r.getAndSet(true);
                            this.f29285a.k.d(true);
                            TTRewardExpressVideoActivity tTRewardExpressVideoActivity3 = this.f29285a;
                            com.bytedance.sdk.openadsdk.component.reward.b.c cVar = tTRewardExpressVideoActivity3.k;
                            String valueOf = String.valueOf(tTRewardExpressVideoActivity3.v);
                            TTRewardExpressVideoActivity tTRewardExpressVideoActivity4 = this.f29285a;
                            cVar.a(valueOf, tTRewardExpressVideoActivity4.getString(t.b(tTRewardExpressVideoActivity4.f29182b, "tt_reward_screen_skip_tx")));
                            this.f29285a.k.f(true);
                        } else {
                            TTRewardExpressVideoActivity tTRewardExpressVideoActivity5 = this.f29285a;
                            tTRewardExpressVideoActivity5.k.a(String.valueOf(tTRewardExpressVideoActivity5.v), null);
                        }
                    }
                }
            });
            boolean a2 = a(j, z, hashMap);
            if (a2 && !z) {
                ((TTRewardVideoActivity) this).D = (int) (System.currentTimeMillis() / 1000);
            }
            return a2;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTRewardVideoActivity, com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity
    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }
}
