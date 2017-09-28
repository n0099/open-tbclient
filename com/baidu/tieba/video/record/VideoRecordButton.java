package com.baidu.tieba.video.record;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class VideoRecordButton extends FrameLayout {
    private View gBR;
    private View gBS;
    private View gBT;
    private TextView gBU;
    private AnimatorSet gBV;
    private AnimatorSet gBW;

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
        inflate(getContext(), d.j.layout_record_button, this);
        this.gBR = findViewById(d.h.record_layer1);
        this.gBS = findViewById(d.h.record_layer2);
        this.gBT = findViewById(d.h.record_layer3);
        this.gBU = (TextView) findViewById(d.h.tv_tip);
    }

    public View getLayer1() {
        return this.gBR;
    }

    public View getLayer2() {
        return this.gBS;
    }

    public TextView getTvTip() {
        return this.gBU;
    }

    public void bxJ() {
        if (this.gBW != null && this.gBW.isRunning()) {
            this.gBW.cancel();
        }
        if (this.gBV == null) {
            this.gBV = new AnimatorSet();
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ObjectAnimator.ofFloat(this.gBR, "scaleX", this.gBR.getScaleX(), 1.05f), ObjectAnimator.ofFloat(this.gBR, "scaleY", this.gBR.getScaleY(), 1.05f), ObjectAnimator.ofFloat(this.gBS, "scaleX", this.gBS.getScaleX(), 1.05f), ObjectAnimator.ofFloat(this.gBS, "scaleY", this.gBS.getScaleY(), 1.05f));
            animatorSet.setDuration(300L);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.playTogether(ObjectAnimator.ofFloat(this.gBR, "scaleX", 1.05f, 0.78f), ObjectAnimator.ofFloat(this.gBR, "scaleY", 1.05f, 0.78f), ObjectAnimator.ofFloat(this.gBS, "scaleX", 1.05f, 0.78f), ObjectAnimator.ofFloat(this.gBS, "scaleY", 1.05f, 0.78f));
            animatorSet2.setDuration(800L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.gBT, PropertyValuesHolder.ofFloat("scaleX", 0.78f, 1.14f), PropertyValuesHolder.ofFloat("scaleY", 0.78f, 1.14f));
            ofPropertyValuesHolder.setRepeatCount(-1);
            ofPropertyValuesHolder.setRepeatMode(2);
            ofPropertyValuesHolder.setDuration(1000L);
            ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoRecordButton.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    VideoRecordButton.this.gBT.setVisibility(0);
                }
            });
            this.gBV.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoRecordButton.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    VideoRecordButton.this.gBT.setVisibility(8);
                }
            });
            this.gBV.playSequentially(animatorSet, animatorSet2, ofPropertyValuesHolder);
        }
        this.gBV.start();
        this.gBU.setVisibility(8);
    }

    public void bxK() {
        if (this.gBV != null && this.gBV.isRunning()) {
            this.gBV.cancel();
        }
        this.gBT.setVisibility(8);
        if (this.gBW == null) {
            this.gBW = new AnimatorSet();
            this.gBW.playTogether(ObjectAnimator.ofFloat(this.gBS, "scaleX", 0.78f, 1.0f), ObjectAnimator.ofFloat(this.gBS, "scaleY", 0.78f, 1.0f), ObjectAnimator.ofFloat(this.gBR, "scaleX", 0.78f, 1.0f), ObjectAnimator.ofFloat(this.gBR, "scaleY", 0.78f, 1.0f));
            this.gBW.setDuration(400L);
            this.gBW.setInterpolator(new DecelerateInterpolator());
            this.gBW.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoRecordButton.3
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.gBQ) {
                        VideoRecordButton.this.gBU.setVisibility(0);
                        VideoRecordButton.this.gBU.setText(VideoRecordButton.this.getResources().getText(d.l.video_record_button_press));
                    }
                }
            });
        }
        this.gBW.start();
    }
}
