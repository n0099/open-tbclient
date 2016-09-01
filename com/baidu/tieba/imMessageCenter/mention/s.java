package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterListAdapter;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ k dsr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(k kVar) {
        this.dsr = kVar;
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
        bdListView = this.dsr.dny;
        if (bdListView != null) {
            imMessageCenterModel = this.dsr.dnv;
            if (imMessageCenterModel != null) {
                bdListView2 = this.dsr.dny;
                bdListView2.l(2000L);
                imMessageCenterModel2 = this.dsr.dnv;
                if (imMessageCenterModel2.getData() != null) {
                    imMessageCenterListAdapter = this.dsr.dnz;
                    imMessageCenterModel4 = this.dsr.dnv;
                    imMessageCenterListAdapter.setData(imMessageCenterModel4.getData());
                }
                imMessageCenterModel3 = this.dsr.dnv;
                if (com.baidu.tbadk.core.util.y.t(imMessageCenterModel3.getData())) {
                    k kVar = this.dsr;
                    z = this.dsr.dsp;
                    kVar.r(z, true);
                }
            }
        }
    }
}
