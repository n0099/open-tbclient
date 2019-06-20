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
    private TextView Tz;
    private View jxs;
    private View jxt;
    private View jxu;
    private ObjectAnimator jxv;
    private ObjectAnimator jxw;
    private ObjectAnimator jxx;
    private ObjectAnimator jxy;

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
        this.jxs = findViewById(R.id.record_layer1);
        this.jxt = findViewById(R.id.record_layer2);
        this.jxu = findViewById(R.id.record_layer3);
        this.Tz = (TextView) findViewById(R.id.tv_tip);
        this.jxu.setScaleX(0.766f);
        this.jxu.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.jxu;
    }

    public View getLayer1() {
        return this.jxs;
    }

    public View getLayer2() {
        return this.jxt;
    }

    public TextView getTvTip() {
        return this.Tz;
    }

    public void cuj() {
        if (this.jxy != null && this.jxy.isRunning()) {
            this.jxx.cancel();
        }
        if (this.jxx == null) {
            this.jxx = ObjectAnimator.ofPropertyValuesHolder(this.jxt, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.jxx.setDuration(200L);
        }
        this.jxx.start();
    }

    public void cuk() {
        if (this.jxx != null && this.jxx.isRunning()) {
            this.jxx.cancel();
        }
        if (this.jxt.getScaleX() != 1.0f) {
            if (this.jxy == null) {
                this.jxy = ObjectAnimator.ofPropertyValuesHolder(this.jxt, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.jxy.setDuration(200L);
            }
            this.jxy.start();
        }
    }

    public void rA(boolean z) {
        if (this.jxw != null && this.jxw.isRunning()) {
            this.jxw.cancel();
        }
        if (this.jxv == null) {
            this.jxv = ObjectAnimator.ofPropertyValuesHolder(this.jxu, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.jxv.setRepeatCount(-1);
            this.jxv.setRepeatMode(2);
            this.jxv.setDuration(1000L);
        }
        this.jxu.setVisibility(0);
        if (z) {
            this.jxs.setVisibility(8);
        } else {
            this.jxs.setBackgroundResource(R.drawable.red_square_bg);
        }
        this.Tz.setVisibility(8);
        this.jxv.start();
    }

    public void ctY() {
        if (this.jxv != null && this.jxv.isRunning()) {
            this.jxv.cancel();
        }
        if (this.jxw == null) {
            this.jxw = ObjectAnimator.ofPropertyValuesHolder(this.jxu, PropertyValuesHolder.ofFloat("scaleX", this.jxu.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.jxu.getScaleY(), 0.766f));
            this.jxw.setDuration((500.0f * Math.abs(0.766f - this.jxu.getScaleX())) / 0.3f);
        }
        this.jxs.setVisibility(0);
        this.jxs.setBackgroundResource(R.drawable.red_circle_bg);
        this.jxw.start();
    }
}
