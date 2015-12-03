package com.baidu.tieba.pb.pb.a;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.b {
    private final /* synthetic */ String bWR;
    final /* synthetic */ g cAo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(g gVar, String str) {
        this.cAo = gVar;
        this.bWR = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.pb.a.c cVar;
        com.baidu.tieba.pb.a.c cVar2;
        com.baidu.tieba.pb.a.c cVar3;
        aVar.dismiss();
        cVar = this.cAo.cAm;
        if (cVar != null) {
            av avVar = new av("c10409");
            cVar2 = this.cAo.cAm;
            av ab = avVar.ab(ImageViewerConfig.FORUM_ID, cVar2.getForumId());
            cVar3 = this.cAo.cAm;
            TiebaStatic.log(ab.ab("tid", cVar3.getThreadId()).ab("uid", this.bWR).ab("is_like", "2"));
        }
    }
}
