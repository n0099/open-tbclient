package com.baidu.tieba.pb.chosen;

import android.view.View;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ h bJc;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.g bJd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar, com.baidu.tbadk.coreExtra.share.g gVar) {
        this.bJc = hVar;
        this.bJd = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbChosenActivity pbChosenActivity;
        com.baidu.adp.lib.util.a.copyToClipboard(this.bJd.linkUrl);
        pbChosenActivity = this.bJc.bJb;
        com.baidu.adp.lib.util.n.showToast(pbChosenActivity.getPageContext().getPageActivity(), view.getResources().getString(t.copy_pb_url_success));
    }
}
