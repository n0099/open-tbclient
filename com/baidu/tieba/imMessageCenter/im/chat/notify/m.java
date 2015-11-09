package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ e bKG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(e eVar) {
        this.bKG = eVar;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        BdListView bdListView;
        ImMessageCenterModel imMessageCenterModel;
        BdListView bdListView2;
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterModel imMessageCenterModel2;
        bdListView = this.bKG.bKw;
        if (bdListView != null) {
            imMessageCenterModel = this.bKG.bKt;
            if (imMessageCenterModel != null) {
                bdListView2 = this.bKG.bKw;
                bdListView2.completePullRefresh();
                imMessageCenterListAdapter = this.bKG.bKx;
                imMessageCenterModel2 = this.bKG.bKt;
                imMessageCenterListAdapter.setData(imMessageCenterModel2.getData());
            }
        }
    }
}
