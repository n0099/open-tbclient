package com.baidu.tieba.pb.pb.main.a;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tieba.pb.pb.main.a.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Animation.AnimationListener {
    final /* synthetic */ f euW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.euW = fVar;
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
        view = this.euW.euU;
        if (view != null) {
            view2 = this.euW.euU;
            view2.clearAnimation();
            view3 = this.euW.euU;
            view3.setVisibility(8);
            this.euW.dq(true);
            aVar = this.euW.enD;
            if (aVar != null) {
                aVar2 = this.euW.enD;
                aVar2.dr(false);
            }
        }
    }
}
