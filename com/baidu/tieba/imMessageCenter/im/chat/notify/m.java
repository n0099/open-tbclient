package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ e bGV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(e eVar) {
        this.bGV = eVar;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        BdListView bdListView;
        ImMessageCenterModel imMessageCenterModel;
        BdListView bdListView2;
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterModel imMessageCenterModel2;
        bdListView = this.bGV.bGL;
        if (bdListView != null) {
            imMessageCenterModel = this.bGV.bGI;
            if (imMessageCenterModel != null) {
                bdListView2 = this.bGV.bGL;
                bdListView2.completePullRefresh();
                imMessageCenterListAdapter = this.bGV.bGM;
                imMessageCenterModel2 = this.bGV.bGI;
                imMessageCenterListAdapter.setData(imMessageCenterModel2.getData());
            }
        }
    }
}
