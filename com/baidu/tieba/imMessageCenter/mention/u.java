package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements c.b {
    private final /* synthetic */ ImMessageCenterShowItemData bZL;
    final /* synthetic */ k ceq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(k kVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.ceq = kVar;
        this.bZL = imMessageCenterShowItemData;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        ImMessageCenterModel imMessageCenterModel;
        com.baidu.tieba.im.chat.notify.a aVar;
        cVar.dismiss();
        switch (i) {
            case 0:
                imMessageCenterModel = this.ceq.bZy;
                ImMessageCenterShowItemData imMessageCenterShowItemData = this.bZL;
                aVar = this.ceq.bJK;
                imMessageCenterModel.deleteItem(imMessageCenterShowItemData, aVar);
                return;
            default:
                return;
        }
    }
}
