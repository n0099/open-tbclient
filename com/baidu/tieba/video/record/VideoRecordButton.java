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
    private TextView axG;
    private View hyN;
    private View hyO;
    private View hyP;
    private ObjectAnimator hyQ;
    private ObjectAnimator hyR;
    private ObjectAnimator hyS;
    private ObjectAnimator hyT;

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
        this.hyN = findViewById(d.g.record_layer1);
        this.hyO = findViewById(d.g.record_layer2);
        this.hyP = findViewById(d.g.record_layer3);
        this.axG = (TextView) findViewById(d.g.tv_tip);
        this.hyP.setScaleX(0.766f);
        this.hyP.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.hyP;
    }

    public View getLayer1() {
        return this.hyN;
    }

    public View getLayer2() {
        return this.hyO;
    }

    public TextView getTvTip() {
        return this.axG;
    }

    public void bEs() {
        if (this.hyT != null && this.hyT.isRunning()) {
            this.hyS.cancel();
        }
        if (this.hyS == null) {
            this.hyS = ObjectAnimator.ofPropertyValuesHolder(this.hyO, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.hyS.setDuration(200L);
        }
        this.hyS.start();
    }

    public void bEt() {
        if (this.hyS != null && this.hyS.isRunning()) {
            this.hyS.cancel();
        }
        if (this.hyO.getScaleX() != 1.0f) {
            if (this.hyT == null) {
                this.hyT = ObjectAnimator.ofPropertyValuesHolder(this.hyO, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.hyT.setDuration(200L);
            }
            this.hyT.start();
        }
    }

    public void nz(boolean z) {
        if (this.hyR != null && this.hyR.isRunning()) {
            this.hyR.cancel();
        }
        if (this.hyQ == null) {
            this.hyQ = ObjectAnimator.ofPropertyValuesHolder(this.hyP, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.hyQ.setRepeatCount(-1);
            this.hyQ.setRepeatMode(2);
            this.hyQ.setDuration(1000L);
        }
        this.hyP.setVisibility(0);
        if (z) {
            this.hyN.setVisibility(8);
        } else {
            this.hyN.setBackgroundResource(d.f.red_square_bg);
        }
        this.axG.setVisibility(8);
        this.hyQ.start();
    }

    public void bEh() {
        if (this.hyQ != null && this.hyQ.isRunning()) {
            this.hyQ.cancel();
        }
        if (this.hyR == null) {
            this.hyR = ObjectAnimator.ofPropertyValuesHolder(this.hyP, PropertyValuesHolder.ofFloat("scaleX", this.hyP.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.hyP.getScaleY(), 0.766f));
            this.hyR.setDuration((500.0f * Math.abs(0.766f - this.hyP.getScaleX())) / 0.3f);
        }
        this.hyN.setVisibility(0);
        this.hyN.setBackgroundResource(d.f.red_circle_bg);
        this.hyR.start();
    }
}
