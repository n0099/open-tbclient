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
    public final Context f27739a;

    /* renamed from: b  reason: collision with root package name */
    public NativeExpressView f27740b;

    /* renamed from: c  reason: collision with root package name */
    public NativeExpressView f27741c;

    /* renamed from: d  reason: collision with root package name */
    public l f27742d;

    /* renamed from: e  reason: collision with root package name */
    public AdSlot f27743e;

    /* renamed from: f  reason: collision with root package name */
    public TTNativeExpressAd.ExpressAdInteractionListener f27744f;

    /* renamed from: g  reason: collision with root package name */
    public TTNativeExpressAd.ExpressVideoAdListener f27745g;

    /* renamed from: h  reason: collision with root package name */
    public int f27746h;
    public boolean i;
    public String j;

    public a(@NonNull Context context, l lVar, AdSlot adSlot) {
        super(context);
        this.j = "banner_ad";
        this.f27739a = context;
        this.f27742d = lVar;
        this.f27743e = adSlot;
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
                aVar.i = false;
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
        NativeExpressView nativeExpressView = this.f27740b;
        this.f27740b = this.f27741c;
        this.f27741c = nativeExpressView;
        if (nativeExpressView != null) {
            removeView(nativeExpressView);
            this.f27741c.k();
            this.f27741c = null;
        }
    }

    public void c() {
        NativeExpressView nativeExpressView = this.f27741c;
        if (nativeExpressView != null) {
            nativeExpressView.h();
        }
    }

    public void d() {
        NativeExpressView nativeExpressView = this.f27740b;
        if (nativeExpressView != null) {
            removeView(nativeExpressView);
            this.f27740b.k();
            this.f27740b = null;
        }
        NativeExpressView nativeExpressView2 = this.f27741c;
        if (nativeExpressView2 != null) {
            removeView(nativeExpressView2);
            this.f27741c.k();
            this.f27741c = null;
        }
    }

    public void e() {
        NativeExpressView nativeExpressView = this.f27740b;
        if (nativeExpressView != null) {
            nativeExpressView.h();
        }
    }

    public void f() {
        try {
            if (this.i || this.f27741c == null) {
                return;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(a(this.f27740b)).with(b(this.f27741c));
            animatorSet.setDuration(this.f27746h).start();
            al.a((View) this.f27741c, 0);
            this.i = true;
        } catch (Throwable unused) {
        }
    }

    public NativeExpressView getCurView() {
        return this.f27740b;
    }

    public NativeExpressView getNextView() {
        return this.f27741c;
    }

    public void setDuration(int i) {
        this.f27746h = i;
    }

    public void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        this.f27744f = expressAdInteractionListener;
        this.f27740b.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.a.2
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdClicked(View view, int i) {
                a aVar = a.this;
                TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener2 = aVar.f27744f;
                if (expressAdInteractionListener2 != null) {
                    expressAdInteractionListener2.onAdClicked(aVar, i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdShow(View view, int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(View view, String str, int i) {
                a aVar = a.this;
                TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener2 = aVar.f27744f;
                if (expressAdInteractionListener2 != null) {
                    expressAdInteractionListener2.onRenderFail(aVar, str, i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderSuccess(View view, float f2, float f3) {
                if (!(view instanceof NativeExpressView) || !((NativeExpressView) view).m()) {
                    a.this.a(f2, f3);
                }
                a aVar = a.this;
                TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener2 = aVar.f27744f;
                if (expressAdInteractionListener2 != null) {
                    expressAdInteractionListener2.onRenderSuccess(aVar, f2, f3);
                }
            }
        });
    }

    public void setVideoAdListener(TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener) {
        this.f27745g = expressVideoAdListener;
    }

    public void a() {
        NativeExpressView nativeExpressView = new NativeExpressView(this.f27739a, this.f27742d, this.f27743e, this.j);
        this.f27740b = nativeExpressView;
        addView(nativeExpressView, new ViewGroup.LayoutParams(-1, -1));
    }

    public void a(l lVar, AdSlot adSlot) {
        NativeExpressView nativeExpressView = new NativeExpressView(this.f27739a, lVar, adSlot, this.j);
        this.f27741c = nativeExpressView;
        nativeExpressView.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.a.1
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdClicked(View view, int i) {
                a aVar = a.this;
                TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener = aVar.f27744f;
                if (expressAdInteractionListener != null) {
                    expressAdInteractionListener.onAdClicked(aVar, i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdShow(View view, int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(View view, String str, int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderSuccess(View view, float f2, float f3) {
                a.this.a(f2, f3);
                a.this.f();
            }
        });
        al.a((View) this.f27741c, 8);
        addView(this.f27741c, new ViewGroup.LayoutParams(-1, -1));
    }

    public boolean b() {
        return this.f27741c != null;
    }

    public void a(float f2, float f3) {
        int a2 = (int) al.a(this.f27739a, f2);
        int a3 = (int) al.a(this.f27739a, f3);
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
