package com.baidu.tieba.recapp.a;

import android.view.View;
import com.baidu.tieba.recapp.view.BaseAppViewHolder;
import com.baidu.tieba.tbadkCore.au;
import com.baidu.tieba.tbadkCore.data.i;
/* loaded from: classes.dex */
class b implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ int RY;
    private final /* synthetic */ View awi;
    final /* synthetic */ a cbf;
    private final /* synthetic */ i cbg;
    private final /* synthetic */ BaseAppViewHolder cbh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, View view, i iVar, int i, BaseAppViewHolder baseAppViewHolder) {
        this.cbf = aVar;
        this.awi = view;
        this.cbg = iVar;
        this.RY = i;
        this.cbh = baseAppViewHolder;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        com.baidu.tbadk.distribute.a.yY().a(this.awi.getContext(), this.cbg.aoy(), "area_download", "pb", this.cbg.cse, this.cbg.threadId);
        com.baidu.tbadk.distribute.a.yY().a(this.cbg.aoy(), this.cbg.cse, this.cbg.threadId, "PB", "download");
        au.a(this.awi.getContext(), this.cbg, this.RY);
        this.cbh.refresh();
    }
}
