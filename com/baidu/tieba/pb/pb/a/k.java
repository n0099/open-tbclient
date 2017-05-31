package com.baidu.tieba.pb.pb.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
/* loaded from: classes.dex */
class k implements View.OnClickListener {
    private final /* synthetic */ String bMP;
    private final /* synthetic */ String cVG;
    final /* synthetic */ i ekl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, String str, String str2) {
        this.ekl = iVar;
        this.cVG = str;
        this.bMP = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.ekl.nM(this.cVG);
        TiebaStatic.log(new as("c12041").Z("fid", this.bMP));
    }
}
