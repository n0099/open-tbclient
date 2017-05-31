package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* loaded from: classes2.dex */
class n implements com.baidu.tieba.im.chat.a.a {
    final /* synthetic */ f djD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(f fVar) {
        this.djD = fVar;
    }

    @Override // com.baidu.tieba.im.chat.a.a
    public void onComplete() {
        BdListView bdListView;
        ImMessageCenterModel imMessageCenterModel;
        BdListView bdListView2;
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterModel imMessageCenterModel2;
        bdListView = this.djD.djt;
        if (bdListView != null) {
            imMessageCenterModel = this.djD.djq;
            if (imMessageCenterModel != null) {
                bdListView2 = this.djD.djt;
                bdListView2.completePullRefreshPostDelayed(2000L);
                imMessageCenterListAdapter = this.djD.dju;
                imMessageCenterModel2 = this.djD.djq;
                imMessageCenterListAdapter.setData(imMessageCenterModel2.getData());
            }
        }
    }
}
