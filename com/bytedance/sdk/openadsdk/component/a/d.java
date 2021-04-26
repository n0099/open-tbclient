package com.bytedance.sdk.openadsdk.component.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.u;
import com.google.android.material.badge.BadgeDrawable;
/* loaded from: classes5.dex */
public class d extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public final Context f28174a;

    /* renamed from: b  reason: collision with root package name */
    public c f28175b;

    /* renamed from: c  reason: collision with root package name */
    public c f28176c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f28177d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f28178e;

    /* renamed from: f  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.dislike.b f28179f;

    /* renamed from: g  reason: collision with root package name */
    public int f28180g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f28181h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f28182i;
    public boolean j;

    public d(@NonNull Context context) {
        super(context);
        this.f28182i = false;
        this.j = false;
        this.f28174a = context;
        g();
    }

    private void g() {
        c cVar = new c(this.f28174a);
        this.f28175b = cVar;
        addView(cVar, new FrameLayout.LayoutParams(-1, -1));
        i();
        h();
    }

    private void h() {
        if (this.j) {
            return;
        }
        this.j = true;
        ImageView imageView = new ImageView(this.f28174a);
        this.f28177d = imageView;
        imageView.setImageResource(ad.d(p.a(), "tt_dislike_icon"));
        this.f28177d.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f28177d.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.a.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.f28179f != null) {
                    d.this.f28179f.showDislikeDialog();
                }
            }
        });
        int a2 = (int) al.a(this.f28174a, 15.0f);
        int a3 = (int) al.a(this.f28174a, 10.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a2, a2);
        layoutParams.gravity = BadgeDrawable.TOP_END;
        layoutParams.topMargin = a3;
        layoutParams.rightMargin = a3;
        addView(this.f28177d, layoutParams);
        al.a(this.f28177d, a2, a2, a2, a2);
    }

    private void i() {
        if (this.f28182i) {
            return;
        }
        this.f28182i = true;
        ImageView imageView = new ImageView(this.f28174a);
        this.f28178e = imageView;
        imageView.setImageResource(ad.d(p.a(), "tt_ad_logo_small"));
        this.f28178e.setScaleType(ImageView.ScaleType.FIT_XY);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(20, 20);
        layoutParams.gravity = BadgeDrawable.BOTTOM_END;
        addView(this.f28178e, layoutParams);
    }

    private void j() {
        ImageView imageView = this.f28178e;
        if (imageView != null) {
            bringChildToFront(imageView);
        }
        ImageView imageView2 = this.f28177d;
        if (imageView2 != null) {
            bringChildToFront(imageView2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        c cVar = this.f28175b;
        this.f28175b = this.f28176c;
        this.f28176c = cVar;
        cVar.b();
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, layoutParams);
        j();
    }

    public c c() {
        return this.f28176c;
    }

    public View d() {
        return this.f28177d;
    }

    public void e() {
        if (this.f28181h) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(a(this.f28175b)).with(b(this.f28176c));
        animatorSet.setDuration(this.f28180g).start();
        this.f28176c.setVisibility(0);
        this.f28181h = true;
    }

    public boolean f() {
        c cVar = this.f28176c;
        return (cVar == null || cVar.a() == null) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f28182i = false;
        this.j = false;
    }

    public c b() {
        return this.f28175b;
    }

    private ObjectAnimator b(final c cVar) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(cVar, "translationX", getWidth(), 0.0f);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.component.a.d.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.f28181h = false;
                d.this.k();
                c cVar2 = cVar;
                if (cVar2 != null) {
                    d.this.a(cVar2.a());
                }
                u.b("TTBannerAd", "SLIDE END");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                u.b("TTBannerAd", "SLIDE START");
            }
        });
        return ofFloat;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        j();
    }

    public void a() {
        c cVar = new c(this.f28174a);
        this.f28176c = cVar;
        cVar.setVisibility(8);
        addView(this.f28176c, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2) {
        super.addView(view, i2);
        j();
    }

    public void a(com.bytedance.sdk.openadsdk.dislike.b bVar) {
        this.f28179f = bVar;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, int i3) {
        super.addView(view, i2, i3);
        j();
    }

    public void a(int i2) {
        this.f28180g = i2;
    }

    private ObjectAnimator a(c cVar) {
        return ObjectAnimator.ofFloat(cVar, "translationX", 0.0f, -getWidth());
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l lVar) {
        com.bytedance.sdk.openadsdk.dislike.b bVar = this.f28179f;
        if (bVar == null || lVar == null) {
            return;
        }
        bVar.a(lVar);
    }
}
