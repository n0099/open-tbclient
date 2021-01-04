package com.baidu.tieba.write;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class f extends h {
    private Animation nXA;
    private Animation nXB;
    private a.C0872a nXz;

    public f(Context context, a.C0872a c0872a) {
        super(context, c0872a);
        this.nXz = c0872a;
        this.nXA = AnimationUtils.loadAnimation(this.mContext, R.anim.ubs_test_in_anim);
        this.nXB = AnimationUtils.loadAnimation(this.mContext, R.anim.ubs_test_out_anim);
        this.nXA.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.f.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                f.this.Up();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.nXB.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.f.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                f.this.Uq();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    @Override // com.baidu.tieba.write.h
    public void dXW() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.nXI != null) {
                this.nXI.Mt(this.mState);
            }
            clearAnimation();
            this.nXz.nVJ.startAnimation(this.nXA);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void aEu() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.nXI != null) {
                this.nXI.Mt(this.mState);
            }
            clearAnimation();
            this.nXz.nVJ.startAnimation(this.nXB);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dXX() {
        Uq();
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Up() {
        this.nXz.eqn.setClickable(true);
        this.mState = 2;
        if (this.nXI != null) {
            this.nXI.Mt(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uq() {
        this.nXz.eqn.setClickable(false);
        this.mState = 4;
        if (this.nXI != null) {
            this.nXI.Mt(this.mState);
        }
    }

    private void clearAnimation() {
        this.nXA.cancel();
        this.nXB.cancel();
        this.nXz.nVJ.clearAnimation();
    }
}
