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
    private TextView CI;
    private View jGd;
    private View jGe;
    private View jGf;
    private ObjectAnimator jGg;
    private ObjectAnimator jGh;
    private ObjectAnimator jGi;
    private ObjectAnimator jGj;

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
        this.jGd = findViewById(R.id.record_layer1);
        this.jGe = findViewById(R.id.record_layer2);
        this.jGf = findViewById(R.id.record_layer3);
        this.CI = (TextView) findViewById(R.id.tv_tip);
        this.jGf.setScaleX(0.766f);
        this.jGf.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.jGf;
    }

    public View getLayer1() {
        return this.jGd;
    }

    public View getLayer2() {
        return this.jGe;
    }

    public TextView getTvTip() {
        return this.CI;
    }

    public void cvW() {
        if (this.jGj != null && this.jGj.isRunning()) {
            this.jGi.cancel();
        }
        if (this.jGi == null) {
            this.jGi = ObjectAnimator.ofPropertyValuesHolder(this.jGe, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.jGi.setDuration(200L);
        }
        this.jGi.start();
    }

    public void cvX() {
        if (this.jGi != null && this.jGi.isRunning()) {
            this.jGi.cancel();
        }
        if (this.jGe.getScaleX() != 1.0f) {
            if (this.jGj == null) {
                this.jGj = ObjectAnimator.ofPropertyValuesHolder(this.jGe, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.jGj.setDuration(200L);
            }
            this.jGj.start();
        }
    }

    public void rA(boolean z) {
        if (this.jGh != null && this.jGh.isRunning()) {
            this.jGh.cancel();
        }
        if (this.jGg == null) {
            this.jGg = ObjectAnimator.ofPropertyValuesHolder(this.jGf, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.jGg.setRepeatCount(-1);
            this.jGg.setRepeatMode(2);
            this.jGg.setDuration(1000L);
        }
        this.jGf.setVisibility(0);
        if (z) {
            this.jGd.setVisibility(8);
        } else {
            this.jGd.setBackgroundResource(R.drawable.red_square_bg);
        }
        this.CI.setVisibility(8);
        this.jGg.start();
    }

    public void cvL() {
        if (this.jGg != null && this.jGg.isRunning()) {
            this.jGg.cancel();
        }
        if (this.jGh == null) {
            this.jGh = ObjectAnimator.ofPropertyValuesHolder(this.jGf, PropertyValuesHolder.ofFloat("scaleX", this.jGf.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.jGf.getScaleY(), 0.766f));
            this.jGh.setDuration((500.0f * Math.abs(0.766f - this.jGf.getScaleX())) / 0.3f);
        }
        this.jGd.setVisibility(0);
        this.jGd.setBackgroundResource(R.drawable.red_circle_bg);
        this.jGh.start();
    }
}
