package com.baidu.tieba.pb.pb.main;

import android.view.animation.Animation;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fd implements Animation.AnimationListener {
    final /* synthetic */ ey eCT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fd(ey eyVar) {
        this.eCT = eyVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.eCT.eAx.setTitleVisibility(false);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ObservedChangeLinearLayout observedChangeLinearLayout;
        boolean z;
        PbActivity pbActivity;
        observedChangeLinearLayout = this.eCT.eBi;
        observedChangeLinearLayout.setVisibility(0);
        this.eCT.eAx.setTitleVisibility(true);
        this.eCT.iT(false);
        z = this.eCT.eCs;
        if (z) {
            this.eCT.aSu();
        }
        pbActivity = this.eCT.eug;
        pbActivity.iv(true);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
