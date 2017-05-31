package com.baidu.tieba.pb.pb.main.a;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tieba.pb.pb.main.a.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Animation.AnimationListener {
    final /* synthetic */ f ewJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
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
        boolean z;
        f.a aVar;
        f.a aVar2;
        view = this.ewJ.ewG;
        if (view != null) {
            view2 = this.ewJ.ewG;
            view2.clearAnimation();
            view3 = this.ewJ.ewG;
            view3.setVisibility(8);
            z = this.ewJ.ewI;
            if (z) {
                this.ewJ.dP(false);
            } else {
                this.ewJ.dP(true);
            }
            aVar = this.ewJ.emC;
            if (aVar != null) {
                aVar2 = this.ewJ.emC;
                aVar2.dQ(false);
            }
        }
    }
}
