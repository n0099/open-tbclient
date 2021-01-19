package com.baidu.tieba.write;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class f extends h {
    private a.C0893a nSU;
    private Animation nSV;
    private Animation nSW;

    public f(Context context, a.C0893a c0893a) {
        super(context, c0893a);
        this.nSU = c0893a;
        this.nSV = AnimationUtils.loadAnimation(this.mContext, R.anim.ubs_test_in_anim);
        this.nSW = AnimationUtils.loadAnimation(this.mContext, R.anim.ubs_test_out_anim);
        this.nSV.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.f.1
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
        this.nSW.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.f.2
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
            if (this.nTd != null) {
                this.nTd.KM(this.mState);
            }
            clearAnimation();
            this.nSU.nRe.startAnimation(this.nSV);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void aAB() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.nTd != null) {
                this.nTd.KM(this.mState);
            }
            clearAnimation();
            this.nSU.nRe.startAnimation(this.nSW);
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
        this.nSU.ely.setClickable(true);
        this.mState = 2;
        if (this.nTd != null) {
            this.nTd.KM(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qv() {
        this.nSU.ely.setClickable(false);
        this.mState = 4;
        if (this.nTd != null) {
            this.nTd.KM(this.mState);
        }
    }

    private void clearAnimation() {
        this.nSV.cancel();
        this.nSW.cancel();
        this.nSU.nRe.clearAnimation();
    }
}
