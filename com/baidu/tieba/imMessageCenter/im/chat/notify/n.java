package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* loaded from: classes.dex */
class n implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ f dca;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(f fVar) {
        this.dca = fVar;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        BdListView bdListView;
        ImMessageCenterModel imMessageCenterModel;
        BdListView bdListView2;
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterModel imMessageCenterModel2;
        bdListView = this.dca.dbQ;
        if (bdListView != null) {
            imMessageCenterModel = this.dca.dbN;
            if (imMessageCenterModel != null) {
                bdListView2 = this.dca.dbQ;
                bdListView2.l(2000L);
                imMessageCenterListAdapter = this.dca.dbR;
                imMessageCenterModel2 = this.dca.dbN;
                imMessageCenterListAdapter.setData(imMessageCenterModel2.getData());
            }
        }
    }
}
