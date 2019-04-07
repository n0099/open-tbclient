package com.baidu.tieba.video.record;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class VideoRecordButton extends FrameLayout {
    private TextView VM;
    private View jet;
    private View jeu;
    private View jev;
    private ObjectAnimator jew;
    private ObjectAnimator jex;
    private ObjectAnimator jey;
    private ObjectAnimator jez;

    public VideoRecordButton(Context context) {
        super(context);
        initView();
    }

    public VideoRecordButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public VideoRecordButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        inflate(getContext(), d.h.layout_record_button, this);
        this.jet = findViewById(d.g.record_layer1);
        this.jeu = findViewById(d.g.record_layer2);
        this.jev = findViewById(d.g.record_layer3);
        this.VM = (TextView) findViewById(d.g.tv_tip);
        this.jev.setScaleX(0.766f);
        this.jev.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.jev;
    }

    public View getLayer1() {
        return this.jet;
    }

    public View getLayer2() {
        return this.jeu;
    }

    public TextView getTvTip() {
        return this.VM;
    }

    public void cmf() {
        if (this.jez != null && this.jez.isRunning()) {
            this.jey.cancel();
        }
        if (this.jey == null) {
            this.jey = ObjectAnimator.ofPropertyValuesHolder(this.jeu, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.jey.setDuration(200L);
        }
        this.jey.start();
    }

    public void cmg() {
        if (this.jey != null && this.jey.isRunning()) {
            this.jey.cancel();
        }
        if (this.jeu.getScaleX() != 1.0f) {
            if (this.jez == null) {
                this.jez = ObjectAnimator.ofPropertyValuesHolder(this.jeu, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.jez.setDuration(200L);
            }
            this.jez.start();
        }
    }

    public void qK(boolean z) {
        if (this.jex != null && this.jex.isRunning()) {
            this.jex.cancel();
        }
        if (this.jew == null) {
            this.jew = ObjectAnimator.ofPropertyValuesHolder(this.jev, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.jew.setRepeatCount(-1);
            this.jew.setRepeatMode(2);
            this.jew.setDuration(1000L);
        }
        this.jev.setVisibility(0);
        if (z) {
            this.jet.setVisibility(8);
        } else {
            this.jet.setBackgroundResource(d.f.red_square_bg);
        }
        this.VM.setVisibility(8);
        this.jew.start();
    }

    public void clU() {
        if (this.jew != null && this.jew.isRunning()) {
            this.jew.cancel();
        }
        if (this.jex == null) {
            this.jex = ObjectAnimator.ofPropertyValuesHolder(this.jev, PropertyValuesHolder.ofFloat("scaleX", this.jev.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.jev.getScaleY(), 0.766f));
            this.jex.setDuration((500.0f * Math.abs(0.766f - this.jev.getScaleX())) / 0.3f);
        }
        this.jet.setVisibility(0);
        this.jet.setBackgroundResource(d.f.red_circle_bg);
        this.jex.start();
    }
}
