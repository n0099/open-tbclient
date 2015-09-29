package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cu implements Animation.AnimationListener {
    private final /* synthetic */ View clA;
    final /* synthetic */ cc cly;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cu(cc ccVar, View view) {
        this.cly = ccVar;
        this.clA = view;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.clA.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        RelativeLayout relativeLayout;
        relativeLayout = this.cly.ckw;
        relativeLayout.setVisibility(8);
        this.clA.setVisibility(8);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.cly.eJ(true);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
