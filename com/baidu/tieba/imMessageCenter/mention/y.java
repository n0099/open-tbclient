package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.imMessageCenter.im.chat.notify.MessageAggregationListAdapter;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class y implements com.baidu.tieba.im.chat.a.a {
    final /* synthetic */ l duq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(l lVar) {
        this.duq = lVar;
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
        bdListView = this.duq.drp;
        if (bdListView != null) {
            imMessageCenterModel = this.duq.drm;
            if (imMessageCenterModel != null) {
                bdListView2 = this.duq.drp;
                bdListView2.completePullRefreshPostDelayed(2000L);
                imMessageCenterModel2 = this.duq.drm;
                if (imMessageCenterModel2.getData() != null) {
                    messageAggregationListAdapter = this.duq.duj;
                    imMessageCenterModel3 = this.duq.drm;
                    messageAggregationListAdapter.setData(imMessageCenterModel3.getData());
                    return;
                }
                l lVar = this.duq;
                isLogin = this.duq.isLogin();
                lVar.v(isLogin, true);
            }
        }
    }
}
