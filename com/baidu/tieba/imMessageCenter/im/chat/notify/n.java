package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* loaded from: classes.dex */
class n implements com.baidu.tieba.im.chat.a.a {
    final /* synthetic */ f cZJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(f fVar) {
        this.cZJ = fVar;
    }

    @Override // com.baidu.tieba.im.chat.a.a
    public void onComplete() {
        BdListView bdListView;
        ImMessageCenterModel imMessageCenterModel;
        BdListView bdListView2;
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterModel imMessageCenterModel2;
        bdListView = this.cZJ.cZz;
        if (bdListView != null) {
            imMessageCenterModel = this.cZJ.cZw;
            if (imMessageCenterModel != null) {
                bdListView2 = this.cZJ.cZz;
                bdListView2.l(2000L);
                imMessageCenterListAdapter = this.cZJ.cZA;
                imMessageCenterModel2 = this.cZJ.cZw;
                imMessageCenterListAdapter.setData(imMessageCenterModel2.getData());
            }
        }
    }
}
