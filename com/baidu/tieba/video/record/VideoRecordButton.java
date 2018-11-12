package com.baidu.tieba.video.record;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.e;
/* loaded from: classes5.dex */
public class VideoRecordButton extends FrameLayout {
    private TextView SZ;
    private View hCF;
    private View hCG;
    private View hCH;
    private ObjectAnimator hCI;
    private ObjectAnimator hCJ;
    private ObjectAnimator hCK;
    private ObjectAnimator hCL;

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
        inflate(getContext(), e.h.layout_record_button, this);
        this.hCF = findViewById(e.g.record_layer1);
        this.hCG = findViewById(e.g.record_layer2);
        this.hCH = findViewById(e.g.record_layer3);
        this.SZ = (TextView) findViewById(e.g.tv_tip);
        this.hCH.setScaleX(0.766f);
        this.hCH.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.hCH;
    }

    public View getLayer1() {
        return this.hCF;
    }

    public View getLayer2() {
        return this.hCG;
    }

    public TextView getTvTip() {
        return this.SZ;
    }

    public void bJd() {
        if (this.hCL != null && this.hCL.isRunning()) {
            this.hCK.cancel();
        }
        if (this.hCK == null) {
            this.hCK = ObjectAnimator.ofPropertyValuesHolder(this.hCG, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.hCK.setDuration(200L);
        }
        this.hCK.start();
    }

    public void bJe() {
        if (this.hCK != null && this.hCK.isRunning()) {
            this.hCK.cancel();
        }
        if (this.hCG.getScaleX() != 1.0f) {
            if (this.hCL == null) {
                this.hCL = ObjectAnimator.ofPropertyValuesHolder(this.hCG, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.hCL.setDuration(200L);
            }
            this.hCL.start();
        }
    }

    public void oe(boolean z) {
        if (this.hCJ != null && this.hCJ.isRunning()) {
            this.hCJ.cancel();
        }
        if (this.hCI == null) {
            this.hCI = ObjectAnimator.ofPropertyValuesHolder(this.hCH, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.hCI.setRepeatCount(-1);
            this.hCI.setRepeatMode(2);
            this.hCI.setDuration(1000L);
        }
        this.hCH.setVisibility(0);
        if (z) {
            this.hCF.setVisibility(8);
        } else {
            this.hCF.setBackgroundResource(e.f.red_square_bg);
        }
        this.SZ.setVisibility(8);
        this.hCI.start();
    }

    public void bIS() {
        if (this.hCI != null && this.hCI.isRunning()) {
            this.hCI.cancel();
        }
        if (this.hCJ == null) {
            this.hCJ = ObjectAnimator.ofPropertyValuesHolder(this.hCH, PropertyValuesHolder.ofFloat("scaleX", this.hCH.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.hCH.getScaleY(), 0.766f));
            this.hCJ.setDuration((500.0f * Math.abs(0.766f - this.hCH.getScaleX())) / 0.3f);
        }
        this.hCF.setVisibility(0);
        this.hCF.setBackgroundResource(e.f.red_circle_bg);
        this.hCJ.start();
    }
}
