package com.baidu.tieba.pb.chosen;

import android.view.View;
import android.view.animation.Animation;
import android.widget.Toast;
import com.baidu.tieba.pb.chosen.widget.PullToRefreshScrollView;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class a implements com.baidu.tieba.pb.chosen.widget.c {
    final /* synthetic */ PbChosenActivity bFY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PbChosenActivity pbChosenActivity) {
        this.bFY = pbChosenActivity;
    }

    @Override // com.baidu.tieba.pb.chosen.widget.c
    public void hb(int i) {
        com.baidu.tieba.pb.chosen.net.a aVar;
        View view;
        Animation YA;
        PullToRefreshScrollView pullToRefreshScrollView;
        com.baidu.tieba.pb.chosen.net.a aVar2;
        View view2;
        Animation Yz;
        if (i == 1) {
            aVar2 = this.bFY.chosenData;
            if (aVar2.getPreTid() > 0) {
                view2 = this.bFY.bFI;
                Yz = this.bFY.Yz();
                view2.startAnimation(Yz);
            } else {
                Toast.makeText(this.bFY.getPageContext().getPageActivity(), y.chosen_pb_no_more_pre_post, 0).show();
            }
        } else if (i == 2) {
            aVar = this.bFY.chosenData;
            if (aVar.getNextTid() > 0) {
                view = this.bFY.bFI;
                YA = this.bFY.YA();
                view.startAnimation(YA);
            } else {
                Toast.makeText(this.bFY.getPageContext().getPageActivity(), y.chosen_pb_no_more_next_post, 0).show();
            }
        }
        pullToRefreshScrollView = this.bFY.bFG;
        pullToRefreshScrollView.YH();
    }
}
