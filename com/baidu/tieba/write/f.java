package com.baidu.tieba.write;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class f extends h {
    private a.C0871a nEv;
    private Animation nEw;
    private Animation nEx;

    public f(Context context, a.C0871a c0871a) {
        super(context, c0871a);
        this.nEv = c0871a;
        this.nEw = AnimationUtils.loadAnimation(this.mContext, R.anim.ubs_test_in_anim);
        this.nEx = AnimationUtils.loadAnimation(this.mContext, R.anim.ubs_test_out_anim);
        this.nEw.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.f.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                f.this.Rv();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.nEx.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.f.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                f.this.Rw();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    @Override // com.baidu.tieba.write.h
    public void dSZ() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.nEE != null) {
                this.nEE.Ll(this.mState);
            }
            clearAnimation();
            this.nEv.nCN.startAnimation(this.nEw);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void aAB() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.nEE != null) {
                this.nEE.Ll(this.mState);
            }
            clearAnimation();
            this.nEv.nCN.startAnimation(this.nEx);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dTa() {
        Rw();
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rv() {
        this.nEv.ebT.setClickable(true);
        this.mState = 2;
        if (this.nEE != null) {
            this.nEE.Ll(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rw() {
        this.nEv.ebT.setClickable(false);
        this.mState = 4;
        if (this.nEE != null) {
            this.nEE.Ll(this.mState);
        }
    }

    private void clearAnimation() {
        this.nEw.cancel();
        this.nEx.cancel();
        this.nEv.nCN.clearAnimation();
    }
}
