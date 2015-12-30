package com.baidu.tieba.recommendfrs.indicator;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.baidu.tieba.recommendfrs.indicator.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends com.baidu.adp.lib.h.d {
    final /* synthetic */ h dpQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.dpQ = hVar;
    }

    @Override // com.baidu.adp.lib.h.d, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        h.a aVar;
        ViewGroup viewGroup;
        View view;
        h.a aVar2;
        this.dpQ.atU = false;
        aVar = this.dpQ.dpO;
        if (aVar != null) {
            aVar2 = this.dpQ.dpO;
            aVar2.ayG();
        }
        viewGroup = this.dpQ.dpN;
        view = this.dpQ.rootView;
        viewGroup.removeView(view);
    }
}
