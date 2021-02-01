package com.baidu.tieba.write;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class f extends h {
    private a.C0896a oda;
    private Animation odb;
    private Animation odc;

    public f(Context context, a.C0896a c0896a) {
        super(context, c0896a);
        this.oda = c0896a;
        this.odb = AnimationUtils.loadAnimation(this.mContext, R.anim.ubs_test_in_anim);
        this.odc = AnimationUtils.loadAnimation(this.mContext, R.anim.ubs_test_out_anim);
        this.odb.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.f.1
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
        this.odc.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.write.f.2
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
    public void dWt() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.odj != null) {
                this.odj.Lh(this.mState);
            }
            clearAnimation();
            this.oda.obi.startAnimation(this.odb);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void aAZ() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.odj != null) {
                this.odj.Lh(this.mState);
            }
            clearAnimation();
            this.oda.obi.startAnimation(this.odc);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dWu() {
        Sf();
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Se() {
        this.oda.enH.setClickable(true);
        this.mState = 2;
        if (this.odj != null) {
            this.odj.Lh(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sf() {
        this.oda.enH.setClickable(false);
        this.mState = 4;
        if (this.odj != null) {
            this.odj.Lh(this.mState);
        }
    }

    private void clearAnimation() {
        this.odb.cancel();
        this.odc.cancel();
        this.oda.obi.clearAnimation();
    }
}
