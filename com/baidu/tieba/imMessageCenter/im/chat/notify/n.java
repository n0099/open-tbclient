package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* loaded from: classes.dex */
class n implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ f duO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(f fVar) {
        this.duO = fVar;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        BdListView bdListView;
        ImMessageCenterModel imMessageCenterModel;
        BdListView bdListView2;
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterModel imMessageCenterModel2;
        bdListView = this.duO.duE;
        if (bdListView != null) {
            imMessageCenterModel = this.duO.duB;
            if (imMessageCenterModel != null) {
                bdListView2 = this.duO.duE;
                bdListView2.l(2000L);
                imMessageCenterListAdapter = this.duO.duF;
                imMessageCenterModel2 = this.duO.duB;
                imMessageCenterListAdapter.setData(imMessageCenterModel2.getData());
            }
        }
    }
}
