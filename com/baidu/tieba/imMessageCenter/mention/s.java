package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterListAdapter;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ k cmS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(k kVar) {
        this.cmS = kVar;
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
        bdListView = this.cmS.chZ;
        if (bdListView != null) {
            imMessageCenterModel = this.cmS.chW;
            if (imMessageCenterModel != null) {
                bdListView2 = this.cmS.chZ;
                bdListView2.nr();
                imMessageCenterModel2 = this.cmS.chW;
                if (imMessageCenterModel2.getData() != null) {
                    imMessageCenterModel3 = this.cmS.chW;
                    if (!imMessageCenterModel3.getData().isEmpty()) {
                        imMessageCenterListAdapter = this.cmS.cia;
                        imMessageCenterModel4 = this.cmS.chW;
                        imMessageCenterListAdapter.setData(imMessageCenterModel4.getData());
                        return;
                    }
                }
                k kVar = this.cmS;
                z = this.cmS.aXd;
                kVar.m(z, true);
            }
        }
    }
}
