package com.baidu.tieba.pb.pb.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
/* loaded from: classes.dex */
class k implements View.OnClickListener {
    private final /* synthetic */ String bTs;
    private final /* synthetic */ String ddD;
    final /* synthetic */ i etk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, String str, String str2) {
        this.etk = iVar;
        this.ddD = str;
        this.bTs = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.etk.oG(this.ddD);
        TiebaStatic.log(new au("c12041").Z("fid", this.bTs));
    }
}
