package com.baidu.tieba.pb.pb.a;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.tbadkCore.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements a.b {
    private final /* synthetic */ String bWR;
    final /* synthetic */ g cAo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(g gVar, String str) {
        this.cAo = gVar;
        this.bWR = str;
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
        cVar = this.cAo.cAm;
        if (cVar != null) {
            cVar2 = this.cAo.cAm;
            if (cVar2.ajy() != null) {
                xVar = this.cAo.Ml;
                cVar3 = this.cAo.cAm;
                String name = cVar3.ajy().getName();
                cVar4 = this.cAo.cAm;
                xVar.bg(name, cVar4.ajy().getId());
                av avVar = new av("c10409");
                cVar5 = this.cAo.cAm;
                av ab = avVar.ab(ImageViewerConfig.FORUM_ID, cVar5.getForumId());
                cVar6 = this.cAo.cAm;
                TiebaStatic.log(ab.ab("tid", cVar6.getThreadId()).ab("uid", this.bWR).ab("is_like", "1"));
            }
        }
    }
}
