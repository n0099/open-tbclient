package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fb implements View.OnClickListener {
    final /* synthetic */ el dpu;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fb(el elVar, String str) {
        this.dpu = elVar;
        this.val$url = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        PbActivity pbActivity3;
        if (!com.baidu.adp.lib.util.k.fH()) {
            pbActivity = this.dpu.dhY;
            pbActivity.showToast(t.j.neterror);
            return;
        }
        com.baidu.tbadk.core.util.bg ut = com.baidu.tbadk.core.util.bg.ut();
        pbActivity2 = this.dpu.dhY;
        ut.c(pbActivity2.getPageContext(), new String[]{this.val$url});
        pbActivity3 = this.dpu.dhY;
        pbActivity3.finish();
    }
}
