package com.baidu.tieba.pb.pb.a;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.tbadkCore.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements a.b {
    final /* synthetic */ g cDT;
    private final /* synthetic */ String caQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(g gVar, String str) {
        this.cDT = gVar;
        this.caQ = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.pb.a.c cVar;
        com.baidu.tieba.pb.a.c cVar2;
        x xVar;
        com.baidu.tieba.pb.a.c cVar3;
        com.baidu.tieba.pb.a.c cVar4;
        com.baidu.tieba.pb.a.c cVar5;
        com.baidu.tieba.pb.a.c cVar6;
        aVar.dismiss();
        cVar = this.cDT.cDR;
        if (cVar != null) {
            cVar2 = this.cDT.cDR;
            if (cVar2.akG() != null) {
                xVar = this.cDT.MB;
                cVar3 = this.cDT.cDR;
                String name = cVar3.akG().getName();
                cVar4 = this.cDT.cDR;
                xVar.bc(name, cVar4.akG().getId());
                av avVar = new av("c10409");
                cVar5 = this.cDT.cDR;
                av aa = avVar.aa(ImageViewerConfig.FORUM_ID, cVar5.getForumId());
                cVar6 = this.cDT.cDR;
                TiebaStatic.log(aa.aa("tid", cVar6.getThreadId()).aa("uid", this.caQ).aa("is_like", "1"));
            }
        }
    }
}
