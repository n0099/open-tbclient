package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.f bGr;
    final /* synthetic */ PbActivity bIJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(PbActivity pbActivity, com.baidu.tbadk.coreExtra.share.f fVar) {
        this.bIJ = pbActivity;
        this.bGr = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.util.a.copyToClipboard(this.bGr.adu);
        com.baidu.adp.lib.util.n.showToast(this.bIJ.getPageContext().getPageActivity(), view.getResources().getString(com.baidu.tieba.y.copy_pb_url_success));
    }
}
