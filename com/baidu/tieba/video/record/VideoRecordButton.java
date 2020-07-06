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
    private ObjectAnimator meA;
    private ObjectAnimator meB;
    private ObjectAnimator meC;
    private View mew;
    private View mex;
    private View mey;
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
        this.mew = findViewById(R.id.record_layer1);
        this.mex = findViewById(R.id.record_layer2);
        this.mey = findViewById(R.id.record_layer3);
        this.ZW = (TextView) findViewById(R.id.tv_tip);
        this.mey.setScaleX(0.766f);
        this.mey.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.mey;
    }

    public View getLayer1() {
        return this.mew;
    }

    public View getLayer2() {
        return this.mex;
    }

    public TextView getTvTip() {
        return this.ZW;
    }

    public void dpA() {
        if (this.meC != null && this.meC.isRunning()) {
            this.meB.cancel();
        }
        if (this.meB == null) {
            this.meB = ObjectAnimator.ofPropertyValuesHolder(this.mex, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.meB.setDuration(200L);
        }
        this.meB.start();
    }

    public void dpB() {
        if (this.meB != null && this.meB.isRunning()) {
            this.meB.cancel();
        }
        if (this.mex.getScaleX() != 1.0f) {
            if (this.meC == null) {
                this.meC = ObjectAnimator.ofPropertyValuesHolder(this.mex, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.meC.setDuration(200L);
            }
            this.meC.start();
        }
    }

    public void vu(boolean z) {
        if (this.meA != null && this.meA.isRunning()) {
            this.meA.cancel();
        }
        if (this.mez == null) {
            this.mez = ObjectAnimator.ofPropertyValuesHolder(this.mey, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.mez.setRepeatCount(-1);
            this.mez.setRepeatMode(2);
            this.mez.setDuration(1000L);
        }
        this.mey.setVisibility(0);
        if (z) {
            this.mew.setVisibility(8);
        } else {
            this.mew.setBackgroundResource(R.drawable.red_square_bg);
        }
        this.ZW.setVisibility(8);
        this.mez.start();
    }

    public void dpp() {
        if (this.mez != null && this.mez.isRunning()) {
            this.mez.cancel();
        }
        if (this.meA == null) {
            this.meA = ObjectAnimator.ofPropertyValuesHolder(this.mey, PropertyValuesHolder.ofFloat("scaleX", this.mey.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.mey.getScaleY(), 0.766f));
            this.meA.setDuration((500.0f * Math.abs(0.766f - this.mey.getScaleX())) / 0.3f);
        }
        this.mew.setVisibility(0);
        this.mew.setBackgroundResource(R.drawable.red_circle_bg);
        this.meA.start();
    }
}
