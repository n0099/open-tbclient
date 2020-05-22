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
    private TextView Zs;
    private ObjectAnimator lJA;
    private View lJu;
    private View lJv;
    private View lJw;
    private ObjectAnimator lJx;
    private ObjectAnimator lJy;
    private ObjectAnimator lJz;

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
        this.lJu = findViewById(R.id.record_layer1);
        this.lJv = findViewById(R.id.record_layer2);
        this.lJw = findViewById(R.id.record_layer3);
        this.Zs = (TextView) findViewById(R.id.tv_tip);
        this.lJw.setScaleX(0.766f);
        this.lJw.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.lJw;
    }

    public View getLayer1() {
        return this.lJu;
    }

    public View getLayer2() {
        return this.lJv;
    }

    public TextView getTvTip() {
        return this.Zs;
    }

    public void dkV() {
        if (this.lJA != null && this.lJA.isRunning()) {
            this.lJz.cancel();
        }
        if (this.lJz == null) {
            this.lJz = ObjectAnimator.ofPropertyValuesHolder(this.lJv, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.lJz.setDuration(200L);
        }
        this.lJz.start();
    }

    public void dkW() {
        if (this.lJz != null && this.lJz.isRunning()) {
            this.lJz.cancel();
        }
        if (this.lJv.getScaleX() != 1.0f) {
            if (this.lJA == null) {
                this.lJA = ObjectAnimator.ofPropertyValuesHolder(this.lJv, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.lJA.setDuration(200L);
            }
            this.lJA.start();
        }
    }

    public void vc(boolean z) {
        if (this.lJy != null && this.lJy.isRunning()) {
            this.lJy.cancel();
        }
        if (this.lJx == null) {
            this.lJx = ObjectAnimator.ofPropertyValuesHolder(this.lJw, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.lJx.setRepeatCount(-1);
            this.lJx.setRepeatMode(2);
            this.lJx.setDuration(1000L);
        }
        this.lJw.setVisibility(0);
        if (z) {
            this.lJu.setVisibility(8);
        } else {
            this.lJu.setBackgroundResource(R.drawable.red_square_bg);
        }
        this.Zs.setVisibility(8);
        this.lJx.start();
    }

    public void dkK() {
        if (this.lJx != null && this.lJx.isRunning()) {
            this.lJx.cancel();
        }
        if (this.lJy == null) {
            this.lJy = ObjectAnimator.ofPropertyValuesHolder(this.lJw, PropertyValuesHolder.ofFloat("scaleX", this.lJw.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.lJw.getScaleY(), 0.766f));
            this.lJy.setDuration((500.0f * Math.abs(0.766f - this.lJw.getScaleX())) / 0.3f);
        }
        this.lJu.setVisibility(0);
        this.lJu.setBackgroundResource(R.drawable.red_circle_bg);
        this.lJy.start();
    }
}
