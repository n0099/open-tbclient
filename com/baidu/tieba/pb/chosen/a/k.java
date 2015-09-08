package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import com.baidu.tieba.pb.chosen.a.i;
import tbclient.FinePbPage.ForumInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ i caJ;
    private final /* synthetic */ ForumInfo caL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, ForumInfo forumInfo) {
        this.caJ = iVar;
        this.caL = forumInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        i.a aVar;
        i.a aVar2;
        aVar = this.caJ.caC;
        if (aVar != null) {
            aVar2 = this.caJ.caC;
            aVar2.d(this.caL.fromfid.longValue(), this.caL.originalurl);
        }
    }
}
