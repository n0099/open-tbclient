package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.e.m.e;
/* loaded from: classes5.dex */
public class CommonTipView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public int f21550e;

    /* renamed from: f  reason: collision with root package name */
    public Animation f21551f;

    /* renamed from: g  reason: collision with root package name */
    public TranslateAnimation f21552g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f21553h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f21554i;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CommonTipView.this.f();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup viewGroup = (ViewGroup) CommonTipView.this.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(CommonTipView.this);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Animation.AnimationListener {
        public c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            CommonTipView.this.i();
            CommonTipView.this.setVisibility(8);
            e.a().postDelayed(CommonTipView.this.f21554i, 600L);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Animation.AnimationListener {
        public d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            CommonTipView commonTipView = CommonTipView.this;
            commonTipView.postDelayed(commonTipView.f21553h, CommonTipView.this.f21550e);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public CommonTipView(Context context) {
        super(context);
        this.f21550e = 4000;
        this.f21551f = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);
        this.f21552g = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.f21553h = new a();
        this.f21554i = new b();
        g();
    }

    public void e() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
    }

    public final void f() {
        removeCallbacks(this.f21553h);
        if (getParent() != null) {
            startAnimation(this.f21551f);
        }
    }

    public final void g() {
        setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds24));
        setGravity(17);
        this.f21551f.setAnimationListener(new c());
        this.f21552g.setDuration(400L);
        this.f21552g.setAnimationListener(new d());
    }

    public void h(int i2) {
        SkinManager.setBackgroundResource(this, R.color.common_color_10260, i2);
        SkinManager.setViewTextColor(this, R.color.CAM_X0111, 1, i2);
    }

    public void i() {
        removeCallbacks(this.f21553h);
        e.a().removeCallbacks(this.f21554i);
        e();
    }

    public void j(FrameLayout frameLayout, int i2) {
        if (frameLayout == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds56));
        layoutParams.setMargins(0, 0, 0, 0);
        frameLayout.addView(this, layoutParams);
        h(i2);
        startAnimation(this.f21552g);
    }

    public void k(LinearLayout linearLayout, int i2) {
        if (linearLayout == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds56));
        layoutParams.gravity = 48;
        linearLayout.addView(this, layoutParams);
        h(i2);
        startAnimation(this.f21552g);
    }

    public void setTipDuration(int i2) {
        if (i2 > 0) {
            this.f21550e = i2;
        }
    }

    public CommonTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21550e = 4000;
        this.f21551f = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);
        this.f21552g = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.f21553h = new a();
        this.f21554i = new b();
        g();
    }

    public CommonTipView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f21550e = 4000;
        this.f21551f = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);
        this.f21552g = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.f21553h = new a();
        this.f21554i = new b();
        g();
    }
}
