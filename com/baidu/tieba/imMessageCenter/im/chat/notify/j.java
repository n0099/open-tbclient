package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ d bpB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(d dVar) {
        this.bpB = dVar;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        BdListView bdListView;
        ImMessageCenterModel imMessageCenterModel;
        BdListView bdListView2;
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterModel imMessageCenterModel2;
        bdListView = this.bpB.bpq;
        if (bdListView != null) {
            imMessageCenterModel = this.bpB.bpn;
            if (imMessageCenterModel != null) {
                bdListView2 = this.bpB.bpq;
                bdListView2.mW();
                imMessageCenterListAdapter = this.bpB.bpr;
                imMessageCenterModel2 = this.bpB.bpn;
                imMessageCenterListAdapter.setData(imMessageCenterModel2.getData());
            }
        }
    }
}
