package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ d bsw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(d dVar) {
        this.bsw = dVar;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        BdListView bdListView;
        ImMessageCenterModel imMessageCenterModel;
        BdListView bdListView2;
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterModel imMessageCenterModel2;
        bdListView = this.bsw.bsm;
        if (bdListView != null) {
            imMessageCenterModel = this.bsw.bsj;
            if (imMessageCenterModel != null) {
                bdListView2 = this.bsw.bsm;
                bdListView2.completePullRefresh();
                imMessageCenterListAdapter = this.bsw.bsn;
                imMessageCenterModel2 = this.bsw.bsj;
                imMessageCenterListAdapter.setData(imMessageCenterModel2.getData());
            }
        }
    }
}
