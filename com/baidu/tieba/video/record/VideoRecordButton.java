package com.baidu.tieba.video.record;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class VideoRecordButton extends FrameLayout {
    private TextView IQ;
    private View hah;
    private View hai;
    private View haj;
    private ObjectAnimator hak;
    private ObjectAnimator hal;
    private ObjectAnimator ham;
    private ObjectAnimator han;

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
        this.hah = findViewById(d.g.record_layer1);
        this.hai = findViewById(d.g.record_layer2);
        this.haj = findViewById(d.g.record_layer3);
        this.IQ = (TextView) findViewById(d.g.tv_tip);
        this.haj.setScaleX(0.766f);
        this.haj.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.haj;
    }

    public View getLayer1() {
        return this.hah;
    }

    public View getLayer2() {
        return this.hai;
    }

    public TextView getTvTip() {
        return this.IQ;
    }

    public void bEE() {
        if (this.han != null && this.han.isRunning()) {
            this.ham.cancel();
        }
        if (this.ham == null) {
            this.ham = ObjectAnimator.ofPropertyValuesHolder(this.hai, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.ham.setDuration(200L);
        }
        this.ham.start();
    }

    public void bEF() {
        if (this.ham != null && this.ham.isRunning()) {
            this.ham.cancel();
        }
        if (this.hai.getScaleX() != 1.0f) {
            if (this.han == null) {
                this.han = ObjectAnimator.ofPropertyValuesHolder(this.hai, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.han.setDuration(200L);
            }
            this.han.start();
        }
    }

    public void nN(boolean z) {
        if (this.hal != null && this.hal.isRunning()) {
            this.hal.cancel();
        }
        if (this.hak == null) {
            this.hak = ObjectAnimator.ofPropertyValuesHolder(this.haj, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.hak.setRepeatCount(-1);
            this.hak.setRepeatMode(2);
            this.hak.setDuration(1000L);
        }
        this.haj.setVisibility(0);
        if (z) {
            this.hah.setVisibility(8);
        } else {
            this.hah.setBackgroundResource(d.f.red_square_bg);
        }
        this.IQ.setVisibility(8);
        this.hak.start();
    }

    public void bEu() {
        if (this.hak != null && this.hak.isRunning()) {
            this.hak.cancel();
        }
        if (this.hal == null) {
            this.hal = ObjectAnimator.ofPropertyValuesHolder(this.haj, PropertyValuesHolder.ofFloat("scaleX", this.haj.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.haj.getScaleY(), 0.766f));
            this.hal.setDuration((500.0f * Math.abs(0.766f - this.haj.getScaleX())) / 0.3f);
        }
        this.hah.setVisibility(0);
        this.hah.setBackgroundResource(d.f.red_circle_bg);
        this.hal.start();
    }
}
