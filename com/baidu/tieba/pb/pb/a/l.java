package com.baidu.tieba.pb.pb.a;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.tbadkCore.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements a.b {
    final /* synthetic */ g chR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(g gVar) {
        this.chR = gVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.pb.a.c cVar;
        com.baidu.tieba.pb.a.c cVar2;
        w wVar;
        com.baidu.tieba.pb.a.c cVar3;
        com.baidu.tieba.pb.a.c cVar4;
        com.baidu.tieba.pb.a.c cVar5;
        com.baidu.tieba.pb.a.c cVar6;
        aVar.dismiss();
        cVar = this.chR.chP;
        if (cVar != null) {
            cVar2 = this.chR.chP;
            if (cVar2.afg() != null) {
                wVar = this.chR.LU;
                cVar3 = this.chR.chP;
                String name = cVar3.afg().getName();
                cVar4 = this.chR.chP;
                wVar.bd(name, cVar4.afg().getId());
                aq aqVar = new aq("c10409");
                cVar5 = this.chR.chP;
                aq ae = aqVar.ae(ImageViewerConfig.FORUM_ID, cVar5.getForumId());
                cVar6 = this.chR.chP;
                TiebaStatic.log(ae.ae("tid", cVar6.getThreadId()).ae("is_like", "1"));
            }
        }
    }
}
