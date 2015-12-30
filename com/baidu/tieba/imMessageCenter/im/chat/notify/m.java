package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* loaded from: classes.dex */
class m implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ e cdL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(e eVar) {
        this.cdL = eVar;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        BdListView bdListView;
        ImMessageCenterModel imMessageCenterModel;
        BdListView bdListView2;
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterModel imMessageCenterModel2;
        bdListView = this.cdL.cdB;
        if (bdListView != null) {
            imMessageCenterModel = this.cdL.cdy;
            if (imMessageCenterModel != null) {
                bdListView2 = this.cdL.cdB;
                bdListView2.completePullRefresh();
                imMessageCenterListAdapter = this.cdL.cdC;
                imMessageCenterModel2 = this.cdL.cdy;
                imMessageCenterListAdapter.setData(imMessageCenterModel2.getData());
            }
        }
    }
}
