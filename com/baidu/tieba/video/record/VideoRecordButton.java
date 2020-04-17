package com.baidu.tieba.video.record;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class VideoRecordButton extends FrameLayout {
    private TextView YZ;
    private View lqL;
    private View lqM;
    private View lqN;
    private ObjectAnimator lqO;
    private ObjectAnimator lqP;
    private ObjectAnimator lqQ;
    private ObjectAnimator lqR;

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
        this.lqL = findViewById(R.id.record_layer1);
        this.lqM = findViewById(R.id.record_layer2);
        this.lqN = findViewById(R.id.record_layer3);
        this.YZ = (TextView) findViewById(R.id.tv_tip);
        this.lqN.setScaleX(0.766f);
        this.lqN.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.lqN;
    }

    public View getLayer1() {
        return this.lqL;
    }

    public View getLayer2() {
        return this.lqM;
    }

    public TextView getTvTip() {
        return this.YZ;
    }

    public void ddJ() {
        if (this.lqR != null && this.lqR.isRunning()) {
            this.lqQ.cancel();
        }
        if (this.lqQ == null) {
            this.lqQ = ObjectAnimator.ofPropertyValuesHolder(this.lqM, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.lqQ.setDuration(200L);
        }
        this.lqQ.start();
    }

    public void ddK() {
        if (this.lqQ != null && this.lqQ.isRunning()) {
            this.lqQ.cancel();
        }
        if (this.lqM.getScaleX() != 1.0f) {
            if (this.lqR == null) {
                this.lqR = ObjectAnimator.ofPropertyValuesHolder(this.lqM, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.lqR.setDuration(200L);
            }
            this.lqR.start();
        }
    }

    public void uE(boolean z) {
        if (this.lqP != null && this.lqP.isRunning()) {
            this.lqP.cancel();
        }
        if (this.lqO == null) {
            this.lqO = ObjectAnimator.ofPropertyValuesHolder(this.lqN, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.lqO.setRepeatCount(-1);
            this.lqO.setRepeatMode(2);
            this.lqO.setDuration(1000L);
        }
        this.lqN.setVisibility(0);
        if (z) {
            this.lqL.setVisibility(8);
        } else {
            this.lqL.setBackgroundResource(R.drawable.red_square_bg);
        }
        this.YZ.setVisibility(8);
        this.lqO.start();
    }

    public void ddy() {
        if (this.lqO != null && this.lqO.isRunning()) {
            this.lqO.cancel();
        }
        if (this.lqP == null) {
            this.lqP = ObjectAnimator.ofPropertyValuesHolder(this.lqN, PropertyValuesHolder.ofFloat("scaleX", this.lqN.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.lqN.getScaleY(), 0.766f));
            this.lqP.setDuration((500.0f * Math.abs(0.766f - this.lqN.getScaleX())) / 0.3f);
        }
        this.lqL.setVisibility(0);
        this.lqL.setBackgroundResource(R.drawable.red_circle_bg);
        this.lqP.start();
    }
}
