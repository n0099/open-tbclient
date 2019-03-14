package com.baidu.tieba.video.record;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class VideoRecordButton extends FrameLayout {
    private TextView VM;
    private View jeF;
    private View jeG;
    private View jeH;
    private ObjectAnimator jeI;
    private ObjectAnimator jeJ;
    private ObjectAnimator jeK;
    private ObjectAnimator jeL;

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
        this.jeF = findViewById(d.g.record_layer1);
        this.jeG = findViewById(d.g.record_layer2);
        this.jeH = findViewById(d.g.record_layer3);
        this.VM = (TextView) findViewById(d.g.tv_tip);
        this.jeH.setScaleX(0.766f);
        this.jeH.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.jeH;
    }

    public View getLayer1() {
        return this.jeF;
    }

    public View getLayer2() {
        return this.jeG;
    }

    public TextView getTvTip() {
        return this.VM;
    }

    public void cmh() {
        if (this.jeL != null && this.jeL.isRunning()) {
            this.jeK.cancel();
        }
        if (this.jeK == null) {
            this.jeK = ObjectAnimator.ofPropertyValuesHolder(this.jeG, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.jeK.setDuration(200L);
        }
        this.jeK.start();
    }

    public void cmi() {
        if (this.jeK != null && this.jeK.isRunning()) {
            this.jeK.cancel();
        }
        if (this.jeG.getScaleX() != 1.0f) {
            if (this.jeL == null) {
                this.jeL = ObjectAnimator.ofPropertyValuesHolder(this.jeG, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.jeL.setDuration(200L);
            }
            this.jeL.start();
        }
    }

    public void qK(boolean z) {
        if (this.jeJ != null && this.jeJ.isRunning()) {
            this.jeJ.cancel();
        }
        if (this.jeI == null) {
            this.jeI = ObjectAnimator.ofPropertyValuesHolder(this.jeH, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.jeI.setRepeatCount(-1);
            this.jeI.setRepeatMode(2);
            this.jeI.setDuration(1000L);
        }
        this.jeH.setVisibility(0);
        if (z) {
            this.jeF.setVisibility(8);
        } else {
            this.jeF.setBackgroundResource(d.f.red_square_bg);
        }
        this.VM.setVisibility(8);
        this.jeI.start();
    }

    public void clW() {
        if (this.jeI != null && this.jeI.isRunning()) {
            this.jeI.cancel();
        }
        if (this.jeJ == null) {
            this.jeJ = ObjectAnimator.ofPropertyValuesHolder(this.jeH, PropertyValuesHolder.ofFloat("scaleX", this.jeH.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.jeH.getScaleY(), 0.766f));
            this.jeJ.setDuration((500.0f * Math.abs(0.766f - this.jeH.getScaleX())) / 0.3f);
        }
        this.jeF.setVisibility(0);
        this.jeF.setBackgroundResource(d.f.red_circle_bg);
        this.jeJ.start();
    }
}
