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
    private View kEo;
    private View kEp;
    private View kEq;
    private ObjectAnimator kEr;
    private ObjectAnimator kEs;
    private ObjectAnimator kEt;
    private ObjectAnimator kEu;

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
        this.kEo = findViewById(R.id.record_layer1);
        this.kEp = findViewById(R.id.record_layer2);
        this.kEq = findViewById(R.id.record_layer3);
        this.FN = (TextView) findViewById(R.id.tv_tip);
        this.kEq.setScaleX(0.766f);
        this.kEq.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.kEq;
    }

    public View getLayer1() {
        return this.kEo;
    }

    public View getLayer2() {
        return this.kEp;
    }

    public TextView getTvTip() {
        return this.FN;
    }

    public void cSl() {
        if (this.kEu != null && this.kEu.isRunning()) {
            this.kEt.cancel();
        }
        if (this.kEt == null) {
            this.kEt = ObjectAnimator.ofPropertyValuesHolder(this.kEp, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.kEt.setDuration(200L);
        }
        this.kEt.start();
    }

    public void cSm() {
        if (this.kEt != null && this.kEt.isRunning()) {
            this.kEt.cancel();
        }
        if (this.kEp.getScaleX() != 1.0f) {
            if (this.kEu == null) {
                this.kEu = ObjectAnimator.ofPropertyValuesHolder(this.kEp, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.kEu.setDuration(200L);
            }
            this.kEu.start();
        }
    }

    public void tw(boolean z) {
        if (this.kEs != null && this.kEs.isRunning()) {
            this.kEs.cancel();
        }
        if (this.kEr == null) {
            this.kEr = ObjectAnimator.ofPropertyValuesHolder(this.kEq, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.kEr.setRepeatCount(-1);
            this.kEr.setRepeatMode(2);
            this.kEr.setDuration(1000L);
        }
        this.kEq.setVisibility(0);
        if (z) {
            this.kEo.setVisibility(8);
        } else {
            this.kEo.setBackgroundResource(R.drawable.red_square_bg);
        }
        this.FN.setVisibility(8);
        this.kEr.start();
    }

    public void cSa() {
        if (this.kEr != null && this.kEr.isRunning()) {
            this.kEr.cancel();
        }
        if (this.kEs == null) {
            this.kEs = ObjectAnimator.ofPropertyValuesHolder(this.kEq, PropertyValuesHolder.ofFloat("scaleX", this.kEq.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.kEq.getScaleY(), 0.766f));
            this.kEs.setDuration((500.0f * Math.abs(0.766f - this.kEq.getScaleX())) / 0.3f);
        }
        this.kEo.setVisibility(0);
        this.kEo.setBackgroundResource(R.drawable.red_circle_bg);
        this.kEs.start();
    }
}
