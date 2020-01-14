package com.baidu.tieba.video.record;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class VideoRecordButton extends FrameLayout {
    private TextView Fu;
    private View kDt;
    private View kDu;
    private View kDv;
    private ObjectAnimator kDw;
    private ObjectAnimator kDx;
    private ObjectAnimator kDy;
    private ObjectAnimator kDz;

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
        this.kDt = findViewById(R.id.record_layer1);
        this.kDu = findViewById(R.id.record_layer2);
        this.kDv = findViewById(R.id.record_layer3);
        this.Fu = (TextView) findViewById(R.id.tv_tip);
        this.kDv.setScaleX(0.766f);
        this.kDv.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.kDv;
    }

    public View getLayer1() {
        return this.kDt;
    }

    public View getLayer2() {
        return this.kDu;
    }

    public TextView getTvTip() {
        return this.Fu;
    }

    public void cQS() {
        if (this.kDz != null && this.kDz.isRunning()) {
            this.kDy.cancel();
        }
        if (this.kDy == null) {
            this.kDy = ObjectAnimator.ofPropertyValuesHolder(this.kDu, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.kDy.setDuration(200L);
        }
        this.kDy.start();
    }

    public void cQT() {
        if (this.kDy != null && this.kDy.isRunning()) {
            this.kDy.cancel();
        }
        if (this.kDu.getScaleX() != 1.0f) {
            if (this.kDz == null) {
                this.kDz = ObjectAnimator.ofPropertyValuesHolder(this.kDu, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.kDz.setDuration(200L);
            }
            this.kDz.start();
        }
    }

    public void ts(boolean z) {
        if (this.kDx != null && this.kDx.isRunning()) {
            this.kDx.cancel();
        }
        if (this.kDw == null) {
            this.kDw = ObjectAnimator.ofPropertyValuesHolder(this.kDv, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.kDw.setRepeatCount(-1);
            this.kDw.setRepeatMode(2);
            this.kDw.setDuration(1000L);
        }
        this.kDv.setVisibility(0);
        if (z) {
            this.kDt.setVisibility(8);
        } else {
            this.kDt.setBackgroundResource(R.drawable.red_square_bg);
        }
        this.Fu.setVisibility(8);
        this.kDw.start();
    }

    public void cQH() {
        if (this.kDw != null && this.kDw.isRunning()) {
            this.kDw.cancel();
        }
        if (this.kDx == null) {
            this.kDx = ObjectAnimator.ofPropertyValuesHolder(this.kDv, PropertyValuesHolder.ofFloat("scaleX", this.kDv.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.kDv.getScaleY(), 0.766f));
            this.kDx.setDuration((500.0f * Math.abs(0.766f - this.kDv.getScaleX())) / 0.3f);
        }
        this.kDt.setVisibility(0);
        this.kDt.setBackgroundResource(R.drawable.red_circle_bg);
        this.kDx.start();
    }
}
