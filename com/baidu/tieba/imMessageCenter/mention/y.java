package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.imMessageCenter.im.chat.notify.MessageAggregationListAdapter;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class y implements com.baidu.tieba.im.chat.a.a {
    final /* synthetic */ l dgY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(l lVar) {
        this.dgY = lVar;
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
        bdListView = this.dgY.ddY;
        if (bdListView != null) {
            imMessageCenterModel = this.dgY.ddV;
            if (imMessageCenterModel != null) {
                bdListView2 = this.dgY.ddY;
                bdListView2.completePullRefreshPostDelayed(2000L);
                imMessageCenterModel2 = this.dgY.ddV;
                if (imMessageCenterModel2.getData() != null) {
                    messageAggregationListAdapter = this.dgY.dgR;
                    imMessageCenterModel3 = this.dgY.ddV;
                    messageAggregationListAdapter.setData(imMessageCenterModel3.getData());
                    return;
                }
                l lVar = this.dgY;
                isLogin = this.dgY.isLogin();
                lVar.r(isLogin, true);
            }
        }
    }
}
