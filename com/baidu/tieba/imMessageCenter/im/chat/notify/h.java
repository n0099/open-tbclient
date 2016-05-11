package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements c.b {
    final /* synthetic */ f ctO;
    private final /* synthetic */ ImMessageCenterShowItemData ctP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.ctO = fVar;
        this.ctP = imMessageCenterShowItemData;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        ImMessageCenterModel imMessageCenterModel;
        com.baidu.tieba.im.chat.notify.a aVar;
        cVar.dismiss();
        switch (i) {
            case 0:
                imMessageCenterModel = this.ctO.ctA;
                ImMessageCenterShowItemData imMessageCenterShowItemData = this.ctP;
                aVar = this.ctO.ccq;
                imMessageCenterModel.deleteItem(imMessageCenterShowItemData, aVar);
                return;
            default:
                return;
        }
    }
}
