package com.baidu.tieba.recapp.a;

import android.view.View;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.recapp.view.BaseAppViewHolder;
import com.baidu.tieba.tbadkCore.ah;
import com.baidu.tieba.tbadkCore.data.n;
/* loaded from: classes.dex */
class e implements a.b {
    private final /* synthetic */ View aGp;
    private final /* synthetic */ n dhK;
    private final /* synthetic */ BaseAppViewHolder dhL;
    final /* synthetic */ d dhN;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, View view, n nVar, int i, BaseAppViewHolder baseAppViewHolder) {
        this.dhN = dVar;
        this.aGp = view;
        this.dhK = nVar;
        this.val$position = i;
        this.dhL = baseAppViewHolder;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        com.baidu.tbadk.distribute.a.Bf().a(this.aGp.getContext(), this.dhK.aCX(), "btn_download", "pb", this.dhK.dzx, this.dhK.threadId);
        com.baidu.tbadk.distribute.a.Bf().a(this.dhK.aCX(), this.dhK.dzx, this.dhK.threadId, "PB", "download", this.dhK.pageNumber);
        ah.a(this.aGp.getContext(), this.dhK, this.val$position);
        this.dhL.refresh();
    }
}
