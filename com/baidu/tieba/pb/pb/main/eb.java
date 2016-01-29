package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class eb implements Animation.AnimationListener {
    final /* synthetic */ dz cSw;
    private final /* synthetic */ View cSx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eb(dz dzVar, View view) {
        this.cSw = dzVar;
        this.cSx = view;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.cSw.cQn.setTitleVisibility(false);
        this.cSx.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        RelativeLayout relativeLayout;
        relativeLayout = this.cSw.cQQ;
        relativeLayout.setVisibility(8);
        this.cSw.cQn.setTitleVisibility(true);
        this.cSx.setVisibility(8);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.cSw.fF(true);
        }
        this.cSw.arG();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
