package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
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
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.widget.RoundFrameLayout;
/* loaded from: classes9.dex */
public class NativeExpressVideoView extends NativeExpressView implements i, c.b, c.InterfaceC1911c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ExpressVideoView f66615a;

    /* renamed from: b  reason: collision with root package name */
    public int f66616b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f66617c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f66618d;

    /* renamed from: e  reason: collision with root package name */
    public int f66619e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f66620f;
    public com.bytedance.sdk.openadsdk.multipro.b.a r;
    public long s;
    public long t;
    public com.bytedance.sdk.openadsdk.core.nativeexpress.a.b u;

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
        this.f66616b = 1;
        this.f66617c = false;
        this.f66618d = true;
        this.f66620f = true;
        h();
    }

    private void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            try {
                this.r = new com.bytedance.sdk.openadsdk.multipro.b.a();
                ExpressVideoView a2 = a(this.f66630g, this.f66633j, this.f66631h);
                this.f66615a = a2;
                a2.setShouldCheckNetChange(false);
                this.f66615a.setControllerStatusCallBack(new NativeVideoTsView.a(this) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ NativeExpressVideoView f66621a;

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
                        this.f66621a = this;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.a
                    public void a(boolean z, long j2, long j3, long j4, boolean z2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Boolean.valueOf(z2)}) == null) {
                            this.f66621a.r.f67933a = z;
                            this.f66621a.r.f67937e = j2;
                            this.f66621a.r.f67938f = j3;
                            this.f66621a.r.f67939g = j4;
                            this.f66621a.r.f67936d = z2;
                        }
                    }
                });
                this.f66615a.setVideoAdLoadListener(this);
                this.f66615a.setVideoAdInteractionListener(this);
                if ("embeded_ad".equals(this.f66631h)) {
                    this.f66615a.setIsAutoPlay(this.f66617c ? this.f66632i.isAutoPlay() : this.f66618d);
                } else if ("splash_ad".equals(this.f66631h)) {
                    this.f66615a.setIsAutoPlay(true);
                } else {
                    this.f66615a.setIsAutoPlay(this.f66618d);
                }
                if ("splash_ad".equals(this.f66631h)) {
                    this.f66615a.setIsQuiet(true);
                } else {
                    this.f66615a.setIsQuiet(com.bytedance.sdk.openadsdk.core.o.h().b(this.f66619e));
                }
                this.f66615a.d_();
            } catch (Exception e2) {
                this.f66615a = null;
                com.bytedance.sdk.component.utils.k.f("NativeExpressVideoView", "（dev ignore）ExpressVideoView-->print:" + e2.toString());
            }
        }
    }

    private void setShowAdInteractionView(boolean z) {
        ExpressVideoView expressVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65543, this, z) == null) || (expressVideoView = this.f66615a) == null) {
            return;
        }
        expressVideoView.setShowAdInteractionView(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.i
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
                this.f66617c = false;
                this.f66618d = false;
            } else if (1 == d2) {
                this.f66617c = false;
                this.f66618d = com.bytedance.sdk.component.utils.n.d(this.f66630g);
            } else if (2 == d2) {
                if (com.bytedance.sdk.component.utils.n.e(this.f66630g) || com.bytedance.sdk.component.utils.n.d(this.f66630g) || com.bytedance.sdk.component.utils.n.f(this.f66630g)) {
                    this.f66617c = false;
                    this.f66618d = true;
                }
            } else if (5 == d2) {
                if (com.bytedance.sdk.component.utils.n.d(this.f66630g) || com.bytedance.sdk.component.utils.n.f(this.f66630g)) {
                    this.f66617c = false;
                    this.f66618d = true;
                }
            } else if (4 == d2) {
                this.f66617c = true;
            }
            if (!this.f66618d) {
                this.f66616b = 3;
            }
            com.bytedance.sdk.component.utils.k.c("NativeVideoAdView", "mIsAutoPlay=" + this.f66618d + ",status=" + d2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.i
    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.s : invokeV.longValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.i
    public int d() {
        InterceptResult invokeV;
        ExpressVideoView expressVideoView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.f66616b == 3 && (expressVideoView = this.f66615a) != null) {
                expressVideoView.d_();
            }
            ExpressVideoView expressVideoView2 = this.f66615a;
            if (expressVideoView2 == null || !expressVideoView2.getNativeVideoController().y()) {
                return this.f66616b;
            }
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.i
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public void e_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f66620f = false;
            com.bytedance.sdk.component.utils.k.b("NativeExpressVideoView", "onVideoAdStartPlay");
            TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener = this.k;
            if (expressVideoAdListener != null) {
                expressVideoAdListener.onVideoAdStartPlay();
            }
            this.f66616b = 2;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.i
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public void f_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f66620f = false;
            com.bytedance.sdk.component.utils.k.b("NativeExpressVideoView", "onVideoAdPaused");
            TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener = this.k;
            if (expressVideoAdListener != null) {
                expressVideoAdListener.onVideoAdPaused();
            }
            this.m = true;
            this.f66616b = 3;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public void g_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f66620f = false;
            com.bytedance.sdk.component.utils.k.b("NativeExpressVideoView", "onVideoAdContinuePlay");
            TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener = this.k;
            if (expressVideoAdListener != null) {
                expressVideoAdListener.onVideoAdContinuePlay();
            }
            this.m = false;
            this.f66616b = 2;
        }
    }

    public com.bytedance.sdk.openadsdk.multipro.b.a getVideoModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.r : (com.bytedance.sdk.openadsdk.multipro.b.a) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.l = new RoundFrameLayout(this.f66630g);
            int d2 = com.bytedance.sdk.openadsdk.q.q.d(this.f66633j.ao());
            this.f66619e = d2;
            b(d2);
            o();
            addView(this.l, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public void h_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.f66620f = false;
            com.bytedance.sdk.component.utils.k.b("NativeExpressVideoView", "onVideoComplete");
            TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener = this.k;
            if (expressVideoAdListener != null) {
                expressVideoAdListener.onVideoAdComplete();
            }
            this.f66616b = 5;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.InterfaceC1911c
    public void i_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            com.bytedance.sdk.component.utils.k.b("NativeExpressVideoView", "onVideoLoad");
            TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener = this.k;
            if (expressVideoAdListener != null) {
                expressVideoAdListener.onVideoLoad();
            }
        }
    }

    public void setCanInterruptVideoPlay(boolean z) {
        ExpressVideoView expressVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048598, this, z) == null) || (expressVideoView = this.f66615a) == null) {
            return;
        }
        expressVideoView.setCanInterruptVideoPlay(z);
    }

    public ExpressVideoView a(Context context, com.bytedance.sdk.openadsdk.core.e.m mVar, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, mVar, str)) == null) ? new ExpressVideoView(context, mVar, str, false) : (ExpressVideoView) invokeLLL.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void a(com.bytedance.sdk.openadsdk.core.nativeexpress.a.b<? extends View> bVar, com.bytedance.sdk.openadsdk.core.e.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, bVar, pVar) == null) {
            this.u = bVar;
            if ((bVar instanceof v) && ((v) bVar).h() != null) {
                ((v) this.u).h().a((i) this);
            }
            if (pVar != null && pVar.b()) {
                if (pVar.a() == 2) {
                    this.f66615a.a(this.f66630g, 25);
                }
                a(pVar);
            }
            super.a(bVar, pVar);
        }
    }

    private void a(com.bytedance.sdk.openadsdk.core.e.p pVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, this, pVar) == null) || pVar == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            b(pVar);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable(this, pVar) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.core.e.p f66622a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ NativeExpressVideoView f66623b;

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
                    this.f66623b = this;
                    this.f66622a = pVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f66623b.b(this.f66622a);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.bytedance.sdk.openadsdk.core.e.p pVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, pVar) == null) || pVar == null) {
            return;
        }
        double e2 = pVar.e();
        double f2 = pVar.f();
        double g2 = pVar.g();
        double h2 = pVar.h();
        int b2 = (int) com.bytedance.sdk.openadsdk.q.s.b(this.f66630g, (float) e2);
        int b3 = (int) com.bytedance.sdk.openadsdk.q.s.b(this.f66630g, (float) f2);
        int b4 = (int) com.bytedance.sdk.openadsdk.q.s.b(this.f66630g, (float) g2);
        int b5 = (int) com.bytedance.sdk.openadsdk.q.s.b(this.f66630g, (float) h2);
        float b6 = com.bytedance.sdk.openadsdk.q.s.b(this.f66630g, pVar.j());
        float b7 = com.bytedance.sdk.openadsdk.q.s.b(this.f66630g, pVar.k());
        float b8 = com.bytedance.sdk.openadsdk.q.s.b(this.f66630g, pVar.l());
        float b9 = com.bytedance.sdk.openadsdk.q.s.b(this.f66630g, pVar.m());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.l.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(b4, b5);
        }
        layoutParams.width = b4;
        layoutParams.height = b5;
        layoutParams.topMargin = b3;
        layoutParams.leftMargin = b2;
        this.l.setLayoutParams(layoutParams);
        this.l.removeAllViews();
        ((RoundFrameLayout) this.l).a(b6, b7, b8, b9);
        ExpressVideoView expressVideoView = this.f66615a;
        if (expressVideoView != null) {
            this.l.addView(expressVideoView);
            this.f66615a.a(0L, true, false);
            b(this.f66619e);
            if (!com.bytedance.sdk.component.utils.n.d(this.f66630g) && !this.f66618d && this.f66620f) {
                this.f66615a.e();
            }
            setShowAdInteractionView(false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.i
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            com.bytedance.sdk.component.utils.k.b("NativeExpressVideoView", "onMuteVideo,mute:" + z);
            ExpressVideoView expressVideoView = this.f66615a;
            if (expressVideoView == null || expressVideoView.getNativeVideoController() == null) {
                return;
            }
            this.f66615a.getNativeVideoController().b(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.i
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            com.bytedance.sdk.component.utils.k.b("NativeExpressVideoView", "onSkipVideo");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.i
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            com.bytedance.sdk.component.utils.k.b("NativeExpressVideoView", "onChangeVideoState,stateType:" + i2);
            ExpressVideoView expressVideoView = this.f66615a;
            if (expressVideoView == null) {
                com.bytedance.sdk.component.utils.k.f("NativeExpressVideoView", "onChangeVideoState,ExpressVideoView is null !!!!!!!!!!!!");
            } else if (i2 == 1) {
                expressVideoView.a(0L, true, false);
            } else if (i2 == 2 || i2 == 3) {
                this.f66615a.setVideoPlayStatus(i2);
                this.f66615a.setCanInterruptVideoPlay(true);
                this.f66615a.performClick();
            } else if (i2 == 4) {
                expressVideoView.getNativeVideoController().m();
            } else if (i2 != 5) {
            } else {
                expressVideoView.a(0L, true, false);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.n
    public void a(int i2, com.bytedance.sdk.openadsdk.core.e.k kVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048580, this, i2, kVar) == null) || i2 == -1 || kVar == null) {
            return;
        }
        if (i2 == 4 && this.f66631h == "draw_ad") {
            ExpressVideoView expressVideoView = this.f66615a;
            if (expressVideoView != null) {
                expressVideoView.performClick();
                return;
            }
            return;
        }
        super.a(i2, kVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.n
    public void a(int i2, com.bytedance.sdk.openadsdk.core.e.k kVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), kVar, Boolean.valueOf(z)}) == null) || i2 == -1 || kVar == null) {
            return;
        }
        if (i2 == 4 && this.f66631h == "draw_ad") {
            ExpressVideoView expressVideoView = this.f66615a;
            if (expressVideoView != null) {
                expressVideoView.performClick();
                return;
            }
            return;
        }
        super.a(i2, kVar, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public void a(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.f66620f = false;
            TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener = this.k;
            if (expressVideoAdListener != null) {
                expressVideoAdListener.onProgressUpdate(j2, j3);
            }
            if (a(j2)) {
                this.f66616b = 2;
            }
            this.s = j2;
            this.t = j3;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.InterfaceC1911c
    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            com.bytedance.sdk.component.utils.k.b("NativeExpressVideoView", "onVideoError,errorCode:" + i2 + ",extraCode:" + i3);
            TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener = this.k;
            if (expressVideoAdListener != null) {
                expressVideoAdListener.onVideoError(i2, i3);
            }
            this.s = this.t;
            this.f66616b = 4;
        }
    }

    private boolean a(long j2) {
        InterceptResult invokeJ;
        ExpressVideoView expressVideoView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TRACKBALL, this, j2)) == null) {
            int i2 = this.f66616b;
            return !(i2 == 5 || i2 == 3 || j2 <= this.s) || ((expressVideoView = this.f66615a) != null && expressVideoView.f());
        }
        return invokeJ.booleanValue;
    }
}
