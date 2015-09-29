package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import com.baidu.tieba.pb.chosen.a.i;
import tbclient.FinePbPage.ForumInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ i cfO;
    private final /* synthetic */ ForumInfo cfQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, ForumInfo forumInfo) {
        this.cfO = iVar;
        this.cfQ = forumInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        i.a aVar;
        i.a aVar2;
        aVar = this.cfO.cfH;
        if (aVar != null) {
            aVar2 = this.cfO.cfH;
            aVar2.e(this.cfQ.fromfid.longValue(), this.cfQ.originalurl);
        }
    }
}
