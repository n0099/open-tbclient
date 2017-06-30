package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes2.dex */
class k implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ f drz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(f fVar) {
        this.drz = fVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (i < 0) {
            return false;
        }
        f fVar = this.drz;
        imMessageCenterListAdapter = this.drz.drq;
        fVar.dro = imMessageCenterListAdapter.getItem(i);
        f fVar2 = this.drz;
        imMessageCenterShowItemData = this.drz.dro;
        fVar2.c(imMessageCenterShowItemData);
        if (this.drz.drt != null) {
            this.drz.drt.td();
        }
        return true;
    }
}
