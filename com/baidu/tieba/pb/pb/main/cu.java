package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cu implements Animation.AnimationListener {
    final /* synthetic */ cc clJ;
    private final /* synthetic */ View clL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cu(cc ccVar, View view) {
        this.clJ = ccVar;
        this.clL = view;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.clL.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        RelativeLayout relativeLayout;
        relativeLayout = this.clJ.ckH;
        relativeLayout.setVisibility(8);
        this.clL.setVisibility(8);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.clJ.eJ(true);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
