package com.baidu.tieba.video.record;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class VideoRecordButton extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public View f21407e;

    /* renamed from: f  reason: collision with root package name */
    public View f21408f;

    /* renamed from: g  reason: collision with root package name */
    public View f21409g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f21410h;

    /* renamed from: i  reason: collision with root package name */
    public ObjectAnimator f21411i;
    public ObjectAnimator j;
    public ObjectAnimator k;
    public ObjectAnimator l;

    public VideoRecordButton(Context context) {
        super(context);
        a();
    }

    public final void a() {
        FrameLayout.inflate(getContext(), R.layout.layout_record_button, this);
        this.f21407e = findViewById(R.id.record_layer1);
        this.f21408f = findViewById(R.id.record_layer2);
        this.f21409g = findViewById(R.id.record_layer3);
        this.f21410h = (TextView) findViewById(R.id.tv_tip);
        this.f21409g.setScaleX(0.766f);
        this.f21409g.setScaleY(0.766f);
    }

    public void b(boolean z) {
        ObjectAnimator objectAnimator = this.j;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.j.cancel();
        }
        if (this.f21411i == null) {
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f21409g, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.f21411i = ofPropertyValuesHolder;
            ofPropertyValuesHolder.setRepeatCount(-1);
            this.f21411i.setRepeatMode(2);
            this.f21411i.setDuration(1000L);
        }
        this.f21409g.setVisibility(0);
        if (z) {
            this.f21407e.setVisibility(8);
        } else {
            this.f21407e.setBackgroundResource(R.drawable.red_square_bg);
        }
        this.f21410h.setVisibility(8);
        this.f21411i.start();
    }

    public void c() {
        ObjectAnimator objectAnimator = this.l;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.k.cancel();
        }
        if (this.k == null) {
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f21408f, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.k = ofPropertyValuesHolder;
            ofPropertyValuesHolder.setDuration(200L);
        }
        this.k.start();
    }

    public void d() {
        ObjectAnimator objectAnimator = this.f21411i;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.f21411i.cancel();
        }
        if (this.j == null) {
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f21409g, PropertyValuesHolder.ofFloat("scaleX", this.f21409g.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.f21409g.getScaleY(), 0.766f));
            this.j = ofPropertyValuesHolder;
            ofPropertyValuesHolder.setDuration((Math.abs(0.766f - this.f21409g.getScaleX()) * 500.0f) / 0.3f);
        }
        this.f21407e.setVisibility(0);
        this.f21407e.setBackgroundResource(R.drawable.red_circle_bg);
        this.j.start();
    }

    public void e() {
        ObjectAnimator objectAnimator = this.k;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.k.cancel();
        }
        if (this.f21408f.getScaleX() == 1.0f) {
            return;
        }
        if (this.l == null) {
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f21408f, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
            this.l = ofPropertyValuesHolder;
            ofPropertyValuesHolder.setDuration(200L);
        }
        this.l.start();
    }

    public View getLayer1() {
        return this.f21407e;
    }

    public View getLayer2() {
        return this.f21408f;
    }

    public View getLayer3() {
        return this.f21409g;
    }

    public TextView getTvTip() {
        return this.f21410h;
    }

    public VideoRecordButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public VideoRecordButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
