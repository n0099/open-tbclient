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
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.b;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.am;
import com.bytedance.sdk.openadsdk.utils.u;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumSet;
import java.util.Locale;
/* loaded from: classes6.dex */
public class g extends h {
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
    public final am Y;
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
    public com.bytedance.sdk.openadsdk.core.widget.g ao;
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

    public g(Context context, View view, boolean z, EnumSet<b.a> enumSet, l lVar, c cVar, boolean z2) {
        super(context, view, z, enumSet, lVar, cVar, z2);
        this.Y = new am(this);
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
        this.aq = new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.g.7

            /* renamed from: b  reason: collision with root package name */
            public float f28669b;

            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                float x = motionEvent.getX();
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked != 0) {
                    if (actionMasked == 1) {
                        g.this.ap = Math.abs(this.f28669b - motionEvent.getX()) < 10.0f;
                    } else if (actionMasked == 2) {
                        view2.getParent().requestDisallowInterceptTouchEvent(true);
                    } else if (actionMasked == 3) {
                        view2.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                } else {
                    this.f28669b = x;
                }
                return false;
            }
        };
        this.au = new Rect();
        this.ay = new Rect();
        this.az = new Rect();
        this.z = p.a().getApplicationContext();
        c(z2);
        this.f28671a = view;
        this.u = z;
        com.bytedance.sdk.openadsdk.core.widget.g gVar = new com.bytedance.sdk.openadsdk.core.widget.g(this);
        this.ao = gVar;
        gVar.a(this.u);
        DisplayMetrics displayMetrics = this.z.getResources().getDisplayMetrics();
        this.am = displayMetrics.widthPixels;
        this.an = displayMetrics.heightPixels;
        this.x = enumSet == null ? EnumSet.noneOf(b.a.class) : enumSet;
        this.E = cVar;
        this.y = lVar;
        c(8);
        a(context, this.f28671a);
        a();
        n();
    }

    private void y() {
        DisplayMetrics displayMetrics = this.z.getResources().getDisplayMetrics();
        TextView textView = this.W;
        if (textView != null) {
            this.ar = textView.getTextSize();
            this.W.setTextSize(2, 14.0f);
            ColorStateList textColors = this.W.getTextColors();
            this.as = textColors;
            if (textColors != null) {
                this.W.setTextColor(ad.i(this.z, "tt_ssxinzi15"));
            }
            this.at = this.W.getAlpha();
            this.W.setAlpha(0.85f);
            this.W.setShadowLayer(0.0f, al.a(this.z, 0.5f), al.a(this.z, 0.5f), ad.i(this.z, "tt_video_shaoow_color_fullscreen"));
            ViewGroup.LayoutParams layoutParams = this.W.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                this.au.set(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                al.b(this.W, (int) TypedValue.applyDimension(1, 16.0f, displayMetrics), this.au.top, (int) TypedValue.applyDimension(1, 14.0f, displayMetrics), this.au.bottom);
            }
        }
        TextView textView2 = this.V;
        if (textView2 != null) {
            this.av = textView2.getTextSize();
            this.V.setTextSize(2, 14.0f);
            ColorStateList textColors2 = this.V.getTextColors();
            this.aw = textColors2;
            if (textColors2 != null) {
                this.V.setTextColor(ad.i(this.z, "tt_ssxinzi15"));
            }
            this.ax = this.V.getAlpha();
            this.V.setAlpha(0.85f);
            this.V.setShadowLayer(0.0f, al.a(this.z, 0.5f), al.a(this.z, 0.5f), ad.i(this.z, "tt_video_shaoow_color_fullscreen"));
            ViewGroup.LayoutParams layoutParams2 = this.V.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                this.ay.set(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                Rect rect = this.ay;
                al.b(this.V, (int) TypedValue.applyDimension(1, 14.0f, displayMetrics), rect.top, rect.right, rect.bottom);
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
                al.b(imageView2, rect2.left, rect2.top, (int) TypedValue.applyDimension(1, 16.0f, displayMetrics), this.az.bottom);
            }
        }
        ImageView imageView3 = this.X;
        if (imageView3 != null) {
            imageView3.setImageDrawable(ad.c(this.z, "tt_shrink_fullscreen"));
        }
        TextView textView3 = this.N;
        if (textView3 != null) {
            ColorStateList textColors3 = textView3.getTextColors();
            this.ah = textColors3;
            if (textColors3 != null) {
                this.N.setTextColor(ad.i(this.z, "tt_ssxinzi15"));
            }
            this.ai = this.N.getAlpha();
            this.N.setAlpha(0.85f);
            ViewGroup.LayoutParams layoutParams4 = this.N.getLayoutParams();
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                this.aj.set(marginLayoutParams4.leftMargin, marginLayoutParams4.topMargin, marginLayoutParams4.rightMargin, marginLayoutParams4.bottomMargin);
                Rect rect3 = this.ay;
                al.b(this.N, (int) TypedValue.applyDimension(1, 1.0f, displayMetrics), rect3.top, rect3.right, rect3.bottom);
            }
        }
        View view = this.L;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams5 = view.getLayoutParams();
            this.ak = layoutParams5.height;
            layoutParams5.height = (int) TypedValue.applyDimension(1, 49.0f, displayMetrics);
            this.L.setLayoutParams(layoutParams5);
            this.L.setBackgroundResource(ad.d(this.z, "tt_shadow_fullscreen_top"));
        }
        b(this.al, true);
    }

    private void z() {
        TextView textView = this.W;
        if (textView != null) {
            textView.setTextSize(0, this.ar);
            ColorStateList colorStateList = this.as;
            if (colorStateList != null) {
                this.W.setTextColor(colorStateList);
            }
            this.W.setAlpha(this.at);
            this.W.setShadowLayer(al.a(this.z, 1.0f), 0.0f, 0.0f, ad.i(this.z, "tt_video_shadow_color"));
            TextView textView2 = this.W;
            Rect rect = this.au;
            al.b(textView2, rect.left, rect.top, rect.right, rect.bottom);
        }
        TextView textView3 = this.V;
        if (textView3 != null) {
            textView3.setTextSize(0, this.av);
            ColorStateList colorStateList2 = this.aw;
            if (colorStateList2 != null) {
                this.V.setTextColor(colorStateList2);
            }
            this.V.setAlpha(this.ax);
            this.V.setShadowLayer(al.a(this.z, 1.0f), 0.0f, 0.0f, ad.i(this.z, "tt_video_shadow_color"));
            TextView textView4 = this.V;
            Rect rect2 = this.ay;
            al.b(textView4, rect2.left, rect2.top, rect2.right, rect2.bottom);
        }
        ImageView imageView = this.X;
        if (imageView != null) {
            Rect rect3 = this.az;
            al.b(imageView, rect3.left, rect3.top, rect3.right, rect3.bottom);
        }
        ImageView imageView2 = this.X;
        if (imageView2 != null) {
            imageView2.setImageDrawable(ad.c(this.z, "tt_enlarge_video"));
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
            al.b(textView6, rect4.left, rect4.top, rect4.right, rect4.bottom);
        }
        View view = this.L;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = this.ak;
            this.L.setLayoutParams(layoutParams);
            this.L.setBackgroundResource(ad.d(this.z, "tt_video_black_desc_gradient"));
        }
        b(this.al, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h
    public void b() {
        this.Y.removeMessages(1);
        this.Y.sendMessageDelayed(this.Y.obtainMessage(1), 2000L);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h
    public void c() {
        this.Y.removeMessages(1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h
    public void d() {
        l lVar;
        al.g(this.f28674d);
        al.g(this.f28675e);
        al.f(this.Q);
        if (this.f28676f != null && (lVar = this.y) != null && lVar.X() != null && this.y.X().h() != null) {
            al.g(this.f28676f);
            com.bytedance.sdk.openadsdk.i.e.c().a(this.y.X().h(), this.f28676f);
        }
        if (this.f28673c.getVisibility() == 0) {
            al.a((View) this.f28673c, 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h
    public void e() {
        a(false, this.u);
        v();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h
    public void f() {
        al.f(this.f28674d);
        al.f(this.Q);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h
    public void g() {
        this.U.setProgress(0);
        this.U.setSecondaryProgress(0);
        this.o.setProgress(0);
        this.o.setSecondaryProgress(0);
        this.V.setText(ad.b(this.z, "tt_00_00"));
        this.W.setText(ad.b(this.z, "tt_00_00"));
        c(8);
        if (x()) {
            this.f28672b.setVisibility(8);
        }
        ImageView imageView = this.f28676f;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
        c(8);
        al.a(this.T, 8);
        al.a(this.f28678h, 8);
        al.a((View) this.f28679i, 8);
        al.a(this.j, 8);
        al.a((View) this.k, 8);
        al.a((View) this.l, 8);
        al.a((View) this.m, 8);
        com.bytedance.sdk.openadsdk.core.widget.h hVar = this.A;
        if (hVar != null) {
            hVar.a(true);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h, com.bytedance.sdk.openadsdk.core.widget.h.b
    public boolean h() {
        return this.Z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h
    public boolean i() {
        return this.u;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h, com.bytedance.sdk.openadsdk.core.widget.h.b
    public void j() {
        a(true, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h
    public boolean k() {
        return this.v;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h, com.bytedance.sdk.openadsdk.core.widget.g.a
    public void l() {
        j();
        b(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h, com.bytedance.sdk.openadsdk.core.widget.g.a
    public boolean m() {
        com.bytedance.sdk.openadsdk.core.widget.h hVar = this.A;
        return hVar != null && hVar.a();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h
    public void c(int i2) {
        this.w = i2;
        al.a(this.f28671a, i2);
        if (i2 != 0) {
            this.aB = false;
        } else if (this.aA) {
            this.aB = true;
        }
    }

    private void e(boolean z) {
        if (z) {
            y();
        } else {
            z();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h
    public void a(Context context, View view) {
        super.a(context, view);
        this.J = (TextView) view.findViewById(ad.e(context, "tt_video_back"));
        this.K = (ImageView) view.findViewById(ad.e(context, "tt_video_close"));
        this.L = view.findViewById(ad.e(context, "tt_video_top_layout"));
        this.P = (ImageView) view.findViewById(ad.e(context, "tt_video_fullscreen_back"));
        this.M = (TextView) view.findViewById(ad.e(context, "tt_video_title"));
        this.N = (TextView) view.findViewById(ad.e(context, "tt_video_top_title"));
        this.O = (TextView) view.findViewById(ad.e(context, "tt_video_current_time"));
        this.Q = view.findViewById(ad.e(context, "tt_video_loading_retry"));
        this.R = (ImageView) view.findViewById(ad.e(context, "tt_video_retry"));
        this.S = (TextView) view.findViewById(ad.e(context, "tt_video_retry_des"));
        this.U = (SeekBar) view.findViewById(ad.e(context, "tt_video_seekbar"));
        this.V = (TextView) view.findViewById(ad.e(context, "tt_video_time_left_time"));
        this.W = (TextView) view.findViewById(ad.e(context, "tt_video_time_play"));
        this.T = view.findViewById(ad.e(context, "tt_video_ad_bottom_layout"));
        this.X = (ImageView) view.findViewById(ad.e(context, "tt_video_ad_full_screen"));
        this.f28677g = (ViewStub) view.findViewById(ad.e(context, "tt_video_ad_cover"));
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h
    public void b(@Nullable ViewGroup viewGroup) {
        View view;
        u.f("FullScreen", "Detail exitFullScreen.....");
        if (viewGroup == null || (view = this.f28671a) == null || !(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        this.Z = false;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f28671a.getLayoutParams();
        marginLayoutParams.width = this.ad;
        marginLayoutParams.height = this.ae;
        marginLayoutParams.leftMargin = this.ac;
        marginLayoutParams.topMargin = this.ab;
        this.f28671a.setLayoutParams(marginLayoutParams);
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.addRule(3, this.af);
            viewGroup.setLayoutParams(layoutParams2);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            Rect rect = this.ag;
            al.b(viewGroup, rect.left, rect.top, rect.right, rect.bottom);
        }
        a(true);
        this.X.setImageDrawable(ad.c(this.z, "tt_enlarge_video"));
        this.U.setThumb(ad.c(this.z, "tt_seek_thumb_normal"));
        this.U.setThumbOffset(0);
        com.bytedance.sdk.openadsdk.core.video.e.a.a(this.f28671a, true);
        e(this.Z);
        al.a(this.L, 8);
        if (this.x.contains(b.a.alwayShowBackBtn)) {
            al.a((View) this.J, 0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h
    public void a() {
        super.a();
        this.ao.a(this.f28671a);
        int i2 = 8;
        al.a((View) this.K, (this.u || this.x.contains(b.a.hideCloseBtn)) ? 8 : 0);
        this.K.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.r()) {
                    g gVar = g.this;
                    gVar.B.c(gVar, view);
                }
            }
        });
        al.a((View) this.J, (!this.u || this.x.contains(b.a.alwayShowBackBtn)) ? 0 : 0);
        this.J.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.r()) {
                    g gVar = g.this;
                    gVar.B.d(gVar, view);
                }
            }
        });
        this.P.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.g.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.r()) {
                    g gVar = g.this;
                    gVar.B.e(gVar, view);
                }
            }
        });
        this.R.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.g.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                g.this.b(false, true);
                g.this.f();
                g.this.d();
                if (g.this.r()) {
                    g gVar = g.this;
                    gVar.B.f(gVar, view);
                }
            }
        });
        this.X.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.r()) {
                    g gVar = g.this;
                    gVar.B.b(gVar, view);
                }
            }
        });
        this.U.setThumbOffset(0);
        this.U.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.g.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i3, boolean z) {
                if (g.this.r()) {
                    g gVar = g.this;
                    gVar.B.a(gVar, i3, z);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (!g.this.Z && g.this.z != null) {
                    seekBar.setThumb(ad.c(p.a(), "tt_seek_thumb_press"));
                }
                if (g.this.r()) {
                    seekBar.setThumbOffset(0);
                    g gVar = g.this;
                    gVar.B.b(gVar, seekBar.getProgress());
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (!g.this.Z && g.this.z != null) {
                    seekBar.setThumb(ad.c(p.a(), "tt_seek_thumb_normal"));
                }
                if (g.this.r()) {
                    seekBar.setThumbOffset(0);
                    g gVar = g.this;
                    gVar.B.a(gVar, seekBar.getProgress());
                }
            }
        });
        this.U.setOnTouchListener(this.aq);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h
    public boolean b(int i2) {
        SeekBar seekBar = this.U;
        return seekBar != null && i2 > seekBar.getSecondaryProgress();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h
    public void b(boolean z) {
        TextView textView = this.M;
        if (textView != null) {
            if (this.u) {
                al.a((View) textView, 8);
            } else {
                al.a((View) textView, z ? 0 : 8);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h
    public void a(boolean z) {
        int i2 = h() ? this.an : this.q;
        int i3 = h() ? this.am : this.r;
        if (this.t <= 0 || this.s <= 0 || i2 <= 0) {
            return;
        }
        if (!i() && !h() && !this.x.contains(b.a.fixedSize)) {
            i3 = this.z.getResources().getDimensionPixelSize(ad.h(this.z, "tt_video_container_maxheight"));
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
        this.f28672b.a(i2, i3);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h
    public void a(String str) {
        TextView textView = this.M;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.N;
        if (textView2 != null) {
            textView2.setText(str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h
    public void a(int i2) {
        View view = this.T;
        if (view != null && view.getVisibility() == 0) {
            al.a((View) this.o, 8);
            return;
        }
        al.a((View) this.o, 0);
        this.U.setProgress(i2);
        this.o.setProgress(i2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h
    public void a(long j, long j2) {
        this.V.setText(com.bytedance.sdk.openadsdk.core.video.e.a.a(j2));
        this.W.setText(com.bytedance.sdk.openadsdk.core.video.e.a.a(j));
        this.U.setProgress(com.bytedance.sdk.openadsdk.core.video.e.a.a(j, j2));
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h
    public void a(long j) {
        this.W.setText(com.bytedance.sdk.openadsdk.core.video.e.a.a(j));
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h
    @SuppressLint({"ClickableViewAccessibility"})
    public void a(l lVar, WeakReference<Context> weakReference, boolean z) {
        l lVar2;
        if (lVar == null) {
            return;
        }
        a(this.f28671a, p.a());
        a(false, this.u);
        al.a(this.f28678h, 0);
        al.a((View) this.f28679i, 0);
        al.a(this.j, 0);
        if (this.f28679i != null && (lVar2 = this.y) != null && lVar2.X() != null && this.y.X().h() != null) {
            com.bytedance.sdk.openadsdk.i.e.c().a(this.y.X().h(), this.f28679i);
        }
        al.a((View) this.n, 0);
        al.a((View) this.k, 8);
        al.a((View) this.l, 8);
        al.a((View) this.m, 8);
        al.a(this.n, ad.a(this.z, "tt_video_dial_replay"));
        al.a(this.n, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.g.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar = g.this.B;
                if (dVar != null) {
                    dVar.g();
                }
            }
        }, "video_ad_button");
        al.a(this.n, (View.OnTouchListener) null, "video_ad_button");
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h
    public void a(@Nullable ViewGroup viewGroup) {
        if (viewGroup != null && (this.f28671a.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            this.Z = true;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f28671a.getLayoutParams();
            this.ac = marginLayoutParams.leftMargin;
            this.ab = marginLayoutParams.topMargin;
            this.ad = marginLayoutParams.width;
            this.ae = marginLayoutParams.height;
            marginLayoutParams.width = -1;
            marginLayoutParams.height = -1;
            marginLayoutParams.topMargin = 0;
            marginLayoutParams.leftMargin = 0;
            this.f28671a.setLayoutParams(marginLayoutParams);
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
                al.b(viewGroup, 0, 0, 0, 0);
            }
            a(true);
            this.X.setImageDrawable(ad.c(this.z, "tt_shrink_video"));
            this.U.setThumb(ad.c(this.z, "tt_seek_thumb_fullscreen_selector"));
            this.U.setThumbOffset(0);
            com.bytedance.sdk.openadsdk.core.video.e.a.a(this.f28671a, false);
            e(this.Z);
            al.a(this.L, 8);
            if (!this.u) {
                al.a((View) this.K, 8);
                al.a((View) this.J, 8);
            } else if (this.x.contains(b.a.hideCloseBtn)) {
                al.a((View) this.K, 8);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h, com.bytedance.sdk.openadsdk.utils.am.a
    public void a(Message message) {
        if (message.what != 1) {
            return;
        }
        j();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h
    public void a(boolean z, boolean z2, boolean z3) {
        al.a(this.T, 0);
        al.a((View) this.o, 0);
        if (this.Z) {
            al.a(this.L, 0);
            al.a((View) this.N, 0);
        } else if (z3) {
            al.a(this.L, 8);
        }
        al.a((View) this.f28673c, (!z || this.f28674d.getVisibility() == 0) ? 8 : 0);
        if (!this.u && !this.Z) {
            if (!this.x.contains(b.a.hideCloseBtn) && !z3) {
                al.a((View) this.K, 0);
            }
            al.a((View) this.J, z3 ? 8 : 0);
        }
        al.a((View) this.V, 0);
        al.a((View) this.W, 0);
        al.a((View) this.U, 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h
    public void a(boolean z, boolean z2) {
        al.a(this.T, 8);
        al.a(this.L, 8);
        al.a((View) this.o, z ? 0 : 8);
        al.a((View) this.f28673c, 8);
        if (!this.u && !this.Z) {
            al.a((View) this.K, 8);
            if (!this.x.contains(b.a.alwayShowBackBtn)) {
                al.a((View) this.J, 8);
            }
        } else if (this.x.contains(b.a.hideCloseBtn)) {
            al.a((View) this.K, 8);
        }
        if (z2) {
            al.a((View) this.K, 8);
            al.a((View) this.J, 8);
        }
        b(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h, com.bytedance.sdk.openadsdk.core.widget.g.a
    public void a(View view, boolean z) {
        if (h()) {
            String format = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
            l lVar = this.y;
            if (lVar != null && !TextUtils.isEmpty(lVar.aj())) {
                a(this.y.aj());
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
            this.B.a(this, view, true, this.f28674d.getVisibility() != 0);
        }
    }
}
