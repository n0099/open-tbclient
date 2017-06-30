package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class ed implements View.OnClickListener {
    private final /* synthetic */ String bTs;
    private final /* synthetic */ String ddD;
    final /* synthetic */ dy exY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ed(dy dyVar, String str, String str2) {
        this.exY = dyVar;
        this.ddD = str;
        this.bTs = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.exY.oG(this.ddD);
        TiebaStatic.log(new com.baidu.tbadk.core.util.au("c12041").Z("fid", this.bTs));
        if (this.exY.eta != null && this.exY.eta.aMv() != null && this.exY.eta.aMv().getThreadType() == 40) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.au("c12123").Z("fid", this.exY.eta.getForumId()).Z("obj_param1", this.ddD));
        }
    }
}
