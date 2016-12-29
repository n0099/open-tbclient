package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fh implements View.OnClickListener {
    final /* synthetic */ er egZ;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fh(er erVar, String str) {
        this.egZ = erVar;
        this.val$url = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        PbActivity pbActivity3;
        if (!com.baidu.adp.lib.util.k.gD()) {
            pbActivity = this.egZ.dYB;
            pbActivity.showToast(r.j.neterror);
            return;
        }
        com.baidu.tbadk.core.util.bc vz = com.baidu.tbadk.core.util.bc.vz();
        pbActivity2 = this.egZ.dYB;
        vz.c(pbActivity2.getPageContext(), new String[]{this.val$url});
        pbActivity3 = this.egZ.dYB;
        pbActivity3.finish();
    }
}
