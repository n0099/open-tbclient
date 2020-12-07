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
    private View nKP;
    private View nKQ;
    private View nKR;
    private ObjectAnimator nKS;
    private ObjectAnimator nKT;
    private ObjectAnimator nKU;
    private ObjectAnimator nKV;

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
        this.nKP = findViewById(R.id.record_layer1);
        this.nKQ = findViewById(R.id.record_layer2);
        this.nKR = findViewById(R.id.record_layer3);
        this.acm = (TextView) findViewById(R.id.tv_tip);
        this.nKR.setScaleX(0.766f);
        this.nKR.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.nKR;
    }

    public View getLayer1() {
        return this.nKP;
    }

    public View getLayer2() {
        return this.nKQ;
    }

    public TextView getTvTip() {
        return this.acm;
    }

    public void dWX() {
        if (this.nKV != null && this.nKV.isRunning()) {
            this.nKU.cancel();
        }
        if (this.nKU == null) {
            this.nKU = ObjectAnimator.ofPropertyValuesHolder(this.nKQ, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.nKU.setDuration(200L);
        }
        this.nKU.start();
    }

    public void dWY() {
        if (this.nKU != null && this.nKU.isRunning()) {
            this.nKU.cancel();
        }
        if (this.nKQ.getScaleX() != 1.0f) {
            if (this.nKV == null) {
                this.nKV = ObjectAnimator.ofPropertyValuesHolder(this.nKQ, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.nKV.setDuration(200L);
            }
            this.nKV.start();
        }
    }

    public void yR(boolean z) {
        if (this.nKT != null && this.nKT.isRunning()) {
            this.nKT.cancel();
        }
        if (this.nKS == null) {
            this.nKS = ObjectAnimator.ofPropertyValuesHolder(this.nKR, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.nKS.setRepeatCount(-1);
            this.nKS.setRepeatMode(2);
            this.nKS.setDuration(1000L);
        }
        this.nKR.setVisibility(0);
        if (z) {
            this.nKP.setVisibility(8);
        } else {
            this.nKP.setBackgroundResource(R.drawable.red_square_bg);
        }
        this.acm.setVisibility(8);
        this.nKS.start();
    }

    public void dWM() {
        if (this.nKS != null && this.nKS.isRunning()) {
            this.nKS.cancel();
        }
        if (this.nKT == null) {
            this.nKT = ObjectAnimator.ofPropertyValuesHolder(this.nKR, PropertyValuesHolder.ofFloat("scaleX", this.nKR.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.nKR.getScaleY(), 0.766f));
            this.nKT.setDuration((500.0f * Math.abs(0.766f - this.nKR.getScaleX())) / 0.3f);
        }
        this.nKP.setVisibility(0);
        this.nKP.setBackgroundResource(R.drawable.red_circle_bg);
        this.nKT.start();
    }
}
