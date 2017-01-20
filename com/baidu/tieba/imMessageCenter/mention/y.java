package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.imMessageCenter.im.chat.notify.MessageAggregationListAdapter;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements com.baidu.tieba.im.chat.a.a {
    final /* synthetic */ l djK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(l lVar) {
        this.djK = lVar;
    }

    @Override // com.baidu.tieba.im.chat.a.a
    public void onComplete() {
        BdListView bdListView;
        ImMessageCenterModel imMessageCenterModel;
        BdListView bdListView2;
        ImMessageCenterModel imMessageCenterModel2;
        boolean isLogin;
        MessageAggregationListAdapter messageAggregationListAdapter;
        ImMessageCenterModel imMessageCenterModel3;
        bdListView = this.djK.dgO;
        if (bdListView != null) {
            imMessageCenterModel = this.djK.dgL;
            if (imMessageCenterModel != null) {
                bdListView2 = this.djK.dgO;
                bdListView2.completePullRefreshPostDelayed(2000L);
                imMessageCenterModel2 = this.djK.dgL;
                if (imMessageCenterModel2.getData() != null) {
                    messageAggregationListAdapter = this.djK.djD;
                    imMessageCenterModel3 = this.djK.dgL;
                    messageAggregationListAdapter.setData(imMessageCenterModel3.getData());
                    return;
                }
                l lVar = this.djK;
                isLogin = this.djK.isLogin();
                lVar.s(isLogin, true);
            }
        }
    }
}
