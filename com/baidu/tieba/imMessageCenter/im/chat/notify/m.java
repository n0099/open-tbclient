package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ e bGo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(e eVar) {
        this.bGo = eVar;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        BdListView bdListView;
        ImMessageCenterModel imMessageCenterModel;
        BdListView bdListView2;
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterModel imMessageCenterModel2;
        bdListView = this.bGo.bGe;
        if (bdListView != null) {
            imMessageCenterModel = this.bGo.bGb;
            if (imMessageCenterModel != null) {
                bdListView2 = this.bGo.bGe;
                bdListView2.completePullRefresh();
                imMessageCenterListAdapter = this.bGo.bGf;
                imMessageCenterModel2 = this.bGo.bGb;
                imMessageCenterListAdapter.setData(imMessageCenterModel2.getData());
            }
        }
    }
}
