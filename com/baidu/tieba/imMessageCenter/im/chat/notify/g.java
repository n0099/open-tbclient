package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements c.b {
    final /* synthetic */ e bGV;
    private final /* synthetic */ ImMessageCenterShowItemData bGW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.bGV = eVar;
        this.bGW = imMessageCenterShowItemData;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        ImMessageCenterModel imMessageCenterModel;
        com.baidu.tieba.im.chat.notify.a aVar;
        cVar.dismiss();
        switch (i) {
            case 0:
                imMessageCenterModel = this.bGV.bGI;
                ImMessageCenterShowItemData imMessageCenterShowItemData = this.bGW;
                aVar = this.bGV.bqT;
                imMessageCenterModel.deleteItem(imMessageCenterShowItemData, aVar);
                return;
            default:
                return;
        }
    }
}
