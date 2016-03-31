package com.baidu.tieba.pb.pb.main;

import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ez implements Animation.AnimationListener {
    final /* synthetic */ eu dnc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ez(eu euVar) {
        this.dnc = euVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.dnc.dkF.setTitleVisibility(false);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        RelativeLayout relativeLayout;
        boolean z;
        relativeLayout = this.dnc.dln;
        relativeLayout.setVisibility(0);
        this.dnc.dkF.setTitleVisibility(true);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.dnc.gp(false);
        }
        z = this.dnc.dmC;
        if (z) {
            this.dnc.azi();
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
