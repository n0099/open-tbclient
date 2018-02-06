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
    private TextView axO;
    private View hyC;
    private View hyD;
    private View hyE;
    private ObjectAnimator hyF;
    private ObjectAnimator hyG;
    private ObjectAnimator hyH;
    private ObjectAnimator hyI;

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
        this.hyC = findViewById(d.g.record_layer1);
        this.hyD = findViewById(d.g.record_layer2);
        this.hyE = findViewById(d.g.record_layer3);
        this.axO = (TextView) findViewById(d.g.tv_tip);
        this.hyE.setScaleX(0.766f);
        this.hyE.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.hyE;
    }

    public View getLayer1() {
        return this.hyC;
    }

    public View getLayer2() {
        return this.hyD;
    }

    public TextView getTvTip() {
        return this.axO;
    }

    public void bEo() {
        if (this.hyI != null && this.hyI.isRunning()) {
            this.hyH.cancel();
        }
        if (this.hyH == null) {
            this.hyH = ObjectAnimator.ofPropertyValuesHolder(this.hyD, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.hyH.setDuration(200L);
        }
        this.hyH.start();
    }

    public void bEp() {
        if (this.hyH != null && this.hyH.isRunning()) {
            this.hyH.cancel();
        }
        if (this.hyD.getScaleX() != 1.0f) {
            if (this.hyI == null) {
                this.hyI = ObjectAnimator.ofPropertyValuesHolder(this.hyD, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.hyI.setDuration(200L);
            }
            this.hyI.start();
        }
    }

    public void nu(boolean z) {
        if (this.hyG != null && this.hyG.isRunning()) {
            this.hyG.cancel();
        }
        if (this.hyF == null) {
            this.hyF = ObjectAnimator.ofPropertyValuesHolder(this.hyE, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.hyF.setRepeatCount(-1);
            this.hyF.setRepeatMode(2);
            this.hyF.setDuration(1000L);
        }
        this.hyE.setVisibility(0);
        if (z) {
            this.hyC.setVisibility(8);
        } else {
            this.hyC.setBackgroundResource(d.f.red_square_bg);
        }
        this.axO.setVisibility(8);
        this.hyF.start();
    }

    public void bEd() {
        if (this.hyF != null && this.hyF.isRunning()) {
            this.hyF.cancel();
        }
        if (this.hyG == null) {
            this.hyG = ObjectAnimator.ofPropertyValuesHolder(this.hyE, PropertyValuesHolder.ofFloat("scaleX", this.hyE.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.hyE.getScaleY(), 0.766f));
            this.hyG.setDuration((500.0f * Math.abs(0.766f - this.hyE.getScaleX())) / 0.3f);
        }
        this.hyC.setVisibility(0);
        this.hyC.setBackgroundResource(d.f.red_circle_bg);
        this.hyG.start();
    }
}
