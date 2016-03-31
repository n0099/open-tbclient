package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ey implements Animation.AnimationListener {
    final /* synthetic */ eu dnc;
    private final /* synthetic */ View dne;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ey(eu euVar, View view) {
        this.dnc = euVar;
        this.dne = view;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.dnc.dkF.setTitleVisibility(false);
        this.dne.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        RelativeLayout relativeLayout;
        relativeLayout = this.dnc.dln;
        relativeLayout.setVisibility(8);
        this.dnc.dkF.setTitleVisibility(true);
        this.dne.setVisibility(8);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.dnc.gp(true);
        }
        this.dnc.azh();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
