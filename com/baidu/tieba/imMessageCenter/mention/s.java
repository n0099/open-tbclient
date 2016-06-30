package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterListAdapter;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ k ddP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(k kVar) {
        this.ddP = kVar;
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
        bdListView = this.ddP.cYT;
        if (bdListView != null) {
            imMessageCenterModel = this.ddP.cYQ;
            if (imMessageCenterModel != null) {
                bdListView2 = this.ddP.cYT;
                bdListView2.k(2000L);
                imMessageCenterModel2 = this.ddP.cYQ;
                if (imMessageCenterModel2.getData() != null) {
                    imMessageCenterListAdapter = this.ddP.cYU;
                    imMessageCenterModel4 = this.ddP.cYQ;
                    imMessageCenterListAdapter.setData(imMessageCenterModel4.getData());
                }
                imMessageCenterModel3 = this.ddP.cYQ;
                if (com.baidu.tbadk.core.util.y.t(imMessageCenterModel3.getData())) {
                    k kVar = this.ddP;
                    z = this.ddP.ddN;
                    kVar.o(z, true);
                }
            }
        }
    }
}
