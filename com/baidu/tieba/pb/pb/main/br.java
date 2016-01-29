package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements a.b {
    final /* synthetic */ bo cNE;
    private final /* synthetic */ String cfq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(bo boVar, String str) {
        this.cNE = boVar;
        this.cfq = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        PbActivity pbActivity;
        cm cmVar;
        PbActivity pbActivity2;
        cm cmVar2;
        PbActivity pbActivity3;
        cm cmVar3;
        PbActivity pbActivity4;
        cm cmVar4;
        aVar.dismiss();
        pbActivity = this.cNE.cNq;
        cmVar = pbActivity.cMF;
        if (cmVar != null) {
            pbActivity2 = this.cNE.cNq;
            cmVar2 = pbActivity2.cMF;
            if (cmVar2.getPbData() != null) {
                com.baidu.tbadk.core.util.au auVar = new com.baidu.tbadk.core.util.au("c10504");
                pbActivity3 = this.cNE.cNq;
                cmVar3 = pbActivity3.cMF;
                com.baidu.tbadk.core.util.au aa = auVar.aa(ImageViewerConfig.FORUM_ID, cmVar3.getPbData().getForumId());
                pbActivity4 = this.cNE.cNq;
                cmVar4 = pbActivity4.cMF;
                TiebaStatic.log(aa.aa("tid", cmVar4.getPbData().getThreadId()).aa("uid", this.cfq).aa("obj_locate", "2"));
            }
        }
    }
}
