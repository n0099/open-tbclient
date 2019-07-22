package com.baidu.tieba.video.record;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class VideoRecordButton extends FrameLayout {
    private TextView TT;
    private View jDB;
    private View jDC;
    private View jDD;
    private ObjectAnimator jDE;
    private ObjectAnimator jDF;
    private ObjectAnimator jDG;
    private ObjectAnimator jDH;

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
        this.jDB = findViewById(R.id.record_layer1);
        this.jDC = findViewById(R.id.record_layer2);
        this.jDD = findViewById(R.id.record_layer3);
        this.TT = (TextView) findViewById(R.id.tv_tip);
        this.jDD.setScaleX(0.766f);
        this.jDD.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.jDD;
    }

    public View getLayer1() {
        return this.jDB;
    }

    public View getLayer2() {
        return this.jDC;
    }

    public TextView getTvTip() {
        return this.TT;
    }

    public void cwY() {
        if (this.jDH != null && this.jDH.isRunning()) {
            this.jDG.cancel();
        }
        if (this.jDG == null) {
            this.jDG = ObjectAnimator.ofPropertyValuesHolder(this.jDC, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.jDG.setDuration(200L);
        }
        this.jDG.start();
    }

    public void cwZ() {
        if (this.jDG != null && this.jDG.isRunning()) {
            this.jDG.cancel();
        }
        if (this.jDC.getScaleX() != 1.0f) {
            if (this.jDH == null) {
                this.jDH = ObjectAnimator.ofPropertyValuesHolder(this.jDC, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.jDH.setDuration(200L);
            }
            this.jDH.start();
        }
    }

    public void rN(boolean z) {
        if (this.jDF != null && this.jDF.isRunning()) {
            this.jDF.cancel();
        }
        if (this.jDE == null) {
            this.jDE = ObjectAnimator.ofPropertyValuesHolder(this.jDD, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.jDE.setRepeatCount(-1);
            this.jDE.setRepeatMode(2);
            this.jDE.setDuration(1000L);
        }
        this.jDD.setVisibility(0);
        if (z) {
            this.jDB.setVisibility(8);
        } else {
            this.jDB.setBackgroundResource(R.drawable.red_square_bg);
        }
        this.TT.setVisibility(8);
        this.jDE.start();
    }

    public void cwN() {
        if (this.jDE != null && this.jDE.isRunning()) {
            this.jDE.cancel();
        }
        if (this.jDF == null) {
            this.jDF = ObjectAnimator.ofPropertyValuesHolder(this.jDD, PropertyValuesHolder.ofFloat("scaleX", this.jDD.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.jDD.getScaleY(), 0.766f));
            this.jDF.setDuration((500.0f * Math.abs(0.766f - this.jDD.getScaleX())) / 0.3f);
        }
        this.jDB.setVisibility(0);
        this.jDB.setBackgroundResource(R.drawable.red_circle_bg);
        this.jDF.start();
    }
}
