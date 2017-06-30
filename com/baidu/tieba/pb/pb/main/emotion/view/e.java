package com.baidu.tieba.pb.pb.main.emotion.view;

import android.animation.Animator;
import android.widget.FrameLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Animator.AnimatorListener {
    private final /* synthetic */ int aBv;
    final /* synthetic */ a eFJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, int i) {
        this.eFJ = aVar;
        this.aBv = i;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        int i;
        if (((FrameLayout.LayoutParams) this.eFJ.getLayoutParams()).leftMargin <= 0) {
            this.eFJ.setCanChildShowPreview(true);
        }
        if (this.aBv == 0) {
            i = this.eFJ.eFu;
            if (i != 0) {
                return;
            }
            this.eFJ.jv(true);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }
}
