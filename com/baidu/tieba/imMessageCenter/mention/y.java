package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.imMessageCenter.im.chat.notify.MessageAggregationListAdapter;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements com.baidu.tieba.im.chat.a.a {
    final /* synthetic */ l dmU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(l lVar) {
        this.dmU = lVar;
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
        bdListView = this.dmU.djW;
        if (bdListView != null) {
            imMessageCenterModel = this.dmU.djT;
            if (imMessageCenterModel != null) {
                bdListView2 = this.dmU.djW;
                bdListView2.completePullRefreshPostDelayed(2000L);
                imMessageCenterModel2 = this.dmU.djT;
                if (imMessageCenterModel2.getData() != null) {
                    messageAggregationListAdapter = this.dmU.dmN;
                    imMessageCenterModel3 = this.dmU.djT;
                    messageAggregationListAdapter.setData(imMessageCenterModel3.getData());
                    return;
                }
                l lVar = this.dmU;
                isLogin = this.dmU.isLogin();
                lVar.r(isLogin, true);
            }
        }
    }
}
