package com.baidu.tieba.recapp.a;

import android.view.View;
import com.baidu.tieba.recapp.view.BaseAppViewHolder;
import com.baidu.tieba.tbadkCore.au;
import com.baidu.tieba.tbadkCore.data.i;
/* loaded from: classes.dex */
class e implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ int RY;
    private final /* synthetic */ View awi;
    private final /* synthetic */ i cbg;
    private final /* synthetic */ BaseAppViewHolder cbh;
    final /* synthetic */ d cbj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, View view, i iVar, int i, BaseAppViewHolder baseAppViewHolder) {
        this.cbj = dVar;
        this.awi = view;
        this.cbg = iVar;
        this.RY = i;
        this.cbh = baseAppViewHolder;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        com.baidu.tbadk.distribute.a.yY().a(this.awi.getContext(), this.cbg.aoy(), "btn_download", "pb", this.cbg.cse, this.cbg.threadId);
        com.baidu.tbadk.distribute.a.yY().a(this.cbg.aoy(), this.cbg.cse, this.cbg.threadId, "PB", "download");
        au.a(this.awi.getContext(), this.cbg, this.RY);
        this.cbh.refresh();
    }
}
