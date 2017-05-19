package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class h implements c.b {
    final /* synthetic */ f dei;
    private final /* synthetic */ ImMessageCenterShowItemData dej;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.dei = fVar;
        this.dej = imMessageCenterShowItemData;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        ImMessageCenterModel imMessageCenterModel;
        com.baidu.tieba.im.chat.a.a aVar;
        cVar.dismiss();
        switch (i) {
            case 0:
                imMessageCenterModel = this.dei.ddV;
                ImMessageCenterShowItemData imMessageCenterShowItemData = this.dej;
                aVar = this.dei.cMz;
                imMessageCenterModel.deleteItem(imMessageCenterShowItemData, aVar);
                return;
            default:
                return;
        }
    }
}
