package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fs implements View.OnClickListener {
    final /* synthetic */ ez eqf;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fs(ez ezVar, String str) {
        this.eqf = ezVar;
        this.val$url = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        PbActivity pbActivity3;
        if (!com.baidu.adp.lib.util.k.gB()) {
            pbActivity = this.eqf.ehi;
            pbActivity.showToast(r.l.neterror);
            return;
        }
        com.baidu.tbadk.core.util.ba vt = com.baidu.tbadk.core.util.ba.vt();
        pbActivity2 = this.eqf.ehi;
        vt.c(pbActivity2.getPageContext(), new String[]{this.val$url});
        pbActivity3 = this.eqf.ehi;
        pbActivity3.finish();
    }
}
