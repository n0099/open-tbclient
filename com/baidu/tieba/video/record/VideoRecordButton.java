package com.baidu.tieba.video.record;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class VideoRecordButton extends FrameLayout {
    private TextView TT;
    private View jEI;
    private View jEJ;
    private View jEK;
    private ObjectAnimator jEL;
    private ObjectAnimator jEM;
    private ObjectAnimator jEN;
    private ObjectAnimator jEO;

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
        this.jEI = findViewById(R.id.record_layer1);
        this.jEJ = findViewById(R.id.record_layer2);
        this.jEK = findViewById(R.id.record_layer3);
        this.TT = (TextView) findViewById(R.id.tv_tip);
        this.jEK.setScaleX(0.766f);
        this.jEK.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.jEK;
    }

    public View getLayer1() {
        return this.jEI;
    }

    public View getLayer2() {
        return this.jEJ;
    }

    public TextView getTvTip() {
        return this.TT;
    }

    public void cxu() {
        if (this.jEO != null && this.jEO.isRunning()) {
            this.jEN.cancel();
        }
        if (this.jEN == null) {
            this.jEN = ObjectAnimator.ofPropertyValuesHolder(this.jEJ, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.jEN.setDuration(200L);
        }
        this.jEN.start();
    }

    public void cxv() {
        if (this.jEN != null && this.jEN.isRunning()) {
            this.jEN.cancel();
        }
        if (this.jEJ.getScaleX() != 1.0f) {
            if (this.jEO == null) {
                this.jEO = ObjectAnimator.ofPropertyValuesHolder(this.jEJ, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.jEO.setDuration(200L);
            }
            this.jEO.start();
        }
    }

    public void rO(boolean z) {
        if (this.jEM != null && this.jEM.isRunning()) {
            this.jEM.cancel();
        }
        if (this.jEL == null) {
            this.jEL = ObjectAnimator.ofPropertyValuesHolder(this.jEK, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.jEL.setRepeatCount(-1);
            this.jEL.setRepeatMode(2);
            this.jEL.setDuration(1000L);
        }
        this.jEK.setVisibility(0);
        if (z) {
            this.jEI.setVisibility(8);
        } else {
            this.jEI.setBackgroundResource(R.drawable.red_square_bg);
        }
        this.TT.setVisibility(8);
        this.jEL.start();
    }

    public void cxj() {
        if (this.jEL != null && this.jEL.isRunning()) {
            this.jEL.cancel();
        }
        if (this.jEM == null) {
            this.jEM = ObjectAnimator.ofPropertyValuesHolder(this.jEK, PropertyValuesHolder.ofFloat("scaleX", this.jEK.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.jEK.getScaleY(), 0.766f));
            this.jEM.setDuration((500.0f * Math.abs(0.766f - this.jEK.getScaleX())) / 0.3f);
        }
        this.jEI.setVisibility(0);
        this.jEI.setBackgroundResource(R.drawable.red_circle_bg);
        this.jEM.start();
    }
}
