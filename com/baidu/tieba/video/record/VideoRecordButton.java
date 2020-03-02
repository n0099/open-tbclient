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
    private TextView FN;
    private View kEq;
    private View kEr;
    private View kEs;
    private ObjectAnimator kEt;
    private ObjectAnimator kEu;
    private ObjectAnimator kEv;
    private ObjectAnimator kEw;

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
        this.kEq = findViewById(R.id.record_layer1);
        this.kEr = findViewById(R.id.record_layer2);
        this.kEs = findViewById(R.id.record_layer3);
        this.FN = (TextView) findViewById(R.id.tv_tip);
        this.kEs.setScaleX(0.766f);
        this.kEs.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.kEs;
    }

    public View getLayer1() {
        return this.kEq;
    }

    public View getLayer2() {
        return this.kEr;
    }

    public TextView getTvTip() {
        return this.FN;
    }

    public void cSn() {
        if (this.kEw != null && this.kEw.isRunning()) {
            this.kEv.cancel();
        }
        if (this.kEv == null) {
            this.kEv = ObjectAnimator.ofPropertyValuesHolder(this.kEr, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.kEv.setDuration(200L);
        }
        this.kEv.start();
    }

    public void cSo() {
        if (this.kEv != null && this.kEv.isRunning()) {
            this.kEv.cancel();
        }
        if (this.kEr.getScaleX() != 1.0f) {
            if (this.kEw == null) {
                this.kEw = ObjectAnimator.ofPropertyValuesHolder(this.kEr, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.kEw.setDuration(200L);
            }
            this.kEw.start();
        }
    }

    public void tw(boolean z) {
        if (this.kEu != null && this.kEu.isRunning()) {
            this.kEu.cancel();
        }
        if (this.kEt == null) {
            this.kEt = ObjectAnimator.ofPropertyValuesHolder(this.kEs, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.kEt.setRepeatCount(-1);
            this.kEt.setRepeatMode(2);
            this.kEt.setDuration(1000L);
        }
        this.kEs.setVisibility(0);
        if (z) {
            this.kEq.setVisibility(8);
        } else {
            this.kEq.setBackgroundResource(R.drawable.red_square_bg);
        }
        this.FN.setVisibility(8);
        this.kEt.start();
    }

    public void cSc() {
        if (this.kEt != null && this.kEt.isRunning()) {
            this.kEt.cancel();
        }
        if (this.kEu == null) {
            this.kEu = ObjectAnimator.ofPropertyValuesHolder(this.kEs, PropertyValuesHolder.ofFloat("scaleX", this.kEs.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.kEs.getScaleY(), 0.766f));
            this.kEu.setDuration((500.0f * Math.abs(0.766f - this.kEs.getScaleX())) / 0.3f);
        }
        this.kEq.setVisibility(0);
        this.kEq.setBackgroundResource(R.drawable.red_circle_bg);
        this.kEu.start();
    }
}
