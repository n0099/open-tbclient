package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterListAdapter;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ k cys;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(k kVar) {
        this.cys = kVar;
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
        bdListView = this.cys.ctD;
        if (bdListView != null) {
            imMessageCenterModel = this.cys.ctA;
            if (imMessageCenterModel != null) {
                bdListView2 = this.cys.ctD;
                bdListView2.k(2000L);
                imMessageCenterModel2 = this.cys.ctA;
                if (imMessageCenterModel2.getData() != null) {
                    imMessageCenterListAdapter = this.cys.ctE;
                    imMessageCenterModel4 = this.cys.ctA;
                    imMessageCenterListAdapter.setData(imMessageCenterModel4.getData());
                }
                imMessageCenterModel3 = this.cys.ctA;
                if (com.baidu.tbadk.core.util.y.s(imMessageCenterModel3.getData())) {
                    k kVar = this.cys;
                    z = this.cys.aXV;
                    kVar.n(z, true);
                }
            }
        }
    }
}
