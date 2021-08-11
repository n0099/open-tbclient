package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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
import com.bytedance.sdk.component.utils.n;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.utils.w;
import com.bytedance.sdk.openadsdk.CacheDirConstants;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.g;
import com.bytedance.sdk.openadsdk.core.y;
import com.bytedance.sdk.openadsdk.e.b.o;
import com.bytedance.sdk.openadsdk.img.ImageLoaderWrapper;
import com.bytedance.sdk.openadsdk.q.q;
import com.bytedance.sdk.openadsdk.q.s;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes9.dex */
public class NativeVideoTsView extends FrameLayout implements w.a, c.a, g.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String A;
    public ViewStub B;
    public c.b C;
    public final AtomicBoolean D;
    public boolean E;
    public boolean F;
    public AtomicBoolean G;

    /* renamed from: a  reason: collision with root package name */
    public final Context f66757a;

    /* renamed from: b  reason: collision with root package name */
    public final m f66758b;

    /* renamed from: c  reason: collision with root package name */
    public c f66759c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f66760d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f66761e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f66762f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f66763g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f66764h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f66765i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f66766j;
    public String k;
    public int l;
    public AtomicBoolean m;
    public boolean n;
    public a o;
    public ViewGroup p;
    public boolean q;
    public boolean r;
    public String s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public long x;
    public final w y;
    public boolean z;

    /* loaded from: classes9.dex */
    public interface a {
        void a(boolean z, long j2, long j3, long j4, boolean z2);
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a(View view, int i2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NativeVideoTsView(@NonNull Context context, @NonNull m mVar) {
        this(context, mVar, false, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (m) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void c(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(AdIconUtil.BAIDU_LOGO_ID, this, z) == null) || this.f66758b == null || this.f66759c == null) {
            return;
        }
        boolean q = q();
        r();
        if (q && this.f66759c.x()) {
            k.b("NativeVideoAdView", "changeVideoStatus---isFromDetailPage()=" + q + "，mNativeVideoController.isPlayComplete()=" + this.f66759c.x());
            b(true);
            e();
        } else if (z && !this.f66759c.x() && !this.f66759c.u()) {
            if (this.f66759c.v() != null && this.f66759c.v().i()) {
                if (this.q) {
                    if ("ALP-AL00".equals(this.A)) {
                        this.f66759c.k();
                    } else {
                        if (!com.bytedance.sdk.openadsdk.core.h.d().u()) {
                            q = true;
                        }
                        ((g) this.f66759c).f(q);
                    }
                    c.b bVar = this.C;
                    if (bVar != null) {
                        bVar.g_();
                    }
                }
            } else if (this.q && this.f66759c.v() == null) {
                if (!this.D.get()) {
                    this.D.set(true);
                }
                this.G.set(false);
                d();
            }
        } else if (this.f66759c.v() == null || !this.f66759c.v().g()) {
        } else {
            this.f66759c.i();
            c.b bVar2 = this.C;
            if (bVar2 != null) {
                bVar2.f_();
            }
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            a(0L, 0);
            this.C = null;
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            addView(a(this.f66757a));
            l();
        }
    }

    private void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || !(this instanceof NativeDrawVideoTsView) || this.m.get() || com.bytedance.sdk.openadsdk.core.h.d().v() == null) {
            return;
        }
        this.f66765i.setImageBitmap(com.bytedance.sdk.openadsdk.core.h.d().v());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f66765i.getLayoutParams();
        int b2 = (int) s.b(getContext(), this.l);
        layoutParams.width = b2;
        layoutParams.height = b2;
        this.f66765i.setLayoutParams(layoutParams);
        this.m.set(true);
    }

    private void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.f66759c = a(this.f66757a, this.f66760d, this.f66758b, this.k, !w(), this.t, this.u);
            m();
            this.p.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this) { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ NativeVideoTsView f66767a;

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
                    this.f66767a = this;
                }

                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        NativeVideoTsView nativeVideoTsView = this.f66767a;
                        ((g) nativeVideoTsView.f66759c).a(nativeVideoTsView.p.getWidth(), this.f66767a.p.getHeight());
                        this.f66767a.p.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    }
                }
            });
        }
    }

    private void m() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || (cVar = this.f66759c) == null) {
            return;
        }
        cVar.d(this.q);
        ((g) this.f66759c).a((g.a) this);
        this.f66759c.a(this);
    }

    private void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.o = null;
            j();
            o();
        }
    }

    private void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            if (!this.D.get()) {
                this.D.set(true);
                c cVar = this.f66759c;
                if (cVar != null) {
                    cVar.a(true, 3);
                }
            }
            this.G.set(false);
        }
    }

    private void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            c(y.a(this, 50, 5));
            this.y.sendEmptyMessageDelayed(1, 500L);
        }
    }

    private boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            if (w()) {
                return false;
            }
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_from_detail_page", false) || com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_isfromvideodetailpage", false);
        }
        return invokeV.booleanValue;
    }

    private void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65552, this) == null) || w()) {
            return;
        }
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_isfromvideodetailpage", Boolean.FALSE);
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_from_detail_page", Boolean.FALSE);
    }

    private void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            if (this.f66759c == null || w() || !com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_update_flag", false)) {
                return;
            }
            boolean a2 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_native_video_complete", false);
            long a3 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_current_play_position", -1L);
            long a4 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_total_play_duration", this.f66759c.q());
            long a5 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_duration", this.f66759c.t());
            this.f66759c.c(a2);
            if (a2) {
                this.f66759c.a(a5);
            } else {
                this.f66759c.a(a3);
            }
            this.f66759c.b(a4);
            this.f66759c.c(a5);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_update_flag", Boolean.FALSE);
            k.f("MultiProcess", "onResumeFeedNativeVideoControllerData-isComplete=" + a2 + ",position=" + a3 + ",totalPlayDuration=" + a4 + ",duration=" + a5);
        }
    }

    private boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) ? 2 == o.h().d(q.d(this.f66758b.ao())) : invokeV.booleanValue;
    }

    private boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) ? 5 == o.h().d(q.d(this.f66758b.ao())) : invokeV.booleanValue;
    }

    private boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, this)) == null) ? this.f66761e : invokeV.booleanValue;
    }

    private boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) ? this.r : invokeV.booleanValue;
    }

    private void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            s.e(this.f66764h);
            s.e(this.f66762f);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public void b() {
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (mVar = this.f66758b) == null) {
            return;
        }
        int d2 = q.d(mVar.ao());
        int d3 = o.h().d(d2);
        if (d3 == 1) {
            this.q = n.d(this.f66757a);
        } else if (d3 == 2) {
            this.q = n.e(this.f66757a) || n.d(this.f66757a) || n.f(this.f66757a);
        } else if (d3 == 3) {
            this.q = false;
        } else if (d3 == 4) {
            this.n = true;
        } else if (d3 == 5) {
            this.q = n.d(this.f66757a) || n.f(this.f66757a);
        }
        if (!this.r) {
            this.f66761e = o.h().b(d2);
        } else {
            this.f66761e = false;
        }
        if ("splash_ad".equals(this.k)) {
            this.q = true;
            this.f66761e = true;
        }
        c cVar = this.f66759c;
        if (cVar != null) {
            cVar.d(this.q);
        }
        if ("feed_video_middle_page".equals(this.k)) {
            this.q = true;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
    public void b(long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            c cVar = this.f66759c;
            if (cVar == null) {
                l();
            } else if ((cVar instanceof g) && !w()) {
                ((g) this.f66759c).g();
            }
            if (this.f66759c == null || !this.D.get()) {
                return;
            }
            this.D.set(false);
            b();
            if (i()) {
                s.a((View) this.f66762f, 8);
                ImageView imageView = this.f66764h;
                if (imageView != null) {
                    s.a((View) imageView, 8);
                }
                m mVar = this.f66758b;
                if (mVar != null && mVar.V() != null) {
                    com.bytedance.sdk.openadsdk.n.f.b bVar = new com.bytedance.sdk.openadsdk.n.f.b();
                    bVar.a(TextUtils.isEmpty(this.s) ? this.f66758b.V().i() : this.s);
                    bVar.d(this.f66758b.ak());
                    bVar.b(this.p.getWidth());
                    bVar.c(this.p.getHeight());
                    bVar.e(this.f66758b.ao());
                    bVar.a(0L);
                    bVar.a(v());
                    bVar.c(CacheDirConstants.getFeedCacheDir());
                    bVar.b(this.f66758b.V().l());
                    this.f66759c.a(bVar);
                    this.f66759c.c(false);
                    return;
                }
                k.f("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
            } else if (this.f66759c.x()) {
                k.b("NativeVideoAdView", "attachTask-mNativeVideoController.isPlayComplete()=" + this.f66759c.x());
                b(true);
            } else {
                k.c("NativeVideoAdView", "attachTask.......mRlImgCover.....VISIBLE");
                h();
                s.a((View) this.f66762f, 0);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.g.a
    public void g() {
        c.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (bVar = this.C) == null || this.F) {
            return;
        }
        this.F = true;
        bVar.e_();
    }

    public c getNativeVideoController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f66759c : (c) invokeV.objValue;
    }

    public void h() {
        ViewStub viewStub;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || this.f66757a == null || (viewStub = this.B) == null || viewStub.getParent() == null || this.f66758b == null || this.f66762f != null) {
            return;
        }
        this.f66762f = (RelativeLayout) this.B.inflate();
        this.f66763g = (ImageView) findViewById(t.e(this.f66757a, "tt_native_video_img_id"));
        ImageView imageView = (ImageView) findViewById(t.e(this.f66757a, "tt_native_video_play"));
        this.f66765i = imageView;
        if (this.f66766j) {
            s.a((View) imageView, 0);
        }
        if (this.f66758b.V() != null && this.f66758b.V().h() != null) {
            ImageLoaderWrapper.from(this.f66758b.V().h()).to(this.f66763g);
        }
        k();
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.q : invokeV.booleanValue;
    }

    public void j() {
        c cVar;
        i w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (cVar = this.f66759c) == null || (w = cVar.w()) == null) {
            return;
        }
        w.e();
        View s = w.s();
        if (s != null) {
            s.setVisibility(8);
            if (s.getParent() != null) {
                ((ViewGroup) s.getParent()).removeView(s);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onAttachedToWindow();
            d();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onDetachedFromWindow();
            n();
        }
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onFinishTemporaryDetach();
            d();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        a aVar;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, motionEvent)) == null) {
            if (!this.r && (aVar = this.o) != null && (cVar = this.f66759c) != null) {
                aVar.a(cVar.x(), this.f66759c.t(), this.f66759c.q(), this.f66759c.n(), this.q);
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onStartTemporaryDetach();
            n();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        c cVar;
        c cVar2;
        c cVar3;
        c cVar4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            super.onWindowFocusChanged(z);
            s();
            if (q() && (cVar4 = this.f66759c) != null && cVar4.x()) {
                r();
                s.a((View) this.f66762f, 8);
                b(true);
                e();
                return;
            }
            b();
            if (!w() && i() && (cVar2 = this.f66759c) != null && !cVar2.u()) {
                if (this.y != null) {
                    if (z && (cVar3 = this.f66759c) != null && !cVar3.x()) {
                        this.y.obtainMessage(1).sendToTarget();
                        return;
                    }
                    this.y.removeMessages(1);
                    c(false);
                }
            } else if (i()) {
            } else {
                if (!z && (cVar = this.f66759c) != null && cVar.v() != null && this.f66759c.v().g()) {
                    this.y.removeMessages(1);
                    c(false);
                } else if (z) {
                    this.y.obtainMessage(1).sendToTarget();
                }
            }
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        c cVar;
        m mVar;
        c cVar2;
        c cVar3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            super.onWindowVisibilityChanged(i2);
            s();
            if (this.E) {
                this.E = i2 == 0;
            }
            if (q() && (cVar3 = this.f66759c) != null && cVar3.x()) {
                r();
                s.a((View) this.f66762f, 8);
                b(true);
                e();
                return;
            }
            b();
            if (w() || !i() || (cVar = this.f66759c) == null || cVar.u() || (mVar = this.f66758b) == null) {
                return;
            }
            if (this.w && mVar.V() != null) {
                com.bytedance.sdk.openadsdk.n.f.b bVar = new com.bytedance.sdk.openadsdk.n.f.b();
                bVar.a(TextUtils.isEmpty(this.s) ? this.f66758b.V().i() : this.s);
                bVar.d(this.f66758b.ak());
                bVar.b(this.p.getWidth());
                bVar.c(this.p.getHeight());
                bVar.e(this.f66758b.ao());
                bVar.a(this.x);
                bVar.a(v());
                bVar.c(CacheDirConstants.getFeedCacheDir());
                bVar.b(this.f66758b.V().l());
                this.f66759c.a(bVar);
                this.w = false;
                s.a((View) this.f66762f, 8);
            } else {
                k.f("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
            }
            if (i2 != 0 || this.y == null || (cVar2 = this.f66759c) == null || cVar2.x()) {
                return;
            }
            this.y.obtainMessage(1).sendToTarget();
        }
    }

    public void setControllerStatusCallBack(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, aVar) == null) {
            this.o = aVar;
        }
    }

    public void setDrawVideoListener(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, drawVideoListener) == null) || (cVar = this.f66759c) == null) {
            return;
        }
        ((g) cVar).a(drawVideoListener);
    }

    public void setIsAutoPlay(boolean z) {
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048605, this, z) == null) || this.z || (mVar = this.f66758b) == null) {
            return;
        }
        int d2 = o.h().d(q.d(mVar.ao()));
        if (z && d2 != 4 && (!n.e(this.f66757a) ? !(!n.f(this.f66757a) ? n.d(this.f66757a) : t() || u()) : !t())) {
            z = false;
        }
        this.q = z;
        c cVar = this.f66759c;
        if (cVar != null) {
            cVar.d(z);
        }
        if (!this.q) {
            h();
            RelativeLayout relativeLayout = this.f66762f;
            if (relativeLayout != null) {
                s.a((View) relativeLayout, 0);
                if (this.f66758b.V() != null) {
                    ImageLoaderWrapper.from(this.f66758b.V().h()).to(this.f66763g);
                } else {
                    k.f("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
                }
            }
        } else {
            s.a((View) this.f66762f, 8);
        }
        this.z = true;
    }

    public void setIsQuiet(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.f66761e = z;
            c cVar = this.f66759c;
            if (cVar != null) {
                cVar.b(z);
            }
        }
    }

    public void setNativeVideoAdListener(c.a aVar) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, aVar) == null) || (cVar = this.f66759c) == null) {
            return;
        }
        cVar.a(aVar);
    }

    public void setNativeVideoController(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, cVar) == null) {
            this.f66759c = cVar;
        }
    }

    public void setNeedNativeVideoPlayBtnVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.f66766j = z;
        }
    }

    public void setVideoAdClickListener(b bVar) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, bVar) == null) || (cVar = this.f66759c) == null) {
            return;
        }
        ((g) cVar).a(bVar);
    }

    public void setVideoAdInteractionListener(c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, bVar) == null) {
            this.C = bVar;
        }
    }

    public void setVideoAdLoadListener(c.InterfaceC1907c interfaceC1907c) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, interfaceC1907c) == null) || (cVar = this.f66759c) == null) {
            return;
        }
        cVar.a(interfaceC1907c);
    }

    public void setVideoCacheUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            this.s = str;
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            super.setVisibility(i2);
            if (i2 == 4 || i2 == 8) {
                o();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NativeVideoTsView(@NonNull Context context, @NonNull m mVar, boolean z, boolean z2) {
        this(context, mVar, z, z2, "embeded_ad", false, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mVar, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (m) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), ((Boolean) objArr2[3]).booleanValue(), (String) objArr2[4], ((Boolean) objArr2[5]).booleanValue(), ((Boolean) objArr2[6]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
    public void a(long j2, int i2) {
        c.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) || (bVar = this.C) == null) {
            return;
        }
        bVar.h_();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NativeVideoTsView(@NonNull Context context, @NonNull m mVar, String str, boolean z, boolean z2) {
        this(context, mVar, false, false, str, z, z2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mVar, str, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (m) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), ((Boolean) objArr2[3]).booleanValue(), (String) objArr2[4], ((Boolean) objArr2[5]).booleanValue(), ((Boolean) objArr2[6]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeVideoTsView(@NonNull Context context, @NonNull m mVar, boolean z, boolean z2, String str, boolean z3, boolean z4) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mVar, Boolean.valueOf(z), Boolean.valueOf(z2), str, Boolean.valueOf(z3), Boolean.valueOf(z4)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.q = true;
        this.f66761e = true;
        this.r = false;
        this.t = false;
        this.u = true;
        this.v = false;
        this.f66766j = true;
        this.k = "embeded_ad";
        this.l = 50;
        this.w = true;
        this.m = new AtomicBoolean(false);
        this.y = new w(this);
        this.z = false;
        this.A = Build.MODEL;
        this.n = false;
        this.D = new AtomicBoolean(false);
        this.E = true;
        this.G = new AtomicBoolean(false);
        this.k = str;
        this.f66757a = context;
        this.f66758b = mVar;
        this.r = z;
        this.v = z2;
        this.t = z3;
        this.u = z4;
        setContentDescription("NativeVideoAdView");
        b();
        f();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
    public void a(long j2, long j3) {
        c.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) || (bVar = this.C) == null) {
            return;
        }
        bVar.a(j2, j3);
    }

    private View a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context)) == null) {
            FrameLayout frameLayout = new FrameLayout(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            frameLayout.setId(t.e(this.f66757a, "tt_native_video_layout"));
            layoutParams.gravity = 17;
            frameLayout.setVisibility(8);
            this.p = frameLayout;
            FrameLayout frameLayout2 = new FrameLayout(context);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            frameLayout2.setId(t.e(this.f66757a, "tt_native_video_frame"));
            layoutParams2.gravity = 17;
            frameLayout2.setLayoutParams(layoutParams2);
            frameLayout.addView(frameLayout2);
            this.f66760d = frameLayout2;
            ViewStub viewStub = new ViewStub(context);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            viewStub.setId(t.e(this.f66757a, "tt_native_video_img_cover_viewStub"));
            viewStub.setLayoutResource(t.f(this.f66757a, "tt_native_video_img_cover_layout"));
            viewStub.setLayoutParams(layoutParams3);
            frameLayout.addView(viewStub);
            this.B = viewStub;
            return frameLayout;
        }
        return (View) invokeL.objValue;
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || n.c(o.a()) == 0) {
            return;
        }
        if (this.f66759c.v() != null) {
            if (this.f66759c.v().g() && i2 == 2) {
                c(false);
                w wVar = this.y;
                if (wVar != null) {
                    wVar.removeMessages(1);
                }
                a(true);
                return;
            } else if (this.f66759c.v().i() && i2 == 3) {
                this.q = true;
                c(true);
                b();
                w wVar2 = this.y;
                if (wVar2 != null) {
                    wVar2.sendEmptyMessageDelayed(1, 500L);
                }
                a(false);
                return;
            }
        }
        if (i() || this.G.get()) {
            return;
        }
        this.G.set(true);
        m mVar = this.f66758b;
        if (mVar != null && mVar.V() != null) {
            x();
            com.bytedance.sdk.openadsdk.n.f.b bVar = new com.bytedance.sdk.openadsdk.n.f.b();
            bVar.a(TextUtils.isEmpty(this.s) ? this.f66758b.V().i() : this.s);
            bVar.d(this.f66758b.ak());
            bVar.b(this.p.getWidth());
            bVar.c(this.p.getHeight());
            bVar.e(this.f66758b.ao());
            bVar.a(this.x);
            bVar.a(v());
            bVar.c(CacheDirConstants.getFeedCacheDir());
            bVar.b(this.f66758b.V().l());
            this.f66759c.a(bVar);
        } else {
            k.f("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
        }
        w wVar3 = this.y;
        if (wVar3 != null) {
            wVar3.sendEmptyMessageDelayed(1, 500L);
        }
        a(false);
    }

    public c a(Context context, ViewGroup viewGroup, m mVar, String str, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, viewGroup, mVar, str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) ? new g(context, viewGroup, mVar, str, z, z2, z3) : (c) invokeCommon.objValue;
    }

    public boolean a(long j2, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            boolean z3 = false;
            this.p.setVisibility(0);
            if (this.f66759c == null) {
                this.f66759c = new g(this.f66757a, this.f66760d, this.f66758b, this.k, this.t, this.u);
                m();
            }
            this.x = j2;
            if (w()) {
                this.f66759c.a(false);
                m mVar = this.f66758b;
                if (mVar != null && mVar.V() != null) {
                    com.bytedance.sdk.openadsdk.n.f.b bVar = new com.bytedance.sdk.openadsdk.n.f.b();
                    bVar.a(TextUtils.isEmpty(this.s) ? this.f66758b.V().i() : this.s);
                    bVar.d(this.f66758b.ak());
                    bVar.b(this.p.getWidth());
                    bVar.c(this.p.getHeight());
                    bVar.e(this.f66758b.ao());
                    bVar.a(j2);
                    bVar.a(v());
                    bVar.c(CacheDirConstants.getFeedCacheDir());
                    bVar.b(this.f66758b.V().l());
                    z3 = this.f66759c.a(bVar);
                }
                int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
                if (((i2 > 0 && !z && !z2) || (i2 > 0 && z && !this.v)) && this.f66759c != null) {
                    o.a aVar = new o.a();
                    aVar.a(this.f66759c.n());
                    aVar.c(this.f66759c.q());
                    aVar.b(this.f66759c.o());
                    com.bytedance.sdk.openadsdk.e.a.a.c(this.f66757a, this.f66759c.w(), aVar);
                }
                return z3;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || n.c(com.bytedance.sdk.openadsdk.core.o.a()) == 0) {
            return;
        }
        if (this.f66759c.v() != null) {
            if (this.f66759c.v().g()) {
                c(false);
                w wVar = this.y;
                if (wVar != null) {
                    wVar.removeMessages(1);
                }
                a(true);
                return;
            } else if (this.f66759c.v().i()) {
                this.q = true;
                c(true);
                b();
                w wVar2 = this.y;
                if (wVar2 != null) {
                    wVar2.sendEmptyMessageDelayed(1, 500L);
                }
                a(false);
                return;
            }
        }
        if (i() || this.G.get()) {
            return;
        }
        this.G.set(true);
        m mVar = this.f66758b;
        if (mVar != null && mVar.V() != null) {
            x();
            com.bytedance.sdk.openadsdk.n.f.b bVar = new com.bytedance.sdk.openadsdk.n.f.b();
            bVar.a(TextUtils.isEmpty(this.s) ? this.f66758b.V().i() : this.s);
            bVar.a(this.f66758b.V().i());
            bVar.d(this.f66758b.ak());
            bVar.b(this.p.getWidth());
            bVar.c(this.p.getHeight());
            bVar.e(this.f66758b.ao());
            bVar.a(this.x);
            bVar.a(v());
            bVar.c(CacheDirConstants.getFeedCacheDir());
            bVar.b(this.f66758b.V().l());
            this.f66759c.a(bVar);
        } else {
            k.f("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
        }
        w wVar3 = this.y;
        if (wVar3 != null) {
            wVar3.sendEmptyMessageDelayed(1, 500L);
        }
        a(false);
    }

    public void b(boolean z) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (cVar = this.f66759c) == null) {
            return;
        }
        cVar.c(z);
        i w = this.f66759c.w();
        if (w != null) {
            w.w();
            View s = w.s();
            if (s != null) {
                if (s.getParent() != null) {
                    ((ViewGroup) s.getParent()).removeView(s);
                }
                s.setVisibility(0);
                addView(s);
                w.a(this.f66758b, new WeakReference<>(this.f66757a), false);
            }
        }
    }

    @Override // com.bytedance.sdk.component.utils.w.a
    public void a(Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, message) == null) && message.what == 1) {
            p();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.g.a
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            b();
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (this.f66764h == null) {
                this.f66764h = new ImageView(getContext());
                if (com.bytedance.sdk.openadsdk.core.h.d().v() != null) {
                    this.f66764h.setImageBitmap(com.bytedance.sdk.openadsdk.core.h.d().v());
                } else {
                    this.f66764h.setImageResource(t.d(com.bytedance.sdk.openadsdk.core.o.a(), "tt_new_play_video"));
                }
                this.f66764h.setScaleType(ImageView.ScaleType.FIT_XY);
                int b2 = (int) s.b(getContext(), this.l);
                int b3 = (int) s.b(getContext(), 10.0f);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(b2, b2);
                layoutParams.gravity = 17;
                layoutParams.rightMargin = b3;
                layoutParams.bottomMargin = b3;
                this.p.addView(this.f66764h, layoutParams);
            }
            if (z) {
                this.f66764h.setVisibility(0);
            } else {
                this.f66764h.setVisibility(8);
            }
        }
    }

    public void a(int i2, int i3) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) || (cVar = this.f66759c) == null) {
            return;
        }
        ((g) cVar).a(i2, i3);
    }
}
