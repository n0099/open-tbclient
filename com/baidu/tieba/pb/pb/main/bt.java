package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.f bXf;
    final /* synthetic */ PbActivity evL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(PbActivity pbActivity, com.baidu.tbadk.coreExtra.share.f fVar) {
        this.evL = pbActivity;
        this.bXf = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.util.a.az(this.bXf.linkUrl);
        com.baidu.adp.lib.util.k.showToast(this.evL.getPageContext().getPageActivity(), view.getResources().getString(r.j.copy_pb_url_success));
    }
}
