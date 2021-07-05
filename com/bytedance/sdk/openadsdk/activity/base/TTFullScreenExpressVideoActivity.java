package com.bytedance.sdk.openadsdk.activity.base;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.j;
import com.bytedance.sdk.openadsdk.component.reward.c.a;
import com.bytedance.sdk.openadsdk.component.reward.c.d;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class TTFullScreenExpressVideoActivity extends TTFullScreenVideoActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public TTFullScreenExpressVideoActivity() {
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

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTFullScreenVideoActivity, com.bytedance.sdk.openadsdk.core.video.b.b
    public boolean a(long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            j.b("TTFullScreenExpressVideoActivity", "bindVideoAd execute");
            a aVar = this.z;
            if (aVar != null && (aVar instanceof d) && !this.A) {
                this.n.a(((d) aVar).e(), this.f28974c, this.f28972a, x());
            } else {
                this.n.a(this.p.b(), this.f28974c, this.f28972a, x());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("dynamic_show_type", Integer.valueOf(this.p.h() ? 1 : 0));
            if (!TextUtils.isEmpty(this.f28977f)) {
                hashMap.put("rit_scene", this.f28977f);
            }
            this.n.a(hashMap);
            this.n.a(new c.a(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTFullScreenExpressVideoActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTFullScreenExpressVideoActivity f29040a;

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
                    this.f29040a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
                public void a(long j2, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
                        this.f29040a.w.removeMessages(300);
                        this.f29040a.s();
                        this.f29040a.p.b(true);
                        this.f29040a.n();
                        this.f29040a.c(false);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
                public void b(long j2, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
                        this.f29040a.w.removeMessages(300);
                        this.f29040a.r();
                        if (this.f29040a.n.a()) {
                            return;
                        }
                        this.f29040a.s();
                        this.f29040a.n.j();
                        j.f("TTFullScreenExpressVideoActivity", "onError、、、、、、、、");
                        if (this.f29040a.t()) {
                            this.f29040a.n.a(1);
                        }
                        this.f29040a.p.a(true);
                        this.f29040a.c(false);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f29040a.w.removeMessages(300);
                        this.f29040a.s();
                        j.b("TTFullScreenExpressVideoActivity", "onTimeOut、、、、、、、、");
                        this.f29040a.c(false);
                        this.f29040a.n.a(0);
                        this.f29040a.n.j();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
                public void a(long j2, long j3) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) || this.f29040a.q.get()) {
                        return;
                    }
                    this.f29040a.w.removeMessages(300);
                    if (j2 != this.f29040a.n.A()) {
                        this.f29040a.s();
                    }
                    if (this.f29040a.n.a()) {
                        this.f29040a.n.b(j2);
                        TTFullScreenExpressVideoActivity tTFullScreenExpressVideoActivity = this.f29040a;
                        long j4 = j2 / 1000;
                        tTFullScreenExpressVideoActivity.v = (int) (tTFullScreenExpressVideoActivity.n.z() - j4);
                        int i2 = (int) j4;
                        if ((this.f29040a.s.get() || this.f29040a.u()) && this.f29040a.n.a()) {
                            this.f29040a.n.l();
                        }
                        if (this.f29040a.p.h()) {
                            this.f29040a.e(i2);
                            TTFullScreenExpressVideoActivity tTFullScreenExpressVideoActivity2 = this.f29040a;
                            if (tTFullScreenExpressVideoActivity2.v >= 0) {
                                tTFullScreenExpressVideoActivity2.k.d(true);
                                TTFullScreenExpressVideoActivity tTFullScreenExpressVideoActivity3 = this.f29040a;
                                tTFullScreenExpressVideoActivity3.k.a(String.valueOf(tTFullScreenExpressVideoActivity3.v), null);
                            }
                        }
                        TTFullScreenExpressVideoActivity tTFullScreenExpressVideoActivity4 = this.f29040a;
                        if (tTFullScreenExpressVideoActivity4.v <= 0) {
                            tTFullScreenExpressVideoActivity4.c(false);
                        }
                    }
                }
            });
            return a(j, z, hashMap);
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTFullScreenVideoActivity, com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity
    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }
}
