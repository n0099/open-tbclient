package com.baidu.tieba.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements View.OnClickListener {
    final /* synthetic */ PbActivity bAT;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.f bBc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(PbActivity pbActivity, com.baidu.tbadk.coreExtra.share.f fVar) {
        this.bAT = pbActivity;
        this.bBc = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.util.a.copyToClipboard(this.bBc.Tq);
        com.baidu.adp.lib.util.l.showToast(this.bAT.getPageContext().getPageActivity(), view.getResources().getString(com.baidu.tieba.z.copy_pb_url_success));
    }
}
