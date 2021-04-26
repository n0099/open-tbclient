package com.baidu.tieba.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class NavigationBarCoverTip extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Animation f22480e;

    /* renamed from: f  reason: collision with root package name */
    public Animation f22481f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f22482g;

    /* renamed from: h  reason: collision with root package name */
    public e f22483h;

    /* renamed from: i  reason: collision with root package name */
    public Activity f22484i;
    public int j;
    public View k;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.c.e.m.e.a().removeCallbacks(NavigationBarCoverTip.this.f22482g);
            NavigationBarCoverTip.this.e();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Animation.AnimationListener {
        public b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (NavigationBarCoverTip.this.f22483h != null) {
                NavigationBarCoverTip.this.f22483h.onShow();
            }
            if (NavigationBarCoverTip.this.f22484i != null) {
                UtilHelper.changeStatusBarIconAndTextColor(true, NavigationBarCoverTip.this.f22484i);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Animation.AnimationListener {
        public c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (NavigationBarCoverTip.this.f22483h != null) {
                NavigationBarCoverTip.this.f22483h.a();
            }
            NavigationBarCoverTip.this.j();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NavigationBarCoverTip.this.e();
        }
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a();

        void onShow();
    }

    public NavigationBarCoverTip(Context context) {
        this(context, null);
    }

    public void e() {
        clearAnimation();
        startAnimation(this.f22481f);
    }

    public final void f() {
        setOrientation(1);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            setPadding(0, UtilHelper.getStatusBarHeight(), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        } else {
            setPadding(0, 0, 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        }
        setOnClickListener(new a());
        g();
        h(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void g() {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.in_from_top);
        this.f22480e = loadAnimation;
        loadAnimation.setAnimationListener(new b());
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.out_to_top);
        this.f22481f = loadAnimation2;
        loadAnimation2.setAnimationListener(new c());
        this.f22482g = new d();
    }

    public void h(int i2) {
        if (this.j != i2) {
            SkinManager.setBackgroundColor(this, R.color.cp_link_tip_a_alpha95);
            this.j = i2;
        }
    }

    public void i() {
        j();
    }

    public final void j() {
        d.a.c.e.m.e.a().removeCallbacks(this.f22482g);
        clearAnimation();
        setVisibility(8);
        Activity activity = this.f22484i;
        if (activity != null) {
            UtilHelper.changeStatusBarIconAndTextColor(false, activity);
            this.f22484i = null;
        }
    }

    public void k(Activity activity, int i2) {
        this.f22484i = activity;
        if (i2 < 0) {
            i2 = 5000;
        }
        setVisibility(0);
        clearAnimation();
        startAnimation(this.f22480e);
        d.a.c.e.m.e.a().removeCallbacks(this.f22482g);
        d.a.c.e.m.e.a().postDelayed(this.f22482g, i2);
    }

    public void l(Activity activity, View view) {
        m(activity, view, 5000);
    }

    public void m(Activity activity, View view, int i2) {
        this.f22484i = activity;
        if (view != this.k) {
            removeAllViews();
            addView(view);
            this.k = view;
        }
        if (i2 < 0) {
            i2 = 5000;
        }
        setVisibility(0);
        clearAnimation();
        startAnimation(this.f22480e);
        d.a.c.e.m.e.a().removeCallbacks(this.f22482g);
        d.a.c.e.m.e.a().postDelayed(this.f22482g, i2);
    }

    public void setCoverTipListener(e eVar) {
        this.f22483h = eVar;
    }

    public NavigationBarCoverTip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationBarCoverTip(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.j = 3;
        f();
    }
}
