package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import d.b.b.e.m.e;
/* loaded from: classes5.dex */
public class BdTopToast extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public View f22025e;

    /* renamed from: f  reason: collision with root package name */
    public BottomShadowLinearLayout f22026f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f22027g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f22028h;
    public Animation i;
    public Animation j;
    public Runnable k;
    public int l;
    public boolean m;

    /* loaded from: classes5.dex */
    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            BdTopToast.this.g();
            if (BdTopToast.this.getParent() != null) {
                ((ViewGroup) BdTopToast.this.getParent()).removeView(BdTopToast.this);
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
            BdTopToast.this.c();
        }
    }

    public BdTopToast(Context context, int i) {
        this(context);
        this.l = i;
    }

    public final void c() {
        g();
        startAnimation(this.j);
    }

    public final void d() {
        setOrientation(1);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.f22025e = new View(getContext());
            addView(this.f22025e, 0, new LinearLayout.LayoutParams(-1, UtilHelper.getStatusBarHeight()));
        }
        LayoutInflater.from(getContext()).inflate(R.layout.bd_top_toast_layout, this);
        this.f22026f = (BottomShadowLinearLayout) findViewById(R.id.bd_top_toast_group);
        this.f22027g = (ImageView) findViewById(R.id.bd_top_toast_icon);
        this.f22028h = (TextView) findViewById(R.id.bd_top_toast_content);
        e();
    }

    public final void e() {
        this.i = AnimationUtils.loadAnimation(getContext(), R.anim.in_from_top);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.out_to_top);
        this.j = loadAnimation;
        loadAnimation.setAnimationListener(new a());
        this.k = new b();
    }

    public void f() {
        SkinManager.setBackgroundColor(this.f22025e, R.color.CAM_X0207);
        if (this.m) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f22027g, R.drawable.ic_icon_pure_succeed_use_n, R.color.CAM_X0302, null);
            SkinManager.setViewTextColor(this.f22028h, R.color.CAM_X0302);
        } else {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f22027g, R.drawable.ic_icon_pure_defeated_use_n, R.color.CAM_X0301, null);
            SkinManager.setViewTextColor(this.f22028h, R.color.CAM_X0301);
        }
        this.f22026f.b();
    }

    public final void g() {
        e.a().removeCallbacks(this.k);
        clearAnimation();
    }

    public BdTopToast h(String str) {
        this.f22028h.setText(str);
        return this;
    }

    public BdTopToast i(boolean z) {
        this.m = z;
        return this;
    }

    public void j(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
        g();
        viewGroup.addView(this, -1, -2);
        f();
        startAnimation(this.i);
        if (this.l >= 0) {
            e.a().postDelayed(this.k, this.l);
        } else {
            e.a().postDelayed(this.k, 5000L);
        }
    }

    public BdTopToast(Context context) {
        this(context, (AttributeSet) null);
    }

    public BdTopToast(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BdTopToast(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.l = -1;
        d();
    }
}
