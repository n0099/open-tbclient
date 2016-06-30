package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements c.b {
    final /* synthetic */ f cZd;
    private final /* synthetic */ ImMessageCenterShowItemData cZe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.cZd = fVar;
        this.cZe = imMessageCenterShowItemData;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        ImMessageCenterModel imMessageCenterModel;
        com.baidu.tieba.im.chat.notify.a aVar;
        cVar.dismiss();
        switch (i) {
            case 0:
                imMessageCenterModel = this.cZd.cYQ;
                ImMessageCenterShowItemData imMessageCenterShowItemData = this.cZe;
                aVar = this.cZd.cHM;
                imMessageCenterModel.deleteItem(imMessageCenterShowItemData, aVar);
                return;
            default:
                return;
        }
    }
}
