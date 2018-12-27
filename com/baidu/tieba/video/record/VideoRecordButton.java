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
    private View hNc;
    private View hNd;
    private View hNe;
    private ObjectAnimator hNf;
    private ObjectAnimator hNg;
    private ObjectAnimator hNh;
    private ObjectAnimator hNi;

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
        this.hNc = findViewById(e.g.record_layer1);
        this.hNd = findViewById(e.g.record_layer2);
        this.hNe = findViewById(e.g.record_layer3);
        this.SZ = (TextView) findViewById(e.g.tv_tip);
        this.hNe.setScaleX(0.766f);
        this.hNe.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.hNe;
    }

    public View getLayer1() {
        return this.hNc;
    }

    public View getLayer2() {
        return this.hNd;
    }

    public TextView getTvTip() {
        return this.SZ;
    }

    public void bLX() {
        if (this.hNi != null && this.hNi.isRunning()) {
            this.hNh.cancel();
        }
        if (this.hNh == null) {
            this.hNh = ObjectAnimator.ofPropertyValuesHolder(this.hNd, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.hNh.setDuration(200L);
        }
        this.hNh.start();
    }

    public void bLY() {
        if (this.hNh != null && this.hNh.isRunning()) {
            this.hNh.cancel();
        }
        if (this.hNd.getScaleX() != 1.0f) {
            if (this.hNi == null) {
                this.hNi = ObjectAnimator.ofPropertyValuesHolder(this.hNd, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.hNi.setDuration(200L);
            }
            this.hNi.start();
        }
    }

    public void oj(boolean z) {
        if (this.hNg != null && this.hNg.isRunning()) {
            this.hNg.cancel();
        }
        if (this.hNf == null) {
            this.hNf = ObjectAnimator.ofPropertyValuesHolder(this.hNe, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.hNf.setRepeatCount(-1);
            this.hNf.setRepeatMode(2);
            this.hNf.setDuration(1000L);
        }
        this.hNe.setVisibility(0);
        if (z) {
            this.hNc.setVisibility(8);
        } else {
            this.hNc.setBackgroundResource(e.f.red_square_bg);
        }
        this.SZ.setVisibility(8);
        this.hNf.start();
    }

    public void bLM() {
        if (this.hNf != null && this.hNf.isRunning()) {
            this.hNf.cancel();
        }
        if (this.hNg == null) {
            this.hNg = ObjectAnimator.ofPropertyValuesHolder(this.hNe, PropertyValuesHolder.ofFloat("scaleX", this.hNe.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.hNe.getScaleY(), 0.766f));
            this.hNg.setDuration((500.0f * Math.abs(0.766f - this.hNe.getScaleX())) / 0.3f);
        }
        this.hNc.setVisibility(0);
        this.hNc.setBackgroundResource(e.f.red_circle_bg);
        this.hNg.start();
    }
}
