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
    private TextView Zc;
    private View lqP;
    private View lqQ;
    private View lqR;
    private ObjectAnimator lqS;
    private ObjectAnimator lqT;
    private ObjectAnimator lqU;
    private ObjectAnimator lqV;

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
        this.lqP = findViewById(R.id.record_layer1);
        this.lqQ = findViewById(R.id.record_layer2);
        this.lqR = findViewById(R.id.record_layer3);
        this.Zc = (TextView) findViewById(R.id.tv_tip);
        this.lqR.setScaleX(0.766f);
        this.lqR.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.lqR;
    }

    public View getLayer1() {
        return this.lqP;
    }

    public View getLayer2() {
        return this.lqQ;
    }

    public TextView getTvTip() {
        return this.Zc;
    }

    public void ddH() {
        if (this.lqV != null && this.lqV.isRunning()) {
            this.lqU.cancel();
        }
        if (this.lqU == null) {
            this.lqU = ObjectAnimator.ofPropertyValuesHolder(this.lqQ, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.lqU.setDuration(200L);
        }
        this.lqU.start();
    }

    public void ddI() {
        if (this.lqU != null && this.lqU.isRunning()) {
            this.lqU.cancel();
        }
        if (this.lqQ.getScaleX() != 1.0f) {
            if (this.lqV == null) {
                this.lqV = ObjectAnimator.ofPropertyValuesHolder(this.lqQ, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.lqV.setDuration(200L);
            }
            this.lqV.start();
        }
    }

    public void uE(boolean z) {
        if (this.lqT != null && this.lqT.isRunning()) {
            this.lqT.cancel();
        }
        if (this.lqS == null) {
            this.lqS = ObjectAnimator.ofPropertyValuesHolder(this.lqR, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.lqS.setRepeatCount(-1);
            this.lqS.setRepeatMode(2);
            this.lqS.setDuration(1000L);
        }
        this.lqR.setVisibility(0);
        if (z) {
            this.lqP.setVisibility(8);
        } else {
            this.lqP.setBackgroundResource(R.drawable.red_square_bg);
        }
        this.Zc.setVisibility(8);
        this.lqS.start();
    }

    public void ddw() {
        if (this.lqS != null && this.lqS.isRunning()) {
            this.lqS.cancel();
        }
        if (this.lqT == null) {
            this.lqT = ObjectAnimator.ofPropertyValuesHolder(this.lqR, PropertyValuesHolder.ofFloat("scaleX", this.lqR.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.lqR.getScaleY(), 0.766f));
            this.lqT.setDuration((500.0f * Math.abs(0.766f - this.lqR.getScaleX())) / 0.3f);
        }
        this.lqP.setVisibility(0);
        this.lqP.setBackgroundResource(R.drawable.red_circle_bg);
        this.lqT.start();
    }
}
