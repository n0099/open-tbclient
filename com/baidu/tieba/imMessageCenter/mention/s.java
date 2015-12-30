package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterListAdapter;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ k cis;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(k kVar) {
        this.cis = kVar;
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
        bdListView = this.cis.cdB;
        if (bdListView != null) {
            imMessageCenterModel = this.cis.cdy;
            if (imMessageCenterModel != null) {
                bdListView2 = this.cis.cdB;
                bdListView2.completePullRefresh();
                imMessageCenterModel2 = this.cis.cdy;
                if (imMessageCenterModel2.getData() != null) {
                    imMessageCenterModel3 = this.cis.cdy;
                    if (!imMessageCenterModel3.getData().isEmpty()) {
                        imMessageCenterListAdapter = this.cis.cdC;
                        imMessageCenterModel4 = this.cis.cdy;
                        imMessageCenterListAdapter.setData(imMessageCenterModel4.getData());
                        return;
                    }
                }
                k kVar = this.cis;
                z = this.cis.aUR;
                kVar.k(z, true);
            }
        }
    }
}
