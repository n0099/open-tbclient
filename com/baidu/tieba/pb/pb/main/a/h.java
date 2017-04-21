package com.baidu.tieba.pb.pb.main.a;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tieba.pb.pb.main.a.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Animation.AnimationListener {
    final /* synthetic */ f euh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
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
        boolean z;
        f.a aVar;
        f.a aVar2;
        view = this.euh.eue;
        if (view != null) {
            view2 = this.euh.eue;
            view2.clearAnimation();
            view3 = this.euh.eue;
            view3.setVisibility(8);
            z = this.euh.eug;
            if (z) {
                this.euh.dx(false);
            } else {
                this.euh.dx(true);
            }
            aVar = this.euh.elL;
            if (aVar != null) {
                aVar2 = this.euh.elL;
                aVar2.dy(false);
            }
        }
    }
}
