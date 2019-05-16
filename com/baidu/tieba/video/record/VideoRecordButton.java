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
    private TextView TA;
    private View jxo;
    private View jxp;
    private View jxq;
    private ObjectAnimator jxr;
    private ObjectAnimator jxs;
    private ObjectAnimator jxt;
    private ObjectAnimator jxu;

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
        this.jxo = findViewById(R.id.record_layer1);
        this.jxp = findViewById(R.id.record_layer2);
        this.jxq = findViewById(R.id.record_layer3);
        this.TA = (TextView) findViewById(R.id.tv_tip);
        this.jxq.setScaleX(0.766f);
        this.jxq.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.jxq;
    }

    public View getLayer1() {
        return this.jxo;
    }

    public View getLayer2() {
        return this.jxp;
    }

    public TextView getTvTip() {
        return this.TA;
    }

    public void cui() {
        if (this.jxu != null && this.jxu.isRunning()) {
            this.jxt.cancel();
        }
        if (this.jxt == null) {
            this.jxt = ObjectAnimator.ofPropertyValuesHolder(this.jxp, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.jxt.setDuration(200L);
        }
        this.jxt.start();
    }

    public void cuj() {
        if (this.jxt != null && this.jxt.isRunning()) {
            this.jxt.cancel();
        }
        if (this.jxp.getScaleX() != 1.0f) {
            if (this.jxu == null) {
                this.jxu = ObjectAnimator.ofPropertyValuesHolder(this.jxp, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.jxu.setDuration(200L);
            }
            this.jxu.start();
        }
    }

    public void rz(boolean z) {
        if (this.jxs != null && this.jxs.isRunning()) {
            this.jxs.cancel();
        }
        if (this.jxr == null) {
            this.jxr = ObjectAnimator.ofPropertyValuesHolder(this.jxq, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.jxr.setRepeatCount(-1);
            this.jxr.setRepeatMode(2);
            this.jxr.setDuration(1000L);
        }
        this.jxq.setVisibility(0);
        if (z) {
            this.jxo.setVisibility(8);
        } else {
            this.jxo.setBackgroundResource(R.drawable.red_square_bg);
        }
        this.TA.setVisibility(8);
        this.jxr.start();
    }

    public void ctX() {
        if (this.jxr != null && this.jxr.isRunning()) {
            this.jxr.cancel();
        }
        if (this.jxs == null) {
            this.jxs = ObjectAnimator.ofPropertyValuesHolder(this.jxq, PropertyValuesHolder.ofFloat("scaleX", this.jxq.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.jxq.getScaleY(), 0.766f));
            this.jxs.setDuration((500.0f * Math.abs(0.766f - this.jxq.getScaleX())) / 0.3f);
        }
        this.jxo.setVisibility(0);
        this.jxo.setBackgroundResource(R.drawable.red_circle_bg);
        this.jxs.start();
    }
}
