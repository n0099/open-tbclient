package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements c.b {
    private final /* synthetic */ ImMessageCenterShowItemData dhQ;
    final /* synthetic */ l dkD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(l lVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.dkD = lVar;
        this.dhQ = imMessageCenterShowItemData;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        ImMessageCenterModel imMessageCenterModel;
        com.baidu.tieba.im.chat.a.a aVar;
        cVar.dismiss();
        switch (i) {
            case 0:
                imMessageCenterModel = this.dkD.dhC;
                ImMessageCenterShowItemData imMessageCenterShowItemData = this.dhQ;
                aVar = this.dkD.cQg;
                imMessageCenterModel.deleteItem(imMessageCenterShowItemData, aVar);
                return;
            default:
                return;
        }
    }
}
