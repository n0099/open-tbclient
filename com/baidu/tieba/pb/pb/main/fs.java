package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fs implements View.OnClickListener {
    final /* synthetic */ fa etn;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fs(fa faVar, String str) {
        this.etn = faVar;
        this.val$url = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        PbActivity pbActivity3;
        if (!com.baidu.adp.lib.util.k.hv()) {
            pbActivity = this.etn.eka;
            pbActivity.showToast(w.l.neterror);
            return;
        }
        com.baidu.tbadk.core.util.bb vQ = com.baidu.tbadk.core.util.bb.vQ();
        pbActivity2 = this.etn.eka;
        vQ.c(pbActivity2.getPageContext(), new String[]{this.val$url});
        pbActivity3 = this.etn.eka;
        pbActivity3.finish();
    }
}
