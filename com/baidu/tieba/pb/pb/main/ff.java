package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ff implements Animation.AnimationListener {
    final /* synthetic */ fa etn;
    private final /* synthetic */ View etp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ff(fa faVar, View view) {
        this.etn = faVar;
        this.etp = view;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.etn.eqM.setTitleVisibility(false);
        this.etp.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ObservedChangeLinearLayout observedChangeLinearLayout;
        PbActivity pbActivity;
        observedChangeLinearLayout = this.etn.erx;
        observedChangeLinearLayout.setVisibility(8);
        this.etn.eqM.setTitleVisibility(true);
        this.etp.setVisibility(8);
        this.etn.iK(true);
        this.etn.aNw();
        pbActivity = this.etn.eka;
        pbActivity.in(false);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
