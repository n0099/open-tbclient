package com.baidu.tieba.write;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class f extends h {
    private a.C0890a nUe;
    private Animation nUf;
    private Animation nUg;

    public f(Context context, a.C0890a c0890a) {
        super(context, c0890a);
        this.nUe = c0890a;
        this.nUf = AnimationUtils.loadAnimation(this.mContext, R.anim.ubs_test_in_anim);
        this.nUg = AnimationUtils.loadAnimation(this.mContext, R.anim.ubs_test_out_anim);
        this.nUf.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.f.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                f.this.Tk();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.nUg.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.f.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                f.this.Tl();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    @Override // com.baidu.tieba.write.h
    public void dYt() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.nUn != null) {
                this.nUn.MG(this.mState);
            }
            clearAnimation();
            this.nUe.nSo.startAnimation(this.nUf);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void aDc() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.nUn != null) {
                this.nUn.MG(this.mState);
            }
            clearAnimation();
            this.nUe.nSo.startAnimation(this.nUg);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dYu() {
        Tl();
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tk() {
        this.nUe.ehl.setClickable(true);
        this.mState = 2;
        if (this.nUn != null) {
            this.nUn.MG(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tl() {
        this.nUe.ehl.setClickable(false);
        this.mState = 4;
        if (this.nUn != null) {
            this.nUn.MG(this.mState);
        }
    }

    private void clearAnimation() {
        this.nUf.cancel();
        this.nUg.cancel();
        this.nUe.nSo.clearAnimation();
    }
}
