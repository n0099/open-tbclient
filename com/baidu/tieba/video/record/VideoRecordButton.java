package com.baidu.tieba.video.record;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class VideoRecordButton extends FrameLayout {
    private TextView JN;
    private View gUW;
    private View gUX;
    private View gUY;
    private ObjectAnimator gUZ;
    private ObjectAnimator gVa;
    private ObjectAnimator gVb;
    private ObjectAnimator gVc;

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
        inflate(getContext(), d.i.layout_record_button, this);
        this.gUW = findViewById(d.g.record_layer1);
        this.gUX = findViewById(d.g.record_layer2);
        this.gUY = findViewById(d.g.record_layer3);
        this.JN = (TextView) findViewById(d.g.tv_tip);
        this.gUY.setScaleX(0.766f);
        this.gUY.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.gUY;
    }

    public View getLayer1() {
        return this.gUW;
    }

    public View getLayer2() {
        return this.gUX;
    }

    public TextView getTvTip() {
        return this.JN;
    }

    public void bzk() {
        if (this.gVc != null && this.gVc.isRunning()) {
            this.gVb.cancel();
        }
        if (this.gVb == null) {
            this.gVb = ObjectAnimator.ofPropertyValuesHolder(this.gUX, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.gVb.setDuration(200L);
        }
        this.gVb.start();
    }

    public void bzl() {
        if (this.gVb != null && this.gVb.isRunning()) {
            this.gVb.cancel();
        }
        if (this.gUX.getScaleX() != 1.0f) {
            if (this.gVc == null) {
                this.gVc = ObjectAnimator.ofPropertyValuesHolder(this.gUX, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.gVc.setDuration(200L);
            }
            this.gVc.start();
        }
    }

    public void nc(boolean z) {
        if (this.gVa != null && this.gVa.isRunning()) {
            this.gVa.cancel();
        }
        if (this.gUZ == null) {
            this.gUZ = ObjectAnimator.ofPropertyValuesHolder(this.gUY, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.gUZ.setRepeatCount(-1);
            this.gUZ.setRepeatMode(2);
            this.gUZ.setDuration(1000L);
        }
        this.gUY.setVisibility(0);
        if (z) {
            this.gUW.setVisibility(8);
        } else {
            this.gUW.setBackgroundResource(d.f.red_square_bg);
        }
        this.JN.setVisibility(8);
        this.gUZ.start();
    }

    public void byZ() {
        if (this.gUZ != null && this.gUZ.isRunning()) {
            this.gUZ.cancel();
        }
        if (this.gVa == null) {
            this.gVa = ObjectAnimator.ofPropertyValuesHolder(this.gUY, PropertyValuesHolder.ofFloat("scaleX", this.gUY.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.gUY.getScaleY(), 0.766f));
            this.gVa.setDuration((500.0f * Math.abs(0.766f - this.gUY.getScaleX())) / 0.3f);
        }
        this.gUW.setVisibility(0);
        this.gUW.setBackgroundResource(d.f.red_circle_bg);
        this.gVa.start();
    }
}
