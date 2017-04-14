package com.baidu.tieba.pb.pb.main.a;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tieba.pb.pb.main.a.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Animation.AnimationListener {
    final /* synthetic */ f erP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.erP = fVar;
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
        view = this.erP.erM;
        if (view != null) {
            view2 = this.erP.erM;
            view2.clearAnimation();
            view3 = this.erP.erM;
            view3.setVisibility(8);
            z = this.erP.erO;
            if (z) {
                this.erP.dn(false);
            } else {
                this.erP.dn(true);
            }
            aVar = this.erP.ejv;
            if (aVar != null) {
                aVar2 = this.erP.ejv;
                aVar2.mo23do(false);
            }
        }
    }
}
