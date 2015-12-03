package com.baidu.tieba.pb.pb.a;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements a.b {
    private final /* synthetic */ String bWR;
    final /* synthetic */ a czV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, String str) {
        this.czV = aVar;
        this.bWR = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.pb.a.c cVar;
        com.baidu.tieba.pb.a.c cVar2;
        com.baidu.tieba.pb.a.c cVar3;
        aVar.dismiss();
        cVar = this.czV.czO;
        if (cVar != null) {
            av avVar = new av("c10398");
            cVar2 = this.czV.czO;
            av ab = avVar.ab(ImageViewerConfig.FORUM_ID, cVar2.getForumId());
            cVar3 = this.czV.czO;
            TiebaStatic.log(ab.ab("tid", cVar3.getThreadId()).ab("uid", this.bWR).ab("is_like", "2"));
        }
    }
}
