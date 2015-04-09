package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import tbclient.FinePbPage.ForumInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e bGI;
    private final /* synthetic */ ForumInfo bGJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, ForumInfo forumInfo) {
        this.bGI = eVar;
        this.bGJ = forumInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        i iVar;
        i iVar2;
        iVar = this.bGI.bGE;
        if (iVar != null) {
            iVar2 = this.bGI.bGE;
            iVar2.b(this.bGJ.fromfid.longValue(), this.bGJ.originalurl);
        }
    }
}
