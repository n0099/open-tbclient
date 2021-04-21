package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import d.b.j0.f0.a;
/* loaded from: classes3.dex */
public class PbTopTipView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public int f19538e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f19539f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f19540g;

    /* renamed from: h  reason: collision with root package name */
    public Animation f19541h;
    public Runnable i;
    public d.b.j0.f0.b j;
    public a.b k;
    public Runnable l;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PbTopTipView.this.h();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.b {
        public b() {
        }

        @Override // d.b.j0.f0.a.b
        public void a(int i, int i2) {
        }

        @Override // d.b.j0.f0.a.b
        public void b(int i, int i2) {
            if (e(i2) && PbTopTipView.this.f19539f) {
                PbTopTipView.this.h();
            }
        }

        @Override // d.b.j0.f0.a.b
        public void c(int i, int i2) {
        }

        @Override // d.b.j0.f0.a.b
        public void d(int i, int i2) {
        }

        public final boolean e(float f2) {
            return Math.abs(f2) >= 5.0f;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnTouchListener {
        public c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return PbTopTipView.this.j.c(motionEvent);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Animation.AnimationListener {
        public d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            PbTopTipView.this.k();
            PbTopTipView.this.setVisibility(8);
            d.b.c.e.m.e.a().postDelayed(PbTopTipView.this.l, 600L);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Animation.AnimationListener {
        public e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (PbTopTipView.this.f19538e > 0) {
                PbTopTipView pbTopTipView = PbTopTipView.this;
                pbTopTipView.postDelayed(pbTopTipView.i, PbTopTipView.this.f19538e);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup viewGroup = (ViewGroup) PbTopTipView.this.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(PbTopTipView.this);
            }
        }
    }

    public PbTopTipView(Context context) {
        super(context);
        this.f19538e = 3000;
        this.i = new a();
        this.k = new b();
        this.l = new f();
        i();
    }

    public void g() {
        this.f19539f = false;
        k();
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
    }

    public final void h() {
        this.f19539f = false;
        removeCallbacks(this.i);
        if (getParent() != null) {
            clearAnimation();
            startAnimation(this.f19540g);
        }
    }

    public final void i() {
        d.b.j0.f0.b bVar = new d.b.j0.f0.b(getContext());
        this.j = bVar;
        bVar.d(this.k);
        setOnTouchListener(new c());
        setupPaddings();
        this.f19541h = AnimationUtils.loadAnimation(getContext(), R.anim.push_top_in);
        this.f19540g = AnimationUtils.loadAnimation(getContext(), R.anim.push_top_out);
        setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.fontsize30));
        this.f19540g.setAnimationListener(new d());
        this.f19541h.setDuration(400L);
        this.f19541h.setAnimationListener(new e());
    }

    public void j(int i) {
        SkinManager.setBackgroundResource(this, R.color.cp_link_tip_a_alpha95, i);
        SkinManager.setViewTextColor(this, R.color.CAM_X0101, 1, i);
    }

    public void k() {
        removeCallbacks(this.i);
        clearAnimation();
        d.b.c.e.m.e.a().removeCallbacks(this.l);
    }

    public void l(RelativeLayout relativeLayout, int i) {
        if (relativeLayout == null) {
            return;
        }
        if (getParent() != null) {
            clearAnimation();
            ((ViewGroup) getParent()).removeView(this);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10);
        relativeLayout.addView(this, layoutParams);
        j(i);
        startAnimation(this.f19541h);
        this.f19539f = true;
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setupPaddings();
    }

    public void setDuration(int i) {
        this.f19538e = i;
    }

    public void setupPaddings() {
        int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(R.dimen.ds30);
        int statusBarHeight = (UtilHelper.canUseStyleImmersiveSticky() && UtilHelper.getRealScreenOrientation(getContext()) == 1) ? UtilHelper.getStatusBarHeight() + dimensionPixelOffset : dimensionPixelOffset;
        int dimensionPixelOffset2 = getContext().getResources().getDimensionPixelOffset(R.dimen.ds34);
        setPadding(dimensionPixelOffset2, statusBarHeight, dimensionPixelOffset2, dimensionPixelOffset);
    }

    public PbTopTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19538e = 3000;
        this.i = new a();
        this.k = new b();
        this.l = new f();
        i();
    }

    public PbTopTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19538e = 3000;
        this.i = new a();
        this.k = new b();
        this.l = new f();
        i();
    }
}
