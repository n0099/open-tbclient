package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bu implements a.b {
    final /* synthetic */ bo cNE;
    private final /* synthetic */ PbLotteryHttpResponseMessage cNF;
    private final /* synthetic */ String cfq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(bo boVar, PbLotteryHttpResponseMessage pbLotteryHttpResponseMessage, String str) {
        this.cNE = boVar;
        this.cNF = pbLotteryHttpResponseMessage;
        this.cfq = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        cm cmVar;
        PbActivity pbActivity3;
        cm cmVar2;
        PbActivity pbActivity4;
        cm cmVar3;
        PbActivity pbActivity5;
        cm cmVar4;
        aVar.dismiss();
        pbActivity = this.cNE.cNq;
        com.baidu.tbadk.browser.f.B(pbActivity.getActivity(), this.cNF.getLotteryInfo().getLink());
        pbActivity2 = this.cNE.cNq;
        cmVar = pbActivity2.cMF;
        if (cmVar != null) {
            pbActivity3 = this.cNE.cNq;
            cmVar2 = pbActivity3.cMF;
            if (cmVar2.getPbData() != null) {
                com.baidu.tbadk.core.util.au auVar = new com.baidu.tbadk.core.util.au("c10505");
                pbActivity4 = this.cNE.cNq;
                cmVar3 = pbActivity4.cMF;
                com.baidu.tbadk.core.util.au aa = auVar.aa(ImageViewerConfig.FORUM_ID, cmVar3.getPbData().getForumId());
                pbActivity5 = this.cNE.cNq;
                cmVar4 = pbActivity5.cMF;
                TiebaStatic.log(aa.aa("tid", cmVar4.getPbData().getThreadId()).aa("uid", this.cfq).aa("obj_locate", "1"));
            }
        }
    }
}
