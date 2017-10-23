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
    private View gBB;
    private View gBC;
    private View gBD;
    private TextView gBE;
    private AnimatorSet gBF;
    private AnimatorSet gBG;

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
        this.gBB = findViewById(d.h.record_layer1);
        this.gBC = findViewById(d.h.record_layer2);
        this.gBD = findViewById(d.h.record_layer3);
        this.gBE = (TextView) findViewById(d.h.tv_tip);
    }

    public View getLayer1() {
        return this.gBB;
    }

    public View getLayer2() {
        return this.gBC;
    }

    public TextView getTvTip() {
        return this.gBE;
    }

    public void bxA() {
        if (this.gBG != null && this.gBG.isRunning()) {
            this.gBG.cancel();
        }
        if (this.gBF == null) {
            this.gBF = new AnimatorSet();
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ObjectAnimator.ofFloat(this.gBB, "scaleX", this.gBB.getScaleX(), 1.05f), ObjectAnimator.ofFloat(this.gBB, "scaleY", this.gBB.getScaleY(), 1.05f), ObjectAnimator.ofFloat(this.gBC, "scaleX", this.gBC.getScaleX(), 1.05f), ObjectAnimator.ofFloat(this.gBC, "scaleY", this.gBC.getScaleY(), 1.05f));
            animatorSet.setDuration(300L);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.playTogether(ObjectAnimator.ofFloat(this.gBB, "scaleX", 1.05f, 0.78f), ObjectAnimator.ofFloat(this.gBB, "scaleY", 1.05f, 0.78f), ObjectAnimator.ofFloat(this.gBC, "scaleX", 1.05f, 0.78f), ObjectAnimator.ofFloat(this.gBC, "scaleY", 1.05f, 0.78f));
            animatorSet2.setDuration(800L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.gBD, PropertyValuesHolder.ofFloat("scaleX", 0.78f, 1.14f), PropertyValuesHolder.ofFloat("scaleY", 0.78f, 1.14f));
            ofPropertyValuesHolder.setRepeatCount(-1);
            ofPropertyValuesHolder.setRepeatMode(2);
            ofPropertyValuesHolder.setDuration(1000L);
            ofPropertyValuesHolder.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoRecordButton.1
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    VideoRecordButton.this.gBD.setVisibility(0);
                }
            });
            this.gBF.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoRecordButton.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    VideoRecordButton.this.gBD.setVisibility(8);
                }
            });
            this.gBF.playSequentially(animatorSet, animatorSet2, ofPropertyValuesHolder);
        }
        this.gBF.start();
        this.gBE.setVisibility(8);
    }

    public void bxB() {
        if (this.gBF != null && this.gBF.isRunning()) {
            this.gBF.cancel();
        }
        this.gBD.setVisibility(8);
        if (this.gBG == null) {
            this.gBG = new AnimatorSet();
            this.gBG.playTogether(ObjectAnimator.ofFloat(this.gBC, "scaleX", 0.78f, 1.0f), ObjectAnimator.ofFloat(this.gBC, "scaleY", 0.78f, 1.0f), ObjectAnimator.ofFloat(this.gBB, "scaleX", 0.78f, 1.0f), ObjectAnimator.ofFloat(this.gBB, "scaleY", 0.78f, 1.0f));
            this.gBG.setDuration(400L);
            this.gBG.setInterpolator(new DecelerateInterpolator());
            this.gBG.addListener(new m() { // from class: com.baidu.tieba.video.record.VideoRecordButton.3
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.gBA) {
                        VideoRecordButton.this.gBE.setVisibility(0);
                        VideoRecordButton.this.gBE.setText(VideoRecordButton.this.getResources().getText(d.l.video_record_button_press));
                    }
                }
            });
        }
        this.gBG.start();
    }
}
