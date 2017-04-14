package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.imMessageCenter.im.chat.notify.MessageAggregationListAdapter;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements com.baidu.tieba.im.chat.a.a {
    final /* synthetic */ l dkD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(l lVar) {
        this.dkD = lVar;
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
        bdListView = this.dkD.dhF;
        if (bdListView != null) {
            imMessageCenterModel = this.dkD.dhC;
            if (imMessageCenterModel != null) {
                bdListView2 = this.dkD.dhF;
                bdListView2.completePullRefreshPostDelayed(2000L);
                imMessageCenterModel2 = this.dkD.dhC;
                if (imMessageCenterModel2.getData() != null) {
                    messageAggregationListAdapter = this.dkD.dkw;
                    imMessageCenterModel3 = this.dkD.dhC;
                    messageAggregationListAdapter.setData(imMessageCenterModel3.getData());
                    return;
                }
                l lVar = this.dkD;
                isLogin = this.dkD.isLogin();
                lVar.r(isLogin, true);
            }
        }
    }
}
