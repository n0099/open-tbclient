package com.baidu.tieba.im.stranger;

import android.content.DialogInterface;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class k implements DialogInterface.OnClickListener {
    final /* synthetic */ StrangerListActivity a;
    private final /* synthetic */ int b;
    private final /* synthetic */ ImMessageCenterShowItemData c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(StrangerListActivity strangerListActivity, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.a = strangerListActivity;
        this.b = i;
        this.c = imMessageCenterShowItemData;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        o oVar;
        com.baidu.tieba.im.a<Void> aVar;
        o oVar2;
        l lVar;
        if (this.b == 1) {
            oVar2 = this.a.c;
            lVar = this.a.j;
            oVar2.a(lVar);
            return;
        }
        oVar = this.a.c;
        ImMessageCenterShowItemData imMessageCenterShowItemData = this.c;
        aVar = this.a.f;
        oVar.a(imMessageCenterShowItemData, aVar);
    }
}
