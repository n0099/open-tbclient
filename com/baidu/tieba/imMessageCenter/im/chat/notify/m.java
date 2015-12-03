package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* loaded from: classes.dex */
class m implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ e bZK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(e eVar) {
        this.bZK = eVar;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        BdListView bdListView;
        ImMessageCenterModel imMessageCenterModel;
        BdListView bdListView2;
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterModel imMessageCenterModel2;
        bdListView = this.bZK.bZB;
        if (bdListView != null) {
            imMessageCenterModel = this.bZK.bZy;
            if (imMessageCenterModel != null) {
                bdListView2 = this.bZK.bZB;
                bdListView2.completePullRefresh();
                imMessageCenterListAdapter = this.bZK.bZC;
                imMessageCenterModel2 = this.bZK.bZy;
                imMessageCenterListAdapter.setData(imMessageCenterModel2.getData());
            }
        }
    }
}
