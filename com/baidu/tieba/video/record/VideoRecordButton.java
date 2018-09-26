package com.baidu.tieba.video.record;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.e;
/* loaded from: classes2.dex */
public class VideoRecordButton extends FrameLayout {
    private TextView SF;
    private View htI;
    private View htJ;
    private View htK;
    private ObjectAnimator htL;
    private ObjectAnimator htM;
    private ObjectAnimator htN;
    private ObjectAnimator htO;

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
        this.htI = findViewById(e.g.record_layer1);
        this.htJ = findViewById(e.g.record_layer2);
        this.htK = findViewById(e.g.record_layer3);
        this.SF = (TextView) findViewById(e.g.tv_tip);
        this.htK.setScaleX(0.766f);
        this.htK.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.htK;
    }

    public View getLayer1() {
        return this.htI;
    }

    public View getLayer2() {
        return this.htJ;
    }

    public TextView getTvTip() {
        return this.SF;
    }

    public void bGr() {
        if (this.htO != null && this.htO.isRunning()) {
            this.htN.cancel();
        }
        if (this.htN == null) {
            this.htN = ObjectAnimator.ofPropertyValuesHolder(this.htJ, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.htN.setDuration(200L);
        }
        this.htN.start();
    }

    public void bGs() {
        if (this.htN != null && this.htN.isRunning()) {
            this.htN.cancel();
        }
        if (this.htJ.getScaleX() != 1.0f) {
            if (this.htO == null) {
                this.htO = ObjectAnimator.ofPropertyValuesHolder(this.htJ, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.htO.setDuration(200L);
            }
            this.htO.start();
        }
    }

    public void nA(boolean z) {
        if (this.htM != null && this.htM.isRunning()) {
            this.htM.cancel();
        }
        if (this.htL == null) {
            this.htL = ObjectAnimator.ofPropertyValuesHolder(this.htK, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.htL.setRepeatCount(-1);
            this.htL.setRepeatMode(2);
            this.htL.setDuration(1000L);
        }
        this.htK.setVisibility(0);
        if (z) {
            this.htI.setVisibility(8);
        } else {
            this.htI.setBackgroundResource(e.f.red_square_bg);
        }
        this.SF.setVisibility(8);
        this.htL.start();
    }

    public void bGg() {
        if (this.htL != null && this.htL.isRunning()) {
            this.htL.cancel();
        }
        if (this.htM == null) {
            this.htM = ObjectAnimator.ofPropertyValuesHolder(this.htK, PropertyValuesHolder.ofFloat("scaleX", this.htK.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.htK.getScaleY(), 0.766f));
            this.htM.setDuration((500.0f * Math.abs(0.766f - this.htK.getScaleX())) / 0.3f);
        }
        this.htI.setVisibility(0);
        this.htI.setBackgroundResource(e.f.red_circle_bg);
        this.htM.start();
    }
}
