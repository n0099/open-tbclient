package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements a.b {
    final /* synthetic */ bc cjW;
    private final /* synthetic */ PbLotteryHttpResponseMessage cjX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(bc bcVar, PbLotteryHttpResponseMessage pbLotteryHttpResponseMessage) {
        this.cjW = bcVar;
        this.cjX = pbLotteryHttpResponseMessage;
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
        PbActivity pbActivity5;
        PbActivity pbActivity6;
        aVar.dismiss();
        if (this.cjX.getOrginalMessage() instanceof PbLotteryRequestMessage) {
            pbActivity5 = this.cjW.cjN;
            pbActivity5.showProgressBar(true, 0, 0);
            PbLotteryRequestMessage pbLotteryRequestMessage = (PbLotteryRequestMessage) this.cjX.getOrginalMessage();
            PbLotteryRequestMessage pbLotteryRequestMessage2 = new PbLotteryRequestMessage(TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountName(), pbLotteryRequestMessage.getForumId(), pbLotteryRequestMessage.getThreadId(), 1, pbLotteryRequestMessage.getActivityId(), pbLotteryRequestMessage.getAwardActId(), pbLotteryRequestMessage.getComponentId());
            pbActivity6 = this.cjW.cjN;
            pbActivity6.sendMessage(pbLotteryRequestMessage2);
        }
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
                TiebaStatic.log(ae.ae("tid", caVar4.getPbData().getThreadId()).ae("is_like", "1"));
            }
        }
    }
}
