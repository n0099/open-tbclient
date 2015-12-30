package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.f bel;
    final /* synthetic */ PbActivity cFS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(PbActivity pbActivity, com.baidu.tbadk.coreExtra.share.f fVar) {
        this.cFS = pbActivity;
        this.bel = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.util.a.aC(this.bel.linkUrl);
        com.baidu.adp.lib.util.k.showToast(this.cFS.getPageContext().getPageActivity(), view.getResources().getString(n.j.copy_pb_url_success));
    }
}
