package com.baidu.tieba.pb.pb.main.a;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tieba.pb.pb.main.a.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Animation.AnimationListener {
    final /* synthetic */ j eDw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.eDw = jVar;
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
        j.a aVar;
        j.a aVar2;
        view = this.eDw.eDt;
        if (view != null) {
            view2 = this.eDw.eDt;
            view2.clearAnimation();
            view3 = this.eDw.eDt;
            view3.setVisibility(0);
            this.eDw.dw(false);
            aVar = this.eDw.evn;
            if (aVar != null) {
                aVar2 = this.eDw.evn;
                aVar2.dx(true);
            }
        }
    }
}
