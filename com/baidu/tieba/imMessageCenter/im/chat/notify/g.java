package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements c.b {
    final /* synthetic */ e bGo;
    private final /* synthetic */ ImMessageCenterShowItemData bGp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.bGo = eVar;
        this.bGp = imMessageCenterShowItemData;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        ImMessageCenterModel imMessageCenterModel;
        com.baidu.tieba.im.chat.notify.a aVar;
        cVar.dismiss();
        switch (i) {
            case 0:
                imMessageCenterModel = this.bGo.bGb;
                ImMessageCenterShowItemData imMessageCenterShowItemData = this.bGp;
                aVar = this.bGo.bqv;
                imMessageCenterModel.deleteItem(imMessageCenterShowItemData, aVar);
                return;
            default:
                return;
        }
    }
}
