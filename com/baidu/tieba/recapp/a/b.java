package com.baidu.tieba.recapp.a;

import android.view.View;
import com.baidu.tieba.recapp.view.BaseAppViewHolder;
import com.baidu.tieba.tbadkCore.au;
import com.baidu.tieba.tbadkCore.c.i;
/* loaded from: classes.dex */
class b implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ int Rz;
    private final /* synthetic */ View auE;
    final /* synthetic */ a bXB;
    private final /* synthetic */ i bXC;
    private final /* synthetic */ BaseAppViewHolder bXD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, View view, i iVar, int i, BaseAppViewHolder baseAppViewHolder) {
        this.bXB = aVar;
        this.auE = view;
        this.bXC = iVar;
        this.Rz = i;
        this.bXD = baseAppViewHolder;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        com.baidu.tbadk.distribute.a.yk().a(this.auE.getContext(), this.bXC.amL(), "area_download", "pb", this.bXC.cof, this.bXC.threadId);
        com.baidu.tbadk.distribute.a.yk().a(this.bXC.amL(), this.bXC.cof, this.bXC.threadId, "PB", "download");
        au.a(this.auE.getContext(), this.bXC, this.Rz);
        this.bXD.refresh();
    }
}
