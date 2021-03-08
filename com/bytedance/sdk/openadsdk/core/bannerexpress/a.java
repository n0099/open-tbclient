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
/* loaded from: classes6.dex */
class a extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    protected final Context f4366a;
    protected NativeExpressView b;
    protected NativeExpressView c;
    protected l d;
    protected AdSlot e;
    protected TTNativeExpressAd.ExpressAdInteractionListener f;
    protected TTNativeExpressAd.ExpressVideoAdListener g;
    protected int h;
    protected boolean i;
    protected String j;

    public a(@NonNull Context context, l lVar, AdSlot adSlot) {
        super(context);
        this.j = "banner_ad";
        this.f4366a = context;
        this.d = lVar;
        this.e = adSlot;
        a();
    }

    protected void a() {
        this.b = new NativeExpressView(this.f4366a, this.d, this.e, this.j);
        addView(this.b, new ViewGroup.LayoutParams(-1, -1));
    }

    public void a(l lVar, AdSlot adSlot) {
        this.c = new NativeExpressView(this.f4366a, lVar, adSlot, this.j);
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
                a.this.f();
            }
        });
        ak.a((View) this.c, 8);
        addView(this.c, new ViewGroup.LayoutParams(-1, -1));
    }

    public void setVideoAdListener(TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener) {
        this.g = expressVideoAdListener;
    }

    public void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        this.f = expressAdInteractionListener;
        this.b.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.a.2
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

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(float f, float f2) {
        int a2 = (int) ak.a(this.f4366a, f);
        int a3 = (int) ak.a(this.f4366a, f2);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(a2, a3);
        }
        layoutParams.width = a2;
        layoutParams.height = a3;
        setLayoutParams(layoutParams);
    }

    public void e() {
        if (this.b != null) {
            this.b.h();
        }
    }

    public void d() {
        if (this.b != null) {
            removeView(this.b);
            this.b.k();
            this.b = null;
        }
        if (this.c != null) {
            removeView(this.c);
            this.c.k();
            this.c = null;
        }
    }

    public NativeExpressView getCurView() {
        return this.b;
    }

    public NativeExpressView getNextView() {
        return this.c;
    }

    public void setDuration(int i) {
        this.h = i;
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
                a.this.i = false;
                a.this.g();
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

    public void c() {
        if (this.c != null) {
            this.c.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f() {
        try {
            if (!this.i && this.c != null) {
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(a(this.b)).with(b(this.c));
                animatorSet.setDuration(this.h).start();
                ak.a((View) this.c, 0);
                this.i = true;
            }
        } catch (Throwable th) {
        }
    }

    public boolean b() {
        return this.c != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        NativeExpressView nativeExpressView = this.b;
        this.b = this.c;
        this.c = nativeExpressView;
        if (this.c != null) {
            removeView(this.c);
            this.c.k();
            this.c = null;
        }
    }
}
