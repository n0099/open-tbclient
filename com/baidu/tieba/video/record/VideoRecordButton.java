package com.baidu.tieba.video.record;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class VideoRecordButton extends FrameLayout {
    private TextView TS;
    private View jHe;
    private View jHf;
    private View jHg;
    private ObjectAnimator jHh;
    private ObjectAnimator jHi;
    private ObjectAnimator jHj;
    private ObjectAnimator jHk;

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
        this.jHe = findViewById(R.id.record_layer1);
        this.jHf = findViewById(R.id.record_layer2);
        this.jHg = findViewById(R.id.record_layer3);
        this.TS = (TextView) findViewById(R.id.tv_tip);
        this.jHg.setScaleX(0.766f);
        this.jHg.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.jHg;
    }

    public View getLayer1() {
        return this.jHe;
    }

    public View getLayer2() {
        return this.jHf;
    }

    public TextView getTvTip() {
        return this.TS;
    }

    public void cyi() {
        if (this.jHk != null && this.jHk.isRunning()) {
            this.jHj.cancel();
        }
        if (this.jHj == null) {
            this.jHj = ObjectAnimator.ofPropertyValuesHolder(this.jHf, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.jHj.setDuration(200L);
        }
        this.jHj.start();
    }

    public void cyj() {
        if (this.jHj != null && this.jHj.isRunning()) {
            this.jHj.cancel();
        }
        if (this.jHf.getScaleX() != 1.0f) {
            if (this.jHk == null) {
                this.jHk = ObjectAnimator.ofPropertyValuesHolder(this.jHf, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.jHk.setDuration(200L);
            }
            this.jHk.start();
        }
    }

    public void rR(boolean z) {
        if (this.jHi != null && this.jHi.isRunning()) {
            this.jHi.cancel();
        }
        if (this.jHh == null) {
            this.jHh = ObjectAnimator.ofPropertyValuesHolder(this.jHg, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.jHh.setRepeatCount(-1);
            this.jHh.setRepeatMode(2);
            this.jHh.setDuration(1000L);
        }
        this.jHg.setVisibility(0);
        if (z) {
            this.jHe.setVisibility(8);
        } else {
            this.jHe.setBackgroundResource(R.drawable.red_square_bg);
        }
        this.TS.setVisibility(8);
        this.jHh.start();
    }

    public void cxX() {
        if (this.jHh != null && this.jHh.isRunning()) {
            this.jHh.cancel();
        }
        if (this.jHi == null) {
            this.jHi = ObjectAnimator.ofPropertyValuesHolder(this.jHg, PropertyValuesHolder.ofFloat("scaleX", this.jHg.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.jHg.getScaleY(), 0.766f));
            this.jHi.setDuration((500.0f * Math.abs(0.766f - this.jHg.getScaleX())) / 0.3f);
        }
        this.jHe.setVisibility(0);
        this.jHe.setBackgroundResource(R.drawable.red_circle_bg);
        this.jHi.start();
    }
}
