package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class en implements Animation.AnimationListener {
    final /* synthetic */ dk cKg;
    private final /* synthetic */ View cKk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public en(dk dkVar, View view) {
        this.cKg = dkVar;
        this.cKk = view;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.cKk.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        RelativeLayout relativeLayout;
        relativeLayout = this.cKg.cIL;
        relativeLayout.setVisibility(8);
        this.cKk.setVisibility(8);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.cKg.fp(true);
        }
        this.cKg.anh();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
