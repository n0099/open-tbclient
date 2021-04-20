package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes5.dex */
public class AlaPlayAnimationView extends ImageView {

    /* renamed from: e  reason: collision with root package name */
    public ObjectAnimator f21700e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f21701f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f21702g;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.f21701f = false;
        this.f21702g = false;
        a();
    }

    public final void a() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.f21700e = ofFloat;
        ofFloat.setRepeatMode(1);
        this.f21700e.setRepeatCount(-1);
        this.f21700e.setDuration(700L);
        setVisibility(8);
        this.f21701f = false;
    }

    public void b() {
        if (this.f21701f) {
            return;
        }
        this.f21701f = true;
        if (this.f21700e != null) {
            setVisibility(0);
            this.f21700e.start();
        }
    }

    public void c() {
        ObjectAnimator objectAnimator = this.f21700e;
        if (objectAnimator != null) {
            objectAnimator.setRepeatCount(-1);
            this.f21700e.cancel();
            clearAnimation();
        }
        this.f21701f = false;
        setVisibility(8);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f21702g) {
            b();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    public void setAutoStartPlay(boolean z) {
        this.f21702g = z;
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21701f = false;
        this.f21702g = false;
        a();
    }
}
