package com.baidu.tieba.pb.history;

import android.view.View;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ PbHistoryActivity buz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PbHistoryActivity pbHistoryActivity) {
        this.buz = pbHistoryActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.buz);
        aVar.aW(y.editor_dialog_title);
        aVar.aX(y.pb_history_clear_tip);
        aVar.a(y.confirm, new c(this));
        aVar.b(y.cancel, new d(this));
        aVar.kT().kW();
    }
}
