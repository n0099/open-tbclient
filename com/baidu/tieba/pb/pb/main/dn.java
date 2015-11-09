package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dn implements Animation.AnimationListener {
    final /* synthetic */ ct cmY;
    private final /* synthetic */ View cna;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dn(ct ctVar, View view) {
        this.cmY = ctVar;
        this.cna = view;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.cna.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        RelativeLayout relativeLayout;
        relativeLayout = this.cmY.clU;
        relativeLayout.setVisibility(8);
        this.cna.setVisibility(8);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.cmY.eM(true);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
