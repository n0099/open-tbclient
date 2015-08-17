package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import com.baidu.tieba.pb.chosen.a.i;
import tbclient.FinePbPage.ForumInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ i bZP;
    private final /* synthetic */ ForumInfo bZR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, ForumInfo forumInfo) {
        this.bZP = iVar;
        this.bZR = forumInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        i.a aVar;
        i.a aVar2;
        aVar = this.bZP.bZI;
        if (aVar != null) {
            aVar2 = this.bZP.bZI;
            aVar2.d(this.bZR.fromfid.longValue(), this.bZR.originalurl);
        }
    }
}
