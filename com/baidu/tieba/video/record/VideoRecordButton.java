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
    private TextView aaz;
    private View mDT;
    private View mDU;
    private View mDV;
    private ObjectAnimator mDW;
    private ObjectAnimator mDX;
    private ObjectAnimator mDY;
    private ObjectAnimator mDZ;

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
        this.mDT = findViewById(R.id.record_layer1);
        this.mDU = findViewById(R.id.record_layer2);
        this.mDV = findViewById(R.id.record_layer3);
        this.aaz = (TextView) findViewById(R.id.tv_tip);
        this.mDV.setScaleX(0.766f);
        this.mDV.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.mDV;
    }

    public View getLayer1() {
        return this.mDT;
    }

    public View getLayer2() {
        return this.mDU;
    }

    public TextView getTvTip() {
        return this.aaz;
    }

    public void dEo() {
        if (this.mDZ != null && this.mDZ.isRunning()) {
            this.mDY.cancel();
        }
        if (this.mDY == null) {
            this.mDY = ObjectAnimator.ofPropertyValuesHolder(this.mDU, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.mDY.setDuration(200L);
        }
        this.mDY.start();
    }

    public void dEp() {
        if (this.mDY != null && this.mDY.isRunning()) {
            this.mDY.cancel();
        }
        if (this.mDU.getScaleX() != 1.0f) {
            if (this.mDZ == null) {
                this.mDZ = ObjectAnimator.ofPropertyValuesHolder(this.mDU, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.mDZ.setDuration(200L);
            }
            this.mDZ.start();
        }
    }

    public void wP(boolean z) {
        if (this.mDX != null && this.mDX.isRunning()) {
            this.mDX.cancel();
        }
        if (this.mDW == null) {
            this.mDW = ObjectAnimator.ofPropertyValuesHolder(this.mDV, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.mDW.setRepeatCount(-1);
            this.mDW.setRepeatMode(2);
            this.mDW.setDuration(1000L);
        }
        this.mDV.setVisibility(0);
        if (z) {
            this.mDT.setVisibility(8);
        } else {
            this.mDT.setBackgroundResource(R.drawable.red_square_bg);
        }
        this.aaz.setVisibility(8);
        this.mDW.start();
    }

    public void dEd() {
        if (this.mDW != null && this.mDW.isRunning()) {
            this.mDW.cancel();
        }
        if (this.mDX == null) {
            this.mDX = ObjectAnimator.ofPropertyValuesHolder(this.mDV, PropertyValuesHolder.ofFloat("scaleX", this.mDV.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.mDV.getScaleY(), 0.766f));
            this.mDX.setDuration((500.0f * Math.abs(0.766f - this.mDV.getScaleX())) / 0.3f);
        }
        this.mDT.setVisibility(0);
        this.mDT.setBackgroundResource(R.drawable.red_circle_bg);
        this.mDX.start();
    }
}
