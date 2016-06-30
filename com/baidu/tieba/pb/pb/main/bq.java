package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.f bGt;
    final /* synthetic */ PbActivity dPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(PbActivity pbActivity, com.baidu.tbadk.coreExtra.share.f fVar) {
        this.dPF = pbActivity;
        this.bGt = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.util.a.aw(this.bGt.linkUrl);
        com.baidu.adp.lib.util.k.showToast(this.dPF.getPageContext().getPageActivity(), view.getResources().getString(u.j.copy_pb_url_success));
    }
}
