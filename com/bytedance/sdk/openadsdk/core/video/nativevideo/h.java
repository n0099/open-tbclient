package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
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
import com.bytedance.sdk.openadsdk.core.e.m;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.b;
import com.bytedance.sdk.openadsdk.img.ImageLoaderWrapper;
import com.bytedance.sdk.openadsdk.q.s;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumSet;
import java.util.Locale;
/* loaded from: classes9.dex */
public class h extends i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView J;
    public ImageView K;
    public View L;
    public TextView M;
    public TextView N;
    public TextView O;
    public ImageView P;
    public View Q;
    public ImageView R;
    public TextView S;
    public View T;
    public SeekBar U;
    public TextView V;
    public TextView W;
    public ImageView X;
    public final w Y;
    public boolean Z;
    public boolean aA;
    public boolean aB;
    public boolean aa;
    public int ab;
    public int ac;
    public int ad;
    public int ae;
    public int af;
    public final Rect ag;
    public ColorStateList ah;
    public float ai;
    public final Rect aj;
    public int ak;
    public boolean al;
    public int am;
    public int an;
    public com.bytedance.sdk.openadsdk.core.widget.h ao;
    public boolean ap;
    public final View.OnTouchListener aq;
    public float ar;
    public ColorStateList as;
    public float at;
    public final Rect au;
    public float av;
    public ColorStateList aw;
    public float ax;
    public final Rect ay;
    public final Rect az;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Context context, View view, boolean z, EnumSet<b.a> enumSet, m mVar, c cVar, boolean z2) {
        super(context, view, z, enumSet, mVar, cVar, z2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context, view, Boolean.valueOf(z), enumSet, mVar, cVar, Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (View) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), (EnumSet) objArr2[3], (m) objArr2[4], (c) objArr2[5], ((Boolean) objArr2[6]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.Y = new w(this);
        this.Z = false;
        this.aa = false;
        this.ab = 0;
        this.ac = 0;
        this.ad = 0;
        this.ae = 0;
        this.af = 0;
        this.ag = new Rect();
        this.aj = new Rect();
        this.ak = 0;
        this.am = 0;
        this.an = 0;
        this.ao = null;
        this.ap = false;
        this.aq = new View.OnTouchListener(this) { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.h.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ h f67180a;

            /* renamed from: b  reason: collision with root package name */
            public float f67181b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f67180a = this;
            }

            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, motionEvent)) == null) {
                    float x = motionEvent.getX();
                    int actionMasked = motionEvent.getActionMasked();
                    if (actionMasked != 0) {
                        if (actionMasked == 1) {
                            this.f67180a.ap = Math.abs(this.f67181b - motionEvent.getX()) < 10.0f;
                        } else if (actionMasked == 2) {
                            view2.getParent().requestDisallowInterceptTouchEvent(true);
                        } else if (actionMasked == 3) {
                            view2.getParent().requestDisallowInterceptTouchEvent(false);
                        }
                    } else {
                        this.f67181b = x;
                    }
                    return false;
                }
                return invokeLL.booleanValue;
            }
        };
        this.au = new Rect();
        this.ay = new Rect();
        this.az = new Rect();
        this.z = o.a().getApplicationContext();
        c(z2);
        this.f67183a = view;
        this.u = z;
        com.bytedance.sdk.openadsdk.core.widget.h hVar = new com.bytedance.sdk.openadsdk.core.widget.h(this);
        this.ao = hVar;
        hVar.a(this.u);
        DisplayMetrics displayMetrics = this.z.getResources().getDisplayMetrics();
        this.am = displayMetrics.widthPixels;
        this.an = displayMetrics.heightPixels;
        this.x = enumSet == null ? EnumSet.noneOf(b.a.class) : enumSet;
        this.E = cVar;
        this.y = mVar;
        c(8);
        a(context, this.f67183a);
        a();
        n();
    }

    private void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            DisplayMetrics displayMetrics = this.z.getResources().getDisplayMetrics();
            TextView textView = this.W;
            if (textView != null) {
                this.ar = textView.getTextSize();
                this.W.setTextSize(2, 14.0f);
                ColorStateList textColors = this.W.getTextColors();
                this.as = textColors;
                if (textColors != null) {
                    this.W.setTextColor(t.i(this.z, "tt_ssxinzi15"));
                }
                this.at = this.W.getAlpha();
                this.W.setAlpha(0.85f);
                this.W.setShadowLayer(0.0f, s.b(this.z, 0.5f), s.b(this.z, 0.5f), t.i(this.z, "tt_video_shaoow_color_fullscreen"));
                ViewGroup.LayoutParams layoutParams = this.W.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    this.au.set(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    s.b(this.W, (int) TypedValue.applyDimension(1, 16.0f, displayMetrics), this.au.top, (int) TypedValue.applyDimension(1, 14.0f, displayMetrics), this.au.bottom);
                }
            }
            TextView textView2 = this.V;
            if (textView2 != null) {
                this.av = textView2.getTextSize();
                this.V.setTextSize(2, 14.0f);
                ColorStateList textColors2 = this.V.getTextColors();
                this.aw = textColors2;
                if (textColors2 != null) {
                    this.V.setTextColor(t.i(this.z, "tt_ssxinzi15"));
                }
                this.ax = this.V.getAlpha();
                this.V.setAlpha(0.85f);
                this.V.setShadowLayer(0.0f, s.b(this.z, 0.5f), s.b(this.z, 0.5f), t.i(this.z, "tt_video_shaoow_color_fullscreen"));
                ViewGroup.LayoutParams layoutParams2 = this.V.getLayoutParams();
                if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                    this.ay.set(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                    Rect rect = this.ay;
                    s.b(this.V, (int) TypedValue.applyDimension(1, 14.0f, displayMetrics), rect.top, rect.right, rect.bottom);
                }
            }
            ImageView imageView = this.X;
            if (imageView != null) {
                ViewGroup.LayoutParams layoutParams3 = imageView.getLayoutParams();
                if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                    this.az.set(marginLayoutParams3.leftMargin, marginLayoutParams3.topMargin, marginLayoutParams3.rightMargin, marginLayoutParams3.bottomMargin);
                    ImageView imageView2 = this.X;
                    Rect rect2 = this.az;
                    s.b(imageView2, rect2.left, rect2.top, (int) TypedValue.applyDimension(1, 16.0f, displayMetrics), this.az.bottom);
                }
            }
            ImageView imageView3 = this.X;
            if (imageView3 != null) {
                imageView3.setImageDrawable(t.c(this.z, "tt_shrink_fullscreen"));
            }
            TextView textView3 = this.N;
            if (textView3 != null) {
                ColorStateList textColors3 = textView3.getTextColors();
                this.ah = textColors3;
                if (textColors3 != null) {
                    this.N.setTextColor(t.i(this.z, "tt_ssxinzi15"));
                }
                this.ai = this.N.getAlpha();
                this.N.setAlpha(0.85f);
                ViewGroup.LayoutParams layoutParams4 = this.N.getLayoutParams();
                if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                    this.aj.set(marginLayoutParams4.leftMargin, marginLayoutParams4.topMargin, marginLayoutParams4.rightMargin, marginLayoutParams4.bottomMargin);
                    Rect rect3 = this.ay;
                    s.b(this.N, (int) TypedValue.applyDimension(1, 1.0f, displayMetrics), rect3.top, rect3.right, rect3.bottom);
                }
            }
            View view = this.L;
            if (view != null) {
                ViewGroup.LayoutParams layoutParams5 = view.getLayoutParams();
                this.ak = layoutParams5.height;
                layoutParams5.height = (int) TypedValue.applyDimension(1, 49.0f, displayMetrics);
                this.L.setLayoutParams(layoutParams5);
                this.L.setBackgroundResource(t.d(this.z, "tt_shadow_fullscreen_top"));
            }
            b(this.al, true);
        }
    }

    private void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            TextView textView = this.W;
            if (textView != null) {
                textView.setTextSize(0, this.ar);
                ColorStateList colorStateList = this.as;
                if (colorStateList != null) {
                    this.W.setTextColor(colorStateList);
                }
                this.W.setAlpha(this.at);
                this.W.setShadowLayer(s.b(this.z, 1.0f), 0.0f, 0.0f, t.i(this.z, "tt_video_shadow_color"));
                TextView textView2 = this.W;
                Rect rect = this.au;
                s.b(textView2, rect.left, rect.top, rect.right, rect.bottom);
            }
            TextView textView3 = this.V;
            if (textView3 != null) {
                textView3.setTextSize(0, this.av);
                ColorStateList colorStateList2 = this.aw;
                if (colorStateList2 != null) {
                    this.V.setTextColor(colorStateList2);
                }
                this.V.setAlpha(this.ax);
                this.V.setShadowLayer(s.b(this.z, 1.0f), 0.0f, 0.0f, t.i(this.z, "tt_video_shadow_color"));
                TextView textView4 = this.V;
                Rect rect2 = this.ay;
                s.b(textView4, rect2.left, rect2.top, rect2.right, rect2.bottom);
            }
            ImageView imageView = this.X;
            if (imageView != null) {
                Rect rect3 = this.az;
                s.b(imageView, rect3.left, rect3.top, rect3.right, rect3.bottom);
            }
            ImageView imageView2 = this.X;
            if (imageView2 != null) {
                imageView2.setImageDrawable(t.c(this.z, "tt_enlarge_video"));
            }
            TextView textView5 = this.N;
            if (textView5 != null) {
                ColorStateList colorStateList3 = this.ah;
                if (colorStateList3 != null) {
                    textView5.setTextColor(colorStateList3);
                }
                this.N.setAlpha(this.ai);
                TextView textView6 = this.N;
                Rect rect4 = this.ay;
                s.b(textView6, rect4.left, rect4.top, rect4.right, rect4.bottom);
            }
            View view = this.L;
            if (view != null) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.height = this.ak;
                this.L.setLayoutParams(layoutParams);
                this.L.setBackgroundResource(t.d(this.z, "tt_video_black_desc_gradient"));
            }
            b(this.al, true);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.i
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.Y.removeMessages(1);
            this.Y.sendMessageDelayed(this.Y.obtainMessage(1), 2000L);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.i
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.Y.removeMessages(1);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.i
    public void d() {
        m mVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            s.f(this.f67186d);
            s.f(this.f67187e);
            s.e(this.Q);
            if (this.f67188f != null && (mVar = this.y) != null && mVar.V() != null && this.y.V().h() != null) {
                s.f(this.f67188f);
                ImageLoaderWrapper.from(this.y.V().h()).to(this.f67188f);
            }
            if (this.f67185c.getVisibility() == 0) {
                s.a((View) this.f67185c, 8);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.i
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            a(false, this.u);
            v();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.i
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            s.e(this.f67186d);
            s.e(this.Q);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.i
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.U.setProgress(0);
            this.U.setSecondaryProgress(0);
            this.o.setProgress(0);
            this.o.setSecondaryProgress(0);
            this.V.setText(t.b(this.z, "tt_00_00"));
            this.W.setText(t.b(this.z, "tt_00_00"));
            c(8);
            if (x()) {
                this.f67184b.setVisibility(8);
            }
            ImageView imageView = this.f67188f;
            if (imageView != null) {
                imageView.setImageDrawable(null);
            }
            c(8);
            s.a(this.T, 8);
            s.a(this.f67190h, 8);
            s.a((View) this.f67191i, 8);
            s.a(this.f67192j, 8);
            s.a((View) this.k, 8);
            s.a((View) this.l, 8);
            s.a((View) this.m, 8);
            com.bytedance.sdk.openadsdk.core.widget.i iVar = this.A;
            if (iVar != null) {
                iVar.a(true);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.i, com.bytedance.sdk.openadsdk.core.widget.i.b
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.Z : invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.i
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.u : invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.i, com.bytedance.sdk.openadsdk.core.widget.i.b
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            a(true, false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.i
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.v : invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.i, com.bytedance.sdk.openadsdk.core.widget.h.a
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            j();
            b(false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.i, com.bytedance.sdk.openadsdk.core.widget.h.a
    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            com.bytedance.sdk.openadsdk.core.widget.i iVar = this.A;
            return iVar != null && iVar.a();
        }
        return invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.i
    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.w = i2;
            s.a(this.f67183a, i2);
            if (i2 != 0) {
                this.aB = false;
            } else if (this.aA) {
                this.aB = true;
            }
        }
    }

    private void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, this, z) == null) {
            if (z) {
                y();
            } else {
                z();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.i
    public void a(Context context, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, context, view) == null) {
            super.a(context, view);
            this.J = (TextView) view.findViewById(t.e(context, "tt_video_back"));
            this.K = (ImageView) view.findViewById(t.e(context, "tt_video_close"));
            this.L = view.findViewById(t.e(context, "tt_video_top_layout"));
            this.P = (ImageView) view.findViewById(t.e(context, "tt_video_fullscreen_back"));
            this.M = (TextView) view.findViewById(t.e(context, "tt_video_title"));
            this.N = (TextView) view.findViewById(t.e(context, "tt_video_top_title"));
            this.O = (TextView) view.findViewById(t.e(context, "tt_video_current_time"));
            this.Q = view.findViewById(t.e(context, "tt_video_loading_retry"));
            this.R = (ImageView) view.findViewById(t.e(context, "tt_video_retry"));
            this.S = (TextView) view.findViewById(t.e(context, "tt_video_retry_des"));
            this.U = (SeekBar) view.findViewById(t.e(context, "tt_video_seekbar"));
            this.V = (TextView) view.findViewById(t.e(context, "tt_video_time_left_time"));
            this.W = (TextView) view.findViewById(t.e(context, "tt_video_time_play"));
            this.T = view.findViewById(t.e(context, "tt_video_ad_bottom_layout"));
            this.X = (ImageView) view.findViewById(t.e(context, "tt_video_ad_full_screen"));
            this.f67189g = (ViewStub) view.findViewById(t.e(context, "tt_video_ad_cover"));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.i
    public void b(@Nullable ViewGroup viewGroup) {
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, viewGroup) == null) {
            k.f("FullScreen", "Detail exitFullScreen.....");
            if (viewGroup == null || (view = this.f67183a) == null || !(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                return;
            }
            this.Z = false;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f67183a.getLayoutParams();
            marginLayoutParams.width = this.ad;
            marginLayoutParams.height = this.ae;
            marginLayoutParams.leftMargin = this.ac;
            marginLayoutParams.topMargin = this.ab;
            this.f67183a.setLayoutParams(marginLayoutParams);
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.addRule(3, this.af);
                viewGroup.setLayoutParams(layoutParams2);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                Rect rect = this.ag;
                s.b(viewGroup, rect.left, rect.top, rect.right, rect.bottom);
            }
            a(true);
            this.X.setImageDrawable(t.c(this.z, "tt_enlarge_video"));
            this.U.setThumb(t.c(this.z, "tt_seek_thumb_normal"));
            this.U.setThumbOffset(0);
            com.bytedance.sdk.openadsdk.core.video.d.a.a(this.f67183a, true);
            e(this.Z);
            s.a(this.L, 8);
            if (this.x.contains(b.a.f67149b)) {
                s.a((View) this.J, 0);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.i
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.ao.a(this.f67183a);
            int i2 = 8;
            s.a((View) this.K, (this.u || this.x.contains(b.a.f67148a)) ? 8 : 0);
            this.K.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.h.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ h f67174a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67174a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) && this.f67174a.r()) {
                        h hVar = this.f67174a;
                        hVar.B.c(hVar, view);
                    }
                }
            });
            s.a((View) this.J, (!this.u || this.x.contains(b.a.f67149b)) ? 0 : 0);
            this.J.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.h.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ h f67175a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67175a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) && this.f67175a.r()) {
                        h hVar = this.f67175a;
                        hVar.B.d(hVar, view);
                    }
                }
            });
            this.P.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.h.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ h f67176a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67176a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) && this.f67176a.r()) {
                        h hVar = this.f67176a;
                        hVar.B.e(hVar, view);
                    }
                }
            });
            this.R.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.h.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ h f67177a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67177a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f67177a.b(false, true);
                        this.f67177a.f();
                        this.f67177a.d();
                        if (this.f67177a.r()) {
                            h hVar = this.f67177a;
                            hVar.B.f(hVar, view);
                        }
                    }
                }
            });
            this.X.setOnClickListener(new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.h.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ h f67178a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67178a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) && this.f67178a.r()) {
                        h hVar = this.f67178a;
                        hVar.B.b(hVar, view);
                    }
                }
            });
            this.U.setThumbOffset(0);
            this.U.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(this) { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.h.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ h f67179a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67179a = this;
                }

                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onProgressChanged(SeekBar seekBar, int i3, boolean z) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{seekBar, Integer.valueOf(i3), Boolean.valueOf(z)}) == null) && this.f67179a.r()) {
                        h hVar = this.f67179a;
                        hVar.B.a(hVar, i3, z);
                    }
                }

                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onStartTrackingTouch(SeekBar seekBar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, seekBar) == null) {
                        if (!this.f67179a.Z && this.f67179a.z != null) {
                            seekBar.setThumb(t.c(o.a(), "tt_seek_thumb_press"));
                        }
                        if (this.f67179a.r()) {
                            seekBar.setThumbOffset(0);
                            h hVar = this.f67179a;
                            hVar.B.b(hVar, seekBar.getProgress());
                        }
                    }
                }

                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onStopTrackingTouch(SeekBar seekBar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, seekBar) == null) {
                        if (!this.f67179a.Z && this.f67179a.z != null) {
                            seekBar.setThumb(t.c(o.a(), "tt_seek_thumb_normal"));
                        }
                        if (this.f67179a.r()) {
                            seekBar.setThumbOffset(0);
                            h hVar = this.f67179a;
                            hVar.B.a(hVar, seekBar.getProgress());
                        }
                    }
                }
            });
            this.U.setOnTouchListener(this.aq);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.i
    public boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            SeekBar seekBar = this.U;
            return seekBar != null && i2 > seekBar.getSecondaryProgress();
        }
        return invokeI.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.i
    public void b(boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || (textView = this.M) == null) {
            return;
        }
        if (this.u) {
            s.a((View) textView, 8);
        } else {
            s.a((View) textView, z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.i
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            int i2 = h() ? this.an : this.q;
            int i3 = h() ? this.am : this.r;
            if (this.t <= 0 || this.s <= 0 || i2 <= 0) {
                return;
            }
            if (!i() && !h() && !this.x.contains(b.a.f67151d)) {
                i3 = this.z.getResources().getDimensionPixelSize(t.h(this.z, "tt_video_container_maxheight"));
            }
            int i4 = this.s;
            int i5 = this.t;
            int i6 = (int) (i5 * ((i2 * 1.0f) / i4));
            if (i6 > i3) {
                i2 = (int) (i4 * ((i3 * 1.0f) / i5));
            } else {
                i3 = i6;
            }
            if (!z && !h()) {
                i2 = this.q;
                i3 = this.r;
            }
            this.f67184b.a(i2, i3);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.i
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            TextView textView = this.M;
            if (textView != null) {
                textView.setText(str);
            }
            TextView textView2 = this.N;
            if (textView2 != null) {
                textView2.setText(str);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.i
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            View view = this.T;
            if (view != null && view.getVisibility() == 0) {
                s.a((View) this.o, 8);
                return;
            }
            s.a((View) this.o, 0);
            this.U.setProgress(i2);
            this.o.setProgress(i2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.i
    public void a(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.V.setText(com.bytedance.sdk.openadsdk.core.video.d.a.a(j3));
            this.W.setText(com.bytedance.sdk.openadsdk.core.video.d.a.a(j2));
            this.U.setProgress(com.bytedance.sdk.openadsdk.core.video.d.a.a(j2, j3));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.i
    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
            this.W.setText(com.bytedance.sdk.openadsdk.core.video.d.a.a(j2));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.i
    @SuppressLint({"ClickableViewAccessibility"})
    public void a(m mVar, WeakReference<Context> weakReference, boolean z) {
        m mVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, mVar, weakReference, z) == null) || mVar == null) {
            return;
        }
        a(this.f67183a, o.a());
        a(false, this.u);
        s.a(this.f67190h, 0);
        s.a((View) this.f67191i, 0);
        s.a(this.f67192j, 0);
        if (this.f67191i != null && (mVar2 = this.y) != null && mVar2.V() != null && this.y.V().h() != null) {
            ImageLoaderWrapper.from(this.y.V().h()).to(this.f67191i);
        }
        s.a((View) this.n, 0);
        s.a((View) this.k, 8);
        s.a((View) this.l, 8);
        s.a((View) this.m, 8);
        s.a(this.n, (CharSequence) t.a(this.z, "tt_video_dial_replay"));
        s.a(this.n, new View.OnClickListener(this) { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.h.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ h f67182a;

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
                this.f67182a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || (dVar = this.f67182a.B) == null) {
                    return;
                }
                dVar.h();
            }
        }, "video_ad_button");
        s.a(this.n, (View.OnTouchListener) null, "video_ad_button");
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.i
    public void a(@Nullable ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, viewGroup) == null) && viewGroup != null && (this.f67183a.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            this.Z = true;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f67183a.getLayoutParams();
            this.ac = marginLayoutParams.leftMargin;
            this.ab = marginLayoutParams.topMargin;
            this.ad = marginLayoutParams.width;
            this.ae = marginLayoutParams.height;
            marginLayoutParams.width = -1;
            marginLayoutParams.height = -1;
            marginLayoutParams.topMargin = 0;
            marginLayoutParams.leftMargin = 0;
            this.f67183a.setLayoutParams(marginLayoutParams);
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                int[] rules = layoutParams2.getRules();
                this.af = rules.length > 0 ? rules[3] : 0;
                layoutParams2.addRule(3, 0);
                viewGroup.setLayoutParams(layoutParams2);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
                this.ag.set(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                s.b(viewGroup, 0, 0, 0, 0);
            }
            a(true);
            this.X.setImageDrawable(t.c(this.z, "tt_shrink_video"));
            this.U.setThumb(t.c(this.z, "tt_seek_thumb_fullscreen_selector"));
            this.U.setThumbOffset(0);
            com.bytedance.sdk.openadsdk.core.video.d.a.a(this.f67183a, false);
            e(this.Z);
            s.a(this.L, 8);
            if (!this.u) {
                s.a((View) this.K, 8);
                s.a((View) this.J, 8);
            } else if (this.x.contains(b.a.f67148a)) {
                s.a((View) this.K, 8);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.i, com.bytedance.sdk.component.utils.w.a
    public void a(Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, message) == null) && message.what == 1) {
            j();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.i
    public void a(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            s.a(this.T, 0);
            s.a((View) this.o, 0);
            if (this.Z) {
                s.a(this.L, 0);
                s.a((View) this.N, 0);
            } else if (z3) {
                s.a(this.L, 8);
            }
            s.a((View) this.f67185c, (!z || this.f67186d.getVisibility() == 0) ? 8 : 0);
            if (!this.u && !this.Z) {
                if (!this.x.contains(b.a.f67148a) && !z3) {
                    s.a((View) this.K, 0);
                }
                s.a((View) this.J, z3 ? 8 : 0);
            }
            s.a((View) this.V, 0);
            s.a((View) this.W, 0);
            s.a((View) this.U, 0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.i
    public void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            s.a(this.T, 8);
            s.a(this.L, 8);
            s.a((View) this.o, z ? 0 : 8);
            s.a((View) this.f67185c, 8);
            if (!this.u && !this.Z) {
                s.a((View) this.K, 8);
                if (!this.x.contains(b.a.f67149b)) {
                    s.a((View) this.J, 8);
                }
            } else if (this.x.contains(b.a.f67148a)) {
                s.a((View) this.K, 8);
            }
            if (z2) {
                s.a((View) this.K, 8);
                s.a((View) this.J, 8);
            }
            b(false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.i, com.bytedance.sdk.openadsdk.core.widget.h.a
    public void a(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, view, z) == null) {
            if (h()) {
                String format = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
                m mVar = this.y;
                if (mVar != null && !TextUtils.isEmpty(mVar.ah())) {
                    a(this.y.ah());
                }
                this.O.setText(format);
            } else {
                a("");
                this.O.setText("");
            }
            if (this.C) {
                return;
            }
            b(this.u && !this.Z);
            if (r()) {
                this.B.a(this, view, true, this.f67186d.getVisibility() != 0);
            }
        }
    }
}
