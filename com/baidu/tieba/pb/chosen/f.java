package com.baidu.tieba.pb.chosen;

import android.view.View;
import android.view.animation.Animation;
import android.widget.ScrollView;
/* loaded from: classes.dex */
class f extends com.baidu.adp.lib.g.e {
    final /* synthetic */ PbChosenActivity bGl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PbChosenActivity pbChosenActivity) {
        this.bGl = pbChosenActivity;
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
        animation2 = this.bGl.bGa;
        if (animation == animation2) {
            aVar3 = this.bGl.chosenData;
            if (aVar3 != null) {
                PbChosenActivity pbChosenActivity = this.bGl;
                view3 = this.bGl.rootView;
                pbChosenActivity.showLoadingView(view3, true);
                view4 = this.bGl.bFV;
                view4.setVisibility(8);
                PbChosenActivity pbChosenActivity2 = this.bGl;
                aVar4 = this.bGl.chosenData;
                pbChosenActivity2.ai(aVar4.getPreTid());
                return;
            }
            return;
        }
        animation3 = this.bGl.bGb;
        if (animation == animation3) {
            aVar = this.bGl.chosenData;
            if (aVar != null) {
                PbChosenActivity pbChosenActivity3 = this.bGl;
                view = this.bGl.rootView;
                pbChosenActivity3.showLoadingView(view, true);
                view2 = this.bGl.bFV;
                view2.setVisibility(8);
                PbChosenActivity pbChosenActivity4 = this.bGl;
                aVar2 = this.bGl.chosenData;
                pbChosenActivity4.ai(aVar2.getNextTid());
                scrollView = this.bGl.bFU;
                scrollView.scrollTo(0, 0);
            }
        }
    }
}
