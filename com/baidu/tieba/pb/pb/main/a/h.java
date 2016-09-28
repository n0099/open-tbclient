package com.baidu.tieba.pb.pb.main.a;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tieba.pb.pb.main.a.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Animation.AnimationListener {
    final /* synthetic */ f exc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.exc = fVar;
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
        view = this.exc.exa;
        if (view != null) {
            view2 = this.exc.exa;
            view2.clearAnimation();
            view3 = this.exc.exa;
            view3.setVisibility(8);
            this.exc.dr(true);
            aVar = this.exc.epC;
            if (aVar != null) {
                aVar2 = this.exc.epC;
                aVar2.ds(false);
            }
        }
    }
}
