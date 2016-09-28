package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.f bSO;
    final /* synthetic */ PbActivity eqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(PbActivity pbActivity, com.baidu.tbadk.coreExtra.share.f fVar) {
        this.eqa = pbActivity;
        this.bSO = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.util.a.az(this.bSO.linkUrl);
        com.baidu.adp.lib.util.k.showToast(this.eqa.getPageContext().getPageActivity(), view.getResources().getString(r.j.copy_pb_url_success));
    }
}
