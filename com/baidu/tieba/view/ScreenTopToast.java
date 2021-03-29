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
import d.b.b.e.m.e;
/* loaded from: classes5.dex */
public class ScreenTopToast extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public ShadowLinearLayout f22177e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f22178f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f22179g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f22180h;
    public Animation i;
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
        this.f22177e = (ShadowLinearLayout) findViewById(R.id.screen_top_toast_group);
        this.f22178f = (TextView) findViewById(R.id.screen_top_toast_title);
        this.f22179g = (TextView) findViewById(R.id.screen_top_toast_content);
        this.f22180h = (TBSpecificationBtn) findViewById(R.id.screen_top_toast_btn);
        this.f22180h.setConfig(new d.b.h0.r.f0.m.a());
        f();
        h();
    }

    public final void f() {
        this.i = AnimationUtils.loadAnimation(getContext(), R.anim.in_from_top);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.out_to_top);
        this.j = loadAnimation;
        loadAnimation.setAnimationListener(new a());
        this.k = new b();
    }

    public boolean g() {
        return this.l;
    }

    public void h() {
        SkinManager.setViewTextColor(this.f22178f, R.color.CAM_X0302);
        SkinManager.setViewTextColor(this.f22179g, R.color.CAM_X0302);
        this.f22180h.k();
        this.f22177e.b();
    }

    public final void i() {
        e.a().removeCallbacks(this.k);
        clearAnimation();
    }

    public ScreenTopToast j(View.OnClickListener onClickListener) {
        this.f22180h.setOnClickListener(onClickListener);
        return this;
    }

    public ScreenTopToast k(String str) {
        this.f22180h.setText(str);
        return this;
    }

    public ScreenTopToast l(String str) {
        this.f22179g.setText(str);
        return this;
    }

    public ScreenTopToast m(String str) {
        this.f22178f.setText(str);
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
        if (TextUtils.isEmpty(this.f22179g.getText())) {
            this.f22179g.setVisibility(8);
        }
        viewGroup.addView(this, -1, -2);
        this.l = true;
        startAnimation(this.i);
        e.a().postDelayed(this.k, 5000L);
    }

    public ScreenTopToast(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScreenTopToast(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        e();
    }
}
