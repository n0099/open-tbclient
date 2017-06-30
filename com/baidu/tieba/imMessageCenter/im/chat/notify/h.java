package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class h implements c.b {
    private final /* synthetic */ ImMessageCenterShowItemData drA;
    final /* synthetic */ f drz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.drz = fVar;
        this.drA = imMessageCenterShowItemData;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        ImMessageCenterModel imMessageCenterModel;
        com.baidu.tieba.im.chat.a.a aVar;
        cVar.dismiss();
        switch (i) {
            case 0:
                imMessageCenterModel = this.drz.drm;
                ImMessageCenterShowItemData imMessageCenterShowItemData = this.drA;
                aVar = this.drz.cZT;
                imMessageCenterModel.deleteItem(imMessageCenterShowItemData, aVar);
                return;
            default:
                return;
        }
    }
}
