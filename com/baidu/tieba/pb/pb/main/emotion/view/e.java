package com.baidu.tieba.pb.pb.main.emotion.view;

import android.animation.Animator;
import android.widget.FrameLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Animator.AnimatorListener {
    final /* synthetic */ a ewn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.ewn = aVar;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (((FrameLayout.LayoutParams) this.ewn.getLayoutParams()).leftMargin <= 0) {
            this.ewn.setCanChildShowPreview(true);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }
}
