package com.baidu.tieba.pb.pb.main.a;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tieba.pb.pb.main.a.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Animation.AnimationListener {
    final /* synthetic */ j ehx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.ehx = jVar;
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
        view = this.ehx.ehv;
        if (view != null) {
            view2 = this.ehx.ehv;
            view2.clearAnimation();
            view3 = this.ehx.ehv;
            view3.setVisibility(0);
            this.ehx.de(false);
            aVar = this.ehx.dZJ;
            if (aVar != null) {
                aVar2 = this.ehx.dZJ;
                aVar2.df(true);
            }
        }
    }
}
