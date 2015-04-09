package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ d bpR;
    private final /* synthetic */ ImMessageCenterShowItemData bpT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(d dVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.bpR = dVar;
        this.bpT = imMessageCenterShowItemData;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        ImMessageCenterModel imMessageCenterModel;
        com.baidu.tieba.im.chat.notify.a aVar;
        eVar.dismiss();
        switch (i) {
            case 0:
                imMessageCenterModel = this.bpR.bpD;
                ImMessageCenterShowItemData imMessageCenterShowItemData = this.bpT;
                aVar = this.bpR.aZT;
                imMessageCenterModel.deleteItem(imMessageCenterShowItemData, aVar);
                return;
            default:
                return;
        }
    }
}
