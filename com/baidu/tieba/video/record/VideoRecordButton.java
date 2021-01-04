package com.baidu.tieba.video.record;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class VideoRecordButton extends FrameLayout {
    private TextView acY;
    private View nOm;
    private View nOn;
    private View nOo;
    private ObjectAnimator nOp;
    private ObjectAnimator nOq;
    private ObjectAnimator nOr;
    private ObjectAnimator nOs;

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
        this.nOm = findViewById(R.id.record_layer1);
        this.nOn = findViewById(R.id.record_layer2);
        this.nOo = findViewById(R.id.record_layer3);
        this.acY = (TextView) findViewById(R.id.tv_tip);
        this.nOo.setScaleX(0.766f);
        this.nOo.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.nOo;
    }

    public View getLayer1() {
        return this.nOm;
    }

    public View getLayer2() {
        return this.nOn;
    }

    public TextView getTvTip() {
        return this.acY;
    }

    public void dWB() {
        if (this.nOs != null && this.nOs.isRunning()) {
            this.nOr.cancel();
        }
        if (this.nOr == null) {
            this.nOr = ObjectAnimator.ofPropertyValuesHolder(this.nOn, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.nOr.setDuration(200L);
        }
        this.nOr.start();
    }

    public void dWC() {
        if (this.nOr != null && this.nOr.isRunning()) {
            this.nOr.cancel();
        }
        if (this.nOn.getScaleX() != 1.0f) {
            if (this.nOs == null) {
                this.nOs = ObjectAnimator.ofPropertyValuesHolder(this.nOn, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.nOs.setDuration(200L);
            }
            this.nOs.start();
        }
    }

    public void yR(boolean z) {
        if (this.nOq != null && this.nOq.isRunning()) {
            this.nOq.cancel();
        }
        if (this.nOp == null) {
            this.nOp = ObjectAnimator.ofPropertyValuesHolder(this.nOo, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.nOp.setRepeatCount(-1);
            this.nOp.setRepeatMode(2);
            this.nOp.setDuration(1000L);
        }
        this.nOo.setVisibility(0);
        if (z) {
            this.nOm.setVisibility(8);
        } else {
            this.nOm.setBackgroundResource(R.drawable.red_square_bg);
        }
        this.acY.setVisibility(8);
        this.nOp.start();
    }

    public void dWq() {
        if (this.nOp != null && this.nOp.isRunning()) {
            this.nOp.cancel();
        }
        if (this.nOq == null) {
            this.nOq = ObjectAnimator.ofPropertyValuesHolder(this.nOo, PropertyValuesHolder.ofFloat("scaleX", this.nOo.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.nOo.getScaleY(), 0.766f));
            this.nOq.setDuration((500.0f * Math.abs(0.766f - this.nOo.getScaleX())) / 0.3f);
        }
        this.nOm.setVisibility(0);
        this.nOm.setBackgroundResource(R.drawable.red_circle_bg);
        this.nOq.start();
    }
}
