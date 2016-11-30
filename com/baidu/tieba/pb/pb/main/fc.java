package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fc implements Animation.AnimationListener {
    final /* synthetic */ ey eCT;
    private final /* synthetic */ View eCV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fc(ey eyVar, View view) {
        this.eCT = eyVar;
        this.eCV = view;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.eCT.eAx.setTitleVisibility(false);
        this.eCV.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ObservedChangeLinearLayout observedChangeLinearLayout;
        PbActivity pbActivity;
        observedChangeLinearLayout = this.eCT.eBi;
        observedChangeLinearLayout.setVisibility(8);
        this.eCT.eAx.setTitleVisibility(true);
        this.eCV.setVisibility(8);
        this.eCT.iT(true);
        this.eCT.aSt();
        pbActivity = this.eCT.eug;
        pbActivity.iv(false);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
