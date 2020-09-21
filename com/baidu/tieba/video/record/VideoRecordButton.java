package com.baidu.tieba.video.record;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class VideoRecordButton extends FrameLayout {
    private TextView aaR;
    private View mNE;
    private View mNF;
    private View mNG;
    private ObjectAnimator mNH;
    private ObjectAnimator mNI;
    private ObjectAnimator mNJ;
    private ObjectAnimator mNK;

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
        this.mNE = findViewById(R.id.record_layer1);
        this.mNF = findViewById(R.id.record_layer2);
        this.mNG = findViewById(R.id.record_layer3);
        this.aaR = (TextView) findViewById(R.id.tv_tip);
        this.mNG.setScaleX(0.766f);
        this.mNG.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.mNG;
    }

    public View getLayer1() {
        return this.mNE;
    }

    public View getLayer2() {
        return this.mNF;
    }

    public TextView getTvTip() {
        return this.aaR;
    }

    public void dIi() {
        if (this.mNK != null && this.mNK.isRunning()) {
            this.mNJ.cancel();
        }
        if (this.mNJ == null) {
            this.mNJ = ObjectAnimator.ofPropertyValuesHolder(this.mNF, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.mNJ.setDuration(200L);
        }
        this.mNJ.start();
    }

    public void dIj() {
        if (this.mNJ != null && this.mNJ.isRunning()) {
            this.mNJ.cancel();
        }
        if (this.mNF.getScaleX() != 1.0f) {
            if (this.mNK == null) {
                this.mNK = ObjectAnimator.ofPropertyValuesHolder(this.mNF, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.mNK.setDuration(200L);
            }
            this.mNK.start();
        }
    }

    public void wY(boolean z) {
        if (this.mNI != null && this.mNI.isRunning()) {
            this.mNI.cancel();
        }
        if (this.mNH == null) {
            this.mNH = ObjectAnimator.ofPropertyValuesHolder(this.mNG, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.mNH.setRepeatCount(-1);
            this.mNH.setRepeatMode(2);
            this.mNH.setDuration(1000L);
        }
        this.mNG.setVisibility(0);
        if (z) {
            this.mNE.setVisibility(8);
        } else {
            this.mNE.setBackgroundResource(R.drawable.red_square_bg);
        }
        this.aaR.setVisibility(8);
        this.mNH.start();
    }

    public void dHX() {
        if (this.mNH != null && this.mNH.isRunning()) {
            this.mNH.cancel();
        }
        if (this.mNI == null) {
            this.mNI = ObjectAnimator.ofPropertyValuesHolder(this.mNG, PropertyValuesHolder.ofFloat("scaleX", this.mNG.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.mNG.getScaleY(), 0.766f));
            this.mNI.setDuration((500.0f * Math.abs(0.766f - this.mNG.getScaleX())) / 0.3f);
        }
        this.mNE.setVisibility(0);
        this.mNE.setBackgroundResource(R.drawable.red_circle_bg);
        this.mNI.start();
    }
}
