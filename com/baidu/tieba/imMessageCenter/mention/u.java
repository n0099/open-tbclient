package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements c.b {
    private final /* synthetic */ ImMessageCenterShowItemData cZK;
    final /* synthetic */ o dcz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(o oVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.dcz = oVar;
        this.cZK = imMessageCenterShowItemData;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        ImMessageCenterModel imMessageCenterModel;
        com.baidu.tieba.im.chat.a.a aVar;
        cVar.dismiss();
        switch (i) {
            case 0:
                imMessageCenterModel = this.dcz.cZw;
                ImMessageCenterShowItemData imMessageCenterShowItemData = this.cZK;
                aVar = this.dcz.cIl;
                imMessageCenterModel.deleteItem(imMessageCenterShowItemData, aVar);
                return;
            default:
                return;
        }
    }
}
