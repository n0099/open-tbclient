package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fq implements View.OnClickListener {
    final /* synthetic */ ey etN;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fq(ey eyVar, String str) {
        this.etN = eyVar;
        this.val$url = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        PbActivity pbActivity3;
        if (!com.baidu.adp.lib.util.k.hB()) {
            pbActivity = this.etN.ekw;
            pbActivity.showToast(w.l.neterror);
            return;
        }
        com.baidu.tbadk.core.util.bb wn = com.baidu.tbadk.core.util.bb.wn();
        pbActivity2 = this.etN.ekw;
        wn.c(pbActivity2.getPageContext(), new String[]{this.val$url});
        pbActivity3 = this.etN.ekw;
        pbActivity3.finish();
    }
}
