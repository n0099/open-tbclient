package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.imMessageCenter.im.chat.notify.MessageAggregationListAdapter;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements com.baidu.tieba.im.chat.a.a {
    final /* synthetic */ l dme;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(l lVar) {
        this.dme = lVar;
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
        bdListView = this.dme.djg;
        if (bdListView != null) {
            imMessageCenterModel = this.dme.djd;
            if (imMessageCenterModel != null) {
                bdListView2 = this.dme.djg;
                bdListView2.completePullRefreshPostDelayed(2000L);
                imMessageCenterModel2 = this.dme.djd;
                if (imMessageCenterModel2.getData() != null) {
                    messageAggregationListAdapter = this.dme.dlX;
                    imMessageCenterModel3 = this.dme.djd;
                    messageAggregationListAdapter.setData(imMessageCenterModel3.getData());
                    return;
                }
                l lVar = this.dme;
                isLogin = this.dme.isLogin();
                lVar.r(isLogin, true);
            }
        }
    }
}
