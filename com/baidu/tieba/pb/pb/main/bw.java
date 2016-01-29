package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw implements a.b {
    final /* synthetic */ bo cNE;
    private final /* synthetic */ PbLotteryHttpResponseMessage cNF;
    private final /* synthetic */ String cfq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(bo boVar, PbLotteryHttpResponseMessage pbLotteryHttpResponseMessage, String str) {
        this.cNE = boVar;
        this.cNF = pbLotteryHttpResponseMessage;
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
        PbActivity pbActivity5;
        PbActivity pbActivity6;
        aVar.dismiss();
        if (this.cNF.getOrginalMessage() instanceof PbLotteryRequestMessage) {
            pbActivity5 = this.cNE.cNq;
            pbActivity5.showProgressBar(true, 0, 0);
            PbLotteryRequestMessage pbLotteryRequestMessage = (PbLotteryRequestMessage) this.cNF.getOrginalMessage();
            PbLotteryRequestMessage pbLotteryRequestMessage2 = new PbLotteryRequestMessage(TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountName(), pbLotteryRequestMessage.getForumId(), pbLotteryRequestMessage.getThreadId(), 1, pbLotteryRequestMessage.getActivityId(), pbLotteryRequestMessage.getAwardActId(), pbLotteryRequestMessage.getComponentId());
            pbActivity6 = this.cNE.cNq;
            pbActivity6.sendMessage(pbLotteryRequestMessage2);
        }
        pbActivity = this.cNE.cNq;
        cmVar = pbActivity.cMF;
        if (cmVar != null) {
            pbActivity2 = this.cNE.cNq;
            cmVar2 = pbActivity2.cMF;
            if (cmVar2.getPbData() != null) {
                com.baidu.tbadk.core.util.au auVar = new com.baidu.tbadk.core.util.au("c10398");
                pbActivity3 = this.cNE.cNq;
                cmVar3 = pbActivity3.cMF;
                com.baidu.tbadk.core.util.au aa = auVar.aa(ImageViewerConfig.FORUM_ID, cmVar3.getPbData().getForumId());
                pbActivity4 = this.cNE.cNq;
                cmVar4 = pbActivity4.cMF;
                TiebaStatic.log(aa.aa("tid", cmVar4.getPbData().getThreadId()).aa("uid", this.cfq).aa("is_like", "1"));
            }
        }
    }
}
