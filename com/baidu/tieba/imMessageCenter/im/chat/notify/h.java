package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class h implements c.b {
    final /* synthetic */ f djD;
    private final /* synthetic */ ImMessageCenterShowItemData djE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.djD = fVar;
        this.djE = imMessageCenterShowItemData;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        ImMessageCenterModel imMessageCenterModel;
        com.baidu.tieba.im.chat.a.a aVar;
        cVar.dismiss();
        switch (i) {
            case 0:
                imMessageCenterModel = this.djD.djq;
                ImMessageCenterShowItemData imMessageCenterShowItemData = this.djE;
                aVar = this.djD.cRX;
                imMessageCenterModel.deleteItem(imMessageCenterShowItemData, aVar);
                return;
            default:
                return;
        }
    }
}
