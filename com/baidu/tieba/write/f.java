package com.baidu.tieba.write;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class f extends h {
    private a.C0874a nFW;
    private Animation nFX;
    private Animation nFY;

    public f(Context context, a.C0874a c0874a) {
        super(context, c0874a);
        this.nFW = c0874a;
        this.nFX = AnimationUtils.loadAnimation(this.mContext, R.anim.ubs_test_in_anim);
        this.nFY = AnimationUtils.loadAnimation(this.mContext, R.anim.ubs_test_out_anim);
        this.nFX.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.f.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                f.this.QM();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.nFY.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.f.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                f.this.QN();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    @Override // com.baidu.tieba.write.h
    public void dSY() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.nGf != null) {
                this.nGf.LO(this.mState);
            }
            clearAnimation();
            this.nFW.nEk.startAnimation(this.nFX);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void azT() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.nGf != null) {
                this.nGf.LO(this.mState);
            }
            clearAnimation();
            this.nFW.nEk.startAnimation(this.nFY);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dSZ() {
        QN();
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QM() {
        this.nFW.eal.setClickable(true);
        this.mState = 2;
        if (this.nGf != null) {
            this.nGf.LO(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QN() {
        this.nFW.eal.setClickable(false);
        this.mState = 4;
        if (this.nGf != null) {
            this.nGf.LO(this.mState);
        }
    }

    private void clearAnimation() {
        this.nFX.cancel();
        this.nFY.cancel();
        this.nFW.nEk.clearAnimation();
    }
}
