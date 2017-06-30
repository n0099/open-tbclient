package com.baidu.tieba.pb.pb.main.a;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tieba.pb.pb.main.a.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Animation.AnimationListener {
    final /* synthetic */ f eGf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.eGf = fVar;
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
        view = this.eGf.eGc;
        if (view != null) {
            view2 = this.eGf.eGc;
            view2.clearAnimation();
            view3 = this.eGf.eGc;
            view3.setVisibility(8);
            z = this.eGf.eGe;
            if (z) {
                this.eGf.ef(false);
            } else {
                this.eGf.ef(true);
            }
            aVar = this.eGf.evG;
            if (aVar != null) {
                aVar2 = this.eGf.evG;
                aVar2.eg(false);
            }
        }
    }
}
