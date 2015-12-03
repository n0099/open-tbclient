package com.baidu.tieba.recommendfrs.indicator;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.baidu.tieba.recommendfrs.indicator.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends com.baidu.adp.lib.h.d {
    final /* synthetic */ h djm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.djm = hVar;
    }

    @Override // com.baidu.adp.lib.h.d, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        h.a aVar;
        ViewGroup viewGroup;
        View view;
        h.a aVar2;
        this.djm.asq = false;
        aVar = this.djm.djk;
        if (aVar != null) {
            aVar2 = this.djm.djk;
            aVar2.awA();
        }
        viewGroup = this.djm.djj;
        view = this.djm.rootView;
        viewGroup.removeView(view);
    }
}
