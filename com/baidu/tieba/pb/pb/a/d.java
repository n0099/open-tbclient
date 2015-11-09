package com.baidu.tieba.pb.pb.a;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements a.b {
    final /* synthetic */ a chy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.chy = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.pb.a.c cVar;
        com.baidu.tieba.pb.a.c cVar2;
        com.baidu.tieba.pb.a.c cVar3;
        aVar.dismiss();
        cVar = this.chy.chr;
        if (cVar != null) {
            aq aqVar = new aq("c10398");
            cVar2 = this.chy.chr;
            aq ae = aqVar.ae(ImageViewerConfig.FORUM_ID, cVar2.getForumId());
            cVar3 = this.chy.chr;
            TiebaStatic.log(ae.ae("tid", cVar3.getThreadId()).ae("is_like", "2"));
        }
    }
}
