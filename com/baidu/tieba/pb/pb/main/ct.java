package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ct implements Animation.AnimationListener {
    final /* synthetic */ cb cfj;
    private final /* synthetic */ View cfl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(cb cbVar, View view) {
        this.cfj = cbVar;
        this.cfl = view;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.cfl.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        RelativeLayout relativeLayout;
        relativeLayout = this.cfj.ceg;
        relativeLayout.setVisibility(8);
        this.cfl.setVisibility(8);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.cfj.ew(true);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
