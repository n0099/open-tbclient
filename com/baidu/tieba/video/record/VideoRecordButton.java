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
    private TextView Zs;
    private View lKC;
    private View lKD;
    private View lKE;
    private ObjectAnimator lKF;
    private ObjectAnimator lKG;
    private ObjectAnimator lKH;
    private ObjectAnimator lKI;

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
        this.lKC = findViewById(R.id.record_layer1);
        this.lKD = findViewById(R.id.record_layer2);
        this.lKE = findViewById(R.id.record_layer3);
        this.Zs = (TextView) findViewById(R.id.tv_tip);
        this.lKE.setScaleX(0.766f);
        this.lKE.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.lKE;
    }

    public View getLayer1() {
        return this.lKC;
    }

    public View getLayer2() {
        return this.lKD;
    }

    public TextView getTvTip() {
        return this.Zs;
    }

    public void dlk() {
        if (this.lKI != null && this.lKI.isRunning()) {
            this.lKH.cancel();
        }
        if (this.lKH == null) {
            this.lKH = ObjectAnimator.ofPropertyValuesHolder(this.lKD, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.lKH.setDuration(200L);
        }
        this.lKH.start();
    }

    public void dll() {
        if (this.lKH != null && this.lKH.isRunning()) {
            this.lKH.cancel();
        }
        if (this.lKD.getScaleX() != 1.0f) {
            if (this.lKI == null) {
                this.lKI = ObjectAnimator.ofPropertyValuesHolder(this.lKD, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.lKI.setDuration(200L);
            }
            this.lKI.start();
        }
    }

    public void vc(boolean z) {
        if (this.lKG != null && this.lKG.isRunning()) {
            this.lKG.cancel();
        }
        if (this.lKF == null) {
            this.lKF = ObjectAnimator.ofPropertyValuesHolder(this.lKE, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.lKF.setRepeatCount(-1);
            this.lKF.setRepeatMode(2);
            this.lKF.setDuration(1000L);
        }
        this.lKE.setVisibility(0);
        if (z) {
            this.lKC.setVisibility(8);
        } else {
            this.lKC.setBackgroundResource(R.drawable.red_square_bg);
        }
        this.Zs.setVisibility(8);
        this.lKF.start();
    }

    public void dkZ() {
        if (this.lKF != null && this.lKF.isRunning()) {
            this.lKF.cancel();
        }
        if (this.lKG == null) {
            this.lKG = ObjectAnimator.ofPropertyValuesHolder(this.lKE, PropertyValuesHolder.ofFloat("scaleX", this.lKE.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.lKE.getScaleY(), 0.766f));
            this.lKG.setDuration((500.0f * Math.abs(0.766f - this.lKE.getScaleX())) / 0.3f);
        }
        this.lKC.setVisibility(0);
        this.lKC.setBackgroundResource(R.drawable.red_circle_bg);
        this.lKG.start();
    }
}
