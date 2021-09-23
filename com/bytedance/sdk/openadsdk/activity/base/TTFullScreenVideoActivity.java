package com.bytedance.sdk.openadsdk.activity.base;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.d.e;
import com.bytedance.sdk.component.d.g;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.component.reward.c.a;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.downloadnew.a.d;
import com.bytedance.sdk.openadsdk.multipro.b;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class TTFullScreenVideoActivity extends TTBaseVideoActivity {
    public static /* synthetic */ Interceptable $ic;
    public static TTFullScreenVideoAd.FullScreenVideoAdInteractionListener E;
    public static boolean F;
    public transient /* synthetic */ FieldHolder $fh;
    public TTFullScreenVideoAd.FullScreenVideoAdInteractionListener D;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1946704449, "Lcom/bytedance/sdk/openadsdk/activity/base/TTFullScreenVideoActivity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1946704449, "Lcom/bytedance/sdk/openadsdk/activity/base/TTFullScreenVideoActivity;");
        }
    }

    public TTFullScreenVideoActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, str) == null) {
            e.c(new g(this, "executeMultiProcessCallback", str) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTFullScreenVideoActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f65818a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ TTFullScreenVideoActivity f65819b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, str};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((String) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f65819b = this;
                    this.f65818a = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            this.f65819b.c(1).executeFullVideoCallback(this.f65819b.f65749e, this.f65818a);
                        } catch (Throwable th) {
                            k.c("TTFullScreenVideoActivity", "executeFullVideoCallback execute throw Exception : ", th);
                        }
                    }
                }
            }, 5);
        }
    }

    private void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65544, this, i2) == null) {
            this.k.a(null, new SpannableStringBuilder(i2 + "s后可跳过"));
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
            m mVar = this.f65747c;
            if (mVar != null && mVar.aJ() != 100.0f) {
                F = true;
            }
            b("onAdVideoBarClick");
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.y) {
            return;
        }
        this.y = true;
        b("onAdClose");
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.w.post(new Runnable(this, str) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTFullScreenVideoActivity.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f65820a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ TTFullScreenVideoActivity f65821b;

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
                    this.f65821b = this;
                    this.f65820a = str;
                }

                /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                @Override // java.lang.Runnable
                public void run() {
                    char c2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        String str2 = this.f65820a;
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
                                    c2 = 5;
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
                            default:
                                c2 = 65535;
                                break;
                        }
                        if (c2 == 0) {
                            if (!b.b()) {
                                if (this.f65821b.D != null) {
                                    this.f65821b.D.onAdVideoBarClick();
                                    return;
                                }
                                return;
                            }
                            this.f65821b.c("onAdVideoBarClick");
                        } else if (c2 == 1) {
                            if (!b.b()) {
                                if (this.f65821b.D != null) {
                                    this.f65821b.D.onAdShow();
                                    return;
                                }
                                return;
                            }
                            this.f65821b.c("onAdShow");
                        } else if (c2 == 2) {
                            if (!b.b()) {
                                if (this.f65821b.D != null) {
                                    this.f65821b.D.onSkippedVideo();
                                    return;
                                }
                                return;
                            }
                            this.f65821b.c("onSkippedVideo");
                        } else if (c2 == 3) {
                            if (!b.b()) {
                                if (this.f65821b.D != null) {
                                    this.f65821b.D.onAdClose();
                                    return;
                                }
                                return;
                            }
                            this.f65821b.c("onAdClose");
                        } else if (c2 != 4) {
                            if (c2 != 5) {
                                return;
                            }
                            if (b.b()) {
                                this.f65821b.c("recycleRes");
                            }
                            this.f65821b.D = null;
                        } else if (!b.b()) {
                            if (this.f65821b.D != null) {
                                this.f65821b.D.onVideoComplete();
                            }
                        } else {
                            this.f65821b.c("onVideoComplete");
                        }
                    }
                }
            });
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            int h2 = o.h().h(this.f65748d);
            if (h2 < 0) {
                h2 = 5;
            }
            if (!o.h().b(String.valueOf(this.f65748d))) {
                if (i2 >= h2) {
                    if (!this.r.getAndSet(true)) {
                        this.k.d(true);
                    }
                    this.k.a(null, getString(t.b(this.f65746b, "tt_reward_screen_skip_tx")));
                    this.k.f(true);
                    return;
                }
                this.k.f(false);
                return;
            }
            if (!this.r.getAndSet(true)) {
                this.k.d(true);
            }
            if (i2 <= h2) {
                f(h2 - i2);
                this.k.f(false);
                return;
            }
            this.k.a(null, getString(t.b(this.f65746b, "tt_reward_screen_skip_tx")));
            this.k.f(true);
        }
    }

    public void finalize() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.finalize();
            E = null;
        }
    }

    @Override // android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.o.g();
            C();
            super.finish();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            b("onVideoComplete");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDestroy();
            C();
            b("recycleRes");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            E = this.D;
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onStop();
            if (a(this.f65747c)) {
                if (d.l && d.k && b(this.f65747c)) {
                    d.k = false;
                    d.l = false;
                    finish();
                } else if (F && !d.l) {
                    F = false;
                    finish();
                } else if (!this.l.H() || d.l) {
                } else {
                    finish();
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity
    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity
    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.k.a(new com.bytedance.sdk.openadsdk.component.reward.top.b(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTFullScreenVideoActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTFullScreenVideoActivity f65816a;

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
                    this.f65816a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.top.b
                public void a(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (com.bytedance.sdk.openadsdk.core.e.o.j(this.f65816a.f65747c)) {
                            this.f65816a.b("onSkippedVideo");
                            this.f65816a.c();
                            return;
                        }
                        this.f65816a.d();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.top.b
                public void b(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                        this.f65816a.a();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.top.b
                public void c(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
                        this.f65816a.b();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.top.b
                public void d(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048579, this, view) == null) || this.f65816a.w()) {
                        return;
                    }
                    this.f65816a.c();
                }
            });
        }
    }

    private boolean b(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, mVar)) == null) {
            if (mVar == null) {
                return false;
            }
            return (mVar.X() == 4) && !TextUtils.isEmpty(mVar.ax());
        }
        return invokeL.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity
    public void a(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, intent) == null) {
            super.a(intent);
            if (intent == null) {
                return;
            }
            this.B = intent.getBooleanExtra("is_verity_playable", false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.base.TTBaseVideoActivity
    public boolean a(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bundle)) == null) {
            if (!b.b()) {
                this.D = com.bytedance.sdk.openadsdk.core.t.a().e();
            }
            if (bundle != null && this.D == null) {
                this.D = E;
                E = null;
            }
            return super.a(bundle);
        }
        return invokeL.booleanValue;
    }

    public boolean a(long j2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z)})) == null) {
            k.b("TTFullScreenVideoActivity", "bindVideoAd execute");
            a aVar = this.z;
            if (aVar != null && (aVar instanceof com.bytedance.sdk.openadsdk.component.reward.c.d)) {
                this.n.a(((com.bytedance.sdk.openadsdk.component.reward.c.d) aVar).e(), this.f65747c, this.f65745a, x());
            } else {
                this.n.a(this.f65753i.e(), this.f65747c, this.f65745a, x());
            }
            HashMap hashMap = null;
            if (!TextUtils.isEmpty(this.f65750f)) {
                hashMap = new HashMap();
                hashMap.put("rit_scene", this.f65750f);
            }
            this.n.a(hashMap);
            this.n.a(new c.a(this) { // from class: com.bytedance.sdk.openadsdk.activity.base.TTFullScreenVideoActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ TTFullScreenVideoActivity f65817a;

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
                    this.f65817a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
                public void a(long j3, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j3), Integer.valueOf(i2)}) == null) {
                        this.f65817a.w.removeMessages(300);
                        this.f65817a.s();
                        this.f65817a.n();
                        this.f65817a.c(false);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
                public void b(long j3, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048579, this, new Object[]{Long.valueOf(j3), Integer.valueOf(i2)}) == null) {
                        this.f65817a.w.removeMessages(300);
                        this.f65817a.r();
                        if (this.f65817a.n.a()) {
                            return;
                        }
                        this.f65817a.s();
                        this.f65817a.n.j();
                        k.f("TTFullScreenVideoActivity", "onError、、、、、、、、");
                        if (this.f65817a.t()) {
                            this.f65817a.n.a(1, 2);
                        }
                        this.f65817a.c(false);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f65817a.w.removeMessages(300);
                        this.f65817a.s();
                        k.b("TTFullScreenVideoActivity", "onTimeOut、、、、、、、、");
                        this.f65817a.c(false);
                        this.f65817a.n.a(0, 1);
                        this.f65817a.n.j();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
                public void a(long j3, long j4) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j3), Long.valueOf(j4)}) == null) || this.f65817a.q.get()) {
                        return;
                    }
                    this.f65817a.w.removeMessages(300);
                    if (j3 != this.f65817a.n.C()) {
                        this.f65817a.s();
                    }
                    if (this.f65817a.n.a()) {
                        this.f65817a.n.b(j3);
                        TTFullScreenVideoActivity tTFullScreenVideoActivity = this.f65817a;
                        long j5 = j3 / 1000;
                        tTFullScreenVideoActivity.v = (int) (tTFullScreenVideoActivity.n.B() - j5);
                        int i2 = (int) j5;
                        if ((this.f65817a.s.get() || this.f65817a.u()) && this.f65817a.n.a()) {
                            this.f65817a.n.l();
                        }
                        this.f65817a.e(i2);
                        TTFullScreenVideoActivity tTFullScreenVideoActivity2 = this.f65817a;
                        int i3 = tTFullScreenVideoActivity2.v;
                        if (i3 >= 0) {
                            tTFullScreenVideoActivity2.k.a(String.valueOf(i3), null);
                        }
                        TTFullScreenVideoActivity tTFullScreenVideoActivity3 = this.f65817a;
                        if (tTFullScreenVideoActivity3.v <= 0) {
                            tTFullScreenVideoActivity3.c(false);
                        }
                    }
                }
            });
            return a(j2, z, hashMap);
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.b.b
    public void a(View view, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            m mVar = this.f65747c;
            if (mVar != null && mVar.aJ() != 100.0f) {
                F = true;
            }
            b("onAdVideoBarClick");
        }
    }

    private boolean a(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, mVar)) == null) {
            if (mVar == null) {
                return false;
            }
            return o.h().i(this.f65748d);
        }
        return invokeL.booleanValue;
    }
}
