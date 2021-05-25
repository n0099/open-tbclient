package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes5.dex */
public class AlaPlayAnimationView extends ImageView {

    /* renamed from: e  reason: collision with root package name */
    public ObjectAnimator f21526e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f21527f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f21528g;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.f21527f = false;
        this.f21528g = false;
        a();
    }

    public final void a() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.f21526e = ofFloat;
        ofFloat.setRepeatMode(1);
        this.f21526e.setRepeatCount(-1);
        this.f21526e.setDuration(700L);
        setVisibility(8);
        this.f21527f = false;
    }

    public void b() {
        if (this.f21527f) {
            return;
        }
        this.f21527f = true;
        if (this.f21526e != null) {
            setVisibility(0);
            this.f21526e.start();
        }
    }

    public void c() {
        ObjectAnimator objectAnimator = this.f21526e;
        if (objectAnimator != null) {
            objectAnimator.setRepeatCount(-1);
            this.f21526e.cancel();
            clearAnimation();
        }
        this.f21527f = false;
        setVisibility(8);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f21528g) {
            b();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    public void setAutoStartPlay(boolean z) {
        this.f21528g = z;
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21527f = false;
        this.f21528g = false;
        a();
    }
}
