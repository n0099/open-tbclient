package com.baidu.tieba.video.record;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class VideoRecordButton extends FrameLayout {
    private TextView acY;
    private View nOl;
    private View nOm;
    private View nOn;
    private ObjectAnimator nOo;
    private ObjectAnimator nOp;
    private ObjectAnimator nOq;
    private ObjectAnimator nOr;

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
        this.nOl = findViewById(R.id.record_layer1);
        this.nOm = findViewById(R.id.record_layer2);
        this.nOn = findViewById(R.id.record_layer3);
        this.acY = (TextView) findViewById(R.id.tv_tip);
        this.nOn.setScaleX(0.766f);
        this.nOn.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.nOn;
    }

    public View getLayer1() {
        return this.nOl;
    }

    public View getLayer2() {
        return this.nOm;
    }

    public TextView getTvTip() {
        return this.acY;
    }

    public void dWC() {
        if (this.nOr != null && this.nOr.isRunning()) {
            this.nOq.cancel();
        }
        if (this.nOq == null) {
            this.nOq = ObjectAnimator.ofPropertyValuesHolder(this.nOm, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.nOq.setDuration(200L);
        }
        this.nOq.start();
    }

    public void dWD() {
        if (this.nOq != null && this.nOq.isRunning()) {
            this.nOq.cancel();
        }
        if (this.nOm.getScaleX() != 1.0f) {
            if (this.nOr == null) {
                this.nOr = ObjectAnimator.ofPropertyValuesHolder(this.nOm, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.nOr.setDuration(200L);
            }
            this.nOr.start();
        }
    }

    public void yR(boolean z) {
        if (this.nOp != null && this.nOp.isRunning()) {
            this.nOp.cancel();
        }
        if (this.nOo == null) {
            this.nOo = ObjectAnimator.ofPropertyValuesHolder(this.nOn, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.nOo.setRepeatCount(-1);
            this.nOo.setRepeatMode(2);
            this.nOo.setDuration(1000L);
        }
        this.nOn.setVisibility(0);
        if (z) {
            this.nOl.setVisibility(8);
        } else {
            this.nOl.setBackgroundResource(R.drawable.red_square_bg);
        }
        this.acY.setVisibility(8);
        this.nOo.start();
    }

    public void dWr() {
        if (this.nOo != null && this.nOo.isRunning()) {
            this.nOo.cancel();
        }
        if (this.nOp == null) {
            this.nOp = ObjectAnimator.ofPropertyValuesHolder(this.nOn, PropertyValuesHolder.ofFloat("scaleX", this.nOn.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.nOn.getScaleY(), 0.766f));
            this.nOp.setDuration((500.0f * Math.abs(0.766f - this.nOn.getScaleX())) / 0.3f);
        }
        this.nOl.setVisibility(0);
        this.nOl.setBackgroundResource(R.drawable.red_circle_bg);
        this.nOp.start();
    }
}
