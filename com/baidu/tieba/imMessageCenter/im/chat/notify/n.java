package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ d bsx;
    private final /* synthetic */ ImMessageCenterShowItemData bsz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(d dVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.bsx = dVar;
        this.bsz = imMessageCenterShowItemData;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void itemClick(com.baidu.tbadk.core.dialog.e eVar, int i, View view) {
        ImMessageCenterModel imMessageCenterModel;
        com.baidu.tieba.im.chat.notify.a aVar;
        eVar.dismiss();
        switch (i) {
            case 0:
                imMessageCenterModel = this.bsx.bsk;
                ImMessageCenterShowItemData imMessageCenterShowItemData = this.bsz;
                aVar = this.bsx.bcB;
                imMessageCenterModel.deleteItem(imMessageCenterShowItemData, aVar);
                return;
            default:
                return;
        }
    }
}
