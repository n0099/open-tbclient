package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fn implements View.OnClickListener {
    final /* synthetic */ ex euB;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fn(ex exVar, String str) {
        this.euB = exVar;
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
            pbActivity = this.euB.emy;
            pbActivity.showToast(t.j.neterror);
            return;
        }
        com.baidu.tbadk.core.util.bi vx = com.baidu.tbadk.core.util.bi.vx();
        pbActivity2 = this.euB.emy;
        vx.c(pbActivity2.getPageContext(), new String[]{this.val$url});
        pbActivity3 = this.euB.emy;
        pbActivity3.finish();
    }
}
