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
/* loaded from: classes5.dex */
public class d extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public final Context f27347a;

    /* renamed from: b  reason: collision with root package name */
    public c f27348b;

    /* renamed from: c  reason: collision with root package name */
    public c f27349c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f27350d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f27351e;

    /* renamed from: f  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.dislike.b f27352f;

    /* renamed from: g  reason: collision with root package name */
    public int f27353g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f27354h;
    public boolean i;
    public boolean j;

    public d(@NonNull Context context) {
        super(context);
        this.i = false;
        this.j = false;
        this.f27347a = context;
        g();
    }

    private void g() {
        c cVar = new c(this.f27347a);
        this.f27348b = cVar;
        addView(cVar, new FrameLayout.LayoutParams(-1, -1));
        i();
        h();
    }

    private void h() {
        if (this.j) {
            return;
        }
        this.j = true;
        ImageView imageView = new ImageView(this.f27347a);
        this.f27350d = imageView;
        imageView.setImageResource(ad.d(p.a(), "tt_dislike_icon"));
        this.f27350d.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f27350d.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.a.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.f27352f != null) {
                    d.this.f27352f.showDislikeDialog();
                }
            }
        });
        int a2 = (int) al.a(this.f27347a, 15.0f);
        int a3 = (int) al.a(this.f27347a, 10.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a2, a2);
        layoutParams.gravity = 8388661;
        layoutParams.topMargin = a3;
        layoutParams.rightMargin = a3;
        addView(this.f27350d, layoutParams);
        al.a(this.f27350d, a2, a2, a2, a2);
    }

    private void i() {
        if (this.i) {
            return;
        }
        this.i = true;
        ImageView imageView = new ImageView(this.f27347a);
        this.f27351e = imageView;
        imageView.setImageResource(ad.d(p.a(), "tt_ad_logo_small"));
        this.f27351e.setScaleType(ImageView.ScaleType.FIT_XY);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(20, 20);
        layoutParams.gravity = 8388693;
        addView(this.f27351e, layoutParams);
    }

    private void j() {
        ImageView imageView = this.f27351e;
        if (imageView != null) {
            bringChildToFront(imageView);
        }
        ImageView imageView2 = this.f27350d;
        if (imageView2 != null) {
            bringChildToFront(imageView2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        c cVar = this.f27348b;
        this.f27348b = this.f27349c;
        this.f27349c = cVar;
        cVar.b();
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, layoutParams);
        j();
    }

    public c c() {
        return this.f27349c;
    }

    public View d() {
        return this.f27350d;
    }

    public void e() {
        if (this.f27354h) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(a(this.f27348b)).with(b(this.f27349c));
        animatorSet.setDuration(this.f27353g).start();
        this.f27349c.setVisibility(0);
        this.f27354h = true;
    }

    public boolean f() {
        c cVar = this.f27349c;
        return (cVar == null || cVar.a() == null) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.i = false;
        this.j = false;
    }

    public c b() {
        return this.f27348b;
    }

    private ObjectAnimator b(final c cVar) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(cVar, "translationX", getWidth(), 0.0f);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.component.a.d.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.f27354h = false;
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
        c cVar = new c(this.f27347a);
        this.f27349c = cVar;
        cVar.setVisibility(8);
        addView(this.f27349c, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        super.addView(view, i);
        j();
    }

    public void a(com.bytedance.sdk.openadsdk.dislike.b bVar) {
        this.f27352f = bVar;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, int i2) {
        super.addView(view, i, i2);
        j();
    }

    public void a(int i) {
        this.f27353g = i;
    }

    private ObjectAnimator a(c cVar) {
        return ObjectAnimator.ofFloat(cVar, "translationX", 0.0f, -getWidth());
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l lVar) {
        com.bytedance.sdk.openadsdk.dislike.b bVar = this.f27352f;
        if (bVar == null || lVar == null) {
            return;
        }
        bVar.a(lVar);
    }
}
