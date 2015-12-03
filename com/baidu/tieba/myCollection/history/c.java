package com.baidu.tieba.myCollection.history;

import android.view.View;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ PbHistoryActivity cuS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PbHistoryActivity pbHistoryActivity) {
        this.cuS = pbHistoryActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cuS.getPageContext().getPageActivity());
        aVar.bN(n.i.pb_history_clear_tip);
        aVar.a(n.i.confirm, new d(this));
        aVar.b(n.i.cancel, new e(this));
        aVar.b(this.cuS.getPageContext()).tv();
    }
}
