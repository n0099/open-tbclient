package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.f bZV;
    final /* synthetic */ PbActivity ccj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(PbActivity pbActivity, com.baidu.tbadk.coreExtra.share.f fVar) {
        this.ccj = pbActivity;
        this.bZV = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.util.a.aA(this.bZV.linkUrl);
        com.baidu.adp.lib.util.k.showToast(this.ccj.getPageContext().getPageActivity(), view.getResources().getString(i.h.copy_pb_url_success));
    }
}
