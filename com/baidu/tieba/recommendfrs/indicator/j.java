package com.baidu.tieba.recommendfrs.indicator;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.baidu.tieba.recommendfrs.indicator.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends com.baidu.adp.lib.g.d {
    final /* synthetic */ h cBU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.cBU = hVar;
    }

    @Override // com.baidu.adp.lib.g.d, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        h.a aVar;
        ViewGroup viewGroup;
        View view;
        h.a aVar2;
        this.cBU.atj = false;
        aVar = this.cBU.cBS;
        if (aVar != null) {
            aVar2 = this.cBU.cBS;
            aVar2.aoc();
        }
        viewGroup = this.cBU.cBR;
        view = this.cBU.rootView;
        viewGroup.removeView(view);
    }
}
