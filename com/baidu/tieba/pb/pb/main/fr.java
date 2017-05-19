package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fr implements Animation.AnimationListener {
    final /* synthetic */ fm epr;
    private final /* synthetic */ View ept;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fr(fm fmVar, View view) {
        this.epr = fmVar;
        this.ept = view;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.epr.emS.setTitleVisibility(false);
        this.ept.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ObservedChangeLinearLayout observedChangeLinearLayout;
        PbActivity pbActivity;
        observedChangeLinearLayout = this.epr.enF;
        observedChangeLinearLayout.setVisibility(8);
        this.epr.emS.setTitleVisibility(false);
        this.ept.setVisibility(8);
        this.epr.iy(true);
        pbActivity = this.epr.efF;
        pbActivity.hW(false);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
