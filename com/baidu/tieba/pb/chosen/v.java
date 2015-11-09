package com.baidu.tieba.pb.chosen;

import android.view.View;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.f aVa;
    final /* synthetic */ s cfP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(s sVar, com.baidu.tbadk.coreExtra.share.f fVar) {
        this.cfP = sVar;
        this.aVa = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbChosenActivity pbChosenActivity;
        com.baidu.adp.lib.util.a.ay(this.aVa.linkUrl);
        pbChosenActivity = this.cfP.cfO;
        com.baidu.adp.lib.util.k.showToast(pbChosenActivity.getPageContext().getPageActivity(), view.getResources().getString(i.h.copy_pb_url_success));
    }
}
