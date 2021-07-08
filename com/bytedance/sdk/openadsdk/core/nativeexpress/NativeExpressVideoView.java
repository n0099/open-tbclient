package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.core.e.p;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.widget.RoundFrameLayout;
import com.bytedance.sdk.openadsdk.r.q;
/* loaded from: classes5.dex */
public class NativeExpressVideoView extends NativeExpressView implements g, c.b, c.InterfaceC0345c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ExpressVideoView f30392a;

    /* renamed from: b  reason: collision with root package name */
    public int f30393b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f30394c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f30395d;

    /* renamed from: e  reason: collision with root package name */
    public int f30396e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f30397f;
    public com.bytedance.sdk.openadsdk.multipro.b.a w;
    public long x;
    public long y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeExpressVideoView(@NonNull Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, AdSlot adSlot, String str) {
        super(context, mVar, adSlot, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mVar, adSlot, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (com.bytedance.sdk.openadsdk.core.e.m) objArr2[1], (AdSlot) objArr2[2], (String) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30393b = 1;
        this.f30394c = false;
        this.f30395d = true;
        this.f30397f = true;
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(p pVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, pVar) == null) || pVar == null) {
            return;
        }
        double e2 = pVar.e();
        double f2 = pVar.f();
        double g2 = pVar.g();
        double h2 = pVar.h();
        int b2 = (int) q.b(this.f30408h, (float) e2);
        int b3 = (int) q.b(this.f30408h, (float) f2);
        int b4 = (int) q.b(this.f30408h, (float) g2);
        int b5 = (int) q.b(this.f30408h, (float) h2);
        float b6 = q.b(this.f30408h, pVar.j());
        float b7 = q.b(this.f30408h, pVar.k());
        float b8 = q.b(this.f30408h, pVar.l());
        float b9 = q.b(this.f30408h, pVar.m());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.o.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(b4, b5);
        }
        layoutParams.width = b4;
        layoutParams.height = b5;
        layoutParams.topMargin = b3;
        layoutParams.leftMargin = b2;
        this.o.setLayoutParams(layoutParams);
        this.o.removeAllViews();
        ((RoundFrameLayout) this.o).a(b6, b7, b8, b9);
        ExpressVideoView expressVideoView = this.f30392a;
        if (expressVideoView != null) {
            this.o.addView(expressVideoView);
            this.f30392a.a(0L, true, false);
            b(this.f30396e);
            if (!com.bytedance.sdk.component.utils.m.d(this.f30408h) && !this.f30395d && this.f30397f) {
                this.f30392a.e();
            }
            setShowAdInteractionView(false);
        }
    }

    private void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            try {
                this.w = new com.bytedance.sdk.openadsdk.multipro.b.a();
                ExpressVideoView a2 = a(this.f30408h, this.m, this.k);
                this.f30392a = a2;
                a2.setShouldCheckNetChange(false);
                this.f30392a.setControllerStatusCallBack(new NativeVideoTsView.a(this) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ NativeExpressVideoView f30398a;

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
                        this.f30398a = this;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.a
                    public void a(boolean z, long j, long j2, long j3, boolean z2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z2)}) == null) {
                            this.f30398a.w.f31601a = z;
                            this.f30398a.w.f31605e = j;
                            this.f30398a.w.f31606f = j2;
                            this.f30398a.w.f31607g = j3;
                            this.f30398a.w.f31604d = z2;
                        }
                    }
                });
                this.f30392a.setVideoAdLoadListener(this);
                this.f30392a.setVideoAdInteractionListener(this);
                if ("embeded_ad".equals(this.k)) {
                    this.f30392a.setIsAutoPlay(this.f30394c ? this.l.isAutoPlay() : this.f30395d);
                } else if ("splash_ad".equals(this.k)) {
                    this.f30392a.setIsAutoPlay(true);
                } else {
                    this.f30392a.setIsAutoPlay(this.f30395d);
                }
                if ("splash_ad".equals(this.k)) {
                    this.f30392a.setIsQuiet(true);
                } else {
                    this.f30392a.setIsQuiet(com.bytedance.sdk.openadsdk.core.o.h().b(this.f30396e));
                }
                this.f30392a.d_();
            } catch (Exception e2) {
                this.f30392a = null;
                com.bytedance.sdk.component.utils.j.f("NativeExpressVideoView", "（dev ignore）ExpressVideoView-->print:" + e2.toString());
            }
        }
    }

    private void setShowAdInteractionView(boolean z) {
        ExpressVideoView expressVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65543, this, z) == null) || (expressVideoView = this.f30392a) == null) {
            return;
        }
        expressVideoView.setShowAdInteractionView(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            int d2 = com.bytedance.sdk.openadsdk.core.o.h().d(i2);
            if (3 == d2) {
                this.f30394c = false;
                this.f30395d = false;
            } else if (1 == d2) {
                this.f30394c = false;
                this.f30395d = com.bytedance.sdk.component.utils.m.d(this.f30408h);
            } else if (2 == d2) {
                if (com.bytedance.sdk.component.utils.m.e(this.f30408h) || com.bytedance.sdk.component.utils.m.d(this.f30408h) || com.bytedance.sdk.component.utils.m.f(this.f30408h)) {
                    this.f30394c = false;
                    this.f30395d = true;
                }
            } else if (5 == d2) {
                if (com.bytedance.sdk.component.utils.m.d(this.f30408h) || com.bytedance.sdk.component.utils.m.f(this.f30408h)) {
                    this.f30394c = false;
                    this.f30395d = true;
                }
            } else if (4 == d2) {
                this.f30394c = true;
            }
            if (!this.f30395d) {
                this.f30393b = 3;
            }
            com.bytedance.sdk.component.utils.j.c("NativeVideoAdView", "mIsAutoPlay=" + this.f30395d + ",status=" + d2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public int d() {
        InterceptResult invokeV;
        ExpressVideoView expressVideoView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.f30393b == 3 && (expressVideoView = this.f30392a) != null) {
                expressVideoView.d_();
            }
            ExpressVideoView expressVideoView2 = this.f30392a;
            if (expressVideoView2 == null || !expressVideoView2.getNativeVideoController().x()) {
                return this.f30393b;
            }
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public void e_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f30397f = false;
            com.bytedance.sdk.component.utils.j.b("NativeExpressVideoView", "onVideoAdStartPlay");
            TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener = this.n;
            if (expressVideoAdListener != null) {
                expressVideoAdListener.onVideoAdStartPlay();
            }
            this.f30393b = 2;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public void f_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f30397f = false;
            com.bytedance.sdk.component.utils.j.b("NativeExpressVideoView", "onVideoAdPaused");
            TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener = this.n;
            if (expressVideoAdListener != null) {
                expressVideoAdListener.onVideoAdPaused();
            }
            this.p = true;
            this.f30393b = 3;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public void g_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f30397f = false;
            com.bytedance.sdk.component.utils.j.b("NativeExpressVideoView", "onVideoAdContinuePlay");
            TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener = this.n;
            if (expressVideoAdListener != null) {
                expressVideoAdListener.onVideoAdContinuePlay();
            }
            this.p = false;
            this.f30393b = 2;
        }
    }

    public com.bytedance.sdk.openadsdk.multipro.b.a getVideoModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.w : (com.bytedance.sdk.openadsdk.multipro.b.a) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.h();
            this.j.a((g) this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public void h_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.f30397f = false;
            com.bytedance.sdk.component.utils.j.b("NativeExpressVideoView", "onVideoComplete");
            TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener = this.n;
            if (expressVideoAdListener != null) {
                expressVideoAdListener.onVideoAdComplete();
            }
            this.f30393b = 5;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.o = new RoundFrameLayout(this.f30408h);
            int d2 = com.bytedance.sdk.openadsdk.r.o.d(this.m.ao());
            this.f30396e = d2;
            b(d2);
            q();
            addView(this.o, new FrameLayout.LayoutParams(-1, -1));
            super.g();
            getWebView().setBackgroundColor(0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.InterfaceC0345c
    public void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            com.bytedance.sdk.component.utils.j.b("NativeExpressVideoView", "onVideoLoad");
            TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener = this.n;
            if (expressVideoAdListener != null) {
                expressVideoAdListener.onVideoLoad();
            }
        }
    }

    public void setCanInterruptVideoPlay(boolean z) {
        ExpressVideoView expressVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048599, this, z) == null) || (expressVideoView = this.f30392a) == null) {
            return;
        }
        expressVideoView.setCanInterruptVideoPlay(z);
    }

    public ExpressVideoView a(Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, mVar, str)) == null) ? new ExpressVideoView(context, mVar, str, false) : (ExpressVideoView) invokeLLL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.j
    public void a(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, pVar) == null) {
            if (pVar != null && pVar.b()) {
                b(pVar);
            }
            super.a(pVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            com.bytedance.sdk.component.utils.j.b("NativeExpressVideoView", "onMuteVideo,mute:" + z);
            ExpressVideoView expressVideoView = this.f30392a;
            if (expressVideoView == null || expressVideoView.getNativeVideoController() == null) {
                return;
            }
            this.f30392a.getNativeVideoController().c(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            com.bytedance.sdk.component.utils.j.b("NativeExpressVideoView", "onSkipVideo");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            com.bytedance.sdk.component.utils.j.b("NativeExpressVideoView", "onChangeVideoState,stateType:" + i2);
            ExpressVideoView expressVideoView = this.f30392a;
            if (expressVideoView == null) {
                com.bytedance.sdk.component.utils.j.f("NativeExpressVideoView", "onChangeVideoState,ExpressVideoView is null !!!!!!!!!!!!");
            } else if (i2 == 1) {
                expressVideoView.a(0L, true, false);
            } else if (i2 == 2 || i2 == 3) {
                this.f30392a.setVideoPlayStatus(i2);
                this.f30392a.setCanInterruptVideoPlay(true);
                this.f30392a.performClick();
            } else if (i2 == 4) {
                expressVideoView.getNativeVideoController().m();
            } else if (i2 != 5) {
            } else {
                expressVideoView.a(0L, true, false);
            }
        }
    }

    private void b(p pVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, pVar) == null) || pVar == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            c(pVar);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable(this, pVar) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ p f30399a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ NativeExpressVideoView f30400b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, pVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f30400b = this;
                    this.f30399a = pVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f30400b.c(this.f30399a);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.j
    public void a(int i2, com.bytedance.sdk.openadsdk.core.e.k kVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048580, this, i2, kVar) == null) || i2 == -1 || kVar == null) {
            return;
        }
        if (i2 == 4 && this.k == "draw_ad") {
            ExpressVideoView expressVideoView = this.f30392a;
            if (expressVideoView != null) {
                expressVideoView.performClick();
                return;
            }
            return;
        }
        super.a(i2, kVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.j
    public void a(int i2, com.bytedance.sdk.openadsdk.core.e.k kVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), kVar, Boolean.valueOf(z)}) == null) || i2 == -1 || kVar == null) {
            return;
        }
        if (i2 == 4 && this.k == "draw_ad") {
            ExpressVideoView expressVideoView = this.f30392a;
            if (expressVideoView != null) {
                expressVideoView.performClick();
                return;
            }
            return;
        }
        super.a(i2, kVar, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public void a(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.f30397f = false;
            TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener = this.n;
            if (expressVideoAdListener != null) {
                expressVideoAdListener.onProgressUpdate(j, j2);
            }
            if (a(j)) {
                this.f30393b = 2;
            }
            this.x = j;
            this.y = j2;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.x : invokeV.longValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.InterfaceC0345c
    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            com.bytedance.sdk.component.utils.j.b("NativeExpressVideoView", "onVideoError,errorCode:" + i2 + ",extraCode:" + i3);
            TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener = this.n;
            if (expressVideoAdListener != null) {
                expressVideoAdListener.onVideoError(i2, i3);
            }
            this.x = this.y;
            this.f30393b = 4;
        }
    }

    private boolean a(long j) {
        InterceptResult invokeJ;
        ExpressVideoView expressVideoView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65539, this, j)) == null) {
            int i2 = this.f30393b;
            return !(i2 == 5 || i2 == 3 || j <= this.x) || ((expressVideoView = this.f30392a) != null && expressVideoView.f());
        }
        return invokeJ.booleanValue;
    }
}
