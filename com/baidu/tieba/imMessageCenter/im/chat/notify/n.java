package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* loaded from: classes.dex */
class n implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ f csQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(f fVar) {
        this.csQ = fVar;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        BdListView bdListView;
        ImMessageCenterModel imMessageCenterModel;
        BdListView bdListView2;
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterModel imMessageCenterModel2;
        bdListView = this.csQ.csF;
        if (bdListView != null) {
            imMessageCenterModel = this.csQ.csC;
            if (imMessageCenterModel != null) {
                bdListView2 = this.csQ.csF;
                bdListView2.nj();
                imMessageCenterListAdapter = this.csQ.csG;
                imMessageCenterModel2 = this.csQ.csC;
                imMessageCenterListAdapter.setData(imMessageCenterModel2.getData());
            }
        }
    }
}
