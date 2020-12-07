package com.baidu.tieba.write;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class f extends h {
    private a.C0890a nUc;
    private Animation nUd;
    private Animation nUe;

    public f(Context context, a.C0890a c0890a) {
        super(context, c0890a);
        this.nUc = c0890a;
        this.nUd = AnimationUtils.loadAnimation(this.mContext, R.anim.ubs_test_in_anim);
        this.nUe = AnimationUtils.loadAnimation(this.mContext, R.anim.ubs_test_out_anim);
        this.nUd.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.f.1
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
        this.nUe.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.f.2
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
    public void dYs() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.nUl != null) {
                this.nUl.MG(this.mState);
            }
            clearAnimation();
            this.nUc.nSm.startAnimation(this.nUd);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void aDc() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.nUl != null) {
                this.nUl.MG(this.mState);
            }
            clearAnimation();
            this.nUc.nSm.startAnimation(this.nUe);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dYt() {
        Tl();
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tk() {
        this.nUc.ehl.setClickable(true);
        this.mState = 2;
        if (this.nUl != null) {
            this.nUl.MG(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tl() {
        this.nUc.ehl.setClickable(false);
        this.mState = 4;
        if (this.nUl != null) {
            this.nUl.MG(this.mState);
        }
    }

    private void clearAnimation() {
        this.nUd.cancel();
        this.nUe.cancel();
        this.nUc.nSm.clearAnimation();
    }
}
