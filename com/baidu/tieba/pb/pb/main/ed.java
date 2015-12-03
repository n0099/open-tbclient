package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ed implements Animation.AnimationListener {
    final /* synthetic */ da cGh;
    private final /* synthetic */ View cGl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ed(da daVar, View view) {
        this.cGh = daVar;
        this.cGl = view;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.cGl.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        RelativeLayout relativeLayout;
        relativeLayout = this.cGh.cEM;
        relativeLayout.setVisibility(8);
        this.cGl.setVisibility(8);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.cGh.fq(true);
        }
        this.cGh.alV();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
