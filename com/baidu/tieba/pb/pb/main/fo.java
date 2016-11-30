package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fo implements View.OnClickListener {
    final /* synthetic */ ey eCT;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fo(ey eyVar, String str) {
        this.eCT = eyVar;
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
            pbActivity = this.eCT.eug;
            pbActivity.showToast(r.j.neterror);
            return;
        }
        com.baidu.tbadk.core.util.bf vP = com.baidu.tbadk.core.util.bf.vP();
        pbActivity2 = this.eCT.eug;
        vP.c(pbActivity2.getPageContext(), new String[]{this.val$url});
        pbActivity3 = this.eCT.eug;
        pbActivity3.finish();
    }
}
