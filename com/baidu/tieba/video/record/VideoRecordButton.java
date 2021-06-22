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
    public View f21567e;

    /* renamed from: f  reason: collision with root package name */
    public View f21568f;

    /* renamed from: g  reason: collision with root package name */
    public View f21569g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f21570h;

    /* renamed from: i  reason: collision with root package name */
    public ObjectAnimator f21571i;
    public ObjectAnimator j;
    public ObjectAnimator k;
    public ObjectAnimator l;

    public VideoRecordButton(Context context) {
        super(context);
        a();
    }

    public final void a() {
        FrameLayout.inflate(getContext(), R.layout.layout_record_button, this);
        this.f21567e = findViewById(R.id.record_layer1);
        this.f21568f = findViewById(R.id.record_layer2);
        this.f21569g = findViewById(R.id.record_layer3);
        this.f21570h = (TextView) findViewById(R.id.tv_tip);
        this.f21569g.setScaleX(0.766f);
        this.f21569g.setScaleY(0.766f);
    }

    public void b(boolean z) {
        ObjectAnimator objectAnimator = this.j;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.j.cancel();
        }
        if (this.f21571i == null) {
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f21569g, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.f21571i = ofPropertyValuesHolder;
            ofPropertyValuesHolder.setRepeatCount(-1);
            this.f21571i.setRepeatMode(2);
            this.f21571i.setDuration(1000L);
        }
        this.f21569g.setVisibility(0);
        if (z) {
            this.f21567e.setVisibility(8);
        } else {
            this.f21567e.setBackgroundResource(R.drawable.red_square_bg);
        }
        this.f21570h.setVisibility(8);
        this.f21571i.start();
    }

    public void c() {
        ObjectAnimator objectAnimator = this.l;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.k.cancel();
        }
        if (this.k == null) {
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f21568f, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.k = ofPropertyValuesHolder;
            ofPropertyValuesHolder.setDuration(200L);
        }
        this.k.start();
    }

    public void d() {
        ObjectAnimator objectAnimator = this.f21571i;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.f21571i.cancel();
        }
        if (this.j == null) {
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f21569g, PropertyValuesHolder.ofFloat("scaleX", this.f21569g.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.f21569g.getScaleY(), 0.766f));
            this.j = ofPropertyValuesHolder;
            ofPropertyValuesHolder.setDuration((Math.abs(0.766f - this.f21569g.getScaleX()) * 500.0f) / 0.3f);
        }
        this.f21567e.setVisibility(0);
        this.f21567e.setBackgroundResource(R.drawable.red_circle_bg);
        this.j.start();
    }

    public void e() {
        ObjectAnimator objectAnimator = this.k;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.k.cancel();
        }
        if (this.f21568f.getScaleX() == 1.0f) {
            return;
        }
        if (this.l == null) {
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f21568f, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
            this.l = ofPropertyValuesHolder;
            ofPropertyValuesHolder.setDuration(200L);
        }
        this.l.start();
    }

    public View getLayer1() {
        return this.f21567e;
    }

    public View getLayer2() {
        return this.f21568f;
    }

    public View getLayer3() {
        return this.f21569g;
    }

    public TextView getTvTip() {
        return this.f21570h;
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
