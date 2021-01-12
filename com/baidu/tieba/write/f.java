package com.baidu.tieba.write;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class f extends h {
    private a.C0893a nST;
    private Animation nSU;
    private Animation nSV;

    public f(Context context, a.C0893a c0893a) {
        super(context, c0893a);
        this.nST = c0893a;
        this.nSU = AnimationUtils.loadAnimation(this.mContext, R.anim.ubs_test_in_anim);
        this.nSV = AnimationUtils.loadAnimation(this.mContext, R.anim.ubs_test_out_anim);
        this.nSU.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.f.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                f.this.Qu();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.nSV.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.f.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                f.this.Qv();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    @Override // com.baidu.tieba.write.h
    public void dUf() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.nTc != null) {
                this.nTc.KM(this.mState);
            }
            clearAnimation();
            this.nST.nRd.startAnimation(this.nSU);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void aAB() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.nTc != null) {
                this.nTc.KM(this.mState);
            }
            clearAnimation();
            this.nST.nRd.startAnimation(this.nSV);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dUg() {
        Qv();
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qu() {
        this.nST.ely.setClickable(true);
        this.mState = 2;
        if (this.nTc != null) {
            this.nTc.KM(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qv() {
        this.nST.ely.setClickable(false);
        this.mState = 4;
        if (this.nTc != null) {
            this.nTc.KM(this.mState);
        }
    }

    private void clearAnimation() {
        this.nSU.cancel();
        this.nSV.cancel();
        this.nST.nRd.clearAnimation();
    }
}
