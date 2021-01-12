package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.utils.ak;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class a extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final Context f6457a;

    /* renamed from: b  reason: collision with root package name */
    private NativeExpressView f6458b;
    private NativeExpressView c;
    private l d;
    private AdSlot e;
    private TTNativeExpressAd.ExpressAdInteractionListener f;
    private int g;
    private boolean h;
    private String i;

    public a(@NonNull Context context, l lVar, AdSlot adSlot) {
        super(context);
        this.i = "banner_ad";
        this.f6457a = context;
        this.d = lVar;
        this.e = adSlot;
        g();
    }

    private void g() {
        this.f6458b = new NativeExpressView(this.f6457a, this.d, this.e, this.i);
        addView(this.f6458b, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void a(l lVar, AdSlot adSlot) {
        this.c = new NativeExpressView(this.f6457a, lVar, adSlot, this.i);
        this.c.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.a.1
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdClicked(View view, int i) {
                if (a.this.f != null) {
                    a.this.f.onAdClicked(a.this, i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdShow(View view, int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(View view, String str, int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderSuccess(View view, float f, float f2) {
                a.this.a(f, f2);
                a.this.h();
            }
        });
        ak.a((View) this.c, 8);
        addView(this.c, new ViewGroup.LayoutParams(-1, -1));
    }

    public void a(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        this.f = expressAdInteractionListener;
        this.f6458b.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.a.2
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdClicked(View view, int i) {
                if (a.this.f != null) {
                    a.this.f.onAdClicked(a.this, i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdShow(View view, int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(View view, String str, int i) {
                if (a.this.f != null) {
                    a.this.f.onRenderFail(a.this, str, i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderSuccess(View view, float f, float f2) {
                if (!(view instanceof NativeExpressView) || !((NativeExpressView) view).m()) {
                    a.this.a(f, f2);
                }
                if (a.this.f != null) {
                    a.this.f.onRenderSuccess(a.this, f, f2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, float f2) {
        int a2 = (int) ak.a(this.f6457a, f);
        int a3 = (int) ak.a(this.f6457a, f2);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(a2, a3);
        }
        layoutParams.width = a2;
        layoutParams.height = a3;
        setLayoutParams(layoutParams);
    }

    public void a() {
        if (this.f6458b != null) {
            this.f6458b.h();
        }
    }

    public void b() {
        if (this.f6458b != null) {
            removeView(this.f6458b);
            this.f6458b.k();
            this.f6458b = null;
        }
        if (this.c != null) {
            removeView(this.c);
            this.c.k();
            this.c = null;
        }
    }

    public NativeExpressView c() {
        return this.f6458b;
    }

    public NativeExpressView d() {
        return this.c;
    }

    public void a(int i) {
        this.g = i;
    }

    private ObjectAnimator a(NativeExpressView nativeExpressView) {
        return ObjectAnimator.ofFloat(nativeExpressView, "translationX", 0.0f, -getWidth());
    }

    private ObjectAnimator b(NativeExpressView nativeExpressView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(nativeExpressView, "translationX", getWidth(), 0.0f);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.a.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.h = false;
                a.this.i();
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
        if (this.c != null) {
            this.c.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        try {
            if (!this.h && this.c != null) {
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(a(this.f6458b)).with(b(this.c));
                animatorSet.setDuration(this.g).start();
                ak.a((View) this.c, 0);
                this.h = true;
            }
        } catch (Throwable th) {
        }
    }

    public boolean f() {
        return this.c != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        NativeExpressView nativeExpressView = this.f6458b;
        this.f6458b = this.c;
        this.c = nativeExpressView;
        if (this.c != null) {
            removeView(this.c);
            this.c.k();
            this.c = null;
        }
    }
}
