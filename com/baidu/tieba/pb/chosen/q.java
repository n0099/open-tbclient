package com.baidu.tieba.pb.chosen;

import android.view.View;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ n bGq;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.f bGr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(n nVar, com.baidu.tbadk.coreExtra.share.f fVar) {
        this.bGq = nVar;
        this.bGr = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbChosenActivity pbChosenActivity;
        com.baidu.adp.lib.util.a.copyToClipboard(this.bGr.adu);
        pbChosenActivity = this.bGq.bGp;
        com.baidu.adp.lib.util.n.showToast(pbChosenActivity.getPageContext().getPageActivity(), view.getResources().getString(y.copy_pb_url_success));
    }
}
