package com.baidu.tieba.video.record;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class VideoRecordButton extends FrameLayout {
    private TextView Qf;
    private View hlS;
    private View hlT;
    private View hlU;
    private ObjectAnimator hlV;
    private ObjectAnimator hlW;
    private ObjectAnimator hlX;
    private ObjectAnimator hlY;

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
        inflate(getContext(), d.h.layout_record_button, this);
        this.hlS = findViewById(d.g.record_layer1);
        this.hlT = findViewById(d.g.record_layer2);
        this.hlU = findViewById(d.g.record_layer3);
        this.Qf = (TextView) findViewById(d.g.tv_tip);
        this.hlU.setScaleX(0.766f);
        this.hlU.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.hlU;
    }

    public View getLayer1() {
        return this.hlS;
    }

    public View getLayer2() {
        return this.hlT;
    }

    public TextView getTvTip() {
        return this.Qf;
    }

    public void bDA() {
        if (this.hlY != null && this.hlY.isRunning()) {
            this.hlX.cancel();
        }
        if (this.hlX == null) {
            this.hlX = ObjectAnimator.ofPropertyValuesHolder(this.hlT, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.hlX.setDuration(200L);
        }
        this.hlX.start();
    }

    public void bDB() {
        if (this.hlX != null && this.hlX.isRunning()) {
            this.hlX.cancel();
        }
        if (this.hlT.getScaleX() != 1.0f) {
            if (this.hlY == null) {
                this.hlY = ObjectAnimator.ofPropertyValuesHolder(this.hlT, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.hlY.setDuration(200L);
            }
            this.hlY.start();
        }
    }

    public void nd(boolean z) {
        if (this.hlW != null && this.hlW.isRunning()) {
            this.hlW.cancel();
        }
        if (this.hlV == null) {
            this.hlV = ObjectAnimator.ofPropertyValuesHolder(this.hlU, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.hlV.setRepeatCount(-1);
            this.hlV.setRepeatMode(2);
            this.hlV.setDuration(1000L);
        }
        this.hlU.setVisibility(0);
        if (z) {
            this.hlS.setVisibility(8);
        } else {
            this.hlS.setBackgroundResource(d.f.red_square_bg);
        }
        this.Qf.setVisibility(8);
        this.hlV.start();
    }

    public void bDp() {
        if (this.hlV != null && this.hlV.isRunning()) {
            this.hlV.cancel();
        }
        if (this.hlW == null) {
            this.hlW = ObjectAnimator.ofPropertyValuesHolder(this.hlU, PropertyValuesHolder.ofFloat("scaleX", this.hlU.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.hlU.getScaleY(), 0.766f));
            this.hlW.setDuration((500.0f * Math.abs(0.766f - this.hlU.getScaleX())) / 0.3f);
        }
        this.hlS.setVisibility(0);
        this.hlS.setBackgroundResource(d.f.red_circle_bg);
        this.hlW.start();
    }
}
