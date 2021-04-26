package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes5.dex */
public class AlaPlayAnimationView extends ImageView {

    /* renamed from: e  reason: collision with root package name */
    public ObjectAnimator f22353e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f22354f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f22355g;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.f22354f = false;
        this.f22355g = false;
        a();
    }

    public final void a() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.f22353e = ofFloat;
        ofFloat.setRepeatMode(1);
        this.f22353e.setRepeatCount(-1);
        this.f22353e.setDuration(700L);
        setVisibility(8);
        this.f22354f = false;
    }

    public void b() {
        if (this.f22354f) {
            return;
        }
        this.f22354f = true;
        if (this.f22353e != null) {
            setVisibility(0);
            this.f22353e.start();
        }
    }

    public void c() {
        ObjectAnimator objectAnimator = this.f22353e;
        if (objectAnimator != null) {
            objectAnimator.setRepeatCount(-1);
            this.f22353e.cancel();
            clearAnimation();
        }
        this.f22354f = false;
        setVisibility(8);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f22355g) {
            b();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    public void setAutoStartPlay(boolean z) {
        this.f22355g = z;
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22354f = false;
        this.f22355g = false;
        a();
    }
}
