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
import com.bytedance.sdk.component.utils.j;
import com.bytedance.sdk.component.utils.r;
import com.bytedance.sdk.component.utils.u;
import com.bytedance.sdk.openadsdk.CacheDirConstants;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.g;
import com.bytedance.sdk.openadsdk.core.y;
import com.bytedance.sdk.openadsdk.r.q;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes5.dex */
public class NativeVideoTsView extends FrameLayout implements u.a, c.a, g.a {
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
    public final Context f30651a;

    /* renamed from: b  reason: collision with root package name */
    public final m f30652b;

    /* renamed from: c  reason: collision with root package name */
    public c f30653c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f30654d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30655e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f30656f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f30657g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f30658h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f30659i;
    public boolean j;
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
    public final u y;
    public boolean z;

    /* loaded from: classes5.dex */
    public interface a {
        void a(boolean z, long j, long j2, long j3, boolean z2);
    }

    /* loaded from: classes5.dex */
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
        if (!(interceptable == null || interceptable.invokeZ(AdIconUtil.BAIDU_LOGO_ID, this, z) == null) || this.f30652b == null || this.f30653c == null) {
            return;
        }
        boolean q = q();
        r();
        if (q && this.f30653c.w()) {
            j.b("NativeVideoAdView", "changeVideoStatus---isFromDetailPage()=" + q + "，mNativeVideoController.isPlayComplete()=" + this.f30653c.w());
            b(true);
            e();
        } else if (z && !this.f30653c.w() && !this.f30653c.t()) {
            if (this.f30653c.u() != null && this.f30653c.u().i()) {
                if (this.q) {
                    if ("ALP-AL00".equals(this.A)) {
                        this.f30653c.k();
                    } else {
                        ((g) this.f30653c).g(q);
                    }
                    c.b bVar = this.C;
                    if (bVar != null) {
                        bVar.g_();
                    }
                }
            } else if (this.q && this.f30653c.u() == null) {
                if (!this.D.get()) {
                    this.D.set(true);
                }
                this.G.set(false);
                d();
            }
        } else if (this.f30653c.u() == null || !this.f30653c.u().g()) {
        } else {
            this.f30653c.i();
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
            addView(a(this.f30651a));
            l();
        }
    }

    private void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || !(this instanceof NativeDrawVideoTsView) || this.m.get() || com.bytedance.sdk.openadsdk.core.h.d().v() == null) {
            return;
        }
        this.f30659i.setImageBitmap(com.bytedance.sdk.openadsdk.core.h.d().v());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f30659i.getLayoutParams();
        int b2 = (int) q.b(getContext(), this.l);
        layoutParams.width = b2;
        layoutParams.height = b2;
        this.f30659i.setLayoutParams(layoutParams);
        this.m.set(true);
    }

    private void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.f30653c = a(this.f30651a, this.f30654d, this.f30652b, this.k, !w(), this.t, this.u);
            m();
            this.p.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this) { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ NativeVideoTsView f30660a;

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
                    this.f30660a = this;
                }

                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        NativeVideoTsView nativeVideoTsView = this.f30660a;
                        ((g) nativeVideoTsView.f30653c).a(nativeVideoTsView.p.getWidth(), this.f30660a.p.getHeight());
                        this.f30660a.p.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    }
                }
            });
        }
    }

    private void m() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || (cVar = this.f30653c) == null) {
            return;
        }
        cVar.e(this.q);
        ((g) this.f30653c).a((g.a) this);
        this.f30653c.a(this);
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
                c cVar = this.f30653c;
                if (cVar != null) {
                    cVar.a(true);
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
            if (this.f30653c == null || w() || !com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_update_flag", false)) {
                return;
            }
            boolean a2 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_native_video_complete", false);
            long a3 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_current_play_position", -1L);
            long a4 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_total_play_duration", this.f30653c.p());
            long a5 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_duration", this.f30653c.s());
            this.f30653c.d(a2);
            if (a2) {
                this.f30653c.a(a5);
            } else {
                this.f30653c.a(a3);
            }
            this.f30653c.b(a4);
            this.f30653c.c(a5);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_update_flag", Boolean.FALSE);
            j.f("MultiProcess", "onResumeFeedNativeVideoControllerData-isComplete=" + a2 + ",position=" + a3 + ",totalPlayDuration=" + a4 + ",duration=" + a5);
        }
    }

    private boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) ? 2 == o.h().d(com.bytedance.sdk.openadsdk.r.o.d(this.f30652b.ao())) : invokeV.booleanValue;
    }

    private boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) ? 5 == o.h().d(com.bytedance.sdk.openadsdk.r.o.d(this.f30652b.ao())) : invokeV.booleanValue;
    }

    private boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, this)) == null) ? this.f30655e : invokeV.booleanValue;
    }

    private boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) ? this.r : invokeV.booleanValue;
    }

    private void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            q.e(this.f30658h);
            q.e(this.f30656f);
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
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (mVar = this.f30652b) == null) {
            return;
        }
        int d2 = com.bytedance.sdk.openadsdk.r.o.d(mVar.ao());
        int d3 = o.h().d(d2);
        if (d3 == 1) {
            this.q = com.bytedance.sdk.component.utils.m.d(this.f30651a);
        } else if (d3 == 2) {
            this.q = com.bytedance.sdk.component.utils.m.e(this.f30651a) || com.bytedance.sdk.component.utils.m.d(this.f30651a) || com.bytedance.sdk.component.utils.m.f(this.f30651a);
        } else if (d3 == 3) {
            this.q = false;
        } else if (d3 == 4) {
            this.n = true;
        } else if (d3 == 5) {
            this.q = com.bytedance.sdk.component.utils.m.d(this.f30651a) || com.bytedance.sdk.component.utils.m.f(this.f30651a);
        }
        if (!this.r) {
            this.f30655e = o.h().b(d2);
        } else {
            this.f30655e = false;
        }
        if ("splash_ad".equals(this.k)) {
            this.q = true;
            this.f30655e = true;
        }
        c cVar = this.f30653c;
        if (cVar != null) {
            cVar.e(this.q);
        }
        if ("feed_video_middle_page".equals(this.k)) {
            this.q = true;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
    public void b(long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)}) == null) {
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            c cVar = this.f30653c;
            if (cVar == null) {
                l();
            } else if ((cVar instanceof g) && !w()) {
                ((g) this.f30653c).y();
            }
            if (this.f30653c == null || !this.D.get()) {
                return;
            }
            this.D.set(false);
            b();
            if (i()) {
                q.a((View) this.f30656f, 8);
                ImageView imageView = this.f30658h;
                if (imageView != null) {
                    q.a((View) imageView, 8);
                }
                m mVar = this.f30652b;
                if (mVar != null && mVar.V() != null) {
                    com.bytedance.sdk.openadsdk.o.f.b bVar = new com.bytedance.sdk.openadsdk.o.f.b();
                    bVar.a(TextUtils.isEmpty(this.s) ? this.f30652b.V().i() : this.s);
                    bVar.d(this.f30652b.ak());
                    bVar.b(this.p.getWidth());
                    bVar.c(this.p.getHeight());
                    bVar.e(this.f30652b.ao());
                    bVar.a(0L);
                    bVar.a(v());
                    bVar.c(CacheDirConstants.getFeedCacheDir());
                    bVar.b(this.f30652b.V().l());
                    this.f30653c.a(bVar);
                    this.f30653c.d(false);
                    return;
                }
                j.f("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
            } else if (this.f30653c.w()) {
                j.b("NativeVideoAdView", "attachTask-mNativeVideoController.isPlayComplete()=" + this.f30653c.w());
                b(true);
            } else {
                j.c("NativeVideoAdView", "attachTask.......mRlImgCover.....VISIBLE");
                h();
                q.a((View) this.f30656f, 0);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f30653c : (c) invokeV.objValue;
    }

    public void h() {
        ViewStub viewStub;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || this.f30651a == null || (viewStub = this.B) == null || viewStub.getParent() == null || this.f30652b == null || this.f30656f != null) {
            return;
        }
        this.f30656f = (RelativeLayout) this.B.inflate();
        this.f30657g = (ImageView) findViewById(r.e(this.f30651a, "tt_native_video_img_id"));
        ImageView imageView = (ImageView) findViewById(r.e(this.f30651a, "tt_native_video_play"));
        this.f30659i = imageView;
        if (this.j) {
            q.a((View) imageView, 0);
        }
        if (this.f30652b.V() != null && this.f30652b.V().h() != null) {
            com.bytedance.sdk.openadsdk.g.a.a(this.f30652b.V().h()).a(this.f30657g);
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
        i v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (cVar = this.f30653c) == null || (v = cVar.v()) == null) {
            return;
        }
        v.e();
        View s = v.s();
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
            if (!this.r && (aVar = this.o) != null && (cVar = this.f30653c) != null) {
                aVar.a(cVar.w(), this.f30653c.s(), this.f30653c.p(), this.f30653c.n(), this.q);
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
            if (q() && (cVar4 = this.f30653c) != null && cVar4.w()) {
                r();
                q.a((View) this.f30656f, 8);
                b(true);
                e();
                return;
            }
            b();
            if (!w() && i() && (cVar2 = this.f30653c) != null && !cVar2.t()) {
                if (this.y != null) {
                    if (z && (cVar3 = this.f30653c) != null && !cVar3.w()) {
                        this.y.obtainMessage(1).sendToTarget();
                        return;
                    }
                    this.y.removeMessages(1);
                    c(false);
                }
            } else if (i()) {
            } else {
                if (!z && (cVar = this.f30653c) != null && cVar.u() != null && this.f30653c.u().g()) {
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
            if (q() && (cVar3 = this.f30653c) != null && cVar3.w()) {
                r();
                q.a((View) this.f30656f, 8);
                b(true);
                e();
                return;
            }
            b();
            if (w() || !i() || (cVar = this.f30653c) == null || cVar.t() || (mVar = this.f30652b) == null) {
                return;
            }
            if (this.w && mVar.V() != null) {
                com.bytedance.sdk.openadsdk.o.f.b bVar = new com.bytedance.sdk.openadsdk.o.f.b();
                bVar.a(TextUtils.isEmpty(this.s) ? this.f30652b.V().i() : this.s);
                bVar.d(this.f30652b.ak());
                bVar.b(this.p.getWidth());
                bVar.c(this.p.getHeight());
                bVar.e(this.f30652b.ao());
                bVar.a(this.x);
                bVar.a(v());
                bVar.c(CacheDirConstants.getFeedCacheDir());
                bVar.b(this.f30652b.V().l());
                this.f30653c.a(bVar);
                this.w = false;
                q.a((View) this.f30656f, 8);
            } else {
                j.f("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
            }
            if (i2 != 0 || this.y == null || (cVar2 = this.f30653c) == null || cVar2.w()) {
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
        if (!(interceptable == null || interceptable.invokeL(1048604, this, drawVideoListener) == null) || (cVar = this.f30653c) == null) {
            return;
        }
        ((g) cVar).a(drawVideoListener);
    }

    public void setIsAutoPlay(boolean z) {
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048605, this, z) == null) || this.z || (mVar = this.f30652b) == null) {
            return;
        }
        int d2 = o.h().d(com.bytedance.sdk.openadsdk.r.o.d(mVar.ao()));
        if (z && d2 != 4 && (!com.bytedance.sdk.component.utils.m.e(this.f30651a) ? !(!com.bytedance.sdk.component.utils.m.f(this.f30651a) ? com.bytedance.sdk.component.utils.m.d(this.f30651a) : t() || u()) : !t())) {
            z = false;
        }
        this.q = z;
        c cVar = this.f30653c;
        if (cVar != null) {
            cVar.e(z);
        }
        if (!this.q) {
            h();
            RelativeLayout relativeLayout = this.f30656f;
            if (relativeLayout != null) {
                q.a((View) relativeLayout, 0);
                if (this.f30652b.V() != null) {
                    com.bytedance.sdk.openadsdk.g.a.a(this.f30652b.V().h()).a(this.f30657g);
                } else {
                    j.f("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
                }
            }
        } else {
            q.a((View) this.f30656f, 8);
        }
        this.z = true;
    }

    public void setIsQuiet(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.f30655e = z;
            c cVar = this.f30653c;
            if (cVar != null) {
                cVar.c(z);
            }
        }
    }

    public void setNativeVideoAdListener(c.a aVar) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, aVar) == null) || (cVar = this.f30653c) == null) {
            return;
        }
        cVar.a(aVar);
    }

    public void setNativeVideoController(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, cVar) == null) {
            this.f30653c = cVar;
        }
    }

    public void setNeedNativeVideoPlayBtnVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.j = z;
        }
    }

    public void setVideoAdClickListener(b bVar) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, bVar) == null) || (cVar = this.f30653c) == null) {
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

    public void setVideoAdLoadListener(c.InterfaceC0345c interfaceC0345c) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, interfaceC0345c) == null) || (cVar = this.f30653c) == null) {
            return;
        }
        cVar.a(interfaceC0345c);
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
    public void a(long j, int i2) {
        c.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)}) == null) || (bVar = this.C) == null) {
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
        this.f30655e = true;
        this.r = false;
        this.t = false;
        this.u = true;
        this.v = false;
        this.j = true;
        this.k = "embeded_ad";
        this.l = 50;
        this.w = true;
        this.m = new AtomicBoolean(false);
        this.y = new u(this);
        this.z = false;
        this.A = Build.MODEL;
        this.n = false;
        this.D = new AtomicBoolean(false);
        this.E = true;
        this.G = new AtomicBoolean(false);
        this.k = str;
        this.f30651a = context;
        this.f30652b = mVar;
        this.r = z;
        this.v = z2;
        this.t = z3;
        this.u = z4;
        setContentDescription("NativeVideoAdView");
        b();
        f();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
    public void a(long j, long j2) {
        c.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) || (bVar = this.C) == null) {
            return;
        }
        bVar.a(j, j2);
    }

    private View a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context)) == null) {
            FrameLayout frameLayout = new FrameLayout(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            frameLayout.setId(r.e(this.f30651a, "tt_native_video_layout"));
            layoutParams.gravity = 17;
            frameLayout.setVisibility(8);
            this.p = frameLayout;
            FrameLayout frameLayout2 = new FrameLayout(context);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            frameLayout2.setId(r.e(this.f30651a, "tt_native_video_frame"));
            layoutParams2.gravity = 17;
            frameLayout2.setLayoutParams(layoutParams2);
            frameLayout.addView(frameLayout2);
            this.f30654d = frameLayout2;
            ViewStub viewStub = new ViewStub(context);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            viewStub.setId(r.e(this.f30651a, "tt_native_video_img_cover_viewStub"));
            viewStub.setLayoutResource(r.f(this.f30651a, "tt_native_video_img_cover_layout"));
            viewStub.setLayoutParams(layoutParams3);
            frameLayout.addView(viewStub);
            this.B = viewStub;
            return frameLayout;
        }
        return (View) invokeL.objValue;
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || com.bytedance.sdk.component.utils.m.c(o.a()) == 0) {
            return;
        }
        if (this.f30653c.u() != null) {
            if (this.f30653c.u().g() && i2 == 2) {
                c(false);
                u uVar = this.y;
                if (uVar != null) {
                    uVar.removeMessages(1);
                }
                a(true);
                return;
            } else if (this.f30653c.u().i() && i2 == 3) {
                this.q = true;
                c(true);
                b();
                u uVar2 = this.y;
                if (uVar2 != null) {
                    uVar2.sendEmptyMessageDelayed(1, 500L);
                }
                a(false);
                return;
            }
        }
        if (i() || this.G.get()) {
            return;
        }
        this.G.set(true);
        m mVar = this.f30652b;
        if (mVar != null && mVar.V() != null) {
            x();
            com.bytedance.sdk.openadsdk.o.f.b bVar = new com.bytedance.sdk.openadsdk.o.f.b();
            bVar.a(TextUtils.isEmpty(this.s) ? this.f30652b.V().i() : this.s);
            bVar.d(this.f30652b.ak());
            bVar.b(this.p.getWidth());
            bVar.c(this.p.getHeight());
            bVar.e(this.f30652b.ao());
            bVar.a(this.x);
            bVar.a(v());
            bVar.c(CacheDirConstants.getFeedCacheDir());
            bVar.b(this.f30652b.V().l());
            this.f30653c.a(bVar);
        } else {
            j.f("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
        }
        u uVar3 = this.y;
        if (uVar3 != null) {
            uVar3.sendEmptyMessageDelayed(1, 500L);
        }
        a(false);
    }

    public c a(Context context, ViewGroup viewGroup, m mVar, String str, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, viewGroup, mVar, str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) ? new g(context, viewGroup, mVar, str, z, z2, z3) : (c) invokeCommon.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || com.bytedance.sdk.component.utils.m.c(o.a()) == 0) {
            return;
        }
        if (this.f30653c.u() != null) {
            if (this.f30653c.u().g()) {
                c(false);
                u uVar = this.y;
                if (uVar != null) {
                    uVar.removeMessages(1);
                }
                a(true);
                return;
            } else if (this.f30653c.u().i()) {
                this.q = true;
                c(true);
                b();
                u uVar2 = this.y;
                if (uVar2 != null) {
                    uVar2.sendEmptyMessageDelayed(1, 500L);
                }
                a(false);
                return;
            }
        }
        if (i() || this.G.get()) {
            return;
        }
        this.G.set(true);
        m mVar = this.f30652b;
        if (mVar != null && mVar.V() != null) {
            x();
            com.bytedance.sdk.openadsdk.o.f.b bVar = new com.bytedance.sdk.openadsdk.o.f.b();
            bVar.a(TextUtils.isEmpty(this.s) ? this.f30652b.V().i() : this.s);
            bVar.a(this.f30652b.V().i());
            bVar.d(this.f30652b.ak());
            bVar.b(this.p.getWidth());
            bVar.c(this.p.getHeight());
            bVar.e(this.f30652b.ao());
            bVar.a(this.x);
            bVar.a(v());
            bVar.c(CacheDirConstants.getFeedCacheDir());
            bVar.b(this.f30652b.V().l());
            this.f30653c.a(bVar);
        } else {
            j.f("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
        }
        u uVar3 = this.y;
        if (uVar3 != null) {
            uVar3.sendEmptyMessageDelayed(1, 500L);
        }
        a(false);
    }

    public boolean a(long j, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        boolean z3;
        long j2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            this.p.setVisibility(0);
            if (this.f30653c == null) {
                this.f30653c = new g(this.f30651a, this.f30654d, this.f30652b, this.k, this.t, this.u);
                m();
            }
            this.x = j;
            if (w()) {
                this.f30653c.b(false);
                m mVar = this.f30652b;
                if (mVar == null || mVar.V() == null) {
                    z3 = false;
                } else {
                    com.bytedance.sdk.openadsdk.o.f.b bVar = new com.bytedance.sdk.openadsdk.o.f.b();
                    bVar.a(TextUtils.isEmpty(this.s) ? this.f30652b.V().i() : this.s);
                    bVar.d(this.f30652b.ak());
                    bVar.b(this.p.getWidth());
                    bVar.c(this.p.getHeight());
                    bVar.e(this.f30652b.ao());
                    bVar.a(j);
                    bVar.a(v());
                    bVar.c(CacheDirConstants.getFeedCacheDir());
                    bVar.b(this.f30652b.V().l());
                    z3 = this.f30653c.a(bVar);
                }
                int i3 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                if ((i3 > 0 && !z && !z2) || (i3 > 0 && z && !this.v)) {
                    c cVar = this.f30653c;
                    if (cVar != null) {
                        long p = cVar.p();
                        i2 = this.f30653c.r();
                        j2 = p;
                    } else {
                        j2 = 0;
                        i2 = 0;
                    }
                    com.bytedance.sdk.openadsdk.e.d.a(this.f30651a, this.f30652b, this.k, "feed_continue", j2, i2, com.bytedance.sdk.openadsdk.r.o.a(this.f30652b, this.f30653c.o(), this.f30653c.u()));
                }
                return z3;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.bytedance.sdk.component.utils.u.a
    public void a(Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, message) == null) && message.what == 1) {
            p();
        }
    }

    public void b(boolean z) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (cVar = this.f30653c) == null) {
            return;
        }
        cVar.d(z);
        i v = this.f30653c.v();
        if (v != null) {
            v.w();
            View s = v.s();
            if (s != null) {
                if (s.getParent() != null) {
                    ((ViewGroup) s.getParent()).removeView(s);
                }
                s.setVisibility(0);
                addView(s);
                v.a(this.f30652b, new WeakReference<>(this.f30651a), false);
            }
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
            if (this.f30658h == null) {
                this.f30658h = new ImageView(getContext());
                if (com.bytedance.sdk.openadsdk.core.h.d().v() != null) {
                    this.f30658h.setImageBitmap(com.bytedance.sdk.openadsdk.core.h.d().v());
                } else {
                    this.f30658h.setImageResource(r.d(o.a(), "tt_new_play_video"));
                }
                this.f30658h.setScaleType(ImageView.ScaleType.FIT_XY);
                int b2 = (int) q.b(getContext(), this.l);
                int b3 = (int) q.b(getContext(), 10.0f);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(b2, b2);
                layoutParams.gravity = 17;
                layoutParams.rightMargin = b3;
                layoutParams.bottomMargin = b3;
                this.p.addView(this.f30658h, layoutParams);
            }
            if (z) {
                this.f30658h.setVisibility(0);
            } else {
                this.f30658h.setVisibility(8);
            }
        }
    }

    public void a(int i2, int i3) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) || (cVar = this.f30653c) == null) {
            return;
        }
        ((g) cVar).a(i2, i3);
    }
}
