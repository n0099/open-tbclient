package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements a.b {
    final /* synthetic */ bc cjW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(bc bcVar) {
        this.cjW = bcVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        PbActivity pbActivity;
        ca caVar;
        PbActivity pbActivity2;
        ca caVar2;
        PbActivity pbActivity3;
        ca caVar3;
        PbActivity pbActivity4;
        ca caVar4;
        aVar.dismiss();
        pbActivity = this.cjW.cjN;
        caVar = pbActivity.cjj;
        if (caVar != null) {
            pbActivity2 = this.cjW.cjN;
            caVar2 = pbActivity2.cjj;
            if (caVar2.getPbData() != null) {
                com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c10398");
                pbActivity3 = this.cjW.cjN;
                caVar3 = pbActivity3.cjj;
                com.baidu.tbadk.core.util.aq ae = aqVar.ae(ImageViewerConfig.FORUM_ID, caVar3.getPbData().getForumId());
                pbActivity4 = this.cjW.cjN;
                caVar4 = pbActivity4.cjj;
                TiebaStatic.log(ae.ae("tid", caVar4.getPbData().getThreadId()).ae("is_like", "2"));
            }
        }
    }
}
