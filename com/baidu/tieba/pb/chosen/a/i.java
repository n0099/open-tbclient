package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import tbclient.FinePbPage.ForumInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ h bJB;
    private final /* synthetic */ ForumInfo bJC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, ForumInfo forumInfo) {
        this.bJB = hVar;
        this.bJC = forumInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        k kVar;
        k kVar2;
        kVar = this.bJB.bJx;
        if (kVar != null) {
            kVar2 = this.bJB.bJx;
            kVar2.c(this.bJC.fromfid.longValue(), this.bJC.originalurl);
        }
    }
}
