package com.baidu.tieba.pb.pb.main;

import android.view.animation.Animation;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fg implements Animation.AnimationListener {
    final /* synthetic */ ez eqf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fg(ez ezVar) {
        this.eqf = ezVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.eqf.enK.setTitleVisibility(false);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ObservedChangeLinearLayout observedChangeLinearLayout;
        boolean z;
        PbActivity pbActivity;
        observedChangeLinearLayout = this.eqf.eou;
        observedChangeLinearLayout.setVisibility(0);
        this.eqf.enK.setTitleVisibility(true);
        this.eqf.iP(false);
        z = this.eqf.epE;
        if (z) {
            this.eqf.aOd();
        }
        pbActivity = this.eqf.ehi;
        pbActivity.is(true);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
