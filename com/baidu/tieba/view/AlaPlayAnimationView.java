package com.baidu.tieba.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes5.dex */
public class AlaPlayAnimationView extends ImageView {

    /* renamed from: e  reason: collision with root package name */
    public ObjectAnimator f21711e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f21712f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f21713g;

    public AlaPlayAnimationView(Context context) {
        super(context);
        this.f21712f = false;
        this.f21713g = false;
        a();
    }

    public final void a() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f, 1.0f);
        this.f21711e = ofFloat;
        ofFloat.setRepeatMode(1);
        this.f21711e.setRepeatCount(-1);
        this.f21711e.setDuration(700L);
        setVisibility(8);
        this.f21712f = false;
    }

    public void b() {
        if (this.f21712f) {
            return;
        }
        this.f21712f = true;
        if (this.f21711e != null) {
            setVisibility(0);
            this.f21711e.start();
        }
    }

    public void c() {
        ObjectAnimator objectAnimator = this.f21711e;
        if (objectAnimator != null) {
            objectAnimator.setRepeatCount(-1);
            this.f21711e.cancel();
            clearAnimation();
        }
        this.f21712f = false;
        setVisibility(8);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f21713g) {
            b();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    public void setAutoStartPlay(boolean z) {
        this.f21713g = z;
    }

    public AlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21712f = false;
        this.f21713g = false;
        a();
    }
}
