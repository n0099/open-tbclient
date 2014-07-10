package com.baidu.tieba.pb.history;

import android.view.View;
import com.baidu.tieba.y;
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
        aVar.a(y.editor_dialog_title);
        aVar.b(y.pb_history_clear_tip);
        aVar.a(y.confirm, new d(this));
        aVar.b(y.cancel, new e(this));
        aVar.a().b();
    }
}
