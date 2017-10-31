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
    private View gLr;
    private View gLs;
    private View gLt;
    private TextView gLu;
    private AnimatorSet gLv;
    private AnimatorSet gLw;

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
        this.gLr = findViewById(d.g.record_layer1);
        this.gLs = findViewById(d.g.record_layer2);
        this.gLt = findViewById(d.g.record_layer3);
        this.gLu = (TextView) findViewById(d.g.tv_tip);
    }

    public View getLayer1() {
        return this.gLr;
    }

    public View getLayer2() {
        return this.gLs;
    }

    public TextView getTvTip() {
        return this.gLu;
    }

    public void bAS() {
        if (this.gLw != null && this.gLw.isRunning()) {
            this.gLw.cancel();
        }
        if (this.gLv == null) {
            this.gLv = new AnimatorSet();
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ObjectAnimator.ofFloat(this.gLr, "scaleX", this.gLr.getScaleX(), 1.05f), ObjectAnimator.ofFloat(this.gLr, "scaleY", this.gLr.getScaleY(), 1.05f), ObjectAnimator.ofFloat(this.gLs, "scaleX", this.gLs.getScaleX(), 1.05f), ObjectAnimator.ofFloat(this.gLs, "scaleY", this.gLs.getScaleY(), 1.05f));
            animatorSet.setDuration(300L);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.playTogether(ObjectAnimator.ofFloat(this.gLr, "scaleX", 1.05f, 0.78f), ObjectAnimator.ofFloat(this.gLr, "scaleY", 1.05f, 0.78f), ObjectAnimator.ofFloat(this.gLs, "scaleX", 1.05f, 0.78f), ObjectAnimator.ofFloat(this.gLs, "scaleY", 1.05f, 0.78f));
            animatorSet2.setDuration(800L);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.gLt, PropertyValuesHolder.ofFloat("scaleX", 0.78f, 1.14f), PropertyValuesHolder.ofFloat("scaleY", 0.78f, 1.14f));
            ofPropertyValuesHolder.setRepeatCount(-1);
            ofPropertyValuesHolder.setRepeatMode(2);
            ofPropertyValuesHolder.setDuration(1000L);
            ofPropertyValuesHolder.addListener(new n() { // from class: com.baidu.tieba.video.record.VideoRecordButton.1
                @Override // com.baidu.tieba.video.record.n, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    VideoRecordButton.this.gLt.setVisibility(0);
                }
            });
            this.gLv.addListener(new n() { // from class: com.baidu.tieba.video.record.VideoRecordButton.2
                @Override // com.baidu.tieba.video.record.n, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    VideoRecordButton.this.gLt.setVisibility(8);
                }
            });
            this.gLv.playSequentially(animatorSet, animatorSet2, ofPropertyValuesHolder);
        }
        this.gLv.start();
        this.gLu.setVisibility(8);
    }

    public void bAT() {
        if (this.gLv != null && this.gLv.isRunning()) {
            this.gLv.cancel();
        }
        this.gLt.setVisibility(8);
        if (this.gLw == null) {
            this.gLw = new AnimatorSet();
            this.gLw.playTogether(ObjectAnimator.ofFloat(this.gLs, "scaleX", 0.78f, 1.0f), ObjectAnimator.ofFloat(this.gLs, "scaleY", 0.78f, 1.0f), ObjectAnimator.ofFloat(this.gLr, "scaleX", 0.78f, 1.0f), ObjectAnimator.ofFloat(this.gLr, "scaleY", 0.78f, 1.0f));
            this.gLw.setDuration(400L);
            this.gLw.setInterpolator(new DecelerateInterpolator());
            this.gLw.addListener(new n() { // from class: com.baidu.tieba.video.record.VideoRecordButton.3
                @Override // com.baidu.tieba.video.record.n, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.gLq) {
                        VideoRecordButton.this.gLu.setVisibility(0);
                        VideoRecordButton.this.gLu.setText(VideoRecordButton.this.getResources().getText(d.j.video_record_button_press));
                    }
                }
            });
        }
        this.gLw.start();
    }
}
