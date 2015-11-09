package com.baidu.tieba.myCollection.history;

import android.view.View;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ PbHistoryActivity ccQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PbHistoryActivity pbHistoryActivity) {
        this.ccQ = pbHistoryActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.ccQ.getPageContext().getPageActivity());
        aVar.bF(i.h.pb_history_clear_tip);
        aVar.a(i.h.confirm, new d(this));
        aVar.b(i.h.cancel, new e(this));
        aVar.b(this.ccQ.getPageContext()).sR();
    }
}
