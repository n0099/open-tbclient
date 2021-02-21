package com.baidu.tieba.write;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class f extends h {
    private a.C0898a odA;
    private Animation odB;
    private Animation odC;

    public f(Context context, a.C0898a c0898a) {
        super(context, c0898a);
        this.odA = c0898a;
        this.odB = AnimationUtils.loadAnimation(this.mContext, R.anim.ubs_test_in_anim);
        this.odC = AnimationUtils.loadAnimation(this.mContext, R.anim.ubs_test_out_anim);
        this.odB.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.f.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                f.this.Se();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.odC.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.f.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                f.this.Sf();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    @Override // com.baidu.tieba.write.h
    public void dWB() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.odJ != null) {
                this.odJ.Li(this.mState);
            }
            clearAnimation();
            this.odA.obJ.startAnimation(this.odB);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void aAZ() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.odJ != null) {
                this.odJ.Li(this.mState);
            }
            clearAnimation();
            this.odA.obJ.startAnimation(this.odC);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dWC() {
        Sf();
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Se() {
        this.odA.enH.setClickable(true);
        this.mState = 2;
        if (this.odJ != null) {
            this.odJ.Li(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sf() {
        this.odA.enH.setClickable(false);
        this.mState = 4;
        if (this.odJ != null) {
            this.odJ.Li(this.mState);
        }
    }

    private void clearAnimation() {
        this.odB.cancel();
        this.odC.cancel();
        this.odA.obJ.clearAnimation();
    }
}
