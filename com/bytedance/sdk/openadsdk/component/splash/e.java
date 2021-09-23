package com.bytedance.sdk.openadsdk.component.splash;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.utils.w;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirConstants;
import com.bytedance.sdk.openadsdk.ISplashClickEyeListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.b.b;
import com.bytedance.sdk.openadsdk.core.e.l;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.e.x;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.SplashExpressBackupView;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.widget.TTCountdownView;
import com.bytedance.sdk.openadsdk.e.b.o;
import com.bytedance.sdk.openadsdk.g.a;
import com.bytedance.sdk.openadsdk.q.g;
import com.bytedance.sdk.openadsdk.q.q;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class e implements w.a, TTSplashAd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.bytedance.sdk.openadsdk.core.b.a A;
    public w B;
    public Map<String, Object> C;
    public long D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;

    /* renamed from: a  reason: collision with root package name */
    public AtomicBoolean f66422a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicBoolean f66423b;

    /* renamed from: c  reason: collision with root package name */
    public int f66424c;

    /* renamed from: d  reason: collision with root package name */
    public final Context f66425d;

    /* renamed from: e  reason: collision with root package name */
    public final m f66426e;

    /* renamed from: f  reason: collision with root package name */
    public TsView f66427f;

    /* renamed from: g  reason: collision with root package name */
    public TTSplashAd.AdInteractionListener f66428g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f66429h;

    /* renamed from: i  reason: collision with root package name */
    public long f66430i;

    /* renamed from: j  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.downloadnew.core.a f66431j;
    public d k;
    public String l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public int q;
    public NativeExpressView r;
    public String s;
    public AdSlot t;
    public TTNativeExpressAd.ExpressAdInteractionListener u;
    public AtomicBoolean v;
    public AtomicBoolean w;
    public TTAppDownloadListener x;
    public ISplashClickEyeListener y;
    public com.bytedance.sdk.openadsdk.k.a.b z;

    public e(@NonNull Context context, @NonNull m mVar, AdSlot adSlot, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mVar, adSlot, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66424c = 3;
        this.f66430i = 0L;
        this.l = null;
        this.m = false;
        this.n = false;
        this.p = true;
        this.q = -1;
        this.v = new AtomicBoolean(false);
        this.w = new AtomicBoolean(false);
        this.f66422a = new AtomicBoolean(false);
        this.f66423b = new AtomicBoolean(false);
        this.C = new HashMap();
        this.E = false;
        this.F = true;
        this.G = false;
        this.H = false;
        this.f66425d = context;
        this.f66426e = mVar;
        this.n = mVar.au();
        this.t = adSlot;
        this.s = str;
        c();
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd
    public int getInteractionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            m mVar = this.f66426e;
            if (mVar == null) {
                return -1;
            }
            return mVar.X();
        }
        return invokeV.intValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd
    public Map<String, Object> getMediaExtraInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            m mVar = this.f66426e;
            if (mVar != null) {
                l lVar = mVar.ad().get(0);
                if (lVar.f()) {
                    if (lVar == null) {
                        return this.f66426e.av();
                    }
                    String a2 = lVar.a();
                    Map<String, Object> av = this.f66426e.av();
                    av.put("image_url", a2);
                    return av;
                }
                return this.f66426e.av();
            }
            return null;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd
    public int[] getSplashClickEyeSizeToDp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int[] iArr = new int[2];
            m mVar = this.f66426e;
            if (mVar == null) {
                return null;
            }
            boolean au = mVar.au();
            if (this.f66426e.S() == null) {
                return null;
            }
            if (au) {
                iArr[0] = this.f66426e.S().d();
                iArr[1] = this.f66426e.S().e();
            } else {
                iArr[0] = this.f66426e.S().a();
                iArr[1] = this.f66426e.S().b();
            }
            return iArr;
        }
        return (int[]) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd
    @NonNull
    public View getSplashView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            m mVar = this.f66426e;
            if (mVar == null || mVar.V() == null || this.f66427f.getVideoContainer() == null || this.l == null || d()) {
                return this.f66427f;
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd
    public void renderExpressAd(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        NativeExpressView nativeExpressView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, expressAdInteractionListener) == null) || expressAdInteractionListener == null || (nativeExpressView = this.r) == null) {
            return;
        }
        this.u = expressAdInteractionListener;
        nativeExpressView.j();
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, tTAppDownloadListener) == null) {
            this.x = tTAppDownloadListener;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd
    public void setNotAllowSdkCountdown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f66429h = true;
            TsView tsView = this.f66427f;
            if (tsView != null) {
                tsView.setSkipIconVisibility(8);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd
    public void setSplashClickEyeListener(ISplashClickEyeListener iSplashClickEyeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, iSplashClickEyeListener) == null) {
            this.y = iSplashClickEyeListener;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd
    public void setSplashInteractionListener(TTSplashAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, adInteractionListener) == null) {
            this.f66428g = adInteractionListener;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd
    public void splashClickEyeAnimationFinish() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.f66427f == null || this.f66426e == null || this.E) {
            return;
        }
        this.E = true;
        this.D = System.currentTimeMillis();
        this.C.put("splash_click_area", 1);
        com.bytedance.sdk.openadsdk.core.b.a aVar = this.A;
        if (aVar != null) {
            aVar.a(this.C);
        }
        boolean au = this.f66426e.au();
        this.f66427f.setCloseViewVisibility(0);
        this.f66427f.setSkipIconVisibility(8);
        this.f66427f.setClickBarViewVisibility(8);
        this.f66427f.setVideoVoiceVisibility(8);
        this.f66427f.setAdlogoViewVisibility(8);
        com.bytedance.sdk.openadsdk.core.b.a aVar2 = this.A;
        if (aVar2 != null) {
            aVar2.a(this.f66427f);
            this.f66427f.setOnClickListenerInternal(this.A);
            this.f66427f.setOnTouchListenerInternal(this.A);
        }
        com.bytedance.sdk.openadsdk.e.d.b(o.a(), this.f66426e, this.s, "show_splash_icon");
        if (!au) {
            b(this.z);
            int A = o.h().A();
            if (A > 0) {
                this.B.sendEmptyMessageDelayed(1, A * 1000);
            }
        } else if (this.H) {
            d dVar = this.k;
            if (dVar != null) {
                dVar.m();
            }
            j();
            this.G = false;
        } else {
            if (Build.VERSION.SDK_INT <= 19) {
                d dVar2 = this.k;
                if (dVar2 != null) {
                    dVar2.m();
                }
                j();
            } else {
                l();
            }
            this.G = false;
        }
        this.f66427f.setCloseViewListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.component.splash.e.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f66443a;

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
                this.f66443a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    this.f66443a.a(true);
                    com.bytedance.sdk.openadsdk.e.d.b(o.a(), this.f66443a.f66426e, this.f66443a.s, "close_splash_icon");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            if (!com.bytedance.sdk.openadsdk.downloadnew.a.d.f67940j) {
                this.F = false;
                if (this.E) {
                    a(true);
                    return;
                }
                return;
            }
            com.bytedance.sdk.openadsdk.downloadnew.a.d.f67940j = false;
            com.bytedance.sdk.openadsdk.core.b.a aVar = this.A;
            if (aVar != null) {
                aVar.a(new b.InterfaceC1906b(this) { // from class: com.bytedance.sdk.openadsdk.component.splash.e.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ e f66442a;

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
                        this.f66442a = this;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.b.b.InterfaceC1906b
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f66442a.F = false;
                            if (this.f66442a.E) {
                                this.f66442a.a(true);
                            }
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.b.b.InterfaceC1906b
                    public void b() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        }
                    }
                });
            }
        }
    }

    private void f() {
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65559, this) == null) || (mVar = this.f66426e) == null || mVar.d() == 1) {
            return;
        }
        if (this.f66426e.V() == null) {
            this.r = new NativeExpressView(this.f66425d, this.f66426e, this.t, this.s);
        } else if (!TextUtils.isEmpty(this.l)) {
            com.bytedance.sdk.openadsdk.core.video.a.a.a(this.f66426e.V().i(), this.l);
            this.r = new NativeExpressVideoView(this.f66425d, this.f66426e, this.t, this.s);
        }
        NativeExpressView nativeExpressView = this.r;
        if (nativeExpressView == null) {
            return;
        }
        nativeExpressView.setBackupListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.c(this) { // from class: com.bytedance.sdk.openadsdk.component.splash.e.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f66444a;

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
                this.f66444a = this;
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public boolean a(NativeExpressView nativeExpressView2, int i2) {
                InterceptResult invokeLI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLI = interceptable2.invokeLI(1048576, this, nativeExpressView2, i2)) == null) {
                    try {
                        new SplashExpressBackupView(this.f66444a.f66425d).a(this.f66444a.f66426e, nativeExpressView2);
                        return true;
                    } catch (Exception unused) {
                        return false;
                    }
                }
                return invokeLI.booleanValue;
            }
        });
        a(this.r, this.f66426e);
        this.r.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener(this) { // from class: com.bytedance.sdk.openadsdk.component.splash.e.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f66445a;

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
                this.f66445a = this;
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdClicked(View view, int i2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(1048576, this, view, i2) == null) {
                    if (this.f66445a.u != null) {
                        this.f66445a.u.onAdClicked(view, i2);
                    }
                    if (this.f66445a.f66428g != null) {
                        this.f66445a.f66428g.onAdClicked(view, i2);
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdShow(View view, int i2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2) == null) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(View view, String str, int i2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, view, str, i2) == null) {
                    k.f("splash", "onRenderFail:" + str);
                    if (this.f66445a.u != null) {
                        this.f66445a.u.onRenderFail(view, str, i2);
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderSuccess(View view, float f2, float f3) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeCommon(1048579, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)}) == null) || this.f66445a.v.get()) {
                    return;
                }
                if (view == null || f2 <= 0.0f || f3 <= 0.0f) {
                    this.f66445a.u.onRenderFail(view, "width <=0 or height <= 0", 110);
                    return;
                }
                this.f66445a.f66427f.a(8, 0, 0, 0, 0);
                this.f66445a.f66427f.setExpressView(this.f66445a.r);
                if (this.f66445a.u != null) {
                    this.f66445a.u.onRenderSuccess(view, f2, f3);
                }
                this.f66445a.w.set(true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, this)) == null) {
            m mVar = this.f66426e;
            return (mVar == null || mVar.S() == null || this.f66426e.d() == 2) ? false : true;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65564, this) == null) || this.y == null) {
            return;
        }
        if (!g()) {
            this.y.isSupportSplashClickEye(false);
            return;
        }
        if (this.n) {
            k();
        }
        this.y.isSupportSplashClickEye(true);
        this.G = true;
        this.y.onSplashClickEyeAnimationStart();
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65566, this) == null) {
            if (this.f66426e.V() != null) {
                if (this.l != null) {
                    this.q = 1;
                } else {
                    this.q = 2;
                }
            } else {
                this.q = 0;
            }
            this.f66431j = b(this.f66426e);
            EmptyView emptyView = new EmptyView(this.f66425d, this.f66427f);
            emptyView.setAdType(3);
            this.f66427f.addView(emptyView);
            com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.f66431j;
            if (aVar != null) {
                aVar.a(emptyView);
            }
            b(false);
            emptyView.setCallback(new EmptyView.a(this) { // from class: com.bytedance.sdk.openadsdk.component.splash.e.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f66436a;

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
                    this.f66436a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void a(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || this.f66436a.f66431j == null) {
                        return;
                    }
                    if (z) {
                        this.f66436a.f66431j.b();
                    } else {
                        this.f66436a.f66431j.c();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.component.splash.e.11.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass11 f66437a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f66437a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.f66437a.f66436a.f66431j == null) {
                                    return;
                                }
                                this.f66437a.f66436a.f66431j.d();
                            }
                        }, 1000L);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f66436a.v.set(true);
                        if (this.f66436a.f66431j != null) {
                            this.f66436a.f66431j.a();
                        }
                        if (this.f66436a.f66431j == null || this.f66436a.f66427f == null || this.f66436a.f66427f.getParent() == null) {
                            return;
                        }
                        Context context = null;
                        try {
                            context = ((View) this.f66436a.f66427f.getParent()).getContext();
                        } catch (Exception unused) {
                        }
                        if (context == null || !(context instanceof Activity)) {
                            return;
                        }
                        this.f66436a.f66431j.a((Activity) context);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void a(View view) {
                    TTCountdownView countDownView;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                        this.f66436a.v.set(true);
                        this.f66436a.f66430i = System.currentTimeMillis();
                        HashMap hashMap = new HashMap();
                        if (this.f66436a.f66426e != null) {
                            if (this.f66436a.f66426e.V() != null) {
                                if (this.f66436a.l != null) {
                                    hashMap.put("splash_show_type", 1);
                                } else {
                                    hashMap.put("splash_show_type", 2);
                                }
                            } else {
                                hashMap.put("splash_show_type", 0);
                            }
                        }
                        if (this.f66436a.w.get()) {
                            hashMap.put("splash_show_type", 3);
                        }
                        k.e("AdEvent", "pangolin ad show " + q.a(this.f66436a.f66426e, view));
                        com.bytedance.sdk.openadsdk.e.d.a(this.f66436a.f66425d, this.f66436a.f66426e, this.f66436a.s, hashMap);
                        this.f66436a.m();
                        if (!this.f66436a.f66429h && this.f66436a.f66427f != null && (countDownView = this.f66436a.f66427f.getCountDownView()) != null) {
                            countDownView.setCountdownListener(new TTCountdownView.a(this) { // from class: com.bytedance.sdk.openadsdk.component.splash.e.11.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass11 f66438a;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f66438a = this;
                                }

                                @Override // com.bytedance.sdk.openadsdk.core.widget.TTCountdownView.a
                                public void a() {
                                    Interceptable interceptable3 = $ic;
                                    if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || this.f66438a.f66436a.G) {
                                        return;
                                    }
                                    this.f66438a.f66436a.l();
                                }

                                @Override // com.bytedance.sdk.openadsdk.core.widget.TTCountdownView.a
                                public void b() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                        if (this.f66438a.f66436a.F) {
                                            this.f66438a.f66436a.h();
                                            this.f66438a.f66436a.F = true;
                                        } else if (this.f66438a.f66436a.k != null) {
                                            this.f66438a.f66436a.k.m();
                                        }
                                        if (this.f66438a.f66436a.w.get() && this.f66438a.f66436a.r != null) {
                                            this.f66438a.f66436a.r.l();
                                        }
                                        if (this.f66438a.f66436a.f66428g != null) {
                                            this.f66438a.f66436a.f66428g.onAdTimeOver();
                                        }
                                        try {
                                            if (this.f66438a.f66436a.k != null) {
                                                if (this.f66438a.f66436a.k.B()) {
                                                    this.f66438a.f66436a.k.b(true);
                                                }
                                                if (!this.f66438a.f66436a.w.get()) {
                                                    this.f66438a.f66436a.k.b();
                                                }
                                                if (this.f66438a.f66436a.g()) {
                                                    return;
                                                }
                                                this.f66438a.f66436a.k.m();
                                            }
                                        } catch (Throwable unused) {
                                        }
                                    }
                                }

                                @Override // com.bytedance.sdk.openadsdk.core.widget.TTCountdownView.a
                                public void c() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                                        this.f66438a.f66436a.k();
                                    }
                                }
                            });
                            if (!this.f66436a.f66423b.get()) {
                                countDownView.a();
                            }
                        }
                        if (this.f66436a.f66428g != null) {
                            this.f66436a.f66428g.onAdShow(this.f66436a.f66427f, this.f66436a.f66426e.X());
                        }
                        k.b("TTSplashAdImpl", "bindViewInteraction 开屏广告展示");
                    }
                }
            });
            emptyView.setNeedCheckingShow(true);
            this.C.put("splash_show_type", Integer.valueOf(this.q));
            com.bytedance.sdk.openadsdk.core.b.a aVar2 = new com.bytedance.sdk.openadsdk.core.b.a(this.f66425d, this.f66426e, this.s, 4);
            this.A = aVar2;
            aVar2.a(this);
            this.A.a(this.C);
            m mVar = this.f66426e;
            if (mVar != null && this.f66427f != null) {
                if (mVar.E() == 2) {
                    View fullClickBarView = this.f66427f.getFullClickBarView();
                    if (fullClickBarView != null) {
                        this.A.a(fullClickBarView);
                        fullClickBarView.setOnClickListener(this.A);
                        fullClickBarView.setOnTouchListener(this.A);
                    }
                } else {
                    this.A.a(this.f66427f);
                    this.f66427f.setOnClickListenerInternal(this.A);
                    this.f66427f.setOnTouchListenerInternal(this.A);
                }
            }
            this.A.b(this.f66427f.getDislikeView());
            this.A.a(this.f66431j);
            this.A.a(new b.a(this) { // from class: com.bytedance.sdk.openadsdk.component.splash.e.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f66439a;

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
                    this.f66439a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.core.b.b.a
                public void a(View view, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLI(1048576, this, view, i2) == null) {
                        if (this.f66439a.f66428g != null) {
                            this.f66439a.f66428g.onAdClicked(view, i2);
                        }
                        this.f66439a.e();
                    }
                }
            });
            this.f66427f.setSkipListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.component.splash.e.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f66440a;

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
                    this.f66440a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (this.f66440a.f66426e != null && this.f66440a.f66426e.V() != null && this.f66440a.o && this.f66440a.k != null) {
                            if (!this.f66440a.g()) {
                                this.f66440a.k.m();
                            }
                            if (!this.f66440a.w.get()) {
                                o.a aVar3 = new o.a();
                                aVar3.a(this.f66440a.k.n());
                                aVar3.c(this.f66440a.k.q());
                                aVar3.b(this.f66440a.k.o());
                                aVar3.e(3);
                                aVar3.f(this.f66440a.k.p());
                                com.bytedance.sdk.openadsdk.e.a.a.f(this.f66440a.f66425d, this.f66440a.k.w(), aVar3);
                            }
                        }
                        if (!TextUtils.isEmpty(this.f66440a.f66426e.ao())) {
                            com.bytedance.sdk.openadsdk.e.d.a(this.f66440a.f66425d, this.f66440a.f66430i > 0 ? System.currentTimeMillis() - this.f66440a.f66430i : 0L, this.f66440a.f66426e);
                        }
                        if (this.f66440a.F) {
                            this.f66440a.h();
                            this.f66440a.F = true;
                        }
                        if (this.f66440a.w.get() && this.f66440a.r != null) {
                            this.f66440a.r.l();
                        }
                        if (this.f66440a.f66428g != null) {
                            this.f66440a.f66424c = 0;
                            this.f66440a.f66428g.onAdSkip();
                        }
                    }
                }
            });
        }
    }

    private boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, this)) == null) {
            if (this.f66426e == null || this.f66427f == null) {
                return false;
            }
            return d();
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65570, this) == null) {
            try {
                if (this.k != null) {
                    this.k.i();
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65572, this) == null) {
            try {
                if (this.k != null) {
                    this.k.k();
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        TsView tsView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65574, this) == null) || (tsView = this.f66427f) == null || tsView.getChildCount() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < this.f66427f.getChildCount(); i2++) {
            View childAt = this.f66427f.getChildAt(i2);
            if (childAt != null && (childAt instanceof EmptyView)) {
                this.f66427f.removeView(childAt);
                return;
            }
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            if (this.f66426e != null) {
                this.f66427f = new TsView(this.f66425d, this.f66426e.aO());
            } else {
                this.f66427f = new TsView(this.f66425d, "");
            }
            m mVar = this.f66426e;
            if (mVar != null) {
                this.f66427f.setADlogoLongClickContent(mVar.aH());
            }
            com.bytedance.sdk.openadsdk.e.d.a(this.f66426e);
            if (this.f66426e.V() != null && this.n) {
                this.f66427f.setVideoViewVisibility(0);
                this.f66427f.setImageViewVisibility(8);
                this.f66427f.setVoiceViewListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.component.splash.e.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ e f66432a;

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
                        this.f66432a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.f66432a.f66427f.setVoiceViewImageResource(this.f66432a.p ? t.d(this.f66432a.f66425d, "tt_splash_unmute") : t.d(this.f66432a.f66425d, "tt_splash_mute"));
                            e eVar = this.f66432a;
                            eVar.p = !eVar.p;
                            if (this.f66432a.k != null) {
                                this.f66432a.k.b(this.f66432a.p);
                            }
                        }
                    }
                });
            }
            if (!this.n) {
                this.f66427f.setVideoViewVisibility(8);
                this.f66427f.setImageViewVisibility(0);
            }
            if (this.f66426e.j() == 0) {
                TsView tsView = this.f66427f;
                if (tsView != null) {
                    tsView.setAdlogoViewVisibility(8);
                }
            } else {
                TsView tsView2 = this.f66427f;
                if (tsView2 != null) {
                    tsView2.setAdlogoViewVisibility(0);
                }
            }
            if (this.f66426e.ar() <= 0) {
                a(3);
            } else {
                int ar = this.f66426e.ar();
                this.f66424c = ar;
                a(ar);
            }
            a(this.f66426e);
            i();
            f();
            this.B = new w(Looper.getMainLooper(), this);
        }
    }

    private boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) {
            this.k = new d(this.f66425d, this.f66427f.getVideoContainer(), this.f66426e);
            k.f("wzj", "mVideoCachePath:" + this.l);
            this.k.a(new c.a(this) { // from class: com.bytedance.sdk.openadsdk.component.splash.e.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f66441a;

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
                    this.f66441a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
                public void a(long j2, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
                        this.f66441a.a(false);
                        this.f66441a.F = false;
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
                public void a(long j2, long j3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
                public void b(long j2, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
                        this.f66441a.H = true;
                        this.f66441a.F = false;
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.f66441a.f66428g != null) {
                            this.f66441a.f66428g.onAdTimeOver();
                        }
                        this.f66441a.a(false);
                        this.f66441a.F = false;
                    }
                }
            });
            x V = this.f66426e.V();
            com.bytedance.sdk.openadsdk.n.f.b bVar = new com.bytedance.sdk.openadsdk.n.f.b();
            bVar.a(V.i());
            bVar.d(this.f66426e.ak());
            bVar.b(this.f66427f.getVideoContainer().getWidth());
            bVar.c(this.f66427f.getVideoContainer().getHeight());
            bVar.e(this.f66426e.ao());
            bVar.a(0L);
            bVar.a(this.p);
            int d2 = q.d(this.f66426e.ao());
            String l = V.l();
            if (TextUtils.isEmpty(l)) {
                l = com.bytedance.sdk.component.utils.e.a(V.i());
            }
            bVar.b(l);
            String a2 = c.a(com.bytedance.sdk.openadsdk.core.o.a(), a.a(com.bytedance.sdk.openadsdk.core.o.a()).a(String.valueOf(d2), com.bytedance.sdk.openadsdk.multipro.b.b()));
            if (this.f66426e.aN()) {
                a2 = CacheDirConstants.getBrandCacheDir();
            }
            bVar.c(a2);
            boolean a3 = this.k.a(bVar);
            this.o = a3;
            return a3;
        }
        return invokeV.booleanValue;
    }

    public void b(com.bytedance.sdk.openadsdk.k.a.b bVar) {
        Drawable a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) || bVar == null) {
            return;
        }
        if (bVar.d()) {
            this.f66427f.setGifView(bVar.b());
        } else if (this.f66426e.S() == null || TextUtils.isEmpty(this.f66426e.S().c())) {
        } else {
            if (bVar.a() != null) {
                a2 = new BitmapDrawable(bVar.a());
            } else {
                a2 = g.a(bVar.b(), 0);
            }
            this.f66427f.setDrawable(a2);
        }
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    private void a(m mVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, mVar) == null) || mVar == null || this.f66427f == null) {
            return;
        }
        int E = mVar.E();
        String F = mVar.F();
        int H = mVar.H();
        int G = mVar.G();
        int I = mVar.I();
        int J = mVar.J();
        if (E == 2) {
            if (!TextUtils.isEmpty(F)) {
                this.f66427f.a(0, H, G, I, J);
                this.f66427f.setClickBarDesc(F);
                return;
            }
            this.f66427f.a(0, H, G, I, J);
            this.f66427f.setClickBarDesc("查看详情");
        } else if (TextUtils.isEmpty(F)) {
            this.f66427f.a(8, H, G, I, J);
        } else {
            this.f66427f.a(0, H, G, I, J);
            this.f66427f.setClickBarDesc(F);
        }
    }

    private void b(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65550, this, z) == null) || this.f66431j == null) {
            return;
        }
        m mVar = this.f66426e;
        this.f66431j.a(new TTAppDownloadListener(this, z, mVar != null ? mVar.ak() : "") { // from class: com.bytedance.sdk.openadsdk.component.splash.e.10
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ boolean f66433a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f66434b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ e f66435c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Boolean.valueOf(z), r8};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f66435c = this;
                this.f66433a = z;
                this.f66434b = r8;
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadActive(long j2, long j3, String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str, str2}) == null) {
                    if (this.f66435c.x != null) {
                        this.f66435c.x.onDownloadActive(j2, j3, str, str2);
                    }
                    if (!this.f66433a || j2 <= 0) {
                        return;
                    }
                    a.C1923a.a(this.f66434b, 3, (int) ((j3 * 100) / j2));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFailed(long j2, long j3, String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str, str2}) == null) {
                    if (this.f66435c.x != null) {
                        this.f66435c.x.onDownloadFailed(j2, j3, str, str2);
                    }
                    if (!this.f66433a || j2 <= 0) {
                        return;
                    }
                    a.C1923a.a(this.f66434b, 4, (int) ((j3 * 100) / j2));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFinished(long j2, String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), str, str2}) == null) {
                    if (this.f66435c.x != null) {
                        this.f66435c.x.onDownloadFinished(j2, str, str2);
                    }
                    if (this.f66433a) {
                        a.C1923a.a(this.f66434b, 5, 100);
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadPaused(long j2, long j3, String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str, str2}) == null) {
                    if (this.f66435c.x != null) {
                        this.f66435c.x.onDownloadPaused(j2, j3, str, str2);
                    }
                    if (!this.f66433a || j2 <= 0) {
                        return;
                    }
                    a.C1923a.a(this.f66434b, 2, (int) ((j3 * 100) / j2));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onIdle() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    if (this.f66435c.x != null) {
                        this.f66435c.x.onIdle();
                    }
                    if (this.f66433a) {
                        a.C1923a.a(this.f66434b, 1, 0);
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onInstalled(String str, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048581, this, str, str2) == null) {
                    if (this.f66435c.x != null) {
                        this.f66435c.x.onInstalled(str, str2);
                    }
                    if (this.f66433a) {
                        a.C1923a.a(this.f66434b, 6, 100);
                    }
                }
            }
        });
    }

    private com.bytedance.sdk.openadsdk.downloadnew.core.a b(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, mVar)) == null) {
            if (mVar.X() == 4) {
                return com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f66425d, mVar, this.s);
            }
            return null;
        }
        return (com.bytedance.sdk.openadsdk.downloadnew.core.a) invokeL.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            m mVar = this.f66426e;
            return mVar != null && mVar.d() == 2;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65544, this, z) == null) {
            if (z && this.n && this.E) {
                a(System.currentTimeMillis() - this.D);
                this.E = false;
            }
            ISplashClickEyeListener iSplashClickEyeListener = this.y;
            if (iSplashClickEyeListener != null) {
                iSplashClickEyeListener.onSplashClickEyeAnimationFinish();
            }
            d dVar = this.k;
            if (dVar != null) {
                dVar.m();
            }
        }
    }

    public e(@NonNull Context context, @NonNull m mVar, String str, AdSlot adSlot, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mVar, str, adSlot, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f66424c = 3;
        this.f66430i = 0L;
        this.l = null;
        this.m = false;
        this.n = false;
        this.p = true;
        this.q = -1;
        this.v = new AtomicBoolean(false);
        this.w = new AtomicBoolean(false);
        this.f66422a = new AtomicBoolean(false);
        this.f66423b = new AtomicBoolean(false);
        this.C = new HashMap();
        this.E = false;
        this.F = true;
        this.G = false;
        this.H = false;
        this.f66425d = context;
        this.f66426e = mVar;
        this.n = mVar.au();
        this.l = str;
        this.t = adSlot;
        this.s = str2;
        c();
    }

    public void c(com.bytedance.sdk.openadsdk.k.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.z = bVar;
        }
    }

    private void a(@NonNull NativeExpressView nativeExpressView, @NonNull m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, this, nativeExpressView, mVar) == null) {
            com.bytedance.sdk.openadsdk.downloadnew.core.a b2 = b(mVar);
            this.f66431j = b2;
            if (b2 != null) {
                b2.b();
                if (nativeExpressView.getContext() != null && (nativeExpressView.getContext() instanceof Activity)) {
                    this.f66431j.a((Activity) nativeExpressView.getContext());
                }
            }
            com.bytedance.sdk.openadsdk.e.d.a(mVar);
            EmptyView emptyView = new EmptyView(this.f66425d, nativeExpressView);
            com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.f66431j;
            if (aVar != null) {
                aVar.a(emptyView);
            }
            emptyView.setCallback(new EmptyView.a(this) { // from class: com.bytedance.sdk.openadsdk.component.splash.e.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ e f66446a;

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
                    this.f66446a = this;
                }

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void a(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || this.f66446a.f66431j == null) {
                        return;
                    }
                    if (z) {
                        if (this.f66446a.f66431j != null) {
                            this.f66446a.f66431j.b();
                        }
                    } else if (this.f66446a.f66431j != null) {
                        this.f66446a.f66431j.c();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048579, this) == null) || this.f66446a.f66431j == null) {
                        return;
                    }
                    this.f66446a.f66431j.d();
                }

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f66446a.f66431j == null) {
                        return;
                    }
                    this.f66446a.f66431j.a();
                }

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void a(View view) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || this.f66446a.r == null) {
                        return;
                    }
                    this.f66446a.r.i();
                }
            });
            this.C.put("splash_show_type", 3);
            Context context = this.f66425d;
            String str = this.s;
            com.bytedance.sdk.openadsdk.core.nativeexpress.e eVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.e(context, mVar, str, q.a(str));
            eVar.a(nativeExpressView);
            eVar.a(this.f66431j);
            eVar.a(this.C);
            this.r.setClickListener(eVar);
            Context context2 = this.f66425d;
            String str2 = this.s;
            com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(context2, mVar, str2, q.a(str2));
            dVar.a(this);
            dVar.a(nativeExpressView);
            dVar.a(this.f66431j);
            dVar.a(this.C);
            this.r.setClickCreativeListener(dVar);
            emptyView.setNeedCheckingShow(true);
            b(true);
        }
    }

    public void a(com.bytedance.sdk.openadsdk.k.a.b bVar) {
        Drawable a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            if (bVar.d()) {
                this.f66427f.setGifView(bVar.b());
            } else if (this.f66426e.ad() == null || this.f66426e.ad().get(0) == null) {
            } else {
                if (bVar.a() != null) {
                    a2 = new BitmapDrawable(bVar.a());
                } else {
                    a2 = g.a(bVar.b(), this.f66426e.ad().get(0).b());
                }
                this.f66427f.setDrawable(a2);
            }
        }
    }

    private void a(int i2) {
        TsView tsView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2) == null) || (tsView = this.f66427f) == null) {
            return;
        }
        tsView.setCountDownTime(i2);
    }

    @Override // com.bytedance.sdk.component.utils.w.a
    public void a(Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) && message.what == 1) {
            a(false);
        }
    }

    private void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(AdIconUtil.AD_TEXT_ID, this, j2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("show_time", j2);
                com.bytedance.sdk.openadsdk.e.d.b(com.bytedance.sdk.openadsdk.core.o.a(), this.f66426e, this.s, "icon_splash_video_show_time", jSONObject);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
