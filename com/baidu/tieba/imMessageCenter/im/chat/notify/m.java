package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ e bKa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(e eVar) {
        this.bKa = eVar;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        BdListView bdListView;
        ImMessageCenterModel imMessageCenterModel;
        BdListView bdListView2;
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterModel imMessageCenterModel2;
        bdListView = this.bKa.bJQ;
        if (bdListView != null) {
            imMessageCenterModel = this.bKa.bJN;
            if (imMessageCenterModel != null) {
                bdListView2 = this.bKa.bJQ;
                bdListView2.completePullRefresh();
                imMessageCenterListAdapter = this.bKa.bJR;
                imMessageCenterModel2 = this.bKa.bJN;
                imMessageCenterListAdapter.setData(imMessageCenterModel2.getData());
            }
        }
    }
}
