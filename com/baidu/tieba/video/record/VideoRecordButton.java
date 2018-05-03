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
    private View gTS;
    private View gTT;
    private View gTU;
    private ObjectAnimator gTV;
    private ObjectAnimator gTW;
    private ObjectAnimator gTX;
    private ObjectAnimator gTY;

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
        this.gTS = findViewById(d.g.record_layer1);
        this.gTT = findViewById(d.g.record_layer2);
        this.gTU = findViewById(d.g.record_layer3);
        this.JR = (TextView) findViewById(d.g.tv_tip);
        this.gTU.setScaleX(0.766f);
        this.gTU.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.gTU;
    }

    public View getLayer1() {
        return this.gTS;
    }

    public View getLayer2() {
        return this.gTT;
    }

    public TextView getTvTip() {
        return this.JR;
    }

    public void bzm() {
        if (this.gTY != null && this.gTY.isRunning()) {
            this.gTX.cancel();
        }
        if (this.gTX == null) {
            this.gTX = ObjectAnimator.ofPropertyValuesHolder(this.gTT, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.gTX.setDuration(200L);
        }
        this.gTX.start();
    }

    public void bzn() {
        if (this.gTX != null && this.gTX.isRunning()) {
            this.gTX.cancel();
        }
        if (this.gTT.getScaleX() != 1.0f) {
            if (this.gTY == null) {
                this.gTY = ObjectAnimator.ofPropertyValuesHolder(this.gTT, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.gTY.setDuration(200L);
            }
            this.gTY.start();
        }
    }

    public void nb(boolean z) {
        if (this.gTW != null && this.gTW.isRunning()) {
            this.gTW.cancel();
        }
        if (this.gTV == null) {
            this.gTV = ObjectAnimator.ofPropertyValuesHolder(this.gTU, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.gTV.setRepeatCount(-1);
            this.gTV.setRepeatMode(2);
            this.gTV.setDuration(1000L);
        }
        this.gTU.setVisibility(0);
        if (z) {
            this.gTS.setVisibility(8);
        } else {
            this.gTS.setBackgroundResource(d.f.red_square_bg);
        }
        this.JR.setVisibility(8);
        this.gTV.start();
    }

    public void bzb() {
        if (this.gTV != null && this.gTV.isRunning()) {
            this.gTV.cancel();
        }
        if (this.gTW == null) {
            this.gTW = ObjectAnimator.ofPropertyValuesHolder(this.gTU, PropertyValuesHolder.ofFloat("scaleX", this.gTU.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.gTU.getScaleY(), 0.766f));
            this.gTW.setDuration((500.0f * Math.abs(0.766f - this.gTU.getScaleX())) / 0.3f);
        }
        this.gTS.setVisibility(0);
        this.gTS.setBackgroundResource(d.f.red_circle_bg);
        this.gTW.start();
    }
}
