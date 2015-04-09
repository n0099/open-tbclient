package com.baidu.tieba.pb.chosen;

import android.view.View;
import android.view.animation.Animation;
import android.widget.Toast;
import com.baidu.tieba.pb.chosen.widget.PullToRefreshScrollView;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class a implements com.baidu.tieba.pb.chosen.widget.c {
    final /* synthetic */ PbChosenActivity bGl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PbChosenActivity pbChosenActivity) {
        this.bGl = pbChosenActivity;
    }

    @Override // com.baidu.tieba.pb.chosen.widget.c
    public void hd(int i) {
        com.baidu.tieba.pb.chosen.net.a aVar;
        View view;
        Animation YM;
        PullToRefreshScrollView pullToRefreshScrollView;
        com.baidu.tieba.pb.chosen.net.a aVar2;
        View view2;
        Animation YL;
        if (i == 1) {
            aVar2 = this.bGl.chosenData;
            if (aVar2.getPreTid() > 0) {
                view2 = this.bGl.bFV;
                YL = this.bGl.YL();
                view2.startAnimation(YL);
            } else {
                Toast.makeText(this.bGl.getPageContext().getPageActivity(), y.chosen_pb_no_more_pre_post, 0).show();
            }
        } else if (i == 2) {
            aVar = this.bGl.chosenData;
            if (aVar.getNextTid() > 0) {
                view = this.bGl.bFV;
                YM = this.bGl.YM();
                view.startAnimation(YM);
            } else {
                Toast.makeText(this.bGl.getPageContext().getPageActivity(), y.chosen_pb_no_more_next_post, 0).show();
            }
        }
        pullToRefreshScrollView = this.bGl.bFT;
        pullToRefreshScrollView.YT();
    }
}
