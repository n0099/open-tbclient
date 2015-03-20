package com.baidu.tieba.myCollection.history;

import android.view.View;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ PbHistoryActivity bEA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PbHistoryActivity pbHistoryActivity) {
        this.bEA = pbHistoryActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.bEA.getPageContext().getPageActivity());
        aVar.bw(y.editor_dialog_title);
        aVar.bx(y.pb_history_clear_tip);
        aVar.a(y.confirm, new d(this));
        aVar.b(y.cancel, new e(this));
        aVar.b(this.bEA.getPageContext()).re();
    }
}
