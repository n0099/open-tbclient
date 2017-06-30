package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gw implements View.OnClickListener {
    final /* synthetic */ gg eEv;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gw(gg ggVar, String str) {
        this.eEv = ggVar;
        this.val$url = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        PbActivity pbActivity3;
        if (!com.baidu.adp.lib.util.k.hA()) {
            pbActivity = this.eEv.euf;
            pbActivity.showToast(w.l.neterror);
            return;
        }
        com.baidu.tbadk.core.util.be vP = com.baidu.tbadk.core.util.be.vP();
        pbActivity2 = this.eEv.euf;
        vP.c(pbActivity2.getPageContext(), new String[]{this.val$url});
        pbActivity3 = this.eEv.euf;
        pbActivity3.finish();
    }
}
