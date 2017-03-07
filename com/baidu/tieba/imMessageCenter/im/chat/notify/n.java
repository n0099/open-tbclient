package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* loaded from: classes.dex */
class n implements com.baidu.tieba.im.chat.a.a {
    final /* synthetic */ f djq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(f fVar) {
        this.djq = fVar;
    }

    @Override // com.baidu.tieba.im.chat.a.a
    public void onComplete() {
        BdListView bdListView;
        ImMessageCenterModel imMessageCenterModel;
        BdListView bdListView2;
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterModel imMessageCenterModel2;
        bdListView = this.djq.djg;
        if (bdListView != null) {
            imMessageCenterModel = this.djq.djd;
            if (imMessageCenterModel != null) {
                bdListView2 = this.djq.djg;
                bdListView2.completePullRefreshPostDelayed(2000L);
                imMessageCenterListAdapter = this.djq.djh;
                imMessageCenterModel2 = this.djq.djd;
                imMessageCenterListAdapter.setData(imMessageCenterModel2.getData());
            }
        }
    }
}
