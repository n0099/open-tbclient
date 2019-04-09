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
    private TextView VN;
    private ObjectAnimator jeA;
    private View jeu;
    private View jev;
    private View jew;
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
        this.jeu = findViewById(d.g.record_layer1);
        this.jev = findViewById(d.g.record_layer2);
        this.jew = findViewById(d.g.record_layer3);
        this.VN = (TextView) findViewById(d.g.tv_tip);
        this.jew.setScaleX(0.766f);
        this.jew.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.jew;
    }

    public View getLayer1() {
        return this.jeu;
    }

    public View getLayer2() {
        return this.jev;
    }

    public TextView getTvTip() {
        return this.VN;
    }

    public void cmf() {
        if (this.jeA != null && this.jeA.isRunning()) {
            this.jez.cancel();
        }
        if (this.jez == null) {
            this.jez = ObjectAnimator.ofPropertyValuesHolder(this.jev, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.jez.setDuration(200L);
        }
        this.jez.start();
    }

    public void cmg() {
        if (this.jez != null && this.jez.isRunning()) {
            this.jez.cancel();
        }
        if (this.jev.getScaleX() != 1.0f) {
            if (this.jeA == null) {
                this.jeA = ObjectAnimator.ofPropertyValuesHolder(this.jev, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.jeA.setDuration(200L);
            }
            this.jeA.start();
        }
    }

    public void qK(boolean z) {
        if (this.jey != null && this.jey.isRunning()) {
            this.jey.cancel();
        }
        if (this.jex == null) {
            this.jex = ObjectAnimator.ofPropertyValuesHolder(this.jew, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.jex.setRepeatCount(-1);
            this.jex.setRepeatMode(2);
            this.jex.setDuration(1000L);
        }
        this.jew.setVisibility(0);
        if (z) {
            this.jeu.setVisibility(8);
        } else {
            this.jeu.setBackgroundResource(d.f.red_square_bg);
        }
        this.VN.setVisibility(8);
        this.jex.start();
    }

    public void clU() {
        if (this.jex != null && this.jex.isRunning()) {
            this.jex.cancel();
        }
        if (this.jey == null) {
            this.jey = ObjectAnimator.ofPropertyValuesHolder(this.jew, PropertyValuesHolder.ofFloat("scaleX", this.jew.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.jew.getScaleY(), 0.766f));
            this.jey.setDuration((500.0f * Math.abs(0.766f - this.jew.getScaleX())) / 0.3f);
        }
        this.jeu.setVisibility(0);
        this.jeu.setBackgroundResource(d.f.red_circle_bg);
        this.jey.start();
    }
}
