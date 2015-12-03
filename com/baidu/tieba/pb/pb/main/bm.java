package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements a.b {
    private final /* synthetic */ String bWR;
    final /* synthetic */ be cCv;
    private final /* synthetic */ PbLotteryHttpResponseMessage cCw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(be beVar, PbLotteryHttpResponseMessage pbLotteryHttpResponseMessage, String str) {
        this.cCv = beVar;
        this.cCw = pbLotteryHttpResponseMessage;
        this.bWR = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        PbActivity pbActivity;
        cc ccVar;
        PbActivity pbActivity2;
        cc ccVar2;
        PbActivity pbActivity3;
        cc ccVar3;
        PbActivity pbActivity4;
        cc ccVar4;
        PbActivity pbActivity5;
        PbActivity pbActivity6;
        aVar.dismiss();
        if (this.cCw.getOrginalMessage() instanceof PbLotteryRequestMessage) {
            pbActivity5 = this.cCv.cCm;
            pbActivity5.showProgressBar(true, 0, 0);
            PbLotteryRequestMessage pbLotteryRequestMessage = (PbLotteryRequestMessage) this.cCw.getOrginalMessage();
            PbLotteryRequestMessage pbLotteryRequestMessage2 = new PbLotteryRequestMessage(TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountName(), pbLotteryRequestMessage.getForumId(), pbLotteryRequestMessage.getThreadId(), 1, pbLotteryRequestMessage.getActivityId(), pbLotteryRequestMessage.getAwardActId(), pbLotteryRequestMessage.getComponentId());
            pbActivity6 = this.cCv.cCm;
            pbActivity6.sendMessage(pbLotteryRequestMessage2);
        }
        pbActivity = this.cCv.cCm;
        ccVar = pbActivity.cBG;
        if (ccVar != null) {
            pbActivity2 = this.cCv.cCm;
            ccVar2 = pbActivity2.cBG;
            if (ccVar2.getPbData() != null) {
                com.baidu.tbadk.core.util.av avVar = new com.baidu.tbadk.core.util.av("c10398");
                pbActivity3 = this.cCv.cCm;
                ccVar3 = pbActivity3.cBG;
                com.baidu.tbadk.core.util.av ab = avVar.ab(ImageViewerConfig.FORUM_ID, ccVar3.getPbData().getForumId());
                pbActivity4 = this.cCv.cCm;
                ccVar4 = pbActivity4.cBG;
                TiebaStatic.log(ab.ab("tid", ccVar4.getPbData().getThreadId()).ab("uid", this.bWR).ab("is_like", "1"));
            }
        }
    }
}
