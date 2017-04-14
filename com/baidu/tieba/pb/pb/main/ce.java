package com.baidu.tieba.pb.pb.main;

import android.widget.Toast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ce implements a.b {
    final /* synthetic */ PbActivity ejU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(PbActivity pbActivity) {
        this.ejU = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        Toast.makeText(this.ejU.getPageContext().getPageActivity(), this.ejU.getPageContext().getResources().getString(w.l.channel_no_push), 1).show();
    }
}
