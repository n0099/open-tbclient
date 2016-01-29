package com.baidu.tieba.pb.pb.a;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements a.b {
    final /* synthetic */ j cKB;
    private final /* synthetic */ String cfq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(j jVar, String str) {
        this.cKB = jVar;
        this.cfq = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.pb.a.c cVar;
        com.baidu.tieba.pb.a.c cVar2;
        com.baidu.tieba.pb.a.c cVar3;
        aVar.dismiss();
        cVar = this.cKB.cJZ;
        if (cVar != null) {
            au auVar = new au("c10409");
            cVar2 = this.cKB.cJZ;
            au aa = auVar.aa(ImageViewerConfig.FORUM_ID, cVar2.getForumId());
            cVar3 = this.cKB.cJZ;
            TiebaStatic.log(aa.aa("tid", cVar3.getThreadId()).aa("uid", this.cfq).aa("is_like", "2"));
        }
    }
}
