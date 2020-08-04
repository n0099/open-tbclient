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
    private View mlO;
    private View mlP;
    private View mlQ;
    private ObjectAnimator mlR;
    private ObjectAnimator mlS;
    private ObjectAnimator mlT;
    private ObjectAnimator mlU;

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
        this.mlO = findViewById(R.id.record_layer1);
        this.mlP = findViewById(R.id.record_layer2);
        this.mlQ = findViewById(R.id.record_layer3);
        this.ZR = (TextView) findViewById(R.id.tv_tip);
        this.mlQ.setScaleX(0.766f);
        this.mlQ.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.mlQ;
    }

    public View getLayer1() {
        return this.mlO;
    }

    public View getLayer2() {
        return this.mlP;
    }

    public TextView getTvTip() {
        return this.ZR;
    }

    public void dsK() {
        if (this.mlU != null && this.mlU.isRunning()) {
            this.mlT.cancel();
        }
        if (this.mlT == null) {
            this.mlT = ObjectAnimator.ofPropertyValuesHolder(this.mlP, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.mlT.setDuration(200L);
        }
        this.mlT.start();
    }

    public void dsL() {
        if (this.mlT != null && this.mlT.isRunning()) {
            this.mlT.cancel();
        }
        if (this.mlP.getScaleX() != 1.0f) {
            if (this.mlU == null) {
                this.mlU = ObjectAnimator.ofPropertyValuesHolder(this.mlP, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.mlU.setDuration(200L);
            }
            this.mlU.start();
        }
    }

    public void vY(boolean z) {
        if (this.mlS != null && this.mlS.isRunning()) {
            this.mlS.cancel();
        }
        if (this.mlR == null) {
            this.mlR = ObjectAnimator.ofPropertyValuesHolder(this.mlQ, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.mlR.setRepeatCount(-1);
            this.mlR.setRepeatMode(2);
            this.mlR.setDuration(1000L);
        }
        this.mlQ.setVisibility(0);
        if (z) {
            this.mlO.setVisibility(8);
        } else {
            this.mlO.setBackgroundResource(R.drawable.red_square_bg);
        }
        this.ZR.setVisibility(8);
        this.mlR.start();
    }

    public void dsz() {
        if (this.mlR != null && this.mlR.isRunning()) {
            this.mlR.cancel();
        }
        if (this.mlS == null) {
            this.mlS = ObjectAnimator.ofPropertyValuesHolder(this.mlQ, PropertyValuesHolder.ofFloat("scaleX", this.mlQ.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.mlQ.getScaleY(), 0.766f));
            this.mlS.setDuration((500.0f * Math.abs(0.766f - this.mlQ.getScaleX())) / 0.3f);
        }
        this.mlO.setVisibility(0);
        this.mlO.setBackgroundResource(R.drawable.red_circle_bg);
        this.mlS.start();
    }
}
