package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ct implements Animation.AnimationListener {
    final /* synthetic */ cb cgg;
    private final /* synthetic */ View cgi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(cb cbVar, View view) {
        this.cgg = cbVar;
        this.cgi = view;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.cgi.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        RelativeLayout relativeLayout;
        relativeLayout = this.cgg.cfd;
        relativeLayout.setVisibility(8);
        this.cgi.setVisibility(8);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.cgg.eE(true);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
