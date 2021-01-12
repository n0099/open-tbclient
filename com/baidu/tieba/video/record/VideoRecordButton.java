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
    private View nJG;
    private View nJH;
    private View nJI;
    private ObjectAnimator nJJ;
    private ObjectAnimator nJK;
    private ObjectAnimator nJL;
    private ObjectAnimator nJM;

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
        this.nJG = findViewById(R.id.record_layer1);
        this.nJH = findViewById(R.id.record_layer2);
        this.nJI = findViewById(R.id.record_layer3);
        this.acW = (TextView) findViewById(R.id.tv_tip);
        this.nJI.setScaleX(0.766f);
        this.nJI.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.nJI;
    }

    public View getLayer1() {
        return this.nJG;
    }

    public View getLayer2() {
        return this.nJH;
    }

    public TextView getTvTip() {
        return this.acW;
    }

    public void dSK() {
        if (this.nJM != null && this.nJM.isRunning()) {
            this.nJL.cancel();
        }
        if (this.nJL == null) {
            this.nJL = ObjectAnimator.ofPropertyValuesHolder(this.nJH, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.nJL.setDuration(200L);
        }
        this.nJL.start();
    }

    public void dSL() {
        if (this.nJL != null && this.nJL.isRunning()) {
            this.nJL.cancel();
        }
        if (this.nJH.getScaleX() != 1.0f) {
            if (this.nJM == null) {
                this.nJM = ObjectAnimator.ofPropertyValuesHolder(this.nJH, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.nJM.setDuration(200L);
            }
            this.nJM.start();
        }
    }

    public void yN(boolean z) {
        if (this.nJK != null && this.nJK.isRunning()) {
            this.nJK.cancel();
        }
        if (this.nJJ == null) {
            this.nJJ = ObjectAnimator.ofPropertyValuesHolder(this.nJI, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.nJJ.setRepeatCount(-1);
            this.nJJ.setRepeatMode(2);
            this.nJJ.setDuration(1000L);
        }
        this.nJI.setVisibility(0);
        if (z) {
            this.nJG.setVisibility(8);
        } else {
            this.nJG.setBackgroundResource(R.drawable.red_square_bg);
        }
        this.acW.setVisibility(8);
        this.nJJ.start();
    }

    public void dSz() {
        if (this.nJJ != null && this.nJJ.isRunning()) {
            this.nJJ.cancel();
        }
        if (this.nJK == null) {
            this.nJK = ObjectAnimator.ofPropertyValuesHolder(this.nJI, PropertyValuesHolder.ofFloat("scaleX", this.nJI.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.nJI.getScaleY(), 0.766f));
            this.nJK.setDuration((500.0f * Math.abs(0.766f - this.nJI.getScaleX())) / 0.3f);
        }
        this.nJG.setVisibility(0);
        this.nJG.setBackgroundResource(R.drawable.red_circle_bg);
        this.nJK.start();
    }
}
