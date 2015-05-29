package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ d bsw;
    private final /* synthetic */ ImMessageCenterShowItemData bsy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(d dVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.bsw = dVar;
        this.bsy = imMessageCenterShowItemData;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        ImMessageCenterModel imMessageCenterModel;
        com.baidu.tieba.im.chat.notify.a aVar;
        eVar.dismiss();
        switch (i) {
            case 0:
                imMessageCenterModel = this.bsw.bsj;
                ImMessageCenterShowItemData imMessageCenterShowItemData = this.bsy;
                aVar = this.bsw.bcA;
                imMessageCenterModel.deleteItem(imMessageCenterShowItemData, aVar);
                return;
            default:
                return;
        }
    }
}
