package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class r implements c.b {
    private final /* synthetic */ ImMessageCenterShowItemData djE;
    final /* synthetic */ l dmu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(l lVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.dmu = lVar;
        this.djE = imMessageCenterShowItemData;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        ImMessageCenterModel imMessageCenterModel;
        com.baidu.tieba.im.chat.a.a aVar;
        cVar.dismiss();
        switch (i) {
            case 0:
                imMessageCenterModel = this.dmu.djq;
                ImMessageCenterShowItemData imMessageCenterShowItemData = this.djE;
                aVar = this.dmu.cRX;
                imMessageCenterModel.deleteItem(imMessageCenterShowItemData, aVar);
                return;
            default:
                return;
        }
    }
}
