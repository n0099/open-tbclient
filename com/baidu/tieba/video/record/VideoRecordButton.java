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
    private View hJR;
    private View hJS;
    private View hJT;
    private ObjectAnimator hJU;
    private ObjectAnimator hJV;
    private ObjectAnimator hJW;
    private ObjectAnimator hJX;

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
        this.hJR = findViewById(e.g.record_layer1);
        this.hJS = findViewById(e.g.record_layer2);
        this.hJT = findViewById(e.g.record_layer3);
        this.SZ = (TextView) findViewById(e.g.tv_tip);
        this.hJT.setScaleX(0.766f);
        this.hJT.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.hJT;
    }

    public View getLayer1() {
        return this.hJR;
    }

    public View getLayer2() {
        return this.hJS;
    }

    public TextView getTvTip() {
        return this.SZ;
    }

    public void bLi() {
        if (this.hJX != null && this.hJX.isRunning()) {
            this.hJW.cancel();
        }
        if (this.hJW == null) {
            this.hJW = ObjectAnimator.ofPropertyValuesHolder(this.hJS, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.hJW.setDuration(200L);
        }
        this.hJW.start();
    }

    public void bLj() {
        if (this.hJW != null && this.hJW.isRunning()) {
            this.hJW.cancel();
        }
        if (this.hJS.getScaleX() != 1.0f) {
            if (this.hJX == null) {
                this.hJX = ObjectAnimator.ofPropertyValuesHolder(this.hJS, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.hJX.setDuration(200L);
            }
            this.hJX.start();
        }
    }

    public void og(boolean z) {
        if (this.hJV != null && this.hJV.isRunning()) {
            this.hJV.cancel();
        }
        if (this.hJU == null) {
            this.hJU = ObjectAnimator.ofPropertyValuesHolder(this.hJT, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.hJU.setRepeatCount(-1);
            this.hJU.setRepeatMode(2);
            this.hJU.setDuration(1000L);
        }
        this.hJT.setVisibility(0);
        if (z) {
            this.hJR.setVisibility(8);
        } else {
            this.hJR.setBackgroundResource(e.f.red_square_bg);
        }
        this.SZ.setVisibility(8);
        this.hJU.start();
    }

    public void bKX() {
        if (this.hJU != null && this.hJU.isRunning()) {
            this.hJU.cancel();
        }
        if (this.hJV == null) {
            this.hJV = ObjectAnimator.ofPropertyValuesHolder(this.hJT, PropertyValuesHolder.ofFloat("scaleX", this.hJT.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.hJT.getScaleY(), 0.766f));
            this.hJV.setDuration((500.0f * Math.abs(0.766f - this.hJT.getScaleX())) / 0.3f);
        }
        this.hJR.setVisibility(0);
        this.hJR.setBackgroundResource(e.f.red_circle_bg);
        this.hJV.start();
    }
}
