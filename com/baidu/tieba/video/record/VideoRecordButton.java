package com.baidu.tieba.video.record;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class VideoRecordButton extends FrameLayout {
    private TextView abj;
    private View npM;
    private View npN;
    private View npO;
    private ObjectAnimator npP;
    private ObjectAnimator npQ;
    private ObjectAnimator npR;
    private ObjectAnimator npS;

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
        this.npM = findViewById(R.id.record_layer1);
        this.npN = findViewById(R.id.record_layer2);
        this.npO = findViewById(R.id.record_layer3);
        this.abj = (TextView) findViewById(R.id.tv_tip);
        this.npO.setScaleX(0.766f);
        this.npO.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.npO;
    }

    public View getLayer1() {
        return this.npM;
    }

    public View getLayer2() {
        return this.npN;
    }

    public TextView getTvTip() {
        return this.abj;
    }

    public void dPc() {
        if (this.npS != null && this.npS.isRunning()) {
            this.npR.cancel();
        }
        if (this.npR == null) {
            this.npR = ObjectAnimator.ofPropertyValuesHolder(this.npN, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.npR.setDuration(200L);
        }
        this.npR.start();
    }

    public void dPd() {
        if (this.npR != null && this.npR.isRunning()) {
            this.npR.cancel();
        }
        if (this.npN.getScaleX() != 1.0f) {
            if (this.npS == null) {
                this.npS = ObjectAnimator.ofPropertyValuesHolder(this.npN, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.npS.setDuration(200L);
            }
            this.npS.start();
        }
    }

    public void xW(boolean z) {
        if (this.npQ != null && this.npQ.isRunning()) {
            this.npQ.cancel();
        }
        if (this.npP == null) {
            this.npP = ObjectAnimator.ofPropertyValuesHolder(this.npO, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.npP.setRepeatCount(-1);
            this.npP.setRepeatMode(2);
            this.npP.setDuration(1000L);
        }
        this.npO.setVisibility(0);
        if (z) {
            this.npM.setVisibility(8);
        } else {
            this.npM.setBackgroundResource(R.drawable.red_square_bg);
        }
        this.abj.setVisibility(8);
        this.npP.start();
    }

    public void dOR() {
        if (this.npP != null && this.npP.isRunning()) {
            this.npP.cancel();
        }
        if (this.npQ == null) {
            this.npQ = ObjectAnimator.ofPropertyValuesHolder(this.npO, PropertyValuesHolder.ofFloat("scaleX", this.npO.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.npO.getScaleY(), 0.766f));
            this.npQ.setDuration((500.0f * Math.abs(0.766f - this.npO.getScaleX())) / 0.3f);
        }
        this.npM.setVisibility(0);
        this.npM.setBackgroundResource(R.drawable.red_circle_bg);
        this.npQ.start();
    }
}
