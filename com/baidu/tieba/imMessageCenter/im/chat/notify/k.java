package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes2.dex */
class k implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ f djD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(f fVar) {
        this.djD = fVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (i < 0) {
            return false;
        }
        f fVar = this.djD;
        imMessageCenterListAdapter = this.djD.dju;
        fVar.djs = imMessageCenterListAdapter.getItem(i);
        f fVar2 = this.djD;
        imMessageCenterShowItemData = this.djD.djs;
        fVar2.c(imMessageCenterShowItemData);
        if (this.djD.djx != null) {
            this.djD.djx.tf();
        }
        return true;
    }
}
