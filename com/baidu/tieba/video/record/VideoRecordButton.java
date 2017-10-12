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
    private View gBQ;
    private View gBR;
    private View gBS;
    private TextView gBT;
    private AnimatorSet gBU;
    private AnimatorSet gBV;

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
        this.gBQ = findViewById(d.h.record_layer1);
        this.gBR = findViewById(d.h.record_layer2);
        this.gBS = findViewById(d.h.record_layer3);
        this.gBT = (TextView) findViewById(d.h.tv_tip);
    }

    public View getLayer1() {
        return this.gBQ;
    }

    public View getLayer2() {
        return this.gBR;
    }

    public TextView getTvTip() {
        return this.gBT;
    }

    public void bxI() {
        if (this.gBV != null && this.gBV.isRunning()) {
            this.gBV.cancel();
        }
        if (this.gBU == null) {
            this.gBU = new AnimatorSet();
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ObjectAnimator.ofFloat(this.gBQ, "scaleX", this.gBQ.getScaleX(), 1.05f), ObjectAnimator.ofFloat(this.gBQ, "scaleY", this.gBQ.getScaleY(), 1.05f), ObjectAnimator.ofFloat(this.gBR, "scaleX", this.gBR.getScaleX(), 1.05f), ObjectAnimator.ofFloat(this.gBR, "scaleY", this.gBR.getScaleY(), 1.05f));
            animatorSet.setDuration(300L);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.playTogether(ObjectAnimator.ofFloat(this.gBQ, "scaleX", 1.05f, 0.78f), ObjectAnimator.ofFloat(this.gBQ, "scaleY", 1.05f, 0.78f), ObjectAnimator.ofFloat(this.gBR, "scaleX", 1.05f, 0.78f), ObjectAnimator.ofFloat(this.gBR, "scaleY", 1.05f, 0.78f));
            animatorSet2.setDuration(800L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.gBS, PropertyValuesHolder.ofFloat("scaleX", 0.78f, 1.14f), PropertyValuesHolder.ofFloat("scaleY", 0.78f, 1.14f));
            ofPropertyValuesHolder.setRepeatCount(-1);
            ofPropertyValuesHolder.setRepeatMode(2);
            ofPropertyValuesHolder.setDuration(1000L);
            ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoRecordButton.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    VideoRecordButton.this.gBS.setVisibility(0);
                }
            });
            this.gBU.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoRecordButton.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    VideoRecordButton.this.gBS.setVisibility(8);
                }
            });
            this.gBU.playSequentially(animatorSet, animatorSet2, ofPropertyValuesHolder);
        }
        this.gBU.start();
        this.gBT.setVisibility(8);
    }

    public void bxJ() {
        if (this.gBU != null && this.gBU.isRunning()) {
            this.gBU.cancel();
        }
        this.gBS.setVisibility(8);
        if (this.gBV == null) {
            this.gBV = new AnimatorSet();
            this.gBV.playTogether(ObjectAnimator.ofFloat(this.gBR, "scaleX", 0.78f, 1.0f), ObjectAnimator.ofFloat(this.gBR, "scaleY", 0.78f, 1.0f), ObjectAnimator.ofFloat(this.gBQ, "scaleX", 0.78f, 1.0f), ObjectAnimator.ofFloat(this.gBQ, "scaleY", 0.78f, 1.0f));
            this.gBV.setDuration(400L);
            this.gBV.setInterpolator(new DecelerateInterpolator());
            this.gBV.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoRecordButton.3
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.gBP) {
                        VideoRecordButton.this.gBT.setVisibility(0);
                        VideoRecordButton.this.gBT.setText(VideoRecordButton.this.getResources().getText(d.l.video_record_button_press));
                    }
                }
            });
        }
        this.gBV.start();
    }
}
