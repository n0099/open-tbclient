package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ d bsx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(d dVar) {
        this.bsx = dVar;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        BdListView bdListView;
        ImMessageCenterModel imMessageCenterModel;
        BdListView bdListView2;
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterModel imMessageCenterModel2;
        bdListView = this.bsx.bsn;
        if (bdListView != null) {
            imMessageCenterModel = this.bsx.bsk;
            if (imMessageCenterModel != null) {
                bdListView2 = this.bsx.bsn;
                bdListView2.completePullRefresh();
                imMessageCenterListAdapter = this.bsx.bso;
                imMessageCenterModel2 = this.bsx.bsk;
                imMessageCenterListAdapter.setData(imMessageCenterModel2.getData());
            }
        }
    }
}
