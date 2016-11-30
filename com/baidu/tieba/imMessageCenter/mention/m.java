package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements c.b {
    private final /* synthetic */ ImMessageCenterShowItemData duP;
    final /* synthetic */ k dzt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.dzt = kVar;
        this.duP = imMessageCenterShowItemData;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        ImMessageCenterModel imMessageCenterModel;
        com.baidu.tieba.im.chat.notify.a aVar;
        cVar.dismiss();
        switch (i) {
            case 0:
                imMessageCenterModel = this.dzt.duB;
                ImMessageCenterShowItemData imMessageCenterShowItemData = this.duP;
                aVar = this.dzt.ddp;
                imMessageCenterModel.deleteItem(imMessageCenterShowItemData, aVar);
                return;
            default:
                return;
        }
    }
}
