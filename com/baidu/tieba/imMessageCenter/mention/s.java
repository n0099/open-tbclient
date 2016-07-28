package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterListAdapter;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ k dgL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(k kVar) {
        this.dgL = kVar;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        BdListView bdListView;
        ImMessageCenterModel imMessageCenterModel;
        BdListView bdListView2;
        ImMessageCenterModel imMessageCenterModel2;
        ImMessageCenterModel imMessageCenterModel3;
        boolean z;
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterModel imMessageCenterModel4;
        bdListView = this.dgL.dbQ;
        if (bdListView != null) {
            imMessageCenterModel = this.dgL.dbN;
            if (imMessageCenterModel != null) {
                bdListView2 = this.dgL.dbQ;
                bdListView2.l(2000L);
                imMessageCenterModel2 = this.dgL.dbN;
                if (imMessageCenterModel2.getData() != null) {
                    imMessageCenterListAdapter = this.dgL.dbR;
                    imMessageCenterModel4 = this.dgL.dbN;
                    imMessageCenterListAdapter.setData(imMessageCenterModel4.getData());
                }
                imMessageCenterModel3 = this.dgL.dbN;
                if (com.baidu.tbadk.core.util.y.t(imMessageCenterModel3.getData())) {
                    k kVar = this.dgL;
                    z = this.dgL.dgJ;
                    kVar.o(z, true);
                }
            }
        }
    }
}
