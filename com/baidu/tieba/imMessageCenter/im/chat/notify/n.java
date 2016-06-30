package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* loaded from: classes.dex */
class n implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ f cZd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(f fVar) {
        this.cZd = fVar;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        BdListView bdListView;
        ImMessageCenterModel imMessageCenterModel;
        BdListView bdListView2;
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterModel imMessageCenterModel2;
        bdListView = this.cZd.cYT;
        if (bdListView != null) {
            imMessageCenterModel = this.cZd.cYQ;
            if (imMessageCenterModel != null) {
                bdListView2 = this.cZd.cYT;
                bdListView2.k(2000L);
                imMessageCenterListAdapter = this.cZd.cYU;
                imMessageCenterModel2 = this.cZd.cYQ;
                imMessageCenterListAdapter.setData(imMessageCenterModel2.getData());
            }
        }
    }
}
