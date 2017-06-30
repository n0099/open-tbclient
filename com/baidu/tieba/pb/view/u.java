package com.baidu.tieba.pb.view;

import android.animation.Animator;
import android.widget.ImageView;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements Animator.AnimatorListener {
    final /* synthetic */ t eMt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.eMt = tVar;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        boolean z;
        List list;
        List list2;
        this.eMt.eMm = true;
        z = this.eMt.eMe;
        if (!z) {
            this.eMt.setVisibility(8);
            int i = 0;
            while (true) {
                int i2 = i;
                list = this.eMt.eMg;
                if (i2 < list.size()) {
                    list2 = this.eMt.eMg;
                    ImageView imageView = (ImageView) list2.get(i2);
                    if (imageView.getTag() != null) {
                        ((com.baidu.tieba.pb.pb.main.view.c) imageView.getTag()).stop();
                    }
                    imageView.setTag(null);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        boolean z;
        z = this.eMt.eMe;
        if (!z) {
            this.eMt.setVisibility(8);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }
}
