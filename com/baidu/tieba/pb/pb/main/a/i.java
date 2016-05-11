package com.baidu.tieba.pb.pb.main.a;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tieba.pb.pb.main.a.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Animation.AnimationListener {
    final /* synthetic */ f dpO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(f fVar) {
        this.dpO = fVar;
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
        view = this.dpO.dpN;
        if (view != null) {
            view2 = this.dpO.dpN;
            view2.clearAnimation();
            view3 = this.dpO.dpN;
            view3.setVisibility(0);
            this.dpO.cZ(false);
            aVar = this.dpO.djh;
            if (aVar != null) {
                aVar2 = this.dpO.djh;
                aVar2.gA(true);
            }
        }
    }
}
