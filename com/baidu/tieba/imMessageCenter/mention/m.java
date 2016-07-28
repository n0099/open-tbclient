package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements c.b {
    private final /* synthetic */ ImMessageCenterShowItemData dcb;
    final /* synthetic */ k dgL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.dgL = kVar;
        this.dcb = imMessageCenterShowItemData;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        ImMessageCenterModel imMessageCenterModel;
        com.baidu.tieba.im.chat.notify.a aVar;
        cVar.dismiss();
        switch (i) {
            case 0:
                imMessageCenterModel = this.dgL.dbN;
                ImMessageCenterShowItemData imMessageCenterShowItemData = this.dcb;
                aVar = this.dgL.cKB;
                imMessageCenterModel.deleteItem(imMessageCenterShowItemData, aVar);
                return;
            default:
                return;
        }
    }
}
