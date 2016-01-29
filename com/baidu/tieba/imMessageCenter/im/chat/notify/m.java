package com.baidu.tieba.imMessageCenter.im.chat.notify;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* loaded from: classes.dex */
class m implements com.baidu.tieba.im.chat.notify.a {
    final /* synthetic */ e cil;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(e eVar) {
        this.cil = eVar;
    }

    @Override // com.baidu.tieba.im.chat.notify.a
    public void onComplete() {
        BdListView bdListView;
        ImMessageCenterModel imMessageCenterModel;
        BdListView bdListView2;
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterModel imMessageCenterModel2;
        bdListView = this.cil.chZ;
        if (bdListView != null) {
            imMessageCenterModel = this.cil.chW;
            if (imMessageCenterModel != null) {
                bdListView2 = this.cil.chZ;
                bdListView2.nr();
                imMessageCenterListAdapter = this.cil.cia;
                imMessageCenterModel2 = this.cil.chW;
                imMessageCenterListAdapter.setData(imMessageCenterModel2.getData());
            }
        }
    }
}
