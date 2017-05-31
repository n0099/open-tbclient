package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gn implements View.OnClickListener {
    final /* synthetic */ fx evi;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gn(fx fxVar, String str) {
        this.evi = fxVar;
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
            pbActivity = this.evi.elf;
            pbActivity.showToast(w.l.neterror);
            return;
        }
        com.baidu.tbadk.core.util.bb vy = com.baidu.tbadk.core.util.bb.vy();
        pbActivity2 = this.evi.elf;
        vy.c(pbActivity2.getPageContext(), new String[]{this.val$url});
        pbActivity3 = this.evi.elf;
        pbActivity3.finish();
    }
}
