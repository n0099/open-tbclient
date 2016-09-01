package com.baidu.tieba.pb.pb.main;

import android.view.animation.Animation;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fc implements Animation.AnimationListener {
    final /* synthetic */ ex euB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fc(ex exVar) {
        this.euB = exVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.euB.erX.setTitleVisibility(false);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ObservedChangeLinearLayout observedChangeLinearLayout;
        boolean z;
        PbActivity pbActivity;
        observedChangeLinearLayout = this.euB.esN;
        observedChangeLinearLayout.setVisibility(0);
        this.euB.erX.setTitleVisibility(true);
        this.euB.is(false);
        z = this.euB.euc;
        if (z) {
            this.euB.aPQ();
        }
        pbActivity = this.euB.emy;
        pbActivity.hZ(true);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
