package com.baidu.tieba.video.record;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class VideoRecordButton extends FrameLayout {
    private TextView Fp;
    private View kzM;
    private View kzN;
    private View kzO;
    private ObjectAnimator kzP;
    private ObjectAnimator kzQ;
    private ObjectAnimator kzR;
    private ObjectAnimator kzS;

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
        this.kzM = findViewById(R.id.record_layer1);
        this.kzN = findViewById(R.id.record_layer2);
        this.kzO = findViewById(R.id.record_layer3);
        this.Fp = (TextView) findViewById(R.id.tv_tip);
        this.kzO.setScaleX(0.766f);
        this.kzO.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.kzO;
    }

    public View getLayer1() {
        return this.kzM;
    }

    public View getLayer2() {
        return this.kzN;
    }

    public TextView getTvTip() {
        return this.Fp;
    }

    public void cPN() {
        if (this.kzS != null && this.kzS.isRunning()) {
            this.kzR.cancel();
        }
        if (this.kzR == null) {
            this.kzR = ObjectAnimator.ofPropertyValuesHolder(this.kzN, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.kzR.setDuration(200L);
        }
        this.kzR.start();
    }

    public void cPO() {
        if (this.kzR != null && this.kzR.isRunning()) {
            this.kzR.cancel();
        }
        if (this.kzN.getScaleX() != 1.0f) {
            if (this.kzS == null) {
                this.kzS = ObjectAnimator.ofPropertyValuesHolder(this.kzN, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.kzS.setDuration(200L);
            }
            this.kzS.start();
        }
    }

    public void tg(boolean z) {
        if (this.kzQ != null && this.kzQ.isRunning()) {
            this.kzQ.cancel();
        }
        if (this.kzP == null) {
            this.kzP = ObjectAnimator.ofPropertyValuesHolder(this.kzO, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.kzP.setRepeatCount(-1);
            this.kzP.setRepeatMode(2);
            this.kzP.setDuration(1000L);
        }
        this.kzO.setVisibility(0);
        if (z) {
            this.kzM.setVisibility(8);
        } else {
            this.kzM.setBackgroundResource(R.drawable.red_square_bg);
        }
        this.Fp.setVisibility(8);
        this.kzP.start();
    }

    public void cPC() {
        if (this.kzP != null && this.kzP.isRunning()) {
            this.kzP.cancel();
        }
        if (this.kzQ == null) {
            this.kzQ = ObjectAnimator.ofPropertyValuesHolder(this.kzO, PropertyValuesHolder.ofFloat("scaleX", this.kzO.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.kzO.getScaleY(), 0.766f));
            this.kzQ.setDuration((500.0f * Math.abs(0.766f - this.kzO.getScaleX())) / 0.3f);
        }
        this.kzM.setVisibility(0);
        this.kzM.setBackgroundResource(R.drawable.red_circle_bg);
        this.kzQ.start();
    }
}
