package com.baidu.tieba.video.record;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class VideoRecordButton extends FrameLayout {
    private TextView ZW;
    private View met;
    private View meu;
    private View mev;
    private ObjectAnimator mew;
    private ObjectAnimator mex;
    private ObjectAnimator mey;
    private ObjectAnimator mez;

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
        this.met = findViewById(R.id.record_layer1);
        this.meu = findViewById(R.id.record_layer2);
        this.mev = findViewById(R.id.record_layer3);
        this.ZW = (TextView) findViewById(R.id.tv_tip);
        this.mev.setScaleX(0.766f);
        this.mev.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.mev;
    }

    public View getLayer1() {
        return this.met;
    }

    public View getLayer2() {
        return this.meu;
    }

    public TextView getTvTip() {
        return this.ZW;
    }

    public void dpw() {
        if (this.mez != null && this.mez.isRunning()) {
            this.mey.cancel();
        }
        if (this.mey == null) {
            this.mey = ObjectAnimator.ofPropertyValuesHolder(this.meu, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.mey.setDuration(200L);
        }
        this.mey.start();
    }

    public void dpx() {
        if (this.mey != null && this.mey.isRunning()) {
            this.mey.cancel();
        }
        if (this.meu.getScaleX() != 1.0f) {
            if (this.mez == null) {
                this.mez = ObjectAnimator.ofPropertyValuesHolder(this.meu, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.mez.setDuration(200L);
            }
            this.mez.start();
        }
    }

    public void vu(boolean z) {
        if (this.mex != null && this.mex.isRunning()) {
            this.mex.cancel();
        }
        if (this.mew == null) {
            this.mew = ObjectAnimator.ofPropertyValuesHolder(this.mev, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.mew.setRepeatCount(-1);
            this.mew.setRepeatMode(2);
            this.mew.setDuration(1000L);
        }
        this.mev.setVisibility(0);
        if (z) {
            this.met.setVisibility(8);
        } else {
            this.met.setBackgroundResource(R.drawable.red_square_bg);
        }
        this.ZW.setVisibility(8);
        this.mew.start();
    }

    public void dpl() {
        if (this.mew != null && this.mew.isRunning()) {
            this.mew.cancel();
        }
        if (this.mex == null) {
            this.mex = ObjectAnimator.ofPropertyValuesHolder(this.mev, PropertyValuesHolder.ofFloat("scaleX", this.mev.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.mev.getScaleY(), 0.766f));
            this.mex.setDuration((500.0f * Math.abs(0.766f - this.mev.getScaleX())) / 0.3f);
        }
        this.met.setVisibility(0);
        this.met.setBackgroundResource(R.drawable.red_circle_bg);
        this.mex.start();
    }
}
