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
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.u;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumSet;
import java.util.Locale;
/* loaded from: classes6.dex */
public class g extends h {
    private TextView J;
    private ImageView K;
    private View L;
    private TextView M;
    private TextView N;
    private TextView O;
    private ImageView P;
    private View Q;
    private ImageView R;
    private TextView S;
    private View T;
    private SeekBar U;
    private TextView V;
    private TextView W;
    private ImageView X;
    private final al Y;
    private boolean Z;
    private boolean aA;
    private boolean aB;
    private boolean aa;
    private int ab;
    private int ac;
    private int ad;
    private int ae;
    private int af;
    private final Rect ag;
    private ColorStateList ah;
    private float ai;
    private final Rect aj;
    private int ak;
    private boolean al;
    private int am;
    private int an;
    private com.bytedance.sdk.openadsdk.core.widget.g ao;
    private boolean ap;
    private final View.OnTouchListener aq;
    private float ar;
    private ColorStateList as;
    private float at;
    private final Rect au;
    private float av;
    private ColorStateList aw;
    private float ax;
    private final Rect ay;
    private final Rect az;

    public g(Context context, View view, boolean z, EnumSet<b.a> enumSet, l lVar, c cVar, boolean z2) {
        super(context, view, z, enumSet, lVar, cVar, z2);
        this.Y = new al(this);
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
            private float b;

            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                float x = motionEvent.getX();
                switch (motionEvent.getActionMasked()) {
                    case 0:
                        this.b = x;
                        break;
                    case 1:
                        g.this.ap = Math.abs(this.b - motionEvent.getX()) < 10.0f;
                        break;
                    case 2:
                        view2.getParent().requestDisallowInterceptTouchEvent(true);
                        break;
                    case 3:
                        view2.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                }
                return false;
            }
        };
        this.au = new Rect();
        this.ay = new Rect();
        this.az = new Rect();
        this.z = p.a().getApplicationContext();
        c(z2);
        this.f4568a = view;
        this.u = z;
        this.ao = new com.bytedance.sdk.openadsdk.core.widget.g(this);
        this.ao.a(this.u);
        DisplayMetrics displayMetrics = this.z.getResources().getDisplayMetrics();
        this.am = displayMetrics.widthPixels;
        this.an = displayMetrics.heightPixels;
        this.x = enumSet == null ? EnumSet.noneOf(b.a.class) : enumSet;
        this.E = cVar;
        this.y = lVar;
        c(8);
        a(context, this.f4568a);
        a();
        n();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h
    public void a(Context context, View view) {
        super.a(context, view);
        this.J = (TextView) view.findViewById(ac.e(context, "tt_video_back"));
        this.K = (ImageView) view.findViewById(ac.e(context, "tt_video_close"));
        this.L = view.findViewById(ac.e(context, "tt_video_top_layout"));
        this.P = (ImageView) view.findViewById(ac.e(context, "tt_video_fullscreen_back"));
        this.M = (TextView) view.findViewById(ac.e(context, "tt_video_title"));
        this.N = (TextView) view.findViewById(ac.e(context, "tt_video_top_title"));
        this.O = (TextView) view.findViewById(ac.e(context, "tt_video_current_time"));
        this.Q = view.findViewById(ac.e(context, "tt_video_loading_retry"));
        this.R = (ImageView) view.findViewById(ac.e(context, "tt_video_retry"));
        this.S = (TextView) view.findViewById(ac.e(context, "tt_video_retry_des"));
        this.U = (SeekBar) view.findViewById(ac.e(context, "tt_video_seekbar"));
        this.V = (TextView) view.findViewById(ac.e(context, "tt_video_time_left_time"));
        this.W = (TextView) view.findViewById(ac.e(context, "tt_video_time_play"));
        this.T = view.findViewById(ac.e(context, "tt_video_ad_bottom_layout"));
        this.X = (ImageView) view.findViewById(ac.e(context, "tt_video_ad_full_screen"));
        this.g = (ViewStub) view.findViewById(ac.e(context, "tt_video_ad_cover"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h
    public void a() {
        int i = 8;
        super.a();
        this.ao.a(this.f4568a);
        ak.a((View) this.K, (this.u || this.x.contains(b.a.hideCloseBtn)) ? 8 : 0);
        this.K.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.r()) {
                    g.this.B.c(g.this, view);
                }
            }
        });
        TextView textView = this.J;
        if (!this.u || this.x.contains(b.a.alwayShowBackBtn)) {
            i = 0;
        }
        ak.a((View) textView, i);
        this.J.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.r()) {
                    g.this.B.d(g.this, view);
                }
            }
        });
        this.P.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.g.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.r()) {
                    g.this.B.e(g.this, view);
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
                    g.this.B.f(g.this, view);
                }
            }
        });
        this.X.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.g.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.r()) {
                    g.this.B.b(g.this, view);
                }
            }
        });
        this.U.setThumbOffset(0);
        this.U.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.g.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (!g.this.Z && g.this.z != null) {
                    seekBar.setThumb(ac.c(p.a(), "tt_seek_thumb_normal"));
                }
                if (g.this.r()) {
                    seekBar.setThumbOffset(0);
                    g.this.B.a(g.this, seekBar.getProgress());
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (!g.this.Z && g.this.z != null) {
                    seekBar.setThumb(ac.c(p.a(), "tt_seek_thumb_press"));
                }
                if (g.this.r()) {
                    seekBar.setThumbOffset(0);
                    g.this.B.b(g.this, seekBar.getProgress());
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (g.this.r()) {
                    g.this.B.a(g.this, i2, z);
                }
            }
        });
        this.U.setOnTouchListener(this.aq);
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
    public void a(boolean z) {
        int i;
        int i2;
        int i3 = h() ? this.an : this.q;
        int i4 = h() ? this.am : this.r;
        if (this.t > 0 && this.s > 0 && i3 > 0) {
            if (!i() && !h() && !this.x.contains(b.a.fixedSize)) {
                i4 = this.z.getResources().getDimensionPixelSize(ac.h(this.z, "tt_video_container_maxheight"));
            }
            int i5 = (int) (((i3 * 1.0f) / this.s) * this.t);
            if (i5 > i4) {
                i = (int) (((i4 * 1.0f) / this.t) * this.s);
            } else {
                i4 = i5;
                i = i3;
            }
            if (z || h()) {
                i2 = i4;
            } else {
                int i6 = this.q;
                i2 = this.r;
                i = i6;
            }
            this.b.a(i, i2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h
    public void a(String str) {
        if (this.M != null) {
            this.M.setText(str);
        }
        if (this.N != null) {
            this.N.setText(str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h
    public void a(int i) {
        if (this.T != null && this.T.getVisibility() == 0) {
            ak.a((View) this.o, 8);
            return;
        }
        ak.a((View) this.o, 0);
        this.U.setProgress(i);
        this.o.setProgress(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h
    public void a(long j, long j2) {
        this.V.setText(com.bytedance.sdk.openadsdk.core.video.e.a.a(j2));
        this.W.setText(com.bytedance.sdk.openadsdk.core.video.e.a.a(j));
        this.U.setProgress(com.bytedance.sdk.openadsdk.core.video.e.a.a(j, j2));
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h
    public void d() {
        ak.g(this.d);
        ak.g(this.e);
        ak.f(this.Q);
        if (this.f != null && this.y != null && this.y.R() != null && this.y.R().h() != null) {
            ak.g(this.f);
            com.bytedance.sdk.openadsdk.h.d.a(this.z).a(this.y.R().h(), this.f);
        }
        if (this.c.getVisibility() == 0) {
            ak.a((View) this.c, 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h
    public void e() {
        a(false, this.u);
        v();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h
    public void a(long j) {
        this.W.setText(com.bytedance.sdk.openadsdk.core.video.e.a.a(j));
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h
    @SuppressLint({"ClickableViewAccessibility"})
    public void a(l lVar, WeakReference<Context> weakReference, boolean z) {
        if (lVar != null) {
            a(this.f4568a, p.a());
            a(false, this.u);
            ak.a(this.h, 0);
            ak.a((View) this.i, 0);
            ak.a(this.j, 0);
            if (this.i != null && this.y != null && this.y.R() != null && this.y.R().h() != null) {
                com.bytedance.sdk.openadsdk.h.d.a(this.z).a(this.y.R().h(), this.i);
            }
            ak.a((View) this.n, 0);
            ak.a((View) this.k, 8);
            ak.a((View) this.l, 8);
            ak.a((View) this.m, 8);
            ak.a(this.n, ac.a(this.z, "tt_video_dial_replay"));
            ak.a(this.n, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.g.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (g.this.B != null) {
                        g.this.B.g();
                    }
                }
            }, "video_ad_button");
            ak.a(this.n, (View.OnTouchListener) null, "video_ad_button");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h
    public void f() {
        ak.f(this.d);
        ak.f(this.Q);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h
    public void g() {
        this.U.setProgress(0);
        this.U.setSecondaryProgress(0);
        this.o.setProgress(0);
        this.o.setSecondaryProgress(0);
        this.V.setText(ac.b(this.z, "tt_00_00"));
        this.W.setText(ac.b(this.z, "tt_00_00"));
        c(8);
        if (x()) {
            this.b.setVisibility(8);
        }
        if (this.f != null) {
            this.f.setImageDrawable(null);
        }
        c(8);
        ak.a(this.T, 8);
        ak.a(this.h, 8);
        ak.a((View) this.i, 8);
        ak.a(this.j, 8);
        ak.a((View) this.k, 8);
        ak.a((View) this.l, 8);
        ak.a((View) this.m, 8);
        if (this.A != null) {
            this.A.a(true);
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

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h
    public void a(@Nullable ViewGroup viewGroup) {
        if (viewGroup != null && (this.f4568a.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            this.Z = true;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f4568a.getLayoutParams();
            this.ac = marginLayoutParams.leftMargin;
            this.ab = marginLayoutParams.topMargin;
            this.ad = marginLayoutParams.width;
            this.ae = marginLayoutParams.height;
            marginLayoutParams.width = -1;
            marginLayoutParams.height = -1;
            marginLayoutParams.topMargin = 0;
            marginLayoutParams.leftMargin = 0;
            this.f4568a.setLayoutParams(marginLayoutParams);
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
                ak.b(viewGroup, 0, 0, 0, 0);
            }
            a(true);
            this.X.setImageDrawable(ac.c(this.z, "tt_shrink_video"));
            this.U.setThumb(ac.c(this.z, "tt_seek_thumb_fullscreen_selector"));
            this.U.setThumbOffset(0);
            com.bytedance.sdk.openadsdk.core.video.e.a.a(this.f4568a, false);
            e(this.Z);
            ak.a(this.L, 8);
            if (!this.u) {
                ak.a((View) this.K, 8);
                ak.a((View) this.J, 8);
            } else if (this.x.contains(b.a.hideCloseBtn)) {
                ak.a((View) this.K, 8);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h
    public void b(@Nullable ViewGroup viewGroup) {
        u.f("FullScreen", "Detail exitFullScreen.....");
        if (viewGroup != null && this.f4568a != null && (this.f4568a.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            this.Z = false;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f4568a.getLayoutParams();
            marginLayoutParams.width = this.ad;
            marginLayoutParams.height = this.ae;
            marginLayoutParams.leftMargin = this.ac;
            marginLayoutParams.topMargin = this.ab;
            this.f4568a.setLayoutParams(marginLayoutParams);
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.addRule(3, this.af);
                viewGroup.setLayoutParams(layoutParams2);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ak.b(viewGroup, this.ag.left, this.ag.top, this.ag.right, this.ag.bottom);
            }
            a(true);
            this.X.setImageDrawable(ac.c(this.z, "tt_enlarge_video"));
            this.U.setThumb(ac.c(this.z, "tt_seek_thumb_normal"));
            this.U.setThumbOffset(0);
            com.bytedance.sdk.openadsdk.core.video.e.a.a(this.f4568a, true);
            e(this.Z);
            ak.a(this.L, 8);
            if (this.x.contains(b.a.alwayShowBackBtn)) {
                ak.a((View) this.J, 0);
            }
        }
    }

    private void e(boolean z) {
        if (z) {
            y();
        } else {
            z();
        }
    }

    private void y() {
        DisplayMetrics displayMetrics = this.z.getResources().getDisplayMetrics();
        if (this.W != null) {
            this.ar = this.W.getTextSize();
            this.W.setTextSize(2, 14.0f);
            this.as = this.W.getTextColors();
            if (this.as != null) {
                this.W.setTextColor(ac.i(this.z, "tt_ssxinzi15"));
            }
            this.at = this.W.getAlpha();
            this.W.setAlpha(0.85f);
            this.W.setShadowLayer(0.0f, ak.a(this.z, 0.5f), ak.a(this.z, 0.5f), ac.i(this.z, "tt_video_shaoow_color_fullscreen"));
            ViewGroup.LayoutParams layoutParams = this.W.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                this.au.set(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                ak.b(this.W, (int) TypedValue.applyDimension(1, 16.0f, displayMetrics), this.au.top, (int) TypedValue.applyDimension(1, 14.0f, displayMetrics), this.au.bottom);
            }
        }
        if (this.V != null) {
            this.av = this.V.getTextSize();
            this.V.setTextSize(2, 14.0f);
            this.aw = this.V.getTextColors();
            if (this.aw != null) {
                this.V.setTextColor(ac.i(this.z, "tt_ssxinzi15"));
            }
            this.ax = this.V.getAlpha();
            this.V.setAlpha(0.85f);
            this.V.setShadowLayer(0.0f, ak.a(this.z, 0.5f), ak.a(this.z, 0.5f), ac.i(this.z, "tt_video_shaoow_color_fullscreen"));
            ViewGroup.LayoutParams layoutParams2 = this.V.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                this.ay.set(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                ak.b(this.V, (int) TypedValue.applyDimension(1, 14.0f, displayMetrics), this.ay.top, this.ay.right, this.ay.bottom);
            }
        }
        if (this.X != null) {
            ViewGroup.LayoutParams layoutParams3 = this.X.getLayoutParams();
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                this.az.set(marginLayoutParams3.leftMargin, marginLayoutParams3.topMargin, marginLayoutParams3.rightMargin, marginLayoutParams3.bottomMargin);
                ak.b(this.X, this.az.left, this.az.top, (int) TypedValue.applyDimension(1, 16.0f, displayMetrics), this.az.bottom);
            }
        }
        if (this.X != null) {
            this.X.setImageDrawable(ac.c(this.z, "tt_shrink_fullscreen"));
        }
        if (this.N != null) {
            this.ah = this.N.getTextColors();
            if (this.ah != null) {
                this.N.setTextColor(ac.i(this.z, "tt_ssxinzi15"));
            }
            this.ai = this.N.getAlpha();
            this.N.setAlpha(0.85f);
            ViewGroup.LayoutParams layoutParams4 = this.N.getLayoutParams();
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                this.aj.set(marginLayoutParams4.leftMargin, marginLayoutParams4.topMargin, marginLayoutParams4.rightMargin, marginLayoutParams4.bottomMargin);
                ak.b(this.N, (int) TypedValue.applyDimension(1, 1.0f, displayMetrics), this.ay.top, this.ay.right, this.ay.bottom);
            }
        }
        if (this.L != null) {
            ViewGroup.LayoutParams layoutParams5 = this.L.getLayoutParams();
            this.ak = layoutParams5.height;
            layoutParams5.height = (int) TypedValue.applyDimension(1, 49.0f, displayMetrics);
            this.L.setLayoutParams(layoutParams5);
            this.L.setBackgroundResource(ac.d(this.z, "tt_shadow_fullscreen_top"));
        }
        b(this.al, true);
    }

    private void z() {
        if (this.W != null) {
            this.W.setTextSize(0, this.ar);
            if (this.as != null) {
                this.W.setTextColor(this.as);
            }
            this.W.setAlpha(this.at);
            this.W.setShadowLayer(ak.a(this.z, 1.0f), 0.0f, 0.0f, ac.i(this.z, "tt_video_shadow_color"));
            ak.b(this.W, this.au.left, this.au.top, this.au.right, this.au.bottom);
        }
        if (this.V != null) {
            this.V.setTextSize(0, this.av);
            if (this.aw != null) {
                this.V.setTextColor(this.aw);
            }
            this.V.setAlpha(this.ax);
            this.V.setShadowLayer(ak.a(this.z, 1.0f), 0.0f, 0.0f, ac.i(this.z, "tt_video_shadow_color"));
            ak.b(this.V, this.ay.left, this.ay.top, this.ay.right, this.ay.bottom);
        }
        if (this.X != null) {
            ak.b(this.X, this.az.left, this.az.top, this.az.right, this.az.bottom);
        }
        if (this.X != null) {
            this.X.setImageDrawable(ac.c(this.z, "tt_enlarge_video"));
        }
        if (this.N != null) {
            if (this.ah != null) {
                this.N.setTextColor(this.ah);
            }
            this.N.setAlpha(this.ai);
            ak.b(this.N, this.ay.left, this.ay.top, this.ay.right, this.ay.bottom);
        }
        if (this.L != null) {
            ViewGroup.LayoutParams layoutParams = this.L.getLayoutParams();
            layoutParams.height = this.ak;
            this.L.setLayoutParams(layoutParams);
            this.L.setBackgroundResource(ac.d(this.z, "tt_video_black_desc_gradient"));
        }
        b(this.al, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h, com.bytedance.sdk.openadsdk.utils.al.a
    public void a(Message message) {
        switch (message.what) {
            case 1:
                j();
                return;
            default:
                return;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h
    public void a(boolean z, boolean z2, boolean z3) {
        ak.a(this.T, 0);
        ak.a((View) this.o, 0);
        if (this.Z) {
            ak.a(this.L, 0);
            ak.a((View) this.N, 0);
        } else if (z3) {
            ak.a(this.L, 8);
        }
        ak.a((View) this.c, (!z || this.d.getVisibility() == 0) ? 8 : 0);
        if (!this.u && !this.Z) {
            if (!this.x.contains(b.a.hideCloseBtn) && !z3) {
                ak.a((View) this.K, 0);
            }
            ak.a((View) this.J, z3 ? 8 : 0);
        }
        ak.a((View) this.V, 0);
        ak.a((View) this.W, 0);
        ak.a((View) this.U, 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h
    public void a(boolean z, boolean z2) {
        ak.a(this.T, 8);
        ak.a(this.L, 8);
        ak.a((View) this.o, z ? 0 : 8);
        ak.a((View) this.c, 8);
        if (!this.u && !this.Z) {
            ak.a((View) this.K, 8);
            if (!this.x.contains(b.a.alwayShowBackBtn)) {
                ak.a((View) this.J, 8);
            }
        } else if (this.x.contains(b.a.hideCloseBtn)) {
            ak.a((View) this.K, 8);
        }
        if (z2) {
            ak.a((View) this.K, 8);
            ak.a((View) this.J, 8);
        }
        b(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h, com.bytedance.sdk.openadsdk.core.widget.h.b
    public void j() {
        a(true, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h
    public boolean b(int i) {
        return this.U != null && i > this.U.getSecondaryProgress();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h
    public void b(boolean z) {
        if (this.M != null) {
            if (this.u) {
                ak.a((View) this.M, 8);
            } else {
                ak.a((View) this.M, z ? 0 : 8);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h
    public boolean k() {
        return this.v;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h
    public void c(int i) {
        this.w = i;
        ak.a(this.f4568a, i);
        if (i != 0) {
            this.aB = false;
        } else if (this.aA) {
            this.aB = true;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h, com.bytedance.sdk.openadsdk.core.widget.g.a
    public void a(View view, boolean z) {
        if (h()) {
            String format = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
            if (this.y != null && !TextUtils.isEmpty(this.y.ad())) {
                a(this.y.ad());
            }
            this.O.setText(format);
        } else {
            a("");
            this.O.setText("");
        }
        if (!this.C) {
            b(this.u && !this.Z);
            if (r()) {
                this.B.a(this, view, true, this.d.getVisibility() != 0);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h, com.bytedance.sdk.openadsdk.core.widget.g.a
    public void l() {
        j();
        b(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.h, com.bytedance.sdk.openadsdk.core.widget.g.a
    public boolean m() {
        return this.A != null && this.A.a();
    }
}
