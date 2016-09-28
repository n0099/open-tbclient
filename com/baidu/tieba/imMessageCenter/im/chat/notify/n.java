package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* loaded from: classes.dex */
class n implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ f dpg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(f fVar) {
        this.dpg = fVar;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        BdListView bdListView;
        ImMessageCenterModel imMessageCenterModel;
        BdListView bdListView2;
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterModel imMessageCenterModel2;
        bdListView = this.dpg.doW;
        if (bdListView != null) {
            imMessageCenterModel = this.dpg.doT;
            if (imMessageCenterModel != null) {
                bdListView2 = this.dpg.doW;
                bdListView2.l(2000L);
                imMessageCenterListAdapter = this.dpg.doX;
                imMessageCenterModel2 = this.dpg.doT;
                imMessageCenterListAdapter.setData(imMessageCenterModel2.getData());
            }
        }
    }
}
