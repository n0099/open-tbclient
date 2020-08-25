package com.baidu.tieba.video.record;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class VideoRecordButton extends FrameLayout {
    private TextView aax;
    private View mDB;
    private View mDC;
    private View mDD;
    private ObjectAnimator mDE;
    private ObjectAnimator mDF;
    private ObjectAnimator mDG;
    private ObjectAnimator mDH;

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
        this.mDB = findViewById(R.id.record_layer1);
        this.mDC = findViewById(R.id.record_layer2);
        this.mDD = findViewById(R.id.record_layer3);
        this.aax = (TextView) findViewById(R.id.tv_tip);
        this.mDD.setScaleX(0.766f);
        this.mDD.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.mDD;
    }

    public View getLayer1() {
        return this.mDB;
    }

    public View getLayer2() {
        return this.mDC;
    }

    public TextView getTvTip() {
        return this.aax;
    }

    public void dEf() {
        if (this.mDH != null && this.mDH.isRunning()) {
            this.mDG.cancel();
        }
        if (this.mDG == null) {
            this.mDG = ObjectAnimator.ofPropertyValuesHolder(this.mDC, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.mDG.setDuration(200L);
        }
        this.mDG.start();
    }

    public void dEg() {
        if (this.mDG != null && this.mDG.isRunning()) {
            this.mDG.cancel();
        }
        if (this.mDC.getScaleX() != 1.0f) {
            if (this.mDH == null) {
                this.mDH = ObjectAnimator.ofPropertyValuesHolder(this.mDC, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.mDH.setDuration(200L);
            }
            this.mDH.start();
        }
    }

    public void wN(boolean z) {
        if (this.mDF != null && this.mDF.isRunning()) {
            this.mDF.cancel();
        }
        if (this.mDE == null) {
            this.mDE = ObjectAnimator.ofPropertyValuesHolder(this.mDD, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.mDE.setRepeatCount(-1);
            this.mDE.setRepeatMode(2);
            this.mDE.setDuration(1000L);
        }
        this.mDD.setVisibility(0);
        if (z) {
            this.mDB.setVisibility(8);
        } else {
            this.mDB.setBackgroundResource(R.drawable.red_square_bg);
        }
        this.aax.setVisibility(8);
        this.mDE.start();
    }

    public void dDU() {
        if (this.mDE != null && this.mDE.isRunning()) {
            this.mDE.cancel();
        }
        if (this.mDF == null) {
            this.mDF = ObjectAnimator.ofPropertyValuesHolder(this.mDD, PropertyValuesHolder.ofFloat("scaleX", this.mDD.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.mDD.getScaleY(), 0.766f));
            this.mDF.setDuration((500.0f * Math.abs(0.766f - this.mDD.getScaleX())) / 0.3f);
        }
        this.mDB.setVisibility(0);
        this.mDB.setBackgroundResource(R.drawable.red_circle_bg);
        this.mDF.start();
    }
}
