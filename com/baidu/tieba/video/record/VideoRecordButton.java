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
    private TextView Qg;
    private ObjectAnimator hgA;
    private ObjectAnimator hgB;
    private ObjectAnimator hgC;
    private ObjectAnimator hgD;
    private View hgx;
    private View hgy;
    private View hgz;

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
        this.hgx = findViewById(d.g.record_layer1);
        this.hgy = findViewById(d.g.record_layer2);
        this.hgz = findViewById(d.g.record_layer3);
        this.Qg = (TextView) findViewById(d.g.tv_tip);
        this.hgz.setScaleX(0.766f);
        this.hgz.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.hgz;
    }

    public View getLayer1() {
        return this.hgx;
    }

    public View getLayer2() {
        return this.hgy;
    }

    public TextView getTvTip() {
        return this.Qg;
    }

    public void bEq() {
        if (this.hgD != null && this.hgD.isRunning()) {
            this.hgC.cancel();
        }
        if (this.hgC == null) {
            this.hgC = ObjectAnimator.ofPropertyValuesHolder(this.hgy, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.hgC.setDuration(200L);
        }
        this.hgC.start();
    }

    public void bEr() {
        if (this.hgC != null && this.hgC.isRunning()) {
            this.hgC.cancel();
        }
        if (this.hgy.getScaleX() != 1.0f) {
            if (this.hgD == null) {
                this.hgD = ObjectAnimator.ofPropertyValuesHolder(this.hgy, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.hgD.setDuration(200L);
            }
            this.hgD.start();
        }
    }

    public void ni(boolean z) {
        if (this.hgB != null && this.hgB.isRunning()) {
            this.hgB.cancel();
        }
        if (this.hgA == null) {
            this.hgA = ObjectAnimator.ofPropertyValuesHolder(this.hgz, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.hgA.setRepeatCount(-1);
            this.hgA.setRepeatMode(2);
            this.hgA.setDuration(1000L);
        }
        this.hgz.setVisibility(0);
        if (z) {
            this.hgx.setVisibility(8);
        } else {
            this.hgx.setBackgroundResource(d.f.red_square_bg);
        }
        this.Qg.setVisibility(8);
        this.hgA.start();
    }

    public void bEf() {
        if (this.hgA != null && this.hgA.isRunning()) {
            this.hgA.cancel();
        }
        if (this.hgB == null) {
            this.hgB = ObjectAnimator.ofPropertyValuesHolder(this.hgz, PropertyValuesHolder.ofFloat("scaleX", this.hgz.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.hgz.getScaleY(), 0.766f));
            this.hgB.setDuration((500.0f * Math.abs(0.766f - this.hgz.getScaleX())) / 0.3f);
        }
        this.hgx.setVisibility(0);
        this.hgx.setBackgroundResource(d.f.red_circle_bg);
        this.hgB.start();
    }
}
