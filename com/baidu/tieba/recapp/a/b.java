package com.baidu.tieba.recapp.a;

import android.view.View;
import com.baidu.tieba.recapp.view.BaseAppViewHolder;
import com.baidu.tieba.tbadkCore.ar;
import com.baidu.tieba.tbadkCore.b.j;
/* loaded from: classes.dex */
class b implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ int FS;
    private final /* synthetic */ View amH;
    final /* synthetic */ a bMD;
    private final /* synthetic */ j bME;
    private final /* synthetic */ BaseAppViewHolder bMF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, View view, j jVar, int i, BaseAppViewHolder baseAppViewHolder) {
        this.bMD = aVar;
        this.amH = view;
        this.bME = jVar;
        this.FS = i;
        this.bMF = baseAppViewHolder;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        com.baidu.tbadk.distribute.a.uO().a(this.amH.getContext(), this.bME.ahp(), "area_download", "pb", this.bME.bYF, this.bME.threadId);
        com.baidu.tbadk.distribute.a.uO().a(this.bME.ahp(), this.bME.bYF, this.bME.threadId, "PB", "download");
        ar.a(this.amH.getContext(), this.bME, this.FS);
        this.bMF.refresh();
    }
}
