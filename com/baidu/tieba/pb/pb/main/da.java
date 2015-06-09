package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class da implements Animation.AnimationListener {
    final /* synthetic */ ch bOG;
    private final /* synthetic */ View bOI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public da(ch chVar, View view) {
        this.bOG = chVar;
        this.bOI = view;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.bOI.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        relativeLayout = this.bOG.bND;
        relativeLayout.setVisibility(8);
        this.bOI.setVisibility(8);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            relativeLayout2 = this.bOG.bHH;
            com.baidu.tbadk.core.util.bq.a((View) relativeLayout2, com.baidu.tieba.n.cp_link_tip_b, true);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
