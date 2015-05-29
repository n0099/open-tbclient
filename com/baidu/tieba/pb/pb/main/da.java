package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class da implements Animation.AnimationListener {
    final /* synthetic */ ch bOF;
    private final /* synthetic */ View bOH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public da(ch chVar, View view) {
        this.bOF = chVar;
        this.bOH = view;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.bOH.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        relativeLayout = this.bOF.bNC;
        relativeLayout.setVisibility(8);
        this.bOH.setVisibility(8);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            relativeLayout2 = this.bOF.bHG;
            com.baidu.tbadk.core.util.bq.a((View) relativeLayout2, com.baidu.tieba.n.cp_link_tip_b, true);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
