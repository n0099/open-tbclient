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
    private View nvH;
    private View nvI;
    private View nvJ;
    private ObjectAnimator nvK;
    private ObjectAnimator nvL;
    private ObjectAnimator nvM;
    private ObjectAnimator nvN;

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
        this.nvH = findViewById(R.id.record_layer1);
        this.nvI = findViewById(R.id.record_layer2);
        this.nvJ = findViewById(R.id.record_layer3);
        this.abj = (TextView) findViewById(R.id.tv_tip);
        this.nvJ.setScaleX(0.766f);
        this.nvJ.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.nvJ;
    }

    public View getLayer1() {
        return this.nvH;
    }

    public View getLayer2() {
        return this.nvI;
    }

    public TextView getTvTip() {
        return this.abj;
    }

    public void dRE() {
        if (this.nvN != null && this.nvN.isRunning()) {
            this.nvM.cancel();
        }
        if (this.nvM == null) {
            this.nvM = ObjectAnimator.ofPropertyValuesHolder(this.nvI, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.nvM.setDuration(200L);
        }
        this.nvM.start();
    }

    public void dRF() {
        if (this.nvM != null && this.nvM.isRunning()) {
            this.nvM.cancel();
        }
        if (this.nvI.getScaleX() != 1.0f) {
            if (this.nvN == null) {
                this.nvN = ObjectAnimator.ofPropertyValuesHolder(this.nvI, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.nvN.setDuration(200L);
            }
            this.nvN.start();
        }
    }

    public void yf(boolean z) {
        if (this.nvL != null && this.nvL.isRunning()) {
            this.nvL.cancel();
        }
        if (this.nvK == null) {
            this.nvK = ObjectAnimator.ofPropertyValuesHolder(this.nvJ, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.nvK.setRepeatCount(-1);
            this.nvK.setRepeatMode(2);
            this.nvK.setDuration(1000L);
        }
        this.nvJ.setVisibility(0);
        if (z) {
            this.nvH.setVisibility(8);
        } else {
            this.nvH.setBackgroundResource(R.drawable.red_square_bg);
        }
        this.abj.setVisibility(8);
        this.nvK.start();
    }

    public void dRt() {
        if (this.nvK != null && this.nvK.isRunning()) {
            this.nvK.cancel();
        }
        if (this.nvL == null) {
            this.nvL = ObjectAnimator.ofPropertyValuesHolder(this.nvJ, PropertyValuesHolder.ofFloat("scaleX", this.nvJ.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.nvJ.getScaleY(), 0.766f));
            this.nvL.setDuration((500.0f * Math.abs(0.766f - this.nvJ.getScaleX())) / 0.3f);
        }
        this.nvH.setVisibility(0);
        this.nvH.setBackgroundResource(R.drawable.red_circle_bg);
        this.nvL.start();
    }
}
