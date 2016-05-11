package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.f bhv;
    final /* synthetic */ PbActivity djE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(PbActivity pbActivity, com.baidu.tbadk.coreExtra.share.f fVar) {
        this.djE = pbActivity;
        this.bhv = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.util.a.aw(this.bhv.linkUrl);
        com.baidu.adp.lib.util.k.showToast(this.djE.getPageContext().getPageActivity(), view.getResources().getString(t.j.copy_pb_url_success));
    }
}
