package com.baidu.tieba.pb.pb.main.a;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tieba.pb.pb.main.a.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Animation.AnimationListener {
    final /* synthetic */ f dWm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.dWm = fVar;
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
        view = this.dWm.dWk;
        if (view != null) {
            view2 = this.dWm.dWk;
            view2.clearAnimation();
            view3 = this.dWm.dWk;
            view3.setVisibility(8);
            this.dWm.dv(true);
            aVar = this.dWm.dPh;
            if (aVar != null) {
                aVar2 = this.dWm.dPh;
                aVar2.ht(false);
            }
        }
    }
}
