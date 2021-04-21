package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes5.dex */
public class AlaPlayAnimationView extends ImageView {

    /* renamed from: e  reason: collision with root package name */
    public ObjectAnimator f21708e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f21709f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f21710g;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.f21709f = false;
        this.f21710g = false;
        a();
    }

    public final void a() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.f21708e = ofFloat;
        ofFloat.setRepeatMode(1);
        this.f21708e.setRepeatCount(-1);
        this.f21708e.setDuration(700L);
        setVisibility(8);
        this.f21709f = false;
    }

    public void b() {
        if (this.f21709f) {
            return;
        }
        this.f21709f = true;
        if (this.f21708e != null) {
            setVisibility(0);
            this.f21708e.start();
        }
    }

    public void c() {
        ObjectAnimator objectAnimator = this.f21708e;
        if (objectAnimator != null) {
            objectAnimator.setRepeatCount(-1);
            this.f21708e.cancel();
            clearAnimation();
        }
        this.f21709f = false;
        setVisibility(8);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f21710g) {
            b();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    public void setAutoStartPlay(boolean z) {
        this.f21710g = z;
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21709f = false;
        this.f21710g = false;
        a();
    }
}
