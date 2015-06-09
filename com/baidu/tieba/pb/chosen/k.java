package com.baidu.tieba.pb.chosen;

import android.view.View;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ h bJd;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.g bJe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar, com.baidu.tbadk.coreExtra.share.g gVar) {
        this.bJd = hVar;
        this.bJe = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbChosenActivity pbChosenActivity;
        com.baidu.adp.lib.util.a.copyToClipboard(this.bJe.linkUrl);
        pbChosenActivity = this.bJd.bJc;
        com.baidu.adp.lib.util.n.showToast(pbChosenActivity.getPageContext().getPageActivity(), view.getResources().getString(t.copy_pb_url_success));
    }
}
