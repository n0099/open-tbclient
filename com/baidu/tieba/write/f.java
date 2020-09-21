package com.baidu.tieba.write;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class f extends h {
    private a.C0823a mWB;
    private Animation mWC;
    private Animation mWD;

    public f(Context context, a.C0823a c0823a) {
        super(context, c0823a);
        this.mWB = c0823a;
        this.mWC = AnimationUtils.loadAnimation(this.mContext, R.anim.ubs_test_in_anim);
        this.mWD = AnimationUtils.loadAnimation(this.mContext, R.anim.ubs_test_out_anim);
        this.mWC.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.f.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                f.this.dJC();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mWD.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.f.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                f.this.dJE();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    @Override // com.baidu.tieba.write.h
    public void dJF() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.mWK != null) {
                this.mWK.Ka(this.mState);
            }
            clearAnimation();
            this.mWB.mUT.startAnimation(this.mWC);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void atw() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.mWK != null) {
                this.mWK.Ka(this.mState);
            }
            clearAnimation();
            this.mWB.mUT.startAnimation(this.mWD);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dJG() {
        dJE();
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJC() {
        this.mWB.dBD.setClickable(true);
        this.mState = 2;
        if (this.mWK != null) {
            this.mWK.Ka(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJE() {
        this.mWB.dBD.setClickable(false);
        this.mState = 4;
        if (this.mWK != null) {
            this.mWK.Ka(this.mState);
        }
    }

    private void clearAnimation() {
        this.mWC.cancel();
        this.mWD.cancel();
        this.mWB.mUT.clearAnimation();
    }
}
