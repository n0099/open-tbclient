package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.f bGe;
    final /* synthetic */ PbActivity bIv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(PbActivity pbActivity, com.baidu.tbadk.coreExtra.share.f fVar) {
        this.bIv = pbActivity;
        this.bGe = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.util.a.copyToClipboard(this.bGe.adm);
        com.baidu.adp.lib.util.n.showToast(this.bIv.getPageContext().getPageActivity(), view.getResources().getString(com.baidu.tieba.y.copy_pb_url_success));
    }
}
