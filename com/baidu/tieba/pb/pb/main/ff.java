package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ff implements Animation.AnimationListener {
    final /* synthetic */ ez eqf;
    private final /* synthetic */ View eqi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ff(ez ezVar, View view) {
        this.eqf = ezVar;
        this.eqi = view;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.eqf.enK.setTitleVisibility(false);
        this.eqi.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ObservedChangeLinearLayout observedChangeLinearLayout;
        PbActivity pbActivity;
        observedChangeLinearLayout = this.eqf.eou;
        observedChangeLinearLayout.setVisibility(8);
        this.eqf.enK.setTitleVisibility(true);
        this.eqi.setVisibility(8);
        this.eqf.iP(true);
        this.eqf.aOc();
        pbActivity = this.eqf.ehi;
        pbActivity.is(false);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
