package com.baidu.tieba.pb.pb.a;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.b {
    final /* synthetic */ g cDT;
    private final /* synthetic */ String caQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(g gVar, String str) {
        this.cDT = gVar;
        this.caQ = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.pb.a.c cVar;
        com.baidu.tieba.pb.a.c cVar2;
        com.baidu.tieba.pb.a.c cVar3;
        aVar.dismiss();
        cVar = this.cDT.cDR;
        if (cVar != null) {
            av avVar = new av("c10409");
            cVar2 = this.cDT.cDR;
            av aa = avVar.aa(ImageViewerConfig.FORUM_ID, cVar2.getForumId());
            cVar3 = this.cDT.cDR;
            TiebaStatic.log(aa.aa("tid", cVar3.getThreadId()).aa("uid", this.caQ).aa("is_like", "2"));
        }
    }
}
