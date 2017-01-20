package com.baidu.tieba.pb.pb.main.a;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tieba.pb.pb.main.a.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Animation.AnimationListener {
    final /* synthetic */ f eqF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
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
        boolean z;
        f.a aVar;
        f.a aVar2;
        view = this.eqF.eqC;
        if (view != null) {
            view2 = this.eqF.eqC;
            view2.clearAnimation();
            view3 = this.eqF.eqC;
            view3.setVisibility(8);
            z = this.eqF.eqE;
            if (z) {
                this.eqF.dl(false);
            } else {
                this.eqF.dl(true);
            }
            aVar = this.eqF.eiw;
            if (aVar != null) {
                aVar2 = this.eqF.eiw;
                aVar2.dm(false);
            }
        }
    }
}
