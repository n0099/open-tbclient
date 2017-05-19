package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class dn implements View.OnClickListener {
    private final /* synthetic */ String bHb;
    private final /* synthetic */ String cQi;
    final /* synthetic */ dl eji;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dn(dl dlVar, String str, String str2) {
        this.eji = dlVar;
        this.cQi = str;
        this.bHb = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.eji.nA(this.cQi);
        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c12041").aa("fid", this.bHb));
    }
}
