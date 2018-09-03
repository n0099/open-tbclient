package com.baidu.tieba.video.record;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class VideoRecordButton extends FrameLayout {
    private TextView Qf;
    private View hlT;
    private View hlU;
    private View hlV;
    private ObjectAnimator hlW;
    private ObjectAnimator hlX;
    private ObjectAnimator hlY;
    private ObjectAnimator hlZ;

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
        inflate(getContext(), f.h.layout_record_button, this);
        this.hlT = findViewById(f.g.record_layer1);
        this.hlU = findViewById(f.g.record_layer2);
        this.hlV = findViewById(f.g.record_layer3);
        this.Qf = (TextView) findViewById(f.g.tv_tip);
        this.hlV.setScaleX(0.766f);
        this.hlV.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.hlV;
    }

    public View getLayer1() {
        return this.hlT;
    }

    public View getLayer2() {
        return this.hlU;
    }

    public TextView getTvTip() {
        return this.Qf;
    }

    public void bDC() {
        if (this.hlZ != null && this.hlZ.isRunning()) {
            this.hlY.cancel();
        }
        if (this.hlY == null) {
            this.hlY = ObjectAnimator.ofPropertyValuesHolder(this.hlU, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.hlY.setDuration(200L);
        }
        this.hlY.start();
    }

    public void bDD() {
        if (this.hlY != null && this.hlY.isRunning()) {
            this.hlY.cancel();
        }
        if (this.hlU.getScaleX() != 1.0f) {
            if (this.hlZ == null) {
                this.hlZ = ObjectAnimator.ofPropertyValuesHolder(this.hlU, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.hlZ.setDuration(200L);
            }
            this.hlZ.start();
        }
    }

    public void nd(boolean z) {
        if (this.hlX != null && this.hlX.isRunning()) {
            this.hlX.cancel();
        }
        if (this.hlW == null) {
            this.hlW = ObjectAnimator.ofPropertyValuesHolder(this.hlV, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.hlW.setRepeatCount(-1);
            this.hlW.setRepeatMode(2);
            this.hlW.setDuration(1000L);
        }
        this.hlV.setVisibility(0);
        if (z) {
            this.hlT.setVisibility(8);
        } else {
            this.hlT.setBackgroundResource(f.C0146f.red_square_bg);
        }
        this.Qf.setVisibility(8);
        this.hlW.start();
    }

    public void bDr() {
        if (this.hlW != null && this.hlW.isRunning()) {
            this.hlW.cancel();
        }
        if (this.hlX == null) {
            this.hlX = ObjectAnimator.ofPropertyValuesHolder(this.hlV, PropertyValuesHolder.ofFloat("scaleX", this.hlV.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.hlV.getScaleY(), 0.766f));
            this.hlX.setDuration((500.0f * Math.abs(0.766f - this.hlV.getScaleX())) / 0.3f);
        }
        this.hlT.setVisibility(0);
        this.hlT.setBackgroundResource(f.C0146f.red_circle_bg);
        this.hlX.start();
    }
}
