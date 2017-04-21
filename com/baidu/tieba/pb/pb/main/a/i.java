package com.baidu.tieba.pb.pb.main.a;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tieba.pb.pb.main.a.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Animation.AnimationListener {
    final /* synthetic */ f euh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(f fVar) {
        this.euh = fVar;
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
        view = this.euh.eue;
        if (view != null) {
            view2 = this.euh.eue;
            view2.clearAnimation();
            view3 = this.euh.eue;
            view3.setVisibility(0);
            this.euh.dx(false);
            aVar = this.euh.elL;
            if (aVar != null) {
                aVar2 = this.euh.elL;
                aVar2.dy(true);
            }
        }
    }
}
