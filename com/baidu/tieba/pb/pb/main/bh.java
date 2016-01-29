package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.f bgG;
    final /* synthetic */ PbActivity cNq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(PbActivity pbActivity, com.baidu.tbadk.coreExtra.share.f fVar) {
        this.cNq = pbActivity;
        this.bgG = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.util.a.aB(this.bgG.linkUrl);
        com.baidu.adp.lib.util.k.showToast(this.cNq.getPageContext().getPageActivity(), view.getResources().getString(t.j.copy_pb_url_success));
    }
}
