package com.baidu.tieba.pb.pb.main;

import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dc implements Animation.AnimationListener {
    final /* synthetic */ da cGh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dc(da daVar) {
        this.cGh = daVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        RelativeLayout relativeLayout;
        boolean z;
        relativeLayout = this.cGh.cEM;
        relativeLayout.setVisibility(0);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.cGh.fq(false);
        }
        z = this.cGh.cFX;
        if (!z) {
            return;
        }
        this.cGh.alW();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
