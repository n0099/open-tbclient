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
    private View kGj;
    private View kGk;
    private View kGl;
    private ObjectAnimator kGm;
    private ObjectAnimator kGn;
    private ObjectAnimator kGo;
    private ObjectAnimator kGp;

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
        this.kGj = findViewById(R.id.record_layer1);
        this.kGk = findViewById(R.id.record_layer2);
        this.kGl = findViewById(R.id.record_layer3);
        this.FN = (TextView) findViewById(R.id.tv_tip);
        this.kGl.setScaleX(0.766f);
        this.kGl.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.kGl;
    }

    public View getLayer1() {
        return this.kGj;
    }

    public View getLayer2() {
        return this.kGk;
    }

    public TextView getTvTip() {
        return this.FN;
    }

    public void cSI() {
        if (this.kGp != null && this.kGp.isRunning()) {
            this.kGo.cancel();
        }
        if (this.kGo == null) {
            this.kGo = ObjectAnimator.ofPropertyValuesHolder(this.kGk, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.kGo.setDuration(200L);
        }
        this.kGo.start();
    }

    public void cSJ() {
        if (this.kGo != null && this.kGo.isRunning()) {
            this.kGo.cancel();
        }
        if (this.kGk.getScaleX() != 1.0f) {
            if (this.kGp == null) {
                this.kGp = ObjectAnimator.ofPropertyValuesHolder(this.kGk, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.kGp.setDuration(200L);
            }
            this.kGp.start();
        }
    }

    public void tC(boolean z) {
        if (this.kGn != null && this.kGn.isRunning()) {
            this.kGn.cancel();
        }
        if (this.kGm == null) {
            this.kGm = ObjectAnimator.ofPropertyValuesHolder(this.kGl, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.kGm.setRepeatCount(-1);
            this.kGm.setRepeatMode(2);
            this.kGm.setDuration(1000L);
        }
        this.kGl.setVisibility(0);
        if (z) {
            this.kGj.setVisibility(8);
        } else {
            this.kGj.setBackgroundResource(R.drawable.red_square_bg);
        }
        this.FN.setVisibility(8);
        this.kGm.start();
    }

    public void cSx() {
        if (this.kGm != null && this.kGm.isRunning()) {
            this.kGm.cancel();
        }
        if (this.kGn == null) {
            this.kGn = ObjectAnimator.ofPropertyValuesHolder(this.kGl, PropertyValuesHolder.ofFloat("scaleX", this.kGl.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.kGl.getScaleY(), 0.766f));
            this.kGn.setDuration((500.0f * Math.abs(0.766f - this.kGl.getScaleX())) / 0.3f);
        }
        this.kGj.setVisibility(0);
        this.kGj.setBackgroundResource(R.drawable.red_circle_bg);
        this.kGn.start();
    }
}
