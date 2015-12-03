package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.f bam;
    final /* synthetic */ PbActivity cCm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(PbActivity pbActivity, com.baidu.tbadk.coreExtra.share.f fVar) {
        this.cCm = pbActivity;
        this.bam = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.util.a.aC(this.bam.linkUrl);
        com.baidu.adp.lib.util.k.showToast(this.cCm.getPageContext().getPageActivity(), view.getResources().getString(n.i.copy_pb_url_success));
    }
}
