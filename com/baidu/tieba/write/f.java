package com.baidu.tieba.write;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class f extends h {
    private Animation nXA;
    private a.C0910a nXy;
    private Animation nXz;

    public f(Context context, a.C0910a c0910a) {
        super(context, c0910a);
        this.nXy = c0910a;
        this.nXz = AnimationUtils.loadAnimation(this.mContext, R.anim.ubs_test_in_anim);
        this.nXA = AnimationUtils.loadAnimation(this.mContext, R.anim.ubs_test_out_anim);
        this.nXz.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.f.1
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
        this.nXA.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.f.2
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
    public void dXX() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.nXH != null) {
                this.nXH.Mt(this.mState);
            }
            clearAnimation();
            this.nXy.nVI.startAnimation(this.nXz);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void aEv() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.nXH != null) {
                this.nXH.Mt(this.mState);
            }
            clearAnimation();
            this.nXy.nVI.startAnimation(this.nXA);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dXY() {
        Uq();
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Up() {
        this.nXy.eqn.setClickable(true);
        this.mState = 2;
        if (this.nXH != null) {
            this.nXH.Mt(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uq() {
        this.nXy.eqn.setClickable(false);
        this.mState = 4;
        if (this.nXH != null) {
            this.nXH.Mt(this.mState);
        }
    }

    private void clearAnimation() {
        this.nXz.cancel();
        this.nXA.cancel();
        this.nXy.nVI.clearAnimation();
    }
}
