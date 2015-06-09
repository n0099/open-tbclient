package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import tbclient.FinePbPage.ForumInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ h bJC;
    private final /* synthetic */ ForumInfo bJD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, ForumInfo forumInfo) {
        this.bJC = hVar;
        this.bJD = forumInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        k kVar;
        k kVar2;
        kVar = this.bJC.bJy;
        if (kVar != null) {
            kVar2 = this.bJC.bJy;
            kVar2.c(this.bJD.fromfid.longValue(), this.bJD.originalurl);
        }
    }
}
