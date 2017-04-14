package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class k implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ f dhP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(f fVar) {
        this.dhP = fVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (i < 0) {
            return false;
        }
        f fVar = this.dhP;
        imMessageCenterListAdapter = this.dhP.dhG;
        fVar.dhE = imMessageCenterListAdapter.getItem(i);
        f fVar2 = this.dhP;
        imMessageCenterShowItemData = this.dhP.dhE;
        fVar2.c(imMessageCenterShowItemData);
        if (this.dhP.dhJ != null) {
            this.dhP.dhJ.tT();
        }
        return true;
    }
}
