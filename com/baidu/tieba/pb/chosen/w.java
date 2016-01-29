package com.baidu.tieba.pb.chosen;

import android.view.View;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.f bgG;
    final /* synthetic */ t cID;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar, com.baidu.tbadk.coreExtra.share.f fVar) {
        this.cID = tVar;
        this.bgG = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbChosenActivity pbChosenActivity;
        com.baidu.adp.lib.util.a.aB(this.bgG.linkUrl);
        pbChosenActivity = this.cID.cIC;
        com.baidu.adp.lib.util.k.showToast(pbChosenActivity.getPageContext().getPageActivity(), view.getResources().getString(t.j.copy_pb_url_success));
    }
}
