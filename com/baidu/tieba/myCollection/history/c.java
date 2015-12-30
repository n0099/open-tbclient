package com.baidu.tieba.myCollection.history;

import android.view.View;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ PbHistoryActivity cyS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PbHistoryActivity pbHistoryActivity) {
        this.cyS = pbHistoryActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.cyS.getPageContext().getPageActivity());
        aVar.bG(n.j.pb_history_clear_tip);
        aVar.a(n.j.confirm, new d(this));
        aVar.b(n.j.cancel, new e(this));
        aVar.b(this.cyS.getPageContext()).tf();
    }
}
