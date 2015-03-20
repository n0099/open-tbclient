package com.baidu.tieba.recapp.a;

import android.view.View;
import com.baidu.tieba.recapp.view.BaseAppViewHolder;
import com.baidu.tieba.tbadkCore.au;
import com.baidu.tieba.tbadkCore.c.i;
/* loaded from: classes.dex */
class b implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ int Rx;
    private final /* synthetic */ View auw;
    final /* synthetic */ a bXl;
    private final /* synthetic */ i bXm;
    private final /* synthetic */ BaseAppViewHolder bXn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, View view, i iVar, int i, BaseAppViewHolder baseAppViewHolder) {
        this.bXl = aVar;
        this.auw = view;
        this.bXm = iVar;
        this.Rx = i;
        this.bXn = baseAppViewHolder;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        com.baidu.tbadk.distribute.a.ye().a(this.auw.getContext(), this.bXm.amw(), "area_download", "pb", this.bXm.cnP, this.bXm.threadId);
        com.baidu.tbadk.distribute.a.ye().a(this.bXm.amw(), this.bXm.cnP, this.bXm.threadId, "PB", "download");
        au.a(this.auw.getContext(), this.bXm, this.Rx);
        this.bXn.refresh();
    }
}
