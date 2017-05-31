package com.baidu.tieba.pb.pb.main.a;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tieba.pb.pb.main.a.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Animation.AnimationListener {
    final /* synthetic */ f ewJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(f fVar) {
        this.ewJ = fVar;
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
        view = this.ewJ.ewG;
        if (view != null) {
            view2 = this.ewJ.ewG;
            view2.clearAnimation();
            view3 = this.ewJ.ewG;
            view3.setVisibility(0);
            this.ewJ.dP(false);
            aVar = this.ewJ.emC;
            if (aVar != null) {
                aVar2 = this.ewJ.emC;
                aVar2.dQ(true);
            }
        }
    }
}
