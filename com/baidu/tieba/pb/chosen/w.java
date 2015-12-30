package com.baidu.tieba.pb.chosen;

import android.view.View;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.coreExtra.share.f bel;
    final /* synthetic */ t cBY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar, com.baidu.tbadk.coreExtra.share.f fVar) {
        this.cBY = tVar;
        this.bel = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbChosenActivity pbChosenActivity;
        com.baidu.adp.lib.util.a.aC(this.bel.linkUrl);
        pbChosenActivity = this.cBY.cBX;
        com.baidu.adp.lib.util.k.showToast(pbChosenActivity.getPageContext().getPageActivity(), view.getResources().getString(n.j.copy_pb_url_success));
    }
}
