package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.f aUS;
    final /* synthetic */ PbActivity ciK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(PbActivity pbActivity, com.baidu.tbadk.coreExtra.share.f fVar) {
        this.ciK = pbActivity;
        this.aUS = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.util.a.aA(this.aUS.linkUrl);
        com.baidu.adp.lib.util.k.showToast(this.ciK.getPageContext().getPageActivity(), view.getResources().getString(i.h.copy_pb_url_success));
    }
}
