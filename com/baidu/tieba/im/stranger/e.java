package com.baidu.tieba.im.stranger;

import android.content.DialogInterface;
import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class e implements DialogInterface.OnClickListener {
    final /* synthetic */ StrangerListActivity a;
    private final /* synthetic */ int b;
    private final /* synthetic */ ImMessageCenterShowItemData c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(StrangerListActivity strangerListActivity, int i, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.a = strangerListActivity;
        this.b = i;
        this.c = imMessageCenterShowItemData;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        h hVar;
        com.baidu.tieba.im.chat.notify.a aVar;
        h hVar2;
        if (this.b == 1) {
            hVar2 = this.a.c;
            hVar2.b();
            this.a.finish();
            return;
        }
        hVar = this.a.c;
        ImMessageCenterShowItemData imMessageCenterShowItemData = this.c;
        aVar = this.a.i;
        hVar.a(imMessageCenterShowItemData, aVar);
    }
}
