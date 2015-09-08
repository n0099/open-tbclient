package com.baidu.tieba.pb.chosen;

import android.view.View;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ r bZU;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.f bZV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(r rVar, com.baidu.tbadk.coreExtra.share.f fVar) {
        this.bZU = rVar;
        this.bZV = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbChosenActivity pbChosenActivity;
        com.baidu.adp.lib.util.a.aA(this.bZV.linkUrl);
        pbChosenActivity = this.bZU.bZT;
        com.baidu.adp.lib.util.k.showToast(pbChosenActivity.getPageContext().getPageActivity(), view.getResources().getString(i.h.copy_pb_url_success));
    }
}
