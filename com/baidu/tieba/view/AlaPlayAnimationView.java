package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes5.dex */
public class AlaPlayAnimationView extends ImageView {

    /* renamed from: e  reason: collision with root package name */
    public ObjectAnimator f22015e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f22016f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f22017g;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.f22016f = false;
        this.f22017g = false;
        a();
    }

    public final void a() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.f22015e = ofFloat;
        ofFloat.setRepeatMode(1);
        this.f22015e.setRepeatCount(-1);
        this.f22015e.setDuration(700L);
        setVisibility(8);
        this.f22016f = false;
    }

    public void b() {
        if (this.f22016f) {
            return;
        }
        this.f22016f = true;
        if (this.f22015e != null) {
            setVisibility(0);
            this.f22015e.start();
        }
    }

    public void c() {
        ObjectAnimator objectAnimator = this.f22015e;
        if (objectAnimator != null) {
            objectAnimator.setRepeatCount(-1);
            this.f22015e.cancel();
            clearAnimation();
        }
        this.f22016f = false;
        setVisibility(8);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f22017g) {
            b();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    public void setAutoStartPlay(boolean z) {
        this.f22017g = z;
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22016f = false;
        this.f22017g = false;
        a();
    }
}
