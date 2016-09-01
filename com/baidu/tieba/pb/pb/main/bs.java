package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.f bSV;
    final /* synthetic */ PbActivity eob;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(PbActivity pbActivity, com.baidu.tbadk.coreExtra.share.f fVar) {
        this.eob = pbActivity;
        this.bSV = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.util.a.az(this.bSV.linkUrl);
        com.baidu.adp.lib.util.k.showToast(this.eob.getPageContext().getPageActivity(), view.getResources().getString(t.j.copy_pb_url_success));
    }
}
