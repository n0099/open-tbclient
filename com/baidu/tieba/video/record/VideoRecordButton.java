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
    private TextView abi;
    private View ndk;
    private View ndl;
    private View ndm;
    private ObjectAnimator ndn;
    private ObjectAnimator ndo;
    private ObjectAnimator ndp;
    private ObjectAnimator ndq;

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
        this.ndk = findViewById(R.id.record_layer1);
        this.ndl = findViewById(R.id.record_layer2);
        this.ndm = findViewById(R.id.record_layer3);
        this.abi = (TextView) findViewById(R.id.tv_tip);
        this.ndm.setScaleX(0.766f);
        this.ndm.setScaleY(0.766f);
    }

    public View getLayer3() {
        return this.ndm;
    }

    public View getLayer1() {
        return this.ndk;
    }

    public View getLayer2() {
        return this.ndl;
    }

    public TextView getTvTip() {
        return this.abi;
    }

    public void dLU() {
        if (this.ndq != null && this.ndq.isRunning()) {
            this.ndp.cancel();
        }
        if (this.ndp == null) {
            this.ndp = ObjectAnimator.ofPropertyValuesHolder(this.ndl, PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.9f), PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.9f));
            this.ndp.setDuration(200L);
        }
        this.ndp.start();
    }

    public void dLV() {
        if (this.ndp != null && this.ndp.isRunning()) {
            this.ndp.cancel();
        }
        if (this.ndl.getScaleX() != 1.0f) {
            if (this.ndq == null) {
                this.ndq = ObjectAnimator.ofPropertyValuesHolder(this.ndl, PropertyValuesHolder.ofFloat("scaleX", 0.9f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.9f, 1.0f));
                this.ndq.setDuration(200L);
            }
            this.ndq.start();
        }
    }

    public void xF(boolean z) {
        if (this.ndo != null && this.ndo.isRunning()) {
            this.ndo.cancel();
        }
        if (this.ndn == null) {
            this.ndn = ObjectAnimator.ofPropertyValuesHolder(this.ndm, PropertyValuesHolder.ofFloat("scaleX", 0.766f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.766f, 1.0f));
            this.ndn.setRepeatCount(-1);
            this.ndn.setRepeatMode(2);
            this.ndn.setDuration(1000L);
        }
        this.ndm.setVisibility(0);
        if (z) {
            this.ndk.setVisibility(8);
        } else {
            this.ndk.setBackgroundResource(R.drawable.red_square_bg);
        }
        this.abi.setVisibility(8);
        this.ndn.start();
    }

    public void dLJ() {
        if (this.ndn != null && this.ndn.isRunning()) {
            this.ndn.cancel();
        }
        if (this.ndo == null) {
            this.ndo = ObjectAnimator.ofPropertyValuesHolder(this.ndm, PropertyValuesHolder.ofFloat("scaleX", this.ndm.getScaleX(), 0.766f), PropertyValuesHolder.ofFloat("scaleY", this.ndm.getScaleY(), 0.766f));
            this.ndo.setDuration((500.0f * Math.abs(0.766f - this.ndm.getScaleX())) / 0.3f);
        }
        this.ndk.setVisibility(0);
        this.ndk.setBackgroundResource(R.drawable.red_circle_bg);
        this.ndo.start();
    }
}
