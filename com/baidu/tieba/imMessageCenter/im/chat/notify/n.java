package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* loaded from: classes.dex */
class n implements com.baidu.tieba.im.chat.a.a {
    final /* synthetic */ f dgY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(f fVar) {
        this.dgY = fVar;
    }

    @Override // com.baidu.tieba.im.chat.a.a
    public void onComplete() {
        BdListView bdListView;
        ImMessageCenterModel imMessageCenterModel;
        BdListView bdListView2;
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterModel imMessageCenterModel2;
        bdListView = this.dgY.dgO;
        if (bdListView != null) {
            imMessageCenterModel = this.dgY.dgL;
            if (imMessageCenterModel != null) {
                bdListView2 = this.dgY.dgO;
                bdListView2.completePullRefreshPostDelayed(2000L);
                imMessageCenterListAdapter = this.dgY.dgP;
                imMessageCenterModel2 = this.dgY.dgL;
                imMessageCenterListAdapter.setData(imMessageCenterModel2.getData());
            }
        }
    }
}
