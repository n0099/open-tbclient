package com.baidu.tieba.pb.pb.main;

import android.view.animation.Animation;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ex implements Animation.AnimationListener {
    final /* synthetic */ es dVR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ex(es esVar) {
        this.dVR = esVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.dVR.dTq.setTitleVisibility(false);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ObservedChangeLinearLayout observedChangeLinearLayout;
        boolean z;
        PbActivity pbActivity;
        observedChangeLinearLayout = this.dVR.dUg;
        observedChangeLinearLayout.setVisibility(0);
        this.dVR.dTq.setTitleVisibility(true);
        this.dVR.hL(false);
        z = this.dVR.dVu;
        if (z) {
            this.dVR.aHP();
        }
        pbActivity = this.dVR.dOg;
        pbActivity.hs(true);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
