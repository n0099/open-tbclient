package com.baidu.tieba.recapp.a;

import android.view.View;
import com.baidu.tieba.recapp.view.BaseAppViewHolder;
import com.baidu.tieba.tbadkCore.ar;
import com.baidu.tieba.tbadkCore.b.j;
/* loaded from: classes.dex */
class e implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ int FV;
    private final /* synthetic */ View amK;
    private final /* synthetic */ j bMF;
    private final /* synthetic */ BaseAppViewHolder bMG;
    final /* synthetic */ d bMI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, View view, j jVar, int i, BaseAppViewHolder baseAppViewHolder) {
        this.bMI = dVar;
        this.amK = view;
        this.bMF = jVar;
        this.FV = i;
        this.bMG = baseAppViewHolder;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        com.baidu.tbadk.distribute.a.uU().a(this.amK.getContext(), this.bMF.ahu(), "btn_download", "pb", this.bMF.bYG, this.bMF.threadId);
        com.baidu.tbadk.distribute.a.uU().a(this.bMF.ahu(), this.bMF.bYG, this.bMF.threadId, "PB", "download");
        ar.a(this.amK.getContext(), this.bMF, this.FV);
        this.bMG.refresh();
    }
}
