package com.baidu.tieba.pb.chosen;

import android.view.View;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.pb.chosen.widget.PullToRefreshScrollView;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class i extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ PbChosenActivity bGl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(PbChosenActivity pbChosenActivity, int i, int i2) {
        super(i, i2);
        this.bGl = pbChosenActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        View view;
        boolean z;
        View view2;
        PullToRefreshScrollView pullToRefreshScrollView;
        if (responsedMessage instanceof com.baidu.tieba.pb.chosen.net.a) {
            com.baidu.tieba.pb.chosen.net.a aVar = (com.baidu.tieba.pb.chosen.net.a) responsedMessage;
            int erroCode = aVar.getErroCode();
            this.bGl.bGe = true;
            if (erroCode != 0 || aVar.isEmpty()) {
                PbChosenActivity pbChosenActivity = this.bGl;
                view = this.bGl.rootView;
                pbChosenActivity.hideLoadingView(view);
                this.bGl.showToast(StringUtils.isNull(aVar.getErrorText()) ? this.bGl.getResources().getString(y.neterror) : aVar.getErrorText());
            } else {
                this.bGl.a(aVar);
            }
            z = this.bGl.aGQ;
            if (!z) {
                String string = this.bGl.getResources().getString(y.recommend_pb_no_net_text);
                PbChosenActivity pbChosenActivity2 = this.bGl;
                view2 = this.bGl.rootView;
                pbChosenActivity2.showNetRefreshView(view2, string, true);
                pullToRefreshScrollView = this.bGl.bFT;
                pullToRefreshScrollView.setVisibility(8);
            }
        }
    }
}
