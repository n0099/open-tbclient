package com.baidu.tieba.pb.pb.main;

import android.view.animation.Animation;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fe implements Animation.AnimationListener {
    final /* synthetic */ ey erv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fe(ey eyVar) {
        this.erv = eyVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.erv.eoV.setTitleVisibility(false);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ObservedChangeLinearLayout observedChangeLinearLayout;
        boolean z;
        PbActivity pbActivity;
        observedChangeLinearLayout = this.erv.epG;
        observedChangeLinearLayout.setVisibility(0);
        this.erv.eoV.setTitleVisibility(true);
        this.erv.iJ(false);
        z = this.erv.eqT;
        if (z) {
            this.erv.aNG();
        }
        pbActivity = this.erv.eig;
        pbActivity.im(true);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
