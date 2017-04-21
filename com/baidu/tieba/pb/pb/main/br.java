package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.h cIP;
    final /* synthetic */ PbActivity emk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(PbActivity pbActivity, com.baidu.tbadk.coreExtra.share.h hVar) {
        this.emk = pbActivity;
        this.cIP = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.util.a.ao(this.cIP.linkUrl);
        com.baidu.adp.lib.util.k.showToast(this.emk.getPageContext().getPageActivity(), view.getResources().getString(w.l.copy_pb_url_success));
    }
}
