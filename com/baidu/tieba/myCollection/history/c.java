package com.baidu.tieba.myCollection.history;

import android.view.View;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ PbHistoryActivity bYs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PbHistoryActivity pbHistoryActivity) {
        this.bYs = pbHistoryActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bYs.getPageContext().getPageActivity());
        aVar.bF(i.h.pb_history_clear_tip);
        aVar.a(i.h.confirm, new d(this));
        aVar.b(i.h.cancel, new e(this));
        aVar.b(this.bYs.getPageContext()).sU();
    }
}
