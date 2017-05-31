package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bz implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.h bJq;
    final /* synthetic */ PbActivity enc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(PbActivity pbActivity, com.baidu.tbadk.coreExtra.share.h hVar) {
        this.enc = pbActivity;
        this.bJq = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.util.a.ao(this.bJq.linkUrl);
        com.baidu.adp.lib.util.k.showToast(this.enc.getPageContext().getPageActivity(), view.getResources().getString(w.l.copy_pb_url_success));
    }
}
