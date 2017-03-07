package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.g cHY;
    final /* synthetic */ PbActivity elO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(PbActivity pbActivity, com.baidu.tbadk.coreExtra.share.g gVar) {
        this.elO = pbActivity;
        this.cHY = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.util.a.as(this.cHY.linkUrl);
        com.baidu.adp.lib.util.k.showToast(this.elO.getPageContext().getPageActivity(), view.getResources().getString(w.l.copy_pb_url_success));
    }
}
