package com.baidu.tieba.recapp.a;

import android.view.View;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.recapp.view.BaseAppViewHolder;
import com.baidu.tieba.tbadkCore.ag;
import com.baidu.tieba.tbadkCore.data.q;
/* loaded from: classes.dex */
class e implements a.b {
    private final /* synthetic */ int YA;
    private final /* synthetic */ View aIS;
    private final /* synthetic */ q dCt;
    private final /* synthetic */ BaseAppViewHolder dCu;
    final /* synthetic */ d dCw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, View view, q qVar, int i, BaseAppViewHolder baseAppViewHolder) {
        this.dCw = dVar;
        this.aIS = view;
        this.dCt = qVar;
        this.YA = i;
        this.dCu = baseAppViewHolder;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        com.baidu.tbadk.distribute.a.Cl().a(this.aIS.getContext(), this.dCt.aMq(), "btn_download", "pb", this.dCt.dWW, this.dCt.threadId);
        if (ag.a(this.aIS.getContext(), this.dCt.aMq(), this.YA)) {
            this.dCt.oh(1);
            TiebaStatic.eventStat(this.aIS.getContext(), "pb_dl_app", null, 1, "app_name", this.dCt.getPkgName());
        }
        this.dCu.refresh();
    }
}
