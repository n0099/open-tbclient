package com.baidu.tieba.video.record;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class VideoRecordButton extends FrameLayout {
    private TextView acm;
    private View nKR;
    private View nKS;
    private View nKT;
    private ObjectAnimator nKU;
    private ObjectAnimator nKV;
    private ObjectAnimator nKW;
    private ObjectAnimator nKX;

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
        inflate(getContext(), R.layout.layout_record_button, this);
        this.nKR = findViewById(R.id.record_layer1);
        this.nKS = findViewById(R.id.record_layer2);
        this.nKT = findViewById(R.id.record_layer3);
        this.acm = (TextView) findViewById(R.id.tv_tip);
        this.nKT.setScaleX(0.766f);
        this.nKT.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.nKT;
    }

    public View getLayer1() {
        return this.nKR;
    }

    public View getLayer2() {
        return this.nKS;
    }

    public TextView getTvTip() {
        return this.acm;
    }

    public void dWY() {
        if (this.nKX != null && this.nKX.isRunning()) {
            this.nKW.cancel();
        }
        if (this.nKW == null) {
            this.nKW = ObjectAnimator.ofPropertyValuesHolder(this.nKS, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.nKW.setDuration(200L);
        }
        this.nKW.start();
    }

    public void dWZ() {
        if (this.nKW != null && this.nKW.isRunning()) {
            this.nKW.cancel();
        }
        if (this.nKS.getScaleX() != 1.0f) {
            if (this.nKX == null) {
                this.nKX = ObjectAnimator.ofPropertyValuesHolder(this.nKS, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.nKX.setDuration(200L);
            }
            this.nKX.start();
        }
    }

    public void yR(boolean z) {
        if (this.nKV != null && this.nKV.isRunning()) {
            this.nKV.cancel();
        }
        if (this.nKU == null) {
            this.nKU = ObjectAnimator.ofPropertyValuesHolder(this.nKT, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.nKU.setRepeatCount(-1);
            this.nKU.setRepeatMode(2);
            this.nKU.setDuration(1000L);
        }
        this.nKT.setVisibility(0);
        if (z) {
            this.nKR.setVisibility(8);
        } else {
            this.nKR.setBackgroundResource(R.drawable.red_square_bg);
        }
        this.acm.setVisibility(8);
        this.nKU.start();
    }

    public void dWN() {
        if (this.nKU != null && this.nKU.isRunning()) {
            this.nKU.cancel();
        }
        if (this.nKV == null) {
            this.nKV = ObjectAnimator.ofPropertyValuesHolder(this.nKT, PropertyValuesHolder.ofFloat("scaleX", this.nKT.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.nKT.getScaleY(), 0.766f));
            this.nKV.setDuration((500.0f * Math.abs(0.766f - this.nKT.getScaleX())) / 0.3f);
        }
        this.nKR.setVisibility(0);
        this.nKR.setBackgroundResource(R.drawable.red_circle_bg);
        this.nKV.start();
    }
}
