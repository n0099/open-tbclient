package com.bytedance.sdk.openadsdk.activity.base;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.component.reward.c.a;
import com.bytedance.sdk.openadsdk.component.reward.c.d;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import java.util.HashMap;
/* loaded from: classes9.dex */
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
    public boolean a(long j2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z)})) == null) {
            k.b("TTFullScreenExpressVideoActivity", "bindVideoAd execute");
            a aVar = this.z;
            if (aVar != null && (aVar instanceof d) && !this.A) {
                this.n.a(((d) aVar).e(), this.f65782c, this.f65780a, x());
            } else {
                this.n.a(this.p.b(), this.f65782c, this.f65780a, x());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("dynamic_show_type", Integer.valueOf(this.p.h() ? 1 : 0));
            if (!TextUtils.isEmpty(this.f65785f)) {
                hashMap.put("rit_scene", this.f65785f);
            }
            this.n.a(hashMap);
            this.n.a(new c.a(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTFullScreenExpressVideoActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTFullScreenExpressVideoActivity f65850a;

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

                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
                public void a(long j3, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j3), Integer.valueOf(i2)}) == null) {
                        this.f65850a.w.removeMessages(300);
                        this.f65850a.s();
                        this.f65850a.p.b(true);
                        this.f65850a.n();
                        this.f65850a.c(false);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
                public void b(long j3, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048579, this, new Object[]{Long.valueOf(j3), Integer.valueOf(i2)}) == null) {
                        this.f65850a.w.removeMessages(300);
                        this.f65850a.r();
                        if (this.f65850a.n.a()) {
                            return;
                        }
                        this.f65850a.s();
                        this.f65850a.n.j();
                        k.f("TTFullScreenExpressVideoActivity", "onError、、、、、、、、");
                        if (this.f65850a.t()) {
                            this.f65850a.n.a(1, 2);
                        }
                        this.f65850a.p.a(true);
                        this.f65850a.c(false);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f65850a.w.removeMessages(300);
                        this.f65850a.s();
                        k.b("TTFullScreenExpressVideoActivity", "onTimeOut、、、、、、、、");
                        this.f65850a.c(false);
                        this.f65850a.n.a(0, 1);
                        this.f65850a.n.j();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
                public void a(long j3, long j4) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j3), Long.valueOf(j4)}) == null) || this.f65850a.q.get()) {
                        return;
                    }
                    this.f65850a.w.removeMessages(300);
                    if (j3 != this.f65850a.n.C()) {
                        this.f65850a.s();
                    }
                    if (this.f65850a.n.a()) {
                        this.f65850a.n.b(j3);
                        TTFullScreenExpressVideoActivity tTFullScreenExpressVideoActivity = this.f65850a;
                        long j5 = j3 / 1000;
                        tTFullScreenExpressVideoActivity.v = (int) (tTFullScreenExpressVideoActivity.n.B() - j5);
                        int i2 = (int) j5;
                        if ((this.f65850a.s.get() || this.f65850a.u()) && this.f65850a.n.a()) {
                            this.f65850a.n.l();
                        }
                        if (this.f65850a.p.h()) {
                            this.f65850a.e(i2);
                            TTFullScreenExpressVideoActivity tTFullScreenExpressVideoActivity2 = this.f65850a;
                            if (tTFullScreenExpressVideoActivity2.v >= 0) {
                                tTFullScreenExpressVideoActivity2.k.d(true);
                                TTFullScreenExpressVideoActivity tTFullScreenExpressVideoActivity3 = this.f65850a;
                                tTFullScreenExpressVideoActivity3.k.a(String.valueOf(tTFullScreenExpressVideoActivity3.v), null);
                            }
                        }
                        TTFullScreenExpressVideoActivity tTFullScreenExpressVideoActivity4 = this.f65850a;
                        if (tTFullScreenExpressVideoActivity4.v <= 0) {
                            tTFullScreenExpressVideoActivity4.c(false);
                        }
                    }
                }
            });
            return a(j2, z, hashMap);
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
