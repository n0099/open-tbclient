package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bu implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.h cCS;
    final /* synthetic */ PbActivity ehy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(PbActivity pbActivity, com.baidu.tbadk.coreExtra.share.h hVar) {
        this.ehy = pbActivity;
        this.cCS = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.util.a.ao(this.cCS.linkUrl);
        com.baidu.adp.lib.util.k.showToast(this.ehy.getPageContext().getPageActivity(), view.getResources().getString(w.l.copy_pb_url_success));
    }
}
