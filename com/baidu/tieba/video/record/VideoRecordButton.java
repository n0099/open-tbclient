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
    private TextView JR;
    private View gTV;
    private View gTW;
    private View gTX;
    private ObjectAnimator gTY;
    private ObjectAnimator gTZ;
    private ObjectAnimator gUa;
    private ObjectAnimator gUb;

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
        this.gTV = findViewById(d.g.record_layer1);
        this.gTW = findViewById(d.g.record_layer2);
        this.gTX = findViewById(d.g.record_layer3);
        this.JR = (TextView) findViewById(d.g.tv_tip);
        this.gTX.setScaleX(0.766f);
        this.gTX.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.gTX;
    }

    public View getLayer1() {
        return this.gTV;
    }

    public View getLayer2() {
        return this.gTW;
    }

    public TextView getTvTip() {
        return this.JR;
    }

    public void bzm() {
        if (this.gUb != null && this.gUb.isRunning()) {
            this.gUa.cancel();
        }
        if (this.gUa == null) {
            this.gUa = ObjectAnimator.ofPropertyValuesHolder(this.gTW, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.gUa.setDuration(200L);
        }
        this.gUa.start();
    }

    public void bzn() {
        if (this.gUa != null && this.gUa.isRunning()) {
            this.gUa.cancel();
        }
        if (this.gTW.getScaleX() != 1.0f) {
            if (this.gUb == null) {
                this.gUb = ObjectAnimator.ofPropertyValuesHolder(this.gTW, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.gUb.setDuration(200L);
            }
            this.gUb.start();
        }
    }

    public void nb(boolean z) {
        if (this.gTZ != null && this.gTZ.isRunning()) {
            this.gTZ.cancel();
        }
        if (this.gTY == null) {
            this.gTY = ObjectAnimator.ofPropertyValuesHolder(this.gTX, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.gTY.setRepeatCount(-1);
            this.gTY.setRepeatMode(2);
            this.gTY.setDuration(1000L);
        }
        this.gTX.setVisibility(0);
        if (z) {
            this.gTV.setVisibility(8);
        } else {
            this.gTV.setBackgroundResource(d.f.red_square_bg);
        }
        this.JR.setVisibility(8);
        this.gTY.start();
    }

    public void bzb() {
        if (this.gTY != null && this.gTY.isRunning()) {
            this.gTY.cancel();
        }
        if (this.gTZ == null) {
            this.gTZ = ObjectAnimator.ofPropertyValuesHolder(this.gTX, PropertyValuesHolder.ofFloat("scaleX", this.gTX.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.gTX.getScaleY(), 0.766f));
            this.gTZ.setDuration((500.0f * Math.abs(0.766f - this.gTX.getScaleX())) / 0.3f);
        }
        this.gTV.setVisibility(0);
        this.gTV.setBackgroundResource(d.f.red_circle_bg);
        this.gTZ.start();
    }
}
