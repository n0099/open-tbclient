package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cd implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.f blr;
    final /* synthetic */ PbActivity dht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(PbActivity pbActivity, com.baidu.tbadk.coreExtra.share.f fVar) {
        this.dht = pbActivity;
        this.blr = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.util.a.aD(this.blr.linkUrl);
        com.baidu.adp.lib.util.k.showToast(this.dht.getPageContext().getPageActivity(), view.getResources().getString(t.j.copy_pb_url_success));
    }
}
