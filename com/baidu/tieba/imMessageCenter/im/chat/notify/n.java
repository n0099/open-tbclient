package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* loaded from: classes.dex */
class n implements com.baidu.tieba.im.chat.a.a {
    final /* synthetic */ f dkg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(f fVar) {
        this.dkg = fVar;
    }

    @Override // com.baidu.tieba.im.chat.a.a
    public void onComplete() {
        BdListView bdListView;
        ImMessageCenterModel imMessageCenterModel;
        BdListView bdListView2;
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterModel imMessageCenterModel2;
        bdListView = this.dkg.djW;
        if (bdListView != null) {
            imMessageCenterModel = this.dkg.djT;
            if (imMessageCenterModel != null) {
                bdListView2 = this.dkg.djW;
                bdListView2.completePullRefreshPostDelayed(2000L);
                imMessageCenterListAdapter = this.dkg.djX;
                imMessageCenterModel2 = this.dkg.djT;
                imMessageCenterListAdapter.setData(imMessageCenterModel2.getData());
            }
        }
    }
}
