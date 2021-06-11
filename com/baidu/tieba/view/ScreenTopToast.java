package com.baidu.tieba.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import d.a.c.e.m.e;
/* loaded from: classes5.dex */
public class ScreenTopToast extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public ShadowLinearLayout f21808e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f21809f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f21810g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f21811h;

    /* renamed from: i  reason: collision with root package name */
    public Animation f21812i;
    public Animation j;
    public Runnable k;
    public boolean l;

    /* loaded from: classes5.dex */
    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            ScreenTopToast.this.i();
            if (ScreenTopToast.this.getParent() != null) {
                ((ViewGroup) ScreenTopToast.this.getParent()).removeView(ScreenTopToast.this);
                ScreenTopToast.this.l = false;
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ScreenTopToast.this.d();
        }
    }

    public ScreenTopToast(Context context) {
        this(context, null);
    }

    public final void d() {
        i();
        startAnimation(this.j);
    }

    public final void e() {
        setOrientation(1);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        }
        LayoutInflater.from(getContext()).inflate(R.layout.screen_top_toast_layout, this);
        this.f21808e = (ShadowLinearLayout) findViewById(R.id.screen_top_toast_group);
        this.f21809f = (TextView) findViewById(R.id.screen_top_toast_title);
        this.f21810g = (TextView) findViewById(R.id.screen_top_toast_content);
        this.f21811h = (TBSpecificationBtn) findViewById(R.id.screen_top_toast_btn);
        this.f21811h.setConfig(new d.a.m0.r.f0.m.a());
        f();
        h();
    }

    public final void f() {
        this.f21812i = AnimationUtils.loadAnimation(getContext(), R.anim.in_from_top);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.out_to_top);
        this.j = loadAnimation;
        loadAnimation.setAnimationListener(new a());
        this.k = new b();
    }

    public boolean g() {
        return this.l;
    }

    public void h() {
        SkinManager.setViewTextColor(this.f21809f, R.color.CAM_X0302);
        SkinManager.setViewTextColor(this.f21810g, R.color.CAM_X0302);
        this.f21811h.k();
        this.f21808e.b();
    }

    public final void i() {
        e.a().removeCallbacks(this.k);
        clearAnimation();
    }

    public ScreenTopToast j(View.OnClickListener onClickListener) {
        this.f21811h.setOnClickListener(onClickListener);
        return this;
    }

    public ScreenTopToast k(String str) {
        this.f21811h.setText(str);
        return this;
    }

    public ScreenTopToast l(String str) {
        this.f21810g.setText(str);
        return this;
    }

    public ScreenTopToast m(String str) {
        this.f21809f.setText(str);
        return this;
    }

    public void n(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
        i();
        if (TextUtils.isEmpty(this.f21810g.getText())) {
            this.f21810g.setVisibility(8);
        }
        viewGroup.addView(this, -1, -2);
        this.l = true;
        startAnimation(this.f21812i);
        e.a().postDelayed(this.k, 5000L);
    }

    public ScreenTopToast(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScreenTopToast(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        e();
    }
}
