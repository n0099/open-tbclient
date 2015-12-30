package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp implements a.b {
    final /* synthetic */ bh cGg;
    private final /* synthetic */ PbLotteryHttpResponseMessage cGh;
    private final /* synthetic */ String caQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(bh bhVar, PbLotteryHttpResponseMessage pbLotteryHttpResponseMessage, String str) {
        this.cGg = bhVar;
        this.cGh = pbLotteryHttpResponseMessage;
        this.caQ = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        PbActivity pbActivity;
        cf cfVar;
        PbActivity pbActivity2;
        cf cfVar2;
        PbActivity pbActivity3;
        cf cfVar3;
        PbActivity pbActivity4;
        cf cfVar4;
        PbActivity pbActivity5;
        PbActivity pbActivity6;
        aVar.dismiss();
        if (this.cGh.getOrginalMessage() instanceof PbLotteryRequestMessage) {
            pbActivity5 = this.cGg.cFS;
            pbActivity5.showProgressBar(true, 0, 0);
            PbLotteryRequestMessage pbLotteryRequestMessage = (PbLotteryRequestMessage) this.cGh.getOrginalMessage();
            PbLotteryRequestMessage pbLotteryRequestMessage2 = new PbLotteryRequestMessage(TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountName(), pbLotteryRequestMessage.getForumId(), pbLotteryRequestMessage.getThreadId(), 1, pbLotteryRequestMessage.getActivityId(), pbLotteryRequestMessage.getAwardActId(), pbLotteryRequestMessage.getComponentId());
            pbActivity6 = this.cGg.cFS;
            pbActivity6.sendMessage(pbLotteryRequestMessage2);
        }
        pbActivity = this.cGg.cFS;
        cfVar = pbActivity.cFl;
        if (cfVar != null) {
            pbActivity2 = this.cGg.cFS;
            cfVar2 = pbActivity2.cFl;
            if (cfVar2.getPbData() != null) {
                com.baidu.tbadk.core.util.av avVar = new com.baidu.tbadk.core.util.av("c10398");
                pbActivity3 = this.cGg.cFS;
                cfVar3 = pbActivity3.cFl;
                com.baidu.tbadk.core.util.av aa = avVar.aa(ImageViewerConfig.FORUM_ID, cfVar3.getPbData().getForumId());
                pbActivity4 = this.cGg.cFS;
                cfVar4 = pbActivity4.cFl;
                TiebaStatic.log(aa.aa("tid", cfVar4.getPbData().getThreadId()).aa("uid", this.caQ).aa("is_like", "1"));
            }
        }
    }
}
