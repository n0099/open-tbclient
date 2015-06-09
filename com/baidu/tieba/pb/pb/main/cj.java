package com.baidu.tieba.pb.pb.main;

import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cj implements Animation.AnimationListener {
    final /* synthetic */ ch bOG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(ch chVar) {
        this.bOG = chVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        relativeLayout = this.bOG.bND;
        relativeLayout.setVisibility(0);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            relativeLayout2 = this.bOG.bHH;
            com.baidu.tbadk.core.util.bq.q(relativeLayout2);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
