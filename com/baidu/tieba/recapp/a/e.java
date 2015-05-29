package com.baidu.tieba.recapp.a;

import android.view.View;
import com.baidu.tieba.recapp.view.BaseAppViewHolder;
import com.baidu.tieba.tbadkCore.au;
import com.baidu.tieba.tbadkCore.data.i;
/* loaded from: classes.dex */
class e implements com.baidu.tbadk.core.dialog.d {
    private final /* synthetic */ int RY;
    private final /* synthetic */ View awh;
    private final /* synthetic */ i cbf;
    private final /* synthetic */ BaseAppViewHolder cbg;
    final /* synthetic */ d cbi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, View view, i iVar, int i, BaseAppViewHolder baseAppViewHolder) {
        this.cbi = dVar;
        this.awh = view;
        this.cbf = iVar;
        this.RY = i;
        this.cbg = baseAppViewHolder;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        com.baidu.tbadk.distribute.a.yX().a(this.awh.getContext(), this.cbf.aox(), "btn_download", "pb", this.cbf.csd, this.cbf.threadId);
        com.baidu.tbadk.distribute.a.yX().a(this.cbf.aox(), this.cbf.csd, this.cbf.threadId, "PB", "download");
        au.a(this.awh.getContext(), this.cbf, this.RY);
        this.cbg.refresh();
    }
}
