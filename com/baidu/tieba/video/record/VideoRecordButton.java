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
    private TextView FN;
    private View kEC;
    private View kED;
    private View kEE;
    private ObjectAnimator kEF;
    private ObjectAnimator kEG;
    private ObjectAnimator kEH;
    private ObjectAnimator kEI;

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
        this.kEC = findViewById(R.id.record_layer1);
        this.kED = findViewById(R.id.record_layer2);
        this.kEE = findViewById(R.id.record_layer3);
        this.FN = (TextView) findViewById(R.id.tv_tip);
        this.kEE.setScaleX(0.766f);
        this.kEE.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.kEE;
    }

    public View getLayer1() {
        return this.kEC;
    }

    public View getLayer2() {
        return this.kED;
    }

    public TextView getTvTip() {
        return this.FN;
    }

    public void cSo() {
        if (this.kEI != null && this.kEI.isRunning()) {
            this.kEH.cancel();
        }
        if (this.kEH == null) {
            this.kEH = ObjectAnimator.ofPropertyValuesHolder(this.kED, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.kEH.setDuration(200L);
        }
        this.kEH.start();
    }

    public void cSp() {
        if (this.kEH != null && this.kEH.isRunning()) {
            this.kEH.cancel();
        }
        if (this.kED.getScaleX() != 1.0f) {
            if (this.kEI == null) {
                this.kEI = ObjectAnimator.ofPropertyValuesHolder(this.kED, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.kEI.setDuration(200L);
            }
            this.kEI.start();
        }
    }

    public void tw(boolean z) {
        if (this.kEG != null && this.kEG.isRunning()) {
            this.kEG.cancel();
        }
        if (this.kEF == null) {
            this.kEF = ObjectAnimator.ofPropertyValuesHolder(this.kEE, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.kEF.setRepeatCount(-1);
            this.kEF.setRepeatMode(2);
            this.kEF.setDuration(1000L);
        }
        this.kEE.setVisibility(0);
        if (z) {
            this.kEC.setVisibility(8);
        } else {
            this.kEC.setBackgroundResource(R.drawable.red_square_bg);
        }
        this.FN.setVisibility(8);
        this.kEF.start();
    }

    public void cSd() {
        if (this.kEF != null && this.kEF.isRunning()) {
            this.kEF.cancel();
        }
        if (this.kEG == null) {
            this.kEG = ObjectAnimator.ofPropertyValuesHolder(this.kEE, PropertyValuesHolder.ofFloat("scaleX", this.kEE.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.kEE.getScaleY(), 0.766f));
            this.kEG.setDuration((500.0f * Math.abs(0.766f - this.kEE.getScaleX())) / 0.3f);
        }
        this.kEC.setVisibility(0);
        this.kEC.setBackgroundResource(R.drawable.red_circle_bg);
        this.kEG.start();
    }
}
