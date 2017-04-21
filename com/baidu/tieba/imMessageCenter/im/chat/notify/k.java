package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
/* loaded from: classes.dex */
class k implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ f dkg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(f fVar) {
        this.dkg = fVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ImMessageCenterListAdapter imMessageCenterListAdapter;
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        if (i < 0) {
            return false;
        }
        f fVar = this.dkg;
        imMessageCenterListAdapter = this.dkg.djX;
        fVar.djV = imMessageCenterListAdapter.getItem(i);
        f fVar2 = this.dkg;
        imMessageCenterShowItemData = this.dkg.djV;
        fVar2.c(imMessageCenterShowItemData);
        if (this.dkg.dka != null) {
            this.dkg.dka.tT();
        }
        return true;
    }
}
