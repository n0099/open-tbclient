package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.imMessageCenter.im.chat.notify.MessageAggregationListAdapter;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class y implements com.baidu.tieba.im.chat.a.a {
    final /* synthetic */ l dmu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(l lVar) {
        this.dmu = lVar;
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
        bdListView = this.dmu.djt;
        if (bdListView != null) {
            imMessageCenterModel = this.dmu.djq;
            if (imMessageCenterModel != null) {
                bdListView2 = this.dmu.djt;
                bdListView2.completePullRefreshPostDelayed(2000L);
                imMessageCenterModel2 = this.dmu.djq;
                if (imMessageCenterModel2.getData() != null) {
                    messageAggregationListAdapter = this.dmu.dmn;
                    imMessageCenterModel3 = this.dmu.djq;
                    messageAggregationListAdapter.setData(imMessageCenterModel3.getData());
                    return;
                }
                l lVar = this.dmu;
                isLogin = this.dmu.isLogin();
                lVar.u(isLogin, true);
            }
        }
    }
}
