package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ d bpR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(d dVar) {
        this.bpR = dVar;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        BdListView bdListView;
        ImMessageCenterModel imMessageCenterModel;
        BdListView bdListView2;
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterModel imMessageCenterModel2;
        bdListView = this.bpR.bpG;
        if (bdListView != null) {
            imMessageCenterModel = this.bpR.bpD;
            if (imMessageCenterModel != null) {
                bdListView2 = this.bpR.bpG;
                bdListView2.mW();
                imMessageCenterListAdapter = this.bpR.bpH;
                imMessageCenterModel2 = this.bpR.bpD;
                imMessageCenterListAdapter.setData(imMessageCenterModel2.getData());
            }
        }
    }
}
