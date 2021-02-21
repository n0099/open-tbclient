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
    private View nTO;
    private View nTP;
    private View nTQ;
    private ObjectAnimator nTR;
    private ObjectAnimator nTS;
    private ObjectAnimator nTT;
    private ObjectAnimator nTU;

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
        this.nTO = findViewById(R.id.record_layer1);
        this.nTP = findViewById(R.id.record_layer2);
        this.nTQ = findViewById(R.id.record_layer3);
        this.acQ = (TextView) findViewById(R.id.tv_tip);
        this.nTQ.setScaleX(0.766f);
        this.nTQ.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.nTQ;
    }

    public View getLayer1() {
        return this.nTO;
    }

    public View getLayer2() {
        return this.nTP;
    }

    public TextView getTvTip() {
        return this.acQ;
    }

    public void dVd() {
        if (this.nTU != null && this.nTU.isRunning()) {
            this.nTT.cancel();
        }
        if (this.nTT == null) {
            this.nTT = ObjectAnimator.ofPropertyValuesHolder(this.nTP, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.nTT.setDuration(200L);
        }
        this.nTT.start();
    }

    public void dVe() {
        if (this.nTT != null && this.nTT.isRunning()) {
            this.nTT.cancel();
        }
        if (this.nTP.getScaleX() != 1.0f) {
            if (this.nTU == null) {
                this.nTU = ObjectAnimator.ofPropertyValuesHolder(this.nTP, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.nTU.setDuration(200L);
            }
            this.nTU.start();
        }
    }

    public void zg(boolean z) {
        if (this.nTS != null && this.nTS.isRunning()) {
            this.nTS.cancel();
        }
        if (this.nTR == null) {
            this.nTR = ObjectAnimator.ofPropertyValuesHolder(this.nTQ, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.nTR.setRepeatCount(-1);
            this.nTR.setRepeatMode(2);
            this.nTR.setDuration(1000L);
        }
        this.nTQ.setVisibility(0);
        if (z) {
            this.nTO.setVisibility(8);
        } else {
            this.nTO.setBackgroundResource(R.drawable.red_square_bg);
        }
        this.acQ.setVisibility(8);
        this.nTR.start();
    }

    public void dUS() {
        if (this.nTR != null && this.nTR.isRunning()) {
            this.nTR.cancel();
        }
        if (this.nTS == null) {
            this.nTS = ObjectAnimator.ofPropertyValuesHolder(this.nTQ, PropertyValuesHolder.ofFloat("scaleX", this.nTQ.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.nTQ.getScaleY(), 0.766f));
            this.nTS.setDuration((500.0f * Math.abs(0.766f - this.nTQ.getScaleX())) / 0.3f);
        }
        this.nTO.setVisibility(0);
        this.nTO.setBackgroundResource(R.drawable.red_circle_bg);
        this.nTS.start();
    }
}
