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
    private View gMA;
    private View gMB;
    private TextView gMC;
    private AnimatorSet gMD;
    private AnimatorSet gME;
    private View gMz;

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
        inflate(getContext(), d.h.layout_record_button, this);
        this.gMz = findViewById(d.g.record_layer1);
        this.gMA = findViewById(d.g.record_layer2);
        this.gMB = findViewById(d.g.record_layer3);
        this.gMC = (TextView) findViewById(d.g.tv_tip);
    }

    public View getLayer1() {
        return this.gMz;
    }

    public View getLayer2() {
        return this.gMA;
    }

    public TextView getTvTip() {
        return this.gMC;
    }

    public void bBe() {
        if (this.gME != null && this.gME.isRunning()) {
            this.gME.cancel();
        }
        if (this.gMD == null) {
            this.gMD = new AnimatorSet();
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ObjectAnimator.ofFloat(this.gMz, "scaleX", this.gMz.getScaleX(), 1.05f), ObjectAnimator.ofFloat(this.gMz, "scaleY", this.gMz.getScaleY(), 1.05f), ObjectAnimator.ofFloat(this.gMA, "scaleX", this.gMA.getScaleX(), 1.05f), ObjectAnimator.ofFloat(this.gMA, "scaleY", this.gMA.getScaleY(), 1.05f));
            animatorSet.setDuration(300L);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.playTogether(ObjectAnimator.ofFloat(this.gMz, "scaleX", 1.05f, 0.78f), ObjectAnimator.ofFloat(this.gMz, "scaleY", 1.05f, 0.78f), ObjectAnimator.ofFloat(this.gMA, "scaleX", 1.05f, 0.78f), ObjectAnimator.ofFloat(this.gMA, "scaleY", 1.05f, 0.78f));
            animatorSet2.setDuration(800L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.gMB, PropertyValuesHolder.ofFloat("scaleX", 0.78f, 1.14f), PropertyValuesHolder.ofFloat("scaleY", 0.78f, 1.14f));
            ofPropertyValuesHolder.setRepeatCount(-1);
            ofPropertyValuesHolder.setRepeatMode(2);
            ofPropertyValuesHolder.setDuration(1000L);
            ofPropertyValuesHolder.addListener(new n() { // from class: com.baidu.tieba.video.record.VideoRecordButton.1
                @Override // com.baidu.tieba.video.record.n, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    VideoRecordButton.this.gMB.setVisibility(0);
                }
            });
            this.gMD.addListener(new n() { // from class: com.baidu.tieba.video.record.VideoRecordButton.2
                @Override // com.baidu.tieba.video.record.n, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    VideoRecordButton.this.gMB.setVisibility(8);
                }
            });
            this.gMD.playSequentially(animatorSet, animatorSet2, ofPropertyValuesHolder);
        }
        this.gMD.start();
        this.gMC.setVisibility(8);
    }

    public void bBf() {
        if (this.gMD != null && this.gMD.isRunning()) {
            this.gMD.cancel();
        }
        this.gMB.setVisibility(8);
        if (this.gME == null) {
            this.gME = new AnimatorSet();
            this.gME.playTogether(ObjectAnimator.ofFloat(this.gMA, "scaleX", 0.78f, 1.0f), ObjectAnimator.ofFloat(this.gMA, "scaleY", 0.78f, 1.0f), ObjectAnimator.ofFloat(this.gMz, "scaleX", 0.78f, 1.0f), ObjectAnimator.ofFloat(this.gMz, "scaleY", 0.78f, 1.0f));
            this.gME.setDuration(400L);
            this.gME.setInterpolator(new DecelerateInterpolator());
            this.gME.addListener(new n() { // from class: com.baidu.tieba.video.record.VideoRecordButton.3
                @Override // com.baidu.tieba.video.record.n, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.gMy) {
                        VideoRecordButton.this.gMC.setVisibility(0);
                        VideoRecordButton.this.gMC.setText(VideoRecordButton.this.getResources().getText(d.j.video_record_button_press));
                    }
                }
            });
        }
        this.gME.start();
    }
}
