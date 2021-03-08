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
    private TextView aek;
    private View nVT;
    private View nVU;
    private View nVV;
    private ObjectAnimator nVW;
    private ObjectAnimator nVX;
    private ObjectAnimator nVY;
    private ObjectAnimator nVZ;

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
        this.nVT = findViewById(R.id.record_layer1);
        this.nVU = findViewById(R.id.record_layer2);
        this.nVV = findViewById(R.id.record_layer3);
        this.aek = (TextView) findViewById(R.id.tv_tip);
        this.nVV.setScaleX(0.766f);
        this.nVV.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.nVV;
    }

    public View getLayer1() {
        return this.nVT;
    }

    public View getLayer2() {
        return this.nVU;
    }

    public TextView getTvTip() {
        return this.aek;
    }

    public void dVl() {
        if (this.nVZ != null && this.nVZ.isRunning()) {
            this.nVY.cancel();
        }
        if (this.nVY == null) {
            this.nVY = ObjectAnimator.ofPropertyValuesHolder(this.nVU, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.nVY.setDuration(200L);
        }
        this.nVY.start();
    }

    public void dVm() {
        if (this.nVY != null && this.nVY.isRunning()) {
            this.nVY.cancel();
        }
        if (this.nVU.getScaleX() != 1.0f) {
            if (this.nVZ == null) {
                this.nVZ = ObjectAnimator.ofPropertyValuesHolder(this.nVU, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.nVZ.setDuration(200L);
            }
            this.nVZ.start();
        }
    }

    public void zf(boolean z) {
        if (this.nVX != null && this.nVX.isRunning()) {
            this.nVX.cancel();
        }
        if (this.nVW == null) {
            this.nVW = ObjectAnimator.ofPropertyValuesHolder(this.nVV, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.nVW.setRepeatCount(-1);
            this.nVW.setRepeatMode(2);
            this.nVW.setDuration(1000L);
        }
        this.nVV.setVisibility(0);
        if (z) {
            this.nVT.setVisibility(8);
        } else {
            this.nVT.setBackgroundResource(R.drawable.red_square_bg);
        }
        this.aek.setVisibility(8);
        this.nVW.start();
    }

    public void dVa() {
        if (this.nVW != null && this.nVW.isRunning()) {
            this.nVW.cancel();
        }
        if (this.nVX == null) {
            this.nVX = ObjectAnimator.ofPropertyValuesHolder(this.nVV, PropertyValuesHolder.ofFloat("scaleX", this.nVV.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.nVV.getScaleY(), 0.766f));
            this.nVX.setDuration((500.0f * Math.abs(0.766f - this.nVV.getScaleX())) / 0.3f);
        }
        this.nVT.setVisibility(0);
        this.nVT.setBackgroundResource(R.drawable.red_circle_bg);
        this.nVX.start();
    }
}
