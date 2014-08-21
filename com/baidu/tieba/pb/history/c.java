package com.baidu.tieba.pb.history;

import android.view.View;
import com.baidu.tieba.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ PbHistoryActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PbHistoryActivity pbHistoryActivity) {
        this.a = pbHistoryActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.a);
        aVar.a(x.editor_dialog_title);
        aVar.b(x.pb_history_clear_tip);
        aVar.a(x.confirm, new d(this));
        aVar.b(x.cancel, new e(this));
        aVar.a().c();
    }
}
