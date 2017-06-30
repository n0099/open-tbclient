package com.baidu.tieba.pb.pb.main;

import android.view.ViewGroup;
import android.view.animation.Animation;
/* loaded from: classes.dex */
class he implements Animation.AnimationListener {
    final /* synthetic */ hd eEy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public he(hd hdVar) {
        this.eEy = hdVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        gg ggVar;
        ViewGroup viewGroup;
        ggVar = this.eEy.eEv;
        viewGroup = ggVar.eDD;
        viewGroup.setVisibility(8);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
