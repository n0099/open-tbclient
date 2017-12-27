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
    private TextView axN;
    private View hHr;
    private View hHs;
    private View hHt;
    private ObjectAnimator hHu;
    private ObjectAnimator hHv;
    private ObjectAnimator hHw;
    private ObjectAnimator hHx;

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
        this.hHr = findViewById(d.g.record_layer1);
        this.hHs = findViewById(d.g.record_layer2);
        this.hHt = findViewById(d.g.record_layer3);
        this.axN = (TextView) findViewById(d.g.tv_tip);
        this.hHt.setScaleX(0.766f);
        this.hHt.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.hHt;
    }

    public View getLayer1() {
        return this.hHr;
    }

    public View getLayer2() {
        return this.hHs;
    }

    public TextView getTvTip() {
        return this.axN;
    }

    public void bKh() {
        if (this.hHx != null && this.hHx.isRunning()) {
            this.hHw.cancel();
        }
        if (this.hHw == null) {
            this.hHw = ObjectAnimator.ofPropertyValuesHolder(this.hHs, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.hHw.setDuration(200L);
        }
        this.hHw.start();
    }

    public void bKi() {
        if (this.hHw != null && this.hHw.isRunning()) {
            this.hHw.cancel();
        }
        if (this.hHs.getScaleX() != 1.0f) {
            if (this.hHx == null) {
                this.hHx = ObjectAnimator.ofPropertyValuesHolder(this.hHs, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.hHx.setDuration(200L);
            }
            this.hHx.start();
        }
    }

    public void oh(boolean z) {
        if (this.hHv != null && this.hHv.isRunning()) {
            this.hHv.cancel();
        }
        if (this.hHu == null) {
            this.hHu = ObjectAnimator.ofPropertyValuesHolder(this.hHt, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.hHu.setRepeatCount(-1);
            this.hHu.setRepeatMode(2);
            this.hHu.setDuration(1000L);
        }
        this.hHt.setVisibility(0);
        if (z) {
            this.hHr.setVisibility(8);
        } else {
            this.hHr.setBackgroundResource(d.f.red_square_bg);
        }
        this.axN.setVisibility(8);
        this.hHu.start();
    }

    public void bJW() {
        if (this.hHu != null && this.hHu.isRunning()) {
            this.hHu.cancel();
        }
        if (this.hHv == null) {
            this.hHv = ObjectAnimator.ofPropertyValuesHolder(this.hHt, PropertyValuesHolder.ofFloat("scaleX", this.hHt.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.hHt.getScaleY(), 0.766f));
            this.hHv.setDuration((500.0f * Math.abs(0.766f - this.hHt.getScaleX())) / 0.3f);
        }
        this.hHr.setVisibility(0);
        this.hHr.setBackgroundResource(d.f.red_circle_bg);
        this.hHv.start();
    }
}
