package com.baidu.tieba.pb.pb.main.a;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tieba.pb.pb.main.a.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Animation.AnimationListener {
    final /* synthetic */ f eiP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(f fVar) {
        this.eiP = fVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        View view;
        View view2;
        View view3;
        f.a aVar;
        f.a aVar2;
        view = this.eiP.eiN;
        if (view != null) {
            view2 = this.eiP.eiN;
            view2.clearAnimation();
            view3 = this.eiP.eiN;
            view3.setVisibility(0);
            this.eiP.ds(false);
            aVar = this.eiP.ebv;
            if (aVar != null) {
                aVar2 = this.eiP.ebv;
                aVar2.hE(true);
            }
        }
    }
}
