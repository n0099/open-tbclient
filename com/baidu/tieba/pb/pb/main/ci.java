package com.baidu.tieba.pb.pb.main;

import android.widget.Toast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ci implements a.b {
    final /* synthetic */ PbActivity ehy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(PbActivity pbActivity) {
        this.ehy = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        Toast.makeText(this.ehy.getPageContext().getPageActivity(), this.ehy.getPageContext().getResources().getString(w.l.channel_no_push), 1).show();
    }
}
