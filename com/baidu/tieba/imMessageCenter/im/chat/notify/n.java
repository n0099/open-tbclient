package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* loaded from: classes2.dex */
class n implements com.baidu.tieba.im.chat.a.a {
    final /* synthetic */ f dei;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(f fVar) {
        this.dei = fVar;
    }

    @Override // com.baidu.tieba.im.chat.a.a
    public void onComplete() {
        BdListView bdListView;
        ImMessageCenterModel imMessageCenterModel;
        BdListView bdListView2;
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterModel imMessageCenterModel2;
        bdListView = this.dei.ddY;
        if (bdListView != null) {
            imMessageCenterModel = this.dei.ddV;
            if (imMessageCenterModel != null) {
                bdListView2 = this.dei.ddY;
                bdListView2.completePullRefreshPostDelayed(2000L);
                imMessageCenterListAdapter = this.dei.ddZ;
                imMessageCenterModel2 = this.dei.ddV;
                imMessageCenterListAdapter.setData(imMessageCenterModel2.getData());
            }
        }
    }
}
