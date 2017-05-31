package com.baidu.tieba.pb.pb.main;

import android.widget.Toast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cm implements a.b {
    final /* synthetic */ PbActivity enc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(PbActivity pbActivity) {
        this.enc = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        Toast.makeText(this.enc.getPageContext().getPageActivity(), this.enc.getPageContext().getResources().getString(w.l.channel_no_push), 1).show();
    }
}
