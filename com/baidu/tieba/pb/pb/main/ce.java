package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ce implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.h bPO;
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(PbActivity pbActivity, com.baidu.tbadk.coreExtra.share.h hVar) {
        this.ewh = pbActivity;
        this.bPO = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.util.a.at(this.bPO.linkUrl);
        com.baidu.adp.lib.util.k.showToast(this.ewh.getPageContext().getPageActivity(), view.getResources().getString(w.l.copy_pb_url_success));
    }
}
