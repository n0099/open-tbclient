package com.baidu.tieba.write;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class f extends h {
    private a.C0841a nma;
    private Animation nmb;
    private Animation nmc;

    public f(Context context, a.C0841a c0841a) {
        super(context, c0841a);
        this.nma = c0841a;
        this.nmb = AnimationUtils.loadAnimation(this.mContext, R.anim.ubs_test_in_anim);
        this.nmc = AnimationUtils.loadAnimation(this.mContext, R.anim.ubs_test_out_anim);
        this.nmb.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.f.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                f.this.dNo();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.nmc.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.f.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                f.this.dNq();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    @Override // com.baidu.tieba.write.h
    public void dNr() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.nmj != null) {
                this.nmj.KG(this.mState);
            }
            clearAnimation();
            this.nma.nks.startAnimation(this.nmb);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void awh() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.nmj != null) {
                this.nmj.KG(this.mState);
            }
            clearAnimation();
            this.nma.nks.startAnimation(this.nmc);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dNs() {
        dNq();
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dNo() {
        this.nma.dNE.setClickable(true);
        this.mState = 2;
        if (this.nmj != null) {
            this.nmj.KG(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dNq() {
        this.nma.dNE.setClickable(false);
        this.mState = 4;
        if (this.nmj != null) {
            this.nmj.KG(this.mState);
        }
    }

    private void clearAnimation() {
        this.nmb.cancel();
        this.nmc.cancel();
        this.nma.nks.clearAnimation();
    }
}
