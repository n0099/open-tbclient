package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fk implements View.OnClickListener {
    final /* synthetic */ eu dnc;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fk(eu euVar, String str) {
        this.dnc = euVar;
        this.val$url = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        PbActivity pbActivity3;
        if (!com.baidu.adp.lib.util.k.jw()) {
            pbActivity = this.dnc.dfw;
            pbActivity.showToast(t.j.neterror);
            return;
        }
        com.baidu.tbadk.core.util.bg wM = com.baidu.tbadk.core.util.bg.wM();
        pbActivity2 = this.dnc.dfw;
        wM.c(pbActivity2.getPageContext(), new String[]{this.val$url});
        pbActivity3 = this.dnc.dfw;
        pbActivity3.finish();
    }
}
