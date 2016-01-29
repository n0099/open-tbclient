package com.baidu.tieba.pb.pb.a;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.b {
    final /* synthetic */ d cKp;
    private final /* synthetic */ String cfq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar, String str) {
        this.cKp = dVar;
        this.cfq = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.pb.a.c cVar;
        com.baidu.tieba.pb.a.c cVar2;
        com.baidu.tieba.pb.a.c cVar3;
        aVar.dismiss();
        cVar = this.cKp.cKn;
        if (cVar != null) {
            au auVar = new au("c10398");
            cVar2 = this.cKp.cKn;
            au aa = auVar.aa(ImageViewerConfig.FORUM_ID, cVar2.getForumId());
            cVar3 = this.cKp.cKn;
            TiebaStatic.log(aa.aa("tid", cVar3.getThreadId()).aa("uid", this.cfq).aa("is_like", "2"));
        }
    }
}
