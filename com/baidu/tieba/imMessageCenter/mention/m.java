package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements c.b {
    private final /* synthetic */ ImMessageCenterShowItemData csR;
    final /* synthetic */ k cxu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.cxu = kVar;
        this.csR = imMessageCenterShowItemData;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        ImMessageCenterModel imMessageCenterModel;
        com.baidu.tieba.im.chat.notify.a aVar;
        cVar.dismiss();
        switch (i) {
            case 0:
                imMessageCenterModel = this.cxu.csC;
                ImMessageCenterShowItemData imMessageCenterShowItemData = this.csR;
                aVar = this.cxu.cbL;
                imMessageCenterModel.deleteItem(imMessageCenterShowItemData, aVar);
                return;
            default:
                return;
        }
    }
}
