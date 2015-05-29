package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.g bJd;
    final /* synthetic */ PbActivity bKT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(PbActivity pbActivity, com.baidu.tbadk.coreExtra.share.g gVar) {
        this.bKT = pbActivity;
        this.bJd = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.util.a.copyToClipboard(this.bJd.linkUrl);
        com.baidu.adp.lib.util.n.showToast(this.bKT.getPageContext().getPageActivity(), view.getResources().getString(com.baidu.tieba.t.copy_pb_url_success));
    }
}
