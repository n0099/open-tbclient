package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* loaded from: classes.dex */
class n implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ f dnI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(f fVar) {
        this.dnI = fVar;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        BdListView bdListView;
        ImMessageCenterModel imMessageCenterModel;
        BdListView bdListView2;
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterModel imMessageCenterModel2;
        bdListView = this.dnI.dny;
        if (bdListView != null) {
            imMessageCenterModel = this.dnI.dnv;
            if (imMessageCenterModel != null) {
                bdListView2 = this.dnI.dny;
                bdListView2.l(2000L);
                imMessageCenterListAdapter = this.dnI.dnz;
                imMessageCenterModel2 = this.dnI.dnv;
                imMessageCenterListAdapter.setData(imMessageCenterModel2.getData());
            }
        }
    }
}
