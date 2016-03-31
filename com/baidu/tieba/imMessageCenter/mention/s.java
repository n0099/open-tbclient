package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterListAdapter;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ k cxu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(k kVar) {
        this.cxu = kVar;
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
        bdListView = this.cxu.csF;
        if (bdListView != null) {
            imMessageCenterModel = this.cxu.csC;
            if (imMessageCenterModel != null) {
                bdListView2 = this.cxu.csF;
                bdListView2.nj();
                imMessageCenterModel2 = this.cxu.csC;
                if (imMessageCenterModel2.getData() != null) {
                    imMessageCenterModel3 = this.cxu.csC;
                    if (!imMessageCenterModel3.getData().isEmpty()) {
                        imMessageCenterListAdapter = this.cxu.csG;
                        imMessageCenterModel4 = this.cxu.csC;
                        imMessageCenterListAdapter.setData(imMessageCenterModel4.getData());
                        return;
                    }
                }
                k kVar = this.cxu;
                z = this.cxu.bbM;
                kVar.o(z, true);
            }
        }
    }
}
