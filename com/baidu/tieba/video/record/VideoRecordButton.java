package com.baidu.tieba.video.record;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class VideoRecordButton extends FrameLayout {
    private TextView acW;
    private View nJH;
    private View nJI;
    private View nJJ;
    private ObjectAnimator nJK;
    private ObjectAnimator nJL;
    private ObjectAnimator nJM;
    private ObjectAnimator nJN;

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
        this.nJH = findViewById(R.id.record_layer1);
        this.nJI = findViewById(R.id.record_layer2);
        this.nJJ = findViewById(R.id.record_layer3);
        this.acW = (TextView) findViewById(R.id.tv_tip);
        this.nJJ.setScaleX(0.766f);
        this.nJJ.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.nJJ;
    }

    public View getLayer1() {
        return this.nJH;
    }

    public View getLayer2() {
        return this.nJI;
    }

    public TextView getTvTip() {
        return this.acW;
    }

    public void dSK() {
        if (this.nJN != null && this.nJN.isRunning()) {
            this.nJM.cancel();
        }
        if (this.nJM == null) {
            this.nJM = ObjectAnimator.ofPropertyValuesHolder(this.nJI, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.nJM.setDuration(200L);
        }
        this.nJM.start();
    }

    public void dSL() {
        if (this.nJM != null && this.nJM.isRunning()) {
            this.nJM.cancel();
        }
        if (this.nJI.getScaleX() != 1.0f) {
            if (this.nJN == null) {
                this.nJN = ObjectAnimator.ofPropertyValuesHolder(this.nJI, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.nJN.setDuration(200L);
            }
            this.nJN.start();
        }
    }

    public void yN(boolean z) {
        if (this.nJL != null && this.nJL.isRunning()) {
            this.nJL.cancel();
        }
        if (this.nJK == null) {
            this.nJK = ObjectAnimator.ofPropertyValuesHolder(this.nJJ, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.nJK.setRepeatCount(-1);
            this.nJK.setRepeatMode(2);
            this.nJK.setDuration(1000L);
        }
        this.nJJ.setVisibility(0);
        if (z) {
            this.nJH.setVisibility(8);
        } else {
            this.nJH.setBackgroundResource(R.drawable.red_square_bg);
        }
        this.acW.setVisibility(8);
        this.nJK.start();
    }

    public void dSz() {
        if (this.nJK != null && this.nJK.isRunning()) {
            this.nJK.cancel();
        }
        if (this.nJL == null) {
            this.nJL = ObjectAnimator.ofPropertyValuesHolder(this.nJJ, PropertyValuesHolder.ofFloat("scaleX", this.nJJ.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.nJJ.getScaleY(), 0.766f));
            this.nJL.setDuration((500.0f * Math.abs(0.766f - this.nJJ.getScaleX())) / 0.3f);
        }
        this.nJH.setVisibility(0);
        this.nJH.setBackgroundResource(R.drawable.red_circle_bg);
        this.nJL.start();
    }
}
