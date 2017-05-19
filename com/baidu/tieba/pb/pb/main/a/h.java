package com.baidu.tieba.pb.pb.main.a;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tieba.pb.pb.main.a.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Animation.AnimationListener {
    final /* synthetic */ f epK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.epK = fVar;
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
        view = this.epK.epH;
        if (view != null) {
            view2 = this.epK.epH;
            view2.clearAnimation();
            view3 = this.epK.epH;
            view3.setVisibility(8);
            z = this.epK.epJ;
            if (z) {
                this.epK.dy(false);
            } else {
                this.epK.dy(true);
            }
            aVar = this.epK.egZ;
            if (aVar != null) {
                aVar2 = this.epK.egZ;
                aVar2.dz(false);
            }
        }
    }
}
