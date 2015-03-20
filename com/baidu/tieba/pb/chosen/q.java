package com.baidu.tieba.pb.chosen;

import android.view.View;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ n bGd;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.f bGe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(n nVar, com.baidu.tbadk.coreExtra.share.f fVar) {
        this.bGd = nVar;
        this.bGe = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbChosenActivity pbChosenActivity;
        com.baidu.adp.lib.util.a.copyToClipboard(this.bGe.adm);
        pbChosenActivity = this.bGd.bGc;
        com.baidu.adp.lib.util.n.showToast(pbChosenActivity.getPageContext().getPageActivity(), view.getResources().getString(y.copy_pb_url_success));
    }
}
