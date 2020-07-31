package com.baidu.tieba.video.record;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class VideoRecordButton extends FrameLayout {
    private TextView ZR;
    private View mlM;
    private View mlN;
    private View mlO;
    private ObjectAnimator mlP;
    private ObjectAnimator mlQ;
    private ObjectAnimator mlR;
    private ObjectAnimator mlS;

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
        this.mlM = findViewById(R.id.record_layer1);
        this.mlN = findViewById(R.id.record_layer2);
        this.mlO = findViewById(R.id.record_layer3);
        this.ZR = (TextView) findViewById(R.id.tv_tip);
        this.mlO.setScaleX(0.766f);
        this.mlO.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.mlO;
    }

    public View getLayer1() {
        return this.mlM;
    }

    public View getLayer2() {
        return this.mlN;
    }

    public TextView getTvTip() {
        return this.ZR;
    }

    public void dsJ() {
        if (this.mlS != null && this.mlS.isRunning()) {
            this.mlR.cancel();
        }
        if (this.mlR == null) {
            this.mlR = ObjectAnimator.ofPropertyValuesHolder(this.mlN, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.mlR.setDuration(200L);
        }
        this.mlR.start();
    }

    public void dsK() {
        if (this.mlR != null && this.mlR.isRunning()) {
            this.mlR.cancel();
        }
        if (this.mlN.getScaleX() != 1.0f) {
            if (this.mlS == null) {
                this.mlS = ObjectAnimator.ofPropertyValuesHolder(this.mlN, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.mlS.setDuration(200L);
            }
            this.mlS.start();
        }
    }

    public void vY(boolean z) {
        if (this.mlQ != null && this.mlQ.isRunning()) {
            this.mlQ.cancel();
        }
        if (this.mlP == null) {
            this.mlP = ObjectAnimator.ofPropertyValuesHolder(this.mlO, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.mlP.setRepeatCount(-1);
            this.mlP.setRepeatMode(2);
            this.mlP.setDuration(1000L);
        }
        this.mlO.setVisibility(0);
        if (z) {
            this.mlM.setVisibility(8);
        } else {
            this.mlM.setBackgroundResource(R.drawable.red_square_bg);
        }
        this.ZR.setVisibility(8);
        this.mlP.start();
    }

    public void dsy() {
        if (this.mlP != null && this.mlP.isRunning()) {
            this.mlP.cancel();
        }
        if (this.mlQ == null) {
            this.mlQ = ObjectAnimator.ofPropertyValuesHolder(this.mlO, PropertyValuesHolder.ofFloat("scaleX", this.mlO.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.mlO.getScaleY(), 0.766f));
            this.mlQ.setDuration((500.0f * Math.abs(0.766f - this.mlO.getScaleX())) / 0.3f);
        }
        this.mlM.setVisibility(0);
        this.mlM.setBackgroundResource(R.drawable.red_circle_bg);
        this.mlQ.start();
    }
}
