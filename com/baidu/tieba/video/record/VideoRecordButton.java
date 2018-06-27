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
    private TextView Qi;
    private View hkE;
    private View hkF;
    private View hkG;
    private ObjectAnimator hkH;
    private ObjectAnimator hkI;
    private ObjectAnimator hkJ;
    private ObjectAnimator hkK;

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
        this.hkE = findViewById(d.g.record_layer1);
        this.hkF = findViewById(d.g.record_layer2);
        this.hkG = findViewById(d.g.record_layer3);
        this.Qi = (TextView) findViewById(d.g.tv_tip);
        this.hkG.setScaleX(0.766f);
        this.hkG.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.hkG;
    }

    public View getLayer1() {
        return this.hkE;
    }

    public View getLayer2() {
        return this.hkF;
    }

    public TextView getTvTip() {
        return this.Qi;
    }

    public void bEQ() {
        if (this.hkK != null && this.hkK.isRunning()) {
            this.hkJ.cancel();
        }
        if (this.hkJ == null) {
            this.hkJ = ObjectAnimator.ofPropertyValuesHolder(this.hkF, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.hkJ.setDuration(200L);
        }
        this.hkJ.start();
    }

    public void bER() {
        if (this.hkJ != null && this.hkJ.isRunning()) {
            this.hkJ.cancel();
        }
        if (this.hkF.getScaleX() != 1.0f) {
            if (this.hkK == null) {
                this.hkK = ObjectAnimator.ofPropertyValuesHolder(this.hkF, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.hkK.setDuration(200L);
            }
            this.hkK.start();
        }
    }

    public void nq(boolean z) {
        if (this.hkI != null && this.hkI.isRunning()) {
            this.hkI.cancel();
        }
        if (this.hkH == null) {
            this.hkH = ObjectAnimator.ofPropertyValuesHolder(this.hkG, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.hkH.setRepeatCount(-1);
            this.hkH.setRepeatMode(2);
            this.hkH.setDuration(1000L);
        }
        this.hkG.setVisibility(0);
        if (z) {
            this.hkE.setVisibility(8);
        } else {
            this.hkE.setBackgroundResource(d.f.red_square_bg);
        }
        this.Qi.setVisibility(8);
        this.hkH.start();
    }

    public void bEF() {
        if (this.hkH != null && this.hkH.isRunning()) {
            this.hkH.cancel();
        }
        if (this.hkI == null) {
            this.hkI = ObjectAnimator.ofPropertyValuesHolder(this.hkG, PropertyValuesHolder.ofFloat("scaleX", this.hkG.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.hkG.getScaleY(), 0.766f));
            this.hkI.setDuration((500.0f * Math.abs(0.766f - this.hkG.getScaleX())) / 0.3f);
        }
        this.hkE.setVisibility(0);
        this.hkE.setBackgroundResource(d.f.red_circle_bg);
        this.hkI.start();
    }
}
