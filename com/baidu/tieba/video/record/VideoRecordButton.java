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
    private TextView axM;
    private View hwU;
    private View hwV;
    private View hwW;
    private ObjectAnimator hwX;
    private ObjectAnimator hwY;
    private ObjectAnimator hwZ;
    private ObjectAnimator hxa;

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
        this.hwU = findViewById(d.g.record_layer1);
        this.hwV = findViewById(d.g.record_layer2);
        this.hwW = findViewById(d.g.record_layer3);
        this.axM = (TextView) findViewById(d.g.tv_tip);
        this.hwW.setScaleX(0.766f);
        this.hwW.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.hwW;
    }

    public View getLayer1() {
        return this.hwU;
    }

    public View getLayer2() {
        return this.hwV;
    }

    public TextView getTvTip() {
        return this.axM;
    }

    public void bDE() {
        if (this.hxa != null && this.hxa.isRunning()) {
            this.hwZ.cancel();
        }
        if (this.hwZ == null) {
            this.hwZ = ObjectAnimator.ofPropertyValuesHolder(this.hwV, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.hwZ.setDuration(200L);
        }
        this.hwZ.start();
    }

    public void bDF() {
        if (this.hwZ != null && this.hwZ.isRunning()) {
            this.hwZ.cancel();
        }
        if (this.hwV.getScaleX() != 1.0f) {
            if (this.hxa == null) {
                this.hxa = ObjectAnimator.ofPropertyValuesHolder(this.hwV, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.hxa.setDuration(200L);
            }
            this.hxa.start();
        }
    }

    public void nk(boolean z) {
        if (this.hwY != null && this.hwY.isRunning()) {
            this.hwY.cancel();
        }
        if (this.hwX == null) {
            this.hwX = ObjectAnimator.ofPropertyValuesHolder(this.hwW, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.hwX.setRepeatCount(-1);
            this.hwX.setRepeatMode(2);
            this.hwX.setDuration(1000L);
        }
        this.hwW.setVisibility(0);
        if (z) {
            this.hwU.setVisibility(8);
        } else {
            this.hwU.setBackgroundResource(d.f.red_square_bg);
        }
        this.axM.setVisibility(8);
        this.hwX.start();
    }

    public void bDt() {
        if (this.hwX != null && this.hwX.isRunning()) {
            this.hwX.cancel();
        }
        if (this.hwY == null) {
            this.hwY = ObjectAnimator.ofPropertyValuesHolder(this.hwW, PropertyValuesHolder.ofFloat("scaleX", this.hwW.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.hwW.getScaleY(), 0.766f));
            this.hwY.setDuration((500.0f * Math.abs(0.766f - this.hwW.getScaleX())) / 0.3f);
        }
        this.hwU.setVisibility(0);
        this.hwU.setBackgroundResource(d.f.red_circle_bg);
        this.hwY.start();
    }
}
