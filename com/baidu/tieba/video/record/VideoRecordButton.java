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
    private TextView axP;
    private View hxo;
    private View hxp;
    private View hxq;
    private ObjectAnimator hxr;
    private ObjectAnimator hxs;
    private ObjectAnimator hxt;
    private ObjectAnimator hxu;

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
        inflate(getContext(), d.h.layout_record_button, this);
        this.hxo = findViewById(d.g.record_layer1);
        this.hxp = findViewById(d.g.record_layer2);
        this.hxq = findViewById(d.g.record_layer3);
        this.axP = (TextView) findViewById(d.g.tv_tip);
        this.hxq.setScaleX(0.766f);
        this.hxq.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.hxq;
    }

    public View getLayer1() {
        return this.hxo;
    }

    public View getLayer2() {
        return this.hxp;
    }

    public TextView getTvTip() {
        return this.axP;
    }

    public void bDG() {
        if (this.hxu != null && this.hxu.isRunning()) {
            this.hxt.cancel();
        }
        if (this.hxt == null) {
            this.hxt = ObjectAnimator.ofPropertyValuesHolder(this.hxp, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.hxt.setDuration(200L);
        }
        this.hxt.start();
    }

    public void bDH() {
        if (this.hxt != null && this.hxt.isRunning()) {
            this.hxt.cancel();
        }
        if (this.hxp.getScaleX() != 1.0f) {
            if (this.hxu == null) {
                this.hxu = ObjectAnimator.ofPropertyValuesHolder(this.hxp, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.hxu.setDuration(200L);
            }
            this.hxu.start();
        }
    }

    public void nn(boolean z) {
        if (this.hxs != null && this.hxs.isRunning()) {
            this.hxs.cancel();
        }
        if (this.hxr == null) {
            this.hxr = ObjectAnimator.ofPropertyValuesHolder(this.hxq, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.hxr.setRepeatCount(-1);
            this.hxr.setRepeatMode(2);
            this.hxr.setDuration(1000L);
        }
        this.hxq.setVisibility(0);
        if (z) {
            this.hxo.setVisibility(8);
        } else {
            this.hxo.setBackgroundResource(d.f.red_square_bg);
        }
        this.axP.setVisibility(8);
        this.hxr.start();
    }

    public void bDv() {
        if (this.hxr != null && this.hxr.isRunning()) {
            this.hxr.cancel();
        }
        if (this.hxs == null) {
            this.hxs = ObjectAnimator.ofPropertyValuesHolder(this.hxq, PropertyValuesHolder.ofFloat("scaleX", this.hxq.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.hxq.getScaleY(), 0.766f));
            this.hxs.setDuration((500.0f * Math.abs(0.766f - this.hxq.getScaleX())) / 0.3f);
        }
        this.hxo.setVisibility(0);
        this.hxo.setBackgroundResource(d.f.red_circle_bg);
        this.hxs.start();
    }
}
