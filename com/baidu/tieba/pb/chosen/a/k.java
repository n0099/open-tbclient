package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import com.baidu.tieba.pb.chosen.a.i;
import tbclient.FinePbPage.ForumInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ i cfZ;
    private final /* synthetic */ ForumInfo cgb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, ForumInfo forumInfo) {
        this.cfZ = iVar;
        this.cgb = forumInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        i.a aVar;
        i.a aVar2;
        aVar = this.cfZ.cfS;
        if (aVar != null) {
            aVar2 = this.cfZ.cfS;
            aVar2.e(this.cgb.fromfid.longValue(), this.cgb.originalurl);
        }
    }
}
