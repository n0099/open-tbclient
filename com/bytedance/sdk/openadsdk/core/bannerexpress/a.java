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
import com.bytedance.sdk.openadsdk.utils.al;
/* loaded from: classes5.dex */
public class a extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public final Context f28587a;

    /* renamed from: b  reason: collision with root package name */
    public NativeExpressView f28588b;

    /* renamed from: c  reason: collision with root package name */
    public NativeExpressView f28589c;

    /* renamed from: d  reason: collision with root package name */
    public l f28590d;

    /* renamed from: e  reason: collision with root package name */
    public AdSlot f28591e;

    /* renamed from: f  reason: collision with root package name */
    public TTNativeExpressAd.ExpressAdInteractionListener f28592f;

    /* renamed from: g  reason: collision with root package name */
    public TTNativeExpressAd.ExpressVideoAdListener f28593g;

    /* renamed from: h  reason: collision with root package name */
    public int f28594h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f28595i;
    public String j;

    public a(@NonNull Context context, l lVar, AdSlot adSlot) {
        super(context);
        this.j = "banner_ad";
        this.f28587a = context;
        this.f28590d = lVar;
        this.f28591e = adSlot;
        a();
    }

    private ObjectAnimator b(NativeExpressView nativeExpressView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(nativeExpressView, "translationX", getWidth(), 0.0f);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.a.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a aVar = a.this;
                aVar.f28595i = false;
                aVar.g();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        NativeExpressView nativeExpressView = this.f28588b;
        this.f28588b = this.f28589c;
        this.f28589c = nativeExpressView;
        if (nativeExpressView != null) {
            removeView(nativeExpressView);
            this.f28589c.k();
            this.f28589c = null;
        }
    }

    public void c() {
        NativeExpressView nativeExpressView = this.f28589c;
        if (nativeExpressView != null) {
            nativeExpressView.h();
        }
    }

    public void d() {
        NativeExpressView nativeExpressView = this.f28588b;
        if (nativeExpressView != null) {
            removeView(nativeExpressView);
            this.f28588b.k();
            this.f28588b = null;
        }
        NativeExpressView nativeExpressView2 = this.f28589c;
        if (nativeExpressView2 != null) {
            removeView(nativeExpressView2);
            this.f28589c.k();
            this.f28589c = null;
        }
    }

    public void e() {
        NativeExpressView nativeExpressView = this.f28588b;
        if (nativeExpressView != null) {
            nativeExpressView.h();
        }
    }

    public void f() {
        try {
            if (this.f28595i || this.f28589c == null) {
                return;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(a(this.f28588b)).with(b(this.f28589c));
            animatorSet.setDuration(this.f28594h).start();
            al.a((View) this.f28589c, 0);
            this.f28595i = true;
        } catch (Throwable unused) {
        }
    }

    public NativeExpressView getCurView() {
        return this.f28588b;
    }

    public NativeExpressView getNextView() {
        return this.f28589c;
    }

    public void setDuration(int i2) {
        this.f28594h = i2;
    }

    public void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        this.f28592f = expressAdInteractionListener;
        this.f28588b.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.a.2
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdClicked(View view, int i2) {
                a aVar = a.this;
                TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener2 = aVar.f28592f;
                if (expressAdInteractionListener2 != null) {
                    expressAdInteractionListener2.onAdClicked(aVar, i2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdShow(View view, int i2) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(View view, String str, int i2) {
                a aVar = a.this;
                TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener2 = aVar.f28592f;
                if (expressAdInteractionListener2 != null) {
                    expressAdInteractionListener2.onRenderFail(aVar, str, i2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderSuccess(View view, float f2, float f3) {
                if (!(view instanceof NativeExpressView) || !((NativeExpressView) view).m()) {
                    a.this.a(f2, f3);
                }
                a aVar = a.this;
                TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener2 = aVar.f28592f;
                if (expressAdInteractionListener2 != null) {
                    expressAdInteractionListener2.onRenderSuccess(aVar, f2, f3);
                }
            }
        });
    }

    public void setVideoAdListener(TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener) {
        this.f28593g = expressVideoAdListener;
    }

    public void a() {
        NativeExpressView nativeExpressView = new NativeExpressView(this.f28587a, this.f28590d, this.f28591e, this.j);
        this.f28588b = nativeExpressView;
        addView(nativeExpressView, new ViewGroup.LayoutParams(-1, -1));
    }

    public void a(l lVar, AdSlot adSlot) {
        NativeExpressView nativeExpressView = new NativeExpressView(this.f28587a, lVar, adSlot, this.j);
        this.f28589c = nativeExpressView;
        nativeExpressView.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.a.1
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdClicked(View view, int i2) {
                a aVar = a.this;
                TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener = aVar.f28592f;
                if (expressAdInteractionListener != null) {
                    expressAdInteractionListener.onAdClicked(aVar, i2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdShow(View view, int i2) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(View view, String str, int i2) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderSuccess(View view, float f2, float f3) {
                a.this.a(f2, f3);
                a.this.f();
            }
        });
        al.a((View) this.f28589c, 8);
        addView(this.f28589c, new ViewGroup.LayoutParams(-1, -1));
    }

    public boolean b() {
        return this.f28589c != null;
    }

    public void a(float f2, float f3) {
        int a2 = (int) al.a(this.f28587a, f2);
        int a3 = (int) al.a(this.f28587a, f3);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(a2, a3);
        }
        layoutParams.width = a2;
        layoutParams.height = a3;
        setLayoutParams(layoutParams);
    }

    private ObjectAnimator a(NativeExpressView nativeExpressView) {
        return ObjectAnimator.ofFloat(nativeExpressView, "translationX", 0.0f, -getWidth());
    }
}
