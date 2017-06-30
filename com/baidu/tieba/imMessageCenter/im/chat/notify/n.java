package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* loaded from: classes2.dex */
class n implements com.baidu.tieba.im.chat.a.a {
    final /* synthetic */ f drz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(f fVar) {
        this.drz = fVar;
    }

    @Override // com.baidu.tieba.im.chat.a.a
    public void onComplete() {
        BdListView bdListView;
        ImMessageCenterModel imMessageCenterModel;
        BdListView bdListView2;
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterModel imMessageCenterModel2;
        bdListView = this.drz.drp;
        if (bdListView != null) {
            imMessageCenterModel = this.drz.drm;
            if (imMessageCenterModel != null) {
                bdListView2 = this.drz.drp;
                bdListView2.completePullRefreshPostDelayed(2000L);
                imMessageCenterListAdapter = this.drz.drq;
                imMessageCenterModel2 = this.drz.drm;
                imMessageCenterListAdapter.setData(imMessageCenterModel2.getData());
            }
        }
    }
}
