package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class dw implements View.OnClickListener {
    private final /* synthetic */ String bMP;
    private final /* synthetic */ String cVG;
    final /* synthetic */ dr eoS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dw(dr drVar, String str, String str2) {
        this.eoS = drVar;
        this.cVG = str;
        this.bMP = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.eoS.nM(this.cVG);
        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c12041").Z("fid", this.bMP));
        if (this.eoS.ekc != null && this.eoS.ekc.aIB() != null && this.eoS.ekc.aIB().getThreadType() == 40) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c12123").Z("fid", this.eoS.ekc.getForumId()).Z("obj_param1", this.cVG));
        }
    }
}
