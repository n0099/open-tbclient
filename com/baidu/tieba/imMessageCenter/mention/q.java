package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterListAdapter;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ k ceq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(k kVar) {
        this.ceq = kVar;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        BdListView bdListView;
        ImMessageCenterModel imMessageCenterModel;
        BdListView bdListView2;
        ImMessageCenterModel imMessageCenterModel2;
        boolean z;
        ImMessageCenterModel imMessageCenterModel3;
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterModel imMessageCenterModel4;
        bdListView = this.ceq.bZB;
        if (bdListView != null) {
            imMessageCenterModel = this.ceq.bZy;
            if (imMessageCenterModel != null) {
                bdListView2 = this.ceq.bZB;
                bdListView2.completePullRefresh();
                imMessageCenterModel2 = this.ceq.bZy;
                if (imMessageCenterModel2.getData() != null) {
                    imMessageCenterModel3 = this.ceq.bZy;
                    if (!imMessageCenterModel3.getData().isEmpty()) {
                        imMessageCenterListAdapter = this.ceq.bZC;
                        imMessageCenterModel4 = this.ceq.bZy;
                        imMessageCenterListAdapter.setData(imMessageCenterModel4.getData());
                        return;
                    }
                }
                k kVar = this.ceq;
                z = this.ceq.aRa;
                kVar.i(z, true);
            }
        }
    }
}
