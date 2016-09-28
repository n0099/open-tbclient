package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterListAdapter;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ k dtO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(k kVar) {
        this.dtO = kVar;
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
        bdListView = this.dtO.doW;
        if (bdListView != null) {
            imMessageCenterModel = this.dtO.doT;
            if (imMessageCenterModel != null) {
                bdListView2 = this.dtO.doW;
                bdListView2.l(2000L);
                imMessageCenterModel2 = this.dtO.doT;
                if (imMessageCenterModel2.getData() != null) {
                    imMessageCenterListAdapter = this.dtO.doX;
                    imMessageCenterModel4 = this.dtO.doT;
                    imMessageCenterListAdapter.setData(imMessageCenterModel4.getData());
                }
                imMessageCenterModel3 = this.dtO.doT;
                if (com.baidu.tbadk.core.util.y.t(imMessageCenterModel3.getData())) {
                    k kVar = this.dtO;
                    z = this.dtO.dtM;
                    kVar.t(z, true);
                }
            }
        }
    }
}
