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
    private View kDo;
    private View kDp;
    private View kDq;
    private ObjectAnimator kDr;
    private ObjectAnimator kDs;
    private ObjectAnimator kDt;
    private ObjectAnimator kDu;

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
        this.kDo = findViewById(R.id.record_layer1);
        this.kDp = findViewById(R.id.record_layer2);
        this.kDq = findViewById(R.id.record_layer3);
        this.Fu = (TextView) findViewById(R.id.tv_tip);
        this.kDq.setScaleX(0.766f);
        this.kDq.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.kDq;
    }

    public View getLayer1() {
        return this.kDo;
    }

    public View getLayer2() {
        return this.kDp;
    }

    public TextView getTvTip() {
        return this.Fu;
    }

    public void cQQ() {
        if (this.kDu != null && this.kDu.isRunning()) {
            this.kDt.cancel();
        }
        if (this.kDt == null) {
            this.kDt = ObjectAnimator.ofPropertyValuesHolder(this.kDp, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.kDt.setDuration(200L);
        }
        this.kDt.start();
    }

    public void cQR() {
        if (this.kDt != null && this.kDt.isRunning()) {
            this.kDt.cancel();
        }
        if (this.kDp.getScaleX() != 1.0f) {
            if (this.kDu == null) {
                this.kDu = ObjectAnimator.ofPropertyValuesHolder(this.kDp, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.kDu.setDuration(200L);
            }
            this.kDu.start();
        }
    }

    public void ts(boolean z) {
        if (this.kDs != null && this.kDs.isRunning()) {
            this.kDs.cancel();
        }
        if (this.kDr == null) {
            this.kDr = ObjectAnimator.ofPropertyValuesHolder(this.kDq, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.kDr.setRepeatCount(-1);
            this.kDr.setRepeatMode(2);
            this.kDr.setDuration(1000L);
        }
        this.kDq.setVisibility(0);
        if (z) {
            this.kDo.setVisibility(8);
        } else {
            this.kDo.setBackgroundResource(R.drawable.red_square_bg);
        }
        this.Fu.setVisibility(8);
        this.kDr.start();
    }

    public void cQF() {
        if (this.kDr != null && this.kDr.isRunning()) {
            this.kDr.cancel();
        }
        if (this.kDs == null) {
            this.kDs = ObjectAnimator.ofPropertyValuesHolder(this.kDq, PropertyValuesHolder.ofFloat("scaleX", this.kDq.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.kDq.getScaleY(), 0.766f));
            this.kDs.setDuration((500.0f * Math.abs(0.766f - this.kDq.getScaleX())) / 0.3f);
        }
        this.kDo.setVisibility(0);
        this.kDo.setBackgroundResource(R.drawable.red_circle_bg);
        this.kDs.start();
    }
}
