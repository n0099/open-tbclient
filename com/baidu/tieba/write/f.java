package com.baidu.tieba.write;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class f extends h {
    private a.C0904a ofG;
    private Animation ofH;
    private Animation ofI;

    public f(Context context, a.C0904a c0904a) {
        super(context, c0904a);
        this.ofG = c0904a;
        this.ofH = AnimationUtils.loadAnimation(this.mContext, R.anim.ubs_test_in_anim);
        this.ofI = AnimationUtils.loadAnimation(this.mContext, R.anim.ubs_test_out_anim);
        this.ofH.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.f.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                f.this.Sh();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.ofI.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.f.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                f.this.Si();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    @Override // com.baidu.tieba.write.h
    public void dWJ() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.ofP != null) {
                this.ofP.Lm(this.mState);
            }
            clearAnimation();
            this.ofG.odP.startAnimation(this.ofH);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void aBc() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.ofP != null) {
                this.ofP.Lm(this.mState);
            }
            clearAnimation();
            this.ofG.odP.startAnimation(this.ofI);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dWK() {
        Si();
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sh() {
        this.ofG.epj.setClickable(true);
        this.mState = 2;
        if (this.ofP != null) {
            this.ofP.Lm(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Si() {
        this.ofG.epj.setClickable(false);
        this.mState = 4;
        if (this.ofP != null) {
            this.ofP.Lm(this.mState);
        }
    }

    private void clearAnimation() {
        this.ofH.cancel();
        this.ofI.cancel();
        this.ofG.odP.clearAnimation();
    }
}
