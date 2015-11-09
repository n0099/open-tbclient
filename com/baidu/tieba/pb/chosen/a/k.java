package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import com.baidu.tieba.pb.chosen.a.i;
import tbclient.FinePbPage.ForumInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ i cgB;
    private final /* synthetic */ ForumInfo cgD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, ForumInfo forumInfo) {
        this.cgB = iVar;
        this.cgD = forumInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        i.a aVar;
        i.a aVar2;
        aVar = this.cgB.cgt;
        if (aVar != null) {
            aVar2 = this.cgB.cgt;
            aVar2.e(this.cgD.fromfid.longValue(), this.cgD.originalurl);
        }
    }
}
