package com.baidu.tieba.pb.pb.main;

import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ec implements Animation.AnimationListener {
    final /* synthetic */ dz cSw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ec(dz dzVar) {
        this.cSw = dzVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.cSw.cQn.setTitleVisibility(false);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        RelativeLayout relativeLayout;
        boolean z;
        relativeLayout = this.cSw.cQQ;
        relativeLayout.setVisibility(0);
        this.cSw.cQn.setTitleVisibility(true);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.cSw.fF(false);
        }
        z = this.cSw.cSb;
        if (z) {
            this.cSw.arH();
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
