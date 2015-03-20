package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import tbclient.FinePbPage.ForumInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ e bGv;
    private final /* synthetic */ ForumInfo bGw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, ForumInfo forumInfo) {
        this.bGv = eVar;
        this.bGw = forumInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        i iVar;
        i iVar2;
        iVar = this.bGv.bGr;
        if (iVar != null) {
            iVar2 = this.bGv.bGr;
            iVar2.hy(this.bGw.fromfname);
        }
    }
}
