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
    private View jxp;
    private View jxq;
    private View jxr;
    private ObjectAnimator jxs;
    private ObjectAnimator jxt;
    private ObjectAnimator jxu;
    private ObjectAnimator jxv;

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
        this.jxp = findViewById(R.id.record_layer1);
        this.jxq = findViewById(R.id.record_layer2);
        this.jxr = findViewById(R.id.record_layer3);
        this.TA = (TextView) findViewById(R.id.tv_tip);
        this.jxr.setScaleX(0.766f);
        this.jxr.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.jxr;
    }

    public View getLayer1() {
        return this.jxp;
    }

    public View getLayer2() {
        return this.jxq;
    }

    public TextView getTvTip() {
        return this.TA;
    }

    public void cuk() {
        if (this.jxv != null && this.jxv.isRunning()) {
            this.jxu.cancel();
        }
        if (this.jxu == null) {
            this.jxu = ObjectAnimator.ofPropertyValuesHolder(this.jxq, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.jxu.setDuration(200L);
        }
        this.jxu.start();
    }

    public void cul() {
        if (this.jxu != null && this.jxu.isRunning()) {
            this.jxu.cancel();
        }
        if (this.jxq.getScaleX() != 1.0f) {
            if (this.jxv == null) {
                this.jxv = ObjectAnimator.ofPropertyValuesHolder(this.jxq, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.jxv.setDuration(200L);
            }
            this.jxv.start();
        }
    }

    public void rz(boolean z) {
        if (this.jxt != null && this.jxt.isRunning()) {
            this.jxt.cancel();
        }
        if (this.jxs == null) {
            this.jxs = ObjectAnimator.ofPropertyValuesHolder(this.jxr, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.jxs.setRepeatCount(-1);
            this.jxs.setRepeatMode(2);
            this.jxs.setDuration(1000L);
        }
        this.jxr.setVisibility(0);
        if (z) {
            this.jxp.setVisibility(8);
        } else {
            this.jxp.setBackgroundResource(R.drawable.red_square_bg);
        }
        this.TA.setVisibility(8);
        this.jxs.start();
    }

    public void ctZ() {
        if (this.jxs != null && this.jxs.isRunning()) {
            this.jxs.cancel();
        }
        if (this.jxt == null) {
            this.jxt = ObjectAnimator.ofPropertyValuesHolder(this.jxr, PropertyValuesHolder.ofFloat("scaleX", this.jxr.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.jxr.getScaleY(), 0.766f));
            this.jxt.setDuration((500.0f * Math.abs(0.766f - this.jxr.getScaleX())) / 0.3f);
        }
        this.jxp.setVisibility(0);
        this.jxp.setBackgroundResource(R.drawable.red_circle_bg);
        this.jxt.start();
    }
}
