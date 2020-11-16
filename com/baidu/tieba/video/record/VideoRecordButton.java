package com.baidu.tieba.video.record;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class VideoRecordButton extends FrameLayout {
    private TextView abo;
    private View nwO;
    private View nwP;
    private View nwQ;
    private ObjectAnimator nwR;
    private ObjectAnimator nwS;
    private ObjectAnimator nwT;
    private ObjectAnimator nwU;

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
        this.nwO = findViewById(R.id.record_layer1);
        this.nwP = findViewById(R.id.record_layer2);
        this.nwQ = findViewById(R.id.record_layer3);
        this.abo = (TextView) findViewById(R.id.tv_tip);
        this.nwQ.setScaleX(0.766f);
        this.nwQ.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.nwQ;
    }

    public View getLayer1() {
        return this.nwO;
    }

    public View getLayer2() {
        return this.nwP;
    }

    public TextView getTvTip() {
        return this.abo;
    }

    public void dRD() {
        if (this.nwU != null && this.nwU.isRunning()) {
            this.nwT.cancel();
        }
        if (this.nwT == null) {
            this.nwT = ObjectAnimator.ofPropertyValuesHolder(this.nwP, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.nwT.setDuration(200L);
        }
        this.nwT.start();
    }

    public void dRE() {
        if (this.nwT != null && this.nwT.isRunning()) {
            this.nwT.cancel();
        }
        if (this.nwP.getScaleX() != 1.0f) {
            if (this.nwU == null) {
                this.nwU = ObjectAnimator.ofPropertyValuesHolder(this.nwP, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.nwU.setDuration(200L);
            }
            this.nwU.start();
        }
    }

    public void ym(boolean z) {
        if (this.nwS != null && this.nwS.isRunning()) {
            this.nwS.cancel();
        }
        if (this.nwR == null) {
            this.nwR = ObjectAnimator.ofPropertyValuesHolder(this.nwQ, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.nwR.setRepeatCount(-1);
            this.nwR.setRepeatMode(2);
            this.nwR.setDuration(1000L);
        }
        this.nwQ.setVisibility(0);
        if (z) {
            this.nwO.setVisibility(8);
        } else {
            this.nwO.setBackgroundResource(R.drawable.red_square_bg);
        }
        this.abo.setVisibility(8);
        this.nwR.start();
    }

    public void dRs() {
        if (this.nwR != null && this.nwR.isRunning()) {
            this.nwR.cancel();
        }
        if (this.nwS == null) {
            this.nwS = ObjectAnimator.ofPropertyValuesHolder(this.nwQ, PropertyValuesHolder.ofFloat("scaleX", this.nwQ.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.nwQ.getScaleY(), 0.766f));
            this.nwS.setDuration((500.0f * Math.abs(0.766f - this.nwQ.getScaleX())) / 0.3f);
        }
        this.nwO.setVisibility(0);
        this.nwO.setBackgroundResource(R.drawable.red_circle_bg);
        this.nwS.start();
    }
}
