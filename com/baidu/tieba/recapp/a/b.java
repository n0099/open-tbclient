package com.baidu.tieba.recapp.a;

import android.view.View;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.recapp.view.BaseAppViewHolder;
import com.baidu.tieba.tbadkCore.ah;
import com.baidu.tieba.tbadkCore.data.q;
/* loaded from: classes.dex */
class b implements a.b {
    private final /* synthetic */ View aHQ;
    final /* synthetic */ a dnp;
    private final /* synthetic */ q dnq;
    private final /* synthetic */ BaseAppViewHolder dnr;
    private final /* synthetic */ int val$position;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, View view, q qVar, int i, BaseAppViewHolder baseAppViewHolder) {
        this.dnp = aVar;
        this.aHQ = view;
        this.dnq = qVar;
        this.val$position = i;
        this.dnr = baseAppViewHolder;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        com.baidu.tbadk.distribute.a.AV().a(this.aHQ.getContext(), this.dnq.aFk(), "area_download", "pb", this.dnq.dHa, this.dnq.threadId);
        if (ah.a(this.aHQ.getContext(), this.dnq.aFk(), this.val$position)) {
            this.dnq.mW(1);
            TiebaStatic.eventStat(this.aHQ.getContext(), "pb_dl_app", null, 1, "app_name", this.dnq.getPkgName());
        }
        this.dnr.refresh();
    }
}
