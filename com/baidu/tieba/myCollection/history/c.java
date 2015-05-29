package com.baidu.tieba.myCollection.history;

import android.view.View;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ PbHistoryActivity bHI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PbHistoryActivity pbHistoryActivity) {
        this.bHI = pbHistoryActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bHI.getPageContext().getPageActivity());
        aVar.bu(t.pb_history_clear_tip);
        aVar.a(t.confirm, new d(this));
        aVar.b(t.cancel, new e(this));
        aVar.b(this.bHI.getPageContext()).rL();
    }
}
