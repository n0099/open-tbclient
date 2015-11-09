package com.baidu.tieba.pb.pb.a;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.b {
    final /* synthetic */ g chR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(g gVar) {
        this.chR = gVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.pb.a.c cVar;
        com.baidu.tieba.pb.a.c cVar2;
        com.baidu.tieba.pb.a.c cVar3;
        aVar.dismiss();
        cVar = this.chR.chP;
        if (cVar != null) {
            aq aqVar = new aq("c10409");
            cVar2 = this.chR.chP;
            aq ae = aqVar.ae(ImageViewerConfig.FORUM_ID, cVar2.getForumId());
            cVar3 = this.chR.chP;
            TiebaStatic.log(ae.ae("tid", cVar3.getThreadId()).ae("is_like", "2"));
        }
    }
}
