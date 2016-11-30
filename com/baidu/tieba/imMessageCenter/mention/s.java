package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterListAdapter;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ k dzt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(k kVar) {
        this.dzt = kVar;
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
        bdListView = this.dzt.duE;
        if (bdListView != null) {
            imMessageCenterModel = this.dzt.duB;
            if (imMessageCenterModel != null) {
                bdListView2 = this.dzt.duE;
                bdListView2.l(2000L);
                imMessageCenterModel2 = this.dzt.duB;
                if (imMessageCenterModel2.getData() != null) {
                    imMessageCenterListAdapter = this.dzt.duF;
                    imMessageCenterModel4 = this.dzt.duB;
                    imMessageCenterListAdapter.setData(imMessageCenterModel4.getData());
                }
                imMessageCenterModel3 = this.dzt.duB;
                if (com.baidu.tbadk.core.util.x.t(imMessageCenterModel3.getData())) {
                    k kVar = this.dzt;
                    z = this.dzt.dzr;
                    kVar.t(z, true);
                }
            }
        }
    }
}
