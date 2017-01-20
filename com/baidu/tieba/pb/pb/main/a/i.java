package com.baidu.tieba.pb.pb.main.a;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tieba.pb.pb.main.a.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Animation.AnimationListener {
    final /* synthetic */ f eqF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(f fVar) {
        this.eqF = fVar;
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
        view = this.eqF.eqC;
        if (view != null) {
            view2 = this.eqF.eqC;
            view2.clearAnimation();
            view3 = this.eqF.eqC;
            view3.setVisibility(0);
            this.eqF.dl(false);
            aVar = this.eqF.eiw;
            if (aVar != null) {
                aVar2 = this.eqF.eiw;
                aVar2.dm(true);
            }
        }
    }
}
