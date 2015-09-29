package com.baidu.tieba.pb.chosen;

import android.view.View;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.f aUH;
    final /* synthetic */ s cfd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(s sVar, com.baidu.tbadk.coreExtra.share.f fVar) {
        this.cfd = sVar;
        this.aUH = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbChosenActivity pbChosenActivity;
        com.baidu.adp.lib.util.a.aA(this.aUH.linkUrl);
        pbChosenActivity = this.cfd.cfc;
        com.baidu.adp.lib.util.k.showToast(pbChosenActivity.getPageContext().getPageActivity(), view.getResources().getString(i.h.copy_pb_url_success));
    }
}
