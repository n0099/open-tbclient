package com.baidu.tieba.recapp.a;

import android.view.View;
import com.baidu.tieba.recapp.view.BaseAppViewHolder;
import com.baidu.tieba.tbadkCore.ar;
import com.baidu.tieba.tbadkCore.b.j;
/* loaded from: classes.dex */
class b implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ View alQ;
    final /* synthetic */ a bKT;
    private final /* synthetic */ j bKU;
    private final /* synthetic */ BaseAppViewHolder bKV;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, View view, j jVar, int i, BaseAppViewHolder baseAppViewHolder) {
        this.bKT = aVar;
        this.alQ = view;
        this.bKU = jVar;
        this.val$position = i;
        this.bKV = baseAppViewHolder;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        com.baidu.tbadk.distribute.a.uD().a(this.alQ.getContext(), this.bKU.agP(), "area_download", "pb", this.bKU.Gb, this.bKU.threadId);
        com.baidu.tbadk.distribute.a.uD().a(this.bKU.agP(), this.bKU.Gb, this.bKU.threadId, "PB", "download");
        ar.a(this.alQ.getContext(), this.bKU, this.val$position);
        this.bKV.refresh();
    }
}
