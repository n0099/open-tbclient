package com.baidu.tieba.write;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class f extends h {
    private a.C0856a nyB;
    private Animation nyC;
    private Animation nyD;

    public f(Context context, a.C0856a c0856a) {
        super(context, c0856a);
        this.nyB = c0856a;
        this.nyC = AnimationUtils.loadAnimation(this.mContext, R.anim.ubs_test_in_anim);
        this.nyD = AnimationUtils.loadAnimation(this.mContext, R.anim.ubs_test_out_anim);
        this.nyC.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.f.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                f.this.dQw();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.nyD.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.f.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                f.this.dQy();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    @Override // com.baidu.tieba.write.h
    public void dQz() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.nyK != null) {
                this.nyK.KY(this.mState);
            }
            clearAnimation();
            this.nyB.nwT.startAnimation(this.nyC);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void ayb() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.nyK != null) {
                this.nyK.KY(this.mState);
            }
            clearAnimation();
            this.nyB.nwT.startAnimation(this.nyD);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dQA() {
        dQy();
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQw() {
        this.nyB.dWb.setClickable(true);
        this.mState = 2;
        if (this.nyK != null) {
            this.nyK.KY(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQy() {
        this.nyB.dWb.setClickable(false);
        this.mState = 4;
        if (this.nyK != null) {
            this.nyK.KY(this.mState);
        }
    }

    private void clearAnimation() {
        this.nyC.cancel();
        this.nyD.cancel();
        this.nyB.nwT.clearAnimation();
    }
}
