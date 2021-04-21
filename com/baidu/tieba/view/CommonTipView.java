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
import d.b.c.e.m.e;
/* loaded from: classes5.dex */
public class CommonTipView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public int f21729e;

    /* renamed from: f  reason: collision with root package name */
    public Animation f21730f;

    /* renamed from: g  reason: collision with root package name */
    public TranslateAnimation f21731g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f21732h;
    public Runnable i;

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
            e.a().postDelayed(CommonTipView.this.i, 600L);
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
            commonTipView.postDelayed(commonTipView.f21732h, CommonTipView.this.f21729e);
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
        this.f21729e = 4000;
        this.f21730f = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);
        this.f21731g = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.f21732h = new a();
        this.i = new b();
        g();
    }

    public void e() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
    }

    public final void f() {
        removeCallbacks(this.f21732h);
        if (getParent() != null) {
            startAnimation(this.f21730f);
        }
    }

    public final void g() {
        setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds24));
        setGravity(17);
        this.f21730f.setAnimationListener(new c());
        this.f21731g.setDuration(400L);
        this.f21731g.setAnimationListener(new d());
    }

    public void h(int i) {
        SkinManager.setBackgroundResource(this, R.color.common_color_10260, i);
        SkinManager.setViewTextColor(this, R.color.CAM_X0111, 1, i);
    }

    public void i() {
        removeCallbacks(this.f21732h);
        e.a().removeCallbacks(this.i);
        e();
    }

    public void j(FrameLayout frameLayout, int i) {
        if (frameLayout == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds56));
        layoutParams.setMargins(0, 0, 0, 0);
        frameLayout.addView(this, layoutParams);
        h(i);
        startAnimation(this.f21731g);
    }

    public void k(LinearLayout linearLayout, int i) {
        if (linearLayout == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds56));
        layoutParams.gravity = 48;
        linearLayout.addView(this, layoutParams);
        h(i);
        startAnimation(this.f21731g);
    }

    public void setTipDuration(int i) {
        if (i > 0) {
            this.f21729e = i;
        }
    }

    public CommonTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21729e = 4000;
        this.f21730f = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);
        this.f21731g = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.f21732h = new a();
        this.i = new b();
        g();
    }

    public CommonTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f21729e = 4000;
        this.f21730f = AnimationUtils.loadAnimation(TbadkCoreApplication.getInst(), R.anim.fade_out);
        this.f21731g = new TranslateAnimation(0.0f, 0.0f, 0.0f - TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.ds56), 0.0f);
        this.f21732h = new a();
        this.i = new b();
        g();
    }
}
