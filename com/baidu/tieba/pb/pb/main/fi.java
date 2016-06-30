package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fi implements View.OnClickListener {
    final /* synthetic */ es dVR;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fi(es esVar, String str) {
        this.dVR = esVar;
        this.val$url = str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        PbActivity pbActivity3;
        if (!com.baidu.adp.lib.util.k.fI()) {
            pbActivity = this.dVR.dOg;
            pbActivity.showToast(u.j.neterror);
            return;
        }
        com.baidu.tbadk.core.util.bi us = com.baidu.tbadk.core.util.bi.us();
        pbActivity2 = this.dVR.dOg;
        us.c(pbActivity2.getPageContext(), new String[]{this.val$url});
        pbActivity3 = this.dVR.dOg;
        pbActivity3.finish();
    }
}
