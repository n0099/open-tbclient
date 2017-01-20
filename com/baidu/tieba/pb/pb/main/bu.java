package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bu implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.f bUr;
    final /* synthetic */ PbActivity eiV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(PbActivity pbActivity, com.baidu.tbadk.coreExtra.share.f fVar) {
        this.eiV = pbActivity;
        this.bUr = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.util.a.ay(this.bUr.linkUrl);
        com.baidu.adp.lib.util.k.showToast(this.eiV.getPageContext().getPageActivity(), view.getResources().getString(r.l.copy_pb_url_success));
    }
}
