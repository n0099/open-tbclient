package com.baidu.tieba.pb.pb.a;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements a.b {
    final /* synthetic */ j cKB;
    private final /* synthetic */ String cfq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(j jVar, String str) {
        this.cKB = jVar;
        this.cfq = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.pb.a.c cVar;
        com.baidu.tieba.pb.a.c cVar2;
        com.baidu.tieba.tbadkCore.w wVar;
        com.baidu.tieba.pb.a.c cVar3;
        com.baidu.tieba.pb.a.c cVar4;
        com.baidu.tieba.pb.a.c cVar5;
        com.baidu.tieba.pb.a.c cVar6;
        aVar.dismiss();
        cVar = this.cKB.cJZ;
        if (cVar != null) {
            cVar2 = this.cKB.cJZ;
            if (cVar2.aoE() != null) {
                wVar = this.cKB.MS;
                cVar3 = this.cKB.cJZ;
                String name = cVar3.aoE().getName();
                cVar4 = this.cKB.cJZ;
                wVar.bl(name, cVar4.aoE().getId());
                au auVar = new au("c10409");
                cVar5 = this.cKB.cJZ;
                au aa = auVar.aa(ImageViewerConfig.FORUM_ID, cVar5.getForumId());
                cVar6 = this.cKB.cJZ;
                TiebaStatic.log(aa.aa("tid", cVar6.getThreadId()).aa("uid", this.cfq).aa("is_like", "1"));
            }
        }
    }
}
