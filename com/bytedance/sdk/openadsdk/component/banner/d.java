package com.bytedance.sdk.openadsdk.component.banner;

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
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class d extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final Context f6274a;

    /* renamed from: b  reason: collision with root package name */
    private c f6275b;
    private c c;
    private ImageView d;
    private ImageView e;
    private com.bytedance.sdk.openadsdk.dislike.b f;
    private int g;
    private boolean h;
    private boolean i;
    private boolean j;

    public d(@NonNull Context context) {
        super(context);
        this.i = false;
        this.j = false;
        this.f6274a = context;
        g();
    }

    private void g() {
        this.f6275b = new c(this.f6274a);
        addView(this.f6275b, new FrameLayout.LayoutParams(-1, -1));
        i();
        h();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.i = false;
        this.j = false;
    }

    private void h() {
        if (!this.j) {
            this.j = true;
            this.d = new ImageView(this.f6274a);
            this.d.setImageResource(ac.d(p.a(), "tt_dislike_icon"));
            this.d.setScaleType(ImageView.ScaleType.FIT_XY);
            this.d.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.banner.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.f != null) {
                        d.this.f.showDislikeDialog();
                    }
                }
            });
            int a2 = (int) ak.a(this.f6274a, 15.0f);
            int a3 = (int) ak.a(this.f6274a, 10.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a2, a2);
            layoutParams.gravity = 8388661;
            layoutParams.topMargin = a3;
            layoutParams.rightMargin = a3;
            addView(this.d, layoutParams);
            ak.a(this.d, a2, a2, a2, a2);
        }
    }

    private void i() {
        if (!this.i) {
            this.i = true;
            this.e = new ImageView(this.f6274a);
            this.e.setImageResource(ac.d(p.a(), "tt_ad_logo_small"));
            this.e.setScaleType(ImageView.ScaleType.FIT_XY);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(20, 20);
            layoutParams.gravity = 8388693;
            addView(this.e, layoutParams);
        }
    }

    public void a() {
        this.c = new c(this.f6274a);
        this.c.setVisibility(8);
        addView(this.c, new FrameLayout.LayoutParams(-1, -1));
    }

    private void j() {
        if (this.e != null) {
            bringChildToFront(this.e);
        }
        if (this.d != null) {
            bringChildToFront(this.d);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, layoutParams);
        j();
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        j();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        super.addView(view, i);
        j();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, int i2) {
        super.addView(view, i, i2);
        j();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.bytedance.sdk.openadsdk.dislike.b bVar) {
        this.f = bVar;
    }

    public c b() {
        return this.f6275b;
    }

    public c c() {
        return this.c;
    }

    public View d() {
        return this.d;
    }

    public void a(int i) {
        this.g = i;
    }

    private ObjectAnimator a(c cVar) {
        return ObjectAnimator.ofFloat(cVar, "translationX", 0.0f, -getWidth());
    }

    private ObjectAnimator b(final c cVar) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(cVar, "translationX", getWidth(), 0.0f);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.component.banner.d.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                u.b("TTBannerAd", "SLIDE START");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.h = false;
                d.this.k();
                if (cVar != null) {
                    d.this.a(cVar.a());
                }
                u.b("TTBannerAd", "SLIDE END");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        return ofFloat;
    }

    public void e() {
        if (!this.h) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(a(this.f6275b)).with(b(this.c));
            animatorSet.setDuration(this.g).start();
            this.c.setVisibility(0);
            this.h = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l lVar) {
        if (this.f != null && lVar != null) {
            this.f.a(lVar);
        }
    }

    public boolean f() {
        return (this.c == null || this.c.a() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        c cVar = this.f6275b;
        this.f6275b = this.c;
        this.c = cVar;
        this.c.b();
    }
}
