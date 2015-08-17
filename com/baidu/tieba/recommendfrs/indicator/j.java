package com.baidu.tieba.recommendfrs.indicator;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.baidu.tieba.recommendfrs.indicator.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends com.baidu.adp.lib.g.d {
    final /* synthetic */ h ctC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.ctC = hVar;
    }

    @Override // com.baidu.adp.lib.g.d, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        h.a aVar;
        ViewGroup viewGroup;
        View view;
        h.a aVar2;
        this.ctC.arz = false;
        aVar = this.ctC.ctA;
        if (aVar != null) {
            aVar2 = this.ctC.ctA;
            aVar2.ajW();
        }
        viewGroup = this.ctC.ctz;
        view = this.ctC.rootView;
        viewGroup.removeView(view);
    }
}
