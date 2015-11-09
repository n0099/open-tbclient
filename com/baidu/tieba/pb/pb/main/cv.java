package com.baidu.tieba.pb.pb.main;

import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cv implements Animation.AnimationListener {
    final /* synthetic */ ct cmY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cv(ct ctVar) {
        this.cmY = ctVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        RelativeLayout relativeLayout;
        relativeLayout = this.cmY.clU;
        relativeLayout.setVisibility(0);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.cmY.eM(false);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
