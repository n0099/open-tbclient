package com.baidu.tieba.pb.chosen;

import android.view.View;
import android.view.animation.Animation;
import android.widget.ScrollView;
/* loaded from: classes.dex */
class f extends com.baidu.adp.lib.g.e {
    final /* synthetic */ PbChosenActivity bFY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PbChosenActivity pbChosenActivity) {
        this.bFY = pbChosenActivity;
    }

    @Override // com.baidu.adp.lib.g.e
    public void b(Animation animation) {
        Animation animation2;
        Animation animation3;
        com.baidu.tieba.pb.chosen.net.a aVar;
        View view;
        View view2;
        com.baidu.tieba.pb.chosen.net.a aVar2;
        ScrollView scrollView;
        com.baidu.tieba.pb.chosen.net.a aVar3;
        View view3;
        View view4;
        com.baidu.tieba.pb.chosen.net.a aVar4;
        animation2 = this.bFY.bFN;
        if (animation == animation2) {
            aVar3 = this.bFY.chosenData;
            if (aVar3 != null) {
                PbChosenActivity pbChosenActivity = this.bFY;
                view3 = this.bFY.rootView;
                pbChosenActivity.showLoadingView(view3, true);
                view4 = this.bFY.bFI;
                view4.setVisibility(8);
                PbChosenActivity pbChosenActivity2 = this.bFY;
                aVar4 = this.bFY.chosenData;
                pbChosenActivity2.ai(aVar4.getPreTid());
                return;
            }
            return;
        }
        animation3 = this.bFY.bFO;
        if (animation == animation3) {
            aVar = this.bFY.chosenData;
            if (aVar != null) {
                PbChosenActivity pbChosenActivity3 = this.bFY;
                view = this.bFY.rootView;
                pbChosenActivity3.showLoadingView(view, true);
                view2 = this.bFY.bFI;
                view2.setVisibility(8);
                PbChosenActivity pbChosenActivity4 = this.bFY;
                aVar2 = this.bFY.chosenData;
                pbChosenActivity4.ai(aVar2.getNextTid());
                scrollView = this.bFY.bFH;
                scrollView.scrollTo(0, 0);
            }
        }
    }
}
