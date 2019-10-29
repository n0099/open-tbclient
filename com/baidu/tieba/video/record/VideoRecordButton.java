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
    private TextView Dk;
    private View jGU;
    private View jGV;
    private View jGW;
    private ObjectAnimator jGX;
    private ObjectAnimator jGY;
    private ObjectAnimator jGZ;
    private ObjectAnimator jHa;

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
        this.jGU = findViewById(R.id.record_layer1);
        this.jGV = findViewById(R.id.record_layer2);
        this.jGW = findViewById(R.id.record_layer3);
        this.Dk = (TextView) findViewById(R.id.tv_tip);
        this.jGW.setScaleX(0.766f);
        this.jGW.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.jGW;
    }

    public View getLayer1() {
        return this.jGU;
    }

    public View getLayer2() {
        return this.jGV;
    }

    public TextView getTvTip() {
        return this.Dk;
    }

    public void cvY() {
        if (this.jHa != null && this.jHa.isRunning()) {
            this.jGZ.cancel();
        }
        if (this.jGZ == null) {
            this.jGZ = ObjectAnimator.ofPropertyValuesHolder(this.jGV, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.jGZ.setDuration(200L);
        }
        this.jGZ.start();
    }

    public void cvZ() {
        if (this.jGZ != null && this.jGZ.isRunning()) {
            this.jGZ.cancel();
        }
        if (this.jGV.getScaleX() != 1.0f) {
            if (this.jHa == null) {
                this.jHa = ObjectAnimator.ofPropertyValuesHolder(this.jGV, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.jHa.setDuration(200L);
            }
            this.jHa.start();
        }
    }

    public void rA(boolean z) {
        if (this.jGY != null && this.jGY.isRunning()) {
            this.jGY.cancel();
        }
        if (this.jGX == null) {
            this.jGX = ObjectAnimator.ofPropertyValuesHolder(this.jGW, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.jGX.setRepeatCount(-1);
            this.jGX.setRepeatMode(2);
            this.jGX.setDuration(1000L);
        }
        this.jGW.setVisibility(0);
        if (z) {
            this.jGU.setVisibility(8);
        } else {
            this.jGU.setBackgroundResource(R.drawable.red_square_bg);
        }
        this.Dk.setVisibility(8);
        this.jGX.start();
    }

    public void cvN() {
        if (this.jGX != null && this.jGX.isRunning()) {
            this.jGX.cancel();
        }
        if (this.jGY == null) {
            this.jGY = ObjectAnimator.ofPropertyValuesHolder(this.jGW, PropertyValuesHolder.ofFloat("scaleX", this.jGW.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.jGW.getScaleY(), 0.766f));
            this.jGY.setDuration((500.0f * Math.abs(0.766f - this.jGW.getScaleX())) / 0.3f);
        }
        this.jGU.setVisibility(0);
        this.jGU.setBackgroundResource(R.drawable.red_circle_bg);
        this.jGY.start();
    }
}
