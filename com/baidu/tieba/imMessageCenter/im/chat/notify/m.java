package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ d bpB;
    private final /* synthetic */ ImMessageCenterShowItemData bpD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(d dVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.bpB = dVar;
        this.bpD = imMessageCenterShowItemData;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        ImMessageCenterModel imMessageCenterModel;
        com.baidu.tieba.im.chat.notify.a aVar;
        eVar.dismiss();
        switch (i) {
            case 0:
                imMessageCenterModel = this.bpB.bpn;
                ImMessageCenterShowItemData imMessageCenterShowItemData = this.bpD;
                aVar = this.bpB.aZD;
                imMessageCenterModel.deleteItem(imMessageCenterShowItemData, aVar);
                return;
            default:
                return;
        }
    }
}
