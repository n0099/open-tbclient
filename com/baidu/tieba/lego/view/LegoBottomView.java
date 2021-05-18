package com.baidu.tieba.lego.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.card.view.BaseCardView;
import com.baidu.tieba.lego.card.view.ButtonCardView;
import d.a.k0.j1.k;
/* loaded from: classes4.dex */
public class LegoBottomView extends RelativeLayout implements k {

    /* renamed from: e  reason: collision with root package name */
    public ObjectAnimator f18113e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f18114f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f18115g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f18116h;

    /* loaded from: classes4.dex */
    public class a implements Animator.AnimatorListener {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            LegoBottomView.this.setVisibility(0);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LegoBottomView.this.f18113e.start();
        }
    }

    public LegoBottomView(Context context) {
        super(context);
        this.f18113e = null;
        this.f18114f = null;
        this.f18115g = false;
        this.f18116h = false;
        d();
    }

    public void b(BaseCardView baseCardView, ICardInfo iCardInfo) {
        baseCardView.g(iCardInfo);
        if (baseCardView instanceof ButtonCardView) {
            ((ButtonCardView) baseCardView).setBackgroundAlpha(0.3f);
        }
        addView(baseCardView);
    }

    public void c() {
        this.f18115g = false;
        this.f18116h = false;
        removeCallbacks(this.f18114f);
    }

    public final void d() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 0.5f, 1.0f);
        this.f18113e = ofFloat;
        ofFloat.setDuration(1000L);
        this.f18113e.addListener(new a());
        this.f18114f = new b();
    }

    public boolean e() {
        return this.f18115g;
    }

    @Override // d.a.k0.j1.k
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        if (i2 != 0) {
            if (i2 == 1 || i2 == 2) {
                setVisibility(8);
            }
        } else if (getVisibility() == 0 || this.f18116h) {
        } else {
            removeCallbacks(this.f18114f);
            postDelayed(this.f18114f, 1000L);
        }
    }

    public void setIsShow(boolean z) {
        this.f18115g = z;
    }

    public void setIsVideoLandscape(boolean z) {
        removeCallbacks(this.f18114f);
        this.f18116h = z;
    }

    public LegoBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18113e = null;
        this.f18114f = null;
        this.f18115g = false;
        this.f18116h = false;
        d();
    }

    public LegoBottomView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f18113e = null;
        this.f18114f = null;
        this.f18115g = false;
        this.f18116h = false;
        d();
    }
}
