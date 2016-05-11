package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* loaded from: classes.dex */
class n implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ f ctO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(f fVar) {
        this.ctO = fVar;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        BdListView bdListView;
        ImMessageCenterModel imMessageCenterModel;
        BdListView bdListView2;
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterModel imMessageCenterModel2;
        bdListView = this.ctO.ctD;
        if (bdListView != null) {
            imMessageCenterModel = this.ctO.ctA;
            if (imMessageCenterModel != null) {
                bdListView2 = this.ctO.ctD;
                bdListView2.k(2000L);
                imMessageCenterListAdapter = this.ctO.ctE;
                imMessageCenterModel2 = this.ctO.ctA;
                imMessageCenterListAdapter.setData(imMessageCenterModel2.getData());
            }
        }
    }
}
