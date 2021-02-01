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
    private TextView acQ;
    private View nTo;
    private View nTp;
    private View nTq;
    private ObjectAnimator nTr;
    private ObjectAnimator nTs;
    private ObjectAnimator nTt;
    private ObjectAnimator nTu;

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
        this.nTo = findViewById(R.id.record_layer1);
        this.nTp = findViewById(R.id.record_layer2);
        this.nTq = findViewById(R.id.record_layer3);
        this.acQ = (TextView) findViewById(R.id.tv_tip);
        this.nTq.setScaleX(0.766f);
        this.nTq.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.nTq;
    }

    public View getLayer1() {
        return this.nTo;
    }

    public View getLayer2() {
        return this.nTp;
    }

    public TextView getTvTip() {
        return this.acQ;
    }

    public void dUV() {
        if (this.nTu != null && this.nTu.isRunning()) {
            this.nTt.cancel();
        }
        if (this.nTt == null) {
            this.nTt = ObjectAnimator.ofPropertyValuesHolder(this.nTp, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.nTt.setDuration(200L);
        }
        this.nTt.start();
    }

    public void dUW() {
        if (this.nTt != null && this.nTt.isRunning()) {
            this.nTt.cancel();
        }
        if (this.nTp.getScaleX() != 1.0f) {
            if (this.nTu == null) {
                this.nTu = ObjectAnimator.ofPropertyValuesHolder(this.nTp, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.nTu.setDuration(200L);
            }
            this.nTu.start();
        }
    }

    public void zg(boolean z) {
        if (this.nTs != null && this.nTs.isRunning()) {
            this.nTs.cancel();
        }
        if (this.nTr == null) {
            this.nTr = ObjectAnimator.ofPropertyValuesHolder(this.nTq, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.nTr.setRepeatCount(-1);
            this.nTr.setRepeatMode(2);
            this.nTr.setDuration(1000L);
        }
        this.nTq.setVisibility(0);
        if (z) {
            this.nTo.setVisibility(8);
        } else {
            this.nTo.setBackgroundResource(R.drawable.red_square_bg);
        }
        this.acQ.setVisibility(8);
        this.nTr.start();
    }

    public void dUK() {
        if (this.nTr != null && this.nTr.isRunning()) {
            this.nTr.cancel();
        }
        if (this.nTs == null) {
            this.nTs = ObjectAnimator.ofPropertyValuesHolder(this.nTq, PropertyValuesHolder.ofFloat("scaleX", this.nTq.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.nTq.getScaleY(), 0.766f));
            this.nTs.setDuration((500.0f * Math.abs(0.766f - this.nTq.getScaleX())) / 0.3f);
        }
        this.nTo.setVisibility(0);
        this.nTo.setBackgroundResource(R.drawable.red_circle_bg);
        this.nTs.start();
    }
}
